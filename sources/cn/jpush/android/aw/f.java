package cn.jpush.android.aw;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f9435a;

    /* renamed from: b, reason: collision with root package name */
    public String f9436b;

    /* renamed from: c, reason: collision with root package name */
    public long f9437c;

    public static f a(String str, String str2, long j) {
        f fVar = new f();
        fVar.f9435a = str;
        fVar.f9436b = str2;
        fVar.f9437c = j;
        return fVar;
    }

    public static f a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            f fVar = new f();
            fVar.f9435a = jSONObject.getString("tpl_id");
            fVar.f9436b = jSONObject.getString("tpl_file_name");
            fVar.f9437c = jSONObject.getLong("tpl_recent_use_time");
            return fVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tpl_id", this.f9435a);
            jSONObject.put("tpl_file_name", this.f9436b);
            jSONObject.put("tpl_recent_use_time", this.f9437c);
            return jSONObject;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppTemplate", "in-app template to json failed. " + th.getMessage());
            return null;
        }
    }
}
