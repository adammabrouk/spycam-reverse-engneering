package c.k.d.p9;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.f;

/* loaded from: classes.dex */
public class v0 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7721a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f7721a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m598f;
        super.onChange(z);
        m598f = this.f7721a.m598f();
        c.k.a.a.a.c.m6a("ExtremePowerMode:" + m598f);
        if (!m598f) {
            this.f7721a.a(true);
        } else {
            XMPushService xMPushService = this.f7721a;
            xMPushService.a(xMPushService.new f(23, null));
        }
    }
}
