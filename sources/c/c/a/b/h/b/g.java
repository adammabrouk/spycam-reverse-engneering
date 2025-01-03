package c.c.a.b.h.b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.signin.internal.zah;

/* loaded from: classes.dex */
public final class g extends c.c.a.b.f.b.a implements f {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // c.c.a.b.h.b.f
    public final void a(zah zahVar, d dVar) throws RemoteException {
        Parcel f2 = f();
        c.c.a.b.f.b.c.a(f2, zahVar);
        c.c.a.b.f.b.c.a(f2, dVar);
        b(12, f2);
    }
}
