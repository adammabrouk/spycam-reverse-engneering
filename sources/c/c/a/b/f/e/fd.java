package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class fd extends a implements dd {
    public fd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // c.c.a.b.f.e.dd
    public final void a(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel f2 = f();
        f2.writeString(str);
        f2.writeString(str2);
        s.a(f2, bundle);
        f2.writeLong(j);
        b(1, f2);
    }

    @Override // c.c.a.b.f.e.dd
    public final int zza() throws RemoteException {
        Parcel a2 = a(2, f());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
