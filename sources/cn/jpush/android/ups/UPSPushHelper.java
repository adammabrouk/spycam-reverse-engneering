package cn.jpush.android.ups;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class UPSPushHelper {
    public static final String ACTION_UPS = ".ups.receiver";
    public static final String KEY_ACTION = "ups.action";
    public static final String KEY_CODE = "ups.code";
    public static final String KEY_RID = "ups.rid";
    public static final String KEY_TOKEN = "ups.token";
    public static final String TAG = "UPSPushHelper";
    public static Map<Long, Object> cacheMap = new ConcurrentHashMap();
    public static AtomicInteger rid = new AtomicInteger(0);
    public static a upsReceiver;

    public static class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TokenResult tokenResult;
            try {
                if (intent.getAction().equals(context.getPackageName() + UPSPushHelper.ACTION_UPS)) {
                    int intExtra = intent.getIntExtra(UPSPushHelper.KEY_RID, 0);
                    int intExtra2 = intent.getIntExtra(UPSPushHelper.KEY_CODE, -1);
                    String stringExtra = intent.getStringExtra(UPSPushHelper.KEY_TOKEN);
                    String stringExtra2 = intent.getStringExtra(UPSPushHelper.KEY_ACTION);
                    Logger.dd(UPSPushHelper.TAG, "intenalAction:" + stringExtra2 + ",rid:" + intExtra + ",code:" + intExtra2 + ",token:" + stringExtra);
                    if (intExtra > 0) {
                        ICallbackResult removeMapping = UPSPushHelper.removeMapping(intExtra);
                        if (removeMapping != null) {
                            removeMapping.onResult(new TokenResult(stringExtra, intExtra2, stringExtra2));
                            return;
                        }
                        return;
                    }
                    if (TextUtils.isEmpty(stringExtra2)) {
                        return;
                    }
                    if (stringExtra2.equals("ups.register") || stringExtra2.equals("ups.unregister")) {
                        Iterator it = UPSPushHelper.cacheMap.values().iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            ICallbackResult objectToCallBack = UPSPushHelper.objectToCallBack(next);
                            if (objectToCallBack != null) {
                                if ((next instanceof UPSRegisterCallBack) && stringExtra2.equals("ups.register")) {
                                    it.remove();
                                    tokenResult = new TokenResult(stringExtra, intExtra2, stringExtra2);
                                } else if ((next instanceof UPSUnRegisterCallBack) && stringExtra2.equals("ups.unregister")) {
                                    it.remove();
                                    tokenResult = new TokenResult(stringExtra, intExtra2, stringExtra2);
                                }
                                objectToCallBack.onResult(tokenResult);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void callResult(Context context, String str, Bundle bundle, ICallbackResult iCallbackResult) {
        int nextRid = getNextRid();
        createMapping(context, nextRid, iCallbackResult);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(KEY_RID, nextRid);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, str, bundle);
    }

    public static void createMapping(Context context, long j, ICallbackResult iCallbackResult) {
        init(context);
        if (iCallbackResult == null) {
            Logger.e(TAG, "requestParams is null");
            return;
        }
        if (cacheMap.containsKey(Long.valueOf(j))) {
            Logger.v(TAG, "rid " + j + " has exist.");
            return;
        }
        if (!(iCallbackResult instanceof Activity)) {
            cacheMap.put(Long.valueOf(j), iCallbackResult);
        } else {
            cacheMap.put(Long.valueOf(j), new WeakReference(iCallbackResult));
        }
    }

    public static int getNextRid() {
        int incrementAndGet = rid.incrementAndGet();
        if (incrementAndGet == Integer.MAX_VALUE) {
            rid.set(0);
        }
        return incrementAndGet;
    }

    public static String getReceiverPermission(Context context) {
        return context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX;
    }

    public static void init(Context context) {
        if (upsReceiver == null) {
            upsReceiver = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(context.getPackageName() + ACTION_UPS);
            context.getApplicationContext().registerReceiver(upsReceiver, intentFilter, getReceiverPermission(context), null);
        }
    }

    public static ICallbackResult objectToCallBack(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof WeakReference) {
            return (ICallbackResult) ((WeakReference) obj).get();
        }
        if (obj instanceof ICallbackResult) {
            return (ICallbackResult) obj;
        }
        return null;
    }

    public static ICallbackResult removeMapping(long j) {
        return objectToCallBack(cacheMap.remove(Long.valueOf(j)));
    }

    public static void upsCallBack(Context context, int i2, String str, int i3, String str2) {
        try {
            Intent intent = new Intent();
            intent.setAction(context.getPackageName() + ACTION_UPS);
            intent.setPackage(context.getPackageName());
            intent.putExtra(KEY_RID, i2);
            intent.putExtra(KEY_CODE, i3);
            intent.putExtra(KEY_TOKEN, str2);
            intent.putExtra(KEY_ACTION, str);
            context.sendBroadcast(intent, getReceiverPermission(context));
        } catch (Throwable th) {
            Logger.ee(TAG, "[upsCallBack] failed:" + th.getMessage());
        }
    }
}
