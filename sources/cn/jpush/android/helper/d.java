package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.bm.g;
import cn.jpush.android.local.JPushConstants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue<Long> f9749a = new ConcurrentLinkedQueue<>();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f9750c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static d f9751d;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<Long, a> f9752b = new ConcurrentHashMap<>();

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f9753a;

        /* renamed from: b, reason: collision with root package name */
        public String f9754b;

        public a(int i2, String str) {
            this.f9753a = i2;
            this.f9754b = str;
        }

        public String toString() {
            return "MobileBean{sequence=" + this.f9753a + ", mobileNumber='" + this.f9754b + "'}";
        }
    }

    public static int a(long j) {
        if (f9749a.size() >= 3) {
            long longValue = j - f9749a.element().longValue();
            if (longValue < 0) {
                f9749a.clear();
                return 2;
            }
            if (longValue <= 10000) {
                return 1;
            }
            while (f9749a.size() >= 3) {
                f9749a.poll();
            }
        }
        f9749a.offer(Long.valueOf(j));
        return 0;
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f9751d == null) {
                synchronized (f9750c) {
                    if (f9751d == null) {
                        f9751d = new d();
                    }
                }
            }
            dVar = f9751d;
        }
        return dVar;
    }

    public JPushMessage a(Context context, Intent intent) {
        JPushMessage jPushMessage;
        Object th;
        int intExtra;
        int intExtra2;
        String stringExtra;
        if (intent == null) {
            return null;
        }
        try {
            intExtra = intent.getIntExtra(InAppSlotParams.SLOT_KEY.SEQ, -1);
            intExtra2 = intent.getIntExtra(JThirdPlatFormInterface.KEY_CODE, -1);
            stringExtra = intent.getStringExtra("mobile");
            jPushMessage = new JPushMessage();
        } catch (Throwable th2) {
            jPushMessage = null;
            th = th2;
        }
        try {
            jPushMessage.setSequence(intExtra);
            jPushMessage.setErrorCode(intExtra2);
            jPushMessage.setMobileNumber(stringExtra);
        } catch (Throwable th3) {
            th = th3;
            Logger.w("MobileNumberHelper", "parese mobile number response to JPushMessage failed, error:" + th);
            return jPushMessage;
        }
        return jPushMessage;
    }

    public void a(Context context, int i2, int i3, String str) {
        try {
            Logger.d("MobileNumberHelper", "Action - onResult,sequence:" + i2 + ",code:" + i3 + ",mobileNumber:" + str);
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            Intent intent = new Intent();
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.d("MobileNumberHelper", "not found messageReceiver");
            } else {
                intent = new Intent(context, Class.forName(messageReceiverClass));
                intent.setAction("mobile_result");
                intent.putExtra(InAppSlotParams.SLOT_KEY.SEQ, i2);
                intent.putExtra(JThirdPlatFormInterface.KEY_CODE, i3);
                intent.putExtra("mobile", str);
            }
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Logger.ww("MobileNumberHelper", "onResult error:" + th);
        }
    }

    public void a(Context context, int i2, String str) {
        Logger.dd("MobileNumberHelper", "action - setMobileNubmer, sequence:" + i2 + ",mobileNumber:" + str);
        Bundle bundle = new Bundle();
        bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i2);
        bundle.putString("mobile", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "set_mobile", bundle);
    }

    public void a(Context context, long j, int i2) {
        if (this.f9752b.size() != 0) {
            a remove = this.f9752b.remove(Long.valueOf(j));
            Logger.d("MobileNumberHelper", "mobileBean:" + remove);
            if (remove == null) {
                Logger.d("MobileNumberHelper", "#unexcepted, do not find mobile number request cache");
                return;
            }
            if (i2 == 0) {
                cn.jpush.android.cache.a.a(context, remove.f9754b);
            } else if (i2 == 11) {
                i2 = JPushInterface.ErrorCode.ERROR_CODE_INTERNEL_SERVER_ERROR;
            } else if (i2 == 10) {
                i2 = JPushInterface.ErrorCode.ERROR_CODE_INVALID_MOBILENUMBER;
            }
            a(context, remove.f9753a, i2, remove.f9754b);
        }
    }

    public void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.ww("MobileNumberHelper", "[setMobileNum] bundle is bull");
            return;
        }
        int i2 = bundle.getInt(InAppSlotParams.SLOT_KEY.SEQ, 0);
        String string = bundle.getString("mobile");
        String f2 = cn.jpush.android.cache.a.f(context);
        Logger.dd("MobileNumberHelper", "action:setMobileNum sequence:" + i2 + ",mobileNumber:" + string + ",lastMobileNumber:" + f2);
        if (f2 != null && TextUtils.equals(string, f2)) {
            Logger.dd("MobileNumberHelper", "already set this mobile number");
            a(context, i2, JPushInterface.ErrorCode.SUCCESS, string);
            return;
        }
        if (cn.jpush.android.cache.a.b(context) == 1) {
            a(context, i2, JPushInterface.ErrorCode.PUSH_STOPED, string);
            return;
        }
        if (f2 != null) {
            cn.jpush.android.cache.a.a(context, (String) null);
        }
        int a2 = a(System.currentTimeMillis());
        if (a2 != 0) {
            Logger.w("MobileNumberHelper", a2 == 1 ? "set mobile number too soon,over 3 times in 10s" : "set mobile number failed,time shaft error，please try again");
            a(context, i2, a2 == 1 ? JPushInterface.ErrorCode.INVOKE_TOO_SOON : JPushInterface.ErrorCode.INCORRECT_TIME, string);
            return;
        }
        int c2 = g.c(string);
        if (c2 == 0) {
            byte[] a3 = cn.jpush.android.bi.b.a(string);
            long a4 = f.a();
            this.f9752b.put(Long.valueOf(a4), new a(i2, string));
            JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 26, 1, a4, 0L, a3);
            return;
        }
        Logger.dd("MobileNumberHelper", "Invalid mobile number: " + string + ", will not set mobile number this time.");
        a(context, i2, c2, string);
    }
}
