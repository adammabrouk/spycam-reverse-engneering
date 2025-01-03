package c.k.d;

import android.content.Context;
import c.k.d.j;

/* loaded from: classes.dex */
public class l0 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f7334a;

    public l0(Context context) {
        this.f7334a = context;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 100886;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m270a() {
        return c.k.b.b.b.a(this.f7334a).m10a().e();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (m270a()) {
                c.k.a.a.a.c.c(this.f7334a.getPackageName() + " begin upload event");
                c.k.b.b.b.a(this.f7334a).m12b();
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
    }
}
