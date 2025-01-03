package cn.jiguang.net;

import cn.jiguang.as.d;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class SSLTrustManager implements X509TrustManager {

    /* renamed from: a, reason: collision with root package name */
    public X509TrustManager f9014a;

    public SSLTrustManager(String str) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            KeyStore.TrustedCertificateEntry trustedCertificateEntry = new KeyStore.TrustedCertificateEntry(x509Certificate);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setEntry("ca_root", trustedCertificateEntry, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f9014a = (X509TrustManager) trustManager;
                    return;
                }
            }
        } catch (Throwable th) {
            d.g("SSLTrustManager", "init trustManager failed, error:" + th);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        d.c("SSLTrustManager", "checkClientTrusted");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        StringBuilder sb;
        String localizedMessage;
        d.c("SSLTrustManager", "checkServerTrusted");
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || x509CertificateArr[0] == null) {
            throw new CertificateException("Check Server x509Certificates is empty");
        }
        try {
            x509CertificateArr[0].checkValidity();
        } catch (CertificateExpiredException e2) {
            sb = new StringBuilder();
            sb.append("checkServerTrusted: CertificateExpiredException:");
            localizedMessage = e2.getLocalizedMessage();
            sb.append(localizedMessage);
            d.g("SSLTrustManager", sb.toString());
        } catch (CertificateNotYetValidException e3) {
            sb = new StringBuilder();
            sb.append("checkServerTrusted: CertificateNotYetValidException:");
            localizedMessage = e3.getLocalizedMessage();
            sb.append(localizedMessage);
            d.g("SSLTrustManager", sb.toString());
        } catch (Throwable th) {
            sb = new StringBuilder();
            sb.append("checkServerTrusted failed, error");
            localizedMessage = th.getLocalizedMessage();
            sb.append(localizedMessage);
            d.g("SSLTrustManager", sb.toString());
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        d.c("SSLTrustManager", "getAcceptedIssuers");
        return this.f9014a.getAcceptedIssuers();
    }
}
