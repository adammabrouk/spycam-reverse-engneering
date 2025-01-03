package cn.jiguang.aq;

import com.shix.shixipc.system.ContentCommon;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f8334a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8335b;

    /* renamed from: c, reason: collision with root package name */
    public int f8336c;

    public a(JSONObject jSONObject) {
        this.f8334a = jSONObject.optString("key");
        this.f8335b = jSONObject.opt("value");
        this.f8336c = jSONObject.optInt(ContentCommon.TYPE, -1);
    }

    public String a() {
        return this.f8334a;
    }

    public void a(Object obj) {
        this.f8335b = obj;
    }

    public Object b() {
        return this.f8335b;
    }

    public int c() {
        return this.f8336c;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.f8334a);
            jSONObject.put("value", this.f8335b);
            jSONObject.put(ContentCommon.TYPE, this.f8336c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "UserPropertiesBean{key='" + this.f8334a + "', value='" + this.f8335b + "', type='" + this.f8336c + "'}";
    }
}
