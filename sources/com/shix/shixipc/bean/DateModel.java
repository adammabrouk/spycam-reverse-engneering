package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DateModel {
    public int apiVer;
    public int cmd;
    public int dstSwitch;
    public String ntpServer;
    public int ntpSwitch;
    public int result;
    public int time;
    public int timeHour;
    public float timeZone;
    public int timeZone_Sec;

    public static DateModel jsonToModel(String str) throws JSONException {
        DateModel dateModel = new DateModel();
        JSONObject jSONObject = new JSONObject(str);
        dateModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setApiVer(CommonUtil.jasonPaseInt(jSONObject, "apiVer", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setNtpSwitch(CommonUtil.jasonPaseInt(jSONObject, "ntpSwitch", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setDstSwitch(CommonUtil.jasonPaseInt(jSONObject, "dstSwitch", ContentCommon.SHIXFINAL_ERRORINT));
        if (dateModel.getApiVer() == 1) {
            dateModel.setTimeZone(CommonUtil.jasonPaseFloat(jSONObject, "timeZone", -110.0f));
        } else {
            dateModel.setTimeZone(CommonUtil.jasonPaseInt(jSONObject, "timeZone", ContentCommon.SHIXFINAL_ERRORINT));
        }
        dateModel.setTime(CommonUtil.jasonPaseInt(jSONObject, "time", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setTimeHour(CommonUtil.jasonPaseInt(jSONObject, "timeHour", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setTimeZone_Sec(CommonUtil.jasonPaseInt(jSONObject, "timeZone_Sec", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setNtpServer(CommonUtil.jasonPaseString(jSONObject, "ntpServer"));
        return dateModel;
    }

    public static String toJson(DateModel dateModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_datetime");
        jSONObject.put("cmd", 126);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("ntpSwitch", dateModel.getNtpSwitch());
        jSONObject.put("dstSwitch", dateModel.getDstSwitch());
        if (dateModel.getApiVer() == 1) {
            jSONObject.put("timeZone", dateModel.getTimeZone());
        } else {
            jSONObject.put("timeZone", (int) dateModel.getTimeZone());
        }
        jSONObject.put("time", dateModel.getTime());
        jSONObject.put("ntpServer", dateModel.getNtpServer());
        jSONObject.put("timeHour", dateModel.getTimeHour());
        jSONObject.put("timeZone_Sec", dateModel.getTimeZone_Sec());
        return jSONObject.toString();
    }

    public int getApiVer() {
        return this.apiVer;
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getDstSwitch() {
        return this.dstSwitch;
    }

    public String getNtpServer() {
        return this.ntpServer;
    }

    public int getNtpSwitch() {
        return this.ntpSwitch;
    }

    public int getResult() {
        return this.result;
    }

    public int getTime() {
        return this.time;
    }

    public int getTimeHour() {
        return this.timeHour;
    }

    public float getTimeZone() {
        return this.timeZone;
    }

    public int getTimeZone_Sec() {
        return this.timeZone_Sec;
    }

    public void setApiVer(int i2) {
        this.apiVer = i2;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setDstSwitch(int i2) {
        this.dstSwitch = i2;
    }

    public void setNtpServer(String str) {
        this.ntpServer = str;
    }

    public void setNtpSwitch(int i2) {
        this.ntpSwitch = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setTime(int i2) {
        this.time = i2;
    }

    public void setTimeHour(int i2) {
        this.timeHour = i2;
    }

    public void setTimeZone(float f2) {
        this.timeZone = f2;
    }

    public void setTimeZone_Sec(int i2) {
        this.timeZone_Sec = i2;
    }
}
