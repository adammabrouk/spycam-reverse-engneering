package com.shix.shixipc;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import com.shix.shixipc.activity.CloudLogActivity;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.he.SpUtil;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PushMessageReceiver extends JPushMessageReceiver {
    public static final String TAG = "JPushMessageReceiver";

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        TagAliasOperatorHelper.getInstance().onAliasOperatorResult(context, jPushMessage);
        super.onAliasOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        TagAliasOperatorHelper.getInstance().onCheckTagOperatorResult(context, jPushMessage);
        super.onCheckTagOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onCommandResult(Context context, CmdMessage cmdMessage) {
        Log.e(TAG, "[onCommandResult] " + cmdMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onConnected(Context context, boolean z) {
        Log.e(TAG, "[onConnected] " + z);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMessage(Context context, CustomMessage customMessage) {
        Log.e(TAG, "[onMessage] " + customMessage);
        Intent intent = new Intent("com.jiguang.demo.message");
        intent.putExtra(JThirdPlatFormInterface.KEY_MSG, customMessage.message);
        context.sendBroadcast(intent);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        TagAliasOperatorHelper.getInstance().onMobileNumberOperatorResult(context, jPushMessage);
        super.onMobileNumberOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMultiActionClicked(Context context, Intent intent) {
        Log.e(TAG, "[onMultiActionClicked] 用户点击了通知栏按钮");
        String string = intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA);
        if (string == null) {
            Log.d(TAG, "ACTION_NOTIFICATION_CLICK_ACTION nActionExtra is null");
            return;
        }
        if (string.equals("my_extra1")) {
            Log.e(TAG, "[onMultiActionClicked] 用户点击通知栏按钮一");
            return;
        }
        if (string.equals("my_extra2")) {
            Log.e(TAG, "[onMultiActionClicked] 用户点击通知栏按钮二");
        } else if (string.equals("my_extra3")) {
            Log.e(TAG, "[onMultiActionClicked] 用户点击通知栏按钮三");
        } else {
            Log.e(TAG, "[onMultiActionClicked] 用户点击通知栏按钮未定义");
        }
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotificationSettingsCheck(Context context, boolean z, int i2) {
        super.onNotificationSettingsCheck(context, z, i2);
        Log.e(TAG, "[onNotificationSettingsCheck] isOn:" + z + ",source:" + i2);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        boolean z;
        Log.e(TAG, "[onNotifyMessageArrived] " + notificationMessage);
        try {
            String replace = new JSONObject(notificationMessage.notificationExtras).optString("dev_uid").replace("-", "");
            int i2 = 0;
            while (true) {
                if (i2 >= SystemValue.arrayList.size()) {
                    z = false;
                    break;
                } else {
                    if (replace.equalsIgnoreCase(SystemValue.arrayList.get(i2).getDev_Did())) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
            if (z) {
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(replace);
            JPushInterface.deleteTags(context, 0, hashSet);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageDismiss(Context context, NotificationMessage notificationMessage) {
        Log.e(TAG, "[onNotifyMessageDismiss] " + notificationMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        boolean z;
        String decodeString;
        Log.e(TAG, "[onNotifyMessageOpened] " + notificationMessage);
        String str = notificationMessage.notificationContent;
        try {
            JSONObject jSONObject = new JSONObject(notificationMessage.notificationExtras);
            String optString = jSONObject.optString("dev_uid");
            String optString2 = jSONObject.optString("dev_uid");
            int optInt = jSONObject.optInt("unsub_en");
            String replace = optString2.replace("-", "");
            int i2 = 0;
            while (true) {
                if (i2 >= SystemValue.arrayList.size()) {
                    z = false;
                    break;
                } else {
                    if (replace.equalsIgnoreCase(SystemValue.arrayList.get(i2).getDev_Did())) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
            if (!z) {
                HashSet hashSet = new HashSet();
                hashSet.add(replace);
                JPushInterface.deleteTags(context, 0, hashSet);
                if (optInt != 1 || (decodeString = SpUtil.INSTANCE.decodeString("SHIXUUID")) == null || TextUtils.isEmpty(decodeString)) {
                    return;
                }
                NativeCallerTools.SDKAPIOpenDeviceSendCmd(replace, CommonUtil.SHIX_Delpush2(decodeString));
                return;
            }
            if (str.startsWith("Alarmning")) {
                String str2 = str.substring(18, 22) + str.substring(15, 17) + str.substring(12, 14);
                Intent intent = new Intent(context, (Class<?>) CloudLogActivity.class);
                intent.addFlags(268435456);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, optString);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, "camName");
                intent.putExtra(ContentCommon.STR_CLOUD_DATE, str2);
                context.startActivity(intent);
                MyLogUtils.d("tag", " did=" + optString + "  cloud_date=" + str2);
                return;
            }
            if (str.contains("报警")) {
                String str3 = str.substring(13, 17) + str.substring(10, 12) + str.substring(7, 9);
                MyLogUtils.d("tag", " Alarmning mMessage=" + str + " --" + str.substring(13, 17) + " --" + str.substring(10, 12) + " --" + str.substring(7, 9));
                Intent intent2 = new Intent(context, (Class<?>) CloudLogActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, optString);
                intent2.putExtra(ContentCommon.STR_CAMERA_NAME, "camName");
                intent2.putExtra(ContentCommon.STR_CLOUD_DATE, str3);
                context.startActivity(intent2);
                MyLogUtils.d("tag", " did=" + optString + "  cloud_date=" + str3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onRegister(Context context, String str) {
        Log.e(TAG, "[onRegister] " + str);
        Intent intent = new Intent("com.jiguang.demo.message");
        intent.putExtra("rid", str);
        context.sendBroadcast(intent);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        TagAliasOperatorHelper.getInstance().onTagOperatorResult(context, jPushMessage);
        super.onTagOperatorResult(context, jPushMessage);
    }
}
