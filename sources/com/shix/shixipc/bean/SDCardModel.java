package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDCardModel {
    public int cmd;
    public int coverage;
    public int free;
    public int result;
    public int sdstatu;
    public int total;

    public static SDCardModel jsonToModel(String str) throws JSONException {
        SDCardModel sDCardModel = new SDCardModel();
        JSONObject jSONObject = new JSONObject(str);
        sDCardModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        sDCardModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        sDCardModel.setTotal(CommonUtil.jasonPaseInt(jSONObject, "total", 0));
        sDCardModel.setFree(CommonUtil.jasonPaseInt(jSONObject, "free", 0));
        sDCardModel.setCoverage(CommonUtil.jasonPaseInt(jSONObject, "coverage", ContentCommon.SHIXFINAL_ERRORINT));
        sDCardModel.setSdstatu(CommonUtil.jasonPaseInt(jSONObject, "sdstatu", ContentCommon.SHIXFINAL_ERRORINT));
        return sDCardModel;
    }

    public static String toJson(SDCardModel sDCardModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_sd");
        jSONObject.put("cmd", 110);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("coverage", sDCardModel.getCoverage());
        jSONObject.put("format", 0);
        return jSONObject.toString();
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getCoverage() {
        return this.coverage;
    }

    public int getFree() {
        return this.free;
    }

    public int getResult() {
        return this.result;
    }

    public int getSdstatu() {
        return this.sdstatu;
    }

    public int getTotal() {
        return this.total;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setCoverage(int i2) {
        this.coverage = i2;
    }

    public void setFree(int i2) {
        this.free = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setSdstatu(int i2) {
        this.sdstatu = i2;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }
}
