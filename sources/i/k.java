package i;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.java */
/* loaded from: classes.dex */
public final class k implements s {

    /* renamed from: a, reason: collision with root package name */
    public final e f11829a;

    /* renamed from: b, reason: collision with root package name */
    public final Inflater f11830b;

    /* renamed from: c, reason: collision with root package name */
    public int f11831c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11832d;

    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f11829a = eVar;
        this.f11830b = inflater;
    }

    public boolean a() throws IOException {
        if (!this.f11830b.needsInput()) {
            return false;
        }
        b();
        if (this.f11830b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f11829a.k()) {
            return true;
        }
        o oVar = this.f11829a.d().f11819a;
        int i2 = oVar.f11847c;
        int i3 = oVar.f11846b;
        int i4 = i2 - i3;
        this.f11831c = i4;
        this.f11830b.setInput(oVar.f11845a, i3, i4);
        return false;
    }

    public final void b() throws IOException {
        int i2 = this.f11831c;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f11830b.getRemaining();
        this.f11831c -= remaining;
        this.f11829a.skip(remaining);
    }

    @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f11832d) {
            return;
        }
        this.f11830b.end();
        this.f11832d = true;
        this.f11829a.close();
    }

    @Override // i.s
    public long read(c cVar, long j) throws IOException {
        boolean a2;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f11832d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            a2 = a();
            try {
                o b2 = cVar.b(1);
                int inflate = this.f11830b.inflate(b2.f11845a, b2.f11847c, (int) Math.min(j, 8192 - b2.f11847c));
                if (inflate > 0) {
                    b2.f11847c += inflate;
                    long j2 = inflate;
                    cVar.f11820b += j2;
                    return j2;
                }
                if (!this.f11830b.finished() && !this.f11830b.needsDictionary()) {
                }
                b();
                if (b2.f11846b != b2.f11847c) {
                    return -1L;
                }
                cVar.f11819a = b2.b();
                p.a(b2);
                return -1L;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!a2);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // i.s
    public t timeout() {
        return this.f11829a.timeout();
    }
}
