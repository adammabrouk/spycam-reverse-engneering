package cn.jpush.android.v;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.Thread;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    public static volatile e f9913d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f9914a = true;

    /* renamed from: b, reason: collision with root package name */
    public d f9915b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f9916c;

    public static e a() {
        if (f9913d == null) {
            synchronized (e.class) {
                f9913d = new e();
            }
        }
        return f9913d;
    }

    private synchronized d l(Context context) {
        if (this.f9916c == null || this.f9916c.getState() == Thread.State.TERMINATED) {
            this.f9916c = new HandlerThread("jg_union_ad_t");
        }
        if (this.f9916c.getState() == Thread.State.NEW) {
            this.f9916c.start();
            this.f9915b = null;
        }
        if (this.f9915b == null) {
            this.f9915b = new d(context, this.f9916c.getLooper());
        }
        return this.f9915b;
    }

    public void a(Context context) {
        try {
            l(context).removeMessages(10000);
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, long j) {
        if (!this.f9914a) {
            cn.jpush.android.r.b.b("TimerManager", "NotifyTimer sendMessage failed, because not enable");
            return;
        }
        try {
            l(context).removeMessages(10000);
            l(context).sendEmptyMessageDelayed(10000, j);
        } catch (Throwable unused) {
        }
        cn.jpush.android.at.c.a().a(context, 21);
    }

    public void a(Context context, long j, boolean z) {
        if (!this.f9914a) {
            cn.jpush.android.r.b.b("TimerManager", "NativeTimer sendMessage failed, because not enable");
            return;
        }
        try {
            l(context).removeMessages(20000);
            l(context).sendEmptyMessageDelayed(20000, j);
        } catch (Throwable unused) {
        }
        if (z) {
            cn.jpush.android.at.c.a().a(context, 22);
        }
    }

    public void a(Context context, String str, long j, long j2) {
        if (TextUtils.equals(str, "0") || TextUtils.isEmpty(str)) {
            cn.jpush.android.r.b.b("TimerManager", "onCmd3 adCode is default");
            return;
        }
        long j3 = j * 1000;
        long j4 = j2 * 1000;
        cn.jpush.android.r.b.b("TimerManager", "onCmd3 adCodeId:" + str + ",interval:" + j3 + ",delayExposureMills:" + j4);
        a.a().b(context, j3, j4);
    }

    public void a(Context context, JSONObject jSONObject) {
        Context context2;
        long j;
        long j2;
        a a2;
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        if (optJSONObject == null) {
            cn.jpush.android.r.b.b("TimerManager", "onCmd77 contentJson is null");
            return;
        }
        long optLong = optJSONObject.optLong("inapp_interval", 120000L) * 1000;
        long optLong2 = optJSONObject.optLong("inapp_max_interval", 120000L) * 1000;
        int optInt = optJSONObject.optInt("ad_type", 0);
        cn.jpush.android.r.b.b("TimerManager", "onCmd77 type:" + optInt + ", interval:" + optLong + ",maxInterval:" + optLong2);
        if (optInt == 0) {
            context2 = context;
            j = optLong;
            j2 = optLong2;
            b.a().a(context2, j, j2);
            a2 = a.a();
        } else if (optInt == 1) {
            b.a().a(context, optLong, optLong2);
            return;
        } else {
            if (optInt != 2) {
                return;
            }
            a2 = a.a();
            context2 = context;
            j = optLong;
            j2 = optLong2;
        }
        a2.a(context2, j, j2);
    }

    public void b(Context context) {
        try {
            l(context).removeMessages(20000);
        } catch (Throwable unused) {
        }
    }

    public void b(Context context, long j) {
        a(context, j, true);
    }

    public void c(Context context) {
        try {
            l(context).removeMessages(30000);
        } catch (Throwable unused) {
        }
    }

    public void c(Context context, long j) {
        try {
            l(context).removeMessages(30000);
            l(context).sendEmptyMessageDelayed(30000, j);
        } catch (Throwable unused) {
        }
    }

    public void d(Context context) {
        cn.jpush.android.at.c.a().a(context, 22);
    }

    public void e(Context context) {
        this.f9914a = true;
        b.a().b(context);
        a.a().b(context);
    }

    public void f(Context context) {
        this.f9914a = false;
        b.a().c(context);
        a.a().c(context);
    }

    public void g(Context context) {
        b.a().b(context);
        a.a().b(context);
        c.a().d(context);
    }

    public void h(Context context) {
        b.a().c(context);
        a.a().c(context);
    }

    public void i(Context context) {
        b.a().d(context);
    }

    public void j(Context context) {
        a.a().e(context);
    }

    public void k(Context context) {
        a.a().d(context);
    }
}
