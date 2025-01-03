package c.c.a.b.g.b;

import android.os.Bundle;
import cn.jiguang.internal.JConstants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class c9 {

    /* renamed from: a, reason: collision with root package name */
    public long f4639a;

    /* renamed from: b, reason: collision with root package name */
    public long f4640b;

    /* renamed from: c, reason: collision with root package name */
    public final j f4641c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w8 f4642d;

    public c9(w8 w8Var) {
        this.f4642d = w8Var;
        this.f4641c = new b9(this, this.f4642d.f5160a);
        long b2 = w8Var.b().b();
        this.f4639a = b2;
        this.f4640b = b2;
    }

    public final void a(long j) {
        this.f4642d.g();
        this.f4641c.c();
        this.f4639a = j;
        this.f4640b = j;
    }

    public final void b(long j) {
        this.f4641c.c();
    }

    public final void c() {
        this.f4642d.g();
        a(false, false, this.f4642d.b().b());
        this.f4642d.n().a(this.f4642d.b().b());
    }

    public final long b() {
        long b2 = this.f4642d.b().b();
        long j = b2 - this.f4640b;
        this.f4640b = b2;
        return j;
    }

    public final long c(long j) {
        long j2 = j - this.f4640b;
        this.f4640b = j;
        return j2;
    }

    public final void a() {
        this.f4641c.c();
        this.f4639a = 0L;
        this.f4640b = 0L;
    }

    public final boolean a(boolean z, boolean z2, long j) {
        this.f4642d.g();
        this.f4642d.w();
        if (!c.c.a.b.f.e.w9.a() || !this.f4642d.l().a(r.B0)) {
            j = this.f4642d.b().b();
        }
        if (!c.c.a.b.f.e.ca.a() || !this.f4642d.l().a(r.x0) || this.f4642d.f5160a.g()) {
            this.f4642d.k().v.a(this.f4642d.b().a());
        }
        long j2 = j - this.f4639a;
        if (!z && j2 < 1000) {
            this.f4642d.c().B().a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
            return false;
        }
        if (this.f4642d.l().a(r.U) && !z2) {
            j2 = (c.c.a.b.f.e.ha.a() && this.f4642d.l().a(r.W) && c.c.a.b.f.e.w9.a() && this.f4642d.l().a(r.B0)) ? c(j) : b();
        }
        this.f4642d.c().B().a("Recording user engagement, ms", Long.valueOf(j2));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        l7.a(this.f4642d.r().a(!this.f4642d.l().r().booleanValue()), bundle, true);
        if (this.f4642d.l().a(r.U) && !this.f4642d.l().a(r.V) && z2) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.f4642d.l().a(r.V) || !z2) {
            this.f4642d.o().a("auto", "_e", bundle);
        }
        this.f4639a = j;
        this.f4641c.c();
        this.f4641c.a(JConstants.HOUR);
        return true;
    }
}
