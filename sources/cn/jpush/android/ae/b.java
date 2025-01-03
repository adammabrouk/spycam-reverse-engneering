package cn.jpush.android.ae;

import android.content.Context;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends cn.jpush.android.ad.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f9094a;

    @Override // cn.jpush.android.ad.a
    public void a(Context context, String str) {
        super.a(context, str);
    }

    @Override // cn.jpush.android.ad.a
    public String b(Context context) {
        this.f9094a = context;
        return "JUnionAdLoad";
    }

    @Override // cn.jpush.android.ad.a
    public void b(Context context, String str) {
        if (!super.d(context, str)) {
            cn.jpush.android.r.b.b("JUnionAdLoad", "not report enable");
            return;
        }
        try {
            JSONArray a2 = c.a(context);
            if (a2 != null && a2.length() != 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JThirdPlatFormInterface.KEY_DATA, a2);
                jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, String.valueOf(UUID.randomUUID()).toLowerCase());
                JSONObject jSONObject2 = new JSONObject();
                cn.jpush.android.s.b b2 = cn.jpush.android.n.b.a().b();
                cn.jpush.android.s.a c2 = cn.jpush.android.n.b.a().c();
                jSONObject2.put("brand", b2.d());
                jSONObject2.put("sdk_ver", c2.e());
                jSONObject.put("extra", jSONObject2);
                cn.jpush.android.r.b.b("JUnionAdLoad", "AD load statistic report data: " + jSONObject.toString());
                cn.jpush.android.l.a.a(context, jSONObject, "ad_load");
                cn.jpush.android.l.a.a(context, jSONObject);
                cn.jpush.android.z.a.a().a(context, jSONObject);
                c.b(context);
                super.b(context, str);
                return;
            }
            cn.jpush.android.r.b.b("JUnionAdLoad", "no load ad statistic data to report");
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdLoad", "ad load collect data report failed, " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.ad.a
    public boolean c(Context context, String str) {
        return true;
    }

    @Override // cn.jpush.android.ad.a
    public boolean d(Context context, String str) {
        return super.d(context, str);
    }
}
