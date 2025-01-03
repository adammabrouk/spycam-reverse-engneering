package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class ad extends a implements yc {
    public ad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // c.c.a.b.f.e.yc
    public final void a(Bundle bundle) throws RemoteException {
        Parcel f2 = f();
        s.a(f2, bundle);
        b(1, f2);
    }
}
