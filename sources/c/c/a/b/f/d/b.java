package c.c.a.b.f.d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public interface b {
    ExecutorService a(ThreadFactory threadFactory, int i2);

    ScheduledExecutorService a(int i2, ThreadFactory threadFactory, int i3);
}
