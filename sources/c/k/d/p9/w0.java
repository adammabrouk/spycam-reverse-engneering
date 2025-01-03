package c.k.d.p9;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.f;

/* loaded from: classes.dex */
public class w0 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7728a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f7728a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m599g;
        super.onChange(z);
        m599g = this.f7728a.m599g();
        c.k.a.a.a.c.m6a("SuperPowerMode:" + m599g);
        this.f7728a.e();
        if (!m599g) {
            this.f7728a.a(true);
        } else {
            XMPushService xMPushService = this.f7728a;
            xMPushService.a(xMPushService.new f(24, null));
        }
    }
}
