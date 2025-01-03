package c.k.d.p9;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class s0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7701a;

    public s0(XMPushService xMPushService) {
        this.f7701a = xMPushService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        super.handleMessage(message);
        if (message != null) {
            try {
                int i2 = message.what;
                if (i2 != 17) {
                    if (i2 == 18) {
                        Message obtain = Message.obtain((Handler) null, 0);
                        obtain.what = 18;
                        Bundle bundle = new Bundle();
                        str = this.f7701a.f11269c;
                        bundle.putString("xmsf_region", str);
                        obtain.setData(bundle);
                        message.replyTo.send(obtain);
                    }
                } else if (message.obj != null) {
                    this.f7701a.onStart((Intent) message.obj, XMPushService.v);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
