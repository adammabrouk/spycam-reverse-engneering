package com.shix.shixipc.he;

import com.shix.shixipc.bean.CameraParamsBean;

/* compiled from: ModelBean.kt */
/* loaded from: classes.dex */
public final class DeviceModel {
    public CameraParamsBean cameraParamsBean;
    public boolean defaultPwdToConnect;
    public String iccid;
    public boolean isApMode;
    public String lowPower;
    public int sdkId = -1;
    public int status;

    public final CameraParamsBean getCameraParamsBean() {
        return this.cameraParamsBean;
    }

    public final boolean getDefaultPwdToConnect() {
        return this.defaultPwdToConnect;
    }

    public final String getIccid() {
        return this.iccid;
    }

    public final String getLowPower() {
        return this.lowPower;
    }

    public final int getSdkId() {
        return this.sdkId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean isApMode() {
        return this.isApMode;
    }

    public final void setApMode(boolean z) {
        this.isApMode = z;
    }

    public final void setCameraParamsBean(CameraParamsBean cameraParamsBean) {
        this.cameraParamsBean = cameraParamsBean;
    }

    public final void setDefaultPwdToConnect(boolean z) {
        this.defaultPwdToConnect = z;
    }

    public final void setIccid(String str) {
        this.iccid = str;
    }

    public final void setLowPower(String str) {
        this.lowPower = str;
    }

    public final void setSdkId(int i2) {
        this.sdkId = i2;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }
}
