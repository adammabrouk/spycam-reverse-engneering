package com.shix.shixipc.he;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.shix.shixipc.activity.FragmentCameraList;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.MyLogUtils;
import f.j.b.f;
import object.p2pipcam.nativecaller.NativeCaller;

/* compiled from: NativeCallerTools.kt */
/* loaded from: classes.dex */
public final class NativeCallerTools {
    public static final NativeCallerTools INSTANCE = new NativeCallerTools();

    public static final void SDKAPICleanUp() {
        NativeCaller.SDKAPICleanUp();
    }

    public static final void SDKAPICloseDevice(int i2) {
        NativeCaller.SDKAPICloseDevice(i2);
    }

    public static final void SDKAPICloseLiveStream(String str) {
        int i2;
        f.c(str, FragmentCameraList.STR_DID);
        Boolean queryKey = SpUtil.INSTANCE.queryKey(str);
        f.a(queryKey);
        if (queryKey.booleanValue()) {
            Integer decodeInt = SpUtil.INSTANCE.decodeInt(str);
            f.a(decodeInt);
            i2 = decodeInt.intValue();
        } else {
            i2 = -1;
        }
        NativeCaller.SDKAPICloseLiveStream(i2);
    }

    public static final void SDKAPIClosePlayBack(int i2) {
        NativeCaller.SDKAPIClosePlayBack(i2);
    }

    public static final void SDKAPICloseTalk(String str) {
        int i2;
        f.c(str, FragmentCameraList.STR_DID);
        Boolean queryKey = SpUtil.INSTANCE.queryKey(str);
        f.a(queryKey);
        if (queryKey.booleanValue()) {
            Integer decodeInt = SpUtil.INSTANCE.decodeInt(str);
            f.a(decodeInt);
            i2 = decodeInt.intValue();
        } else {
            i2 = -1;
        }
        NativeCaller.SDKAPICloseTalk(i2);
    }

    public static final int SDKAPIDecodeH264Frame(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int[] iArr, int i5) {
        f.c(bArr, "f_arrEncData");
        f.c(bArr2, "f_arrYuvData");
        f.c(iArr, "f_WH");
        return NativeCaller.SDKAPIDecodeH264Frame(bArr, i2, i3, bArr2, i4, iArr, i5);
    }

    public static final int SDKAPIDecodeVdata(int i2, int i3, byte[] bArr, int i4, byte[] bArr2, int i5, int[] iArr) {
        f.c(bArr, "h264Data");
        f.c(bArr2, "f_arrYUVData");
        f.c(iArr, "wh");
        return NativeCaller.SDKAPIDecodeVdata(i2, i3, bArr, i4, bArr2, i5, iArr);
    }

    public static final void SDKAPIInit() {
        NativeCaller.SDKAPIInit(ContentCommon.SERVER_STRING);
    }

    public static final int SDKAPIOpenDevice(String str, String str2, String str3) {
        f.c(str, FragmentCameraList.STR_DID);
        f.c(str2, "user");
        f.c(str3, "pwd");
        return NativeCaller.SDKAPIOpenDevice(str, str2, str3, 0);
    }

    public static final int SDKAPIOpenDeviceSendCmd(String str, String str2) {
        f.c(str, FragmentCameraList.STR_DID);
        f.c(str2, "jsonStr");
        return NativeCaller.SDKAPIOpenDeviceSendCmd(str, ContentCommon.DEFAULT_USER_NAME, "", str2);
    }

    public static final int SDKAPIOpenDeviceWithVideo(String str, String str2, String str3, int i2) {
        f.c(str, FragmentCameraList.STR_DID);
        f.c(str2, "user");
        f.c(str3, "pwd");
        return NativeCaller.SDKAPIOpenDevice(str, str2, str3, i2);
    }

