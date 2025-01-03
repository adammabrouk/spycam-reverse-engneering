package cn.jpush.android.b;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.shix.shixipc.system.ContentCommon;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b implements Serializable {
    public static final long serialVersionUID = 2310616383854860780L;

    /* renamed from: a, reason: collision with root package name */
    public String f9482a;

    /* renamed from: b, reason: collision with root package name */
    public long f9483b;

    /* renamed from: c, reason: collision with root package name */
    public String f9484c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9485d;

    /* renamed from: e, reason: collision with root package name */
    public long f9486e;

    /* renamed from: f, reason: collision with root package name */
    public double f9487f = 200.0d;

    /* renamed from: g, reason: collision with root package name */
    public double f9488g = 200.0d;

    /* renamed from: h, reason: collision with root package name */
    public String f9489h;

    /* renamed from: i, reason: collision with root package name */
    public int f9490i;
    public String j;
    public String k;
    public int l;
    public int m;
    public int n;
    public long o;
    public String p;
    public int q;
    public String r;
    public int s;
    public cn.jpush.android.d.d t;

    public static b a(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.k = jSONObject.optString("op");
            bVar.f9482a = jSONObject.optString("geofenceid");
            bVar.j = jSONObject.optString("name");
            bVar.f9483b = jSONObject.optLong("radius");
            bVar.f9484c = jSONObject.optString("status");
            bVar.f9485d = jSONObject.optBoolean("repeat");
            bVar.l = jSONObject.optInt("repeat_week_num");
            bVar.m = jSONObject.optInt("repeat_day_num");
            bVar.n = jSONObject.optInt("repeat_time");
            bVar.f9486e = jSONObject.optLong("expiration");
            bVar.f9490i = jSONObject.optInt(ContentCommon.TYPE, 1);
            bVar.f9487f = jSONObject.optDouble("lon", 200.0d);
            bVar.f9488g = jSONObject.optDouble("lat", 200.0d);
            bVar.o = jSONObject.optLong("lastTime");
            bVar.p = jSONObject.optString("lastTimeWeek");
            bVar.q = jSONObject.optInt("weekNum");
            bVar.r = jSONObject.optString("lastTimeDay");
            bVar.s = jSONObject.optInt("dayNum");
            bVar.f9489h = jSONObject.optString("lastGeoStatus");
            String optString = jSONObject.optString("entity");
            if (!TextUtils.isEmpty(optString)) {
                bVar.t = cn.jpush.android.d.d.a(optString, context.getPackageName(), JCoreHelper.getAppKey(context), 0L);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static b a(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.k = jSONObject.optString("op");
            bVar.f9482a = jSONObject.optString("geofenceid");
            bVar.j = jSONObject.optString("name");
            bVar.f9483b = jSONObject.optLong("radius");
            bVar.f9484c = jSONObject.optString("status");
            bVar.f9485d = jSONObject.optBoolean("repeat");
            bVar.l = jSONObject.optInt("repeat_week_num");
            bVar.m = jSONObject.optInt("repeat_day_num");
            bVar.n = jSONObject.optInt("repeat_time");
            bVar.f9486e = jSONObject.optLong("expiration");
            bVar.f9490i = jSONObject.optInt(ContentCommon.TYPE, 1);
            JSONObject optJSONObject = jSONObject.optJSONObject("center");
            if (optJSONObject != null) {
                bVar.f9487f = optJSONObject.optDouble("lon", 200.0d);
                bVar.f9488g = optJSONObject.optDouble("lat", 200.0d);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", this.k);
            jSONObject.put("geofenceid", this.f9482a);
            jSONObject.put("name", this.j);
            jSONObject.put("radius", this.f9483b);
            jSONObject.put("status", this.f9484c);
            jSONObject.put("repeat", this.f9485d);
            jSONObject.put("repeat_week_num", this.l);
            jSONObject.put("repeat_day_num", this.m);
            jSONObject.put("repeat_time", this.n);
            jSONObject.put("expiration", this.f9486e);
            jSONObject.put(ContentCommon.TYPE, this.f9490i);
            jSONObject.put("lon", this.f9487f);
            jSONObject.put("lat", this.f9488g);
            jSONObject.put("lastTime", this.o);
            jSONObject.put("lastTimeWeek", this.p);
            jSONObject.put("weekNum", this.q);
            jSONObject.put("lastTimeDay", this.r);
            jSONObject.put("dayNum", this.s);
            jSONObject.put("lastGeoStatus", this.f9489h);
            if (this.t != null) {
                jSONObject.put("entity", this.t.f9705i);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(b bVar) {
        this.f9489h = bVar.f9489h;
        this.o = bVar.o;
        this.p = bVar.p;
        this.r = bVar.r;
        this.q = bVar.q;
        this.s = bVar.s;
    }

    public void b(JSONObject jSONObject) {
        try {
            if (jSONObject.has("name")) {
                this.j = jSONObject.optString("name");
            }
            long optLong = jSONObject.optLong("radius", -1L);
            if (optLong > 0) {
                this.f9483b = optLong;
            }
            if (jSONObject.has("status")) {
                this.f9484c = jSONObject.optString("status");
            }
            if (jSONObject.has("repeat")) {
                boolean optBoolean = jSONObject.optBoolean("repeat");
                this.f9485d = optBoolean;
                if (optBoolean) {
                    if (jSONObject.has("repeat_week_num")) {
                        this.l = jSONObject.optInt("repeat_week_num");
                    }
                    if (jSONObject.has("repeat_day_num")) {
                        this.m = jSONObject.optInt("repeat_day_num");
                    }
                    if (jSONObject.has("repeat_time")) {
                        this.n = jSONObject.optInt("repeat_time");
                    }
                }
            }
            if (jSONObject.has("expiration")) {
                this.f9486e = jSONObject.optLong("expiration");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("center");
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("lon", 200.0d);
                double optDouble2 = optJSONObject.optDouble("lat", 200.0d);
                if (optDouble >= -180.0d && optDouble <= 180.0d && optDouble2 >= -90.0d && optDouble2 <= 90.0d) {
                    this.f9487f = optDouble;
                    this.f9488g = optDouble2;
                    return;
                }
                Logger.w("Geofence", "update center failed because value invalid, [" + optDouble2 + "," + optDouble + "]");
            }
        } catch (Throwable unused) {
        }
    }
}
