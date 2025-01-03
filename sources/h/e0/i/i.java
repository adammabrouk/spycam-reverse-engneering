package h.e0.i;

import i.r;
import i.s;
import i.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Http2Stream.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public long f11612b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11613c;

    /* renamed from: d, reason: collision with root package name */
    public final g f11614d;

    /* renamed from: e, reason: collision with root package name */
    public List<h.e0.i.c> f11615e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11616f;

    /* renamed from: g, reason: collision with root package name */
    public final b f11617g;

    /* renamed from: h, reason: collision with root package name */
    public final a f11618h;

    /* renamed from: a, reason: collision with root package name */
    public long f11611a = 0;

    /* renamed from: i, reason: collision with root package name */
    public final c f11619i = new c();
    public final c j = new c();
    public h.e0.i.b k = null;

    /* compiled from: Http2Stream.java */
    public final class b implements s {

        /* renamed from: a, reason: collision with root package name */
        public final i.c f11624a = new i.c();

        /* renamed from: b, reason: collision with root package name */
        public final i.c f11625b = new i.c();

        /* renamed from: c, reason: collision with root package name */
        public final long f11626c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11627d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11628e;

        public b(long j) {
            this.f11626c = j;
        }

        public final void a(long j) {
            i.this.f11614d.a(j);
        }

        @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long g2;
            synchronized (i.this) {
                this.f11627d = true;
                g2 = this.f11625b.g();
                this.f11625b.a();
                i.this.notifyAll();
            }
            if (g2 > 0) {
                a(g2);
            }
            i.this.a();
        }

        @Override // i.s
        public long read(i.c cVar, long j) throws IOException {
            h.e0.i.b bVar;
            long j2;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (i.this) {
                a();
                if (this.f11627d) {
                    throw new IOException("stream closed");
                }
                bVar = i.this.k;
                if (this.f11625b.g() > 0) {
                    j2 = this.f11625b.read(cVar, Math.min(j, this.f11625b.g()));
                    i.this.f11611a += j2;
                } else {
                    j2 = -1;
                }
                if (bVar == null && i.this.f11611a >= i.this.f11614d.n.c() / 2) {
                    i.this.f11614d.a(i.this.f11613c, i.this.f11611a);
                    i.this.f11611a = 0L;
                }
            }
            if (j2 != -1) {
                a(j2);
                return j2;
            }
            if (bVar == null) {
                return -1L;
            }
            throw new n(bVar);
        }

        @Override // i.s
        public t timeout() {
            return i.this.f11619i;
        }

        public final void a() throws IOException {
            i.this.f11619i.g();
            while (this.f11625b.g() == 0 && !this.f11628e && !this.f11627d && i.this.k == null) {
                try {
                    i.this.k();
                } finally {
                    i.this.f11619i.k();
                }
            }
        }

        public void a(i.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (i.this) {
                    z = this.f11628e;
                    z2 = true;
                    z3 = this.f11625b.g() + j > this.f11626c;
                }
                if (z3) {
                    eVar.skip(j);
                    i.this.c(h.e0.i.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.skip(j);
                    return;
                }
                long read = eVar.read(this.f11624a, j);
                if (read != -1) {
                    j -= read;
                    synchronized (i.this) {
                        if (this.f11625b.g() != 0) {
                            z2 = false;
                        }
                        this.f11625b.a(this.f11624a);
                        if (z2) {
                            i.this.notifyAll();
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }
    }

    /* compiled from: Http2Stream.java */
    public class c extends i.a {
        public c() {
        }

        @Override // i.a
        public IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // i.a
        public void i() {
            i.this.c(h.e0.i.b.CANCEL);
        }

        public void k() throws IOException {
            if (h()) {
                throw b((IOException) null);
            }
        }
    }

    public i(int i2, g gVar, boolean z, boolean z2, List<h.e0.i.c> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f11613c = i2;
        this.f11614d = gVar;
        this.f11612b = gVar.o.c();
        this.f11617g = new b(gVar.n.c());
        a aVar = new a();
        this.f11618h = aVar;
        this.f11617g.f11628e = z2;
        aVar.f11622c = z;
    }

    public void a(h.e0.i.b bVar) throws IOException {
        if (b(bVar)) {
            this.f11614d.b(this.f11613c, bVar);
        }
    }

    public final boolean b(h.e0.i.b bVar) {
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.f11617g.f11628e && this.f11618h.f11622c) {
                return false;
            }
            this.k = bVar;
            notifyAll();
            this.f11614d.c(this.f11613c);
            return true;
        }
    }

    public int c() {
        return this.f11613c;
    }

    public r d() {
        synchronized (this) {
            if (!this.f11616f && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f11618h;
    }

    public s e() {
        return this.f11617g;
    }

    public boolean f() {
        return this.f11614d.f11550a == ((this.f11613c & 1) == 1);
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f11617g.f11628e || this.f11617g.f11627d) && (this.f11618h.f11622c || this.f11618h.f11621b)) {
            if (this.f11616f) {
                return false;
            }
        }
        return true;
    }

    public t h() {
        return this.f11619i;
    }

    public void i() {
        boolean g2;
        synchronized (this) {
            this.f11617g.f11628e = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f11614d.c(this.f11613c);
    }

    public synchronized List<h.e0.i.c> j() throws IOException {
        List<h.e0.i.c> list;
        if (!f()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.f11619i.g();
        while (this.f11615e == null && this.k == null) {
            try {
                k();
            } catch (Throwable th) {
                this.f11619i.k();
                throw th;
            }
        }
        this.f11619i.k();
        list = this.f11615e;
        if (list == null) {
            throw new n(this.k);
        }
        this.f11615e = null;
        return list;
    }

    public void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public t l() {
        return this.j;
    }

    public void c(h.e0.i.b bVar) {
        if (b(bVar)) {
            this.f11614d.c(this.f11613c, bVar);
        }
    }

    /* compiled from: Http2Stream.java */
    public final class a implements r {

        /* renamed from: a, reason: collision with root package name */
        public final i.c f11620a = new i.c();

        /* renamed from: b, reason: collision with root package name */
        public boolean f11621b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11622c;

        public a() {
        }

        @Override // i.r
        public void a(i.c cVar, long j) throws IOException {
            this.f11620a.a(cVar, j);
            while (this.f11620a.g() >= 16384) {
                a(false);
            }
        }

        @Override // i.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                if (this.f11621b) {
                    return;
                }
                if (!i.this.f11618h.f11622c) {
                    if (this.f11620a.g() > 0) {
                        while (this.f11620a.g() > 0) {
                            a(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.f11614d.a(iVar.f11613c, true, (i.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.f11621b = true;
                }
                i.this.f11614d.flush();
                i.this.a();
            }
        }

        @Override // i.r, java.io.Flushable
        public void flush() throws IOException {
            synchronized (i.this) {
                i.this.b();
            }
            while (this.f11620a.g() > 0) {
                a(false);
                i.this.f11614d.flush();
            }
        }

        @Override // i.r
        public t timeout() {
            return i.this.j;
        }

        public final void a(boolean z) throws IOException {
            long min;
            synchronized (i.this) {
                i.this.j.g();
                while (i.this.f11612b <= 0 && !this.f11622c && !this.f11621b && i.this.k == null) {
                    try {
                        i.this.k();
                    } finally {
                    }
                }
                i.this.j.k();
                i.this.b();
                min = Math.min(i.this.f11612b, this.f11620a.g());
                i.this.f11612b -= min;
            }
            i.this.j.g();
            try {
                i.this.f11614d.a(i.this.f11613c, z && min == this.f11620a.g(), this.f11620a, min);
            } finally {
            }
        }
    }

    public void a(List<h.e0.i.c> list) {
        boolean z;
        synchronized (this) {
            z = true;
            this.f11616f = true;
            if (this.f11615e == null) {
                this.f11615e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f11615e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f11615e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f11614d.c(this.f11613c);
    }

    public synchronized void d(h.e0.i.b bVar) {
        if (this.k == null) {
            this.k = bVar;
            notifyAll();
        }
    }

    public void b() throws IOException {
        a aVar = this.f11618h;
        if (!aVar.f11621b) {
            if (!aVar.f11622c) {
                if (this.k != null) {
                    throw new n(this.k);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public void a(i.e eVar, int i2) throws IOException {
        this.f11617g.a(eVar, i2);
    }

    public void a() throws IOException {
        boolean z;
        boolean g2;
        synchronized (this) {
            z = !this.f11617g.f11628e && this.f11617g.f11627d && (this.f11618h.f11622c || this.f11618h.f11621b);
            g2 = g();
        }
        if (z) {
            a(h.e0.i.b.CANCEL);
        } else {
            if (g2) {
                return;
            }
            this.f11614d.c(this.f11613c);
        }
    }

    public void a(long j) {
        this.f11612b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
