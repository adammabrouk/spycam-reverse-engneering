package c.a.a.l.k.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import c.a.a.h;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final c f3306a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.j.a f3307b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f3308c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3309d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3310e;

    /* renamed from: f, reason: collision with root package name */
    public c.a.a.c<c.a.a.j.a, c.a.a.j.a, Bitmap, Bitmap> f3311f;

    /* renamed from: g, reason: collision with root package name */
    public b f3312g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3313h;

    /* compiled from: GifFrameLoader.java */
    public static class b extends c.a.a.p.h.g<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        public final Handler f3314d;

        /* renamed from: e, reason: collision with root package name */
        public final int f3315e;

        /* renamed from: f, reason: collision with root package name */
        public final long f3316f;

        /* renamed from: g, reason: collision with root package name */
        public Bitmap f3317g;

        public b(Handler handler, int i2, long j) {
            this.f3314d = handler;
            this.f3315e = i2;
            this.f3316f = j;
        }

        public Bitmap g() {
            return this.f3317g;
        }

        @Override // c.a.a.p.h.j
        public /* bridge */ /* synthetic */ void a(Object obj, c.a.a.p.g.c cVar) {
            a((Bitmap) obj, (c.a.a.p.g.c<? super Bitmap>) cVar);
        }

        public void a(Bitmap bitmap, c.a.a.p.g.c<? super Bitmap> cVar) {
            this.f3317g = bitmap;
            this.f3314d.sendMessageAtTime(this.f3314d.obtainMessage(1, this), this.f3316f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    public interface c {
        void a(int i2);
    }

    /* compiled from: GifFrameLoader.java */
    public class d implements Handler.Callback {
        public d() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                f.this.a((b) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            c.a.a.e.a((b) message.obj);
            return false;
        }
    }

    /* compiled from: GifFrameLoader.java */
    public static class e implements c.a.a.l.c {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f3319a;

        public e() {
            this(UUID.randomUUID());
        }

        @Override // c.a.a.l.c
        public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // c.a.a.l.c
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return ((e) obj).f3319a.equals(this.f3319a);
            }
            return false;
        }

        @Override // c.a.a.l.c
        public int hashCode() {
            return this.f3319a.hashCode();
        }

        public e(UUID uuid) {
            this.f3319a = uuid;
        }
    }

    public f(Context context, c cVar, c.a.a.j.a aVar, int i2, int i3) {
        this(cVar, aVar, null, a(context, aVar, i2, i3, c.a.a.e.a(context).b()));
    }

    public void a(c.a.a.l.g<Bitmap> gVar) {
        if (gVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f3311f = this.f3311f.a(gVar);
    }

    public Bitmap b() {
        b bVar = this.f3312g;
        if (bVar != null) {
            return bVar.g();
        }
        return null;
    }

    public final void c() {
        if (!this.f3309d || this.f3310e) {
            return;
        }
        this.f3310e = true;
        this.f3307b.a();
        this.f3311f.a(new e()).b((c.a.a.c<c.a.a.j.a, c.a.a.j.a, Bitmap, Bitmap>) new b(this.f3308c, this.f3307b.c(), SystemClock.uptimeMillis() + this.f3307b.g()));
    }

    public void d() {
        if (this.f3309d) {
            return;
        }
        this.f3309d = true;
        this.f3313h = false;
        c();
    }

    public void e() {
        this.f3309d = false;
    }

    public f(c cVar, c.a.a.j.a aVar, Handler handler, c.a.a.c<c.a.a.j.a, c.a.a.j.a, Bitmap, Bitmap> cVar2) {
        this.f3309d = false;
        this.f3310e = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new d()) : handler;
        this.f3306a = cVar;
        this.f3307b = aVar;
        this.f3308c = handler;
        this.f3311f = cVar2;
    }

    public void a() {
        e();
        b bVar = this.f3312g;
        if (bVar != null) {
            c.a.a.e.a(bVar);
            this.f3312g = null;
        }
        this.f3313h = true;
    }

    public void a(b bVar) {
        if (this.f3313h) {
            this.f3308c.obtainMessage(2, bVar).sendToTarget();
            return;
        }
        b bVar2 = this.f3312g;
        this.f3312g = bVar;
        this.f3306a.a(bVar.f3315e);
        if (bVar2 != null) {
            this.f3308c.obtainMessage(2, bVar2).sendToTarget();
        }
        this.f3310e = false;
        c();
    }

    public static c.a.a.c<c.a.a.j.a, c.a.a.j.a, Bitmap, Bitmap> a(Context context, c.a.a.j.a aVar, int i2, int i3, c.a.a.l.i.m.c cVar) {
        h hVar = new h(cVar);
        g gVar = new g();
        c.a.a.l.b a2 = c.a.a.l.k.a.a();
        c.a.a.d a3 = c.a.a.e.b(context).a(gVar, c.a.a.j.a.class).a((h.c) aVar).a(Bitmap.class);
        a3.a(a2);
        a3.a((c.a.a.l.e) hVar);
        a3.a(true);
        a3.a(c.a.a.l.i.b.NONE);
        a3.a(i2, i3);
        return a3;
    }
}
