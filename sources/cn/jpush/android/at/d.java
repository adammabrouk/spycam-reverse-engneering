package cn.jpush.android.at;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.utils.MyAudioPlayer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile d f9344a;

    /* renamed from: b, reason: collision with root package name */
    public static AtomicInteger f9345b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public long f9346c = 0;

    /* renamed from: d, reason: collision with root package name */
    public f f9347d = new f() { // from class: cn.jpush.android.at.d.1
        @Override // cn.jpush.android.at.f
        public void a(Message message) {
            Context context = JPushConstants.mApplicationContext;
            d.this.b(context);
            cn.jpush.android.r.b.b("InAppPeriodWorker", "time is up, next period=" + c.a().c());
            d.this.c(context);
        }
    };

    public static d a() {
        if (f9344a == null) {
            synchronized (d.class) {
                if (f9344a == null) {
                    f9344a = new d();
                }
            }
        }
        return f9344a;
    }

    private void a(Context context) {
        g.a().a(MyAudioPlayer.KEY_SAMPLE_RATE, c.a().c() * 1000, this.f9347d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        if (cn.jpush.android.cache.a.e(context)) {
            return;
        }
        c.a().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        cn.jpush.android.r.b.b("InAppPeriodWorker", "periodTask...");
        this.f9346c = SystemClock.elapsedRealtime();
        c.a().a(context, "tcp_rtc", false, 0L);
    }

    public void a(Context context, boolean z) {
        cn.jpush.android.r.b.d("InAppPeriodWorker", "PeriodWorker resume, reset: " + z);
        if (this.f9346c > 0 && SystemClock.elapsedRealtime() > this.f9346c + ((c.a().c() + 5) * 1000)) {
            cn.jpush.android.r.b.d("InAppPeriodWorker", "schedule time is expired, execute now");
            a(context);
            c(context);
        } else if (!z) {
            cn.jpush.android.r.b.b("InAppPeriodWorker", "need not change period task");
        } else {
            cn.jpush.android.r.b.d("InAppPeriodWorker", "force reset init send task and update interval...");
            a(context);
        }
    }
}
