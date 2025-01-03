package c.k.c.a;

import c.k.c.a.p;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p.a.C0128a f6932a;

    public x(p.a.C0128a c0128a) {
        this.f6932a = c0128a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f6932a.f6887b.size() != 0) {
            this.f6932a.b();
            return;
        }
        scheduledFuture = this.f6932a.f6888c;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f6932a.f6888c;
            scheduledFuture2.cancel(false);
            this.f6932a.f6888c = null;
        }
    }
}
