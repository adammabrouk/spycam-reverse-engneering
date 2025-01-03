package com.shix.shixipc;

import android.content.Context;
import android.util.Log;
import cn.jpush.android.api.JPushMessage;

/* loaded from: classes.dex */
public class TagAliasOperatorHelper {
    public static final String TAG = "JIGUANG-TagAliasHelper";
    public static TagAliasOperatorHelper mInstance;
    public Context context;

    public static TagAliasOperatorHelper getInstance() {
        if (mInstance == null) {
            synchronized (TagAliasOperatorHelper.class) {
                if (mInstance == null) {
                    mInstance = new TagAliasOperatorHelper();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context) {
        if (context != null) {
            this.context = context.getApplicationContext();
        }
    }

    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        int sequence = jPushMessage.getSequence();
        Log.i(TAG, "action - onAliasOperatorResult, sequence:" + sequence + ",alias:" + jPushMessage.getAlias());
        init(context);
        if (jPushMessage.getErrorCode() == 0) {
            Log.i(TAG, "action - modify alias Success,sequence:" + sequence);
            return;
        }
        Log.e(TAG, "Failed to modify alias, errorCode:" + jPushMessage.getErrorCode());
    }

    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        Log.i(TAG, "action - onCheckTagOperatorResult, sequence:" + jPushMessage.getSequence() + ",checktag:" + jPushMessage.getCheckTag());
        init(context);
        if (jPushMessage.getErrorCode() != 0) {
            Log.e(TAG, "Failed to modify tags, errorCode:" + jPushMessage.getErrorCode());
            return;
        }
        Log.i(TAG, "modify tag " + jPushMessage.getCheckTag() + " bind state success,state:" + jPushMessage.getTagCheckStateResult());
    }

    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        int sequence = jPushMessage.getSequence();
        Log.i(TAG, "action - onMobileNumberOperatorResult, sequence:" + sequence + ",mobileNumber:" + jPushMessage.getMobileNumber());
        init(context);
        if (jPushMessage.getErrorCode() == 0) {
            Log.i(TAG, "action - set mobile number Success,sequence:" + sequence);
            return;
        }
        Log.e(TAG, "Failed to set mobile number, errorCode:" + jPushMessage.getErrorCode());
    }

    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        int sequence = jPushMessage.getSequence();
        Log.i(TAG, "action - onTagOperatorResult, sequence:" + sequence + ",tags:" + jPushMessage.getTags());
        StringBuilder sb = new StringBuilder();
        sb.append("tags size:");
        sb.append(jPushMessage.getTags().size());
        Log.i(TAG, sb.toString());
        if (jPushMessage.getTags().size() > 0) {
            CrashApplication.setTags(jPushMessage.getTags());
        }
        init(context);
        if (jPushMessage.getErrorCode() == 0) {
            Log.i(TAG, "action - modify tag Success,sequence:" + sequence);
            return;
        }
        String str = "Failed to modify tags";
        if (jPushMessage.getErrorCode() == 6018) {
            str = "Failed to modify tags, tags is exceed limit need to clean";
        }
        Log.e(TAG, str + ", errorCode:" + jPushMessage.getErrorCode());
    }
}
