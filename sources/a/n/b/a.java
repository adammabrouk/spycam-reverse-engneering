package a.n.b;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class a<D> {

    /* renamed from: a, reason: collision with root package name */
    public int f1554a;

    /* renamed from: b, reason: collision with root package name */
    public b<D> f1555b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0043a<D> f1556c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1557d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1558e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1559f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1560g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1561h;

    /* compiled from: Loader.java */
    /* renamed from: a.n.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0043a<D> {
    }

    /* compiled from: Loader.java */
    public interface b<D> {
    }

    public void a() {
        this.f1558e = true;
        c();
    }

    public boolean b() {
        return d();
    }

    public void c() {
    }

    public boolean d() {
        return false;
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void h() {
        e();
        this.f1559f = true;
        this.f1557d = false;
        this.f1558e = false;
        this.f1560g = false;
        this.f1561h = false;
    }

    public final void i() {
        this.f1557d = true;
        this.f1559f = false;
        this.f1558e = false;
        f();
    }

    public void j() {
        this.f1557d = false;
        g();
    }

    public void registerOnLoadCanceledListener(InterfaceC0043a<D> interfaceC0043a) {
        if (this.f1556c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f1556c = interfaceC0043a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        a.h.i.b.a(this, sb);
        sb.append(" id=");
        sb.append(this.f1554a);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(b<D> bVar) {
        b<D> bVar2 = this.f1555b;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (bVar2 != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f1555b = null;
    }

    public void unregisterOnLoadCanceledListener(InterfaceC0043a<D> interfaceC0043a) {
        InterfaceC0043a<D> interfaceC0043a2 = this.f1556c;
        if (interfaceC0043a2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0043a2 != interfaceC0043a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f1556c = null;
    }

    public String a(D d2) {
        StringBuilder sb = new StringBuilder(64);
        a.h.i.b.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1554a);
        printWriter.print(" mListener=");
        printWriter.println(this.f1555b);
        if (this.f1557d || this.f1560g || this.f1561h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1557d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f1560g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f1561h);
        }
        if (this.f1558e || this.f1559f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f1558e);
            printWriter.print(" mReset=");
            printWriter.println(this.f1559f);
        }
    }
}
