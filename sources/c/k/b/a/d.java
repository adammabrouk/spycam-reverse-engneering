package c.k.b.a;

import c.k.d.g9;
import c.k.d.o0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f6769a;

    /* renamed from: b, reason: collision with root package name */
    public String f6770b;

    /* renamed from: c, reason: collision with root package name */
    public int f6771c;

    /* renamed from: d, reason: collision with root package name */
    public String f6772d = o0.a();

    /* renamed from: e, reason: collision with root package name */
    public String f6773e = g9.m180a();

    /* renamed from: f, reason: collision with root package name */
    public String f6774f;

    /* renamed from: g, reason: collision with root package name */
    public String f6775g;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.f6769a);
            jSONObject.put("reportType", this.f6771c);
            jSONObject.put("clientInterfaceId", this.f6770b);
            jSONObject.put("os", this.f6772d);
            jSONObject.put("miuiVersion", this.f6773e);
            jSONObject.put("pkgName", this.f6774f);
            jSONObject.put("sdkVersion", this.f6775g);
            return jSONObject;
        } catch (JSONException e2) {
            c.k.a.a.a.c.a(e2);
            return null;
        }
    }

    public void a(String str) {
        this.f6774f = str;
    }

    public String b() {
        JSONObject a2 = a();
        return a2 == null ? "" : a2.toString();
    }

    public void b(String str) {
        this.f6775g = str;
    }
}
