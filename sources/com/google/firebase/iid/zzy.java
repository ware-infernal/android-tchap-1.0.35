package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.firebase_messaging.zzg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;
import kotlin.jvm.internal.LongCompanionObject;

final class zzy {
    zzy() {
    }

    /* access modifiers changed from: 0000 */
    public final zzz zzb(Context context, String str) throws zzaa {
        zzz zzd = zzd(context, str);
        if (zzd != null) {
            return zzd;
        }
        return zzc(context, str);
    }

    /* access modifiers changed from: 0000 */
    public final zzz zzc(Context context, String str) {
        zzz zzz = new zzz(zza.zzc(), System.currentTimeMillis());
        zzz zza = zza(context, str, zzz, true);
        String str2 = "FirebaseInstanceId";
        if (zza == null || zza.equals(zzz)) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Generated new key");
            }
            zza(context, str, zzz);
            return zzz;
        }
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Loaded key after generating new one, using loaded one");
        }
        return zza;
    }

    static void zza(Context context) {
        File[] listFiles;
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final zzz zzd(Context context, String str) throws zzaa {
        try {
            zzz zze = zze(context, str);
            if (zze != null) {
                zza(context, str, zze);
                return zze;
            }
            e = null;
            try {
                zzz zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza, false);
                    return zza;
                }
            } catch (zzaa e) {
                e = e;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (zzaa e2) {
            e = e2;
        }
    }

    private static KeyPair zzc(String str, String str2) throws zzaa {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzaa((Exception) e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzaa((Exception) e2);
        }
    }

    private final zzz zze(Context context, String str) throws zzaa {
        File zzf = zzf(context, str);
        if (!zzf.exists()) {
            return null;
        }
        try {
            return zza(zzf);
        } catch (zzaa | IOException e) {
            String str2 = "FirebaseInstanceId";
            if (Log.isLoggable(str2, 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d(str2, sb.toString());
            }
            try {
                return zza(zzf);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w(str2, sb2.toString());
                throw new zzaa((Exception) e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a4, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a5, code lost:
        if (r9 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        zza(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00aa, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ad, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        zza(r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b1, code lost:
        throw r11;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0060=Splitter:B:19:0x0060, B:31:0x009e=Splitter:B:31:0x009e} */
    private final zzz zza(Context context, String str, zzz zzz, boolean z) {
        String str2 = "FirebaseInstanceId";
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Writing key to properties file");
        }
        Properties properties = new Properties();
        properties.setProperty("pub", zzz.zzv());
        properties.setProperty("pri", zzz.zzw());
        properties.setProperty("cre", String.valueOf(zzz.zzbt));
        File zzf = zzf(context, str);
        try {
            zzf.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(zzf, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            channel.lock();
            if (z && channel.size() > 0) {
                try {
                    channel.position(0);
                    zzz zza = zza(channel);
                    if (channel != null) {
                        zza((Throwable) null, channel);
                    }
                    zza((Throwable) null, randomAccessFile);
                    return zza;
                } catch (zzaa | IOException e) {
                    if (Log.isLoggable(str2, 3)) {
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 64);
                        sb.append("Tried reading key pair before writing new one, but failed with: ");
                        sb.append(valueOf);
                        Log.d(str2, sb.toString());
                    }
                }
            }
            channel.position(0);
            properties.store(Channels.newOutputStream(channel), null);
            if (channel != null) {
                zza((Throwable) null, channel);
            }
            zza((Throwable) null, randomAccessFile);
            return zzz;
        } catch (IOException e2) {
            String valueOf2 = String.valueOf(e2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
            sb2.append("Failed to write key: ");
            sb2.append(valueOf2);
            Log.w(str2, sb2.toString());
            return null;
        }
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File zzf(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r8 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        zza(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002f, code lost:
        zza(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        throw r1;
     */
    private final zzz zza(File file) throws zzaa, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        channel.lock(0, LongCompanionObject.MAX_VALUE, true);
        zzz zza = zza(channel);
        if (channel != null) {
            zza((Throwable) null, channel);
        }
        zza((Throwable) null, fileInputStream);
        return zza;
    }

    private static zzz zza(FileChannel fileChannel) throws zzaa, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property == null || property2 == null) {
            throw new zzaa("Invalid properties file");
        }
        try {
            return new zzz(zzc(property, property2), Long.parseLong(properties.getProperty("cre")));
        } catch (NumberFormatException e) {
            throw new zzaa((Exception) e);
        }
    }

    private static zzz zza(SharedPreferences sharedPreferences, String str) throws zzaa {
        String string = sharedPreferences.getString(zzaw.zzd(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzaw.zzd(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzz(zzc(string, string2), zzb(sharedPreferences, str));
    }

    private final void zza(Context context, String str, zzz zzz) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzz.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzaa unused) {
        }
        String str2 = "FirebaseInstanceId";
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Writing key to shared preferences");
        }
        Editor edit = sharedPreferences.edit();
        edit.putString(zzaw.zzd(str, "|P|"), zzz.zzv());
        edit.putString(zzaw.zzd(str, "|K|"), zzz.zzw());
        edit.putString(zzaw.zzd(str, "cre"), String.valueOf(zzz.zzbt));
        edit.commit();
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzaw.zzd(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    private static /* synthetic */ void zza(Throwable th, FileChannel fileChannel) {
        if (th != null) {
            try {
                fileChannel.close();
            } catch (Throwable th2) {
                zzg.zza(th, th2);
            }
        } else {
            fileChannel.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, RandomAccessFile randomAccessFile) {
        if (th != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                zzg.zza(th, th2);
            }
        } else {
            randomAccessFile.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzg.zza(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }
}
