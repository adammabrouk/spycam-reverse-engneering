package c.c.a.b.c.o;

import android.os.IBinder;
import android.os.IInterface;
import c.c.a.b.c.l.a;

/* loaded from: classes.dex */
public class t<T extends IInterface> extends g<T> {
    public final a.h<T> y;

    public a.h<T> B() {
        return this.y;
    }

    @Override // c.c.a.b.c.o.c
    public T a(IBinder iBinder) {
        return this.y.a(iBinder);
    }

    @Override // c.c.a.b.c.o.c
    public String b() {
        return this.y.b();
    }

    @Override // c.c.a.b.c.o.g, c.c.a.b.c.o.c, c.c.a.b.c.l.a.f
    public int d() {
        return super.d();
    }

    @Override // c.c.a.b.c.o.c
    public String k() {
        return this.y.k();
    }

    @Override // c.c.a.b.c.o.c
    public void b(int i2, T t) {
        this.y.a(i2, t);
    }
}
