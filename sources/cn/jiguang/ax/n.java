package cn.jiguang.ax;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.shix.shixipc.system.ContentCommon;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public int f8462a;

    /* renamed from: b, reason: collision with root package name */
    public String f8463b;

    /* renamed from: c, reason: collision with root package name */
    public String f8464c;

    /* renamed from: d, reason: collision with root package name */
    public long f8465d;

    /* renamed from: e, reason: collision with root package name */
    public String f8466e;

    /* renamed from: f, reason: collision with root package name */
    public double f8467f;

    /* renamed from: g, reason: collision with root package name */
    public double f8468g;

    /* renamed from: h, reason: collision with root package name */
    public long f8469h;

    /* renamed from: i, reason: collision with root package name */
    public int f8470i = 0;
    public int j = 0;

    public n(int i2, String str, String str2, long j, String str3, double d2, double d3, long j2) {
        this.f8462a = i2;
        this.f8463b = str;
        this.f8464c = str2;
        this.f8465d = j;
        this.f8466e = str3;
        this.f8467f = d2;
        this.f8468g = d3;
        this.f8469h = j2;
    }

    public static boolean a(double d2, double d3) {
        return d2 > -90.0d && d2 < 90.0d && d3 > -180.0d && d3 < 180.0d;
    }

    public JSONObject a(Set<String> set) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ContentCommon.TYPE, this.f8462a);
            jSONObject.put("appkey", this.f8463b);
            jSONObject.put("sdkver", this.f8464c);
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            if (this.f8465d != 0) {
                jSONObject.put("uid", this.f8465d);
            }
            if (this.f8466e != null) {
                jSONObject.put("opera", this.f8466e);
            }
            if (a(this.f8467f, this.f8468g)) {
                jSONObject.put("lat", this.f8467f);
                jSONObject.put("lng", this.f8468g);
                jSONObject.put("time", this.f8469h);
            }
            if (set != null && !set.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("fail_ips", jSONArray);
            }
            if (this.f8470i != 0) {
                jSONObject.put("ips_flag", this.f8470i);
            }
            if (this.j != 0) {
                jSONObject.put("report_flag", this.j);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
