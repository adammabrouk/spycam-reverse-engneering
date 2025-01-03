package cn.jiguang.af;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.tencent.bugly.CrashModule;

@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f8142e = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static c f8143h;

    /* renamed from: a, reason: collision with root package name */
    public Handler f8144a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8145b;

    /* renamed from: c, reason: collision with root package name */
    public LocationManager f8146c;

    /* renamed from: d, reason: collision with root package name */
    public cn.jiguang.ag.b f8147d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8148f;

    /* renamed from: g, reason: collision with root package name */
    public String f8149g;

    /* renamed from: i, reason: collision with root package name */
    public LocationListener f8150i = new LocationListener() { // from class: cn.jiguang.af.c.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                cn.jiguang.ai.a.a("JLocationGps", "onLocationChanged:" + location + ",provider:" + c.this.f8149g);
                c.this.a(location);
                c.this.h();
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JLocationGps", "onLocationChanged failed:" + th.getMessage());
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            cn.jiguang.ai.a.a("JLocationGps", "onProviderDisabled:" + str);
            c.this.h();
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            cn.jiguang.ai.a.a("JLocationGps", "onProviderEnabled:" + str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            cn.jiguang.ai.a.a("JLocationGps", "onStatusChanged status:" + i2);
            if (i2 == 0) {
                c.this.h();
            }
        }
    };

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i2 = 1001;
            switch (message.what) {
                case 1001:
                    try {
                        if (c.this.f8149g == null || !c.this.f8149g.equals("network")) {
                            cn.jiguang.ai.a.d("JLocationGps", "get " + c.this.f8149g + " time out ");
                            c.this.h();
                        } else {
                            cn.jiguang.ai.a.d("JLocationGps", "get gps with network time out ");
                            c.this.f8149g = "gps";
                            c.this.g();
                            c.this.f8146c.requestLocationUpdates(c.this.f8149g, 2000L, 0.0f, c.this.f8150i);
                            cn.jiguang.ai.a.a("JLocationGps", "request " + c.this.f8149g + " location");
                            c.this.f8144a.sendEmptyMessageDelayed(1001, 10000L);
                        }
                        break;
                    } catch (Throwable th) {
                        str = "when location time out " + th.getMessage();
                        break;
                    }
                    break;
                case CrashModule.MODULE_ID /* 1004 */:
                    cn.jiguang.ai.a.a("JLocationGps", "LOAD_GPS_ACTION_REQUEST_ONLY_NETWORK");
                    i2 = 1005;
                case 1003:
                    try {
                        c.this.f8146c.requestLocationUpdates(c.this.f8149g, 2000L, 0.0f, c.this.f8150i);
                        cn.jiguang.ai.a.a("JLocationGps", "request " + c.this.f8149g + " location");
                        c.this.f8144a.sendEmptyMessageDelayed(i2, 20000L);
                        break;
                    } catch (SecurityException unused) {
                        str = "No suitable permission when get last known location!";
                        break;
                    } catch (Throwable unused2) {
                        str = "The provider is illegal argument!";
                        break;
                    }
                case 1005:
                    str = "get only network " + c.this.f8149g + " time out ";
                    cn.jiguang.ai.a.d("JLocationGps", str);
                    c.this.h();
                    break;
            }
        }
    }

    public c(Context context) {
        this.f8145b = context;
        this.f8146c = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
    }

    public static c a(Context context) {
        if (f8143h == null) {
            synchronized (f8142e) {
                if (f8143h == null) {
                    f8143h = new c(context);
                }
            }
        }
        return f8143h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if (location == null) {
            this.f8147d = null;
            return;
        }
        cn.jiguang.ai.a.a("JLocationGps", "updateGpsInfo location time:" + location.getTime());
        if (this.f8147d == null) {
            this.f8147d = new cn.jiguang.ag.b();
        }
        this.f8147d.f8164a = cn.jiguang.l.d.a(this.f8145b, location.getTime());
        this.f8147d.f8165b = location.getProvider();
        this.f8147d.f8166c = location.getLatitude();
        this.f8147d.f8167d = location.getLongitude();
        this.f8147d.f8169f = location.getBearing();
        this.f8147d.f8170g = location.getAccuracy();
    }

    private boolean a(Location location, Location location2) {
        if (location == null) {
            return false;
        }
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a2 = a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && a2;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private void f() {
        try {
            if (this.f8144a == null) {
                HandlerThread handlerThread = new HandlerThread("jg_lcn_thread");
                handlerThread.start();
                this.f8144a = new a(handlerThread.getLooper());
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.f("JLocationGps", "start load loc-info failed - error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        String str;
        try {
            if (this.f8150i == null) {
                str = "Location listener is null , do nothing!";
            } else {
                if (this.f8146c != null) {
                    this.f8146c.removeUpdates(this.f8150i);
                }
                str = "locationManager is null , do nothing!";
            }
            cn.jiguang.ai.a.d("JLocationGps", str);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JLocationGps", "remove location listener failed  e:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        cn.jiguang.ai.a.a("JLocationGps", "gps will done");
        this.f8148f = true;
        g();
        if (this.f8144a != null) {
            try {
                if (this.f8144a.hasMessages(CrashModule.MODULE_ID)) {
                    this.f8144a.removeMessages(CrashModule.MODULE_ID);
                }
                if (this.f8144a.hasMessages(1003)) {
                    this.f8144a.removeMessages(1003);
                }
                if (this.f8144a.hasMessages(1001)) {
                    this.f8144a.removeMessages(1001);
                }
                if (this.f8144a.hasMessages(1005)) {
                    this.f8144a.removeMessages(1005);
                }
                this.f8144a.getLooper().quit();
            } finally {
                try {
                } finally {
                }
            }
        } else {
            cn.jiguang.ai.a.e("JLocationGps", "cellLocationManager is null,please check it");
        }
    }

    public cn.jiguang.ag.b a() {
        return this.f8147d;
    }

    public boolean b() {
        return this.f8148f;
    }

    public void c() {
        String str;
        this.f8148f = false;
        this.f8147d = null;
        if (this.f8146c == null) {
            str = "get locationManager failed";
        } else {
            f();
            if (this.f8144a != null) {
                if (this.f8146c.isProviderEnabled("network")) {
                    this.f8149g = "network";
                } else {
                    if (!this.f8146c.isProviderEnabled("gps")) {
                        this.f8149g = "network";
                        this.f8144a.sendEmptyMessage(CrashModule.MODULE_ID);
                        return;
                    }
                    this.f8149g = "gps";
                }
                this.f8144a.sendEmptyMessage(1003);
                return;
            }
            str = " mAsyncHandler is empty";
        }
        cn.jiguang.ai.a.d("JLocationGps", str);
        this.f8148f = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032 A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:3:0x0002, B:5:0x0020, B:9:0x0032, B:11:0x0041, B:18:0x0027), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.jiguang.ag.b d() {
        /*
            r7 = this;
            java.lang.String r0 = "JLocationGps"
            android.location.LocationManager r1 = r7.f8146c     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "gps"
            android.location.Location r1 = r1.getLastKnownLocation(r2)     // Catch: java.lang.Throwable -> L69
            android.location.LocationManager r2 = r7.f8146c     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = "network"
            android.location.Location r2 = r2.getLastKnownLocation(r3)     // Catch: java.lang.Throwable -> L69
            android.location.LocationManager r3 = r7.f8146c     // Catch: java.lang.Throwable -> L69
            java.lang.String r4 = "passive"
            android.location.Location r3 = r3.getLastKnownLocation(r4)     // Catch: java.lang.Throwable -> L69
            boolean r4 = r7.a(r1, r2)     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L27
            boolean r2 = r7.a(r1, r3)     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L2f
            goto L30
        L27:
            boolean r1 = r7.a(r2, r3)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L2f
            r1 = r2
            goto L30
        L2f:
            r1 = r3
        L30:
            if (r1 == 0) goto L82
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L69
            long r4 = r1.getTime()     // Catch: java.lang.Throwable -> L69
            long r2 = r2 - r4
            r4 = 30000(0x7530, double:1.4822E-319)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L82
            r7.a(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "bestLocation:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L69
            cn.jiguang.ag.b r2 = r7.f8147d     // Catch: java.lang.Throwable -> L69
            r1.append(r2)     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = ",curTime:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L69
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L69
            r1.append(r2)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L69
            cn.jiguang.ai.a.a(r0, r1)     // Catch: java.lang.Throwable -> L69
            cn.jiguang.ag.b r0 = r7.f8147d     // Catch: java.lang.Throwable -> L69
            return r0
        L69:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "loadLastGpsInfo failed: "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            cn.jiguang.ai.a.d(r0, r1)
        L82:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.af.c.d():cn.jiguang.ag.b");
    }

    public boolean e() {
        String str;
        try {
            if (this.f8146c == null) {
                return false;
            }
            if (!this.f8146c.isProviderEnabled("gps") && !this.f8146c.isProviderEnabled("network")) {
                if (!this.f8146c.isProviderEnabled("passive")) {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException unused) {
            str = "The provider [gps] is illegal argument!";
            cn.jiguang.ai.a.d("JLocationGps", str);
            return false;
        } catch (SecurityException unused2) {
            str = "No suitable permission is present when get GPS_PROVIDER!";
            cn.jiguang.ai.a.d("JLocationGps", str);
            return false;
        } catch (Exception unused3) {
            str = "The ILocationManager is null!";
            cn.jiguang.ai.a.d("JLocationGps", str);
            return false;
        }
    }
}
