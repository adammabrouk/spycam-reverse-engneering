package cn.jiguang.ax;

import android.text.TextUtils;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashSet<g> f8445a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashSet<g> f8446b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashSet<g> f8447c;

    /* renamed from: d, reason: collision with root package name */
    public LinkedHashSet<g> f8448d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedHashSet<g> f8449e;

    /* renamed from: f, reason: collision with root package name */
    public JSONObject f8450f;

    /* renamed from: g, reason: collision with root package name */
    public transient g f8451g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8452h;

    public l(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f8445a = a(jSONObject, "ips");
            this.f8446b = a(jSONObject, "ssl_ips");
            this.f8447c = a(jSONObject, "http_report");
            this.f8448d = a(jSONObject, "https_report");
            this.f8449e = a(jSONObject, "sis_ips");
            this.f8452h = jSONObject.optBoolean("data_report");
            this.f8450f = jSONObject.optJSONObject("tcp_report");
            cn.jiguang.as.d.c("sis", "get sis=" + jSONObject.toString(2));
        } catch (Throwable unused) {
        }
    }

    private LinkedHashSet<g> a(JSONObject jSONObject, String str) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    g a2 = g.a(optJSONArray.optString(i2, null));
                    if (a2 != null && a2.a()) {
                        linkedHashSet.add(a2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return linkedHashSet;
    }

    public boolean a() {
        LinkedHashSet<g> linkedHashSet;
        LinkedHashSet<g> linkedHashSet2 = this.f8445a;
        return (linkedHashSet2 == null || linkedHashSet2.isEmpty()) && ((linkedHashSet = this.f8446b) == null || linkedHashSet.isEmpty());
    }
}
