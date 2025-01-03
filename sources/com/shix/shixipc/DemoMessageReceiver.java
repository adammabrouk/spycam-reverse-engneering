package com.shix.shixipc;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.k.c.a.l;
import c.k.c.a.n;
import c.k.c.a.o;
import com.shix.shixipc.activity.CloudLogActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.ActivityTaskManager;
import com.shix.shixipc.utils.MyLogUtils;
import java.util.List;

/* loaded from: classes.dex */
public class DemoMessageReceiver extends com.xiaomi.mipush.sdk.PushMessageReceiver {
    public String mAlias;
    public String mCommand;
    public String mEndTime;
    public String mMessage;
    public String mReason;
    public String mRegId;
    public long mResultCode = -1;
    public String mStartTime;
    public String mTopic;
    public String mUserAccount;

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, n nVar) {
        String command = nVar.getCommand();
        List<String> commandArguments = nVar.getCommandArguments();
        String str = null;
        String str2 = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            str = commandArguments.get(1);
        }
        if ("register".equals(command)) {
            if (nVar.getResultCode() == 0) {
                this.mRegId = str2;
            }
        } else if ("set-alias".equals(command)) {
            if (nVar.getResultCode() == 0) {
                this.mAlias = str2;
            }
        } else if ("unset-alias".equals(command)) {
            if (nVar.getResultCode() == 0) {
                this.mAlias = str2;
            }
        } else if ("subscribe-topic".equals(command)) {
            if (nVar.getResultCode() == 0) {
                this.mTopic = str2;
            }
        } else if ("unsubscibe-topic".equals(command)) {
            if (nVar.getResultCode() == 0) {
                this.mTopic = str2;
            }
        } else if ("accept-time".equals(command) && nVar.getResultCode() == 0) {
            this.mStartTime = str2;
            this.mEndTime = str;
        }
        MyLogUtils.d("tag", " onCommandResult   " + toString());
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, o oVar) {
        this.mMessage = oVar.getContent();
        if (!TextUtils.isEmpty(oVar.getTopic())) {
            this.mTopic = oVar.getTopic();
        } else if (!TextUtils.isEmpty(oVar.getAlias())) {
            this.mAlias = oVar.getAlias();
        } else if (!TextUtils.isEmpty(oVar.getUserAccount())) {
            this.mUserAccount = oVar.getUserAccount();
        } else if (!TextUtils.isEmpty(oVar.getCategory())) {
            this.mStartTime = oVar.getUserAccount();
        } else if (!TextUtils.isEmpty(oVar.getDescription())) {
            this.mEndTime = oVar.getUserAccount();
        } else if (TextUtils.isEmpty(oVar.getTitle())) {
            if (!TextUtils.isEmpty(oVar.getPassThrough() + "")) {
                this.mReason = oVar.getUserAccount();
            }
        } else {
            this.mCommand = oVar.getUserAccount();
        }
        if (this.mTopic != null) {
            boolean z = false;
            if (SystemValue.arrayList.size() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= SystemValue.arrayList.size()) {
                        break;
                    }
                    if (this.mTopic.equalsIgnoreCase(SystemValue.arrayList.get(i2).getDev_Did())) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
            if (!z) {
                l.g(context, this.mTopic, null);
            }
        }
        MyLogUtils.d("tag", " onNotificationMessageArrived:" + toString() + " \n message:" + oVar.toString());
        if ("103".equals(oVar.getExtra().get("alarm_type"))) {
            ActivityTaskManager.getInstance().closeAllActivity();
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, o oVar) {
        boolean z;
        this.mMessage = oVar.getContent();
        if (!TextUtils.isEmpty(oVar.getTopic())) {
            this.mTopic = oVar.getTopic();
        } else if (!TextUtils.isEmpty(oVar.getAlias())) {
            this.mAlias = oVar.getAlias();
        } else if (!TextUtils.isEmpty(oVar.getUserAccount())) {
            this.mUserAccount = oVar.getUserAccount();
        }
        if (SystemValue.arrayList.size() > 0) {
            for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
                if (this.mTopic.equalsIgnoreCase(SystemValue.arrayList.get(i2).getDev_Did())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            l.g(context, this.mTopic, null);
        }
        if (this.mMessage.startsWith("Alarmning")) {
            String str = this.mTopic.substring(0, 3) + "-" + this.mTopic.substring(3, 9) + "-" + this.mTopic.substring(9);
            String str2 = this.mMessage.substring(18, 22) + this.mMessage.substring(15, 17) + this.mMessage.substring(12, 14);
            Intent intent = new Intent(context, (Class<?>) CloudLogActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, str);
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, "camName");
            intent.putExtra(ContentCommon.STR_CLOUD_DATE, str2);
            context.startActivity(intent);
            MyLogUtils.d("tag", " did=" + str + "  cloud_date=" + str2);
        } else if (this.mMessage.contains("报警")) {
            String str3 = this.mTopic.substring(0, 3) + "-" + this.mTopic.substring(3, 9) + "-" + this.mTopic.substring(9);
            String str4 = this.mMessage.substring(13, 17) + this.mMessage.substring(10, 12) + this.mMessage.substring(7, 9);
            MyLogUtils.d("tag", " Alarmning mMessage=" + this.mMessage + " --" + this.mMessage.substring(13, 17) + " --" + this.mMessage.substring(10, 12) + " --" + this.mMessage.substring(7, 9));
            Intent intent2 = new Intent(context, (Class<?>) CloudLogActivity.class);
            intent2.addFlags(268435456);
            intent2.putExtra(ContentCommon.STR_CAMERA_ID, str3);
            intent2.putExtra(ContentCommon.STR_CAMERA_NAME, "camName");
            intent2.putExtra(ContentCommon.STR_CLOUD_DATE, str4);
            context.startActivity(intent2);
            MyLogUtils.d("tag", " did=" + str3 + "  cloud_date=" + str4);
        }
        MyLogUtils.d("tag", " onNotificationMessageClicked   " + toString());
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, o oVar) {
        this.mMessage = oVar.getContent();
        if (!TextUtils.isEmpty(oVar.getTopic())) {
            this.mTopic = oVar.getTopic();
        } else if (!TextUtils.isEmpty(oVar.getAlias())) {
            this.mAlias = oVar.getAlias();
        } else if (!TextUtils.isEmpty(oVar.getUserAccount())) {
            this.mUserAccount = oVar.getUserAccount();
        }
        MyLogUtils.d("tag", " onReceivePassThroughMessage   " + toString());
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, n nVar) {
        String command = nVar.getCommand();
        List<String> commandArguments = nVar.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            commandArguments.get(1);
        }
        if ("register".equals(command) && nVar.getResultCode() == 0) {
            this.mRegId = str;
        }
        ContentCommon.XM_TOKEN = this.mRegId;
        MyLogUtils.d("tag", " onReceiveRegisterResult   " + toString());
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onRequirePermissions(Context context, String[] strArr) {
        super.onRequirePermissions(context, strArr);
        MyLogUtils.d("tag", " onRequirePermissions   " + toString());
    }

    public String toString() {
        return "MiPushDemoMessageReceiver{mRegId='" + this.mRegId + "', mResultCode=" + this.mResultCode + ", mReason='" + this.mReason + "', mCommand='" + this.mCommand + "', mMessage='" + this.mMessage + "', mTopic='" + this.mTopic + "', mAlias='" + this.mAlias + "', mUserAccount='" + this.mUserAccount + "', mStartTime='" + this.mStartTime + "', mEndTime='" + this.mEndTime + "'}";
    }
}
