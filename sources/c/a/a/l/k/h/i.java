package c.a.a.l.k.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import c.a.a.j.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: GifResourceDecoder.java */
/* loaded from: classes.dex */
public class i implements c.a.a.l.e<InputStream, c.a.a.l.k.h.b> {

    /* renamed from: f, reason: collision with root package name */
    public static final b f3322f = new b();

    /* renamed from: g, reason: collision with root package name */
    public static final a f3323g = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Context f3324a;

    /* renamed from: b, reason: collision with root package name */
    public final b f3325b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a.a.l.i.m.c f3326c;

    /* renamed from: d, reason: collision with root package name */
    public final a f3327d;

    /* renamed from: e, reason: collision with root package name */
    public final c.a.a.l.k.h.a f3328e;

    public i(Context context, c.a.a.l.i.m.c cVar) {
        this(context, cVar, f3322f, f3323g);
    }

    @Override // c.a.a.l.e
    public String c() {
        return "";
    }

    public i(Context context, c.a.a.l.i.m.c cVar, b bVar, a aVar) {
        this.f3324a = context;
        this.f3326c = cVar;
        this.f3327d = aVar;
        this.f3328e = new c.a.a.l.k.h.a(cVar);
        this.f3325b = bVar;
    }

    @Override // c.a.a.l.e
    public d a(InputStream inputStream, int i2, int i3) {
        byte[] a2 = a(inputStream);
        c.a.a.j.d a3 = this.f3325b.a(a2);
        c.a.a.j.a a4 = this.f3327d.a(this.f3328e);
        try {
            return a(a2, i2, i3, a3, a4);
        } finally {
            this.f3325b.a(a3);
            this.f3327d.a(a4);
        }
    }

    /* compiled from: GifResourceDecoder.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<c.a.a.j.a> f3329a = c.a.a.r.h.a(0);

        public synchronized c.a.a.j.a a(a.InterfaceC0063a interfaceC0063a) {
            c.a.a.j.a poll;
            poll = this.f3329a.poll();
            if (poll == null) {
                poll = new c.a.a.j.a(interfaceC0063a);
            }
            return poll;
        }

        public synchronized void a(c.a.a.j.a aVar) {
            aVar.b();
            this.f3329a.offer(aVar);
        }
    }

    /* compiled from: GifResourceDecoder.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<c.a.a.j.d> f3330a = c.a.a.r.h.a(0);

        public synchronized c.a.a.j.d a(byte[] bArr) {
            c.a.a.j.d poll;
            poll = this.f3330a.poll();
            if (poll == null) {
                poll = new c.a.a.j.d();
            }
            poll.a(bArr);
            return poll;
        }

        public synchronized void a(c.a.a.j.d dVar) {
            dVar.a();
            this.f3330a.offer(dVar);
        }
    }

    public final d a(byte[] bArr, int i2, int i3, c.a.a.j.d dVar, c.a.a.j.a aVar) {
        Bitmap a2;
        c.a.a.j.c c2 = dVar.c();
        if (c2.a() <= 0 || c2.b() != 0 || (a2 = a(aVar, c2, bArr)) == null) {
            return null;
        }
        return new d(new c.a.a.l.k.h.b(this.f3324a, this.f3328e, this.f3326c, c.a.a.l.k.d.a(), i2, i3, c2, bArr, a2));
    }

    public final Bitmap a(c.a.a.j.a aVar, c.a.a.j.c cVar, byte[] bArr) {
        aVar.a(cVar, bArr);
        aVar.a();
        return aVar.h();
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e2) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e2);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
