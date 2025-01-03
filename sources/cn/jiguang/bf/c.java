package cn.jiguang.bf;

/* loaded from: classes.dex */
public final class c extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final cn.jiguang.bg.c f8705a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f8706b;

    /* renamed from: c, reason: collision with root package name */
    public final Thread f8707c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8708d;

    public c(cn.jiguang.bg.c cVar, Throwable th, Thread thread) {
        this(cVar, th, thread, false);
    }

    public c(cn.jiguang.bg.c cVar, Throwable th, Thread thread, boolean z) {
        this.f8705a = cVar;
        this.f8706b = th;
        this.f8707c = thread;
        this.f8708d = z;
    }

    public cn.jiguang.bg.c a() {
        return this.f8705a;
    }

    public Throwable b() {
        return this.f8706b;
    }

    public Thread c() {
        return this.f8707c;
    }

    public boolean d() {
        return this.f8708d;
    }
}
