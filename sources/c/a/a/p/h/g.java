package c.a.a.p.h;

/* compiled from: SimpleTarget.java */
/* loaded from: classes.dex */
public abstract class g<Z> extends a<Z> {

    /* renamed from: b, reason: collision with root package name */
    public final int f3430b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3431c;

    public g() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // c.a.a.p.h.j
    public final void a(h hVar) {
        if (c.a.a.r.h.a(this.f3430b, this.f3431c)) {
            hVar.a(this.f3430b, this.f3431c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f3430b + " and height: " + this.f3431c + ", either provide dimensions in the constructor or call override()");
    }

    public g(int i2, int i3) {
        this.f3430b = i2;
        this.f3431c = i3;
    }
}
