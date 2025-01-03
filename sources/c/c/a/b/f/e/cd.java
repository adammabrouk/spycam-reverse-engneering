package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class cd extends j1 implements dd {
    public cd() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // c.c.a.b.f.e.j1
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            a(parcel.readString(), parcel.readString(), (Bundle) s.a(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        } else {
            if (i2 != 2) {
                return false;
            }
            int zza = zza();
            parcel2.writeNoException();
            parcel2.writeInt(zza);
        }
        return true;
    }
}
