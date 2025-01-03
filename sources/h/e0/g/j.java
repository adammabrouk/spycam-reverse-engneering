package h.e0.g;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.decoding.InactivityTimer;
import h.a0;
import h.b0;
import h.c0;
import h.p;
import h.s;
import h.t;
import h.v;
import h.y;
import h.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes.dex */
public final class j implements t {

    /* renamed from: a, reason: collision with root package name */
    public final v f11474a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11475b;

    /* renamed from: c, reason: collision with root package name */
    public volatile h.e0.f.g f11476c;

    /* renamed from: d, reason: collision with root package name */
    public Object f11477d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f11478e;

    public j(v vVar, boolean z) {
        this.f11474a = vVar;
        this.f11475b = z;
    }

    public void a() {
        this.f11478e = true;
        h.e0.f.g gVar = this.f11476c;
        if (gVar != null) {
            gVar.a();
        }
    }

    public boolean b() {
        return this.f11478e;
    }

    @Override // h.t
    public a0 intercept(t.a aVar) throws IOException {
        a0 a2;
        y a3 = aVar.a();
        g gVar = (g) aVar;
        h.e e2 = gVar.e();
        p g2 = gVar.g();
        h.e0.f.g gVar2 = new h.e0.f.g(this.f11474a.d(), a(a3.g()), e2, g2, this.f11477d);
        this.f11476c = gVar2;
        a0 a0Var = null;
        int i2 = 0;
        while (!this.f11478e) {
            try {
                try {
                    a2 = gVar.a(a3, gVar2, null, null);
                    if (a0Var != null) {
                        a0.a l = a2.l();
                        a0.a l2 = a0Var.l();
                        l2.a((b0) null);
                        l.d(l2.a());
                        a2 = l.a();
                    }
                } catch (h.e0.f.e e3) {
                    if (!a(e3.getLastConnectException(), gVar2, false, a3)) {
                        throw e3.getFirstConnectException();
                    }
                } catch (IOException e4) {
                    if (!a(e4, gVar2, !(e4 instanceof h.e0.i.a), a3)) {
                        throw e4;
                    }
                }
                try {
                    y a4 = a(a2, gVar2.h());
                    if (a4 == null) {
                        if (!this.f11475b) {
                            gVar2.f();
                        }
                        return a2;
                    }
                    h.e0.c.a(a2.a());
                    int i3 = i2 + 1;
                    if (i3 > 20) {
                        gVar2.f();
                        throw new ProtocolException("Too many follow-up requests: " + i3);
                    }
                    a4.a();
                    if (!a(a2, a4.g())) {
                        gVar2.f();
                        gVar2 = new h.e0.f.g(this.f11474a.d(), a(a4.g()), e2, g2, this.f11477d);
                        this.f11476c = gVar2;
                    } else if (gVar2.b() != null) {
                        throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    a0Var = a2;
                    a3 = a4;
                    i2 = i3;
                } catch (IOException e5) {
                    gVar2.f();
                    throw e5;
                }
            } catch (Throwable th) {
                gVar2.a((IOException) null);
                gVar2.f();
                throw th;
            }
        }
        gVar2.f();
        throw new IOException("Canceled");
    }

    public void a(Object obj) {
        this.f11477d = obj;
    }

    public final h.a a(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        h.g gVar;
        if (sVar.h()) {
            SSLSocketFactory y = this.f11474a.y();
            hostnameVerifier = this.f11474a.l();
            sSLSocketFactory = y;
            gVar = this.f11474a.b();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new h.a(sVar.g(), sVar.j(), this.f11474a.h(), this.f11474a.x(), sSLSocketFactory, hostnameVerifier, gVar, this.f11474a.t(), this.f11474a.s(), this.f11474a.r(), this.f11474a.e(), this.f11474a.u());
    }

    public final boolean a(IOException iOException, h.e0.f.g gVar, boolean z, y yVar) {
        gVar.a(iOException);
        if (!this.f11474a.w()) {
            return false;
        }
        if (z) {
            yVar.a();
        }
        return a(iOException, z) && gVar.d();
    }

    public final boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public final y a(a0 a0Var, c0 c0Var) throws IOException {
        String b2;
        s b3;
        Proxy s;
        if (a0Var != null) {
            int c2 = a0Var.c();
            String e2 = a0Var.r().e();
            if (c2 == 307 || c2 == 308) {
                if (!e2.equals("GET") && !e2.equals("HEAD")) {
                    return null;
                }
            } else {
                if (c2 == 401) {
                    return this.f11474a.a().a(c0Var, a0Var);
                }
                if (c2 == 503) {
                    if ((a0Var.m() == null || a0Var.m().c() != 503) && a(a0Var, Integer.MAX_VALUE) == 0) {
                        return a0Var.r();
                    }
                    return null;
                }
                if (c2 == 407) {
                    if (c0Var != null) {
                        s = c0Var.b();
                    } else {
                        s = this.f11474a.s();
                    }
                    if (s.type() == Proxy.Type.HTTP) {
                        return this.f11474a.t().a(c0Var, a0Var);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (c2 == 408) {
                    if (!this.f11474a.w()) {
                        return null;
                    }
                    a0Var.r().a();
                    if ((a0Var.m() == null || a0Var.m().c() != 408) && a(a0Var, 0) <= 0) {
                        return a0Var.r();
                    }
                    return null;
                }
                switch (c2) {
                    case InactivityTimer.INACTIVITY_DELAY_SECONDS /* 300 */:
                    case ErrorCorrection.MODULO_VALUE /* 301 */:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f11474a.j() || (b2 = a0Var.b(HttpHeaders.LOCATION)) == null || (b3 = a0Var.r().g().b(b2)) == null) {
                return null;
            }
            if (!b3.m().equals(a0Var.r().g().m()) && !this.f11474a.k()) {
                return null;
            }
            y.a f2 = a0Var.r().f();
            if (f.b(e2)) {
                boolean d2 = f.d(e2);
                if (f.c(e2)) {
                    f2.a("GET", (z) null);
                } else {
                    f2.a(e2, d2 ? a0Var.r().a() : null);
                }
                if (!d2) {
                    f2.a("Transfer-Encoding");
                    f2.a(HttpHeaders.CONTENT_LENGTH);
                    f2.a(HttpHeaders.CONTENT_TYPE);
                }
            }
            if (!a(a0Var, b3)) {
                f2.a(HttpHeaders.AUTHORIZATION);
            }
            f2.a(b3);
            return f2.a();
        }
        throw new IllegalStateException();
    }

    public final int a(a0 a0Var, int i2) {
        String b2 = a0Var.b("Retry-After");
        if (b2 == null) {
            return i2;
        }
        if (b2.matches("\\d+")) {
            return Integer.valueOf(b2).intValue();
        }
        return Integer.MAX_VALUE;
    }

    public final boolean a(a0 a0Var, s sVar) {
        s g2 = a0Var.r().g();
        return g2.g().equals(sVar.g()) && g2.j() == sVar.j() && g2.m().equals(sVar.m());
    }
}
