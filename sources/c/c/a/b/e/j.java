package c.c.a.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import c.c.a.b.d.a;

/* loaded from: classes.dex */
public final class j extends c.c.a.b.f.c.a implements i {
    public j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // c.c.a.b.e.i
    public final c.c.a.b.d.a a(c.c.a.b.d.a aVar, String str, int i2) throws RemoteException {
        Parcel zza = zza();
        c.c.a.b.f.c.c.a(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i2);
        Parcel a2 = a(4, zza);
        c.c.a.b.d.a a3 = a.AbstractBinderC0092a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    @Override // c.c.a.b.e.i
    public final c.c.a.b.d.a b(c.c.a.b.d.a aVar, String str, int i2) throws RemoteException {
        Parcel zza = zza();
        c.c.a.b.f.c.c.a(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i2);
        Parcel a2 = a(2, zza);
        c.c.a.b.d.a a3 = a.AbstractBinderC0092a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    @Override // c.c.a.b.e.i
    public final int d() throws RemoteException {
        Parcel a2 = a(6, zza());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // c.c.a.b.e.i
    public final int a(c.c.a.b.d.a aVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        c.c.a.b.f.c.c.a(zza, aVar);
        zza.writeString(str);
        c.c.a.b.f.c.c.a(zza, z);
        Parcel a2 = a(5, zza);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // c.c.a.b.e.i
    public final int b(c.c.a.b.d.a aVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        c.c.a.b.f.c.c.a(zza, aVar);
        zza.writeString(str);
        c.c.a.b.f.c.c.a(zza, z);
        Parcel a2 = a(3, zza);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
