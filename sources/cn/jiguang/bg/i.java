package cn.jiguang.bg;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Date f8771a;

    /* renamed from: b, reason: collision with root package name */
    public Date f8772b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f8773c;

    /* renamed from: d, reason: collision with root package name */
    public final UUID f8774d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f8775e;

    /* renamed from: f, reason: collision with root package name */
    public a f8776f;

    /* renamed from: g, reason: collision with root package name */
    public Long f8777g;

    /* renamed from: h, reason: collision with root package name */
    public Double f8778h;

    /* renamed from: i, reason: collision with root package name */
    public final String f8779i;
    public String j;
    public final String k;
    public final Object l;

    public enum a {
        Ok,
        Exited,
        Crashed
    }

    public i() {
        this(a.Ok, cn.jiguang.e.b.c(), cn.jiguang.e.b.c(), 0, UUID.randomUUID(), true, null, null, null, null, "production");
    }

    public i(a aVar, Date date, Date date2, int i2, UUID uuid, Boolean bool, Long l, Double d2, String str, String str2, String str3) {
        this.l = new Object();
        this.f8776f = aVar;
        this.f8771a = date;
        this.f8772b = date2;
        this.f8773c = new AtomicInteger(i2);
        this.f8774d = uuid;
        this.f8775e = bool;
        this.f8777g = l;
        this.f8778h = d2;
        this.f8779i = str;
        this.j = str2;
        this.k = str3;
    }

    private double b(Date date) {
        double abs = Math.abs(date.getTime() - this.f8771a.getTime());
        Double.isNaN(abs);
        return abs / 1000.0d;
    }

    private long c(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    public Date a() {
        Date date = this.f8771a;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public void a(Date date) {
        synchronized (this.l) {
            this.f8775e = null;
            if (this.f8776f == a.Ok) {
                this.f8776f = a.Exited;
            }
            if (date == null) {
                date = cn.jiguang.e.b.c();
            }
            this.f8772b = date;
            if (this.f8772b != null) {
                this.f8778h = Double.valueOf(b(this.f8772b));
                this.f8777g = Long.valueOf(c(this.f8772b));
            }
        }
    }

    public boolean a(a aVar, String str, boolean z) {
        boolean z2;
        synchronized (this.l) {
            boolean z3 = false;
            z2 = true;
            if (aVar != null) {
                try {
                    this.f8776f = aVar;
                    z3 = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (str != null) {
                this.j = str;
                z3 = true;
            }
            if (z) {
                this.f8773c.addAndGet(1);
            } else {
                z2 = z3;
            }
            if (z2) {
                this.f8775e = null;
                Date c2 = cn.jiguang.e.b.c();
                this.f8772b = c2;
                if (c2 != null) {
                    this.f8777g = Long.valueOf(c(c2));
                }
            }
        }
        return z2;
    }

    public UUID b() {
        return this.f8774d;
    }

    public Boolean c() {
        return this.f8775e;
    }

    public int d() {
        return this.f8773c.get();
    }

    public a e() {
        return this.f8776f;
    }

    public Long f() {
        return this.f8777g;
    }

    public Double g() {
        return this.f8778h;
    }

    public Date h() {
        Date date = this.f8772b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void i() {
        a(cn.jiguang.e.b.c());
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public i clone() {
        return new i(this.f8776f, this.f8771a, this.f8772b, this.f8773c.get(), this.f8774d, this.f8775e, this.f8777g, this.f8778h, this.f8779i, this.j, this.k);
    }
}
