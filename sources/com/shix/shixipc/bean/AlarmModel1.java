package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AlarmModel1 {
    public int audio_out;
    public int cmd;
    public int enable;
    public int level;
    public int msg_push;
    public int record;
    public int result;
    public int start_hour;
    public int start_min;
    public int stop_hour;
    public int stop_min;

    public static AlarmModel1 jsonToModel(String str) throws JSONException {
        AlarmModel1 alarmModel1 = new AlarmModel1();
        JSONObject jSONObject = new JSONObject(str);
        alarmModel1.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setEnable(CommonUtil.jasonPaseInt(jSONObject, "enable", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setLevel(CommonUtil.jasonPaseInt(jSONObject, "level", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setAudio_out(CommonUtil.jasonPaseInt(jSONObject, "audio_out", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setRecord(CommonUtil.jasonPaseInt(jSONObject, "record", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setMsg_push(CommonUtil.jasonPaseInt(jSONObject, "msg_push", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setStart_min(CommonUtil.jasonPaseInt(jSONObject, "start_min", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setStop_min(CommonUtil.jasonPaseInt(jSONObject, "stop_min", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setStart_hour(CommonUtil.jasonPaseInt(jSONObject, "start_hour", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel1.setStop_hour(CommonUtil.jasonPaseInt(jSONObject, "stop_hour", ContentCommon.SHIXFINAL_ERRORINT));
        return alarmModel1;
    }

    public static String toJson(AlarmModel1 alarmModel1, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_alarm");
        jSONObject.put("cmd", 108);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("enable", alarmModel1.getEnable());
        jSONObject.put("level", alarmModel1.getLevel());
        jSONObject.put("audio_out", alarmModel1.getAudio_out());
        jSONObject.put("record", alarmModel1.getRecord());
        jSONObject.put("msg_push", alarmModel1.getMsg_push());
        jSONObject.put("start_min", alarmModel1.getStart_min());
        jSONObject.put("stop_min", alarmModel1.getStop_min());
        jSONObject.put("start_hour", alarmModel1.getStart_hour());
        jSONObject.put("stop_hour", alarmModel1.getStop_hour());
        return jSONObject.toString();
    }

    public int getAudio_out() {
        return this.audio_out;
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getEnable() {
        return this.enable;
    }

    public int getLevel() {
        return this.level;
    }

    public int getMsg_push() {
        return this.msg_push;
    }

    public int getRecord() {
        return this.record;
    }

    public int getResult() {
        return this.result;
    }

    public int getStart_hour() {
        return this.start_hour;
    }

    public int getStart_min() {
        return this.start_min;
    }

    public int getStop_hour() {
        return this.stop_hour;
    }

    public int getStop_min() {
        return this.stop_min;
    }

    public void setAudio_out(int i2) {
        this.audio_out = i2;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setEnable(int i2) {
        this.enable = i2;
    }

    public void setLevel(int i2) {
        this.level = i2;
    }

    public void setMsg_push(int i2) {
        this.msg_push = i2;
    }

    public void setRecord(int i2) {
        this.record = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setStart_hour(int i2) {
        this.start_hour = i2;
    }

    public void setStart_min(int i2) {
        this.start_min = i2;
    }

    public void setStop_hour(int i2) {
        this.stop_hour = i2;
    }

    public void setStop_min(int i2) {
        this.stop_min = i2;
    }
}
