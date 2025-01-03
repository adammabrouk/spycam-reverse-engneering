package c.k.d;

import android.content.Context;
import c.k.d.j;

/* loaded from: classes.dex */
public class m0 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f7372a;

    public m0(Context context) {
        this.f7372a = context;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 100887;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m292a() {
        return c.k.b.b.b.a(this.f7372a).m10a().f();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (m292a()) {
                c.k.b.b.b.a(this.f7372a).c();
                c.k.a.a.a.c.c(this.f7372a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
    }
}
