package h.e0.j;

import android.os.Build;
import android.util.Log;
import h.w;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* compiled from: AndroidPlatform.java */
/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: c, reason: collision with root package name */
    public final e<Socket> f11647c;

    /* renamed from: d, reason: collision with root package name */
    public final e<Socket> f11648d;

    /* renamed from: e, reason: collision with root package name */
    public final e<Socket> f11649e;

    /* renamed from: f, reason: collision with root package name */
    public final e<Socket> f11650f;

    /* renamed from: g, reason: collision with root package name */
    public final c f11651g = c.a();

    /* compiled from: AndroidPlatform.java */
    /* renamed from: h.e0.j.a$a, reason: collision with other inner class name */
    public static final class C0170a extends h.e0.k.c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f11652a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f11653b;

        public C0170a(Object obj, Method method) {
            this.f11652a = obj;
            this.f11653b = method;
        }

        @Override // h.e0.k.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f11653b.invoke(this.f11652a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0170a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: AndroidPlatform.java */
    public static final class b implements h.e0.k.e {

        /* renamed from: a, reason: collision with root package name */
        public final X509TrustManager f11654a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f11655b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.f11655b = method;
            this.f11654a = x509TrustManager;
        }

        @Override // h.e0.k.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f11655b.invoke(this.f11654a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw h.e0.c.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f11654a.equals(bVar.f11654a) && this.f11655b.equals(bVar.f11655b);
        }

        public int hashCode() {
            return this.f11654a.hashCode() + (this.f11655b.hashCode() * 31);
        }
    }

    public a(Class<?> cls, e<Socket> eVar, e<Socket> eVar2, e<Socket> eVar3, e<Socket> eVar4) {
        this.f11647c = eVar;
        this.f11648d = eVar2;
        this.f11649e = eVar3;
        this.f11650f = eVar4;
    }

    public static f e() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (f()) {
                e eVar5 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar2 = new e(null, "setAlpnProtocols", byte[].class);
                eVar = eVar5;
            } else {
                eVar = null;
                eVar2 = null;
            }
            return new a(cls2, eVar3, eVar4, eVar, eVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    public static boolean f() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // h.e0.j.f
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (!h.e0.c.a(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e3;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        } catch (SecurityException e4) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e4);
            throw iOException2;
        }
    }

    @Override // h.e0.j.f
    @Nullable
    public String b(SSLSocket sSLSocket) {
        byte[] bArr;
        e<Socket> eVar = this.f11649e;
        if (eVar == null || !eVar.a((e<Socket>) sSLSocket) || (bArr = (byte[]) this.f11649e.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, h.e0.c.j);
    }

    /* compiled from: AndroidPlatform.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Method f11656a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f11657b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f11658c;

        public c(Method method, Method method2, Method method3) {
            this.f11656a = method;
            this.f11657b = method2;
            this.f11658c = method3;
        }

        public Object a(String str) {
            Method method = this.f11656a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f11657b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f11658c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }
    }

    @Override // h.e0.j.f
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw h.e0.c.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw h.e0.c.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw h.e0.c.a("unable to determine cleartext support", e);
        }
    }

    public final boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return a(str, cls, obj);
        }
    }

    @Override // h.e0.j.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.f11647c.c(sSLSocket, true);
            this.f11648d.c(sSLSocket, str);
        }
        e<Socket> eVar = this.f11650f;
        if (eVar == null || !eVar.a((e<Socket>) sSLSocket)) {
            return;
        }
        this.f11650f.d(sSLSocket, f.b(list));
    }

    @Override // h.e0.j.f
    public h.e0.k.e b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // h.e0.j.f
    public void a(int i2, String str, Throwable th) {
        int min;
        int i3 = i2 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i4 = min;
                }
            }
            i4 = min + 1;
        }
    }

    @Override // h.e0.j.f
    public Object a(String str) {
        return this.f11651g.a(str);
    }

    @Override // h.e0.j.f
    public void a(String str, Object obj) {
        if (this.f11651g.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    public final boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    @Override // h.e0.j.f
    public h.e0.k.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0170a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    @Override // h.e0.j.f
    public SSLContext a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && i2 < 22) {
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
}
