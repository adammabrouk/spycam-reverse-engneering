package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.a.a;
import cn.jiguang.ao.c;
import cn.jiguang.ao.g;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.as.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ActionManager {
    public static final String SDK_TYPE = "sdk_type";
    public static final String SDK_VERSION = "version";
    public static final String TAG = "ActionManager";
    public static volatile ActionManager detachDataManager;
    public static final Object lock = new Object();
    public static HashMap<String, JDispatchAction> actionMap = new HashMap<>();
    public static HashMap<String, String> actionStringMap = new HashMap<>();

    public ActionManager() {
        c.a();
    }

    public static void addAction(String str, String str2) {
        Log.d(TAG, "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (actionMap.containsKey(str)) {
            d.c(TAG, "has same type action");
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JDispatchAction) {
                actionStringMap.put(str, str2);
                actionMap.put(str, (JDispatchAction) newInstance);
            } else {
                d.g(TAG, "this action is not a JDispatchAction,please check and extends JDispatchAction");
            }
        } catch (Throwable th) {
            d.h(TAG, "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public static HashMap<String, String> getActionMap() {
        return actionStringMap;
    }

    public static ActionManager getInstance() {
        if (detachDataManager == null) {
            synchronized (lock) {
                if (detachDataManager == null) {
                    detachDataManager = new ActionManager();
                }
            }
        }
        return detachDataManager;
    }

    public void handleMessage(Context context, String str, Object obj) {
        d.a(TAG, "onSended type:" + str + ",actionMap size:" + actionMap.size());
        if (TextUtils.isEmpty(str)) {
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                entry.getValue().handleMessage(context, entry.getKey(), obj);
            }
            return;
        }
        JDispatchAction jDispatchAction = actionMap.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.handleMessage(context, str, obj);
        }
    }

    public Map<Integer, Bundle> loadPInfo() {
        int i2;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
            Bundle pInfo = entry.getValue().getPInfo(entry.getKey());
            if (pInfo != null && (i2 = pInfo.getInt("pid", 0)) > 0) {
                hashMap.put(Integer.valueOf(i2), pInfo);
            }
        }
        return hashMap;
    }

    public boolean wrapSdkTypeVersionInfo(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject == null) {
            d.g(TAG, "wrapSdkTypeVersionInfo failed ,container is null");
            return false;
        }
        try {
            if (g.a(g.b())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(SDK_VERSION, a.f8098b);
                jSONObject2.put(SDK_TYPE, g.b());
                try {
                    jSONObject.put("core_sdk_ver", jSONObject2);
                    z = true;
                } catch (JSONException unused) {
                    return true;
                }
            }
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (g.a(value.getSdkType())) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(SDK_VERSION, value.getSdkVersion(entry.getKey()));
                    jSONObject3.put(SDK_TYPE, value.getSdkType());
                    jSONObject.put(value.getReportVersionKey(entry.getKey()), jSONObject3);
                    z = true;
                }
            }
            return z;
        } catch (JSONException unused2) {
            return z;
        }
    }

    public boolean wrapSdkVersionInfo(JSONObject jSONObject) {
        Object dataByCmd;
        if (jSONObject == null) {
            d.g(TAG, "wrapSdkVersionInfo failed ,container is null");
            return false;
        }
        try {
            jSONObject.put("core_sdk_ver", a.f8098b);
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                jSONObject.put(value.getReportVersionKey(entry.getKey()), value.getSdkVersion(entry.getKey()));
                Object dataByCmd2 = value.getDataByCmd(null, 30001);
                if (dataByCmd2 != null && (dataByCmd2 instanceof String) && (dataByCmd = value.getDataByCmd(null, 30002)) != null && (dataByCmd instanceof String)) {
                    jSONObject.put((String) dataByCmd2, (String) dataByCmd);
                }
            }
            return true;
        } catch (JSONException unused) {
            return true;
        }
    }
}
