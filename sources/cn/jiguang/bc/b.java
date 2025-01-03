package cn.jiguang.bc;

import cn.jiguang.as.d;
import cn.jiguang.az.f;
import cn.jiguang.e.h;
import com.shix.shixipc.utilcode.MemoryConstants;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.shix.shixipc.utilcode.NotificationUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: g, reason: collision with root package name */
    public final int f8667g;

    /* renamed from: h, reason: collision with root package name */
    public ByteBuffer f8668h = ByteBuffer.allocate(8192);

    public b(int i2, int i3) {
        this.f8667g = i2;
        this.f8666f = i3;
    }

    private boolean b(byte[] bArr) {
        try {
            if (!b()) {
                d.c("NioSocketClient", "send error - connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                int write = this.f8662b.write(ByteBuffer.wrap(bArr));
                if (write > 0) {
                    d.a("NioSocketClient", "isWritable has send len:" + write);
                    return true;
                }
                if (write >= 0) {
                    return true;
                }
                d.a("NioSocketClient", "isWritable error:" + write);
                return false;
            }
            d.c("NioSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e2) {
            d.h("NioSocketClient", "send data error:" + e2);
            close();
            return false;
        }
    }

    @Override // cn.jiguang.bc.a
    public synchronized int a(String str, int i2) {
        super.a(str, i2);
        try {
            this.f8662b = SocketChannel.open();
            this.f8664d = Selector.open();
            this.f8662b.configureBlocking(false);
            this.f8662b.connect(new InetSocketAddress(str, i2));
            d.c("NioSocketClient", "tcp connecting...");
            long currentTimeMillis = System.currentTimeMillis();
            while (!this.f8662b.finishConnect()) {
                if (!this.f8665e) {
                    d.c("NioSocketClient", "has close channel when connect...");
                    return -991;
                }
                Thread.sleep(10L);
                if (System.currentTimeMillis() - currentTimeMillis > NetworkUtils.SCAN_PERIOD_MILLIS) {
                    close();
                    return -994;
                }
            }
            if (!this.f8665e) {
                d.c("NioSocketClient", "has close channel when connected...");
                return -991;
            }
            d.c("NioSocketClient", "tcp connected");
            this.f8662b.register(this.f8664d, 1);
            return 0;
        } catch (Throwable th) {
            d.h("NioSocketClient", "tcp connect has failed:" + th);
            close();
            if (th instanceof SocketTimeoutException) {
                return -994;
            }
            return NotificationUtils.IMPORTANCE_UNSPECIFIED;
        }
    }

    @Override // cn.jiguang.bc.a
    public int a(byte[] bArr) {
        if (bArr == null) {
            d.c("NioSocketClient", "sendData failed, send data was null");
            return 103;
        }
        d.c("NioSocketClient", "send data length:" + bArr.length);
        if (bArr.length < this.f8667g) {
            return b(bArr) ? 0 : 103;
        }
        d.c("NioSocketClient", "sendData failed, data length must less than " + this.f8667g);
        return 6026;
    }

    @Override // cn.jiguang.bc.a
    public ByteBuffer a(int i2) {
        ByteBuffer b2;
        try {
            if (!b()) {
                throw new f(-991, "recv error,the connect is invalid");
            }
            int c2 = c();
            if (c2 > 0 && (b2 = b(c2)) != null) {
                return b2;
            }
            int i3 = 0;
            int i4 = MemoryConstants.MB;
            while (b() && this.f8663c < i4) {
                int select = i2 > 0 ? this.f8664d.select(i2) : this.f8664d.select();
                if (select == 0) {
                    d.c("NioSocketClient", "readSelect:" + select + ",time out:" + i2);
                    if (i2 > 0) {
                        throw new f(-994, "recv time out");
                    }
                } else {
                    Iterator<SelectionKey> it = this.f8664d.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        SocketChannel socketChannel = (SocketChannel) next.channel();
                        if (next.isReadable()) {
                            int read = socketChannel.read(this.f8668h);
                            if (read < 0) {
                                throw new f(-996, "read len < 0:" + read);
                            }
                            this.f8668h.flip();
                            int limit = this.f8668h.limit();
                            if (this.f8661a.remaining() < limit) {
                                throw new f(-996, "the total buf remaining less than readLen,remaining:" + this.f8661a.remaining() + ",readLen:" + limit);
                            }
                            this.f8661a.put(this.f8668h);
                            this.f8663c += limit;
                            this.f8668h.compact();
                            if (this.f8663c < this.f8666f) {
                                d.c("NioSocketClient", "totalbuf can not parse head:" + this.f8663c + ",peerNetData len:" + limit + ",read:" + read);
                            } else {
                                i4 = c();
                            }
                            i3 = limit;
                        } else {
                            next.isWritable();
                        }
                        it.remove();
                    }
                }
            }
            if (i4 == 1048576) {
                throw new f(-997, "recv empty data or tcp has close");
            }
            d.c("NioSocketClient", "read len:" + i3 + ",recvTotalLen:" + this.f8663c + ",shouldLen:" + i4);
            ByteBuffer b3 = b(i4);
            if (b3 != null) {
                return b3;
            }
            throw new f(-1001, "parse error");
        } catch (Throwable th) {
            if (th instanceof SocketTimeoutException) {
                throw new f(-994, th.getMessage());
            }
            if (th instanceof f) {
                throw th;
            }
            throw new f(-997, th.getMessage());
        }
    }

    @Override // cn.jiguang.bc.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.c("NioSocketClient", "close this connect");
        super.close();
        Selector selector = this.f8664d;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException unused) {
            }
        }
        h.a(this.f8662b);
        this.f8662b = null;
    }
}
