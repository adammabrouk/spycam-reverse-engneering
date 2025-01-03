package i;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* loaded from: classes.dex */
public class i extends t {

    /* renamed from: e, reason: collision with root package name */
    public t f11823e;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f11823e = tVar;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f11823e = tVar;
        return this;
    }

    @Override // i.t
    public t b() {
        return this.f11823e.b();
    }

    @Override // i.t
    public long c() {
        return this.f11823e.c();
    }

    @Override // i.t
    public boolean d() {
        return this.f11823e.d();
    }

    @Override // i.t
    public void e() throws IOException {
        this.f11823e.e();
    }

    @Override // i.t
    public long f() {
        return this.f11823e.f();
    }

    public final t g() {
        return this.f11823e;
    }

    @Override // i.t
    public t a(long j, TimeUnit timeUnit) {
        return this.f11823e.a(j, timeUnit);
    }

    @Override // i.t
    public t a(long j) {
        return this.f11823e.a(j);
    }

    @Override // i.t
    public t a() {
        return this.f11823e.a();
    }
}
