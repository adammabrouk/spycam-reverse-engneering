package c.c.a.b.c.o;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import c.c.a.b.d.a;
import com.google.android.gms.common.internal.SignInButtonConfig;

/* loaded from: classes.dex */
public final class b0 extends c.c.a.b.f.b.a implements o {
    public b0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // c.c.a.b.c.o.o
    public final c.c.a.b.d.a a(c.c.a.b.d.a aVar, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.b.c.a(f2, aVar);
        c.c.a.b.f.b.c.a(f2, signInButtonConfig);
        Parcel a2 = a(2, f2);
        c.c.a.b.d.a a3 = a.AbstractBinderC0092a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
