package c.c.b.l;

import android.text.TextUtils;
import android.util.Log;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: d, reason: collision with root package name */
    public static final long f5908d = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a, reason: collision with root package name */
    public final String f5909a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5910b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5911c;

    public b0(String str, String str2, long j) {
        this.f5909a = str;
        this.f5910b = str2;
        this.f5911c = j;
    }

    public static String a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_TOKEN, str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    public static b0 b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new b0(str, null, 0L);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new b0(jSONObject.getString(JThirdPlatFormInterface.KEY_TOKEN), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to parse token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    public final boolean a(String str) {
        return System.currentTimeMillis() > this.f5911c + f5908d || !str.equals(this.f5910b);
    }
}
