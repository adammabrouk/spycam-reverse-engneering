package c.j.a.h;

import android.content.Context;

/* compiled from: PushSecurityManager.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    public static volatile d f6548d;

    /* renamed from: a, reason: collision with root package name */
    public b f6549a;

    /* renamed from: b, reason: collision with root package name */
    public c f6550b;

    /* renamed from: c, reason: collision with root package name */
    public Context f6551c;

    public d(Context context) {
        if (this.f6549a == null) {
            this.f6551c = c.j.a.z.c.c(context.getApplicationContext());
            this.f6549a = new e(this.f6551c);
        }
        if (this.f6550b == null) {
            this.f6550b = new a();
        }
    }

    public static d a(Context context) {
        if (f6548d == null) {
            synchronized (d.class) {
                if (f6548d == null && context != null) {
                    f6548d = new d(context);
                }
            }
        }
        return f6548d;
    }

    public final b a() {
        return this.f6549a;
    }
}
