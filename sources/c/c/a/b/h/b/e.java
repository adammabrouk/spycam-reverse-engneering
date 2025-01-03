package c.c.a.b.h.b;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zaj;

/* loaded from: classes.dex */
public abstract class e extends c.c.a.b.f.b.b implements d {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // c.c.a.b.f.b.b
    public boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 3) {
            a((ConnectionResult) c.c.a.b.f.b.c.a(parcel, ConnectionResult.CREATOR), (zaa) c.c.a.b.f.b.c.a(parcel, zaa.CREATOR));
        } else if (i2 == 4) {
            b((Status) c.c.a.b.f.b.c.a(parcel, Status.CREATOR));
        } else if (i2 == 6) {
            a((Status) c.c.a.b.f.b.c.a(parcel, Status.CREATOR));
        } else if (i2 == 7) {
            a((Status) c.c.a.b.f.b.c.a(parcel, Status.CREATOR), (GoogleSignInAccount) c.c.a.b.f.b.c.a(parcel, GoogleSignInAccount.CREATOR));
        } else {
            if (i2 != 8) {
                return false;
            }
            a((zaj) c.c.a.b.f.b.c.a(parcel, zaj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
