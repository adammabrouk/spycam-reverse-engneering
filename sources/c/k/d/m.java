package c.k.d;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public a f7364a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f7365b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f7366c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7367d;

    /* renamed from: e, reason: collision with root package name */
    public int f7368e;

    /* renamed from: f, reason: collision with root package name */
    public volatile b f7369f;

    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedBlockingQueue<b> f7370a;

        public a() {
            super("PackageProcessor");
            this.f7370a = new LinkedBlockingQueue<>();
        }

        public final void a(int i2, b bVar) {
            try {
                m.this.f7365b.sendMessage(m.this.f7365b.obtainMessage(i2, bVar));
            } catch (Exception e2) {
                c.k.a.a.a.c.a(e2);
            }
        }

        public void a(b bVar) {
            try {
                this.f7370a.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = m.this.f7368e > 0 ? m.this.f7368e : RecyclerView.FOREVER_NS;
            while (!m.this.f7366c) {
                try {
                    b poll = this.f7370a.poll(j, TimeUnit.SECONDS);
                    m.this.f7369f = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (m.this.f7368e > 0) {
                        m.this.a();
                    }
                } catch (InterruptedException e2) {
                    c.k.a.a.a.c.a(e2);
                }
            }
        }
    }

    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public m(boolean z) {
        this(z, 0);
    }

    public m(boolean z, int i2) {
        this.f7365b = null;
        this.f7366c = false;
        this.f7368e = 0;
        this.f7365b = new n(this, Looper.getMainLooper());
        this.f7367d = z;
        this.f7368e = i2;
    }

    public final synchronized void a() {
        this.f7364a = null;
        this.f7366c = true;
    }

    public synchronized void a(b bVar) {
        if (this.f7364a == null) {
            a aVar = new a();
            this.f7364a = aVar;
            aVar.setDaemon(this.f7367d);
            this.f7366c = false;
            this.f7364a.start();
        }
        this.f7364a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f7365b.postDelayed(new o(this, bVar), j);
    }
}
