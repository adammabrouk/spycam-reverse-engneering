package cn.jpush.android.d;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements Serializable {
    public static final long serialVersionUID = -942487107643335186L;

    /* renamed from: a, reason: collision with root package name */
    public String f9694a;

    /* renamed from: b, reason: collision with root package name */
    public String f9695b;

    public a() {
    }

    public a(d dVar) {
        this.f9694a = dVar.f9700d;
        this.f9695b = dVar.f9704h;
    }

    public a(String str, String str2) {
        this.f9694a = str;
        this.f9695b = str2;
    }

    public static a a(JSONObject jSONObject) {
        return new a(jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID), jSONObject.optString("override_msg_id"));
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, this.f9694a);
            jSONObject.put("override_msg_id", this.f9695b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (TextUtils.isEmpty(this.f9694a) || TextUtils.isEmpty(aVar.f9694a) || !TextUtils.equals(this.f9694a, aVar.f9694a)) {
            return false;
        }
        if (TextUtils.isEmpty(this.f9695b) && TextUtils.isEmpty(aVar.f9695b)) {
            return true;
        }
        return (TextUtils.isEmpty(this.f9695b) || TextUtils.isEmpty(aVar.f9695b) || !TextUtils.equals(this.f9695b, aVar.f9695b)) ? false : true;
    }

    public String toString() {
        return "msg_id = " + this.f9694a + ",  override_msg_id = " + this.f9695b;
    }
}
