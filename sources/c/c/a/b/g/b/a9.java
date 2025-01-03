package c.c.a.b.g.b;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class a9 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public long f4586a;

    /* renamed from: b, reason: collision with root package name */
    public long f4587b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x8 f4588c;

    public a9(x8 x8Var, long j, long j2) {
        this.f4588c = x8Var;
        this.f4586a = j;
        this.f4587b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4588c.f5189b.a().a(new Runnable(this) { // from class: c.c.a.b.g.b.z8

            /* renamed from: a, reason: collision with root package name */
            public final a9 f5230a;

            {
                this.f5230a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a9 a9Var = this.f5230a;
                x8 x8Var = a9Var.f4588c;
                long j = a9Var.f4586a;
                long j2 = a9Var.f4587b;
                x8Var.f5189b.g();
                x8Var.f5189b.c().A().a("Application going to the background");
                if (x8Var.f5189b.l().a(r.E0)) {
                    x8Var.f5189b.k().x.a(true);
                }
                if (!x8Var.f5189b.l().r().booleanValue()) {
                    x8Var.f5189b.f5168e.b(j2);
                    x8Var.f5189b.a(false, false, j2);
                }
                x8Var.f5189b.o().a("auto", "_ab", j, new Bundle());
            }
        });
    }
}
