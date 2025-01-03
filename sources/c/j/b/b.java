package c.j.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IPCInvoke.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: IPCInvoke.java */
    public static abstract class a extends Binder implements b {

        /* compiled from: IPCInvoke.java */
        /* renamed from: c.j.b.b$a$a, reason: collision with other inner class name */
        public static class C0126a implements b {

            /* renamed from: b, reason: collision with root package name */
            public static b f6742b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f6743a;

            public C0126a(IBinder iBinder) {
                this.f6743a = iBinder;
            }

            @Override // c.j.b.b
            public Bundle a(Bundle bundle, c.j.b.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.vivo.vms.IPCInvoke");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!this.f6743a.transact(1, obtain, obtain2, 0) && a.f() != null) {
                        return a.f().a(bundle, aVar);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6743a;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.vivo.vms.IPCInvoke");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0126a(iBinder) : (b) queryLocalInterface;
        }

        public static b f() {
            return C0126a.f6742b;
        }
    }

    Bundle a(Bundle bundle, c.j.b.a aVar) throws RemoteException;
}
