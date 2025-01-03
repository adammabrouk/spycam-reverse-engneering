package c.c.a.b.c.o;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface k extends IInterface {

    public static abstract class a extends c.c.a.b.f.c.b implements k {

        /* renamed from: c.c.a.b.c.o.k$a$a, reason: collision with other inner class name */
        public static class C0089a extends c.c.a.b.f.c.a implements k {
            public C0089a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // c.c.a.b.c.o.k
            public final Account e() throws RemoteException {
                Parcel a2 = a(2, zza());
                Account account = (Account) c.c.a.b.f.c.c.a(a2, Account.CREATOR);
                a2.recycle();
                return account;
            }
        }

        public static k a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof k ? (k) queryLocalInterface : new C0089a(iBinder);
        }
    }

    Account e() throws RemoteException;
}
