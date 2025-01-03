package c.c.a.b.c.l;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.c.a.b.c.l.a.d;
import c.c.a.b.c.o.c;
import c.c.a.b.c.o.r;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* loaded from: classes.dex */
public final class a<O extends d> {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0083a<?, O> f3828a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3829b;

    /* renamed from: c.c.a.b.c.l.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0083a<T extends f, O> extends e<T, O> {
        public abstract T a(Context context, Looper looper, c.c.a.b.c.o.d dVar, O o, c.c.a.b.c.l.f fVar, c.c.a.b.c.l.g gVar);
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: c.c.a.b.c.l.a$d$a, reason: collision with other inner class name */
        public interface InterfaceC0084a extends c, InterfaceC0085d {
            Account e();
        }

        public interface b extends c {
            GoogleSignInAccount r();
        }

        public interface c extends d {
        }

        /* renamed from: c.c.a.b.c.l.a$d$d, reason: collision with other inner class name */
        public interface InterfaceC0085d extends d {
        }

        public interface e extends c, InterfaceC0085d {
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        void a(c.InterfaceC0088c interfaceC0088c);

        void a(c.e eVar);

        void a(c.c.a.b.c.o.k kVar, Set<Scope> set);

        boolean a();

        boolean c();

        int d();

        boolean e();

        Feature[] f();

        String g();

        void h();

        boolean j();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public interface h<T extends IInterface> extends b {
        T a(IBinder iBinder);

        void a(int i2, T t);

        String b();

        String k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0083a<C, O> abstractC0083a, g<C> gVar) {
        r.a(abstractC0083a, "Cannot construct an Api with a null ClientBuilder");
        r.a(gVar, "Cannot construct an Api with a null ClientKey");
        this.f3829b = str;
        this.f3828a = abstractC0083a;
    }

    public final String a() {
        return this.f3829b;
    }

    public final AbstractC0083a<?, O> b() {
        r.b(this.f3828a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f3828a;
    }
}
