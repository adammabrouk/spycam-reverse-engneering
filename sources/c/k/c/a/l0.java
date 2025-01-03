package c.k.c.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public class l0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f6862a;

    public l0(i0 i0Var) {
        this.f6862a = i0Var;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f6862a) {
            this.f6862a.f6840d = new Messenger(iBinder);
            this.f6862a.f6843g = false;
            list = this.f6862a.f6842f;
            for (Message message : list) {
                try {
                    messenger = this.f6862a.f6840d;
                    messenger.send(message);
                } catch (RemoteException e2) {
                    c.k.a.a.a.c.a(e2);
                }
            }
            list2 = this.f6862a.f6842f;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f6862a.f6840d = null;
        this.f6862a.f6843g = false;
    }
}
