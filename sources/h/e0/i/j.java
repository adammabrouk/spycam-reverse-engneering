package h.e0.i;

import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import h.e0.i.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Writer.java */
/* loaded from: classes.dex */
public final class j implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    public static final Logger f11630g = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final i.d f11631a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11632b;

    /* renamed from: c, reason: collision with root package name */
    public final i.c f11633c;

    /* renamed from: d, reason: collision with root package name */
    public int f11634d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11635e;

    /* renamed from: f, reason: collision with root package name */
    public final d.b f11636f;

    public j(i.d dVar, boolean z) {
        this.f11631a = dVar;
        this.f11632b = z;
        i.c cVar = new i.c();
        this.f11633c = cVar;
        this.f11636f = new d.b(cVar);
        this.f11634d = 16384;
    }

    public synchronized void a() throws IOException {
        if (this.f11635e) {
            throw new IOException("closed");
        }
        if (this.f11632b) {
            if (f11630g.isLoggable(Level.FINE)) {
                f11630g.fine(h.e0.c.a(">> CONNECTION %s", e.f11534a.hex()));
            }
            this.f11631a.write(e.f11534a.toByteArray());
            this.f11631a.flush();
        }
    }

    public int b() {
        return this.f11634d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f11635e = true;
        this.f11631a.close();
    }

    public synchronized void flush() throws IOException {
        if (this.f11635e) {
            throw new IOException("closed");
        }
        this.f11631a.flush();
    }

    public synchronized void b(m mVar) throws IOException {
        if (this.f11635e) {
            throw new IOException("closed");
        }
        int i2 = 0;
        a(0, mVar.d() * 6, (byte) 4, (byte) 0);
        while (i2 < 10) {
            if (mVar.d(i2)) {
                this.f11631a.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                this.f11631a.writeInt(mVar.a(i2));
            }
            i2++;
        }
        this.f11631a.flush();
    }

    public synchronized void a(m mVar) throws IOException {
        if (!this.f11635e) {
            this.f11634d = mVar.c(this.f11634d);
            if (mVar.b() != -1) {
                this.f11636f.b(mVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f11631a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void b(int i2, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f11634d, j);
            long j2 = min;
            j -= j2;
            a(i2, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f11631a.a(this.f11633c, j2);
        }
    }

    public synchronized void a(int i2, int i3, List<c> list) throws IOException {
        if (!this.f11635e) {
            this.f11636f.a(list);
            long g2 = this.f11633c.g();
            int min = (int) Math.min(this.f11634d - 4, g2);
            long j = min;
            a(i2, min + 4, (byte) 5, g2 == j ? (byte) 4 : (byte) 0);
            this.f11631a.writeInt(i3 & Integer.MAX_VALUE);
            this.f11631a.a(this.f11633c, j);
            if (g2 > j) {
                b(i2, g2 - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i2, int i3, List<c> list) throws IOException {
        if (!this.f11635e) {
            a(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, b bVar) throws IOException {
        if (!this.f11635e) {
            if (bVar.httpCode != -1) {
                a(i2, 4, (byte) 3, (byte) 0);
                this.f11631a.writeInt(bVar.httpCode);
                this.f11631a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i2, i.c cVar, int i3) throws IOException {
        if (!this.f11635e) {
            a(i2, z ? (byte) 1 : (byte) 0, cVar, i3);
        } else {
            throw new IOException("closed");
        }
    }

    public void a(int i2, byte b2, i.c cVar, int i3) throws IOException {
        a(i2, i3, (byte) 0, b2);
        if (i3 > 0) {
            this.f11631a.a(cVar, i3);
        }
    }

    public synchronized void a(boolean z, int i2, int i3) throws IOException {
        if (!this.f11635e) {
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f11631a.writeInt(i2);
            this.f11631a.writeInt(i3);
            this.f11631a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, b bVar, byte[] bArr) throws IOException {
        if (!this.f11635e) {
            if (bVar.httpCode != -1) {
                a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f11631a.writeInt(i2);
                this.f11631a.writeInt(bVar.httpCode);
                if (bArr.length > 0) {
                    this.f11631a.write(bArr);
                }
                this.f11631a.flush();
            } else {
                e.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, long j) throws IOException {
        if (this.f11635e) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            a(i2, 4, (byte) 8, (byte) 0);
            this.f11631a.writeInt((int) j);
            this.f11631a.flush();
        } else {
            e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    public void a(int i2, int i3, byte b2, byte b3) throws IOException {
        if (f11630g.isLoggable(Level.FINE)) {
            f11630g.fine(e.a(false, i2, i3, b2, b3));
        }
        int i4 = this.f11634d;
        if (i3 > i4) {
            e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            e.a("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        }
        a(this.f11631a, i3);
        this.f11631a.writeByte(b2 & ThreadUtils.TYPE_SINGLE);
        this.f11631a.writeByte(b3 & ThreadUtils.TYPE_SINGLE);
        this.f11631a.writeInt(i2 & Integer.MAX_VALUE);
    }

    public static void a(i.d dVar, int i2) throws IOException {
        dVar.writeByte((i2 >>> 16) & ViewfinderView.OPAQUE);
        dVar.writeByte((i2 >>> 8) & ViewfinderView.OPAQUE);
        dVar.writeByte(i2 & ViewfinderView.OPAQUE);
    }

    public void a(boolean z, int i2, List<c> list) throws IOException {
        if (!this.f11635e) {
            this.f11636f.a(list);
            long g2 = this.f11633c.g();
            int min = (int) Math.min(this.f11634d, g2);
            long j = min;
            byte b2 = g2 == j ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i2, min, (byte) 1, b2);
            this.f11631a.a(this.f11633c, j);
            if (g2 > j) {
                b(i2, g2 - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
