package h;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: EventListener.java */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f11732a = new a();

    /* compiled from: EventListener.java */
    public class a extends p {
    }

    /* compiled from: EventListener.java */
    public class b implements c {
        public b() {
        }

        @Override // h.p.c
        public p a(e eVar) {
            return p.this;
        }
    }

    /* compiled from: EventListener.java */
    public interface c {
        p a(e eVar);
    }

    public static c a(p pVar) {
        return pVar.new b();
    }

    public void a(e eVar) {
    }

    public void a(e eVar, long j) {
    }

    public void a(e eVar, a0 a0Var) {
    }

    public void a(e eVar, i iVar) {
    }

    public void a(e eVar, @Nullable q qVar) {
    }

    public void a(e eVar, y yVar) {
    }

    public void a(e eVar, IOException iOException) {
    }

    public void a(e eVar, String str) {
    }

    public void a(e eVar, String str, List<InetAddress> list) {
    }

    public void a(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void a(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable w wVar) {
    }

    public void a(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable w wVar, IOException iOException) {
    }

    public void b(e eVar) {
    }

    public void b(e eVar, long j) {
    }

    public void b(e eVar, i iVar) {
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
    }

    public void e(e eVar) {
    }

    public void f(e eVar) {
    }

    public void g(e eVar) {
    }
}
