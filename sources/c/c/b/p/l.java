package c.c.b.p;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f6154a = new l();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
