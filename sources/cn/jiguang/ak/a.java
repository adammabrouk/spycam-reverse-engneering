package cn.jiguang.ak;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.l.b;
import cn.jiguang.l.d;
import com.shix.shixipc.system.ContentCommon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jiguang.l.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f8178a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f8179b;

    /* renamed from: c, reason: collision with root package name */
    public String f8180c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f8181d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f8182e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f8183f = 0;

    private JSONObject a(String str, int i2, int i3) {
        int i4;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(i2);
            jSONArray.put(i3);
            if (!"core".equals(str)) {
                if ("push".equals(str)) {
                    jSONArray.put(d.h());
                    i4 = this.f8183f;
                }
                jSONObject2.put(str, jSONArray);
                jSONObject.put(ContentCommon.TYPE, ActionManager.SDK_TYPE);
                jSONObject.put("itime", d.i(this.f8178a));
                jSONObject.put("sdk", jSONObject2);
                return jSONObject;
            }
            jSONArray.put(d.d());
            i4 = this.f8183f;
            jSONArray.put(i4);
            jSONObject2.put(str, jSONArray);
            jSONObject.put(ContentCommon.TYPE, ActionManager.SDK_TYPE);
            jSONObject.put("itime", d.i(this.f8178a));
            jSONObject.put("sdk", jSONObject2);
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.ai.a.d("JType", "package json exception: " + e2.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, String str, int i2, int i3, int i4) {
        if (TextUtils.isEmpty(str) || i2 < 0 || i3 < 0) {
            return false;
        }
        int o = b.o(context, str);
        cn.jiguang.ai.a.a("JType", "[isTypeReportEnable],lastversion:" + o + ",curversion:" + i4 + ",type:" + str);
        if (o != i4) {
            return true;
        }
        String n = b.n(context, str);
        return !n.equals(i2 + "," + i3);
    }

    @Override // cn.jiguang.l.a
    public String a(Context context) {
        this.f8178a = context;
        return "JType";
    }

    @Override // cn.jiguang.l.a
    public void a(String str, Bundle bundle) {
        this.f8179b = bundle;
    }

    @Override // cn.jiguang.l.a
    public void b(Context context, String str) {
    }

    @Override // cn.jiguang.l.a
    public void d(Context context, String str) {
        JSONObject a2 = a(this.f8180c, this.f8181d, this.f8182e);
        if (a2 == null) {
            cn.jiguang.ai.a.d("JType", "there are no data to report");
        } else {
            d.a(context, a2);
        }
    }

    @Override // cn.jiguang.l.a
    public boolean d() {
        Bundle bundle = this.f8179b;
        if (bundle == null) {
            return false;
        }
        this.f8180c = bundle.getString("name");
        this.f8181d = this.f8179b.getInt("custom", 0);
        this.f8182e = this.f8179b.getInt("dynamic", 0);
        this.f8183f = this.f8179b.getInt("sdk_v", 0);
        cn.jiguang.ai.a.a("JType", "parseBundle type:" + this.f8180c + ",custom:" + this.f8181d + ",dynamic:" + this.f8182e + ",sdkVersion:" + this.f8183f);
        boolean a2 = a(this.f8178a, this.f8180c, this.f8181d, this.f8182e, this.f8183f);
        if (a2) {
            String str = this.f8181d + "," + this.f8182e;
            b.a(this.f8178a, this.f8180c, this.f8183f);
            b.a(this.f8178a, this.f8180c, str);
        } else {
            cn.jiguang.ai.a.a("JType", "type [" + this.f8180c + "] data not change");
        }
        return a2;
    }
}
