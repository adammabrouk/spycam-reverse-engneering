package a.h.g;

import a.h.g.e;
import a.h.g.f;
import android.graphics.Typeface;
import android.os.Handler;

/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final f.c f1019a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f1020b;

    /* compiled from: CallbackWithHandler.java */
    /* renamed from: a.h.g.a$a, reason: collision with other inner class name */
    public class RunnableC0020a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f.c f1021a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f1022b;

        public RunnableC0020a(a aVar, f.c cVar, Typeface typeface) {
            this.f1021a = cVar;
            this.f1022b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1021a.a(this.f1022b);
        }
    }

    /* compiled from: CallbackWithHandler.java */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f.c f1023a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1024b;

        public b(a aVar, f.c cVar, int i2) {
            this.f1023a = cVar;
            this.f1024b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1023a.a(this.f1024b);
        }
    }

    public a(f.c cVar, Handler handler) {
        this.f1019a = cVar;
        this.f1020b = handler;
    }

    public final void a(Typeface typeface) {
        this.f1020b.post(new RunnableC0020a(this, this.f1019a, typeface));
    }

    public final void a(int i2) {
        this.f1020b.post(new b(this, this.f1019a, i2));
    }

    public void a(e.C0021e c0021e) {
        if (c0021e.a()) {
            a(c0021e.f1046a);
        } else {
            a(c0021e.f1047b);
        }
    }
}
