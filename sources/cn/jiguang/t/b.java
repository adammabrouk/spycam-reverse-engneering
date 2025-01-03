package cn.jiguang.t;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9051a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f9052b = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f9052b.put(iBinder);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("GoogleSericeConnection", "service is connect e: " + th.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
