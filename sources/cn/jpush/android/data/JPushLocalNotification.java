package cn.jpush.android.data;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.Logger;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JPushLocalNotification implements Serializable {
    public static final long serialVersionUID = 1472982106750878137L;

    /* renamed from: f, reason: collision with root package name */
    public String f9711f;

    /* renamed from: g, reason: collision with root package name */
    public String f9712g;

    /* renamed from: h, reason: collision with root package name */
    public String f9713h;

    /* renamed from: i, reason: collision with root package name */
    public long f9714i;

    /* renamed from: a, reason: collision with root package name */
    public int f9706a = 1;

    /* renamed from: b, reason: collision with root package name */
    public String f9707b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f9708c = "00";

    /* renamed from: d, reason: collision with root package name */
    public String f9709d = "00";

    /* renamed from: e, reason: collision with root package name */
    public long f9710e = 0;
    public long j = 1;
    public int k = 1;
    public String l = "";
    public String m = "";

    private void a(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && JPushLocalNotification.class == obj.getClass() && this.j == ((JPushLocalNotification) obj).j;
    }

    public long getBroadcastTime() {
        return this.f9710e;
    }

    public long getBuilderId() {
        return this.f9714i;
    }

    public String getContent() {
        return this.f9711f;
    }

    public String getExtras() {
        return this.f9713h;
    }

    public long getNotificationId() {
        return this.j;
    }

    public String getTitle() {
        return this.f9712g;
    }

    public int hashCode() {
        long j = this.j;
        return (int) (j ^ (j >>> 32));
    }

    public void setBroadcastTime(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < 0 || i3 < 1 || i3 > 12 || i4 < 1 || i4 > 31 || i5 < 0 || i5 > 23 || i6 < 0 || i6 > 59 || i7 < 0 || i7 > 59) {
            Logger.ee("JPushLocalNotification", "Set time fail! Please check your args!");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i2, i3 - 1, i4, i5, i6, i7);
        Date time = calendar.getTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (time.getTime() < currentTimeMillis) {
            this.f9710e = currentTimeMillis;
        } else {
            this.f9710e = time.getTime();
        }
    }

    public void setBroadcastTime(long j) {
        this.f9710e = j;
    }

    public void setBroadcastTime(Date date) {
        this.f9710e = date.getTime();
    }

    public void setBuilderId(long j) {
        this.f9714i = j;
    }

    public void setContent(String str) {
        this.f9711f = str;
    }

    public void setExtras(String str) {
        this.f9713h = str;
    }

    public void setNotificationId(long j) {
        this.j = (int) j;
    }

    public void setTitle(String str) {
        this.f9712g = str;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.f9713h)) {
                jSONObject2.put("n_extras", new JSONObject(this.f9713h));
            }
            a("n_content", this.f9711f, jSONObject2);
            a("n_title", this.f9712g, jSONObject2);
            a("n_content", this.f9711f, jSONObject2);
            jSONObject2.put("ad_t", 0);
            jSONObject.put("m_content", jSONObject2);
            a(JThirdPlatFormInterface.KEY_MSG_ID, "" + this.j, jSONObject);
            a("content_type", this.m, jSONObject);
            a("override_msg_id", this.l, jSONObject);
            jSONObject.put("n_only", this.k);
            jSONObject.put("n_builder_id", this.f9714i);
            jSONObject.put("show_type", 3);
            jSONObject.put("notificaion_type", 1);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
