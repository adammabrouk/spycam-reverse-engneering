package h.e0.h;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import h.a0;
import h.b0;
import h.e0.g.h;
import h.e0.g.k;
import h.r;
import h.v;
import h.y;
import i.i;
import i.l;
import i.r;
import i.s;
import i.t;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* compiled from: Http1Codec.java */
/* loaded from: classes.dex */
public final class a implements h.e0.g.c {

    /* renamed from: a, reason: collision with root package name */
    public final v f11482a;

    /* renamed from: b, reason: collision with root package name */
    public final h.e0.f.g f11483b;

    /* renamed from: c, reason: collision with root package name */
    public final i.e f11484c;

    /* renamed from: d, reason: collision with root package name */
    public final i.d f11485d;

    /* renamed from: e, reason: collision with root package name */
    public int f11486e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f11487f = 262144;

    /* compiled from: Http1Codec.java */
    public abstract class b implements s {

        /* renamed from: a, reason: collision with root package name */
        public final i f11488a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11489b;

        /* renamed from: c, reason: collision with root package name */
        public long f11490c;

        public b() {
            this.f11488a = new i(a.this.f11484c.timeout());
            this.f11490c = 0L;
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i2 = aVar.f11486e;
            if (i2 == 6) {
                return;
            }
            if (i2 != 5) {
                throw new IllegalStateException("state: " + a.this.f11486e);
            }
            aVar.a(this.f11488a);
            a aVar2 = a.this;
            aVar2.f11486e = 6;
            h.e0.f.g gVar = aVar2.f11483b;
            if (gVar != null) {
                gVar.a(!z, aVar2, this.f11490c, iOException);
            }
        }

        @Override // i.s
        public long read(i.c cVar, long j) throws IOException {
            try {
                long read = a.this.f11484c.read(cVar, j);
                if (read > 0) {
                    this.f11490c += read;
                }
                return read;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        @Override // i.s
        public t timeout() {
            return this.f11488a;
        }
    }

    /* compiled from: Http1Codec.java */
    public final class c implements r {

        /* renamed from: a, reason: collision with root package name */
        public final i f11492a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11493b;

        public c() {
            this.f11492a = new i(a.this.f11485d.timeout());
        }

        @Override // i.r
        public void a(i.c cVar, long j) throws IOException {
            if (this.f11493b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.f11485d.b(j);
            a.this.f11485d.a("\r\n");
            a.this.f11485d.a(cVar, j);
            a.this.f11485d.a("\r\n");
        }

        @Override // i.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f11493b) {
                return;
            }
            this.f11493b = true;
            a.this.f11485d.a("0\r\n\r\n");
            a.this.a(this.f11492a);
            a.this.f11486e = 3;
        }

        @Override // i.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f11493b) {
                return;
            }
            a.this.f11485d.flush();
        }

