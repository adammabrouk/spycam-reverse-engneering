package c.k.c.a;

import android.content.Context;
import android.text.TextUtils;
import c.k.c.a.z0;

/* loaded from: classes.dex */
public class d0 {
    public static a a(Context context, s0 s0Var) {
        return b(context, s0Var);
    }

    public static a b(Context context, s0 s0Var) {
        z0.a m64a = z0.m64a(s0Var);
        if (m64a == null || TextUtils.isEmpty(m64a.f6942a) || TextUtils.isEmpty(m64a.f6943b)) {
            return null;
        }
        return (a) c.k.d.f0.a(m64a.f6942a, m64a.f6943b, context);
    }
}
