package cn.jpush.android.bd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.bm.k;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final LocationManager f9516a;

    /* renamed from: b, reason: collision with root package name */
    public Context f9517b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f9518c;

    /* renamed from: e, reason: collision with root package name */
    public volatile a f9520e;

    /* renamed from: f, reason: collision with root package name */
    public volatile b f9521f;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, JSONObject> f9519d = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public boolean f9522g = false;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f9525a;

        /* renamed from: b, reason: collision with root package name */
        public double f9526b;

        /* renamed from: c, reason: collision with root package name */
        public double f9527c;

        public a() {
        }

        public void a(Context context) {
            String n = cn.jpush.android.cache.a.n(context);
            if (TextUtils.isEmpty(n)) {
                return;
            }
            Logger.d("GeofencePullHelper", "last pull state:" + n);
            try {
                a(new JSONObject(n));
            } catch (JSONException unused) {
            }
        }

        public void a(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            Logger.d("GeofencePullHelper", "saveGeofenceLastPullState:" + jSONObject.toString());
            a(jSONObject);
            cn.jpush.android.cache.a.f(f.this.f9517b, jSONObject.toString());
        }

        public void a(JSONObject jSONObject) {
            f.this.f9520e.f9526b = jSONObject.optDouble("lat", 200.0d);
            f.this.f9520e.f9527c = jSONObject.optDouble("lng", 200.0d);
            f.this.f9520e.f9525a = jSONObject.optLong("time", 0L);
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f9529a = 1800;

        /* renamed from: b, reason: collision with root package name */
        public int f9530b = 10800;

        /* renamed from: c, reason: collision with root package name */
        public int f9531c = 900;

        /* renamed from: d, reason: collision with root package name */
        public int f9532d = 20;

        public b() {
        }

        private void a(JSONObject jSONObject) {
            f.this.f9521f.f9529a = jSONObject.optInt("minInterval", f.this.f9521f.f9529a);
            f.this.f9521f.f9530b = jSONObject.optInt("nextInterval", f.this.f9521f.f9530b);
            f.this.f9521f.f9531c = jSONObject.optInt("minLBSInterval", f.this.f9521f.f9531c);
            f.this.f9521f.f9532d = jSONObject.optInt("minLBSKilo", f.this.f9521f.f9532d);
        }

        private void a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i2) {
            if (jSONObject.has(str)) {
                jSONObject2.put(str, i2);
            }
        }

        public void a(Context context) {
            String m = cn.jpush.android.cache.a.m(context);
            if (TextUtils.isEmpty(m)) {
                return;
            }
            Logger.d("GeofencePullHelper", "pull limit:" + m);
            try {
                a(new JSONObject(m));
            } catch (Throwable unused) {
            }
        }

        public void a(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                a(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                a(jSONObject, jSONObject2, "minInterval", f.this.f9521f.f9529a);
                a(jSONObject, jSONObject2, "nextInterval", f.this.f9521f.f9530b);
                a(jSONObject, jSONObject2, "minLBSInterval", f.this.f9521f.f9531c);
                a(jSONObject, jSONObject2, "minLBSKilo", f.this.f9521f.f9532d);
                cn.jpush.android.cache.a.e(context, jSONObject2.toString());
            } catch (Throwable unused) {
                Logger.d("GeofencePullHelper", "save limit failed");
            }
        }
    }

    public f(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f9517b = applicationContext;
        this.f9516a = (LocationManager) applicationContext.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        c();
        i();
        j();
    }

    private void a(double d2, double d3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lat", d2);
            jSONObject.put("lng", d3);
            jSONObject.put("time", System.currentTimeMillis() / 1000);
            long a2 = cn.jpush.android.helper.f.a();
            Logger.dd("GeofencePullHelper", "will send report geo request:" + jSONObject + ",requestid:" + a2);
            HashMap<String, JSONObject> hashMap = this.f9519d;
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("");
            hashMap.put(sb.toString(), jSONObject);
            JCoreHelper.sendRequest(this.f9517b, JPushConstants.SDK_TYPE, 37, 1, a2, 0L, cn.jpush.android.bi.b.c(jSONObject.toString()));
        } catch (Throwable th) {
            Logger.dd("GeofencePullHelper", "send report geo request failed:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("pull geofence after ");
        long j2 = j * 1000;
        sb.append(j2);
        sb.append("ms");
        Logger.dd("GeofencePullHelper", sb.toString());
        Handler handler = this.f9518c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f9518c.removeMessages(1000);
        }
        this.f9518c.sendEmptyMessageDelayed(1000, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("compile loc after ");
        long j2 = j * 1000;
        sb.append(j2);
        sb.append("ms");
        Logger.dd("GeofencePullHelper", sb.toString());
        Handler handler = this.f9518c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1002)) {
            this.f9518c.removeMessages(1002);
        }
        this.f9518c.sendEmptyMessageDelayed(1002, j2);
    }

    private void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("jg_gph_thread") { // from class: cn.jpush.android.bd.f.1
                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e2) {
                        Logger.e("GeofencePullHelper", "handler thread run e:" + e2 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.f9518c = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.bd.f.2
                @Override // android.os.Handler
                @SuppressLint({"MissingPermission"})
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1000:
                            f.this.a(r3.f9521f.f9530b);
                            break;
                        case 1001:
                            break;
                        case 1002:
                            if (f.this.g()) {
                                f.this.a(0L);
                            }
                            f.this.b(r3.f9521f.f9531c);
                            return;
                        default:
                            return;
                    }
                    f.this.f();
                }
            };
        } catch (Throwable th) {
            Logger.ww("GeofencePullHelper", "init geofence pull handler failed:" + th);
        }
    }

    private void d() {
        Logger.dd("GeofencePullHelper", "start schedule geofence pull");
        a((h() || g()) ? 0L : this.f9521f.f9530b);
        b(this.f9521f.f9531c);
    }

    private void e() {
        Logger.dd("GeofencePullHelper", "stop schedule geofence pull");
        Handler handler = this.f9518c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f9518c.removeMessages(1000);
        }
        if (this.f9518c.hasMessages(1001)) {
            this.f9518c.removeMessages(1001);
        }
        if (this.f9518c.hasMessages(1002)) {
            this.f9518c.removeMessages(1002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void f() {
        Logger.dd("GeofencePullHelper", "try pull...");
        Location a2 = c.a(this.f9517b, this.f9516a);
        if (a2 == null) {
            Logger.dd("GeofencePullHelper", "stop pull,get loction failed");
        } else {
            a(a2.getLatitude(), a2.getLongitude());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        Location a2 = c.a(this.f9517b, this.f9516a);
        if (a2 != null) {
            double a3 = k.a(a2.getLongitude(), a2.getLatitude(), this.f9520e.f9527c, this.f9520e.f9526b);
            Logger.d("GeofencePullHelper", "check current distance to last pull distance:" + a3 + ",lbsKilo:" + (this.f9521f.f9532d * 1000));
            if (a3 > this.f9521f.f9532d * 1000) {
                return true;
            }
        }
        Logger.dd("GeofencePullHelper", "loc limit");
        return false;
    }

    private boolean h() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = this.f9520e.f9525a;
        Logger.dd("GeofencePullHelper", "lastPullTime:" + j + ",currentTime:" + currentTimeMillis + ",minInterval:" + this.f9521f.f9529a);
        if (currentTimeMillis - j >= this.f9521f.f9529a) {
            return true;
        }
        Logger.dd("GeofencePullHelper", "time limit");
        return false;
    }

    private void i() {
        this.f9520e = new a();
        this.f9520e.a(this.f9517b);
    }

    private void j() {
        this.f9521f = new b();
        this.f9521f.a(this.f9517b);
        this.f9522g = cn.jpush.android.cache.a.l(this.f9517b);
    }

    public void a() {
        Logger.d("GeofencePullHelper", "onLogin");
        if (this.f9522g) {
            d();
        } else {
            Logger.dd("GeofencePullHelper", "do not support pull");
        }
    }

    public void a(long j, int i2, d dVar) {
        String str;
        StringBuilder sb;
        String str2;
        JSONObject remove = this.f9519d.remove(j + "");
        if (i2 == JPushInterface.ErrorCode.TIMEOUT) {
            sb = new StringBuilder();
            str2 = "pull geo is timeout,requestid:";
        } else {
            if (remove != null) {
                JSONObject a2 = dVar.a();
                if (a2 == null) {
                    str = "onPullResponse empty pull response";
                    Logger.dd("GeofencePullHelper", str);
                }
                this.f9521f.a(this.f9517b, a2);
                JSONArray b2 = dVar.b();
                if (b2 == null) {
                    b2 = new JSONArray();
                }
                Logger.dd("GeofencePullHelper", "onPullResponse:" + b2);
                if (b2.length() == 0) {
                    this.f9522g = false;
                    cn.jpush.android.cache.a.c(this.f9517b, false);
                    e();
                }
                this.f9520e.a(this.f9517b, remove);
                e.a().a(b2);
                cn.jpush.android.bd.a.a(this.f9517b, b2 != null ? b2.toString() : "");
                return;
            }
            sb = new StringBuilder();
            str2 = "can not find request from requestid:";
        }
        sb.append(str2);
        sb.append(j);
        str = sb.toString();
        Logger.dd("GeofencePullHelper", str);
    }

    public void a(cn.jpush.android.bd.b bVar) {
        if (bVar == null) {
            return;
        }
        int a2 = bVar.a();
        Logger.d("GeofencePullHelper", "control pull geo type:" + a2);
        if (this.f9522g ^ (a2 == 1)) {
            boolean z = a2 == 1;
            this.f9522g = z;
            cn.jpush.android.cache.a.c(this.f9517b, z);
            if (this.f9522g) {
                d();
            } else {
                e();
            }
        }
    }

    public void b() {
        Logger.d("GeofencePullHelper", "onTcpDisconnected");
        e();
    }
}
