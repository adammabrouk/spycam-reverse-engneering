package cn.jpush.android.at;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.ActionManager;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static e f9349a;

    /* renamed from: b, reason: collision with root package name */
    public int f9350b = 1;

    /* renamed from: c, reason: collision with root package name */
    public long f9351c = 30000;

    /* renamed from: d, reason: collision with root package name */
    public int f9352d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f9353e = 0;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<Long, Integer> f9354f = new ConcurrentHashMap<>();

    public static e a() {
        if (f9349a == null) {
            synchronized (e.class) {
                if (f9349a == null) {
                    f9349a = new e();
                }
            }
        }
        return f9349a;
    }

    private String a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("user_type", cn.jpush.android.af.e.a(context) ? 1 : 0);
            jSONObject.put(ActionManager.SDK_TYPE, 1);
            jSONObject.put("render_type", 0);
            jSONObject.put("content", "");
            return jSONObject.toString();
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppPullTaskHelper", "package sdk render ad header failed, e: " + th.getMessage());
            return "";
        }
    }

    private void a(Context context, int i2, int i3) {
        if (context == null) {
            try {
                context = JPushConstants.mApplicationContext;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppPullTaskHelper", "send pull result to user by broadcast, code: " + i3 + ", error: " + th.getMessage());
                return;
            }
        }
        if (context != null) {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            Intent intent = new Intent();
            if (TextUtils.isEmpty(messageReceiverClass)) {
                cn.jpush.android.r.b.b("InAppPullTaskHelper", "not found messageReceiver");
            } else {
                intent = new Intent(context, Class.forName(messageReceiverClass));
                intent.setAction("in_app_pull_result");
                intent.putExtra(InAppSlotParams.SLOT_KEY.SEQ, i2);
                intent.putExtra(JThirdPlatFormInterface.KEY_CODE, i3);
            }
            context.sendBroadcast(intent);
        }
    }

    private void a(Context context, long j, int i2) {
        if (this.f9354f.size() > 0) {
            Integer remove = this.f9354f.remove(Long.valueOf(j));
            cn.jpush.android.r.b.b("InAppPullTaskHelper", "sequence:" + remove + ", code: " + i2);
            if (remove == null) {
                cn.jpush.android.r.b.b("InAppPullTaskHelper", "#unexcepted, do not find in app request cache");
                return;
            }
            if (i2 != 0) {
                switch (i2) {
                    case 8001:
                        i2 = 6029;
                        break;
                    case 8002:
                        i2 = 6030;
                        break;
                    case 8003:
                        i2 = 6032;
                        break;
                    case 8004:
                        i2 = 6033;
                        break;
                    case 8005:
                        i2 = 6034;
                        break;
                }
            } else {
                i2 = 6028;
            }
            a(context, remove.intValue(), i2);
        }
    }

    public JPushMessage a(Context context, Intent intent) {
        JPushMessage jPushMessage = new JPushMessage();
        if (intent != null) {
            try {
                cn.jpush.android.r.b.b("InAppPullTaskHelper", "[parseInAppResponse2JPushMessage] process: " + cn.jpush.android.bm.a.d(context));
                int intExtra = intent.getIntExtra(InAppSlotParams.SLOT_KEY.SEQ, -1);
                int intExtra2 = intent.getIntExtra(JThirdPlatFormInterface.KEY_CODE, -1);
                jPushMessage.setSequence(intExtra);
                jPushMessage.setErrorCode(intExtra2);
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppPullTaskHelper", "parese in app response to JPushMessage failed, error:" + th);
            }
        }
        return jPushMessage;
    }

    public void a(Context context, long j, int i2, int i3, long j2) {
        try {
            if (i2 != JPushInterface.ErrorCode.TIMEOUT) {
                this.f9350b = Math.max(i3, 0);
                this.f9351c = Math.max(j2, 0L) * 1000;
                cn.jpush.android.r.b.b("InAppPullTaskHelper", "[onPullInAppCallBack],reqId:" + j + ",code:" + i2 + ",reqLmtCount:" + this.f9350b + ", reqTimeInterval:" + this.f9351c);
            }
            a(context, j, i2);
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("InAppPullTaskHelper", "[onPullInAppCallBack] error:" + th);
        }
    }

    public synchronized void a(Context context, Bundle bundle) {
        int i2;
        try {
        } finally {
        }
        if (bundle == null) {
            cn.jpush.android.r.b.g("InAppPullTaskHelper", "[pullInAppMessage] bundle is bull");
            cn.jpush.android.ae.c.a(context, 12, 107, "");
            return;
        }
        int i3 = bundle.getInt(InAppSlotParams.SLOT_KEY.SEQ, 0);
        int i4 = bundle.getInt(ContentCommon.TYPE, 0);
        String string = bundle.getString("AdPositionKey", "");
        String str = LogUtils.PLACEHOLDER;
        if (JPushConstants.SDK_VERSION_CODE >= 420) {
            try {
                String string2 = bundle.getString("inapp_param", "");
                if (!TextUtils.isEmpty(string2)) {
                    JSONObject jSONObject = new JSONObject(string2);
                    int optInt = jSONObject.optInt(InAppSlotParams.SLOT_KEY.SEQ, 0);
                    String optString = jSONObject.optString(InAppSlotParams.SLOT_KEY.SLOT, "");
                    String optString2 = jSONObject.optString(InAppSlotParams.SLOT_KEY.EVENT, "");
                    if (!TextUtils.isEmpty(optString) && !string.equals(optString)) {
                        string = optString;
                    }
                    str = !TextUtils.isEmpty(optString2) ? optString2 : LogUtils.PLACEHOLDER;
                    if (optInt > 0) {
                        i3 = optInt;
                    }
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppPullTaskHelper", "parse adSlot data failed, " + th.getMessage());
            }
        }
        if (TextUtils.isEmpty(string)) {
            string = LogUtils.PLACEHOLDER;
        }
        String str2 = string;
        if (cn.jpush.android.cache.a.b(context) == 1) {
            a(context, i3, JPushInterface.ErrorCode.PUSH_STOPED);
            cn.jpush.android.ae.c.a(context, 12, 104, str2);
            return;
        }
        if (!cn.jpush.android.bm.a.a(context)) {
            a(context, i3, 6036);
            cn.jpush.android.ae.c.a(context, 12, 103, str2);
            return;
        }
        if (cn.jpush.android.ar.d.c(context)) {
            cn.jpush.android.r.b.b("InAppPullTaskHelper", "can not pull in-message in black page");
            a(context, i3, 6035);
            cn.jpush.android.ae.c.a(context, 12, 106, str2);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f9353e > this.f9351c) {
            this.f9352d = 0;
        }
        if (this.f9352d >= this.f9350b) {
            cn.jpush.android.r.b.f("InAppPullTaskHelper", "in app message request limit, limit code: " + this.f9350b + ", hasReqCount: " + this.f9352d + ", srvTimeInterval: " + this.f9351c + ", reqTimeInterval: " + (currentTimeMillis - this.f9353e));
            a(context, i3, 6031);
            cn.jpush.android.ae.c.a(context, 12, 102, str2);
            return;
        }
        long a2 = cn.jpush.android.helper.f.a();
        String e2 = c.a().e(context);
        String a3 = cn.jpush.android.ar.d.a();
        if (TextUtils.isEmpty(a3)) {
            a3 = LogUtils.PLACEHOLDER;
        }
        String str3 = str2 + "$$" + a3 + "$$" + str + "$$" + String.valueOf(UUID.randomUUID()).toLowerCase() + "$$3";
        String a4 = a(context);
        cn.jpush.android.r.b.b("InAppPullTaskHelper", "start request in-app message, reqCount: " + this.f9350b + ", reqTimeInterval: " + this.f9351c + ", hasReqCount: " + this.f9352d + ", cmd: 34, ver: 5, type: " + i4 + ", adPositionKey: " + str2 + ", devInfo: " + e2 + ", adInfo: " + str3 + ", extras: " + a4);
        this.f9354f.put(Long.valueOf(a2), Integer.valueOf(i3));
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 34, 5, a2, 20000L, cn.jpush.android.bi.b.a(i4, str3, e2, a4));
        if (currentTimeMillis - this.f9353e > this.f9351c) {
            i2 = 1;
        } else {
            i2 = this.f9352d + 1;
            this.f9352d = i2;
        }
        this.f9352d = i2;
        this.f9353e = currentTimeMillis;
        cn.jpush.android.ae.c.a(context, 12, 0, str2);
        cn.jpush.android.r.b.b("InAppPullTaskHelper", "after user request count: " + this.f9352d + ", userReqTime: " + this.f9353e);
    }

    public boolean a(long j) {
        return this.f9354f.containsKey(Long.valueOf(j));
    }
}
