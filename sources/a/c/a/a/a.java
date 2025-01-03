package a.c.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public static volatile a f624c;

    /* renamed from: a, reason: collision with root package name */
    public c f625a;

    /* renamed from: b, reason: collision with root package name */
    public c f626b;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: a.c.a.a.a$a, reason: collision with other inner class name */
    public static class ExecutorC0008a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.b().b(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.b().a(runnable);
        }
    }

    static {
        new ExecutorC0008a();
        new b();
    }

    public a() {
        a.c.a.a.b bVar = new a.c.a.a.b();
        this.f626b = bVar;
        this.f625a = bVar;
    }

    public static a b() {
        if (f624c != null) {
            return f624c;
        }
        synchronized (a.class) {
            if (f624c == null) {
                f624c = new a();
            }
        }
        return f624c;
    }

    @Override // a.c.a.a.c
    public void a(Runnable runnable) {
        this.f625a.a(runnable);
    }

    @Override // a.c.a.a.c
    public boolean a() {
        return this.f625a.a();
    }

    @Override // a.c.a.a.c
    public void b(Runnable runnable) {
        this.f625a.b(runnable);
    }
}
