package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CameraParmsModel {
    public String AppMakeTime;
    public String SysMakeTime;
    public String alias;
    public String appver;
    public int batstatus;
    public int batvalue;
    public int bright;
    public int charging;
    public int clock;
    public int clockScreen;
    public int cmd;
    public int contrast;
    public int icut;
    public int ir_mode_end_sec;
    public int ir_mode_start_sec;
    public int ir_mode_timer_en;
    public int lamp;
    public String mcuver;
    public int menual_exposure_again;
    public int menual_exposure_dgain;
    public int menual_exposure_en;
    public int menual_exposure_expTime;
    public int menual_exposure_ispdgain;
    public int mic;
    public int online;
    public int oss_push_en;
    public int pirstatu;
    public int power;
    public int result;
    public int rotmir;
    public int signal;
    public int spk;
    public String sysver;
    public int watch;

    public static CameraParmsModel jsonToModel(String str) throws JSONException {
        CameraParmsModel cameraParmsModel = new CameraParmsModel();
        JSONObject jSONObject = new JSONObject(str);
        cameraParmsModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setMenual_exposure_en(CommonUtil.jasonPaseInt(jSONObject, "menual_exposure_en", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setMenual_exposure_expTime(CommonUtil.jasonPaseInt(jSONObject, "menual_exposure_expTime", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setMenual_exposure_again(CommonUtil.jasonPaseInt(jSONObject, "menual_exposure_again", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setMenual_exposure_dgain(CommonUtil.jasonPaseInt(jSONObject, "menual_exposure_dgain", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setMenual_exposure_ispdgain(CommonUtil.jasonPaseInt(jSONObject, "menual_exposure_ispdgain", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setBright(CommonUtil.jasonPaseInt(jSONObject, "bright", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setContrast(CommonUtil.jasonPaseInt(jSONObject, "contrast", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setIcut(CommonUtil.jasonPaseInt(jSONObject, "icut", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setRotmir(CommonUtil.jasonPaseInt(jSONObject, "rotmir", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setClockScreen(CommonUtil.jasonPaseInt(jSONObject, "clockScreen", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setPirstatu(CommonUtil.jasonPaseInt(jSONObject, "pirstatu", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setMic(CommonUtil.jasonPaseInt(jSONObject, "mic", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setSpk(CommonUtil.jasonPaseInt(jSONObject, "spk", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setLamp(CommonUtil.jasonPaseInt(jSONObject, "lamp", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setSysver(CommonUtil.jasonPaseString(jSONObject, "sysver"));
        cameraParmsModel.setMcuver(CommonUtil.jasonPaseString(jSONObject, "mcuver"));
        cameraParmsModel.setAppver(CommonUtil.jasonPaseString(jSONObject, "appver"));
        cameraParmsModel.setAlias(CommonUtil.jasonPaseString(jSONObject, "alias"));
        cameraParmsModel.setAppMakeTime(CommonUtil.jasonPaseString(jSONObject, "AppMakeTime"));
        cameraParmsModel.setSysMakeTime(CommonUtil.jasonPaseString(jSONObject, "SysMakeTime"));
        cameraParmsModel.setClock(CommonUtil.jasonPaseInt(jSONObject, "clock", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setPower(CommonUtil.jasonPaseInt(jSONObject, "power", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setCharging(CommonUtil.jasonPaseInt(jSONObject, "charging", ContentCommon.SHIXFINAL_ERRORINT));
        try {
            cameraParmsModel.setSignal(CommonUtil.jasonPaseInt(jSONObject, "signal", ContentCommon.SHIXFINAL_ERRORINT));
        } catch (Exception unused) {
        }
        try {
            cameraParmsModel.setBatvalue(CommonUtil.jasonPaseInt(jSONObject, "batValue", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setBatstatus(CommonUtil.jasonPaseInt(jSONObject, "batStatus", ContentCommon.SHIXFINAL_ERRORINT));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        cameraParmsModel.setOss_push_en(CommonUtil.jasonPaseInt(jSONObject, "oss_push_en", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setIr_mode_timer_en(CommonUtil.jasonPaseInt(jSONObject, "ir_mode_timer_en", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setIr_mode_start_sec(CommonUtil.jasonPaseInt(jSONObject, "ir_mode_start_sec", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setIr_mode_end_sec(CommonUtil.jasonPaseInt(jSONObject, "ir_mode_end_sec", ContentCommon.SHIXFINAL_ERRORINT));
        return cameraParmsModel;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getAppMakeTime() {
        return this.AppMakeTime;
    }

    public String getAppver() {
        return this.appver;
    }

    public int getBatstatus() {
        return this.batstatus;
    }

    public int getBatvalue() {
        return this.batvalue;
    }

    public int getBright() {
        return this.bright;
    }

    public int getCharging() {
        return this.charging;
    }

    public int getClock() {
        return this.clock;
    }

    public int getClockScreen() {
        return this.clockScreen;
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getContrast() {
        return this.contrast;
    }

    public int getIcut() {
        return this.icut;
    }

    public int getIr_mode_end_sec() {
        return this.ir_mode_end_sec;
    }

    public int getIr_mode_start_sec() {
        return this.ir_mode_start_sec;
    }

    public int getIr_mode_timer_en() {
        return this.ir_mode_timer_en;
    }

    public int getLamp() {
        return this.lamp;
    }

    public String getMcuver() {
        return this.mcuver;
    }

    public int getMenual_exposure_again() {
        return this.menual_exposure_again;
    }

    public int getMenual_exposure_dgain() {
        return this.menual_exposure_dgain;
    }

    public int getMenual_exposure_en() {
        return this.menual_exposure_en;
    }

    public int getMenual_exposure_expTime() {
        return this.menual_exposure_expTime;
    }

    public int getMenual_exposure_ispdgain() {
        return this.menual_exposure_ispdgain;
    }

    public int getMic() {
        return this.mic;
    }

    public int getOnline() {
        return this.online;
    }

    public int getOss_push_en() {
        return this.oss_push_en;
    }

    public int getPirstatu() {
        return this.pirstatu;
    }

    public int getPower() {
        return this.power;
    }

    public int getResult() {
        return this.result;
    }

    public int getRotmir() {
        return this.rotmir;
    }

    public int getSignal() {
        return this.signal;
    }

    public int getSpk() {
        return this.spk;
    }

    public String getSysMakeTime() {
        return this.SysMakeTime;
    }

    public String getSysver() {
        return this.sysver;
    }

    public int getWatch() {
        return this.watch;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setAppMakeTime(String str) {
        this.AppMakeTime = str;
    }

    public void setAppver(String str) {
        this.appver = str;
    }

    public void setBatstatus(int i2) {
        this.batstatus = i2;
    }

    public void setBatvalue(int i2) {
        this.batvalue = i2;
    }

    public void setBright(int i2) {
        this.bright = i2;
    }

    public void setCharging(int i2) {
        this.charging = i2;
    }

    public void setClock(int i2) {
        this.clock = i2;
    }

    public void setClockScreen(int i2) {
        this.clockScreen = i2;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setContrast(int i2) {
        this.contrast = i2;
    }

    public void setIcut(int i2) {
        this.icut = i2;
    }

    public void setIr_mode_end_sec(int i2) {
        this.ir_mode_end_sec = i2;
    }

    public void setIr_mode_start_sec(int i2) {
        this.ir_mode_start_sec = i2;
    }

    public void setIr_mode_timer_en(int i2) {
        this.ir_mode_timer_en = i2;
    }

    public void setLamp(int i2) {
        this.lamp = i2;
    }

    public void setMcuver(String str) {
        this.mcuver = str;
    }

    public void setMenual_exposure_again(int i2) {
        this.menual_exposure_again = i2;
    }

    public void setMenual_exposure_dgain(int i2) {
        this.menual_exposure_dgain = i2;
    }

    public void setMenual_exposure_en(int i2) {
        this.menual_exposure_en = i2;
    }

    public void setMenual_exposure_expTime(int i2) {
        this.menual_exposure_expTime = i2;
    }

    public void setMenual_exposure_ispdgain(int i2) {
        this.menual_exposure_ispdgain = i2;
    }

    public void setMic(int i2) {
        this.mic = i2;
    }

    public void setOnline(int i2) {
        this.online = i2;
    }

    public void setOss_push_en(int i2) {
        this.oss_push_en = i2;
    }

    public void setPirstatu(int i2) {
        this.pirstatu = i2;
    }

    public void setPower(int i2) {
        this.power = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setRotmir(int i2) {
        this.rotmir = i2;
    }

    public void setSignal(int i2) {
        this.signal = i2;
    }

    public void setSpk(int i2) {
        this.spk = i2;
    }

    public void setSysMakeTime(String str) {
        this.SysMakeTime = str;
    }

    public void setSysver(String str) {
        this.sysver = str;
    }

    public void setWatch(int i2) {
        this.watch = i2;
    }
}
