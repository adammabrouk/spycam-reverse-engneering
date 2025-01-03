package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AlarmModel {
    public int cmd;
    public int motion_smd_enable;
    public int pirPush;
    public int pirdelaytime;
    public int pirenable;
    public int pirsensitive;
    public int pirvideo;
    public int pirvideotime;
    public int result;

    public static AlarmModel jsonToModel(String str) throws JSONException {
        AlarmModel alarmModel = new AlarmModel();
        JSONObject jSONObject = new JSONObject(str);
        alarmModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirenable(CommonUtil.jasonPaseInt(jSONObject, "pirenable", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirvideo(CommonUtil.jasonPaseInt(jSONObject, "pirvideo", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirvideotime(CommonUtil.jasonPaseInt(jSONObject, "pirvideotime", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirsensitive(CommonUtil.jasonPaseInt(jSONObject, "pirsensitive", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirdelaytime(CommonUtil.jasonPaseInt(jSONObject, "pirDelayTime", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirPush(CommonUtil.jasonPaseInt(jSONObject, "pirPush", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setMotion_smd_enable(CommonUtil.jasonPaseInt(jSONObject, "motion_smd_enable", ContentCommon.SHIXFINAL_ERRORINT));
        if (alarmModel.getPirsensitive() == -110) {
            if (alarmModel.getPirenable() > 0) {
                alarmModel.setPirsensitive(alarmModel.getPirenable());
            } else {
                alarmModel.setPirsensitive(2);
            }
        }
        return alarmModel;
    }

    public static String toJson(AlarmModel alarmModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_alarm");
        jSONObject.put("cmd", 108);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        if (alarmModel != null) {
            jSONObject.put("pirenable", alarmModel.getPirenable());
            jSONObject.put("pirsensitive", alarmModel.getPirsensitive());
            jSONObject.put("pirvideo", alarmModel.getPirvideo());
            jSONObject.put("pirvideotime", alarmModel.getPirvideotime());
            jSONObject.put("pirDelayTime", alarmModel.getPirdelaytime());
            jSONObject.put("pirPush", alarmModel.getPirPush());
            jSONObject.put("motion_smd_enable", alarmModel.getMotion_smd_enable());
        }
        return jSONObject.toString();
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getMotion_smd_enable() {
        return this.motion_smd_enable;
    }

    public int getPirPush() {
        return this.pirPush;
    }

    public int getPirdelaytime() {
        return this.pirdelaytime;
    }

    public int getPirenable() {
        return this.pirenable;
    }

    public int getPirsensitive() {
        return this.pirsensitive;
    }

    public int getPirvideo() {
        return this.pirvideo;
    }

    public int getPirvideotime() {
        return this.pirvideotime;
    }

    public int getResult() {
        return this.result;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setMotion_smd_enable(int i2) {
        this.motion_smd_enable = i2;
    }

    public void setPirPush(int i2) {
        this.pirPush = i2;
    }

    public void setPirdelaytime(int i2) {
        this.pirdelaytime = i2;
    }

    public void setPirenable(int i2) {
        this.pirenable = i2;
    }

    public void setPirsensitive(int i2) {
        this.pirsensitive = i2;
    }

    public void setPirvideo(int i2) {
        this.pirvideo = i2;
    }

    public void setPirvideotime(int i2) {
        this.pirvideotime = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }
}
