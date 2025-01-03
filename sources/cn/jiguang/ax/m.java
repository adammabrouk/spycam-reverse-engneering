package cn.jiguang.ax;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.shix.shixipc.system.ContentCommon;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public String f8453a;

    /* renamed from: b, reason: collision with root package name */
    public int f8454b;

    /* renamed from: c, reason: collision with root package name */
    public g f8455c;

    /* renamed from: d, reason: collision with root package name */
    public long f8456d;

    /* renamed from: e, reason: collision with root package name */
    public long f8457e;

    /* renamed from: f, reason: collision with root package name */
    public long f8458f;

    /* renamed from: g, reason: collision with root package name */
    public int f8459g;

    /* renamed from: h, reason: collision with root package name */
    public double f8460h;

    /* renamed from: i, reason: collision with root package name */
    public double f8461i;
    public long j;
    public int k;

    public static m a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m mVar = new m();
                mVar.f8453a = jSONObject.optString("appkey");
                mVar.f8454b = jSONObject.getInt(ContentCommon.TYPE);
                mVar.f8455c = g.a(jSONObject.getString("addr"));
                mVar.f8457e = jSONObject.getLong("rtime");
                mVar.f8458f = jSONObject.getLong("interval");
                mVar.f8459g = jSONObject.getInt("net");
                mVar.k = jSONObject.getInt(JThirdPlatFormInterface.KEY_CODE);
                mVar.f8456d = jSONObject.optLong("uid");
                mVar.f8460h = jSONObject.optDouble("lat");
                mVar.f8461i = jSONObject.optDouble("lng");
                mVar.j = jSONObject.optLong("ltime");
                return mVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static LinkedList<m> a(String str) {
        LinkedList<m> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    linkedList.add(a(jSONArray.getJSONObject(i2)));
                }
            } catch (JSONException unused) {
            }
        }
        return linkedList;
    }

    public static boolean a(double d2, double d3) {
        return d2 > -90.0d && d2 < 90.0d && d3 > -180.0d && d3 < 180.0d;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f8453a)) {
                jSONObject.put("appkey", this.f8453a);
            }
            jSONObject.put(ContentCommon.TYPE, this.f8454b);
            jSONObject.put("addr", this.f8455c.toString());
            jSONObject.put("rtime", this.f8457e);
            jSONObject.put("interval", this.f8458f);
            jSONObject.put("net", this.f8459g);
            jSONObject.put(JThirdPlatFormInterface.KEY_CODE, this.k);
            if (this.f8456d != 0) {
                jSONObject.put("uid", this.f8456d);
            }
            if (a(this.f8460h, this.f8461i)) {
                jSONObject.put("lat", this.f8460h);
                jSONObject.put("lng", this.f8461i);
                jSONObject.put("ltime", this.j);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
