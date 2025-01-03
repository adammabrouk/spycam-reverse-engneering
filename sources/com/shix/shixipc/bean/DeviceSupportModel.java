package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceSupportModel {
    public int cmd;
    public int ircut_menu_dis;
    public int ptz;
    public int result;
    public int smd;

    public static DeviceSupportModel jsonToModel(String str) throws JSONException {
        DeviceSupportModel deviceSupportModel = new DeviceSupportModel();
        JSONObject jSONObject = new JSONObject(str);
        deviceSupportModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        deviceSupportModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        deviceSupportModel.setPtz(CommonUtil.jasonPaseInt(jSONObject, "ptz", ContentCommon.SHIXFINAL_ERRORINT));
        deviceSupportModel.setSmd(CommonUtil.jasonPaseInt(jSONObject, "smd", ContentCommon.SHIXFINAL_ERRORINT));
        deviceSupportModel.setIrcut_menu_dis(CommonUtil.jasonPaseInt(jSONObject, "ircut_menu_dis", ContentCommon.SHIXFINAL_ERRORINT));
        return deviceSupportModel;
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getIrcut_menu_dis() {
        return this.ircut_menu_dis;
    }

    public int getPtz() {
        return this.ptz;
    }

    public int getResult() {
        return this.result;
    }

    public int getSmd() {
        return this.smd;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setIrcut_menu_dis(int i2) {
        this.ircut_menu_dis = i2;
    }

    public void setPtz(int i2) {
        this.ptz = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setSmd(int i2) {
        this.smd = i2;
    }
}
