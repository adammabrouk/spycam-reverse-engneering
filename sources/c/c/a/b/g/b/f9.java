package c.c.a.b.g.b;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class f9 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w8 f4734a;

    public f9(w8 w8Var) {
        this.f4734a = w8Var;
    }

    public final void a() {
        this.f4734a.g();
        if (this.f4734a.k().a(this.f4734a.b().a())) {
            this.f4734a.k().r.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f4734a.c().B().a("Detected application was in foreground");
                b(this.f4734a.b().a(), false);
            }
        }
    }

    public final void b(long j, boolean z) {
        this.f4734a.g();
        if (this.f4734a.f5160a.g()) {
            this.f4734a.k().v.a(j);
            this.f4734a.c().B().a("Session started, time", Long.valueOf(this.f4734a.b().b()));
            Long valueOf = Long.valueOf(j / 1000);
            this.f4734a.o().a("auto", "_sid", valueOf, j);
            this.f4734a.k().r.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.f4734a.l().a(r.r0) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.f4734a.o().a("auto", "_s", j, bundle);
            if (c.c.a.b.f.e.k9.a() && this.f4734a.l().a(r.w0)) {
                String a2 = this.f4734a.k().A.a();
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a2);
                this.f4734a.o().a("auto", "_ssr", j, bundle2);
            }
        }
    }

    public final void a(long j, boolean z) {
        this.f4734a.g();
        this.f4734a.A();
        if (this.f4734a.k().a(j)) {
            this.f4734a.k().r.a(true);
        }
        this.f4734a.k().v.a(j);
        if (this.f4734a.k().r.a()) {
            b(j, z);
        }
    }
}
