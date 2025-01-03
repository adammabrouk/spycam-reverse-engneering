package c.k.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.k.d.m;

/* loaded from: classes.dex */
public class n extends Handler {
    public n(m mVar, Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        m.b bVar = (m.b) message.obj;
        int i2 = message.what;
        if (i2 == 0) {
            bVar.a();
        } else if (i2 == 1) {
            bVar.c();
        }
        super.handleMessage(message);
    }
}
