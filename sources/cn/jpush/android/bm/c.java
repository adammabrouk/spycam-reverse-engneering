package cn.jpush.android.bm;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class c {
    public static File a(Context context, String str) {
        File filesDir;
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            return new File(filesDir, str);
        }
        Logger.w("FileUtils", "can't get file :" + str);
        return null;
    }

    public static Object a(File file) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object readObject = objectInputStream.readObject();
            k.a((Closeable) objectInputStream);
            return readObject;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            k.a((Closeable) objectInputStream2);
            throw th;
        }
    }

    public static String a(Context context, String str, int i2) {
        return a(context, str, i2, true);
    }

    public static String a(Context context, String str, int i2, boolean z) {
        if (context == null) {
            return null;
        }
        try {
            a.a();
            String b2 = b(context, str + File.separator);
            if (z) {
                a(context, str, i2, (File) null);
            }
            return b2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(Context context, String str, int i2, File file) {
        File[] listFiles;
        if (file == null) {
            file = a(context, str);
        }
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > i2) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: cn.jpush.android.bm.c.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(File file2, File file3) {
                    if (file2.lastModified() > file3.lastModified()) {
                        return -1;
                    }
                    return file2.lastModified() < file3.lastModified() ? 1 : 0;
                }
            });
            c(listFiles[listFiles.length - 1]);
        }
    }

    public static boolean a(File file, Object obj) {
        ObjectOutputStream objectOutputStream;
        if (file == null || file.isDirectory()) {
            Logger.w("FileUtils", "file should not be null or a directory");
            return false;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            b(file);
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            k.a(objectOutputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            try {
                Logger.w("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
                return false;
            } finally {
                k.a(objectOutputStream2);
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Throwable th) {
            Logger.w("FileUtils", "FileUtils e:" + th);
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        byte[] bytes;
        if (str2 != null) {
            try {
                bytes = str2.getBytes("UTF-8");
            } catch (Exception e2) {
                Logger.w("FileUtils", "getBytes exception:" + e2);
                return false;
            }
        } else {
            bytes = null;
        }
        return b(str, bytes);
    }

    public static boolean a(String str, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return b(str, bArr);
    }

    public static String b(Context context, String str) {
        try {
            File a2 = a(context, str);
            if (a2 == null) {
                Logger.w("FileUtils", str + " can't be null");
                return "";
            }
            if (a2.isFile()) {
                a2.delete();
            }
            if (!a2.exists()) {
                a2.mkdirs();
            }
            return a2.getAbsolutePath() + File.separator;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
        }
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static void b(File file) {
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

    public static boolean b(String str, String str2) {
        Logger.v("FileUtils", "action:createHtmlFile - filePath:" + str + ", content:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return a(str, str2);
    }

    public static boolean b(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                b(file);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    k.a(fileOutputStream2);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    Logger.w("FileUtils", "save to file exception:" + e + " path = " + str);
                    k.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    k.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static String c(Context context, String str) {
        try {
            a.a();
            a(context, "rich", 10, (File) null);
            return b(context, "rich" + File.separator + str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean c(File file) {
        try {
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return file.delete();
            }
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    File file2 = new File(file, str);
                    if (file2.isDirectory()) {
                        c(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            return file.delete();
        } catch (Exception unused) {
            Logger.e("FileUtils", "Delete dir error");
            return false;
        }
    }

    public static String d(Context context, String str) {
        try {
            a.a();
            String str2 = context.getFilesDir().getAbsolutePath() + File.separator + str;
            if (new File(str2).exists()) {
                return str2;
            }
            Logger.ww("FileUtils", "Can't find developer picture resource in SDCard.");
            return "";
        } catch (Throwable th) {
            Logger.ww("FileUtils", "Get developer picture resource failed." + th);
            return "";
        }
    }
}
