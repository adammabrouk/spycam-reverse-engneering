package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class YunTaiModel {
    public int cmd;
    public int privacy_enable;
    public int privacy_end_sec;
    public int privacy_start_sec;
    public int result;
    public int scan_enable;
    public int scan_end_sec;
    public int scan_start_sec;
    public int set_watch_position = 0;
    public int track_enable;
    public int track_sensitivity;
    public int track_smd_enable;
    public int watch_position_enable;

    public static YunTaiModel jsonToModel(String str) throws JSONException {
        YunTaiModel yunTaiModel = new YunTaiModel();
        JSONObject jSONObject = new JSONObject(str);
        yunTaiModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setTrack_smd_enable(CommonUtil.jasonPaseInt(jSONObject, "track_smd_enable", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setPrivacy_enable(CommonUtil.jasonPaseInt(jSONObject, "privacy_enable", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setPrivacy_end_sec(CommonUtil.jasonPaseInt(jSONObject, "privacy_end_sec", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setPrivacy_start_sec(CommonUtil.jasonPaseInt(jSONObject, "privacy_start_sec", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setScan_enable(CommonUtil.jasonPaseInt(jSONObject, "scan_enable", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setScan_end_sec(CommonUtil.jasonPaseInt(jSONObject, "scan_end_sec", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setScan_start_sec(CommonUtil.jasonPaseInt(jSONObject, "scan_start_sec", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setTrack_enable(CommonUtil.jasonPaseInt(jSONObject, "track_enable", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setTrack_sensitivity(CommonUtil.jasonPaseInt(jSONObject, "track_sensitivity", ContentCommon.SHIXFINAL_ERRORINT));
        yunTaiModel.setWatch_position_enable(CommonUtil.jasonPaseInt(jSONObject, "watch_position_enable", ContentCommon.SHIXFINAL_ERRORINT));
        return yunTaiModel;
    }

    public static String toJson(YunTaiModel yunTaiModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_ptz");
        jSONObject.put("cmd", 110);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("track_enable", yunTaiModel.getTrack_enable());
        jSONObject.put("track_smd_enable", yunTaiModel.getTrack_smd_enable());
        jSONObject.put("privacy_enable", yunTaiModel.getPrivacy_enable());
        jSONObject.put("privacy_start_sec", yunTaiModel.getPrivacy_start_sec());
        jSONObject.put("privacy_end_sec", yunTaiModel.getPrivacy_end_sec());
        jSONObject.put("scan_start_sec", yunTaiModel.getScan_start_sec());
        jSONObject.put("scan_enable", yunTaiModel.getScan_enable());
        jSONObject.put("scan_end_sec", yunTaiModel.getScan_end_sec());
        jSONObject.put("track_sensitivity", yunTaiModel.getTrack_sensitivity());
        jSONObject.put("watch_position_enable", yunTaiModel.getWatch_position_enable());
        jSONObject.put("set_watch_position", yunTaiModel.getSet_watch_position());
        MyLogUtils.d("SHIXTRANS", jSONObject.toString());
        return jSONObject.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String toJsonSimple(YunTaiModel yunTaiModel, String str, String str2, String str3, int i2) throws JSONException {
        char c2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_ptz");
        jSONObject.put("cmd", 110);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        switch (str3.hashCode()) {
            case -1920065514:
                if (str3.equals("set_watch_position")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -1773403395:
                if (str3.equals("privacy_start_sec")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1069729870:
                if (str3.equals("scan_start_sec")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -985451031:
                if (str3.equals("watch_position_enable")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 610694682:
                if (str3.equals("privacy_enable")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1237120396:
                if (str3.equals("track_smd_enable")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1754353974:
                if (str3.equals("privacy_end_sec")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1875130103:
                if (str3.equals("track_enable")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 2067935019:
                if (str3.equals("scan_end_sec")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 2144830853:
                if (str3.equals("scan_enable")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                yunTaiModel.setTrack_enable(i2);
                break;
            case 1:
                yunTaiModel.setTrack_smd_enable(i2);
                break;
            case 2:
                yunTaiModel.setPrivacy_enable(i2);
                break;
            case 3:
                yunTaiModel.setPrivacy_start_sec(i2);
                break;
            case 4:
                yunTaiModel.setPrivacy_end_sec(i2);
                break;
            case 5:
                yunTaiModel.setScan_start_sec(i2);
                break;
            case 6:
                yunTaiModel.setScan_enable(i2);
                break;
            case 7:
                yunTaiModel.setScan_end_sec(i2);
                break;
            case '\b':
                yunTaiModel.setWatch_position_enable(i2);
                break;
            case '\t':
                yunTaiModel.setSet_watch_position(i2);
                break;
        }
        jSONObject.put(str3, i2);
        MyLogUtils.d("SHIXTRANS", jSONObject.toString());
        return jSONObject.toString();
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getPrivacy_enable() {
        return this.privacy_enable;
    }

    public int getPrivacy_end_sec() {
        return this.privacy_end_sec;
    }

    public int getPrivacy_start_sec() {
        return this.privacy_start_sec;
    }

    public int getResult() {
        return this.result;
    }

    public int getScan_enable() {
        return this.scan_enable;
    }

    public int getScan_end_sec() {
        return this.scan_end_sec;
    }

    public int getScan_start_sec() {
        return this.scan_start_sec;
    }

    public int getSet_watch_position() {
        return this.set_watch_position;
    }

    public int getTrack_enable() {
        return this.track_enable;
    }

    public int getTrack_sensitivity() {
        return this.track_sensitivity;
    }

    public int getTrack_smd_enable() {
        return this.track_smd_enable;
    }

    public int getWatch_position_enable() {
        return this.watch_position_enable;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setPrivacy_enable(int i2) {
        this.privacy_enable = i2;
    }

    public void setPrivacy_end_sec(int i2) {
        this.privacy_end_sec = i2;
    }

    public void setPrivacy_start_sec(int i2) {
        this.privacy_start_sec = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setScan_enable(int i2) {
        this.scan_enable = i2;
    }

    public void setScan_end_sec(int i2) {
        this.scan_end_sec = i2;
    }

    public void setScan_start_sec(int i2) {
        this.scan_start_sec = i2;
    }

    public void setSet_watch_position(int i2) {
        this.set_watch_position = i2;
    }

    public void setTrack_enable(int i2) {
        this.track_enable = i2;
    }

    public void setTrack_sensitivity(int i2) {
        this.track_sensitivity = i2;
    }

    public void setTrack_smd_enable(int i2) {
        this.track_smd_enable = i2;
    }

    public void setWatch_position_enable(int i2) {
        this.watch_position_enable = i2;
    }
}
