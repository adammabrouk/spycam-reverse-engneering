package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JNotifyActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MultiActionsNotificationBuilder extends DefaultPushNotificationBuilder {
    public static final String INTENT_NOTIFICATION_CLICK_ACTION_PROXY = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY";
    public static final String NOTI_ACT_EXTRA_STR = "notification_action_extra_string";
    public static final String NOTI_ACT_RES_ID = "notification_action_res_id";
    public static final String NOTI_ACT_TEXT = "notification_action_text";
    public static final String TAG = "MultiActionsNotificationBuilder";
    public JSONArray actionJSONArray = new JSONArray();
    public Context mContext;

    public MultiActionsNotificationBuilder(Context context) {
        this.mContext = context;
    }

    public static PushNotificationBuilder parseFromPreference(Context context, String str) {
        MultiActionsNotificationBuilder multiActionsNotificationBuilder = new MultiActionsNotificationBuilder(context);
        try {
            multiActionsNotificationBuilder.actionJSONArray = new JSONArray(str);
        } catch (JSONException e2) {
            Logger.ww(TAG, "Parse builder from preference failed!" + e2);
        }
        return multiActionsNotificationBuilder;
    }

    public void addJPushAction(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NOTI_ACT_RES_ID, i2);
            jSONObject.put(NOTI_ACT_TEXT, str);
            jSONObject.put(NOTI_ACT_EXTRA_STR, str2);
            this.actionJSONArray.put(jSONObject);
            Logger.i(TAG, this.actionJSONArray.toString());
        } catch (JSONException e2) {
            Logger.ww(TAG, "Construct action failed!" + e2);
        }
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    @TargetApi(11)
    public Notification getNotification(Notification.Builder builder) {
        if (Build.VERSION.SDK_INT < 16) {
            Logger.i(TAG, "Device with SDK_VERSION < 16, show original notification style.");
            return builder.getNotification();
        }
        for (int i2 = 0; i2 < this.actionJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = this.actionJSONArray.getJSONObject(i2);
                Intent intent = new Intent("cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY");
                intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA, jSONObject.getString(NOTI_ACT_EXTRA_STR));
                intent.setClass(this.mContext, JNotifyActivity.class);
                intent.setFlags(8388608);
                intent.putExtra("isNotification", true);
                PendingIntent activity = PendingIntent.getActivity(this.mContext, i2, intent, 201326592);
                Logger.i(TAG, "Add notification action: res - " + jSONObject.getInt(NOTI_ACT_RES_ID) + ", string - " + jSONObject.getString(NOTI_ACT_TEXT) + ", extra - " + jSONObject.getString(NOTI_ACT_EXTRA_STR));
                builder.addAction(jSONObject.getInt(NOTI_ACT_RES_ID), jSONObject.getString(NOTI_ACT_TEXT), activity).setAutoCancel(true);
            } catch (JSONException e2) {
                Logger.ww(TAG, "Parse Action from preference preference failed!" + e2);
            }
        }
        return builder.build();
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return this.actionJSONArray.toString();
    }
}
