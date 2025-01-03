package cn.jiguang.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends cn.jiguang.l.a {

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile d f8988c;

    /* renamed from: a, reason: collision with root package name */
    public Context f8989a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f8990b;

    public static d a() {
        if (f8988c == null) {
            synchronized (d.class) {
                if (f8988c == null) {
                    f8988c = new d();
                }
            }
        }
        return f8988c;
    }

    private boolean a(JSONObject jSONObject) {
        if (TextUtils.isEmpty(cn.jiguang.l.b.i(this.f8989a))) {
            cn.jiguang.ai.a.a("JDeviceIds", "ids cache is empty");
        } else {
            try {
                return !r0.equals(cn.jiguang.l.d.c(jSONObject.toString()));
            } catch (Exception e2) {
                cn.jiguang.ai.a.d("JDeviceIds", "[checkIdsChanged] toMD5 error: " + e2.getMessage());
            }
        }
        return true;
    }

    private void e() {
        try {
            Object obj = this.f8990b.get(JThirdPlatFormInterface.KEY_DATA);
            if (obj != null) {
                String c2 = cn.jiguang.l.d.c(cn.jiguang.l.d.g(obj.toString()));
                cn.jiguang.l.b.v(this.f8989a, c2);
                cn.jiguang.ai.a.a("JDeviceIds", "device ids refresh cache success, md5-ids: " + c2);
            }
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("JDeviceIds", "ids encrypted failed, err: " + e2.getMessage());
        }
    }

    @Override // cn.jiguang.l.a
    public String a(Context context) {
        this.f8989a = context;
        return "JDeviceIds";
    }

    @Override // cn.jiguang.l.a
    public void b(Context context, String str) {
        String str2;
        if (cn.jiguang.h.a.a().f(1900)) {
            return;
        }
        try {
            JSONObject a2 = cn.jiguang.r.a.a(context);
            if (a2 == null) {
                cn.jiguang.ai.a.d("JDeviceIds", "ids collect failed");
                return;
            }
            if (!a(a2)) {
                cn.jiguang.ai.a.a("JDeviceIds", "ids not changed, need not report");
                return;
            }
            try {
                str2 = cn.jiguang.l.d.f(a2.toString());
            } catch (Exception e2) {
                cn.jiguang.ai.a.d("JDeviceIds", "ids encrypted failed, err: " + e2.getMessage());
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (this.f8990b == null) {
                this.f8990b = new JSONObject();
            }
            this.f8990b.put(JThirdPlatFormInterface.KEY_DATA, str2);
            cn.jiguang.ai.a.a("JDeviceIds", "collect success:" + this.f8990b + ", origin ids: " + a2.toString());
            super.b(context, str);
        } catch (JSONException e3) {
            cn.jiguang.ai.a.d("JDeviceIds", "packageJson exception: " + e3.getMessage());
        }
    }

    @Override // cn.jiguang.l.a
    public void d(Context context, String str) {
        if (cn.jiguang.h.a.a().f(1900)) {
            return;
        }
        JSONObject jSONObject = this.f8990b;
        if (jSONObject == null) {
            cn.jiguang.ai.a.d("JDeviceIds", "there are no data to report");
            return;
        }
        cn.jiguang.l.d.a(context, jSONObject, "sdk_joa");
        cn.jiguang.l.d.a(context, this.f8990b);
        super.d(context, str);
        e();
        cn.jiguang.ai.a.a("JDeviceIds", str + "report success, reportData: " + this.f8990b);
        this.f8990b = null;
    }
}
