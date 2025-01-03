package c.k.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import c.k.d.k4;

/* loaded from: classes.dex */
public class l4 implements k4.a {

    /* renamed from: b, reason: collision with root package name */
    public Context f7347b;

    /* renamed from: a, reason: collision with root package name */
    public PendingIntent f7346a = null;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f7348c = 0;

    public l4(Context context) {
        this.f7347b = null;
        this.f7347b = context;
    }

    public long a() {
        return g5.b();
    }

    @Override // c.k.d.k4.a
    /* renamed from: a, reason: collision with other method in class */
    public void mo284a() {
        if (this.f7346a != null) {
            try {
                ((AlarmManager) this.f7347b.getSystemService("alarm")).cancel(this.f7346a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f7346a = null;
                c.k.a.a.a.c.c("unregister timer");
                this.f7348c = 0L;
                throw th;
            }
            this.f7346a = null;
            c.k.a.a.a.c.c("unregister timer");
            this.f7348c = 0L;
        }
        this.f7348c = 0L;
    }

    public final void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f7347b.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f7347b, 0, intent, 0);
        this.f7346a = broadcast;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            f0.a(alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.f7346a);
        } else if (i2 >= 19) {
            a(alarmManager, j, broadcast);
        } else {
            alarmManager.set(0, j, broadcast);
        }
        c.k.a.a.a.c.c("register timer " + j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if (r7.f7348c < java.lang.System.currentTimeMillis()) goto L17;
     */
    @Override // c.k.d.k4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r8) {
        /*
            r7 = this;
            long r0 = r7.a()
            r2 = 0
            if (r8 != 0) goto Lf
            long r4 = r7.f7348c
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto Lf
            return
        Lf:
            if (r8 == 0) goto L14
            r7.mo284a()
        L14:
            if (r8 != 0) goto L2d
            long r4 = r7.f7348c
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 != 0) goto L1d
            goto L2d
        L1d:
            long r2 = r7.f7348c
            long r2 = r2 + r0
            r7.f7348c = r2
            long r2 = r7.f7348c
            long r4 = java.lang.System.currentTimeMillis()
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L3a
            goto L33
        L2d:
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2 % r0
            long r0 = r0 - r2
        L33:
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 + r0
            r7.f7348c = r2
        L3a:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r0 = c.k.d.p9.v.m
            r8.<init>(r0)
            android.content.Context r0 = r7.f7347b
            java.lang.String r0 = r0.getPackageName()
            r8.setPackage(r0)
            long r0 = r7.f7348c
            r7.a(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.l4.a(boolean):void");
    }

    @Override // c.k.d.k4.a
    /* renamed from: a */
    public boolean mo268a() {
        return this.f7348c != 0;
    }
}
