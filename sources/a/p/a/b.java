package a.p.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0048b f1590a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1591b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final List<View> f1592c = new ArrayList();

    /* compiled from: ChildHelper.java */
    /* renamed from: a.p.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0048b {
        int a();

        View a(int i2);

        void a(View view);

        void a(View view, int i2);

        void a(View view, int i2, ViewGroup.LayoutParams layoutParams);

        RecyclerView.c0 b(View view);

        void b();

        void b(int i2);

        void c(int i2);

        void c(View view);

        int d(View view);
    }

    public b(InterfaceC0048b interfaceC0048b) {
        this.f1590a = interfaceC0048b;
    }

    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    public final void b(View view) {
        this.f1592c.add(view);
        this.f1590a.a(view);
    }

    public View c(int i2) {
        return this.f1590a.a(d(i2));
    }

    public final int d(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int a2 = this.f1590a.a();
        int i3 = i2;
        while (i3 < a2) {
            int b2 = i2 - (i3 - this.f1591b.b(i3));
            if (b2 == 0) {
                while (this.f1591b.c(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    public void e(View view) {
        int d2 = this.f1590a.d(view);
        if (d2 < 0) {
            return;
        }
        if (this.f1591b.d(d2)) {
            h(view);
        }
        this.f1590a.c(d2);
    }

    public void f(int i2) {
        int d2 = d(i2);
        View a2 = this.f1590a.a(d2);
        if (a2 == null) {
            return;
        }
        if (this.f1591b.d(d2)) {
            h(a2);
        }
        this.f1590a.c(d2);
    }

    public void g(View view) {
        int d2 = this.f1590a.d(view);
        if (d2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f1591b.c(d2)) {
            this.f1591b.a(d2);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean h(View view) {
        if (!this.f1592c.remove(view)) {
            return false;
        }
        this.f1590a.c(view);
        return true;
    }

    public String toString() {
        return this.f1591b.toString() + ", hidden list:" + this.f1592c.size();
    }

    /* compiled from: ChildHelper.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f1593a = 0;

        /* renamed from: b, reason: collision with root package name */
        public a f1594b;

        public final void a() {
            if (this.f1594b == null) {
                this.f1594b = new a();
            }
        }

        public void b() {
            this.f1593a = 0L;
            a aVar = this.f1594b;
            if (aVar != null) {
                aVar.b();
            }
        }

        public boolean c(int i2) {
            if (i2 < 64) {
                return (this.f1593a & (1 << i2)) != 0;
            }
            a();
            return this.f1594b.c(i2 - 64);
        }

        public boolean d(int i2) {
            if (i2 >= 64) {
                a();
                return this.f1594b.d(i2 - 64);
            }
            long j = 1 << i2;
            boolean z = (this.f1593a & j) != 0;
            long j2 = this.f1593a & (j ^ (-1));
            this.f1593a = j2;
            long j3 = j - 1;
            this.f1593a = (j2 & j3) | Long.rotateRight((j3 ^ (-1)) & j2, 1);
            a aVar = this.f1594b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f1594b.d(0);
            }
            return z;
        }

        public void e(int i2) {
            if (i2 < 64) {
                this.f1593a |= 1 << i2;
            } else {
                a();
                this.f1594b.e(i2 - 64);
            }
        }

        public String toString() {
            if (this.f1594b == null) {
                return Long.toBinaryString(this.f1593a);
            }
            return this.f1594b.toString() + "xx" + Long.toBinaryString(this.f1593a);
        }

        public void a(int i2) {
            if (i2 >= 64) {
                a aVar = this.f1594b;
                if (aVar != null) {
                    aVar.a(i2 - 64);
                    return;
                }
                return;
            }
            this.f1593a &= (1 << i2) ^ (-1);
        }

        public int b(int i2) {
            a aVar = this.f1594b;
            if (aVar == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.f1593a);
                }
                return Long.bitCount(this.f1593a & ((1 << i2) - 1));
            }
            if (i2 < 64) {
                return Long.bitCount(this.f1593a & ((1 << i2) - 1));
            }
            return aVar.b(i2 - 64) + Long.bitCount(this.f1593a);
        }

        public void a(int i2, boolean z) {
            if (i2 >= 64) {
                a();
                this.f1594b.a(i2 - 64, z);
                return;
            }
            boolean z2 = (this.f1593a & Long.MIN_VALUE) != 0;
            long j = (1 << i2) - 1;
            long j2 = this.f1593a;
            this.f1593a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                e(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f1594b != null) {
                a();
                this.f1594b.a(0, z2);
            }
        }
    }

    public void a(View view, int i2, boolean z) {
        int a2 = i2 < 0 ? this.f1590a.a() : d(i2);
        this.f1591b.a(a2, z);
        if (z) {
            b(view);
        }
        this.f1590a.a(view, a2);
    }

    public View b(int i2) {
        int size = this.f1592c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f1592c.get(i3);
            RecyclerView.c0 b2 = this.f1590a.b(view);
            if (b2.getLayoutPosition() == i2 && !b2.isInvalid() && !b2.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public void c() {
        this.f1591b.b();
        for (int size = this.f1592c.size() - 1; size >= 0; size--) {
            this.f1590a.c(this.f1592c.get(size));
            this.f1592c.remove(size);
        }
        this.f1590a.b();
    }

    public boolean d(View view) {
        return this.f1592c.contains(view);
    }

    public View e(int i2) {
        return this.f1590a.a(i2);
    }

    public boolean f(View view) {
        int d2 = this.f1590a.d(view);
        if (d2 == -1) {
            h(view);
            return true;
        }
        if (!this.f1591b.c(d2)) {
            return false;
        }
        this.f1591b.d(d2);
        h(view);
        this.f1590a.c(d2);
        return true;
    }

    public void a(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int d2;
        if (i2 < 0) {
            d2 = this.f1590a.a();
        } else {
            d2 = d(i2);
        }
        this.f1591b.a(d2, z);
        if (z) {
            b(view);
        }
        this.f1590a.a(view, d2, layoutParams);
    }

    public int c(View view) {
        int d2 = this.f1590a.d(view);
        if (d2 == -1 || this.f1591b.c(d2)) {
            return -1;
        }
        return d2 - this.f1591b.b(d2);
    }

    public int b() {
        return this.f1590a.a();
    }

    public int a() {
        return this.f1590a.a() - this.f1592c.size();
    }

    public void a(int i2) {
        int d2 = d(i2);
        this.f1591b.d(d2);
        this.f1590a.b(d2);
    }

    public void a(View view) {
        int d2 = this.f1590a.d(view);
        if (d2 >= 0) {
            this.f1591b.e(d2);
            b(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }
}
