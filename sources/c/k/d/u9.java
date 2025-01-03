package c.k.d;

import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public class u9 {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f7939a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f7939a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        f7939a.put("89504E47", "png");
        f7939a.put("47494638", "gif");
        f7939a.put("474946", "gif");
        f7939a.put("424D", "bmp");
    }

    public static long a(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                j += listFiles[i2].isDirectory() ? a(listFiles[i2]) : listFiles[i2].length();
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
        return j;
    }
}
