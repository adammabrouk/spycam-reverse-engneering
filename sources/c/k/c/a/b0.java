package c.k.c.a;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.b8;
import c.k.d.d8;
import c.k.d.e6;
import c.k.d.f8;
import c.k.d.h8;
import c.k.d.i8;
import c.k.d.l7;
import c.k.d.m7;
import c.k.d.n7;
import c.k.d.r7;
import c.k.d.s7;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.x7;
import c.k.d.y7;
import c.k.d.z7;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class b0 {
    public static i8 a(Context context, s7 s7Var) {
        byte[] m475a;
        if (s7Var.m477b()) {
            try {
                m475a = e6.a(c.k.d.h0.m185a(q0.m45a(context).d()), s7Var.m475a());
            } catch (Exception e2) {
                throw new i1("the aes decrypt failed.", e2);
            }
        } else {
            m475a = s7Var.m475a();
        }
        i8 a2 = a(s7Var.m469a(), s7Var.f99b);
        if (a2 != null) {
            h8.a(a2, m475a);
        }
        return a2;
    }

    public static i8 a(v6 v6Var, boolean z) {
        switch (c0.f6810a[v6Var.ordinal()]) {
            case 1:
                return new x7();
            case 2:
                return new d8();
            case 3:
                return new b8();
            case 4:
                return new f8();
            case 5:
                return new z7();
            case 6:
                return new m7();
            case 7:
                return new r7();
            case 8:
                return new y7();
            case 9:
                if (z) {
                    return new v7();
                }
                n7 n7Var = new n7();
                n7Var.a(true);
                return n7Var;
            case 10:
                return new r7();
            default:
                return null;
        }
    }

    public static <T extends i8<T, ?>> s7 a(Context context, T t, v6 v6Var) {
        return a(context, t, v6Var, !v6Var.equals(v6.Registration), context.getPackageName(), q0.m45a(context).m46a());
    }

    public static <T extends i8<T, ?>> s7 a(Context context, T t, v6 v6Var, boolean z, String str, String str2) {
        String str3;
        byte[] a2 = h8.a(t);
        if (a2 != null) {
            s7 s7Var = new s7();
            if (z) {
                String d2 = q0.m45a(context).d();
                if (TextUtils.isEmpty(d2)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a2 = e6.b(c.k.d.h0.m185a(d2), a2);
                    } catch (Exception unused) {
                        c.k.a.a.a.c.d("encryption error. ");
                    }
                }
            }
            l7 l7Var = new l7();
            l7Var.f7357a = 5L;
            l7Var.f55a = "fakeid";
            s7Var.a(l7Var);
            s7Var.a(ByteBuffer.wrap(a2));
            s7Var.a(v6Var);
            s7Var.b(true);
            s7Var.b(str);
            s7Var.a(z);
            s7Var.a(str2);
            return s7Var;
        }
        str3 = "invoke convertThriftObjectToBytes method, return null.";
        c.k.a.a.a.c.m6a(str3);
        return null;
    }
}
