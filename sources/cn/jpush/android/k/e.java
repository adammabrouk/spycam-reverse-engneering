package cn.jpush.android.k;

import android.text.TextUtils;
import cn.jiguang.internal.ActionManager;
import cn.jpush.android.api.InAppSlotParams;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f9779a = "";

    /* renamed from: b, reason: collision with root package name */
    public long f9780b = System.currentTimeMillis();

    /* renamed from: c, reason: collision with root package name */
    public String f9781c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f9782d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f9783e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f9784f = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f9785g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f9786h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f9787i = "";
    public int j = -1;
    public String k = "";
    public int l = -1;
    public String m = "";

    public e a(int i2) {
        this.f9783e = i2;
        return this;
    }

    public e a(String str) {
        this.f9779a = str;
        return this;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f9779a)) {
                jSONObject.put("id", this.f9779a);
            }
            if (this.f9780b != -1) {
                jSONObject.put("time", this.f9780b);
            }
            if (!TextUtils.isEmpty(this.f9781c)) {
                jSONObject.put(ActionManager.SDK_VERSION, this.f9781c);
            }
            if (!TextUtils.isEmpty(this.f9782d)) {
                jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, this.f9782d);
            }
            if (this.f9783e != -1) {
                jSONObject.put("render", this.f9783e);
            }
            if (this.f9784f != -1) {
                jSONObject.put("result", this.f9784f);
            }
            if (!TextUtils.isEmpty(this.f9785g)) {
                jSONObject.put("ad_code_id", this.f9785g);
            }
            if (!TextUtils.isEmpty(this.f9786h)) {
                jSONObject.put("ad_code_name", this.f9786h);
            }
            if (!TextUtils.isEmpty(this.f9787i)) {
                jSONObject.put("url", this.f9787i);
            }
            if (this.j != -1) {
                jSONObject.put("url_result", this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject.put("page", this.k);
            }
            if (this.l != -1) {
                jSONObject.put("duration", this.l);
            }
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject.put("feedback", this.m);
            }
            JSONObject jSONObject2 = new JSONObject();
            cn.jpush.android.s.a c2 = cn.jpush.android.n.b.a().c();
            jSONObject2.put("core_version", c2.g());
            jSONObject2.put("push_version", c2.e());
            jSONObject2.put("local_push_version", c2.f());
            jSONObject.put("sdk_info", jSONObject2);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public e b(int i2) {
        this.f9784f = i2;
        return this;
    }

    public e b(String str) {
        this.f9782d = str;
        return this;
    }

    public e c(int i2) {
        this.j = i2;
        return this;
    }

    public e c(String str) {
        this.f9785g = str;
        return this;
    }

    public e d(int i2) {
        this.l = i2;
        return this;
    }

    public e d(String str) {
        this.f9786h = str;
        return this;
    }

    public e e(String str) {
        this.f9787i = str;
        return this;
    }

    public e f(String str) {
        this.k = str;
        return this;
    }

    public e g(String str) {
        this.m = str;
        return this;
    }
}
