package c.c.b.p;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class n {
    public static Executor a() {
        return a("Firebase-Messaging-Rpc-Task");
    }

    public static Executor b() {
        return a("Firebase-Messaging-Trigger-Topics-Io");
    }

    public static Executor a(String str) {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c.c.a.b.c.s.s.a(str));
    }
}
