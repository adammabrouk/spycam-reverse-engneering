package cn.jpush.android.y;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f9964a;

    /* renamed from: b, reason: collision with root package name */
    public long f9965b;

    /* renamed from: c, reason: collision with root package name */
    public int f9966c;

    /* renamed from: d, reason: collision with root package name */
    public long f9967d;

    /* renamed from: e, reason: collision with root package name */
    public String f9968e;

    public a(int i2, long j, long j2, ByteBuffer byteBuffer) {
        super(i2, j, j2, byteBuffer);
        this.f9964a = 0;
        this.f9965b = 300000L;
        this.f9966c = 5;
        this.f9967d = 5L;
        parseBody();
    }

    public a(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f9964a;
    }

    public long b() {
        return this.f9965b;
    }

    public int c() {
        return this.f9966c;
    }

    public String d() {
        return this.f9968e;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            if (this.body != null) {
                byte[] bArr = new byte[this.body.getShort()];
                this.body.get(bArr);
                String str = new String(bArr, "UTF-8");
                if (!TextUtils.isEmpty(str)) {
                    this.f9968e = str;
                    JSONObject jSONObject = new JSONObject(str);
                    this.f9964a = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE, 0);
                    this.f9965b = jSONObject.optLong("timeInterval", 300000L);
                    this.f9966c = jSONObject.optInt("limitCount", 5);
                    if (!TextUtils.isEmpty(jSONObject.optString("extra"))) {
                        this.f9967d = new JSONObject(r1).optInt("reqInterval", 5);
                    }
                }
                Logger.d("MessagePush", "[parseBody]: code=" + this.f9964a + ", reqTimeInterval=" + this.f9965b + ", reqLimitCount=" + this.f9966c + ", reqNavTimeInterval=" + this.f9967d);
            }
        } catch (Throwable unused) {
            Logger.ww("MessagePush", "parse in app pull response failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[InAppPullResponse] - code:" + this.f9964a + ", reqTimeInterval:" + this.f9965b + ", reqLimitCount:" + this.f9966c + ", reqNavTimeInterval:" + this.f9967d + " - " + super.toString();
    }
}
