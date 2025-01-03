package c.c.a.b.g.b;

import cn.jiguang.internal.JConstants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class d9 {

    /* renamed from: a, reason: collision with root package name */
    public final c.c.a.b.c.s.e f4679a;

    /* renamed from: b, reason: collision with root package name */
    public long f4680b;

    public d9(c.c.a.b.c.s.e eVar) {
        c.c.a.b.c.o.r.a(eVar);
        this.f4679a = eVar;
    }

    public final void a() {
        this.f4680b = this.f4679a.b();
    }

    public final void b() {
        this.f4680b = 0L;
    }

    public final boolean a(long j) {
        return this.f4680b == 0 || this.f4679a.b() - this.f4680b >= JConstants.HOUR;
    }
}
