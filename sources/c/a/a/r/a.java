package c.a.a.r;

import android.util.Log;
import java.util.Queue;

/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3448b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Queue<byte[]> f3449a = h.a(0);

    public static a b() {
        return f3448b;
    }

    public byte[] a() {
        byte[] poll;
        synchronized (this.f3449a) {
            poll = this.f3449a.poll();
        }
        if (poll == null) {
            poll = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return poll;
    }

    public boolean a(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 65536) {
            return false;
        }
        synchronized (this.f3449a) {
            if (this.f3449a.size() < 32) {
                z = true;
                this.f3449a.offer(bArr);
            }
        }
        return z;
    }
}
