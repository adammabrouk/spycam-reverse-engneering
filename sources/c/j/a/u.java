package c.j.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: PushClientThread.java */
/* loaded from: classes.dex */
public final class u extends Handler {
    public u(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof r) {
            r rVar = (r) obj;
            c.j.a.z.v.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(rVar)));
            rVar.run();
        }
    }
}
