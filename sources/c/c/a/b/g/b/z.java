package c.c.a.b.g.b;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class z extends d4 {

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f5208b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f5209c;

    /* renamed from: d, reason: collision with root package name */
    public long f5210d;

    public z(a5 a5Var) {
        super(a5Var);
        this.f5209c = new a.e.a();
        this.f5208b = new a.e.a();
    }

    public final void a(String str, long j) {
        if (str == null || str.length() == 0) {
            c().t().a("Ad unit id must be a non-empty string");
        } else {
            a().a(new a(this, str, j));
        }
    }

    public final void b(String str, long j) {
        if (str == null || str.length() == 0) {
            c().t().a("Ad unit id must be a non-empty string");
        } else {
            a().a(new b2(this, str, j));
        }
    }

    public final void c(String str, long j) {
        e();
        g();
        c.c.a.b.c.o.r.b(str);
        if (this.f5209c.isEmpty()) {
            this.f5210d = j;
        }
        Integer num = this.f5209c.get(str);
        if (num != null) {
            this.f5209c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f5209c.size() >= 100) {
            c().w().a("Too many ads visible");
        } else {
            this.f5209c.put(str, 1);
            this.f5208b.put(str, Long.valueOf(j));
        }
    }

    public final void d(String str, long j) {
        e();
        g();
        c.c.a.b.c.o.r.b(str);
        Integer num = this.f5209c.get(str);
        if (num == null) {
            c().t().a("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        m7 a2 = r().a(false);
        int intValue = num.intValue() - 1;
        if (intValue != 0) {
            this.f5209c.put(str, Integer.valueOf(intValue));
            return;
        }
        this.f5209c.remove(str);
        Long l = this.f5208b.get(str);
        if (l == null) {
            c().t().a("First ad unit exposure time was never set");
        } else {
            long longValue = j - l.longValue();
            this.f5208b.remove(str);
            a(str, longValue, a2);
        }
        if (this.f5209c.isEmpty()) {
            long j2 = this.f5210d;
            if (j2 == 0) {
                c().t().a("First ad exposure time was never set");
            } else {
                a(j - j2, a2);
                this.f5210d = 0L;
            }
        }
    }

    public final void a(long j, m7 m7Var) {
        if (m7Var == null) {
            c().B().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            c().B().a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        l7.a(m7Var, bundle, true);
        o().a("am", "_xa", bundle);
    }

    public final void b(long j) {
        Iterator<String> it = this.f5208b.keySet().iterator();
        while (it.hasNext()) {
            this.f5208b.put(it.next(), Long.valueOf(j));
        }
        if (this.f5208b.isEmpty()) {
            return;
        }
        this.f5210d = j;
    }

    public final void a(String str, long j, m7 m7Var) {
        if (m7Var == null) {
            c().B().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            c().B().a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        l7.a(m7Var, bundle, true);
        o().a("am", "_xu", bundle);
    }

    public final void a(long j) {
        m7 a2 = r().a(false);
        for (String str : this.f5208b.keySet()) {
            a(str, j - this.f5208b.get(str).longValue(), a2);
        }
        if (!this.f5208b.isEmpty()) {
            a(j - this.f5210d, a2);
        }
        b(j);
    }
}
