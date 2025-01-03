package c.k.d;

import android.content.Context;

/* loaded from: classes.dex */
public class n0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public c.k.b.c.e f7406a;

    /* renamed from: b, reason: collision with root package name */
    public Context f7407b;

    public void a(Context context) {
        this.f7407b = context;
    }

    public void a(c.k.b.c.e eVar) {
        this.f7406a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r0 a2;
        String str;
        long currentTimeMillis;
        try {
            if (this.f7406a != null) {
                this.f7406a.a();
            }
            c.k.a.a.a.c.c("begin read and send perf / event");
            if (this.f7406a instanceof c.k.b.c.a) {
                a2 = r0.a(this.f7407b);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else {
                if (!(this.f7406a instanceof c.k.b.c.b)) {
                    return;
                }
                a2 = r0.a(this.f7407b);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            }
            a2.m438a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
    }
}