    public static final void SDKAPIOpenLiveStream(String str, int i2) {
        int i3;
        f.c(str, FragmentCameraList.STR_DID);
        Boolean queryKey = SpUtil.INSTANCE.queryKey(str);
        f.a(queryKey);
        if (queryKey.booleanValue()) {
            Integer decodeInt = SpUtil.INSTANCE.decodeInt(str);
            f.a(decodeInt);
            i3 = decodeInt.intValue();
        } else {
            i3 = -1;
        }
        if (i2 == 1) {
            MyLogUtils.e("tag", "SDKAPIOpenLiveStream 打开高清视频 sdkId=" + i3 + " result = " + NativeCaller.SDKAPIOpenLiveStream(i3, 1));
            return;
        }
        if (i2 == 2) {
            MyLogUtils.e("tag", "SDKAPIOpenLiveStream 打开标清视频 sdkId=" + i3 + " result = " + NativeCaller.SDKAPIOpenLiveStream(i3, 2));
        }
    }

    public static final int SDKAPIOpenPlayBack(int i2, String str, int i3) {
        return NativeCaller.SDKAPIOpenPlayBack(i2, str, i3);
    }

    public static final int SDKAPIOpenTalk(String str) {
        int i2;
        f.c(str, FragmentCameraList.STR_DID);
        Boolean queryKey = SpUtil.INSTANCE.queryKey(str);
        f.a(queryKey);
        if (queryKey.booleanValue()) {
            Integer decodeInt = SpUtil.INSTANCE.decodeInt(str);
            f.a(decodeInt);
            i2 = decodeInt.intValue();
        } else {
            i2 = -1;
        }
        return NativeCaller.SDKAPIOpenTalk(i2);
    }

    public static final void SDKAPISendTalkData(String str, byte[] bArr, int i2) {
        int i3;
        f.c(str, FragmentCameraList.STR_DID);
        f.c(bArr, JThirdPlatFormInterface.KEY_DATA);
        Boolean queryKey = SpUtil.INSTANCE.queryKey(str);
        f.a(queryKey);
        if (queryKey.booleanValue()) {
            Integer decodeInt = SpUtil.INSTANCE.decodeInt(str);
            f.a(decodeInt);
            i3 = decodeInt.intValue();
        } else {
            i3 = -1;
        }
        NativeCaller.SDKAPISendTalkData(i3, bArr, i2);
    }

    public static final void SDKAPISetCallbackContext(Object obj) {
        f.c(obj, "context");
        NativeCaller.SDKAPISetCallbackContext(obj);
    }

    public static final int SDKAPIStartSearchLanDev(String str) {
        f.c(str, "strIp");
        return NativeCaller.SDKAPIStartSearchLanDev(str);
    }

    public static final void SDKAPIStopSearchLanDev() {
        NativeCaller.SDKAPIStopSearchLanDev();
    }

    public static final void SDKAPITransferBinary(int i2, byte[] bArr) {
        f.c(bArr, JThirdPlatFormInterface.KEY_DATA);
        NativeCaller.SDKAPITransferBinary(i2, Constant.CODE_startCode, Constant.CODE_cmdCode, bArr, bArr.length);
    }

    public static final int SDKAPITransferMessage(int i2, String str) {
        f.c(str, "jsonStr");
        return NativeCaller.SDKAPITransferMessage(i2, Constant.CODE_startCode, Constant.CODE_cmdCode, str);
    }

    public static final int SDKAPIYuv420ToRgb565(byte[] bArr, byte[] bArr2, int i2, int i3) {
        return NativeCaller.SDKAPIYuv420ToRgb565(bArr, bArr2, i2, i3);
    }

    public static final int SDKAPITransferMessage(String str, String str2) {
        int i2;
        f.c(str, FragmentCameraList.STR_DID);
        f.c(str2, "jsonStr");
        Boolean queryKey = SpUtil.INSTANCE.queryKey(str);
        f.a(queryKey);
        if (queryKey.booleanValue()) {
            Integer decodeInt = SpUtil.INSTANCE.decodeInt(str);
            f.a(decodeInt);
            i2 = decodeInt.intValue();
        } else {
            i2 = -1;
        }
        return NativeCaller.SDKAPITransferMessage(i2, Constant.CODE_startCode, Constant.CODE_cmdCode, str2);
    }
}
