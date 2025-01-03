package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class j7 {
    public static String a(String str, String[] strArr, String[] strArr2) {
        c.c.a.b.c.o.r.a(strArr);
        c.c.a.b.c.o.r.a(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i2 = 0; i2 < min; i2++) {
            String str2 = strArr[i2];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i2];
            }
        }
        return null;
    }
}
