package h;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f11734a;

    /* renamed from: b, reason: collision with root package name */
    public final h f11735b;

    /* renamed from: c, reason: collision with root package name */
    public final List<Certificate> f11736c;

    /* renamed from: d, reason: collision with root package name */
    public final List<Certificate> f11737d;

    public q(d0 d0Var, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f11734a = d0Var;
        this.f11735b = hVar;
        this.f11736c = list;
        this.f11737d = list2;
    }

    public static q a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        h a2 = h.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        d0 forJavaName = d0.forJavaName(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List a3 = certificateArr != null ? h.e0.c.a(certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new q(forJavaName, a2, a3, localCertificates != null ? h.e0.c.a(localCertificates) : Collections.emptyList());
    }

    public List<Certificate> b() {
        return this.f11736c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f11734a.equals(qVar.f11734a) && this.f11735b.equals(qVar.f11735b) && this.f11736c.equals(qVar.f11736c) && this.f11737d.equals(qVar.f11737d);
    }

    public int hashCode() {
        return ((((((527 + this.f11734a.hashCode()) * 31) + this.f11735b.hashCode()) * 31) + this.f11736c.hashCode()) * 31) + this.f11737d.hashCode();
    }

    public h a() {
        return this.f11735b;
    }
}
