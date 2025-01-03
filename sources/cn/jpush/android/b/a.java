package cn.jpush.android.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.bd.e;
import cn.jpush.android.bm.k;
import cn.jpush.android.helper.Logger;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.zxing.client.j2se.EncoderConfig;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: b, reason: collision with root package name */
    public long f9471b;

    /* renamed from: c, reason: collision with root package name */
    public LocationManager f9472c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f9473d;

    /* renamed from: e, reason: collision with root package name */
    public long f9474e;

    /* renamed from: f, reason: collision with root package name */
    public long f9475f;

    /* renamed from: g, reason: collision with root package name */
    public String f9476g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9477h;

    /* renamed from: i, reason: collision with root package name */
    @SuppressLint({"MissingPermission"})
    public LocationListener f9478i;
    public final AtomicBoolean j;

    public a(Context context) {
        super(context);
        this.f9474e = 900000L;
        this.f9475f = 20000L;
        this.f9477h = false;
        this.f9478i = new LocationListener() { // from class: cn.jpush.android.b.a.1
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                a.this.f9472c.removeUpdates(this);
                a.this.j.set(false);
                a.this.a(location);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i2, Bundle bundle) {
            }
        };
        this.j = new AtomicBoolean();
        this.f9472c = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        this.f9474e = cn.jpush.android.cache.a.c(context, 900000L);
        this.f9471b = cn.jpush.android.cache.a.c(context, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        LinkedHashMap<String, b> linkedHashMap;
        Logger.dd("CustomGeofenAction", "current location:" + location);
        Handler handler = this.f9473d;
        if (handler != null && handler.hasMessages(1001)) {
            this.f9473d.removeMessages(1001);
        }
        if (location != null && e.a().c() > 0) {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            LinkedHashMap<String, b> b2 = e.a().b();
            Iterator<Map.Entry<String, b>> it = b2.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                b value = it.next().getValue();
                if (value.f9486e * 1000 <= System.currentTimeMillis()) {
                    Logger.dd("CustomGeofenAction", "Out of date geofence " + value.f9482a);
                    it.remove();
                    e.a().a(value);
                } else {
                    LinkedHashMap<String, b> linkedHashMap2 = b2;
                    double a2 = k.a(longitude, latitude, value.f9487f, value.f9488g);
                    Logger.dd("CustomGeofenAction", value.f9482a + " distance to center:" + a2);
                    String str = a2 <= ((double) value.f9483b) ? "in" : EncoderConfig.DEFAULT_OUTPUT_FILE_BASE;
                    double d2 = value.f9483b;
                    Double.isNaN(d2);
                    if (Math.abs(a2 - d2) < 1000.0d) {
                        z = true;
                    }
                    Logger.d("CustomGeofenAction", "lastStatus:" + value.f9489h + ",currentStatus:" + str);
                    Logger.d("CustomGeofenAction", "geofence status :" + value.f9489h + ",currentStatus:" + str + ",geoStatus:" + str);
                    if ((value.f9484c.equals("inside") || !str.equals(value.f9489h)) && !(value.f9484c.equals("inside") && str == EncoderConfig.DEFAULT_OUTPUT_FILE_BASE)) {
                        if ((value.f9484c.equals("inside") || (value.f9489h != null && str.equals(value.f9484c))) && d(value)) {
                            c(value);
                            a(value, location);
                            cn.jpush.android.bd.a.a(this.f9491a, value.a().toString(), latitude, longitude);
                            if (!value.f9485d) {
                                Logger.dd("CustomGeofenAction", "No repeat geofence " + value.f9482a);
                                linkedHashMap = linkedHashMap2;
                                linkedHashMap.remove(value.f9482a);
                                e.a().a(value);
                                value.f9489h = str;
                                e.a().a(value.f9482a, value.a(), false);
                            }
                        }
                        linkedHashMap = linkedHashMap2;
                        value.f9489h = str;
                        e.a().a(value.f9482a, value.a(), false);
                    } else {
                        linkedHashMap = linkedHashMap2;
                    }
                    b2 = linkedHashMap;
                }
            }
            if (this.f9471b == -1) {
                long j = z ? 180000 : 900000;
                if (this.f9474e != j) {
                    this.f9474e = j;
                    Logger.dd("CustomGeofenAction", "need update scan peroid to:" + this.f9474e);
                    b(j);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        Logger.dd("CustomGeofenAction", "Scan geofence after " + j + "ms");
        Handler handler = this.f9473d;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f9473d.removeMessages(1000);
        }
        this.f9473d.sendEmptyMessageDelayed(1000, j);
    }

    private void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("jg_cgf_thread") { // from class: cn.jpush.android.b.a.2
                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e2) {
                        Logger.e("CustomGeofenAction", "handler thread run e:" + e2 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.f9473d = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.b.a.3
                @Override // android.os.Handler
                @SuppressLint({"MissingPermission"})
                public void handleMessage(Message message) {
                    String str;
                    switch (message.what) {
                        case 1000:
                            Logger.d("CustomGeofenAction", "period task tid " + Thread.currentThread().getId());
                            a aVar = a.this;
                            aVar.b(aVar.f9474e);
                            break;
                        case 1001:
                            a.this.d();
                            try {
                                if (a.this.f9476g == null || !a.this.f9476g.equals("gps")) {
                                    str = "Network provider time out!";
                                } else {
                                    Logger.dd("CustomGeofenAction", "GPS provider time out!");
                                    a.this.f9476g = "network";
                                    if (a.this.f9472c.isProviderEnabled(a.this.f9476g)) {
                                        a.this.f9472c.requestLocationUpdates(a.this.f9476g, 2000L, 0.0f, a.this.f9478i);
                                        a.this.f9473d.sendEmptyMessageDelayed(1001, a.this.f9475f / 2);
                                        return;
                                    }
                                    str = "Network provider is disabled";
                                }
                                Logger.dd("CustomGeofenAction", str);
                            } catch (Throwable th) {
                                Logger.dd("CustomGeofenAction", "request location error#" + th);
                            }
                            a.this.j.set(false);
                            return;
                        case 1002:
                            break;
                        default:
                            return;
                    }
                    a.this.e();
                }
            };
        } catch (Throwable th) {
            Logger.ww("CustomGeofenAction", "init geofence handler failed:" + th);
        }
    }

    private void c(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        bVar.o = currentTimeMillis;
        Date date = new Date(currentTimeMillis);
        String format = k.a("yyyy-DDD").format(date);
        if (format.equals(bVar.r)) {
            bVar.s++;
        } else {
            bVar.r = format;
            bVar.s = 1;
        }
        String format2 = k.a("yyyy-ww").format(date);
        if (format2.equals(bVar.p)) {
            bVar.q++;
        } else {
            bVar.p = format2;
            bVar.q = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void d() {
        String str;
        try {
            if (this.f9478i == null) {
                str = "Location listener is null , do nothing!";
            } else {
                if (this.f9472c != null) {
                    this.f9472c.removeUpdates(this.f9478i);
                }
                str = "locationManager is null , do nothing!";
            }
            Logger.w("CustomGeofenAction", str);
        } catch (Throwable th) {
            Logger.w("CustomGeofenAction", "remove location listener failed  e:" + th.getMessage());
        }
    }

    private boolean d(b bVar) {
        StringBuilder sb;
        int i2;
        String sb2;
        if (bVar.o <= 0) {
            return true;
        }
        if (bVar.f9485d) {
            if (bVar.n <= 0 && bVar.f9484c.equals("inside")) {
                bVar.n = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (bVar.n > 0) {
                long j = bVar.o;
                if (j > 0 && currentTimeMillis < j + (r0 * 1000)) {
                    sb = new StringBuilder();
                    sb.append("in ");
                    sb.append(bVar.n);
                    sb.append("s, can't repeat geofence");
                    sb2 = sb.toString();
                }
            }
            if (bVar.m > 0 && !TextUtils.isEmpty(bVar.r)) {
                if (bVar.r.equals(k.a("yyyy-DDD").format(new Date(currentTimeMillis))) && bVar.s >= bVar.m) {
                    sb = new StringBuilder();
                    sb.append("today already repeat enough:");
                    sb.append(bVar.s);
                    sb.append("/");
                    i2 = bVar.m;
                    sb.append(i2);
                    sb2 = sb.toString();
                }
            }
            if (bVar.l > 0 && !TextUtils.isEmpty(bVar.p)) {
                if (bVar.p.equals(k.a("yyyy-ww").format(new Date(currentTimeMillis))) && bVar.q >= bVar.l) {
                    sb = new StringBuilder();
                    sb.append("this week already repeat enough:");
                    sb.append(bVar.q);
                    sb.append("/");
                    i2 = bVar.l;
                    sb.append(i2);
                    sb2 = sb.toString();
                }
            }
            return true;
        }
        sb2 = "can't repeat geofence";
        Logger.dd("CustomGeofenAction", sb2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Logger.d("CustomGeofenAction", "try locate...");
        if (!cn.jpush.android.bd.c.b(this.f9491a, this.f9472c)) {
            Logger.dd("CustomGeofenAction", "No enabled provider");
            return;
        }
        Logger.d("CustomGeofenAction", "sdk int:" + Build.VERSION.SDK_INT + ",targetSdkVersion:" + this.f9491a.getApplicationInfo().targetSdkVersion);
        if (e.a().c() <= 0) {
            a();
        } else if (this.j.get()) {
            Logger.d("CustomGeofenAction", "isLocating...");
        } else {
            f();
        }
    }

    @SuppressLint({"MissingPermission"})
    private void f() {
        String str;
        try {
            if (this.f9472c == null) {
                Logger.ww("CustomGeofenAction", "locationManager is null");
                return;
            }
            Location a2 = cn.jpush.android.bd.c.a(this.f9491a, this.f9472c);
            if (System.currentTimeMillis() - (a2 != null ? a2.getTime() : 0L) < 30000) {
                StringBuilder sb = new StringBuilder();
                sb.append("need not restart gpslocation,the time with last:");
                sb.append(System.currentTimeMillis() - (a2 != null ? a2.getTime() : 0L));
                Logger.dd("CustomGeofenAction", sb.toString());
                a(a2);
                return;
            }
            this.f9476g = null;
            if (this.f9472c.isProviderEnabled("gps")) {
                this.f9476g = "gps";
            } else if (this.f9472c.isProviderEnabled("network")) {
                this.f9476g = "network";
            }
            Logger.d("CustomGeofenAction", "provider " + this.f9476g);
            if (TextUtils.isEmpty(this.f9476g)) {
                Logger.dd("CustomGeofenAction", "not gps nor network provider,stop scan geofence");
                return;
            }
            this.j.set(true);
            this.f9472c.requestLocationUpdates(this.f9476g, 2000L, 0.0f, this.f9478i);
            this.f9473d.sendEmptyMessageDelayed(1001, this.f9475f);
        } catch (SecurityException unused) {
            str = "No suitable permission when get last known location!";
            Logger.ww("CustomGeofenAction", str);
        } catch (Throwable th) {
            str = "The provider is illegal argument!" + th;
            Logger.ww("CustomGeofenAction", str);
        }
    }

    @Override // cn.jpush.android.b.c
    public synchronized void a() {
        Logger.dd("CustomGeofenAction", "geofence size:" + e.a().c());
        Logger.dd("CustomGeofenAction", "stop listen geofence");
        if (this.f9477h) {
            if (this.f9473d != null) {
                this.f9473d.removeMessages(1000);
            }
            this.f9477h = false;
        }
    }

    @Override // cn.jpush.android.b.c
    public void a(long j) {
        Logger.dd("CustomGeofenAction", "Set geofence interval " + j);
        this.f9474e = j;
        this.f9471b = j;
        cn.jpush.android.cache.a.b(this.f9491a, j);
    }

    @Override // cn.jpush.android.b.c
    public void a(b bVar) {
        Handler handler;
        Logger.dd("CustomGeofenAction", "Geofence create success, id=" + bVar.f9482a);
        if (!this.f9477h || (handler = this.f9473d) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    public void a(b bVar, b bVar2) {
        Handler handler;
        if (bVar != null) {
            Logger.dd("CustomGeofenAction", "Geofence update success, id=" + bVar.f9482a);
        }
        if (!this.f9477h || (handler = this.f9473d) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    public synchronized void b() {
        Logger.dd("CustomGeofenAction", "start listen geofence");
        if (!cn.jpush.android.cache.a.o(this.f9491a)) {
            Logger.ww("CustomGeofenAction", "lbs is disable!");
            return;
        }
        if (this.f9477h) {
            Logger.ii("CustomGeofenAction", "geofence is running!");
            return;
        }
        if (e.a().c() == 0) {
            Logger.dd("CustomGeofenAction", "No geofence,not need listen");
            return;
        }
        if (this.f9473d == null) {
            c();
        }
        b(0L);
        this.f9477h = true;
    }

    @Override // cn.jpush.android.b.c
    public void b(b bVar) {
        Logger.dd("CustomGeofenAction", "Geofence delete success, id=" + bVar.f9482a);
    }
}
