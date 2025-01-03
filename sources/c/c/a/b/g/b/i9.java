package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public abstract class i9 extends j9 {

    /* renamed from: c, reason: collision with root package name */
    public boolean f4815c;

    public i9(l9 l9Var) {
        super(l9Var);
        this.f4840b.a(this);
    }

    public final boolean p() {
        return this.f4815c;
    }

    public final void q() {
        if (!p()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void r() {
        if (this.f4815c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        s();
        this.f4840b.t();
        this.f4815c = true;
    }

    public abstract boolean s();
}
