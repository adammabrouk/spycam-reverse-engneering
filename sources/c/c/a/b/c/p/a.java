package c.c.a.b.c.p;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static InterfaceC0091a f4003a;

    /* renamed from: c.c.a.b.c.p.a$a, reason: collision with other inner class name */
    public interface InterfaceC0091a {
        ScheduledExecutorService a();
    }

    public static synchronized InterfaceC0091a a() {
        InterfaceC0091a interfaceC0091a;
        synchronized (a.class) {
            if (f4003a == null) {
                f4003a = new b();
            }
            interfaceC0091a = f4003a;
        }
        return interfaceC0091a;
    }
}
