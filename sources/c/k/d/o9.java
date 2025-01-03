package c.k.d;

/* loaded from: classes.dex */
public class o9 {
    public static String a(String str, String str2) {
        try {
            return (String) q9.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("SystemProperties.get: " + e2);
            return str2;
        }
    }
}
