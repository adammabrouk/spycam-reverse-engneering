package com.shix.shixipc.he;

import com.shix.shixipc.activity.FragmentCameraList;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.MyLogUtils;
import f.j.b.f;
import f.k.i;
import java.util.ArrayList;

/* compiled from: DeviceUtil.kt */
/* loaded from: classes.dex */
public final class DeviceUtil {
    public static final DeviceUtil INSTANCE = new DeviceUtil();

    public final int StartPPPP(String str, String str2, String str3) {
        f.c(str, FragmentCameraList.STR_DID);
        f.c(str2, "user");
        f.c(str3, "pwd");
        MyLogUtils.e("tag", "SDKAPIOpenDevice did=" + str + "  user=" + str2 + " pwd=" + str3);
        int SDKAPIOpenDevice = NativeCallerTools.SDKAPIOpenDevice(str, str2, str3);
        if (SDKAPIOpenDevice >= 0) {
            int i2 = 0;
            ArrayList<CameraParamsBean> arrayList = SystemValue.arrayList;
            f.b(arrayList, "SystemValue.arrayList");
            int size = arrayList.size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
                f.b(cameraParamsBean, "SystemValue.arrayList[i]");
                if (i.a(cameraParamsBean.getDev_Did(), str, true)) {
                    CameraParamsBean cameraParamsBean2 = SystemValue.arrayList.get(i2);
                    f.b(cameraParamsBean2, "SystemValue.arrayList[i]");
                    cameraParamsBean2.setSdkId(SDKAPIOpenDevice);
                    CameraParamsBean cameraParamsBean3 = SystemValue.arrayList.get(i2);
                    f.b(cameraParamsBean3, "SystemValue.arrayList[i]");
                    cameraParamsBean3.setStatus(1);
                    break;
                }
                i2++;
            }
            SpUtil.INSTANCE.encode(Constant.MMKV_sdkId + SDKAPIOpenDevice, str);
            SpUtil.INSTANCE.encode(str, Integer.valueOf(SDKAPIOpenDevice));
            MyLogUtils.e("tag", "NativeCallerTools.SDKAPIOpenDevice 连接成功did=" + str + " 文件描述符=" + SDKAPIOpenDevice);
        } else {
            MyLogUtils.e("tag", "NativeCallerTools.SDKAPIOpenDevice 连接失败did=" + str + " 文件描述符=" + SDKAPIOpenDevice);
        }
        if (SDKAPIOpenDevice >= 0) {
            return SDKAPIOpenDevice;
        }
        return -1;
    }

    public final int StartPPPPWithVideo(String str, String str2, String str3, int i2) {
        f.c(str, FragmentCameraList.STR_DID);
        f.c(str2, "user");
        f.c(str3, "pwd");
        MyLogUtils.e("tag", "SDKAPIOpenDevice did=" + str + "  user=" + str2 + " pwd=" + str3 + " videoFlag= " + i2);
        int SDKAPIOpenDeviceWithVideo = NativeCallerTools.SDKAPIOpenDeviceWithVideo(str, str2, str3, i2);
        if (SDKAPIOpenDeviceWithVideo >= 0) {
            int i3 = 0;
            ArrayList<CameraParamsBean> arrayList = SystemValue.arrayList;
            f.b(arrayList, "SystemValue.arrayList");
            int size = arrayList.size();
            while (true) {
                if (i3 >= size) {
                    break;
                }
                CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i3);
                f.b(cameraParamsBean, "SystemValue.arrayList[i]");
                if (i.a(cameraParamsBean.getDev_Did(), str, true)) {
                    CameraParamsBean cameraParamsBean2 = SystemValue.arrayList.get(i3);
                    f.b(cameraParamsBean2, "SystemValue.arrayList[i]");
                    cameraParamsBean2.setSdkId(SDKAPIOpenDeviceWithVideo);
                    CameraParamsBean cameraParamsBean3 = SystemValue.arrayList.get(i3);
                    f.b(cameraParamsBean3, "SystemValue.arrayList[i]");
                    cameraParamsBean3.setStatus(1);
                    break;
                }
                i3++;
            }
            SpUtil.INSTANCE.encode(Constant.MMKV_sdkId + SDKAPIOpenDeviceWithVideo, str);
            SpUtil.INSTANCE.encode(str, Integer.valueOf(SDKAPIOpenDeviceWithVideo));
            MyLogUtils.e("tag", "NativeCallerTools.SDKAPIOpenDevice 连接成功did=" + str + " 文件描述符=" + SDKAPIOpenDeviceWithVideo);
        } else {
            MyLogUtils.e("tag", "NativeCallerTools.SDKAPIOpenDevice 连接成功did=" + str + " 文件描述符=" + SDKAPIOpenDeviceWithVideo);
        }
        if (SDKAPIOpenDeviceWithVideo >= 0) {
            return SDKAPIOpenDeviceWithVideo;
        }
        return -1;
    }

    public final void StopPPPP(String str) {
        int i2;
        f.c(str, FragmentCameraList.STR_DID);
        ArrayList<CameraParamsBean> arrayList = SystemValue.arrayList;
        f.b(arrayList, "SystemValue.arrayList");
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            }
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i3);
            f.b(cameraParamsBean, "SystemValue.arrayList[i]");
            if (f.a((Object) cameraParamsBean.getDev_Did(), (Object) str)) {
                CameraParamsBean cameraParamsBean2 = SystemValue.arrayList.get(i3);
                f.b(cameraParamsBean2, "SystemValue.arrayList[i]");
                i2 = cameraParamsBean2.getSdkId();
                MyLogUtils.e("tag", "StopPPPP  did = " + str + "  StopPPPP sdkId=" + i2 + ' ');
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            NativeCallerTools.SDKAPICloseDevice(i2);
            MyLogUtils.e("tag", " StopPPPP 关闭did=" + str + ' ');
            ArrayList<CameraParamsBean> arrayList2 = SystemValue.arrayList;
            f.b(arrayList2, "SystemValue.arrayList");
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                CameraParamsBean cameraParamsBean3 = SystemValue.arrayList.get(i4);
                f.b(cameraParamsBean3, "SystemValue.arrayList[i]");
                if (f.a((Object) cameraParamsBean3.getDev_Did(), (Object) str)) {
                    CameraParamsBean cameraParamsBean4 = SystemValue.arrayList.get(i4);
                    f.b(cameraParamsBean4, "SystemValue.arrayList[i]");
                    cameraParamsBean4.setSdkId(-1);
                    CameraParamsBean cameraParamsBean5 = SystemValue.arrayList.get(i4);
                    f.b(cameraParamsBean5, "SystemValue.arrayList[i]");
                    cameraParamsBean5.setStatus(0);
                    StringBuilder sb = new StringBuilder();
                    sb.append(" StopPPPP 关闭did=");
                    sb.append(str);
                    sb.append(" ,");
                    sb.append("sdkId =");
                    CameraParamsBean cameraParamsBean6 = SystemValue.arrayList.get(i4);
                    f.b(cameraParamsBean6, "SystemValue.arrayList[i]");
                    sb.append(cameraParamsBean6.getSdkId());
                    sb.append(",status=");
                    CameraParamsBean cameraParamsBean7 = SystemValue.arrayList.get(i4);
                    f.b(cameraParamsBean7, "SystemValue.arrayList[i]");
                    sb.append(cameraParamsBean7.getStatus());
                    sb.append(' ');
                    MyLogUtils.e("tag", sb.toString());
                    return;
                }
            }
        }
    }

    public final void backgroundStopPPPP(String str) {
        int i2;
        f.c(str, FragmentCameraList.STR_DID);
        ArrayList<CameraParamsBean> arrayList = SystemValue.arrayList;
        f.b(arrayList, "SystemValue.arrayList");
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            }
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i3);
            f.b(cameraParamsBean, "SystemValue.arrayList[i]");
            if (f.a((Object) cameraParamsBean.getDev_Did(), (Object) str)) {
                CameraParamsBean cameraParamsBean2 = SystemValue.arrayList.get(i3);
                f.b(cameraParamsBean2, "SystemValue.arrayList[i]");
                i2 = cameraParamsBean2.getSdkId();
                MyLogUtils.e("tag", "backgroundStopPPPP  did = " + str + " sdkId=" + i2 + ' ');
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            NativeCallerTools.SDKAPICloseDevice(i2);
            MyLogUtils.e("tag", " backgroundStopPPPP 关闭did=" + str + ' ');
            ArrayList<CameraParamsBean> arrayList2 = SystemValue.arrayList;
            f.b(arrayList2, "SystemValue.arrayList");
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                CameraParamsBean cameraParamsBean3 = SystemValue.arrayList.get(i4);
                f.b(cameraParamsBean3, "SystemValue.arrayList[i]");
                if (f.a((Object) cameraParamsBean3.getDev_Did(), (Object) str)) {
                    CameraParamsBean cameraParamsBean4 = SystemValue.arrayList.get(i4);
                    f.b(cameraParamsBean4, "SystemValue.arrayList[i]");
                    cameraParamsBean4.setSdkId(-1);
                    CameraParamsBean cameraParamsBean5 = SystemValue.arrayList.get(i4);
                    f.b(cameraParamsBean5, "SystemValue.arrayList[i]");
                    cameraParamsBean5.setStatus(9);
                    StringBuilder sb = new StringBuilder();
                    sb.append(" backgroundStopPPPP 关闭did=");
                    sb.append(str);
                    sb.append(" ,");
                    sb.append("sdkId =");
                    CameraParamsBean cameraParamsBean6 = SystemValue.arrayList.get(i4);
                    f.b(cameraParamsBean6, "SystemValue.arrayList[i]");
                    sb.append(cameraParamsBean6.getSdkId());
                    sb.append(",status=");
                    CameraParamsBean cameraParamsBean7 = SystemValue.arrayList.get(i4);
                    f.b(cameraParamsBean7, "SystemValue.arrayList[i]");
                    sb.append(cameraParamsBean7.getStatus());
                    sb.append(' ');
                    MyLogUtils.e("tag", sb.toString());
                    return;
                }
            }
        }
    }

    public final CameraParamsBean getCameraBean(int i2) {
        ArrayList<CameraParamsBean> arrayList = SystemValue.arrayList;
        f.b(arrayList, "SystemValue.arrayList");
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i3);
            f.b(cameraParamsBean, "SystemValue.arrayList[i]");
            if (cameraParamsBean.getSdkId() == i2) {
                return SystemValue.arrayList.get(i3);
            }
        }
        return null;
    }

    public final int getCameraBeanStatus(int i2) {
        CameraParamsBean cameraParamsBean;
        ArrayList<CameraParamsBean> arrayList = SystemValue.arrayList;
        f.b(arrayList, "SystemValue.arrayList");
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                cameraParamsBean = null;
                break;
            }
            CameraParamsBean cameraParamsBean2 = SystemValue.arrayList.get(i3);
            f.b(cameraParamsBean2, "SystemValue.arrayList[i]");
            if (cameraParamsBean2.getSdkId() == i2) {
                cameraParamsBean = SystemValue.arrayList.get(i3);
                break;
            }
            i3++;
        }
        if (cameraParamsBean != null) {
            return cameraParamsBean.getStatus();
        }
        return 0;
    }

    public final String getDid(int i2) {
        Boolean queryKey = SpUtil.INSTANCE.queryKey(Constant.MMKV_sdkId + i2);
        f.a(queryKey);
        if (!queryKey.booleanValue()) {
            return "";
        }
        return String.valueOf(SpUtil.INSTANCE.decodeString(Constant.MMKV_sdkId + i2));
    }

    public final int getSdkId(String str) {
        f.c(str, FragmentCameraList.STR_DID);
        Boolean queryKey = SpUtil.INSTANCE.queryKey(str);
        f.a(queryKey);
        if (!queryKey.booleanValue()) {
            return -1;
        }
        Integer decodeInt = SpUtil.INSTANCE.decodeInt(str);
        f.a(decodeInt);
        return decodeInt.intValue();
    }

    public final String getTime(String str) {
        f.c(str, "str");
        return str;
    }
}
