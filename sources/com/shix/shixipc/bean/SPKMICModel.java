package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SPKMICModel {
    public int batstatus;
    public int batvalue;
    public int cmd;
    public int mic;
    public int result;
    public int spk;

    public static SPKMICModel jsonToModel(String str) throws JSONException {
        SPKMICModel sPKMICModel = new SPKMICModel();
        JSONObject jSONObject = new JSONObject(str);
        sPKMICModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setSpk(CommonUtil.jasonPaseInt(jSONObject, "outputvol", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setMic(CommonUtil.jasonPaseInt(jSONObject, "inputvol", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setBatvalue(CommonUtil.jasonPaseInt(jSONObject, "batvalue", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setBatstatus(CommonUtil.jasonPaseInt(jSONObject, "batstatus", ContentCommon.SHIXFINAL_ERRORINT));
        return sPKMICModel;
    }

    public int getBatstatus() {
        return this.batstatus;
    }

    public int getBatvalue() {
        return this.batvalue;
    }

    public int getCmd() {
        return this.cmd;
    }

    public int getMic() {
        return this.mic;
    }

    public int getResult() {
        return this.result;
    }

    public int getSpk() {
        return this.spk;
    }

    public void setBatstatus(int i2) {
        this.batstatus = i2;
    }

    public void setBatvalue(int i2) {
        this.batvalue = i2;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setMic(int i2) {
        this.mic = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setSpk(int i2) {
        this.spk = i2;
    }
}
