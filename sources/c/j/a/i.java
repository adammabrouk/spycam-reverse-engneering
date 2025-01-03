package c.j.a;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IPCManager.java */
/* loaded from: classes.dex */
public final class i implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f6557a;

    public i(g gVar) {
        this.f6557a = gVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            c.j.a.z.v.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i2 = message.what;
        if (i2 == 1) {
            c.j.a.z.v.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.f6557a.f6541d;
            if (atomicInteger.get() == 2) {
                this.f6557a.a(1);
            }
        } else if (i2 != 2) {
            c.j.a.z.v.b("AidlManager", "unknow msg what [" + message.what + "]");
        } else {
            atomicInteger2 = this.f6557a.f6541d;
            if (atomicInteger2.get() == 4) {
                this.f6557a.f();
            }
            this.f6557a.a(1);
        }
        return true;
    }
}
