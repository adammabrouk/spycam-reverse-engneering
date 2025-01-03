package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VideoRecordModel {
    public int bistream;
    public int cmd;
    public int end_time;
    public int recordAudio;
    public int record_time;
    public int recordcov;
    public int result;
    public int start_time;
    public int timerecord;
    public int videoRecord;

    public static VideoRecordModel jsonToModel(String str) throws JSONException {
        VideoRecordModel videoRecordModel = new VideoRecordModel();
        JSONObject jSONObject = new JSONObject(str);
        videoRecordModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setRecordcov(CommonUtil.jasonPaseInt(jSONObject, "recordcov", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setStart_time(CommonUtil.jasonPaseInt(jSONObject, "start_time", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setEnd_time(CommonUtil.jasonPaseInt(jSONObject, "end_time", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setRecord_time(CommonUtil.jasonPaseInt(jSONObject, "record_time", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setBistream(CommonUtil.jasonPaseInt(jSONObject, "bitStream", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setRecordAudio(CommonUtil.jasonPaseInt(jSONObject, "recordAudio", ContentCommon.SHIXFINAL_ERRORINT));
        if (CommonUtil.jasonPaseInt(jSONObject, "videoRecord", ContentCommon.SHIXFINAL_ERRORINT) != -110) {
            videoRecordModel.setTimerecord(CommonUtil.jasonPaseInt(jSONObject, "videoRecord", ContentCommon.SHIXFINAL_ERRORINT));
            videoRecordModel.setVideoRecord(CommonUtil.jasonPaseInt(jSONObject, "videoRecord", ContentCommon.SHIXFINAL_ERRORINT));
        } else {
            videoRecordModel.setTimerecord(CommonUtil.jasonPaseInt(jSONObject, "timerecord", ContentCommon.SHIXFINAL_ERRORINT));
        }
        return videoRecordModel;
    }

    public static String toJson(VideoRecordModel videoRecordModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_record_param");
        jSONObject.put("cmd", 122);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("recordcov", videoRecordModel.getRecordcov());
        jSONObject.put("start_time", videoRecordModel.getStart_time());
        jSONObject.put("end_time", videoRecordModel.getEnd_time());
        jSONObject.put("record_time", videoRecordModel.getRecord_time());
        jSONObject.put("bitStream", videoRecordModel.getBistream());
        jSONObject.put("recordAudio", videoRecordModel.getRecordAudio());
        jSONObject.put("recordcov", videoRecordModel.getRecordcov());
        if (videoRecordModel.getVideoRecord() != -110) {
            jSONObject.put("videoRecord", videoRecordModel.getTimerecord());
        } else {
            jSONObject.put("timerecord", videoRecordModel.getTimerecord());
        }
        return jSONObject.toString();
    }

    public int getBistream() {
        return this.bistream;
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getEnd_time() {
        return this.end_time;
    }

    public int getRecordAudio() {
        return this.recordAudio;
    }

    public int getRecord_time() {
        return this.record_time;
    }

    public int getRecordcov() {
        return this.recordcov;
    }

    public int getResult() {
        return this.result;
    }

    public int getStart_time() {
        return this.start_time;
    }

    public int getTimerecord() {
        return this.timerecord;
    }

    public int getVideoRecord() {
        return this.videoRecord;
    }

    public void setBistream(int i2) {
        this.bistream = i2;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setEnd_time(int i2) {
        this.end_time = i2;
    }

    public void setRecordAudio(int i2) {
        this.recordAudio = i2;
    }

    public void setRecord_time(int i2) {
        this.record_time = i2;
    }

    public void setRecordcov(int i2) {
        this.recordcov = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setStart_time(int i2) {
        this.start_time = i2;
    }

    public void setTimerecord(int i2) {
        this.timerecord = i2;
    }

    public void setVideoRecord(int i2) {
        this.videoRecord = i2;
    }
}
