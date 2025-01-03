package c.c.a.b.g.b;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class x8 {

    /* renamed from: a, reason: collision with root package name */
    public a9 f5188a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w8 f5189b;

    public x8(w8 w8Var) {
        this.f5189b = w8Var;
    }

    public final void a() {
        Handler handler;
        this.f5189b.g();
        if (this.f5189b.l().a(r.q0) && this.f5188a != null) {
            handler = this.f5189b.f5166c;
            handler.removeCallbacks(this.f5188a);
        }
        if (this.f5189b.l().a(r.E0)) {
            this.f5189b.k().x.a(false);
        }
    }

    public final void a(long j) {
        Handler handler;
        if (this.f5189b.l().a(r.q0)) {
            this.f5188a = new a9(this, this.f5189b.b().a(), j);
            handler = this.f5189b.f5166c;
            handler.postDelayed(this.f5188a, 2000L);
        }
    }
}
