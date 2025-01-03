package c.k.d;

import android.content.Context;
import c.k.d.p8;
import c.k.d.z8;

/* loaded from: classes.dex */
public class h8 {
    public static short a(Context context, s7 s7Var) {
        return (short) (d5.a(context, s7Var.f7851b, false).a() + 0 + (i.b(context) ? 4 : 0) + (i.a(context) ? 8 : 0));
    }

    public static <T extends i8<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new n8("the message byte is empty.");
        }
        new m8(new z8.a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends i8<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new o8(new p8.a()).a(t);
        } catch (n8 e2) {
            c.k.a.a.a.c.a("convertThriftObjectToBytes catch TException.", e2);
            return null;
        }
    }
}
