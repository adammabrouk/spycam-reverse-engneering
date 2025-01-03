package cn.jpush.android.api;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppSlotParams {

    /* renamed from: a, reason: collision with root package name */
    public int f9174a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f9175b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f9176c = "";

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public InAppSlotParams f9177a = new InAppSlotParams();

        public InAppSlotParams build() {
            return this.f9177a;
        }

        public Builder setAdEvent(String str) {
            this.f9177a.f9176c = str;
            return this;
        }

        public Builder setAdSlot(String str) {
            this.f9177a.f9175b = str;
            return this;
        }

        public Builder setSequence(int i2) {
            this.f9177a.f9174a = i2;
            return this;
        }
    }

    public interface SLOT_KEY {
        public static final String EVENT = "event";
        public static final String SEQ = "sequence";
        public static final String SLOT = "slot";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static InAppSlotParams parseJSONString(String str) {
        InAppSlotParams inAppSlotParams = new InAppSlotParams();
        try {
            JSONObject jSONObject = new JSONObject(str);
            inAppSlotParams.f9174a = jSONObject.optInt(SLOT_KEY.SEQ, 0);
            inAppSlotParams.f9175b = jSONObject.optString(SLOT_KEY.SLOT, "");
            inAppSlotParams.f9176c = jSONObject.optString(SLOT_KEY.EVENT, "");
        } catch (Throwable unused) {
        }
        return inAppSlotParams;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SLOT_KEY.SEQ, this.f9174a);
            jSONObject.put(SLOT_KEY.SLOT, this.f9175b);
            jSONObject.put(SLOT_KEY.EVENT, this.f9176c);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "InAppSlotParams{sequence=" + this.f9174a + ", adSlot='" + this.f9175b + "', adEvent='" + this.f9176c + "'}";
    }
}
