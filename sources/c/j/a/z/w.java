package c.j.a.z;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MessageConvertUtil.java */
/* loaded from: classes.dex */
public final class w {
    public static c.j.a.t.b a(c.j.a.t.a aVar) {
        c.j.a.t.b bVar = new c.j.a.t.b();
        bVar.e(aVar.o());
        bVar.h(aVar.q());
        bVar.g(aVar.p());
        bVar.b(aVar.e());
        bVar.c(aVar.j());
        bVar.e(aVar.l());
        bVar.d(aVar.g());
        bVar.c(aVar.f());
        bVar.f(aVar.m());
        bVar.d(aVar.n());
        bVar.a(aVar.r());
        bVar.a(aVar.i());
        bVar.a(aVar.k());
        return bVar;
    }

    public static String b(c.j.a.t.a aVar) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aVar.o());
        jSONArray.put(aVar.q());
        jSONArray.put(aVar.p());
        jSONArray.put(aVar.e());
        jSONArray.put(aVar.j());
        jSONArray.put(aVar.l());
        jSONArray.put(aVar.g());
        jSONArray.put(aVar.f());
        jSONArray.put(aVar.m());
        jSONArray.put(aVar.n());
        jSONArray.put(aVar.r());
        if (aVar.k() != null) {
            jSONArray.put(new JSONObject(aVar.k()));
        } else {
            jSONArray.put("{}");
        }
        jSONArray.put(aVar.s());
        jSONArray.put(aVar.x());
        jSONArray.put(aVar.z());
        jSONArray.put(aVar.y());
        jSONArray.put(aVar.v());
        jSONArray.put(aVar.h());
        jSONArray.put(aVar.c());
        jSONArray.put(aVar.d());
        jSONArray.put(aVar.u());
        jSONArray.put(aVar.t());
        return jSONArray.toString();
    }

    public static c.j.a.t.a a(String str) {
        c.j.a.t.a aVar = new c.j.a.t.a();
        try {
        } catch (JSONException e2) {
            v.a("MessageConvertUtil", "notify msg pack to obj error", e2);
        }
        if (TextUtils.isEmpty(str)) {
            v.a("MessageConvertUtil", "notify msg pack to obj is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray(str);
        aVar.e(jSONArray.getInt(0));
        aVar.h(jSONArray.getString(1));
        aVar.g(jSONArray.getString(2));
        aVar.b(jSONArray.getString(3));
        aVar.c(jSONArray.getInt(4));
        aVar.e(jSONArray.getString(5));
        aVar.d(jSONArray.getString(6));
        aVar.c(jSONArray.getString(7));
        aVar.f(jSONArray.getString(8));
        aVar.d(jSONArray.getInt(9));
        aVar.a(jSONArray.getBoolean(10));
        if (jSONArray.length() > 11) {
            aVar.a(s.a(new JSONObject(jSONArray.getString(11))));
        }
        if (jSONArray.length() > 15) {
            aVar.f(jSONArray.getInt(12));
            aVar.i(jSONArray.getString(13));
            aVar.b(jSONArray.getBoolean(14));
            aVar.j(jSONArray.getString(15));
        }
        if (jSONArray.length() > 16) {
            aVar.i(jSONArray.getInt(16));
        }
        if (jSONArray.length() > 18) {
            aVar.b(jSONArray.getInt(17));
            aVar.a(jSONArray.getString(18));
        }
        if (jSONArray.length() > 19) {
            aVar.a(jSONArray.getInt(19));
        }
        if (jSONArray.length() > 20) {
            aVar.h(jSONArray.getInt(20));
        }
        if (jSONArray.length() > 21) {
            aVar.g(jSONArray.getInt(21));
        }
        return aVar;
    }
}
