package cn.jpush.android.v;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9912a;

    public d(Context context, Looper looper) {
        super(looper);
        this.f9912a = context;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            int i2 = message.what;
            if (i2 == 10000) {
                b.a().a(this.f9912a);
            } else if (i2 == 20000) {
                a.a().a(this.f9912a);
            } else if (i2 == 30000) {
                c.a().a(this.f9912a);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("TimerHandler", "TimerHandler - handle message failed, " + th.getMessage());
        }
    }
}
