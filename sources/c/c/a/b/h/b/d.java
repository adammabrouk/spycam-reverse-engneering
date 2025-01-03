package c.c.a.b.h.b;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zaj;

/* loaded from: classes.dex */
public interface d extends IInterface {
    void a(ConnectionResult connectionResult, zaa zaaVar) throws RemoteException;

    void a(Status status) throws RemoteException;

    void a(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void a(zaj zajVar) throws RemoteException;

    void b(Status status) throws RemoteException;
}
