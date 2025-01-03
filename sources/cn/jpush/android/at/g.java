package cn.jpush.android.at;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static volatile g f9357a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f9358b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f9359c = false;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap<Integer, f> f9360d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public Handler f9361e;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                f fVar = (f) g.this.f9360d.get(Integer.valueOf(message.what));
                if (fVar == null) {
                    cn.jpush.android.r.b.f("InAppTaskHandlerManager", "miss task:" + message.what);
                    return;
                }
                if (fVar.f9356c != 1) {
                    g.this.f9360d.remove(Integer.valueOf(message.what));
                }
                fVar.a(message);
                cn.jpush.android.r.b.b("InAppTaskHandlerManager", "delay message task time up, action: " + message.what + ", actionType: " + fVar.f9356c + ", hbTime: " + c.a().c());
                if (fVar.f9356c == 1) {
                    cn.jpush.android.r.b.b("InAppTaskHandlerManager", "delay message task time up, send next delay task, hbTime: " + c.a().c());
                    sendEmptyMessageDelayed(message.what, ((long) c.a().c()) * 1000);
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppTaskHandlerManager", "handleMessage,e:" + th);
            }
        }
    }

    public static g a() {
        if (f9357a == null) {
            synchronized (f9358b) {
                if (f9357a == null) {
                    f9357a = new g();
                }
            }
        }
        return f9357a;
    }

    public void a(int i2, long j, f fVar) {
        if (this.f9361e == null) {
            return;
        }
        cn.jpush.android.r.b.b("InAppTaskHandlerManager", "send delay hb message task, action: " + i2 + ", time: " + j + ", type: 1");
        fVar.f9355b = j;
        fVar.f9356c = 1;
        this.f9360d.put(Integer.valueOf(i2), fVar);
        if (this.f9361e.hasMessages(i2)) {
            cn.jpush.android.r.b.f("InAppTaskHandlerManager", "registerFixedAction,same action in handler,will replace");
            this.f9361e.removeMessages(i2);
        }
        this.f9361e.sendEmptyMessageDelayed(i2, j);
    }

    public synchronized void b() {
        if (this.f9359c) {
            return;
        }
        cn.jpush.android.r.b.b("InAppTaskHandlerManager", "init task manager...");
        try {
            this.f9361e = new a(Looper.getMainLooper());
        } catch (Exception unused) {
            this.f9361e = new a(Looper.getMainLooper());
        }
        this.f9359c = true;
    }

    public void b(int i2, long j, f fVar) {
        if (this.f9361e == null) {
            return;
        }
        fVar.f9356c = 2;
        this.f9360d.put(Integer.valueOf(i2), fVar);
        if (this.f9361e.hasMessages(i2)) {
            cn.jpush.android.r.b.b("InAppTaskHandlerManager", "sendMsg,replace:" + i2);
            this.f9361e.removeMessages(i2);
        } else {
            cn.jpush.android.r.b.b("InAppTaskHandlerManager", "sendMsg,action=" + i2);
        }
        this.f9361e.sendEmptyMessageDelayed(i2, j);
    }
}
