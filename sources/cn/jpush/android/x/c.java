package cn.jpush.android.x;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f9959a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f9960b = 30;

    /* renamed from: c, reason: collision with root package name */
    public int f9961c = 1;

    /* renamed from: d, reason: collision with root package name */
    public int f9962d = 5;

    public c(String str) {
        a(str);
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f9959a = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE, -1);
            int optInt = jSONObject.optInt("timeInterval", 30);
            this.f9960b = optInt;
            this.f9960b = optInt >= 0 ? optInt : 30;
            int optInt2 = jSONObject.optInt("limitCount", 1);
            this.f9961c = optInt2;
            this.f9961c = optInt2 >= 0 ? optInt2 : 1;
            String optString = jSONObject.optString("extra", "");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt3 = new JSONObject(optString).optInt("reqInterval", 5);
            this.f9962d = optInt3;
            this.f9962d = optInt3 >= 0 ? optInt3 : 5;
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        return "response: code:" + this.f9959a + ",timeInterval:" + this.f9960b + ",limitCount:" + this.f9961c + ",reqTimeInterval:" + this.f9962d;
    }
}
