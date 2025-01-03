package c.c.a.b.c.o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class n0 extends c.c.a.b.f.c.b implements m0 {
    public n0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static m0 a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof m0 ? (m0) queryLocalInterface : new o0(iBinder);
    }

    @Override // c.c.a.b.f.c.b
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            c.c.a.b.d.a zzb = zzb();
            parcel2.writeNoException();
            c.c.a.b.f.c.c.a(parcel2, zzb);
        } else {
            if (i2 != 2) {
                return false;
            }
            int C = C();
            parcel2.writeNoException();
            parcel2.writeInt(C);
        }
        return true;
    }
}
