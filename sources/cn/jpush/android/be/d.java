package cn.jpush.android.be;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;

/* loaded from: classes.dex */
public class d {
    public static void a(Context context) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "clear_local_notify", new Bundle());
    }

    public static void a(Context context, long j) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("local_notify_ID", Long.valueOf(j));
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "rm_local_notify", bundle);
    }

    public static void a(Context context, JPushLocalNotification jPushLocalNotification) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("local_notify", jPushLocalNotification);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "add_local_notify", bundle);
    }
}
