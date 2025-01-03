package cn.jpush.android.helper;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JDispatchAction;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.local.JPushResponse;
import com.shix.shixipc.system.ContentCommon;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class b extends JDispatchAction {
    @Override // cn.jiguang.api.JDispatchAction
    public Object beforLogin(Context context, String str, int i2, String str2) {
        return ActionHelper.getInstance().beforLogin(context, str, i2, str2);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i2, int i3, long j, long j2, ByteBuffer byteBuffer) {
        Logger.d("JPushDispacthAction", "dispatchMessage command:" + i2 + ",ver:" + i3 + ",rid:" + j + ",requestid:" + j2);
        ActionHelper.getInstance().doAction(context, JThirdPlatFormInterface.KEY_MSG, new JPushResponse(i2, j, j2, byteBuffer));
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchTimeOutMessage(Context context, String str, long j, int i2) {
        Bundle bundle = new Bundle();
        bundle.putLong("rid", j);
        bundle.putInt("cmd", i2);
        ActionHelper.getInstance().doAction(context, "msg_time_out", bundle);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object getDataByCmd(Context context, int i2) {
        if (i2 != 30000) {
            if (30001 == i2) {
                return "sdk_ver_local";
            }
            if (30002 == i2) {
                return JPushConstants.SDK_VERSION_NAME;
            }
            return null;
        }
        String a2 = cn.jpush.android.bc.a.a();
        Logger.d("JPushDispacthAction", "core get push animator config file version: " + a2);
        return a2;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Bundle getPInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("pid", 2);
        bundle.putString(JThirdPlatFormInterface.KEY_CODE, JPushConstants.SDK_VERSION_CODE + "");
        return bundle;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return ActionHelper.getInstance().getSdkVersion(str);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
        ActionHelper.getInstance().doAction(context, "handle_msg", obj);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i2) {
        return ActionHelper.getInstance().isSupportedCMD(str, i2);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        ActionHelper.getInstance().doAction(context, str2, bundle);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onEvent(Context context, String str, int i2, int i3, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt(ContentCommon.TYPE, i2);
        bundle.putInt(JThirdPlatFormInterface.KEY_CODE, i3);
        bundle.putString(JThirdPlatFormInterface.KEY_MSG, str2);
        ActionHelper.getInstance().doAction(context, "jcore_on_event", bundle);
    }
}
