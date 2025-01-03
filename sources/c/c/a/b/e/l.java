package c.c.a.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import c.c.a.b.d.a;

/* loaded from: classes.dex */
public final class l extends c.c.a.b.f.c.a implements k {
    public l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // c.c.a.b.e.k
    public final c.c.a.b.d.a a(c.c.a.b.d.a aVar, String str, int i2, c.c.a.b.d.a aVar2) throws RemoteException {
        Parcel zza = zza();
        c.c.a.b.f.c.c.a(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i2);
        c.c.a.b.f.c.c.a(zza, aVar2);
        Parcel a2 = a(2, zza);
        c.c.a.b.d.a a3 = a.AbstractBinderC0092a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    @Override // c.c.a.b.e.k
    public final c.c.a.b.d.a b(c.c.a.b.d.a aVar, String str, int i2, c.c.a.b.d.a aVar2) throws RemoteException {
        Parcel zza = zza();
        c.c.a.b.f.c.c.a(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i2);
        c.c.a.b.f.c.c.a(zza, aVar2);
        Parcel a2 = a(3, zza);
        c.c.a.b.d.a a3 = a.AbstractBinderC0092a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
