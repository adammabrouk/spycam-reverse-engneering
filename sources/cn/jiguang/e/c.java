package cn.jiguang.e;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class c {

    public static class a implements FileFilter {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8866a = new a(true, false);

        /* renamed from: b, reason: collision with root package name */
        public static final a f8867b = new a(false, true);

        /* renamed from: c, reason: collision with root package name */
        public final boolean f8868c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f8869d;

        /* renamed from: e, reason: collision with root package name */
        public final String f8870e;

        /* renamed from: f, reason: collision with root package name */
        public final int f8871f;

        public a(boolean z, boolean z2) {
            this.f8868c = z;
            this.f8869d = z2;
            this.f8870e = null;
            this.f8871f = 0;
        }

        public a(boolean z, boolean z2, String str, int i2) {
            this.f8870e = str;
            this.f8871f = i2;
            this.f8868c = z;
            this.f8869d = z2;
        }

        public static a a(String str) {
            return new a(false, true, str, 3);
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (this.f8868c && !file.isFile()) {
                return false;
            }
            if (this.f8869d && !file.isDirectory()) {
                return false;
            }
            if (TextUtils.isEmpty(this.f8870e)) {
                return true;
            }
            int i2 = this.f8871f;
            if (i2 == 1) {
                return file.getName().startsWith(this.f8870e);
            }
            if (i2 == 2) {
                return file.getName().endsWith(this.f8870e);
            }
            if (i2 == 3) {
                return file.getName().equals(this.f8870e);
            }
            if (i2 != 4) {
                return false;
            }
            return file.getName().contains(this.f8870e);
        }
    }

    public static File a(Context context, String str) {
        File filesDir;
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            return new File(filesDir, str);
        }
        cn.jiguang.as.d.g("FileUtils", "can't get file :" + str);
        return null;
    }

    public static File a(File[] fileArr) {
        File file = null;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                if (file2.lastModified() > (file != null ? file.lastModified() : 0L)) {
                    file = file2;
                }
            }
        }
        return file;
    }

    public static void a(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                    cn.jiguang.as.d.c("FileUtils", "delete File:" + file.getPath());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return b(a(context, str), str2);
    }

    public static boolean a(File file, String str) {
        String str2;
        FileWriter fileWriter;
        if (file == null || file.isDirectory()) {
            str2 = "file should not be null or a directory";
        } else {
            if (!TextUtils.isEmpty(str)) {
                FileWriter fileWriter2 = null;
                try {
                    b(file);
                    fileWriter = new FileWriter(file, true);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileWriter.write(str);
                    h.a(fileWriter);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter2 = fileWriter;
                    try {
                        cn.jiguang.as.d.g("FileUtils", "append to file exception:" + th + " path = " + file.getAbsolutePath());
                        return false;
                    } finally {
                        h.a(fileWriter2);
                    }
                }
            }
            str2 = "append data should not be empty";
        }
        cn.jiguang.as.d.g("FileUtils", str2);
        return false;
    }

    public static boolean a(File file, byte[] bArr) {
        if (file == null || file.isDirectory()) {
            cn.jiguang.as.d.g("FileUtils", "file should not be null or a directory");
            return false;
        }
        FileOutputStream fileOutputStream = null;
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th) {
                th = th;
                try {
                    cn.jiguang.as.d.g("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
                    return false;
                } finally {
                    h.a(fileOutputStream);
                }
            }
        }
        b(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        try {
            fileOutputStream2.write(bArr);
            h.a(fileOutputStream2);
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
            cn.jiguang.as.d.g("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            char[] charArray = str.toCharArray();
            char[] cArr = new char[10];
            if (charArray.length <= 10) {
                return false;
            }
            for (int i2 = 0; i2 < 10; i2++) {
                cArr[i2] = (char) (charArray[i2] ^ 2000);
            }
            return "j-c-o-r-e-".equals(new String(cArr));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static File[] a(File file, FileFilter... fileFilterArr) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return null;
        }
        if (fileFilterArr == null || fileFilterArr.length == 0 || (fileFilterArr.length == 1 && fileFilterArr[0] == null)) {
            return file.listFiles();
        }
        if (fileFilterArr.length == 1) {
            return file.listFiles(fileFilterArr[0]);
        }
        LinkedList<File> linkedList = new LinkedList();
        linkedList.add(file);
        int length = fileFilterArr.length;
        int i2 = 0;
        while (i2 < length) {
            FileFilter fileFilter = fileFilterArr[i2];
            LinkedList linkedList2 = new LinkedList();
            for (File file2 : linkedList) {
                File[] listFiles = fileFilter != null ? file2.listFiles(fileFilter) : file2.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    Collections.addAll(linkedList2, listFiles);
                }
            }
            if (linkedList2.isEmpty()) {
                return null;
            }
            i2++;
            linkedList = linkedList2;
        }
        return (File[]) linkedList.toArray(new File[0]);
    }

    public static File[] a(String str, FileFilter... fileFilterArr) {
        try {
            return a(new File(str), fileFilterArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            char[] charArray = str.toCharArray();
            for (int i2 = 0; i2 < charArray.length; i2++) {
                charArray[i2] = (char) (charArray[i2] ^ 2000);
            }
            return new String(charArray);
        } catch (Throwable unused) {
            return str;
        }
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

    public static boolean b(File file, String str) {
        String str2;
        if (file == null || file.isDirectory()) {
            str2 = "file should not be null or a directory";
        } else if (TextUtils.isEmpty(str)) {
            str2 = "append data should not be empty";
        } else {
            FileWriter fileWriter = null;
            try {
                b(file);
                String str3 = new String(c(file));
                if (a(str3)) {
                    FileWriter fileWriter2 = new FileWriter(file, true);
                    try {
                        fileWriter2.write(b(str));
                        fileWriter = fileWriter2;
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        try {
                            cn.jiguang.as.d.g("FileUtils", "append to file exception:" + th + " path = " + file.getAbsolutePath());
                            return false;
                        } finally {
                            h.a(fileWriter);
                        }
                    }
                } else {
                    String path = file.getPath();
                    file.delete();
                    File file2 = new File(path);
                    try {
                        b(file2);
                        c(file2, str3 + str);
                    } catch (Throwable th2) {
                        th = th2;
                        file = file2;
                        cn.jiguang.as.d.g("FileUtils", "append to file exception:" + th + " path = " + file.getAbsolutePath());
                        return false;
                    }
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        cn.jiguang.as.d.g("FileUtils", str2);
        return false;
    }

    public static String c(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(0, "j-c-o-r-e-");
            return b(sb.toString());
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean c(File file, String str) {
        byte[] bytes;
        if (str != null) {
            try {
                bytes = c(str).getBytes("UTF-8");
            } catch (Throwable th) {
                cn.jiguang.as.d.g("FileUtils", "getBytes exception:" + th);
                return false;
            }
        } else {
            bytes = null;
        }
        return a(file, bytes);
    }

    public static byte[] c(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            return h.a((InputStream) fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            try {
                cn.jiguang.as.d.c("FileUtils", "can't read, give up read. e:" + th);
                return null;
            } finally {
                h.a((Closeable) fileInputStream);
            }
        }
    }

    public static String d(File file) {
        byte[] c2 = c(file);
        if (c2 == null) {
            return null;
        }
        try {
            return d(new String(c2, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            cn.jiguang.as.d.c("FileUtils", "can't encoding, give up read :" + e2);
            return null;
        }
    }

    public static String d(String str) {
        try {
            return (!TextUtils.isEmpty(str) && a(str)) ? b(str.substring(10)) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void e(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                e(file2);
                file2.delete();
            }
        }
        file.delete();
    }
}
