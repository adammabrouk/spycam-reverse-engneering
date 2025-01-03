package h.e0.g;

import h.b0;
import h.u;
import javax.annotation.Nullable;

/* compiled from: RealResponseBody.java */
/* loaded from: classes.dex */
public final class h extends b0 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f11471a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11472b;

    /* renamed from: c, reason: collision with root package name */
    public final i.e f11473c;

    public h(@Nullable String str, long j, i.e eVar) {
        this.f11471a = str;
        this.f11472b = j;
        this.f11473c = eVar;
    }

    @Override // h.b0
    public long contentLength() {
        return this.f11472b;
    }

    @Override // h.b0
    public u contentType() {
        String str = this.f11471a;
        if (str != null) {
            return u.b(str);
        }
        return null;
    }

    @Override // h.b0
    public i.e source() {
        return this.f11473c;
    }
}
