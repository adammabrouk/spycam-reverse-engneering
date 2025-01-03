package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;

/* loaded from: classes.dex */
public class SchedulerReceiver extends BroadcastReceiver {
    public static final String DELAY_NOTIFY = "delay_notify";
    public static final String TAG = "SchedulerReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Logger.dd(TAG, "onReceive action=" + intent.getAction());
            if (DELAY_NOTIFY.equals(intent.getAction())) {
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, DELAY_NOTIFY, null);
            }
        } catch (Throwable th) {
            Logger.w(TAG, "onReceive e:" + th);
        }
    }
}
