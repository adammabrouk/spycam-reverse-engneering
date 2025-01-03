package c.c.a.b.f.d;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class p extends o {

    /* renamed from: a, reason: collision with root package name */
    public final n f4059a = new n();

    @Override // c.c.a.b.f.d.o
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.f4059a.a(th, true).add(th2);
    }
}
