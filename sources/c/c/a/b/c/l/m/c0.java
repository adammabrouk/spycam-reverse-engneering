package c.c.a.b.c.l.m;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.c.a.b.c.l.m.b;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class c0<T> extends v {

    /* renamed from: a, reason: collision with root package name */
    public final c.c.a.b.j.i<T> f3872a;

    public c0(int i2, c.c.a.b.j.i<T> iVar) {
        super(i2);
        this.f3872a = iVar;
    }

    @Override // c.c.a.b.c.l.m.l
    public void a(Status status) {
        this.f3872a.b(new c.c.a.b.c.l.b(status));
    }

    public abstract void d(b.a<?> aVar) throws RemoteException;

    @Override // c.c.a.b.c.l.m.l
    public void a(RuntimeException runtimeException) {
        this.f3872a.b(runtimeException);
    }

    @Override // c.c.a.b.c.l.m.l
    public final void a(b.a<?> aVar) throws DeadObjectException {
        Status a2;
        Status a3;
        try {
            d(aVar);
        } catch (DeadObjectException e2) {
            a3 = l.a(e2);
            a(a3);
            throw e2;
        } catch (RemoteException e3) {
            a2 = l.a(e3);
            a(a2);
        } catch (RuntimeException e4) {
            a(e4);
        }
    }
}
