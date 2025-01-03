package a.n.a;

import a.e.h;
import a.m.i;
import a.m.n;
import a.m.o;
import a.m.t;
import a.m.u;
import a.m.v;
import a.n.b.a;
import android.os.Bundle;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
public class b extends a.n.a.a {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1549c = false;

    /* renamed from: a, reason: collision with root package name */
    public final i f1550a;

    /* renamed from: b, reason: collision with root package name */
    public final c f1551b;

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: a.n.a.b$b, reason: collision with other inner class name */
    public static class C0042b<D> implements o<D> {
        public void a(String str, PrintWriter printWriter) {
            throw null;
        }

        public boolean a() {
            throw null;
        }

        public void b() {
            throw null;
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    public static class c extends t {

        /* renamed from: d, reason: collision with root package name */
        public static final u.b f1552d = new a();

        /* renamed from: c, reason: collision with root package name */
        public h<a> f1553c = new h<>();

        /* compiled from: LoaderManagerImpl.java */
        public static class a implements u.b {
            @Override // a.m.u.b
            public <T extends t> T a(Class<T> cls) {
                return new c();
            }
        }

        public static c a(v vVar) {
            return (c) new u(vVar, f1552d).a(c.class);
        }

        @Override // a.m.t
        public void b() {
            super.b();
            int c2 = this.f1553c.c();
            for (int i2 = 0; i2 < c2; i2++) {
                this.f1553c.c(i2).a(true);
            }
            this.f1553c.a();
        }

        public void c() {
            int c2 = this.f1553c.c();
            for (int i2 = 0; i2 < c2; i2++) {
                this.f1553c.c(i2).f();
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f1553c.c() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f1553c.c(); i2++) {
                    a c2 = this.f1553c.c(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f1553c.b(i2));
                    printWriter.print(": ");
                    printWriter.println(c2.toString());
                    c2.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public b(i iVar, v vVar) {
        this.f1550a = iVar;
        this.f1551b = c.a(vVar);
    }

    @Override // a.n.a.a
    public void a() {
        this.f1551b.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(RecyclerView.c0.FLAG_IGNORE);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a.h.i.b.a(this.f1550a, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // a.n.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1551b.a(str, fileDescriptor, printWriter, strArr);
    }

    /* compiled from: LoaderManagerImpl.java */
    public static class a<D> extends n<D> implements a.b<D> {
        public final int k;
        public final Bundle l;
        public final a.n.b.a<D> m;
        public i n;
        public C0042b<D> o;
        public a.n.b.a<D> p;

        public a.n.b.a<D> a(boolean z) {
            if (b.f1549c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.b();
            this.m.a();
            C0042b<D> c0042b = this.o;
            if (c0042b != null) {
                b(c0042b);
                if (z) {
                    c0042b.b();
                    throw null;
                }
            }
            this.m.unregisterListener(this);
            if (c0042b != null) {
                c0042b.a();
                throw null;
            }
            if (!z) {
                return this.m;
            }
            this.m.h();
            return this.p;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void b(o<? super D> oVar) {
            super.b(oVar);
            this.n = null;
            this.o = null;
        }

        @Override // androidx.lifecycle.LiveData
        public void c() {
            if (b.f1549c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.i();
        }

        @Override // androidx.lifecycle.LiveData
        public void d() {
            if (b.f1549c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.j();
        }

        public a.n.b.a<D> e() {
            return this.m;
        }

        public void f() {
            i iVar = this.n;
            C0042b<D> c0042b = this.o;
            if (iVar == null || c0042b == null) {
                return;
            }
            super.b(c0042b);
            a(iVar, c0042b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            a.h.i.b.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }

        @Override // a.m.n, androidx.lifecycle.LiveData
        public void a(D d2) {
            super.a((a<D>) d2);
            a.n.b.a<D> aVar = this.p;
            if (aVar != null) {
                aVar.h();
                this.p = null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.k);
            printWriter.print(" mArgs=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            this.m.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.o == null) {
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(e().a(a()));
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.println(b());
                return;
            }
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.o);
            this.o.a(str + "  ", printWriter);
            throw null;
        }
    }
}
