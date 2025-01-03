package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceOffTimeModel {
    public int cmd;
    public int resule;
    public int timedOffDays;
    public int timedOffTime;

    public static DeviceOffTimeModel jsonToModel(String str) throws JSONException {
        DeviceOffTimeModel deviceOffTimeModel = new DeviceOffTimeModel();
        JSONObject jSONObject = new JSONObject(str);
        deviceOffTimeModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        deviceOffTimeModel.setResule(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        deviceOffTimeModel.setTimedOffTime(CommonUtil.jasonPaseInt(jSONObject, "timedOffTime", ContentCommon.SHIXFINAL_ERRORINT));
        deviceOffTimeModel.setTimedOffDays(CommonUtil.jasonPaseInt(jSONObject, "timedOffDays", ContentCommon.SHIXFINAL_ERRORINT));
        return deviceOffTimeModel;
    }

    public static String sendToJsonOne(String str, String str2, String str3, int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_light_param");
        jSONObject.put("cmd", 121);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put(str3, i2);
        return jSONObject.toString();
    }

    public static String toJson(DeviceOffTimeModel deviceOffTimeModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_light_param");
        jSONObject.put("cmd", 121);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("timedOffTime", deviceOffTimeModel.getTimedOffTime());
        jSONObject.put("timedOffDays", deviceOffTimeModel.getTimedOffDays());
        return jSONObject.toString();
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getResule() {
        return this.resule;
    }

    public int getTimedOffDays() {
        return this.timedOffDays;
    }

    public int getTimedOffTime() {
        return this.timedOffTime;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setResule(int i2) {
        this.resule = i2;
    }

    public void setTimedOffDays(int i2) {
        this.timedOffDays = i2;
    }

    public void setTimedOffTime(int i2) {
        this.timedOffTime = i2;
    }

    public String toString() {
        return "DeviceOffTimeModel{cmd=" + this.cmd + ", resule=" + this.resule + ", timedOffTime=" + this.timedOffTime + '}';
    }
}
