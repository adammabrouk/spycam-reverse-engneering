package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class bd extends j1 implements yc {
    public bd() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // c.c.a.b.f.e.j1
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        a((Bundle) s.a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
