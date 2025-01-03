package cn.jiguang.bd;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.as.d;
import cn.jiguang.az.h;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f8671a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8672b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f8673c = false;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap<Integer, cn.jiguang.bd.a> f8674d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public Handler f8675e;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f8676f;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                cn.jiguang.bd.a aVar = (cn.jiguang.bd.a) b.this.f8674d.get(Integer.valueOf(message.what));
                if (aVar != null) {
                    aVar.a(message);
                    if (aVar.f8670c == 1) {
                        sendEmptyMessageDelayed(message.what, h.a().f() * 1000);
                    } else {
                        b.this.f8674d.remove(Integer.valueOf(message.what));
                    }
                } else {
                    d.g("TaskHandlerManager_xxx", "miss task:" + message.what);
                }
            } catch (Throwable th) {
                d.g("TaskHandlerManager_xxx", "handleMessage,e:" + th);
            }
        }
    }

    public static b a() {
        if (f8671a == null) {
            synchronized (f8672b) {
                if (f8671a == null) {
                    f8671a = new b();
                }
            }
        }
        return f8671a;
    }

    public void a(int i2, long j, cn.jiguang.bd.a aVar) {
        if (this.f8675e == null) {
            return;
        }
        aVar.f8669b = j;
        aVar.f8670c = 1;
        this.f8674d.put(Integer.valueOf(i2), aVar);
        if (this.f8675e.hasMessages(i2)) {
            d.g("TaskHandlerManager_xxx", "registerFixedAction,same action in handler,will replace");
            this.f8675e.removeMessages(i2);
        }
        this.f8675e.sendEmptyMessageDelayed(i2, j);
    }

    public synchronized void a(Context context) {
        if (this.f8673c) {
            return;
        }
        if (context == null) {
            d.c("TaskHandlerManager_xxx", "init context is null");
            return;
        }
        d.c("TaskHandlerManager_xxx", "init task manager...");
        try {
            if (this.f8676f == null || !this.f8676f.isAlive()) {
                HandlerThread handlerThread = new HandlerThread("jg_tsk_thread") { // from class: cn.jiguang.bd.b.1
                    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            super.run();
                        } catch (RuntimeException e2) {
                            d.i("TaskHandlerManager_xxx", "handler thread run e:" + e2 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                        }
                    }
                };
                this.f8676f = handlerThread;
                handlerThread.start();
            }
            this.f8675e = new a(this.f8676f.getLooper() == null ? Looper.getMainLooper() : this.f8676f.getLooper());
        } catch (Exception unused) {
            this.f8675e = new a(Looper.getMainLooper());
        }
        this.f8673c = true;
    }

    public boolean a(int i2) {
        Handler handler = this.f8675e;
        if (handler == null) {
            return false;
        }
        return handler.hasMessages(i2);
    }

    public void b(int i2) {
        if (this.f8675e == null) {
            return;
        }
        this.f8674d.remove(Integer.valueOf(i2));
        this.f8675e.removeMessages(i2);
    }

    public void b(int i2, long j, cn.jiguang.bd.a aVar) {
        if (this.f8675e == null) {
            return;
        }
        aVar.f8670c = 2;
        this.f8674d.put(Integer.valueOf(i2), aVar);
        if (this.f8675e.hasMessages(i2)) {
            d.c("TaskHandlerManager_xxx", "sendMsg,replace:" + i2);
            this.f8675e.removeMessages(i2);
        } else {
            d.c("TaskHandlerManager_xxx", "sendMsg,action=" + i2);
        }
        this.f8675e.sendEmptyMessageDelayed(i2, j);
    }
}
