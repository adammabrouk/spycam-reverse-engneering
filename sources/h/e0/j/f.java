package h.e0.j;

import h.v;
import h.w;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f11672a = b();

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f11673b = Logger.getLogger(v.class.getName());

    public static f b() {
        f f2;
        f e2 = a.e();
        if (e2 != null) {
            return e2;
        }
        if (d() && (f2 = b.f()) != null) {
            return f2;
        }
        c e3 = c.e();
        if (e3 != null) {
            return e3;
        }
        f e4 = d.e();
        return e4 != null ? e4 : new f();
    }

    public static f c() {
        return f11672a;
    }

    public static boolean d() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    @Nullable
    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public void a(int i2, String str, Throwable th) {
        f11673b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f11673b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static byte[] b(List<w> list) {
        i.c cVar = new i.c();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = list.get(i2);
            if (wVar != w.HTTP_1_0) {
                cVar.writeByte(wVar.toString().length());
                cVar.a(wVar.toString());
            }
        }
        return cVar.i();
    }

    public static List<String> a(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = list.get(i2);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public h.e0.k.c a(X509TrustManager x509TrustManager) {
        return new h.e0.k.a(b(x509TrustManager));
    }

    public SSLContext a() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    public h.e0.k.e b(X509TrustManager x509TrustManager) {
        return new h.e0.k.b(x509TrustManager.getAcceptedIssuers());
    }
}
