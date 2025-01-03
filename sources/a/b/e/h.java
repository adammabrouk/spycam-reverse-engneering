package a.b.e;

import a.h.j.c0;
import a.h.j.d0;
import a.h.j.e0;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f294c;

    /* renamed from: d, reason: collision with root package name */
    public d0 f295d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f296e;

    /* renamed from: b, reason: collision with root package name */
    public long f293b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final e0 f297f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<c0> f292a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    public class a extends e0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f298a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f299b = 0;

        public a() {
        }

        public void a() {
            this.f299b = 0;
            this.f298a = false;
            h.this.b();
        }

        @Override // a.h.j.d0
        public void b(View view) {
            int i2 = this.f299b + 1;
            this.f299b = i2;
            if (i2 == h.this.f292a.size()) {
                d0 d0Var = h.this.f295d;
                if (d0Var != null) {
                    d0Var.b(null);
                }
                a();
            }
        }

        @Override // a.h.j.e0, a.h.j.d0
        public void c(View view) {
            if (this.f298a) {
                return;
            }
            this.f298a = true;
            d0 d0Var = h.this.f295d;
            if (d0Var != null) {
                d0Var.c(null);
            }
        }
    }

    public h a(c0 c0Var) {
        if (!this.f296e) {
            this.f292a.add(c0Var);
        }
        return this;
    }

    public void b() {
        this.f296e = false;
    }

    public void c() {
        if (this.f296e) {
            return;
        }
        Iterator<c0> it = this.f292a.iterator();
        while (it.hasNext()) {
            c0 next = it.next();
            long j = this.f293b;
            if (j >= 0) {
                next.a(j);
            }
            Interpolator interpolator = this.f294c;
            if (interpolator != null) {
                next.a(interpolator);
            }
            if (this.f295d != null) {
                next.a(this.f297f);
            }
            next.c();
        }
        this.f296e = true;
    }

    public h a(c0 c0Var, c0 c0Var2) {
        this.f292a.add(c0Var);
        c0Var2.b(c0Var.b());
        this.f292a.add(c0Var2);
        return this;
    }

    public void a() {
        if (this.f296e) {
            Iterator<c0> it = this.f292a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f296e = false;
        }
    }

    public h a(long j) {
        if (!this.f296e) {
            this.f293b = j;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.f296e) {
            this.f294c = interpolator;
        }
        return this;
    }

    public h a(d0 d0Var) {
        if (!this.f296e) {
            this.f295d = d0Var;
        }
        return this;
    }
}
