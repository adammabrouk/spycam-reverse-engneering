package h.e0.i;

import com.shix.shixipc.utilcode.ThreadUtils;
import h.e0.i.d;
import i.s;
import i.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Reader.java */
/* loaded from: classes.dex */
public final class h implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f11600e = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final i.e f11601a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11602b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11603c;

    /* renamed from: d, reason: collision with root package name */
    public final d.a f11604d;

    /* compiled from: Http2Reader.java */
    public static final class a implements s {

        /* renamed from: a, reason: collision with root package name */
        public final i.e f11605a;

        /* renamed from: b, reason: collision with root package name */
        public int f11606b;

        /* renamed from: c, reason: collision with root package name */
        public byte f11607c;

        /* renamed from: d, reason: collision with root package name */
        public int f11608d;

        /* renamed from: e, reason: collision with root package name */
        public int f11609e;

        /* renamed from: f, reason: collision with root package name */
        public short f11610f;

        public a(i.e eVar) {
            this.f11605a = eVar;
        }

        public final void a() throws IOException {
            int i2 = this.f11608d;
            int a2 = h.a(this.f11605a);
            this.f11609e = a2;
            this.f11606b = a2;
            byte readByte = (byte) (this.f11605a.readByte() & ThreadUtils.TYPE_SINGLE);
            this.f11607c = (byte) (this.f11605a.readByte() & ThreadUtils.TYPE_SINGLE);
            if (h.f11600e.isLoggable(Level.FINE)) {
                h.f11600e.fine(e.a(true, this.f11608d, this.f11606b, readByte, this.f11607c));
            }
            int readInt = this.f11605a.readInt() & Integer.MAX_VALUE;
            this.f11608d = readInt;
            if (readByte != 9) {
                e.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            }
            if (readInt == i2) {
                return;
            }
            e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // i.s
        public long read(i.c cVar, long j) throws IOException {
            while (true) {
                int i2 = this.f11609e;
                if (i2 != 0) {
                    long read = this.f11605a.read(cVar, Math.min(j, i2));
                    if (read == -1) {
                        return -1L;
                    }
                    this.f11609e = (int) (this.f11609e - read);
                    return read;
                }
                this.f11605a.skip(this.f11610f);
                this.f11610f = (short) 0;
                if ((this.f11607c & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // i.s
        public t timeout() {
            return this.f11605a.timeout();
        }
    }

    /* compiled from: Http2Reader.java */
    public interface b {
        void a();

        void a(int i2, int i3, int i4, boolean z);

        void a(int i2, int i3, List<c> list) throws IOException;

        void a(int i2, long j);

        void a(int i2, h.e0.i.b bVar);

        void a(int i2, h.e0.i.b bVar, i.f fVar);

        void a(boolean z, int i2, int i3);

        void a(boolean z, int i2, int i3, List<c> list);

        void a(boolean z, int i2, i.e eVar, int i3) throws IOException;

        void a(boolean z, m mVar);
    }

    public h(i.e eVar, boolean z) {
        this.f11601a = eVar;
        this.f11603c = z;
        a aVar = new a(eVar);
        this.f11602b = aVar;
        this.f11604d = new d.a(4096, aVar);
    }

    public void a(b bVar) throws IOException {
        if (this.f11603c) {
            if (a(true, bVar)) {
                return;
            }
            e.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        i.f c2 = this.f11601a.c(e.f11534a.size());
        if (f11600e.isLoggable(Level.FINE)) {
            f11600e.fine(h.e0.c.a("<< CONNECTION %s", c2.hex()));
        }
        if (e.f11534a.equals(c2)) {
            return;
        }
        e.b("Expected a connection header but was %s", c2.utf8());
        throw null;
    }

    public final void b(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        }
        if (i3 != 0) {
            e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int readInt = this.f11601a.readInt();
        int readInt2 = this.f11601a.readInt();
        int i4 = i2 - 8;
        h.e0.i.b fromHttp2 = h.e0.i.b.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        }
        i.f fVar = i.f.EMPTY;
        if (i4 > 0) {
            fVar = this.f11601a.c(i4);
        }
        bVar.a(readInt, fromHttp2, fVar);
    }

    public final void c(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        short readByte = (b2 & 8) != 0 ? (short) (this.f11601a.readByte() & ThreadUtils.TYPE_SINGLE) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i3);
            i2 -= 5;
        }
        bVar.a(z, i3, -1, a(a(i2, b2, readByte), readByte, b2, i3));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f11601a.close();
    }

    public final void d(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 8) {
            e.b("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        }
        if (i3 != 0) {
            e.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        bVar.a((b2 & 1) != 0, this.f11601a.readInt(), this.f11601a.readInt());
    }

    public final void e(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        }
        if (i3 != 0) {
            a(bVar, i3);
        } else {
            e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void f(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short readByte = (b2 & 8) != 0 ? (short) (this.f11601a.readByte() & ThreadUtils.TYPE_SINGLE) : (short) 0;
        bVar.a(i3, this.f11601a.readInt() & Integer.MAX_VALUE, a(a(i2 - 4, b2, readByte), readByte, b2, i3));
    }

    public final void g(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        }
        if (i3 == 0) {
            e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
        int readInt = this.f11601a.readInt();
        h.e0.i.b fromHttp2 = h.e0.i.b.fromHttp2(readInt);
        if (fromHttp2 != null) {
            bVar.a(i3, fromHttp2);
        } else {
            e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        }
    }

    public final void h(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b2 & 1) != 0) {
            if (i2 == 0) {
                bVar.a();
                return;
            } else {
                e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        }
        if (i2 % 6 != 0) {
            e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        }
        m mVar = new m();
        for (int i4 = 0; i4 < i2; i4 += 6) {
            int readShort = this.f11601a.readShort() & 65535;
            int readInt = this.f11601a.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    readShort = 7;
                    if (readInt < 0) {
                        e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    throw null;
                }
            } else if (readInt != 0 && readInt != 1) {
                e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                throw null;
            }
            mVar.a(readShort, readInt);
        }
        bVar.a(false, mVar);
    }

    public final void i(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
            throw null;
        }
        long readInt = this.f11601a.readInt() & 2147483647L;
        if (readInt != 0) {
            bVar.a(i3, readInt);
        } else {
            e.b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.f11601a.g(9L);
            int a2 = a(this.f11601a);
            if (a2 < 0 || a2 > 16384) {
                e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
                throw null;
            }
            byte readByte = (byte) (this.f11601a.readByte() & ThreadUtils.TYPE_SINGLE);
            if (z && readByte != 4) {
                e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.f11601a.readByte() & ThreadUtils.TYPE_SINGLE);
            int readInt = this.f11601a.readInt() & Integer.MAX_VALUE;
            if (f11600e.isLoggable(Level.FINE)) {
                f11600e.fine(e.a(true, readInt, a2, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    a(bVar, a2, readByte2, readInt);
                    return true;
                case 1:
                    c(bVar, a2, readByte2, readInt);
                    return true;
                case 2:
                    e(bVar, a2, readByte2, readInt);
                    return true;
                case 3:
                    g(bVar, a2, readByte2, readInt);
                    return true;
                case 4:
                    h(bVar, a2, readByte2, readInt);
                    return true;
                case 5:
                    f(bVar, a2, readByte2, readInt);
                    return true;
                case 6:
                    d(bVar, a2, readByte2, readInt);
                    return true;
                case 7:
                    b(bVar, a2, readByte2, readInt);
                    return true;
                case 8:
                    i(bVar, a2, readByte2, readInt);
                    return true;
                default:
                    this.f11601a.skip(a2);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public final List<c> a(int i2, short s, byte b2, int i3) throws IOException {
        a aVar = this.f11602b;
        aVar.f11609e = i2;
        aVar.f11606b = i2;
        aVar.f11610f = s;
        aVar.f11607c = b2;
        aVar.f11608d = i3;
        this.f11604d.f();
        return this.f11604d.c();
    }

    public final void a(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if (!((b2 & 32) != 0)) {
            short readByte = (b2 & 8) != 0 ? (short) (this.f11601a.readByte() & ThreadUtils.TYPE_SINGLE) : (short) 0;
            bVar.a(z, i3, this.f11601a, a(i2, b2, readByte));
            this.f11601a.skip(readByte);
            return;
        }
        e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    public final void a(b bVar, int i2) throws IOException {
        int readInt = this.f11601a.readInt();
        bVar.a(i2, readInt & Integer.MAX_VALUE, (this.f11601a.readByte() & ThreadUtils.TYPE_SINGLE) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    public static int a(i.e eVar) throws IOException {
        return (eVar.readByte() & ThreadUtils.TYPE_SINGLE) | ((eVar.readByte() & ThreadUtils.TYPE_SINGLE) << 16) | ((eVar.readByte() & ThreadUtils.TYPE_SINGLE) << 8);
    }

    public static int a(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }
}
