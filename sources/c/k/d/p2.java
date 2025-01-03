package c.k.d;

import android.content.Context;

/* loaded from: classes.dex */
public class p2 {
    public static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        return c.k.d.p9.m.a(context).a(a7.DCJobMutualSwitch.a(), false) && !h.a(context, str, j);
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] m185a = h0.m185a(str);
        try {
            a(m185a);
            return e6.a(m185a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m185a = h0.m185a(str);
        try {
            a(m185a);
            return e6.b(m185a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
