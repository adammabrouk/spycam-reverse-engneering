package c.c.b.l;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.iid.zzj;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Messenger f5979a;

    /* renamed from: b, reason: collision with root package name */
    public final zzj f5980b;

    public o(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f5979a = new Messenger(iBinder);
            this.f5980b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f5980b = new zzj(iBinder);
            this.f5979a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f5979a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzj zzjVar = this.f5980b;
        if (zzjVar == null) {
            throw new IllegalStateException("Both messengers are null");
        }
        zzjVar.a(message);
    }
}
