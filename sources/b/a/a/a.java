package b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.asus.push.DataBuffer;

/* loaded from: classes.dex */
public abstract class a extends Binder implements b {
    public static final String DESCRIPTOR = "cn.asus.push.IAIDLCallback";
    public static final int TRANSACTION_call = 1;

    public a() {
        attachInterface(this, DESCRIPTOR);
    }

    public static b asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new f(iBinder) : (b) queryLocalInterface;
    }

    public static b getDefaultImpl() {
        return f.f2901b;
    }

    public static boolean setDefaultImpl(b bVar) {
        if (f.f2901b != null || bVar == null) {
            return false;
        }
        f.f2901b = bVar;
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
        if (i2 != 1598968902) {
            return super.onTransact(i2, parcel, parcel2, i3);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
