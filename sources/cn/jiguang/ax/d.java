package cn.jiguang.ax;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final g f8414a;

    /* renamed from: b, reason: collision with root package name */
    public int f8415b;

    /* renamed from: c, reason: collision with root package name */
    public long f8416c;

    /* renamed from: d, reason: collision with root package name */
    public long f8417d;

    /* renamed from: e, reason: collision with root package name */
    public int f8418e;

    public d(g gVar) {
        this.f8414a = gVar;
    }

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d(new g(jSONObject.getString("ip"), jSONObject.getInt("port")));
            dVar.f8415b = jSONObject.optInt("status");
            dVar.f8416c = jSONObject.optLong("fetch_time");
            dVar.f8417d = jSONObject.optLong("cost");
            dVar.f8418e = jSONObject.optInt("prefer");
            return dVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", this.f8414a.f8423a);
            jSONObject.put("port", this.f8414a.f8424b);
            jSONObject.put("status", this.f8415b);
            jSONObject.put("fetch_time", this.f8416c);
            jSONObject.put("cost", this.f8417d);
            jSONObject.put("prefer", this.f8418e);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f8415b != dVar.f8415b || this.f8416c != dVar.f8416c || this.f8417d != dVar.f8417d || this.f8418e != dVar.f8418e) {
            return false;
        }
        g gVar = this.f8414a;
        g gVar2 = dVar.f8414a;
        return gVar != null ? gVar.equals(gVar2) : gVar2 == null;
    }

    public int hashCode() {
        g gVar = this.f8414a;
        int hashCode = (((gVar != null ? gVar.hashCode() : 0) * 31) + this.f8415b) * 31;
        long j = this.f8416c;
        int i2 = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.f8417d;
        return ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f8418e;
    }

    public String toString() {
        return "IpInfo{ipPort=" + this.f8414a + ", status=" + this.f8415b + ", fetchTime=" + this.f8416c + ", cost=" + this.f8417d + ", prefer=" + this.f8418e + '}';
    }
}
