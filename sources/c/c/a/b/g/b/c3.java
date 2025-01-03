package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public abstract class c3 extends d4 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f4628b;

    public c3(a5 a5Var) {
        super(a5Var);
        this.f5160a.a(this);
    }

    public void u() {
    }

    public final boolean v() {
        return this.f4628b;
    }

    public final void w() {
        if (!v()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void x() {
        if (this.f4628b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (z()) {
            return;
        }
        this.f5160a.k();
        this.f4628b = true;
    }

    public final void y() {
        if (this.f4628b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        u();
        this.f5160a.k();
        this.f4628b = true;
    }

    public abstract boolean z();
}
