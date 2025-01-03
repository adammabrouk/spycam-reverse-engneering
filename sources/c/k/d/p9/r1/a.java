package c.k.d.p9.r1;

import android.content.Context;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;

/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7698a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetworkStatusReceiver f7699b;

    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f7699b = networkStatusReceiver;
        this.f7698a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7699b.a(this.f7698a);
    }
}
