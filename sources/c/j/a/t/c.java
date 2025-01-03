package c.j.a.t;

import android.text.TextUtils;
import c.j.a.z.s;
import c.j.a.z.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UnvarnishedMessage.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f6650a;

    /* renamed from: b, reason: collision with root package name */
    public String f6651b;

    /* renamed from: c, reason: collision with root package name */
    public String f6652c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f6653d = new HashMap();

    public c(String str) {
        a(str);
    }

    public int a() {
        return this.f6650a;
    }

    public void a(long j) {
    }

    public String b() {
        return this.f6651b;
    }

    public String c() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f6650a);
        jSONArray.put(this.f6651b);
        jSONArray.put(this.f6652c);
        Object obj = this.f6653d;
        if (obj == null) {
            obj = new HashMap();
        }
        jSONArray.put(obj);
        return jSONArray.toString();
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                v.a("UnvarnishedMessage", "unvarnishedMsg pack to obj is null");
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.f6650a = jSONArray.optInt(0);
            this.f6651b = jSONArray.getString(1);
            this.f6652c = jSONArray.getString(2);
            this.f6653d = s.a(new JSONObject(jSONArray.getString(3)));
        } catch (JSONException e2) {
            e2.printStackTrace();
            v.a("UnvarnishedMessage", "unvarnishedMsg pack to obj error", e2);
        }
    }
}
