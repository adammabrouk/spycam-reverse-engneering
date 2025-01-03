package i;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink.java */
/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11838a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final r f11839b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11840c;

    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f11839b = rVar;
    }

    @Override // i.r
    public void a(c cVar, long j) throws IOException {
        if (this.f11840c) {
            throw new IllegalStateException("closed");
        }
        this.f11838a.a(cVar, j);
        q();
    }

    @Override // i.d
    public d b(long j) throws IOException {
        if (this.f11840c) {
            throw new IllegalStateException("closed");
        }
        this.f11838a.b(j);
        return q();
    }

    @Override // i.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f11840c) {
            return;
        }
        try {
            if (this.f11838a.f11820b > 0) {
                this.f11839b.a(this.f11838a, this.f11838a.f11820b);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f11839b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f11840c = true;
        if (th == null) {
            return;
        }
        u.a(th);
        throw null;
    }

    @Override // i.d
    public c d() {
        return this.f11838a;
    }

    @Override // i.d, i.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.f11840c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f11838a;
        long j = cVar.f11820b;
        if (j > 0) {
            this.f11839b.a(cVar, j);
        }
        this.f11839b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f11840c;
    }

    @Override // i.d
    public d q() throws IOException {
        if (this.f11840c) {
            throw new IllegalStateException("closed");
        }
        long b2 = this.f11838a.b();
        if (b2 > 0) {
            this.f11839b.a(this.f11838a, b2);
        }
        return this;
    }

    @Override // i.r
    public t timeout() {
        return this.f11839b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f11839b + ")";
    }

    @Override // i.d
    public d write(byte[] bArr) throws IOException {
        if (this.f11840c) {
            throw new IllegalStateException("closed");
        }
        this.f11838a.write(bArr);
        q();
        return this;
    }

    @Override // i.d
    public d writeByte(int i2) throws IOException {
        if (this.f11840c) {
            throw new IllegalStateException("closed");
        }
        this.f11838a.writeByte(i2);
        return q();
    }

    @Override // i.d
    public d writeInt(int i2) throws IOException {
        if (this.f11840c) {
            throw new IllegalStateException("closed");
        }
        this.f11838a.writeInt(i2);
        return q();
    }

    @Override // i.d
    public d writeShort(int i2) throws IOException {
        if (this.f11840c) {
            throw new IllegalStateException("closed");
        }
        this.f11838a.writeShort(i2);
        q();
        return this;
    }

    @Override // i.d
    public d a(f fVar) throws IOException {
        if (!this.f11840c) {
            this.f11838a.a(fVar);
            q();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i.d
    public d write(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f11840c) {
            this.f11838a.write(bArr, i2, i3);
            q();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i.d
    public d a(String str) throws IOException {
        if (!this.f11840c) {
            this.f11838a.a(str);
            q();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f11840c) {
            int write = this.f11838a.write(byteBuffer);
            q();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // i.d
    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = sVar.read(this.f11838a, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
            q();
        }
    }
}
