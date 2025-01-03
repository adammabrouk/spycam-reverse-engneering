package c.k.c.a;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.v9;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class h1 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile h1 f6834b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f6835c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Context f6836a;

    public h1(Context context) {
        this.f6836a = context;
    }

    public static h1 a(Context context) {
        if (f6834b == null) {
            synchronized (h1.class) {
                if (f6834b == null) {
                    f6834b = new h1(context);
                }
            }
        }
        return f6834b;
    }

    public final File a(String str) {
        File file = new File(this.f6836a.getFilesDir() + "/crash");
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        File[] listFiles = file.listFiles();
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2].isFile() && listFiles[i2].getName().startsWith(str)) {
                return listFiles[i2];
            }
        }
        return null;
    }

    public String a(File file) {
        if (file == null) {
            return "";
        }
        String[] split = file.getName().split(":");
        return split.length != 2 ? "" : split[0];
    }

    public ArrayList<File> a() {
        ArrayList<File> arrayList = new ArrayList<>();
        File file = new File(this.f6836a.getFilesDir() + "/crash");
        if (!file.exists()) {
            file.mkdirs();
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            String[] split = listFiles[i2].getName().split(":");
            if (split.length >= 2 && Integer.parseInt(split[1]) >= 1 && listFiles[i2].isFile()) {
                arrayList.add(listFiles[i2]);
            }
        }
        return arrayList;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f6835c) {
            File a2 = a(str2);
            if (a2 != null) {
                String[] split = a2.getName().split(":");
                if (split.length < 2) {
                    return;
                }
                a2.renameTo(new File(this.f6836a.getFilesDir() + "/crash/" + str2 + ":" + String.valueOf(Integer.parseInt(split[1]) + 1)));
            } else {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(this.f6836a.getFilesDir() + "/crash/" + str2 + ":1"));
                        try {
                            fileOutputStream2.write(str.getBytes());
                            fileOutputStream2.flush();
                            v9.a(fileOutputStream2);
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            c.k.a.a.a.c.a(e);
                            v9.a(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            v9.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        }
    }
}
