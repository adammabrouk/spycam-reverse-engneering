package i;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource.java */
/* loaded from: classes.dex */
public final class j implements s {

    /* renamed from: b, reason: collision with root package name */
    public final e f11825b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f11826c;

    /* renamed from: d, reason: collision with root package name */
    public final k f11827d;

    /* renamed from: a, reason: collision with root package name */
    public int f11824a = 0;

    /* renamed from: e, reason: collision with root package name */
    public final CRC32 f11828e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f11826c = new Inflater(true);
        e a2 = l.a(sVar);
        this.f11825b = a2;
        this.f11827d = new k(a2, this.f11826c);
    }

    public final void a() throws IOException {
        this.f11825b.g(10L);
        byte a2 = this.f11825b.d().a(3L);
        boolean z = ((a2 >> 1) & 1) == 1;
        if (z) {
            a(this.f11825b.d(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f11825b.readShort());
        this.f11825b.skip(8L);
        if (((a2 >> 2) & 1) == 1) {
            this.f11825b.g(2L);
            if (z) {
                a(this.f11825b.d(), 0L, 2L);
            }
            long p = this.f11825b.d().p();
            this.f11825b.g(p);
            if (z) {
                a(this.f11825b.d(), 0L, p);
            }
            this.f11825b.skip(p);
        }
        if (((a2 >> 3) & 1) == 1) {
            long a3 = this.f11825b.a((byte) 0);
            if (a3 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f11825b.d(), 0L, a3 + 1);
            }
            this.f11825b.skip(a3 + 1);
        }
        if (((a2 >> 4) & 1) == 1) {
            long a4 = this.f11825b.a((byte) 0);
            if (a4 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f11825b.d(), 0L, a4 + 1);
            }
            this.f11825b.skip(a4 + 1);
        }
        if (z) {
            a("FHCRC", this.f11825b.p(), (short) this.f11828e.getValue());
            this.f11828e.reset();
        }
    }

    public final void b() throws IOException {
        a("CRC", this.f11825b.j(), (int) this.f11828e.getValue());
        a("ISIZE", this.f11825b.j(), (int) this.f11826c.getBytesWritten());
    }

    @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f11827d.close();
    }

    @Override // i.s
    public long read(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f11824a == 0) {
            a();
            this.f11824a = 1;
        }
        if (this.f11824a == 1) {
            long j2 = cVar.f11820b;
            long read = this.f11827d.read(cVar, j);
            if (read != -1) {
                a(cVar, j2, read);
                return read;
            }
            this.f11824a = 2;
        }
        if (this.f11824a == 2) {
            b();
            this.f11824a = 3;
            if (!this.f11825b.k()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // i.s
    public t timeout() {
        return this.f11825b.timeout();
    }

    public final void a(c cVar, long j, long j2) {
        o oVar = cVar.f11819a;
        while (true) {
            int i2 = oVar.f11847c;
            int i3 = oVar.f11846b;
            if (j < i2 - i3) {
                break;
            }
            j -= i2 - i3;
            oVar = oVar.f11850f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(oVar.f11847c - r7, j2);
            this.f11828e.update(oVar.f11845a, (int) (oVar.f11846b + j), min);
            j2 -= min;
            oVar = oVar.f11850f;
            j = 0;
        }
    }

    public final void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }
}
