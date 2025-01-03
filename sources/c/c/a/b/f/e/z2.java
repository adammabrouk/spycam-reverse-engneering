package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class z2 extends v2 {

    /* renamed from: a, reason: collision with root package name */
    public final y2 f4549a = new y2();

    @Override // c.c.a.b.f.e.v2
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.f4549a.a(th, true).add(th2);
    }
}
