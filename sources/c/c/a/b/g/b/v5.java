package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public abstract class v5 extends w5 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f5141b;

    public v5(a5 a5Var) {
        super(a5Var);
        this.f5160a.a(this);
    }

    public void m() {
    }

    public final void n() {
        if (!r()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void o() {
        if (this.f5141b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (q()) {
            return;
        }
        this.f5160a.k();
        this.f5141b = true;
    }

    public final void p() {
        if (this.f5141b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        m();
        this.f5160a.k();
        this.f5141b = true;
    }

    public abstract boolean q();

    public final boolean r() {
        return this.f5141b;
    }
}
