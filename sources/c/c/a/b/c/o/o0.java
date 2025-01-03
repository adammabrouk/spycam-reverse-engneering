package c.c.a.b.c.o;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import c.c.a.b.d.a;

/* loaded from: classes.dex */
public final class o0 extends c.c.a.b.f.c.a implements m0 {
    public o0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // c.c.a.b.c.o.m0
    public final int C() throws RemoteException {
        Parcel a2 = a(2, zza());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // c.c.a.b.c.o.m0
    public final c.c.a.b.d.a zzb() throws RemoteException {
        Parcel a2 = a(1, zza());
        c.c.a.b.d.a a3 = a.AbstractBinderC0092a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
