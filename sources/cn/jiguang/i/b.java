package cn.jiguang.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.l.d;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends cn.jiguang.l.a {

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile b f8903c;

    /* renamed from: a, reason: collision with root package name */
    public Context f8904a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f8905b;

    /* renamed from: d, reason: collision with root package name */
    public String f8906d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8907e;

    public static b a() {
        if (f8903c == null) {
            synchronized (b.class) {
                if (f8903c == null) {
                    f8903c = new b();
                }
            }
        }
        return f8903c;
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<cn.jiguang.j.a> list) {
        try {
            if (this.f8905b == null) {
                this.f8905b = new JSONObject();
            }
            if (cn.jiguang.h.a.a().d(1608)) {
                this.f8905b.put("ssid", str);
            }
            if (cn.jiguang.h.a.a().d(1601)) {
                this.f8905b.put("bssid", str2);
            }
            if (cn.jiguang.h.a.a().d(1605)) {
                this.f8905b.put("local_ip", str3);
            }
            if (cn.jiguang.h.a.a().d(1606)) {
                this.f8905b.put("local_mac", str4);
            }
            if (cn.jiguang.h.a.a().d(1607)) {
                this.f8905b.put("netmask", str5);
            }
            if (cn.jiguang.h.a.a().d(1604)) {
                this.f8905b.put("gateway", str8);
            }
            if (cn.jiguang.h.a.a().d(1602)) {
                this.f8905b.put("dhcp", str9);
            }
            if (cn.jiguang.h.a.a().d(1603)) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(str6)) {
                    jSONArray.put(str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    jSONArray.put(str7);
                }
                this.f8905b.put("dns", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (cn.jiguang.j.a aVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", aVar.f8924a);
                jSONObject.put("mac", aVar.f8927d);
                jSONArray2.put(jSONObject);
            }
            this.f8905b.put(JThirdPlatFormInterface.KEY_DATA, jSONArray2);
        } catch (JSONException e2) {
            cn.jiguang.ai.a.d("JArp", "packageJson exception: " + e2.getMessage());
        }
    }

    @Override // cn.jiguang.l.a
    public String a(Context context) {
        this.f8904a = context;
        return "JArp";
    }

    @Override // cn.jiguang.l.a
    public void a(String str, JSONObject jSONObject) {
        if (cn.jiguang.h.a.a().a(1600)) {
            this.f8907e = true;
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            boolean z = !optJSONObject.optBoolean("disable");
            cn.jiguang.l.b.a(this.f8904a, "JArp", z);
            if (z) {
                long optLong = optJSONObject.optLong("frequency", 0L) * 1000;
                if (optLong == 0) {
                    cn.jiguang.l.b.b(this.f8904a, true);
                } else {
                    cn.jiguang.l.b.b(this.f8904a, false);
                    cn.jiguang.l.b.b(this.f8904a, "JArp", optLong);
                }
            }
        }
    }

    @Override // cn.jiguang.l.a
    public boolean a(Context context, String str) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0102, code lost:
    
        if (android.text.TextUtils.equals(r6, "0.0.0.0") != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012d, code lost:
    
        if (android.text.TextUtils.equals(r9, "0.0.0.0") != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x016f, code lost:
    
        if (android.text.TextUtils.equals(r14, "0.0.0.0") != false) goto L76;
     */
    @Override // cn.jiguang.l.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.i.b.b(android.content.Context, java.lang.String):void");
    }

    @Override // cn.jiguang.l.a
    public boolean b() {
        return cn.jiguang.l.b.i(this.f8904a, "JArp");
    }

    @Override // cn.jiguang.l.a
    public boolean c(Context context, String str) {
        if (!cn.jiguang.h.a.a().a(1600)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.f8906d)) {
            this.f8906d = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("JArp");
        sb.append(this.f8906d);
        return currentTimeMillis - cn.jiguang.l.b.g(context, sb.toString()) > cn.jiguang.l.b.h(context, "JArp");
    }

    @Override // cn.jiguang.l.a
    public void d(Context context, String str) {
        if (cn.jiguang.h.a.a().a(1600)) {
            JSONObject jSONObject = this.f8905b;
            if (jSONObject == null) {
                cn.jiguang.ai.a.a("JArp", "there are no data to report");
                return;
            }
            d.a(context, jSONObject, "mac_list");
            d.a(context, this.f8905b, new a(this.f8906d, context, "JArp", str));
            this.f8905b = null;
        }
    }
}
