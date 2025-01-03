package cn.jiguang.az;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JPushInterface;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f8553b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f8554c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, JDispatchAction> f8552a = new ConcurrentHashMap<>();

    public b() {
        Object a2 = cn.jiguang.d.a.a();
        if (a2 instanceof HashMap) {
            StringBuilder sb = new StringBuilder();
            sb.append("actiom map size:");
            HashMap<String, String> hashMap = (HashMap) a2;
            sb.append(hashMap.size());
            cn.jiguang.as.d.c("DispatchActionManager", sb.toString());
            a(hashMap);
            a(JConstants.SDK_TYPE, cn.jiguang.c.a.class.getCanonicalName());
        }
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        return (Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8) + Integer.parseInt(split[2]);
    }

    public static b a() {
        if (f8553b == null) {
            synchronized (f8554c) {
                if (f8553b == null) {
                    f8553b = new b();
                }
            }
        }
        return f8553b;
    }

    private void b(Context context, int i2, int i3, String str) {
        Intent intent = null;
        try {
            if (i2 == 0 && i3 == 0) {
                intent = new Intent(JPushInterface.ACTION_REGISTRATION_ID);
                intent.putExtra(JPushInterface.EXTRA_REGISTRATION_ID, str);
            } else if (i2 == -1 || i2 == 1) {
                intent = new Intent(JPushInterface.ACTION_CONNECTION_CHANGE);
                if (i2 == -1) {
                    intent.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                } else {
                    intent.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, true);
                }
            }
            if (intent != null) {
                String packageName = context.getPackageName();
                intent.addCategory(packageName);
                intent.setPackage(packageName);
                cn.jiguang.e.a.a(context, intent);
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("DispatchActionManager", "sendToOldPushUser failed:" + th.getMessage());
        }
    }

    public byte a(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 24, "platformtype");
                if (beforLogin instanceof Byte) {
                    return ((Byte) beforLogin).byteValue();
                }
            }
        }
        return (byte) 0;
    }

    public Object a(Context context, String str, int i2) {
        String str2;
        if (JConstants.SDK_VERSION_INT <= 284) {
            return null;
        }
        JDispatchAction jDispatchAction = f8552a.get(str);
        if (jDispatchAction != null) {
            Object dataByCmd = jDispatchAction.getDataByCmd(context, i2);
            if (dataByCmd != null) {
                return dataByCmd;
            }
            str2 = str + " sdk action data:" + dataByCmd + ", actionType: " + i2;
        } else {
            str2 = str + " sdk action is null";
        }
        cn.jiguang.as.d.a("DispatchActionManager", str2);
        return null;
    }

    public void a(Context context, int i2, int i3, String str) {
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                value.onEvent(context, entry.getKey(), i2, i3, str);
            }
        }
        b(context, i2, i3, str);
    }

    public void a(Context context, cn.jiguang.bb.c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            cn.jiguang.as.d.g("DispatchActionManager", "Action - dispatchMessage unexcepted - head was null");
            return;
        }
        d a2 = j.a().a(cVar.f8639e);
        if (a2 == null) {
            for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && value.isSupportedCMD(entry.getKey(), cVar.f8637c)) {
                    value.dispatchMessage(context, entry.getKey(), cVar.f8637c, cVar.f8636b, cVar.f8639e, -1L, byteBuffer);
                }
            }
            return;
        }
        cn.jiguang.as.d.c("DispatchActionManager", "dispacth msg with reuqest :" + a2);
        JDispatchAction jDispatchAction = f8552a.get(a2.f8557c);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchMessage(context, a2.f8557c, cVar.f8637c, cVar.f8636b, cVar.f8639e, a2.f8556b, byteBuffer);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("rid", cVar.f8639e);
        h.a().a(context, "tcp_a7", bundle);
    }

    public void a(Context context, String str, long j, int i2) {
        if (!TextUtils.isEmpty(str) && str.equals(JConstants.SDK_TYPE)) {
            if (i2 != 26) {
                return;
            }
            k.a().b(context, j);
            return;
        }
        JDispatchAction jDispatchAction = f8552a.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchTimeOutMessage(context, str, j, i2);
            return;
        }
        cn.jiguang.as.d.g("DispatchActionManager", "not found dispatch action by sdktype:" + str);
    }

    public void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            cn.jiguang.as.d.h("DispatchActionManager", "run action bundle is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.as.d.h("DispatchActionManager", "run action sdktype is empty");
            return;
        }
        if (JConstants.SDK_TYPE.contains(str)) {
            str = JConstants.SDK_TYPE;
        }
        JDispatchAction jDispatchAction = f8552a.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.onActionRun(context, str, bundle.getString("internal_action"), bundle);
            return;
        }
        cn.jiguang.as.d.h("DispatchActionManager", "dispacth action is null by sdktype:" + str);
    }

    public void a(String str, String str2) {
        cn.jiguang.as.d.c("DispatchActionManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (f8552a.containsKey(str)) {
            cn.jiguang.as.d.c("DispatchActionManager", "has same type action");
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JDispatchAction) {
                f8552a.put(str, (JDispatchAction) newInstance);
                cn.jiguang.as.d.c("DispatchActionManager", "action init:" + newInstance.getClass().getName());
            } else {
                cn.jiguang.as.d.g("DispatchActionManager", "this action is not a JDispatchAction,please check and extends JDispatchAction");
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.h("DispatchActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public void a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            cn.jiguang.as.d.g("DispatchActionManager", "init map is empty");
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public boolean a(int i2) {
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                try {
                    cn.jiguang.as.d.d("DispatchActionManager", "isAllowAction actionType:" + i2 + ",sdktype:" + entry.getKey() + ",action:" + value.checkAction(entry.getKey(), i2));
                    if (!value.checkAction(entry.getKey(), i2)) {
                        return false;
                    }
                } catch (Throwable th) {
                    cn.jiguang.as.d.g("DispatchActionManager", "isAllowAction error:" + th.getMessage());
                }
            }
        }
        return true;
    }

    public String b(int i2) {
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && value.getRegPriority(entry.getKey()) == i2) {
                return value.getSdkVersion(entry.getKey());
            }
        }
        return "";
    }

    public String b(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 24, "platformregid");
                if (beforLogin instanceof String) {
                    return (String) beforLogin;
                }
            }
        }
        return "";
    }

    public String b(String str, String str2) {
        String str3;
        JDispatchAction jDispatchAction = f8552a.get(str);
        if (jDispatchAction != null) {
            String sdkVersion = jDispatchAction.getSdkVersion(str);
            if (!TextUtils.isEmpty(sdkVersion)) {
                return sdkVersion;
            }
            str3 = str + " sdk action sdkversion:" + sdkVersion;
        } else {
            str3 = str + " sdk action is null";
        }
        cn.jiguang.as.d.a("DispatchActionManager", str3);
        return str2;
    }

    public short b() {
        short regFlag;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (regFlag = value.getRegFlag(entry.getKey())) != 0) {
                s = (short) (s | regFlag);
            }
        }
        return s;
    }

    public short c() {
        short loginFlag;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (loginFlag = value.getLoginFlag(entry.getKey())) != 0) {
                s = (short) (s | loginFlag);
            }
        }
        return s;
    }

    public Map<Integer, Bundle> d() {
        int i2;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            Bundle pInfo = entry.getValue().getPInfo(entry.getKey());
            if (pInfo != null && (i2 = pInfo.getInt("pid", 0)) > 0) {
                hashMap.put(Integer.valueOf(i2), pInfo);
            }
        }
        return hashMap;
    }

    public String e() {
        StringBuilder sb;
        short s = 3;
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            short regPriority = entry.getValue().getRegPriority(entry.getKey());
            if (s < regPriority) {
                s = regPriority;
            }
        }
        cn.jiguang.as.d.c("DispatchActionManager", "max reg priority:" + ((int) s));
        String str = "";
        for (int i2 = 0; i2 <= s; i2++) {
            if (i2 == 3) {
                sb = new StringBuilder();
                sb.append(str);
                str = cn.jiguang.a.a.f8098b;
            } else {
                Iterator<Map.Entry<String, JDispatchAction>> it = f8552a.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, JDispatchAction> next = it.next();
                    JDispatchAction value = next.getValue();
                    if (value.getRegPriority(next.getKey()) == i2) {
                        str = str + value.getSdkVersion(next.getKey());
                        break;
                    }
                }
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append("|");
            str = sb.toString();
        }
        return str.substring(0, str.length() - 1);
    }

    public String f() {
        String str = a(cn.jiguang.a.a.f8098b) + "|";
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : f8552a.entrySet()) {
            short logPriority = entry.getValue().getLogPriority(entry.getKey());
            if (s < logPriority) {
                s = logPriority;
            }
        }
        cn.jiguang.as.d.c("DispatchActionManager", "max login priority:" + ((int) s));
        for (int i2 = 1; i2 <= s; i2++) {
            Iterator<Map.Entry<String, JDispatchAction>> it = f8552a.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, JDispatchAction> next = it.next();
                    JDispatchAction value = next.getValue();
                    if (value.getLogPriority(next.getKey()) == i2) {
                        str = str + a(value.getSdkVersion(next.getKey()));
                        break;
                    }
                }
            }
            str = str + "|";
        }
        return str.substring(0, str.length() - 1);
    }
}
