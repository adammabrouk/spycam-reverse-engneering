package com.shix.shixipc.bean;

import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CameraListBean implements Serializable {
    public static final long serialVersionUID = -1893938966606638094L;
    public int devCont;
    public List<String> devS = new ArrayList();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static CameraListBean jsonToModel(String str) throws JSONException {
        CameraListBean cameraListBean = new CameraListBean();
        JSONObject jSONObject = new JSONObject(str);
        int i2 = jSONObject.getInt("devCont");
        cameraListBean.setDevCont(i2);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(CommonUtil.jasonPaseString(jSONObject, "key[" + i3 + "]"));
        }
        cameraListBean.setDevS(arrayList);
        return cameraListBean;
    }

    public static String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("devCont", SystemValue.arrayList.size());
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            jSONObject.put("key[" + i2 + "]", SystemValue.arrayList.get(i2).getDev_Did());
        }
        return jSONObject.toString();
    }

    public int getDevCont() {
        return this.devCont;
    }

    public List<String> getDevS() {
        return this.devS;
    }

    public void setDevCont(int i2) {
        this.devCont = i2;
    }

    public void setDevS(List<String> list) {
        this.devS = list;
    }
}
