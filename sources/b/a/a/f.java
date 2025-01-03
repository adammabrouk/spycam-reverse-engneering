package b.a.a;

import android.os.IBinder;
import android.os.Parcel;
import cn.asus.push.DataBuffer;

/* loaded from: classes.dex */
public final class f implements b {

    /* renamed from: b, reason: collision with root package name */
    public static b f2901b;

    /* renamed from: a, reason: collision with root package name */
    public IBinder f2902a;

    public f(IBinder iBinder) {
        this.f2902a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2902a;
    }

    @Override // b.a.a.b
    public final void call(DataBuffer dataBuffer) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(a.DESCRIPTOR);
            if (dataBuffer != null) {
                obtain.writeInt(1);
                dataBuffer.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (this.f2902a.transact(1, obtain, null, 1) || a.getDefaultImpl() == null) {
                return;
            }
            a.getDefaultImpl().call(dataBuffer);
        } finally {
            obtain.recycle();
        }
    }
}
