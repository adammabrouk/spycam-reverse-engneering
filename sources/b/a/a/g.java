package b.a.a;

import android.os.IBinder;
import android.os.Parcel;
import cn.asus.push.DataBuffer;

/* loaded from: classes.dex */
public final class g implements d {

    /* renamed from: b, reason: collision with root package name */
    public static d f2903b;

    /* renamed from: a, reason: collision with root package name */
    public IBinder f2904a;

    public g(IBinder iBinder) {
        this.f2904a = iBinder;
    }

    @Override // b.a.a.d
    public final void a(DataBuffer dataBuffer, b bVar) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLInvoke");
            if (dataBuffer != null) {
                obtain.writeInt(1);
                dataBuffer.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            if (this.f2904a.transact(2, obtain, null, 1) || c.f() == null) {
                return;
            }
            c.f().a(dataBuffer, bVar);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2904a;
    }
}
