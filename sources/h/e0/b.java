package h.e0;

/* compiled from: NamedRunnable.java */
/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f11394a;

    public b(String str, Object... objArr) {
        this.f11394a = c.a(str, objArr);
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f11394a);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
