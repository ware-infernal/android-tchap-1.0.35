package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.ProviderResourceEntry;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.FontsContractCompat.FontInfo;
import org.apache.commons.cli.HelpFormatter;

public class TypefaceCompat {
    private static final String TAG = "TypefaceCompat";
    private static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        if (VERSION.SDK_INT >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (VERSION.SDK_INT >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.isUsable()) {
            sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
        } else if (VERSION.SDK_INT >= 21) {
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        } else {
            sTypefaceCompatImpl = new TypefaceCompatBaseImpl();
        }
    }

    private TypefaceCompat() {
    }

    public static Typeface findFromCache(Resources resources, int i, int i2) {
        return (Typeface) sTypefaceCache.get(createResourceUid(resources, i, i2));
    }

    private static String createResourceUid(Resources resources, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(resources.getResourcePackageName(i));
        String str = HelpFormatter.DEFAULT_OPT_PREFIX;
        sb.append(str);
        sb.append(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FamilyResourceEntry familyResourceEntry, Resources resources, int i, int i2, FontCallback fontCallback, Handler handler, boolean z) {
        Typeface typeface;
        if (familyResourceEntry instanceof ProviderResourceEntry) {
            ProviderResourceEntry providerResourceEntry = (ProviderResourceEntry) familyResourceEntry;
            boolean z2 = false;
            if (!z ? fontCallback == null : providerResourceEntry.getFetchStrategy() == 0) {
                z2 = true;
            }
            typeface = FontsContractCompat.getFontSync(context, providerResourceEntry.getRequest(), fontCallback, handler, z2, z ? providerResourceEntry.getTimeout() : -1, i2);
        } else {
            typeface = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontFamilyFilesResourceEntry) familyResourceEntry, resources, i2);
            if (fontCallback != null) {
                if (typeface != null) {
                    fontCallback.callbackSuccessAsync(typeface, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typeface != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, str, i2);
        if (createFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr, int i) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
    }
}
