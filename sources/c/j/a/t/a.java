package c.j.a.t;

/* compiled from: InsideNotificationItem.java */
/* loaded from: classes.dex */
public class a extends b {
    public int q;
    public String r;
    public boolean s;
    public String t;
    public int u;
    public int v;
    public int w;
    public int x;

    public final int A() {
        int i2 = this.w;
        return ((i2 & 32) == 0 && (i2 & 16) != 0) ? 1 : 0;
    }

    public void b(boolean z) {
        this.s = z;
    }

    public void f(int i2) {
        this.q = i2;
    }

    public void g(int i2) {
        this.w = i2;
        this.x = A();
    }

    public void h(int i2) {
        this.v = i2;
    }

    public void i(String str) {
        this.r = str;
    }

    public void j(String str) {
        this.t = str;
    }

    public int s() {
        return this.q;
    }

    public int t() {
        return this.w;
    }

    public int u() {
        return this.v;
    }

    public int v() {
        return this.u;
    }

    public int w() {
        return this.x;
    }

    public String x() {
        return this.r;
    }

    public String y() {
        return this.t;
    }

    public boolean z() {
        return this.s;
    }

    public void i(int i2) {
        this.u = i2;
    }
}
