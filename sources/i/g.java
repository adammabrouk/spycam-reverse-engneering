package i;

import java.io.IOException;

/* compiled from: ForwardingSink.java */
/* loaded from: classes.dex */
public abstract class g implements r {

    /* renamed from: a, reason: collision with root package name */
    public final r f11822a;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f11822a = rVar;
    }

    @Override // i.r
    public void a(c cVar, long j) throws IOException {
        this.f11822a.a(cVar, j);
    }

    @Override // i.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f11822a.close();
    }

    @Override // i.r, java.io.Flushable
    public void flush() throws IOException {
        this.f11822a.flush();
    }

    @Override // i.r
    public t timeout() {
        return this.f11822a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f11822a.toString() + ")";
    }
}
