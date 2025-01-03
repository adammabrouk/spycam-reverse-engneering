package c.a.a.r;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class c extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    public static final Queue<c> f3452c = h.a(0);

    /* renamed from: a, reason: collision with root package name */
    public InputStream f3453a;

    /* renamed from: b, reason: collision with root package name */
    public IOException f3454b;

    public static c b(InputStream inputStream) {
        c poll;
        synchronized (f3452c) {
            poll = f3452c.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.a(inputStream);
        return poll;
    }

    public void a(InputStream inputStream) {
        this.f3453a = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f3453a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3453a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f3453a.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f3453a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f3453a.read(bArr);
        } catch (IOException e2) {
            this.f3454b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f3453a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.f3453a.skip(j);
        } catch (IOException e2) {
            this.f3454b = e2;
            return 0L;
        }
    }

    public IOException a() {
        return this.f3454b;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.f3453a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f3454b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f3453a.read();
        } catch (IOException e2) {
            this.f3454b = e2;
            return -1;
        }
    }

    public void b() {
        this.f3454b = null;
        this.f3453a = null;
        synchronized (f3452c) {
            f3452c.offer(this);
        }
    }
}