        @Override // i.r
        public t timeout() {
            return this.f11492a;
        }
    }

    /* compiled from: Http1Codec.java */
    public class d extends b {

        /* renamed from: e, reason: collision with root package name */
        public final h.s f11495e;

        /* renamed from: f, reason: collision with root package name */
        public long f11496f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f11497g;

        public d(h.s sVar) {
            super();
            this.f11496f = -1L;
            this.f11497g = true;
            this.f11495e = sVar;
        }

        public final void a() throws IOException {
            if (this.f11496f != -1) {
                a.this.f11484c.h();
            }
            try {
                this.f11496f = a.this.f11484c.s();
                String trim = a.this.f11484c.h().trim();
                if (this.f11496f < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f11496f + trim + "\"");
                }
                if (this.f11496f == 0) {
                    this.f11497g = false;
                    h.e0.g.e.a(a.this.f11482a.f(), this.f11495e, a.this.f());
                    a(true, null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f11489b) {
                return;
            }
            if (this.f11497g && !h.e0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f11489b = true;
        }

        @Override // h.e0.h.a.b, i.s
        public long read(i.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f11489b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f11497g) {
                return -1L;
            }
            long j2 = this.f11496f;
            if (j2 == 0 || j2 == -1) {
                a();
                if (!this.f11497g) {
                    return -1L;
                }
            }
            long read = super.read(cVar, Math.min(j, this.f11496f));
            if (read != -1) {
                this.f11496f -= read;
                return read;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, protocolException);
            throw protocolException;
        }
    }

    /* compiled from: Http1Codec.java */
    public final class e implements r {

        /* renamed from: a, reason: collision with root package name */
        public final i f11499a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11500b;

        /* renamed from: c, reason: collision with root package name */
        public long f11501c;

        public e(long j) {
            this.f11499a = new i(a.this.f11485d.timeout());
            this.f11501c = j;
        }

        @Override // i.r
        public void a(i.c cVar, long j) throws IOException {
            if (this.f11500b) {
                throw new IllegalStateException("closed");
            }
            h.e0.c.a(cVar.g(), 0L, j);
            if (j <= this.f11501c) {
                a.this.f11485d.a(cVar, j);
                this.f11501c -= j;
                return;
            }
            throw new ProtocolException("expected " + this.f11501c + " bytes but received " + j);
        }

        @Override // i.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f11500b) {
                return;
            }
            this.f11500b = true;
            if (this.f11501c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.a(this.f11499a);
            a.this.f11486e = 3;
        }

        @Override // i.r, java.io.Flushable
        public void flush() throws IOException {
            if (this.f11500b) {
                return;
            }
            a.this.f11485d.flush();
        }

        @Override // i.r
        public t timeout() {
            return this.f11499a;
        }
    }

    /* compiled from: Http1Codec.java */
    public class f extends b {

        /* renamed from: e, reason: collision with root package name */
        public long f11503e;

        public f(a aVar, long j) throws IOException {
            super();
            this.f11503e = j;
            if (j == 0) {
                a(true, null);
            }
        }

        @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f11489b) {
                return;
            }
            if (this.f11503e != 0 && !h.e0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f11489b = true;
        }

        @Override // h.e0.h.a.b, i.s
        public long read(i.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f11489b) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.f11503e;
            if (j2 == 0) {
                return -1L;
            }
            long read = super.read(cVar, Math.min(j2, j));
            if (read == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
            long j3 = this.f11503e - read;
            this.f11503e = j3;
            if (j3 == 0) {
                a(true, null);
            }
            return read;
        }
    }

    /* compiled from: Http1Codec.java */
    public class g extends b {

        /* renamed from: e, reason: collision with root package name */
        public boolean f11504e;

        public g(a aVar) {
            super();
        }

        @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f11489b) {
                return;
            }
            if (!this.f11504e) {
                a(false, null);
            }
            this.f11489b = true;
        }

        @Override // h.e0.h.a.b, i.s
        public long read(i.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f11489b) {
                throw new IllegalStateException("closed");
            }
            if (this.f11504e) {
                return -1L;
            }
            long read = super.read(cVar, j);
            if (read != -1) {
                return read;
            }
            this.f11504e = true;
            a(true, null);
            return -1L;
        }
    }

    public a(v vVar, h.e0.f.g gVar, i.e eVar, i.d dVar) {
        this.f11482a = vVar;
        this.f11483b = gVar;
        this.f11484c = eVar;
        this.f11485d = dVar;
    }

    @Override // h.e0.g.c
    public r a(y yVar, long j) {
        if ("chunked".equalsIgnoreCase(yVar.a("Transfer-Encoding"))) {
            return c();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // h.e0.g.c
    public void b() throws IOException {
        this.f11485d.flush();
    }

    public r c() {
        if (this.f11486e == 1) {
            this.f11486e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f11486e);
    }

    @Override // h.e0.g.c
    public void cancel() {
        h.e0.f.c c2 = this.f11483b.c();
        if (c2 != null) {
            c2.a();
        }
    }

    public s d() throws IOException {
        if (this.f11486e != 4) {
            throw new IllegalStateException("state: " + this.f11486e);
        }
        h.e0.f.g gVar = this.f11483b;
        if (gVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f11486e = 5;
        gVar.e();
        return new g(this);
    }

    public final String e() throws IOException {
        String e2 = this.f11484c.e(this.f11487f);
        this.f11487f -= e2.length();
        return e2;
    }

    public h.r f() throws IOException {
        r.a aVar = new r.a();
        while (true) {
            String e2 = e();
            if (e2.length() == 0) {
                return aVar.a();
            }
            h.e0.a.f11393a.a(aVar, e2);
        }
    }

    public s b(long j) throws IOException {
        if (this.f11486e == 4) {
            this.f11486e = 5;
            return new f(this, j);
        }
        throw new IllegalStateException("state: " + this.f11486e);
    }

    @Override // h.e0.g.c
    public void a(y yVar) throws IOException {
        a(yVar.c(), h.e0.g.i.a(yVar, this.f11483b.c().e().b().type()));
    }

    @Override // h.e0.g.c
    public b0 a(a0 a0Var) throws IOException {
        h.e0.f.g gVar = this.f11483b;
        gVar.f11451f.e(gVar.f11450e);
        String b2 = a0Var.b(HttpHeaders.CONTENT_TYPE);
        if (!h.e0.g.e.b(a0Var)) {
            return new h(b2, 0L, l.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(a0Var.b("Transfer-Encoding"))) {
            return new h(b2, -1L, l.a(a(a0Var.r().g())));
        }
        long a2 = h.e0.g.e.a(a0Var);
        if (a2 != -1) {
            return new h(b2, a2, l.a(b(a2)));
        }
        return new h(b2, -1L, l.a(d()));
    }

    @Override // h.e0.g.c
    public void a() throws IOException {
        this.f11485d.flush();
    }

    public void a(h.r rVar, String str) throws IOException {
        if (this.f11486e == 0) {
            this.f11485d.a(str).a("\r\n");
            int b2 = rVar.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f11485d.a(rVar.a(i2)).a(": ").a(rVar.b(i2)).a("\r\n");
            }
            this.f11485d.a("\r\n");
            this.f11486e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f11486e);
    }

    @Override // h.e0.g.c
    public a0.a a(boolean z) throws IOException {
        int i2 = this.f11486e;
        if (i2 != 1 && i2 != 3) {
            throw new IllegalStateException("state: " + this.f11486e);
        }
        try {
            k a2 = k.a(e());
            a0.a aVar = new a0.a();
            aVar.a(a2.f11479a);
            aVar.a(a2.f11480b);
            aVar.a(a2.f11481c);
            aVar.a(f());
            if (z && a2.f11480b == 100) {
                return null;
            }
            if (a2.f11480b == 100) {
                this.f11486e = 3;
                return aVar;
            }
            this.f11486e = 4;
            return aVar;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f11483b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public i.r a(long j) {
        if (this.f11486e == 1) {
            this.f11486e = 2;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f11486e);
    }

    public s a(h.s sVar) throws IOException {
        if (this.f11486e == 4) {
            this.f11486e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.f11486e);
    }

    public void a(i iVar) {
        t g2 = iVar.g();
        iVar.a(t.f11854d);
        g2.a();
        g2.b();
    }
}
