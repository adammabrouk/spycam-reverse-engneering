package h.e0.f;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import h.a0;
import h.c0;
import h.e0.i.g;
import h.i;
import h.j;
import h.k;
import h.p;
import h.q;
import h.s;
import h.t;
import h.v;
import h.w;
import h.y;
import i.l;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* compiled from: RealConnection.java */
/* loaded from: classes.dex */
public final class c extends g.h implements i {

    /* renamed from: b, reason: collision with root package name */
    public final j f11427b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f11428c;

    /* renamed from: d, reason: collision with root package name */
    public Socket f11429d;

    /* renamed from: e, reason: collision with root package name */
    public Socket f11430e;

    /* renamed from: f, reason: collision with root package name */
    public q f11431f;

    /* renamed from: g, reason: collision with root package name */
    public w f11432g;

    /* renamed from: h, reason: collision with root package name */
    public h.e0.i.g f11433h;

    /* renamed from: i, reason: collision with root package name */
    public i.e f11434i;
    public i.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<g>> n = new ArrayList();
    public long o = RecyclerView.FOREVER_NS;

    public c(j jVar, c0 c0Var) {
        this.f11427b = jVar;
        this.f11428c = c0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r17, int r18, int r19, int r20, boolean r21, h.e r22, h.p r23) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.f.c.a(int, int, int, int, boolean, h.e, h.p):void");
    }

    public final y b() {
        y.a aVar = new y.a();
        aVar.a(this.f11428c.a().k());
        aVar.b(HttpHeaders.HOST, h.e0.c.a(this.f11428c.a().k(), true));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b(HttpHeaders.USER_AGENT, h.e0.d.a());
        return aVar.a();
    }

    public q c() {
        return this.f11431f;
    }

    public boolean d() {
        return this.f11433h != null;
    }

    public c0 e() {
        return this.f11428c;
    }

    public Socket f() {
        return this.f11430e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f11428c.a().k().g());
        sb.append(":");
        sb.append(this.f11428c.a().k().j());
        sb.append(", proxy=");
        sb.append(this.f11428c.b());
        sb.append(" hostAddress=");
        sb.append(this.f11428c.d());
        sb.append(" cipherSuite=");
        q qVar = this.f11431f;
        sb.append(qVar != null ? qVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f11432g);
        sb.append('}');
        return sb.toString();
    }

    public final void a(int i2, int i3, int i4, h.e eVar, p pVar) throws IOException {
        y b2 = b();
        s g2 = b2.g();
        for (int i5 = 0; i5 < 21; i5++) {
            a(i2, i3, eVar, pVar);
            b2 = a(i3, i4, b2, g2);
            if (b2 == null) {
                return;
            }
            h.e0.c.a(this.f11429d);
            this.f11429d = null;
            this.j = null;
            this.f11434i = null;
            pVar.a(eVar, this.f11428c.d(), this.f11428c.b(), null);
        }
    }

    public final void a(int i2, int i3, h.e eVar, p pVar) throws IOException {
        Socket createSocket;
        Proxy b2 = this.f11428c.b();
        h.a a2 = this.f11428c.a();
        if (b2.type() != Proxy.Type.DIRECT && b2.type() != Proxy.Type.HTTP) {
            createSocket = new Socket(b2);
        } else {
            createSocket = a2.i().createSocket();
        }
        this.f11429d = createSocket;
        pVar.a(eVar, this.f11428c.d(), b2);
        this.f11429d.setSoTimeout(i3);
        try {
            h.e0.j.f.c().a(this.f11429d, this.f11428c.d(), i2);
            try {
                this.f11434i = l.a(l.b(this.f11429d));
                this.j = l.a(l.a(this.f11429d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f11428c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void a(b bVar, int i2, h.e eVar, p pVar) throws IOException {
        if (this.f11428c.a().j() == null) {
            if (this.f11428c.a().e().contains(w.H2_PRIOR_KNOWLEDGE)) {
                this.f11430e = this.f11429d;
                this.f11432g = w.H2_PRIOR_KNOWLEDGE;
                a(i2);
                return;
            } else {
                this.f11430e = this.f11429d;
                this.f11432g = w.HTTP_1_1;
                return;
            }
        }
        pVar.g(eVar);
        a(bVar);
        pVar.a(eVar, this.f11431f);
        if (this.f11432g == w.HTTP_2) {
            a(i2);
        }
    }

    public final void a(int i2) throws IOException {
        this.f11430e.setSoTimeout(0);
        g.C0169g c0169g = new g.C0169g(true);
        c0169g.a(this.f11430e, this.f11428c.a().k().g(), this.f11434i, this.j);
        c0169g.a(this);
        c0169g.a(i2);
        h.e0.i.g a2 = c0169g.a();
        this.f11433h = a2;
        a2.e();
    }

    public final void a(b bVar) throws IOException {
        w wVar;
        h.a a2 = this.f11428c.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) a2.j().createSocket(this.f11429d, a2.k().g(), a2.k().j(), true);
                try {
                    k a3 = bVar.a(sSLSocket2);
                    if (a3.c()) {
                        h.e0.j.f.c().a(sSLSocket2, a2.k().g(), a2.e());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    q a4 = q.a(session);
                    if (a2.d().verify(a2.k().g(), session)) {
                        a2.a().a(a2.k().g(), a4.b());
                        String b2 = a3.c() ? h.e0.j.f.c().b(sSLSocket2) : null;
                        this.f11430e = sSLSocket2;
                        this.f11434i = l.a(l.b(sSLSocket2));
                        this.j = l.a(l.a(this.f11430e));
                        this.f11431f = a4;
                        if (b2 != null) {
                            wVar = w.get(b2);
                        } else {
                            wVar = w.HTTP_1_1;
                        }
                        this.f11432g = wVar;
                        if (sSLSocket2 != null) {
                            h.e0.j.f.c().a(sSLSocket2);
                            return;
                        }
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) a4.b().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + a2.k().g() + " not verified:\n    certificate: " + h.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + h.e0.k.d.a(x509Certificate));
                } catch (AssertionError e2) {
                    e = e2;
                    if (!h.e0.c.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        h.e0.j.f.c().a(sSLSocket);
                    }
                    h.e0.c.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e3) {
            e = e3;
        }
    }

    public final y a(int i2, int i3, y yVar, s sVar) throws IOException {
        String str = "CONNECT " + h.e0.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            h.e0.h.a aVar = new h.e0.h.a(null, null, this.f11434i, this.j);
            this.f11434i.timeout().a(i2, TimeUnit.MILLISECONDS);
            this.j.timeout().a(i3, TimeUnit.MILLISECONDS);
            aVar.a(yVar.c(), str);
            aVar.a();
            a0.a a2 = aVar.a(false);
            a2.a(yVar);
            a0 a3 = a2.a();
            long a4 = h.e0.g.e.a(a3);
            if (a4 == -1) {
                a4 = 0;
            }
            i.s b2 = aVar.b(a4);
            h.e0.c.b(b2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b2.close();
            int c2 = a3.c();
            if (c2 == 200) {
                if (this.f11434i.d().k() && this.j.d().k()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (c2 == 407) {
                y a5 = this.f11428c.a().g().a(this.f11428c, a3);
                if (a5 != null) {
                    if ("close".equalsIgnoreCase(a3.b("Connection"))) {
                        return a5;
                    }
                    yVar = a5;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a3.c());
            }
        }
    }

    public boolean a(h.a aVar, @Nullable c0 c0Var) {
        if (this.n.size() >= this.m || this.k || !h.e0.a.f11393a.a(this.f11428c.a(), aVar)) {
            return false;
        }
        if (aVar.k().g().equals(e().a().k().g())) {
            return true;
        }
        if (this.f11433h == null || c0Var == null || c0Var.b().type() != Proxy.Type.DIRECT || this.f11428c.b().type() != Proxy.Type.DIRECT || !this.f11428c.d().equals(c0Var.d()) || c0Var.a().d() != h.e0.k.d.f11676a || !a(aVar.k())) {
            return false;
        }
        try {
            aVar.a().a(aVar.k().g(), c().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(s sVar) {
        if (sVar.j() != this.f11428c.a().k().j()) {
            return false;
        }
        if (sVar.g().equals(this.f11428c.a().k().g())) {
            return true;
        }
        return this.f11431f != null && h.e0.k.d.f11676a.a(sVar.g(), (X509Certificate) this.f11431f.b().get(0));
    }

    public h.e0.g.c a(v vVar, t.a aVar, g gVar) throws SocketException {
        if (this.f11433h != null) {
            return new h.e0.i.f(vVar, aVar, gVar, this.f11433h);
        }
        this.f11430e.setSoTimeout(aVar.c());
        this.f11434i.timeout().a(aVar.c(), TimeUnit.MILLISECONDS);
        this.j.timeout().a(aVar.d(), TimeUnit.MILLISECONDS);
        return new h.e0.h.a(vVar, gVar, this.f11434i, this.j);
    }

    public void a() {
        h.e0.c.a(this.f11429d);
    }

    public boolean a(boolean z) {
        if (this.f11430e.isClosed() || this.f11430e.isInputShutdown() || this.f11430e.isOutputShutdown()) {
            return false;
        }
        if (this.f11433h != null) {
            return !r0.b();
        }
        if (z) {
            try {
                int soTimeout = this.f11430e.getSoTimeout();
                try {
                    this.f11430e.setSoTimeout(1);
                    return !this.f11434i.k();
                } finally {
                    this.f11430e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // h.e0.i.g.h
    public void a(h.e0.i.i iVar) throws IOException {
        iVar.a(h.e0.i.b.REFUSED_STREAM);
    }

    @Override // h.e0.i.g.h
    public void a(h.e0.i.g gVar) {
        synchronized (this.f11427b) {
            this.m = gVar.c();
        }
    }
}
