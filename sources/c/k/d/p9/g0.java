package c.k.d.p9;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public class g0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f7588a;

    public g0(e0 e0Var) {
        this.f7588a = e0Var;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f7588a) {
            this.f7588a.f7564d = new Messenger(iBinder);
            this.f7588a.f7563c = false;
            list = this.f7588a.f7562b;
            for (Message message : list) {
                try {
                    messenger = this.f7588a.f7564d;
                    messenger.send(message);
                } catch (RemoteException e2) {
                    c.k.a.a.a.c.a(e2);
                }
            }
            list2 = this.f7588a.f7562b;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f7588a.f7564d = null;
        this.f7588a.f7563c = false;
    }
}
