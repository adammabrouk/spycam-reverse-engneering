package cn.jpush.android.bd;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f9506a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f9507b;

    /* renamed from: c, reason: collision with root package name */
    public JSONArray f9508c;

    public d(int i2, long j, long j2, ByteBuffer byteBuffer) {
        super(i2, j, j2, byteBuffer);
        this.f9506a = -1;
        parseBody();
    }

    public d(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public JSONObject a() {
        return this.f9507b;
    }

    public JSONArray b() {
        return this.f9508c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            if (this.body == null) {
                Logger.ww("GeoPullResponse", "geo pull response empty");
                return;
            }
            short s = this.body.getShort();
            this.f9506a = s;
            if (s != 0) {
                Logger.ww("GeoPullResponse", "geo pull response error code :" + this.f9506a);
                return;
            }
            byte[] bArr = new byte[this.body.getShort()];
            this.body.get(bArr);
            String str = new String(bArr, "UTF-8");
            Logger.d("GeoPullResponse", "receive content：" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f9508c = jSONObject.getJSONArray("geofence");
            jSONObject.remove("geofence");
            this.f9507b = jSONObject;
        } catch (Throwable unused) {
            Logger.ww("GeoPullResponse", "parse geo pull response failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoPullResponse] - limit:" + this.f9507b + " - geoArray:" + this.f9508c + " - " + super.toString();
    }
}
