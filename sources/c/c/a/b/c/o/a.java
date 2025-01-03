package c.c.a.b.c.o;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.b.c.o.k;

/* loaded from: classes.dex */
public class a extends k.a {
    public static Account a(k kVar) {
        if (kVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return kVar.e();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
