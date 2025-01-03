package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class j4 extends a implements k2 {
    public j4(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // c.c.a.b.f.e.k2
    public final Bundle a(Bundle bundle) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, bundle);
        Parcel a2 = a(1, f2);
        Bundle bundle2 = (Bundle) s.a(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle2;
    }
}
