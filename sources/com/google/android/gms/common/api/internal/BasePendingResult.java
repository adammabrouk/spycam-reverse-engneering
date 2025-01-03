package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import c.c.a.b.c.l.h;
import c.c.a.b.c.l.i;
import c.c.a.b.c.l.j;
import c.c.a.b.c.l.k;
import c.c.a.b.c.l.m.b0;
import c.c.a.b.c.l.m.h0;
import c.c.a.b.c.o.r;
import c.c.a.b.f.b.e;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends j> extends h<R> {

    /* renamed from: e, reason: collision with root package name */
    public k<? super R> f10043e;

    /* renamed from: g, reason: collision with root package name */
    public R f10045g;

    /* renamed from: h, reason: collision with root package name */
    public Status f10046h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f10047i;
    public boolean j;
    public boolean k;

    @KeepName
    public b mResultGuardian;

    /* renamed from: a, reason: collision with root package name */
    public final Object f10039a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final CountDownLatch f10041c = new CountDownLatch(1);

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<h.a> f10042d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference<b0> f10044f = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    public final a<R> f10040b = new a<>(Looper.getMainLooper());

    public static class a<R extends j> extends e {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(k<? super R> kVar, R r) {
            sendMessage(obtainMessage(1, new Pair(kVar, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    ((BasePendingResult) message.obj).b(Status.f10033f);
                    return;
                }
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            k kVar = (k) pair.first;
            j jVar = (j) pair.second;
            try {
                kVar.a(jVar);
            } catch (RuntimeException e2) {
                BasePendingResult.c(jVar);
                throw e2;
            }
        }
    }

    public final class b {
        public b() {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.c(BasePendingResult.this.f10045g);
            super.finalize();
        }

        public /* synthetic */ b(BasePendingResult basePendingResult, h0 h0Var) {
            this();
        }
    }

    static {
        new h0();
    }

    @Deprecated
    public BasePendingResult() {
        new WeakReference(null);
    }

    public static void c(j jVar) {
        if (jVar instanceof i) {
            try {
                ((i) jVar).a();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(jVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    public abstract R a(Status status);

    public final void a(R r) {
        synchronized (this.f10039a) {
            if (this.k || this.j) {
                c(r);
                return;
            }
            b();
            boolean z = true;
            r.b(!b(), "Results have already been set");
            if (this.f10047i) {
                z = false;
            }
            r.b(z, "Result has already been consumed");
            b((BasePendingResult<R>) r);
        }
    }

    public final boolean b() {
        return this.f10041c.getCount() == 0;
    }

    public final void b(Status status) {
        synchronized (this.f10039a) {
            if (!b()) {
                a((BasePendingResult<R>) a(status));
                this.k = true;
            }
        }
    }

    public final void b(R r) {
        this.f10045g = r;
        this.f10041c.countDown();
        this.f10046h = this.f10045g.m();
        h0 h0Var = null;
        if (this.j) {
            this.f10043e = null;
        } else if (this.f10043e == null) {
            if (this.f10045g instanceof i) {
                this.mResultGuardian = new b(this, h0Var);
            }
        } else {
            this.f10040b.removeMessages(2);
            this.f10040b.a(this.f10043e, a());
        }
        ArrayList<h.a> arrayList = this.f10042d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            h.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.f10046h);
        }
        this.f10042d.clear();
    }

    public final R a() {
        R r;
        synchronized (this.f10039a) {
            r.b(!this.f10047i, "Result has already been consumed.");
            r.b(b(), "Result is not ready.");
            r = this.f10045g;
            this.f10045g = null;
            this.f10043e = null;
            this.f10047i = true;
        }
        b0 andSet = this.f10044f.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }
}
