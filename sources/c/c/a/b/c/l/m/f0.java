package c.c.a.b.c.l.m;

import com.google.android.gms.common.ConnectionResult;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final a.e.a<e0<?>, ConnectionResult> f3880a;

    /* renamed from: b, reason: collision with root package name */
    public final a.e.a<e0<?>, String> f3881b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.b.j.i<Map<e0<?>, String>> f3882c;

    /* renamed from: d, reason: collision with root package name */
    public int f3883d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3884e;

    public final Set<e0<?>> a() {
        return this.f3880a.keySet();
    }

    public final void a(e0<?> e0Var, ConnectionResult connectionResult, String str) {
        this.f3880a.put(e0Var, connectionResult);
        this.f3881b.put(e0Var, str);
        this.f3883d--;
        if (!connectionResult.y()) {
            this.f3884e = true;
        }
        if (this.f3883d == 0) {
            if (!this.f3884e) {
                this.f3882c.a((c.c.a.b.j.i<Map<e0<?>, String>>) this.f3881b);
            } else {
                this.f3882c.a(new c.c.a.b.c.l.c(this.f3880a));
            }
        }
    }
}
