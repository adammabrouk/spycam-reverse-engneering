package c.c.a.b.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import c.c.a.b.c.s.p;
import c.c.a.b.c.s.r;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes.dex */
public class a {
    public static ScheduledExecutorService l;

    /* renamed from: a, reason: collision with root package name */
    public final Object f5246a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f5247b;

    /* renamed from: c, reason: collision with root package name */
    public WorkSource f5248c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5249d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5250e;

    /* renamed from: f, reason: collision with root package name */
    public final String f5251f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f5252g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5253h;

    /* renamed from: i, reason: collision with root package name */
    public final Map<String, Integer[]> f5254i;
    public int j;
    public AtomicInteger k;

    static {
        new b();
    }

    public a(Context context, int i2, String str) {
        this(context, i2, str, null, context == null ? null : context.getPackageName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        if (r2 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
    
        c.c.a.b.c.r.d.a().a(r13.f5252g, c.c.a.b.c.r.c.a(r13.f5247b, r6), 7, r13.f5250e, r6, null, r13.f5249d, b(), r14);
        r13.j++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r13.j == 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.k
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.a(r0)
            java.lang.Object r0 = r13.f5246a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f5254i     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L96
            r2 = 0
            if (r1 == 0) goto L1a
            int r1 = r13.j     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L29
        L1a:
            android.os.PowerManager$WakeLock r1 = r13.f5247b     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f5254i     // Catch: java.lang.Throwable -> L96
            r1.clear()     // Catch: java.lang.Throwable -> L96
            r13.j = r2     // Catch: java.lang.Throwable -> L96
        L29:
            boolean r1 = r13.f5253h     // Catch: java.lang.Throwable -> L96
            r12 = 1
            if (r1 == 0) goto L56
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f5254i     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L47
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f5254i     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch: java.lang.Throwable -> L96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L96
            r3[r2] = r4     // Catch: java.lang.Throwable -> L96
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L96
            r2 = 1
            goto L54
        L47:
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L96
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L96
            r1[r2] = r3     // Catch: java.lang.Throwable -> L96
        L54:
            if (r2 != 0) goto L5e
        L56:
            boolean r1 = r13.f5253h     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
            int r1 = r13.j     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
        L5e:
            c.c.a.b.c.r.d r1 = c.c.a.b.c.r.d.a()     // Catch: java.lang.Throwable -> L96
            android.content.Context r2 = r13.f5252g     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r3 = r13.f5247b     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = c.c.a.b.c.r.c.a(r3, r6)     // Catch: java.lang.Throwable -> L96
            r4 = 7
            java.lang.String r5 = r13.f5250e     // Catch: java.lang.Throwable -> L96
            r7 = 0
            int r8 = r13.f5249d     // Catch: java.lang.Throwable -> L96
            java.util.List r9 = r13.b()     // Catch: java.lang.Throwable -> L96
            r10 = r14
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96
            int r1 = r13.j     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r12
            r13.j = r1     // Catch: java.lang.Throwable -> L96
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r0 = r13.f5247b
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L95
            java.util.concurrent.ScheduledExecutorService r0 = c.c.a.b.i.a.l
            c.c.a.b.i.c r1 = new c.c.a.b.i.c
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L95:
            return
        L96:
            r14 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.i.a.a(long):void");
    }

    public final List<String> b() {
        return r.a(this.f5248c);
    }

    public a(Context context, int i2, String str, String str2, String str3) {
        this(context, i2, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public a(Context context, int i2, String str, String str2, String str3, String str4) {
        this.f5246a = this;
        this.f5253h = true;
        this.f5254i = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.k = new AtomicInteger(0);
        c.c.a.b.c.o.r.a(context, "WakeLock: context must not be null");
        c.c.a.b.c.o.r.a(str, (Object) "WakeLock: wakeLockName must not be empty");
        this.f5249d = i2;
        this.f5251f = null;
        this.f5252g = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f5250e = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f5250e = str;
        }
        this.f5247b = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        if (r.a(context)) {
            WorkSource a2 = r.a(context, p.a(str3) ? context.getPackageName() : str3);
            this.f5248c = a2;
            if (a2 != null && r.a(this.f5252g)) {
                WorkSource workSource = this.f5248c;
                if (workSource != null) {
                    workSource.add(a2);
                } else {
                    this.f5248c = a2;
                }
                try {
                    this.f5247b.setWorkSource(this.f5248c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (l == null) {
            l = c.c.a.b.c.p.a.a().a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
    
        if (r1 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        c.c.a.b.c.r.d.a().a(r12.f5252g, c.c.a.b.c.r.c.a(r12.f5247b, r6), 8, r12.f5250e, r6, null, r12.f5249d, b());
        r12.j--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r12.j == 1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.k
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L19
            java.lang.String r0 = r12.f5250e
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = " release without a matched acquire!"
            java.lang.String r0 = r0.concat(r1)
            java.lang.String r1 = "WakeLock"
            android.util.Log.e(r1, r0)
        L19:
            r0 = 0
            java.lang.String r6 = r12.a(r0)
            java.lang.Object r0 = r12.f5246a
            monitor-enter(r0)
            boolean r1 = r12.f5253h     // Catch: java.lang.Throwable -> L7e
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L52
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f5254i     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L33
        L31:
            r1 = 0
            goto L50
        L33:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r2 != r10) goto L42
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f5254i     // Catch: java.lang.Throwable -> L7e
            r1.remove(r6)     // Catch: java.lang.Throwable -> L7e
            r1 = 1
            goto L50
        L42:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L7e
            r1[r11] = r2     // Catch: java.lang.Throwable -> L7e
            goto L31
        L50:
            if (r1 != 0) goto L5a
        L52:
            boolean r1 = r12.f5253h     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L79
            int r1 = r12.j     // Catch: java.lang.Throwable -> L7e
            if (r1 != r10) goto L79
        L5a:
            c.c.a.b.c.r.d r1 = c.c.a.b.c.r.d.a()     // Catch: java.lang.Throwable -> L7e
            android.content.Context r2 = r12.f5252g     // Catch: java.lang.Throwable -> L7e
            android.os.PowerManager$WakeLock r3 = r12.f5247b     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = c.c.a.b.c.r.c.a(r3, r6)     // Catch: java.lang.Throwable -> L7e
            r4 = 8
            java.lang.String r5 = r12.f5250e     // Catch: java.lang.Throwable -> L7e
            r7 = 0
            int r8 = r12.f5249d     // Catch: java.lang.Throwable -> L7e
            java.util.List r9 = r12.b()     // Catch: java.lang.Throwable -> L7e
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7e
            int r1 = r12.j     // Catch: java.lang.Throwable -> L7e
            int r1 = r1 - r10
            r12.j = r1     // Catch: java.lang.Throwable -> L7e
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r12.a(r11)
            return
        L7e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            goto L82
        L81:
            throw r1
        L82:
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.i.a.a():void");
    }

    public final void a(int i2) {
        if (this.f5247b.isHeld()) {
            try {
                this.f5247b.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f5250e).concat(" was already released!"), e2);
                } else {
                    throw e2;
                }
            }
            this.f5247b.isHeld();
        }
    }

    public final String a(String str) {
        return (!this.f5253h || TextUtils.isEmpty(str)) ? this.f5251f : str;
    }

    public void a(boolean z) {
        this.f5247b.setReferenceCounted(z);
        this.f5253h = z;
    }
}
