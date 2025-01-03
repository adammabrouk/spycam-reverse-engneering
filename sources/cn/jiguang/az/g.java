package cn.jiguang.az;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import com.shix.shixipc.utils.MyAudioPlayer;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static volatile g f8565a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8566b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public Context f8567c;

    /* renamed from: d, reason: collision with root package name */
    public cn.jiguang.bd.a f8568d = new cn.jiguang.bd.a() { // from class: cn.jiguang.az.g.1
        @Override // cn.jiguang.bd.a
        public void a(Message message) {
            cn.jiguang.as.d.c("PeriodWorker", "time is up, next period=" + (h.a().g() * 1000));
            g gVar = g.this;
            gVar.c(gVar.f8567c);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public long f8569e;

    public static g a() {
        if (f8565a == null) {
            synchronized (f8566b) {
                if (f8565a == null) {
                    f8565a = new g();
                }
            }
        }
        return f8565a;
    }

    private void b(Context context) {
        this.f8569e = SystemClock.elapsedRealtime();
        if (((Boolean) cn.jiguang.f.b.a(context, cn.jiguang.f.a.C())).booleanValue()) {
            a.a(context);
        } else {
            a.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        cn.jiguang.as.d.c("PeriodWorker", "periodTask...");
        b(context);
        cn.jiguang.a.a.a(context, false, 0L);
        b.a().a(context, 19, 0, "periodTask");
        e.a(context, "periodtask", null);
        cn.jiguang.ap.e.c(context);
    }

    public void a(Context context) {
        this.f8567c = context;
        cn.jiguang.bd.b.a().a(MyAudioPlayer.KEY_SAMPLE_RATE, h.a().f() * 1000, this.f8568d);
    }

    public void a(Context context, boolean z) {
        cn.jiguang.as.d.e("PeriodWorker", "PeriodWorker resume");
        if (this.f8569e > 0 && SystemClock.elapsedRealtime() > this.f8569e + ((h.a().f() + 5) * 1000)) {
            cn.jiguang.as.d.e("PeriodWorker", "schedule time is expired, execute now");
            a(context);
            c(context);
        } else if (!z) {
            cn.jiguang.as.d.c("PeriodWorker", "need not change period task");
        } else {
            a(context);
            b(context);
        }
    }

    public void b() {
        this.f8569e = SystemClock.elapsedRealtime();
        a.a(this.f8567c);
        cn.jiguang.bd.b.a().a(MyAudioPlayer.KEY_SAMPLE_RATE, h.a().f() * 1000, this.f8568d);
    }
}
