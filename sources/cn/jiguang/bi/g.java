package cn.jiguang.bi;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.api.SdkType;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class g extends JDispatchAction {
    private JAction a(String str) {
        return a.a().a(str);
    }

    private JActionExtra b(String str) {
        return a.a().b(str);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object beforLogin(Context context, String str, int i2, String str2) {
        JActionExtra b2 = b(str);
        if (b2 != null) {
            return b2.beforLogin(context, i2, str2);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object beforRegister(Context context, String str, int i2, String str2) {
        JActionExtra b2 = b(str);
        if (b2 != null) {
            return b2.beforRegister(context, i2, str2);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean checkAction(String str, int i2) {
        JActionExtra b2 = b(str);
        if (b2 != null) {
            return b2.checkAction(i2);
        }
        return true;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i2, int i3, long j, long j2, ByteBuffer byteBuffer) {
        JAction a2 = a(str);
        if (a2 != null) {
            d.b("SupportDispatchAction", "dispatchMessage ,command:" + i2 + ",ver:" + i3 + ",rid:" + j + ",reuqestId:" + j2);
            a2.dispatchMessage(context, 0L, i2, str.equals(SdkType.JMESSAGE.name()) ? new c(false, byteBuffer.limit() + 20, i3, i2, j, JCoreInterface.getSid(), JCoreInterface.getUid()) : new c(false, i3, i2, j2), byteBuffer);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchTimeOutMessage(Context context, String str, long j, int i2) {
        JAction a2 = a(str);
        if (a2 != null) {
            a2.dispatchTimeOutMessage(context, 0L, j, i2);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSSP.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 3;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 6;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 7 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 8;
        }
        if (str.equals(SdkType.JSSP.name())) {
            return (short) 128;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 32;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 256;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 512;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 1024 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 8;
        }
        if (str.equals(SdkType.JSSP.name())) {
            return (short) 128;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 32;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 256;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 512;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 1024 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 0;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JSSP.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 6;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 7 : (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return "sdk_ver";
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return "statistics_sdk_ver";
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return "share_sdk_ver";
        }
        if (str.equals(SdkType.JSSP.name())) {
            return "ssp_sdk_ver";
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return "im_sdk_ver";
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return "verification_sdk_ver";
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return "mlink_sdk_ver";
        }
        if (str.equals(SdkType.JUNION.name())) {
            return "junion_sdk_ver";
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        JAction a2 = a(str);
        return a2 != null ? a2.getSdkVersion() : "";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JSSP.name())) {
            return (short) 9;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 10;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 11;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 12 : (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
        d.b("SupportDispatchAction", "handleMessage,sdkType:" + str);
        JAction a2 = a(str);
        if (a2 != null) {
            a2.handleMessage(context, 0L, obj);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i2) {
        JAction a2 = a(str);
        if (a2 != null) {
            return a2.isSupportedCMD(i2);
        }
        return false;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        JAction a2 = a(str);
        if (a2 != null) {
            a2.onActionRun(context, 0L, bundle, null);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onEvent(Context context, String str, int i2, int i3, String str2) {
        JAction a2 = a(str);
        if (a2 != null) {
            a2.onEvent(context, 0L, i2);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object onSendData(Context context, String str, long j, int i2, int i3) {
        JActionExtra b2 = b(str);
        if (b2 != null) {
            return b2.onSendData(context, 0L, j, i2, i3);
        }
        return null;
    }
}
