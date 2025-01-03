package h.e0.f;

import h.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final List<k> f11423a;

    /* renamed from: b, reason: collision with root package name */
    public int f11424b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11425c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11426d;

    public b(List<k> list) {
        this.f11423a = list;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i2 = this.f11424b;
        int size = this.f11423a.size();
        while (true) {
            if (i2 >= size) {
                kVar = null;
                break;
            }
            kVar = this.f11423a.get(i2);
            if (kVar.a(sSLSocket)) {
                this.f11424b = i2 + 1;
                break;
            }
            i2++;
        }
        if (kVar != null) {
            this.f11425c = b(sSLSocket);
            h.e0.a.f11393a.a(kVar, sSLSocket, this.f11426d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f11426d + ", modes=" + this.f11423a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public final boolean b(SSLSocket sSLSocket) {
        for (int i2 = this.f11424b; i2 < this.f11423a.size(); i2++) {
            if (this.f11423a.get(i2).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(IOException iOException) {
        this.f11426d = true;
        if (!this.f11425c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
