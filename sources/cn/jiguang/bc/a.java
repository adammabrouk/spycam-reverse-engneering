package cn.jiguang.bc;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: classes.dex */
public abstract class a implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public SocketChannel f8662b;

    /* renamed from: c, reason: collision with root package name */
    public int f8663c;

    /* renamed from: d, reason: collision with root package name */
    public Selector f8664d;

    /* renamed from: f, reason: collision with root package name */
    public int f8666f = 20;

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f8661a = ByteBuffer.allocate(49152);

    /* renamed from: e, reason: collision with root package name */
    public boolean f8665e = false;

    public int a(String str, int i2) {
        if (this.f8661a == null) {
            this.f8661a = ByteBuffer.allocate(49152);
        }
        this.f8661a.clear();
        this.f8663c = 0;
        this.f8665e = true;
        return 0;
    }

    public abstract int a(byte[] bArr);

    public ByteBuffer a() {
        return a(0);
    }

    public abstract ByteBuffer a(int i2);

    public ByteBuffer b(int i2) {
        int i3 = this.f8663c;
        if (i3 < i2) {
            return null;
        }
        this.f8663c = i3 - i2;
        byte[] bArr = new byte[i2];
        this.f8661a.flip();
        this.f8661a.get(bArr, 0, i2);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f8661a.compact();
        return wrap;
    }

    public boolean b() {
        SocketChannel socketChannel;
        return this.f8665e && (socketChannel = this.f8662b) != null && socketChannel.isConnected();
    }

    public int c() {
        if (this.f8663c < this.f8666f) {
            return 0;
        }
        int position = this.f8661a.position();
        this.f8661a.position(0);
        int i2 = this.f8661a.getShort() & Short.MAX_VALUE;
        this.f8661a.position(position);
        return i2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8665e = false;
        ByteBuffer byteBuffer = this.f8661a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f8663c = 0;
    }
}
