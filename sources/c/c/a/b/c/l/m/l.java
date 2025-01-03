package c.c.a.b.c.l.m;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import c.c.a.b.c.l.m.b;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class l {
    public l(int i2) {
    }

    public static Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (c.c.a.b.c.s.n.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(b.a<?> aVar) throws DeadObjectException;

    public abstract void a(i iVar, boolean z);

    public abstract void a(Status status);

    public abstract void a(RuntimeException runtimeException);
}
