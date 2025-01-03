package cn.jpush.android.af;

import android.content.Context;
import cn.jpush.android.bm.k;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class b {
    public static File a(Context context, String str) {
        File filesDir;
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            return new File(filesDir, str);
        }
        cn.jpush.android.r.b.f("FileUtils", "can't get file :" + str);
        return null;
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static boolean a(File file, String str) {
        byte[] bytes;
        if (str != null) {
            try {
                bytes = str.getBytes("UTF-8");
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("FileUtils", "getBytes exception:" + th);
                return false;
            }
        } else {
            bytes = null;
        }
        return a(file, bytes);
    }

    public static boolean a(File file, byte[] bArr) {
        if (file == null || file.isDirectory()) {
            cn.jpush.android.r.b.f("FileUtils", "file should not be null or a directory");
            return false;
        }
        FileOutputStream fileOutputStream = null;
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th) {
                th = th;
                try {
                    cn.jpush.android.r.b.f("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
                    return false;
                } finally {
                    k.a(fileOutputStream);
                }
            }
        }
        a(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        try {
            fileOutputStream2.write(bArr);
            k.a(fileOutputStream2);
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
            cn.jpush.android.r.b.f("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
            return false;
        }
    }
}
