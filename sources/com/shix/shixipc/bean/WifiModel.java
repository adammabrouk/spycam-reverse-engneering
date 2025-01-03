package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WifiModel {
    public int cmd;
    public int conmode;
    public int encryption;
    public int result;
    public int signal;
    public String ssid;
    public String wifipwd;

    public static WifiModel jsonToModel(String str) throws JSONException {
        WifiModel wifiModel = new WifiModel();
        JSONObject jSONObject = new JSONObject(str);
        wifiModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        wifiModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        wifiModel.setSsid(CommonUtil.jasonPaseString(jSONObject, "ssid"));
        wifiModel.setSignal(CommonUtil.jasonPaseInt(jSONObject, "signal", ContentCommon.SHIXFINAL_ERRORINT));
        wifiModel.setEncryption(CommonUtil.jasonPaseInt(jSONObject, "encryption", ContentCommon.SHIXFINAL_ERRORINT));
        wifiModel.setConmode(CommonUtil.jasonPaseInt(jSONObject, "conmode", ContentCommon.SHIXFINAL_ERRORINT));
        return wifiModel;
    }

    public static String toJson(WifiModel wifiModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_sd");
        jSONObject.put("cmd", 114);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("ssid", wifiModel.getSsid());
        jSONObject.put("wifipwd", wifiModel.getWifipwd());
        jSONObject.put("encryption", wifiModel.getEncryption());
        return jSONObject.toString();
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getConmode() {
        return this.conmode;
    }

    public int getEncryption() {
        return this.encryption;
    }

    public int getResult() {
        return this.result;
    }

    public int getSignal() {
        return this.signal;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getWifipwd() {
        return this.wifipwd;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setConmode(int i2) {
        this.conmode = i2;
    }

    public void setEncryption(int i2) {
        this.encryption = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setSignal(int i2) {
        this.signal = i2;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setWifipwd(String str) {
        this.wifipwd = str;
    }

    public String toString() {
        return "WifiModel{cmd=" + this.cmd + ", result=" + this.result + ", ssid='" + this.ssid + "', wifipwd='" + this.wifipwd + "', encryption=" + this.encryption + ", signal=" + this.signal + ", conmode=" + this.conmode + '}';
    }
}
