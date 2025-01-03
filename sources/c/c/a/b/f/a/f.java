package c.c.a.b.f.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class f extends a implements d {
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // c.c.a.b.f.a.d
    public final boolean a(boolean z) throws RemoteException {
        Parcel f2 = f();
        c.a(f2, true);
        Parcel a2 = a(2, f2);
        boolean a3 = c.a(a2);
        a2.recycle();
        return a3;
    }

    @Override // c.c.a.b.f.a.d
    public final String c() throws RemoteException {
        Parcel a2 = a(1, f());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }
}
