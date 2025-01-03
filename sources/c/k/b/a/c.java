package c.k.b.a;

import cn.jpush.android.api.JThirdPlatFormInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: h, reason: collision with root package name */
    public int f6767h;

    /* renamed from: i, reason: collision with root package name */
    public long f6768i = -1;
    public long j = -1;

    public static c c() {
        return new c();
    }

    @Override // c.k.b.a.d
    public JSONObject a() {
        try {
            JSONObject a2 = super.a();
            if (a2 == null) {
                return null;
            }
            a2.put(JThirdPlatFormInterface.KEY_CODE, this.f6767h);
            a2.put("perfCounts", this.f6768i);
            a2.put("perfLatencies", this.j);
            return a2;
        } catch (JSONException e2) {
            c.k.a.a.a.c.a(e2);
            return null;
        }
    }

    @Override // c.k.b.a.d
    public String b() {
        return super.b();
    }
}
