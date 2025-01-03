package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.FileUtil;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CameraParamsBean implements Serializable {
    public static final long serialVersionUID = -1893938966606638092L;
    public String dev_Did;
    public String dev_Pwd;
    public String dev_User;
    public String dev_name;
    public int dev_p2pstatus = -1;
    public int resetrict = -1;
    public int sdkId = -1;
    public int status = 1;
    public String devicePath = "";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static CameraParamsBean jsonToModel(String str) throws JSONException {
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        JSONObject jSONObject = new JSONObject(str);
        cameraParamsBean.setDev_Did(CommonUtil.jasonPaseString(jSONObject, "dev_Did"));
        cameraParamsBean.setDev_User(CommonUtil.jasonPaseString(jSONObject, "dev_User"));
        cameraParamsBean.setDev_Pwd(CommonUtil.jasonPaseString(jSONObject, "dev_Pwd"));
        cameraParamsBean.setDev_name(CommonUtil.jasonPaseString(jSONObject, "dev_name"));
        return cameraParamsBean;
    }

    public static String toJson(CameraParamsBean cameraParamsBean) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dev_Did", cameraParamsBean.getDev_Did());
        jSONObject.put("dev_User", cameraParamsBean.getDev_User());
        jSONObject.put("dev_Pwd", cameraParamsBean.getDev_Pwd());
        jSONObject.put("dev_name", cameraParamsBean.getDev_name());
        return jSONObject.toString();
    }

    public String getDev_Did() {
        return this.dev_Did;
    }

    public String getDev_Pwd() {
        return this.dev_Pwd;
    }

    public String getDev_User() {
        return this.dev_User;
    }

    public String getDev_name() {
        return this.dev_name;
    }

    public int getDev_p2pstatus() {
        return this.dev_p2pstatus;
    }

    public String getDevicePath() {
        return this.devicePath;
    }

    public int getResetrict() {
        return this.resetrict;
    }

    public int getSdkId() {
        return this.sdkId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDev_Did(String str) {
        this.dev_Did = str;
        this.devicePath = FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/picid/" + str + ".jpg";
    }

    public void setDev_Pwd(String str) {
        this.dev_Pwd = str;
    }

    public void setDev_User(String str) {
        this.dev_User = str;
    }

    public void setDev_name(String str) {
        this.dev_name = str;
    }

    public void setDev_p2pstatus(int i2) {
        this.dev_p2pstatus = i2;
    }

    public void setResetrict(int i2) {
        this.resetrict = i2;
    }

    public void setSdkId(int i2) {
        this.sdkId = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
