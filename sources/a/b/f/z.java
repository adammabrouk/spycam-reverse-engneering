package a.b.f;

/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public int f616a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f617b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f618c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f619d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f620e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f621f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f622g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f623h = false;

    public int a() {
        return this.f622g ? this.f616a : this.f617b;
    }

    public int b() {
        return this.f616a;
    }

    public int c() {
        return this.f617b;
    }

    public int d() {
        return this.f622g ? this.f617b : this.f616a;
    }

    public void a(int i2, int i3) {
        this.f623h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f620e = i2;
            this.f616a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f621f = i3;
            this.f617b = i3;
        }
    }

    public void b(int i2, int i3) {
        this.f618c = i2;
        this.f619d = i3;
        this.f623h = true;
        if (this.f622g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f616a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f617b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f616a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f617b = i3;
        }
    }

    public void a(boolean z) {
        if (z == this.f622g) {
            return;
        }
        this.f622g = z;
        if (!this.f623h) {
            this.f616a = this.f620e;
            this.f617b = this.f621f;
            return;
        }
        if (z) {
            int i2 = this.f619d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f620e;
            }
            this.f616a = i2;
            int i3 = this.f618c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f621f;
            }
            this.f617b = i3;
            return;
        }
        int i4 = this.f618c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f620e;
        }
        this.f616a = i4;
        int i5 = this.f619d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f621f;
        }
        this.f617b = i5;
    }
}
