package a.p.a;

import android.view.View;

/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final b f1697a;

    /* renamed from: b, reason: collision with root package name */
    public a f1698b = new a();

    /* compiled from: ViewBoundsCheck.java */
    public interface b {
        int a();

        int a(View view);

        View a(int i2);

        int b();

        int b(View view);
    }

    public q(b bVar) {
        this.f1697a = bVar;
    }

    public View a(int i2, int i3, int i4, int i5) {
        int b2 = this.f1697a.b();
        int a2 = this.f1697a.a();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View a3 = this.f1697a.a(i2);
            this.f1698b.a(b2, a2, this.f1697a.a(a3), this.f1697a.b(a3));
            if (i4 != 0) {
                this.f1698b.b();
                this.f1698b.a(i4);
                if (this.f1698b.a()) {
                    return a3;
                }
            }
            if (i5 != 0) {
                this.f1698b.b();
                this.f1698b.a(i5);
                if (this.f1698b.a()) {
                    view = a3;
                }
            }
            i2 += i6;
        }
        return view;
    }

    /* compiled from: ViewBoundsCheck.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1699a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f1700b;

        /* renamed from: c, reason: collision with root package name */
        public int f1701c;

        /* renamed from: d, reason: collision with root package name */
        public int f1702d;

        /* renamed from: e, reason: collision with root package name */
        public int f1703e;

        public int a(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        public void a(int i2, int i3, int i4, int i5) {
            this.f1700b = i2;
            this.f1701c = i3;
            this.f1702d = i4;
            this.f1703e = i5;
        }

        public void b() {
            this.f1699a = 0;
        }

        public void a(int i2) {
            this.f1699a = i2 | this.f1699a;
        }

        public boolean a() {
            int i2 = this.f1699a;
            if ((i2 & 7) != 0 && (i2 & (a(this.f1702d, this.f1700b) << 0)) == 0) {
                return false;
            }
            int i3 = this.f1699a;
            if ((i3 & 112) != 0 && (i3 & (a(this.f1702d, this.f1701c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f1699a;
            if ((i4 & 1792) != 0 && (i4 & (a(this.f1703e, this.f1700b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f1699a;
            return (i5 & 28672) == 0 || (i5 & (a(this.f1703e, this.f1701c) << 12)) != 0;
        }
    }

    public boolean a(View view, int i2) {
        this.f1698b.a(this.f1697a.b(), this.f1697a.a(), this.f1697a.a(view), this.f1697a.b(view));
        if (i2 == 0) {
            return false;
        }
        this.f1698b.b();
        this.f1698b.a(i2);
        return this.f1698b.a();
    }
}
