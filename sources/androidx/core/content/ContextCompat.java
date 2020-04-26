package androidx.core.content;

import android.accessibilityservice.AccessibilityService;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.util.HashMap;
import org.matrix.androidsdk.rest.model.login.PasswordLoginParams;

public class ContextCompat {
    private static final String TAG = "ContextCompat";
    private static final Object sLock = new Object();
    private static TypedValue sTempValue;

    private static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = new HashMap<>();

        private LegacyServiceMapHolder() {
        }

        static {
            if (VERSION.SDK_INT > 22) {
                SERVICES.put(SubscriptionManager.class, "telephony_subscription_service");
                SERVICES.put(UsageStatsManager.class, "usagestats");
            }
            if (VERSION.SDK_INT > 21) {
                SERVICES.put(AppWidgetManager.class, "appwidget");
                SERVICES.put(BatteryManager.class, "batterymanager");
                SERVICES.put(CameraManager.class, "camera");
                SERVICES.put(JobScheduler.class, "jobscheduler");
                SERVICES.put(LauncherApps.class, "launcherapps");
                SERVICES.put(MediaProjectionManager.class, "media_projection");
                SERVICES.put(MediaSessionManager.class, "media_session");
                SERVICES.put(RestrictionsManager.class, "restrictions");
                SERVICES.put(TelecomManager.class, "telecom");
                SERVICES.put(TvInputManager.class, "tv_input");
            }
            if (VERSION.SDK_INT > 19) {
                SERVICES.put(AppOpsManager.class, "appops");
                SERVICES.put(CaptioningManager.class, "captioning");
                SERVICES.put(ConsumerIrManager.class, "consumer_ir");
                SERVICES.put(PrintManager.class, "print");
            }
            if (VERSION.SDK_INT > 18) {
                SERVICES.put(BluetoothManager.class, "bluetooth");
            }
            if (VERSION.SDK_INT > 17) {
                SERVICES.put(DisplayManager.class, "display");
                SERVICES.put(UserManager.class, PasswordLoginParams.IDENTIFIER_KEY_USER);
            }
            if (VERSION.SDK_INT > 16) {
                SERVICES.put(InputManager.class, "input");
                SERVICES.put(MediaRouter.class, "media_router");
                SERVICES.put(NsdManager.class, "servicediscovery");
            }
            SERVICES.put(AccessibilityService.class, "accessibility");
            SERVICES.put(AccountManager.class, "account");
            SERVICES.put(ActivityManager.class, "activity");
            SERVICES.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            SERVICES.put(AudioManager.class, "audio");
            SERVICES.put(ClipboardManager.class, "clipboard");
            SERVICES.put(ConnectivityManager.class, "connectivity");
            SERVICES.put(DevicePolicyManager.class, "device_policy");
            SERVICES.put(DownloadManager.class, "download");
            SERVICES.put(DropBoxManager.class, "dropbox");
            SERVICES.put(InputMethodManager.class, "input_method");
            SERVICES.put(KeyguardManager.class, "keyguard");
            SERVICES.put(LayoutInflater.class, "layout_inflater");
            SERVICES.put(LocationManager.class, "location");
            SERVICES.put(NfcManager.class, "nfc");
            SERVICES.put(NotificationManager.class, "notification");
            SERVICES.put(PowerManager.class, "power");
            SERVICES.put(SearchManager.class, "search");
            SERVICES.put(SensorManager.class, "sensor");
            SERVICES.put(StorageManager.class, "storage");
            SERVICES.put(TelephonyManager.class, "phone");
            SERVICES.put(TextServicesManager.class, "textservices");
            SERVICES.put(UiModeManager.class, "uimode");
            SERVICES.put(UsbManager.class, "usb");
            SERVICES.put(Vibrator.class, "vibrator");
            SERVICES.put(WallpaperManager.class, "wallpaper");
            SERVICES.put(WifiP2pManager.class, "wifip2p");
            SERVICES.put(WifiManager.class, "wifi");
            SERVICES.put(WindowManager.class, "window");
        }
    }

    protected ContextCompat() {
    }

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
        } else {
            context.startActivities(intentArr);
        }
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static File getDataDir(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.getDataDir();
        }
        String str = context.getApplicationInfo().dataDir;
        return str != null ? new File(str) : null;
    }

    public static File[] getObbDirs(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getObbDirs();
        }
        return new File[]{context.getObbDir()};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    public static File[] getExternalCacheDirs(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (file == null) {
                file = new File(str);
            } else if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static Drawable getDrawable(Context context, int i) {
        int i2;
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (sLock) {
            if (sTempValue == null) {
                sTempValue = new TypedValue();
            }
            context.getResources().getValue(i, sTempValue, true);
            i2 = sTempValue.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static int getColor(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static File getNoBackupFilesDir(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static File getCodeCacheDir(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return context.getCodeCacheDir();
        }
        return createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        return r4;
     */
    private static synchronized File createFilesDir(File file) {
        synchronized (ContextCompat.class) {
            if (!file.exists() && !file.mkdirs()) {
                if (file.exists()) {
                    return file;
                }
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to create files subdir ");
                sb.append(file.getPath());
                Log.w(str, sb.toString());
                return null;
            }
        }
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static <T> T getSystemService(Context context, Class<T> cls) {
        if (VERSION.SDK_INT >= 23) {
            return context.getSystemService(cls);
        }
        String systemServiceName = getSystemServiceName(context, cls);
        return systemServiceName != null ? context.getSystemService(systemServiceName) : null;
    }

    public static String getSystemServiceName(Context context, Class<?> cls) {
        if (VERSION.SDK_INT >= 23) {
            return context.getSystemServiceName(cls);
        }
        return (String) LegacyServiceMapHolder.SERVICES.get(cls);
    }
}
