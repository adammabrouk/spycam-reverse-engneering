package cn.jiguang.ay;

import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public long f8550a;

    /* renamed from: b, reason: collision with root package name */
    public SelectionKey f8551b;

    public o(long j) {
        Selector selector;
        SocketChannel open = SocketChannel.open();
        this.f8550a = j;
        try {
            selector = Selector.open();
        } catch (Throwable th) {
            th = th;
            selector = null;
        }
        try {
            open.configureBlocking(false);
            this.f8551b = open.register(selector, 1);
        } catch (Throwable th2) {
            th = th2;
            if (selector != null) {
                selector.close();
            }
            open.close();
            throw th;
        }
    }

    public static void a(SelectionKey selectionKey, long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        if ((currentTimeMillis > 0 ? selectionKey.selector().select(currentTimeMillis) : currentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    private byte[] a(int i2) {
        SocketChannel socketChannel = (SocketChannel) this.f8551b.channel();
        byte[] bArr = new byte[i2];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f8551b.interestOps(1);
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.f8551b.isReadable()) {
                    long read = socketChannel.read(wrap);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i3 += (int) read;
                    if (i3 < i2 && System.currentTimeMillis() > this.f8550a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f8551b, this.f8550a);
                }
            } finally {
                if (this.f8551b.isValid()) {
                    this.f8551b.interestOps(0);
                }
            }
        }
        return bArr;
    }

    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) {
        o oVar = new o(j);
        if (socketAddress != null) {
            try {
                oVar.a(socketAddress);
            } finally {
                oVar.b();
            }
        }
        oVar.b(socketAddress2);
        oVar.a(bArr);
        return oVar.a();
    }

    public void a(SocketAddress socketAddress) {
        ((SocketChannel) this.f8551b.channel()).socket().bind(socketAddress);
    }

    public void a(byte[] bArr) {
        SocketChannel socketChannel = (SocketChannel) this.f8551b.channel();
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & ViewfinderView.OPAQUE)}), ByteBuffer.wrap(bArr)};
        this.f8551b.interestOps(4);
        int i2 = 0;
        while (i2 < bArr.length + 2) {
            try {
                if (this.f8551b.isWritable()) {
                    long write = socketChannel.write(byteBufferArr);
                    if (write < 0) {
                        throw new EOFException();
                    }
                    i2 += (int) write;
                    if (i2 < bArr.length + 2 && System.currentTimeMillis() > this.f8550a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f8551b, this.f8550a);
                }
            } finally {
                if (this.f8551b.isValid()) {
                    this.f8551b.interestOps(0);
                }
            }
        }
    }

    public byte[] a() {
        byte[] a2 = a(2);
        byte[] a3 = a(((a2[0] & ThreadUtils.TYPE_SINGLE) << 8) + (a2[1] & ThreadUtils.TYPE_SINGLE));
        return a3;
    }

    public void b() {
        this.f8551b.selector().close();
        this.f8551b.channel().close();
    }

    public void b(SocketAddress socketAddress) {
        SocketChannel socketChannel = (SocketChannel) this.f8551b.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.f8551b.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.f8551b.isConnectable()) {
                    a(this.f8551b, this.f8550a);
                }
            } finally {
                if (this.f8551b.isValid()) {
                    this.f8551b.interestOps(0);
                }
            }
        }
    }
}
