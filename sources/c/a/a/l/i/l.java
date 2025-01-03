package c.a.a.l.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3119a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f3120b = new Handler(Looper.getMainLooper(), new b());

    /* compiled from: ResourceRecycler.java */
    public static class b implements Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((k) message.obj).a();
            return true;
        }
    }

    public void a(k<?> kVar) {
        c.a.a.r.h.a();
        if (this.f3119a) {
            this.f3120b.obtainMessage(1, kVar).sendToTarget();
            return;
        }
        this.f3119a = true;
        kVar.a();
        this.f3119a = false;
    }
}
