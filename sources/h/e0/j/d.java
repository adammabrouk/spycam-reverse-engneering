package h.e0.j;

import h.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: JdkWithJettyBootPlatform.java */
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: c, reason: collision with root package name */
    public final Method f11661c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f11662d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f11663e;

    /* renamed from: f, reason: collision with root package name */
    public final Class<?> f11664f;

    /* renamed from: g, reason: collision with root package name */
    public final Class<?> f11665g;

    /* compiled from: JdkWithJettyBootPlatform.java */
    public static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f11666a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11667b;

        /* renamed from: c, reason: collision with root package name */
        public String f11668c;

        public a(List<String> list) {
            this.f11666a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = h.e0.c.f11396b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f11667b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f11666a;
            }
            if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f11668c = (String) objArr[0];
                return null;
            }
            List list = (List) objArr[0];
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f11666a.contains(list.get(i2))) {
                    String str = (String) list.get(i2);
                    this.f11668c = str;
                    return str;
                }
            }
            String str2 = this.f11666a.get(0);
            this.f11668c = str2;
            return str2;
        }
    }

    public d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f11661c = method;
        this.f11662d = method2;
        this.f11663e = method3;
        this.f11664f = cls;
        this.f11665g = cls2;
    }

    public static f e() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // h.e0.j.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            this.f11661c.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f11664f, this.f11665g}, new a(f.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw h.e0.c.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // h.e0.j.f
    @Nullable
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f11662d.invoke(null, sSLSocket));
            if (!aVar.f11667b && aVar.f11668c == null) {
                f.c().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (aVar.f11667b) {
                return null;
            }
            return aVar.f11668c;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw h.e0.c.a("unable to get selected protocol", (Exception) e2);
        }
    }

    @Override // h.e0.j.f
    public void a(SSLSocket sSLSocket) {
        try {
            this.f11663e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw h.e0.c.a("unable to remove alpn", (Exception) e2);
        }
    }
}
