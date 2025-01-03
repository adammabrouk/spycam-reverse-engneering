package c.j.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Worker.java */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6667a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public Context f6668b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f6669c;

    /* compiled from: Worker.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            x.this.b(message);
        }
    }

    public x() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f6669c = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f6668b = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f6667a) {
            if (this.f6669c == null) {
                String str = "Dead worker dropping a message: " + message.what;
                c.j.a.z.v.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                this.f6669c.sendMessage(message);
            }
        }
    }
}
