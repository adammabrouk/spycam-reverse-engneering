package h.e0.g;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import h.a0;
import h.l;
import h.m;
import h.r;
import h.t;
import h.u;
import h.y;
import h.z;
import java.io.IOException;
import java.util.List;

/* compiled from: BridgeInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    public final m f11456a;

    public a(m mVar) {
        this.f11456a = mVar;
    }

    public final String a(List<l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            l lVar = list.get(i2);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }

    @Override // h.t
    public a0 intercept(t.a aVar) throws IOException {
        y a2 = aVar.a();
        y.a f2 = a2.f();
        z a3 = a2.a();
        if (a3 != null) {
            u contentType = a3.contentType();
            if (contentType != null) {
                f2.b(HttpHeaders.CONTENT_TYPE, contentType.toString());
            }
            long contentLength = a3.contentLength();
            if (contentLength != -1) {
                f2.b(HttpHeaders.CONTENT_LENGTH, Long.toString(contentLength));
                f2.a("Transfer-Encoding");
            } else {
                f2.b("Transfer-Encoding", "chunked");
                f2.a(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (a2.a(HttpHeaders.HOST) == null) {
            f2.b(HttpHeaders.HOST, h.e0.c.a(a2.g(), false));
        }
        if (a2.a("Connection") == null) {
            f2.b("Connection", "Keep-Alive");
        }
        if (a2.a("Accept-Encoding") == null && a2.a(HttpHeaders.RANGE) == null) {
            z = true;
            f2.b("Accept-Encoding", "gzip");
        }
        List<l> a4 = this.f11456a.a(a2.g());
        if (!a4.isEmpty()) {
            f2.b("Cookie", a(a4));
        }
        if (a2.a(HttpHeaders.USER_AGENT) == null) {
            f2.b(HttpHeaders.USER_AGENT, h.e0.d.a());
        }
        a0 a5 = aVar.a(f2.a());
        e.a(this.f11456a, a2.g(), a5.g());
        a0.a l = a5.l();
        l.a(a2);
        if (z && "gzip".equalsIgnoreCase(a5.b(HttpHeaders.CONTENT_ENCODING)) && e.b(a5)) {
            i.j jVar = new i.j(a5.a().source());
            r.a a6 = a5.g().a();
            a6.b(HttpHeaders.CONTENT_ENCODING);
            a6.b(HttpHeaders.CONTENT_LENGTH);
            l.a(a6.a());
            l.a(new h(a5.b(HttpHeaders.CONTENT_TYPE), -1L, i.l.a(jVar)));
        }
        return l.a();
    }
}
