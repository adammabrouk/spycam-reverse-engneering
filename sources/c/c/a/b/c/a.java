package c.c.a.b.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.c.a.b.c.o.r;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3802a = false;

    /* renamed from: b, reason: collision with root package name */
    public final BlockingQueue<IBinder> f3803b = new LinkedBlockingQueue();

    public IBinder a(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        r.c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f3802a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f3802a = true;
        IBinder poll = this.f3803b.poll(j, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3803b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
