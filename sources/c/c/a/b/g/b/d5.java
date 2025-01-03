package c.c.a.b.g.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class d5 {
    public long A;
    public long B;
    public long C;
    public String D;
    public boolean E;
    public long F;
    public long G;

    /* renamed from: a, reason: collision with root package name */
    public final a5 f4655a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4656b;

    /* renamed from: c, reason: collision with root package name */
    public String f4657c;

    /* renamed from: d, reason: collision with root package name */
    public String f4658d;

    /* renamed from: e, reason: collision with root package name */
    public String f4659e;

    /* renamed from: f, reason: collision with root package name */
    public String f4660f;

    /* renamed from: g, reason: collision with root package name */
    public long f4661g;

    /* renamed from: h, reason: collision with root package name */
    public long f4662h;

    /* renamed from: i, reason: collision with root package name */
    public long f4663i;
    public String j;
    public long k;
    public String l;
    public long m;
    public long n;
    public boolean o;
    public long p;
    public boolean q;
    public boolean r;
    public String s;
    public Boolean t;
    public long u;
    public List<String> v;
    public String w;
    public long x;
    public long y;
    public long z;

    public d5(a5 a5Var, String str) {
        c.c.a.b.c.o.r.a(a5Var);
        c.c.a.b.c.o.r.b(str);
        this.f4655a = a5Var;
        this.f4656b = str;
        a5Var.a().g();
    }

    public final boolean A() {
        this.f4655a.a().g();
        return this.o;
    }

    public final long B() {
        this.f4655a.a().g();
        return this.f4661g;
    }

    public final long C() {
        this.f4655a.a().g();
        return this.F;
    }

    public final long D() {
        this.f4655a.a().g();
        return this.G;
    }

    public final void E() {
        this.f4655a.a().g();
        long j = this.f4661g + 1;
        if (j > 2147483647L) {
            this.f4655a.c().w().a("Bundle index overflow. appId", w3.a(this.f4656b));
            j = 0;
        }
        this.E = true;
        this.f4661g = j;
    }

    public final long F() {
        this.f4655a.a().g();
        return this.x;
    }

    public final long G() {
        this.f4655a.a().g();
        return this.y;
    }

    public final long H() {
        this.f4655a.a().g();
        return this.z;
    }

    public final long I() {
        this.f4655a.a().g();
        return this.A;
    }

    public final boolean a() {
        this.f4655a.a().g();
        return this.E;
    }

    public final void b(String str) {
        this.f4655a.a().g();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !s9.c(this.f4658d, str);
        this.f4658d = str;
    }

    public final void c(String str) {
        this.f4655a.a().g();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !s9.c(this.s, str);
        this.s = str;
    }

    public final void d(String str) {
        this.f4655a.a().g();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !s9.c(this.w, str);
        this.w = str;
    }

    public final void e(String str) {
        this.f4655a.a().g();
        this.E |= !s9.c(this.f4659e, str);
        this.f4659e = str;
    }

    public final void f(String str) {
        this.f4655a.a().g();
        this.E |= !s9.c(this.f4660f, str);
        this.f4660f = str;
    }

    public final void g(String str) {
        this.f4655a.a().g();
        this.E |= !s9.c(this.j, str);
        this.j = str;
    }

    public final void h(String str) {
        this.f4655a.a().g();
        this.E |= !s9.c(this.l, str);
        this.l = str;
    }

    public final void i(long j) {
        this.f4655a.a().g();
        this.E |= this.G != j;
        this.G = j;
    }

    public final void j(long j) {
        this.f4655a.a().g();
        this.E |= this.x != j;
        this.x = j;
    }

    public final void k() {
        this.f4655a.a().g();
        this.E = false;
    }

    public final String l() {
        this.f4655a.a().g();
        return this.f4656b;
    }

    public final String m() {
        this.f4655a.a().g();
        return this.f4657c;
    }

    public final String n() {
        this.f4655a.a().g();
        return this.f4658d;
    }

    public final String o() {
        this.f4655a.a().g();
        return this.s;
    }

    public final String p() {
        this.f4655a.a().g();
        return this.w;
    }

    public final String q() {
        this.f4655a.a().g();
        return this.f4659e;
    }

    public final String r() {
        this.f4655a.a().g();
        return this.f4660f;
    }

    public final long s() {
        this.f4655a.a().g();
        return this.f4662h;
    }

    public final long t() {
        this.f4655a.a().g();
        return this.f4663i;
    }

    public final String u() {
        this.f4655a.a().g();
        return this.j;
    }

    public final long v() {
        this.f4655a.a().g();
        return this.k;
    }

    public final String w() {
        this.f4655a.a().g();
        return this.l;
    }

    public final long x() {
        this.f4655a.a().g();
        return this.m;
    }

    public final long y() {
        this.f4655a.a().g();
        return this.n;
    }

    public final long z() {
        this.f4655a.a().g();
        return this.u;
    }

    public final void a(String str) {
        this.f4655a.a().g();
        this.E |= !s9.c(this.f4657c, str);
        this.f4657c = str;
    }

    public final void k(long j) {
        this.f4655a.a().g();
        this.E |= this.y != j;
        this.y = j;
    }

    public final void l(long j) {
        this.f4655a.a().g();
        this.E |= this.z != j;
        this.z = j;
    }

    public final void m(long j) {
        this.f4655a.a().g();
        this.E |= this.A != j;
        this.A = j;
    }

    public final void n(long j) {
        this.f4655a.a().g();
        this.E |= this.C != j;
        this.C = j;
    }

    public final void o(long j) {
        this.f4655a.a().g();
        this.E |= this.B != j;
        this.B = j;
    }

    public final void p(long j) {
        this.f4655a.a().g();
        this.E |= this.p != j;
        this.p = j;
    }

    public final void e(long j) {
        this.f4655a.a().g();
        this.E |= this.n != j;
        this.n = j;
    }

    public final void f(long j) {
        this.f4655a.a().g();
        this.E |= this.u != j;
        this.u = j;
    }

    public final void g(long j) {
        c.c.a.b.c.o.r.a(j >= 0);
        this.f4655a.a().g();
        this.E = (this.f4661g != j) | this.E;
        this.f4661g = j;
    }

    public final void h(long j) {
        this.f4655a.a().g();
        this.E |= this.F != j;
        this.F = j;
    }

    public final void i(String str) {
        this.f4655a.a().g();
        this.E |= !s9.c(this.D, str);
        this.D = str;
    }

    public final List<String> j() {
        this.f4655a.a().g();
        return this.v;
    }

    public final void b(long j) {
        this.f4655a.a().g();
        this.E |= this.f4663i != j;
        this.f4663i = j;
    }

    public final void c(long j) {
        this.f4655a.a().g();
        this.E |= this.k != j;
        this.k = j;
    }

    public final void d(long j) {
        this.f4655a.a().g();
        this.E |= this.m != j;
        this.m = j;
    }

    public final void a(long j) {
        this.f4655a.a().g();
        this.E |= this.f4662h != j;
        this.f4662h = j;
    }

    public final String e() {
        this.f4655a.a().g();
        String str = this.D;
        i((String) null);
        return str;
    }

    public final long f() {
        this.f4655a.a().g();
        return this.p;
    }

    public final boolean h() {
        this.f4655a.a().g();
        return this.r;
    }

    public final Boolean i() {
        this.f4655a.a().g();
        return this.t;
    }

    public final long b() {
        this.f4655a.a().g();
        return this.C;
    }

    public final long c() {
        this.f4655a.a().g();
        return this.B;
    }

    public final String d() {
        this.f4655a.a().g();
        return this.D;
    }

    public final boolean g() {
        this.f4655a.a().g();
        return this.q;
    }

    public final void a(boolean z) {
        this.f4655a.a().g();
        this.E |= this.o != z;
        this.o = z;
    }

    public final void b(boolean z) {
        this.f4655a.a().g();
        this.E |= this.q != z;
        this.q = z;
    }

    public final void c(boolean z) {
        this.f4655a.a().g();
        this.E |= this.r != z;
        this.r = z;
    }

    public final void a(Boolean bool) {
        this.f4655a.a().g();
        this.E |= !s9.a(this.t, bool);
        this.t = bool;
    }

    public final void a(List<String> list) {
        this.f4655a.a().g();
        if (s9.a(this.v, list)) {
            return;
        }
        this.E = true;
        this.v = list != null ? new ArrayList(list) : null;
    }
}
