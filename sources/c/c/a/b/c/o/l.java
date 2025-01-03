package c.c.a.b.c.o;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzb;

/* loaded from: classes.dex */
public interface l extends IInterface {

    public static abstract class a extends c.c.a.b.f.c.b implements l {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // c.c.a.b.f.c.b
        public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.c.a.b.f.c.c.a(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                a(parcel.readInt(), (Bundle) c.c.a.b.f.c.c.a(parcel, Bundle.CREATOR));
            } else {
                if (i2 != 3) {
                    return false;
                }
                a(parcel.readInt(), parcel.readStrongBinder(), (zzb) c.c.a.b.f.c.c.a(parcel, zzb.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i2, Bundle bundle) throws RemoteException;

    void a(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(int i2, IBinder iBinder, zzb zzbVar) throws RemoteException;
}
