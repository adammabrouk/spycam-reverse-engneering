package h.e0.j;

import h.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: Jdk9Platform.java */
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: c, reason: collision with root package name */
    public final Method f11659c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f11660d;

    public c(Method method, Method method2) {
        this.f11659c = method;
        this.f11660d = method2;
    }

    public static c e() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // h.e0.j.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = f.a(list);
            this.f11659c.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw h.e0.c.a("unable to set ssl parameters", (Exception) e2);
        }
    }

    @Override // h.e0.j.f
    @Nullable
    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f11660d.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw h.e0.c.a("unable to get selected protocols", (Exception) e2);
        }
    }
}
