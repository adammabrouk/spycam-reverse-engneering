package h;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final g f11677c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public final Set<b> f11678a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final h.e0.k.c f11679b;

    /* compiled from: CertificatePinner.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<b> f11680a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f11680a), null);
        }
    }

    /* compiled from: CertificatePinner.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f11681a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11682b;

        /* renamed from: c, reason: collision with root package name */
        public final String f11683c;

        /* renamed from: d, reason: collision with root package name */
        public final i.f f11684d;

        public boolean a(String str) {
            if (!this.f11681a.startsWith("*.")) {
                return str.equals(this.f11682b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f11682b.length()) {
                String str2 = this.f11682b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f11681a.equals(bVar.f11681a) && this.f11683c.equals(bVar.f11683c) && this.f11684d.equals(bVar.f11684d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f11681a.hashCode()) * 31) + this.f11683c.hashCode()) * 31) + this.f11684d.hashCode();
        }

        public String toString() {
            return this.f11683c + this.f11684d.base64();
        }
    }

    public g(Set<b> set, @Nullable h.e0.k.c cVar) {
        this.f11678a = set;
        this.f11679b = cVar;
    }

    public static i.f b(X509Certificate x509Certificate) {
        return i.f.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        h.e0.k.c cVar = this.f11679b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            int size2 = a2.size();
            i.f fVar = null;
            i.f fVar2 = null;
            for (int i3 = 0; i3 < size2; i3++) {
                b bVar = a2.get(i3);
                if (bVar.f11683c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = b(x509Certificate);
                    }
                    if (bVar.f11684d.equals(fVar)) {
                        return;
                    }
                } else {
                    if (!bVar.f11683c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f11683c);
                    }
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f11684d.equals(fVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = a2.size();
        for (int i5 = 0; i5 < size4; i5++) {
            b bVar2 = a2.get(i5);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (h.e0.c.a(this.f11679b, gVar.f11679b) && this.f11678a.equals(gVar.f11678a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        h.e0.k.c cVar = this.f11679b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f11678a.hashCode();
    }

    public List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f11678a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public g a(@Nullable h.e0.k.c cVar) {
        return h.e0.c.a(this.f11679b, cVar) ? this : new g(this.f11678a, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static i.f a(X509Certificate x509Certificate) {
        return i.f.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }
}
