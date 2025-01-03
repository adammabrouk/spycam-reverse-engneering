package c.c.a.c.y;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    public static d f5732e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f5733a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f5734b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    public c f5735c;

    /* renamed from: d, reason: collision with root package name */
    public c f5736d;

    /* compiled from: SnackbarManager.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            d.this.a((c) message.obj);
            return true;
        }
    }

    /* compiled from: SnackbarManager.java */
    public interface b {
        void a(int i2);
    }

    /* compiled from: SnackbarManager.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f5738a;

        /* renamed from: b, reason: collision with root package name */
        public int f5739b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f5740c;

        public boolean a(b bVar) {
            return bVar != null && this.f5738a.get() == bVar;
        }
    }

    public static d a() {
        if (f5732e == null) {
            f5732e = new d();
        }
        return f5732e;
    }

    public void b(b bVar) {
        synchronized (this.f5733a) {
            if (a(bVar) && !this.f5735c.f5740c) {
                this.f5735c.f5740c = true;
                this.f5734b.removeCallbacksAndMessages(this.f5735c);
            }
        }
    }

    public void c(b bVar) {
        synchronized (this.f5733a) {
            if (a(bVar) && this.f5735c.f5740c) {
                this.f5735c.f5740c = false;
                b(this.f5735c);
            }
        }
    }

    public final boolean a(c cVar, int i2) {
        b bVar = cVar.f5738a.get();
        if (bVar == null) {
            return false;
        }
        this.f5734b.removeCallbacksAndMessages(cVar);
        bVar.a(i2);
        return true;
    }

    public final void b(c cVar) {
        int i2 = cVar.f5739b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? 1500 : 2750;
        }
        this.f5734b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f5734b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    public final boolean a(b bVar) {
        c cVar = this.f5735c;
        return cVar != null && cVar.a(bVar);
    }

    public void a(c cVar) {
        synchronized (this.f5733a) {
            if (this.f5735c == cVar || this.f5736d == cVar) {
                a(cVar, 2);
            }
        }
    }
}
