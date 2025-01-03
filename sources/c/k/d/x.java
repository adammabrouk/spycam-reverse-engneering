package c.k.d;

import android.content.Context;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public static int f7996a;

    public static s a(Context context) {
        if (w.a(context)) {
            f7996a = 1;
            return new w(context);
        }
        if (q.m413a(context)) {
            f7996a = 2;
            return new q(context);
        }
        if (v.a(context)) {
            f7996a = 3;
            return new t(context);
        }
        f7996a = 0;
        return new z();
    }
}
