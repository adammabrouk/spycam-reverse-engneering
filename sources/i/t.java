package i;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: d, reason: collision with root package name */
    public static final t f11854d = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f11855a;

    /* renamed from: b, reason: collision with root package name */
    public long f11856b;

    /* renamed from: c, reason: collision with root package name */
    public long f11857c;

    /* compiled from: Timeout.java */
    public class a extends t {
        @Override // i.t
        public t a(long j) {
            return this;
        }

        @Override // i.t
        public t a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // i.t
        public void e() throws IOException {
        }
    }

    public t a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f11857c = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public t b() {
        this.f11857c = 0L;
        return this;
    }

    public long c() {
        if (this.f11855a) {
            return this.f11856b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.f11855a;
    }

    public void e() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f11855a && this.f11856b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long f() {
        return this.f11857c;
    }

    public t a(long j) {
        this.f11855a = true;
        this.f11856b = j;
        return this;
    }

    public t a() {
        this.f11855a = false;
        return this;
    }
}
