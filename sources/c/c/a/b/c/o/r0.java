package c.c.a.b.c.o;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzk;

/* loaded from: classes.dex */
public final class r0 extends c.c.a.b.f.c.a implements p0 {
    public r0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // c.c.a.b.c.o.p0
    public final boolean a(zzk zzkVar, c.c.a.b.d.a aVar) throws RemoteException {
        Parcel zza = zza();
        c.c.a.b.f.c.c.a(zza, zzkVar);
        c.c.a.b.f.c.c.a(zza, aVar);
        Parcel a2 = a(5, zza);
        boolean a3 = c.c.a.b.f.c.c.a(a2);
        a2.recycle();
        return a3;
    }
}
