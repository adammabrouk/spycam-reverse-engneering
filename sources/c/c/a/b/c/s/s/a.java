package c.c.a.b.c.s.s;

import c.c.a.b.c.o.r;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f4022a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f4023b;

    public a(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f4023b.newThread(new b(runnable, 0));
        newThread.setName(this.f4022a);
        return newThread;
    }

    public a(String str, int i2) {
        this.f4023b = Executors.defaultThreadFactory();
        r.a(str, (Object) "Name must not be null");
        this.f4022a = str;
    }
}
