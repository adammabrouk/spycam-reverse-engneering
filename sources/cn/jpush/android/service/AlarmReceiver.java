package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jiguang.ao.f;
import cn.jiguang.ao.g;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.as.d;
import cn.jiguang.az.a;
import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    public static final String TAG = "AlarmReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d.c(TAG, "onReceive");
        if (f.a()) {
            d.d(TAG, "sdk is banned, not handle hb receiver task");
            return;
        }
        if (g.a()) {
            d.d(TAG, "sdk is limit, not handle hb receiver task");
            return;
        }
        if (Build.VERSION.SDK_INT >= 31 && context.getApplicationInfo().targetSdkVersion >= 31) {
            d.d(TAG, "sdk is android 12, return");
        } else if (!JConstants.isCallInit.get()) {
            d.d(TAG, "please call init");
        } else {
            a.b(context);
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 10, "a2", null, new Object[0]);
        }
    }
}
