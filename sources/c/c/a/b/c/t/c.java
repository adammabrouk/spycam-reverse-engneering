package c.c.a.b.c.t;

import android.content.Context;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static c f4032b = new c();

    /* renamed from: a, reason: collision with root package name */
    public b f4033a = null;

    public static b b(Context context) {
        return f4032b.a(context);
    }

    public final synchronized b a(Context context) {
        if (this.f4033a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f4033a = new b(context);
        }
        return this.f4033a;
    }
}
