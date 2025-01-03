package cn.jiguang.az;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.JConstants;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static volatile k f8610a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8611b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public Map<Long, String> f8612c = new HashMap();

    public static k a() {
        if (f8610a == null) {
            synchronized (f8611b) {
                if (f8610a == null) {
                    f8610a = new k();
                }
            }
        }
        return f8610a;
    }

    private String a(Context context, String str, String str2) {
        String str3 = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.a(str));
        if (!TextUtils.isEmpty(str2) && !str2.equals(str3)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("need not ");
        sb.append(str);
        sb.append(" userctrl,newest version:");
        if (TextUtils.isEmpty(str2)) {
            str2 = LogUtils.NULL;
        }
        sb.append(str2);
        cn.jiguang.as.d.a("UserCtrlHelper", sb.toString());
        return "";
    }

    private void a(Context context, short s, String str, String str2) {
        cn.jiguang.as.d.c("UserCtrlHelper", "sendUserCtrlInfo sdkType:" + str2 + ",property:" + ((int) s) + ",verInfo:" + str);
        long b2 = j.b();
        cn.jiguang.av.b.a(context, JConstants.SDK_TYPE, 26, 0, b2, 10000L, cn.jiguang.bb.b.a(s, (short) 1, str));
        this.f8612c.put(Long.valueOf(b2), str2);
    }

    public void a(Context context) {
        if (context == null) {
            cn.jiguang.as.d.g("UserCtrlHelper", "handleUserCtrl failed,context is null");
            return;
        }
        ConcurrentHashMap<String, JDispatchAction> concurrentHashMap = b.f8552a;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, JDispatchAction> entry : concurrentHashMap.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                String a2 = a(context, entry.getKey(), value.getSdkVersion(entry.getKey()));
                if (!TextUtils.isEmpty(a2)) {
                    a(context, value.getUserCtrlProperty(entry.getKey()), a2, entry.getKey());
                }
            }
        }
    }

    public void a(Context context, long j) {
        String str;
        Map<Long, String> map;
        String remove = this.f8612c.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(remove)) {
            str = "userCtrlSuccess but not found rid:" + j;
        } else {
            cn.jiguang.as.d.c("UserCtrlHelper", "userCtrlSuccess rid:" + j + ",sdkType:" + remove);
            String b2 = b.a().b(remove, "");
            if (!TextUtils.isEmpty(b2)) {
                cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.a(remove).a((cn.jiguang.f.a<String>) b2)});
                map = this.f8612c;
                if (map == null && map.isEmpty() && !cn.jiguang.ao.c.a().a(context)) {
                    h.a().a(context, "tcp_a21", null);
                    return;
                }
                return;
            }
            str = "userCtrlSuccess but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.as.d.c("UserCtrlHelper", str);
        map = this.f8612c;
        if (map == null) {
        }
    }

    public void a(Context context, long j, int i2) {
        String str;
        String remove = this.f8612c.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(remove)) {
            str = "onUserCtrlFailed but not found rid:" + j;
        } else {
            cn.jiguang.as.d.c("UserCtrlHelper", "onUserCtrlFailed rid:" + j + ",sdkType:" + remove + ",errorCode:" + i2);
            if (!TextUtils.isEmpty(b.a().b(remove, ""))) {
                return;
            }
            str = "onUserCtrlFailed but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.as.d.c("UserCtrlHelper", str);
    }

    public void b(Context context, long j) {
        cn.jiguang.as.d.c("UserCtrlHelper", "onUserCtrlTimeout rid:" + j);
        this.f8612c.remove(Long.valueOf(j));
    }

    public boolean b(Context context) {
        if (context == null) {
            cn.jiguang.as.d.h("UserCtrlHelper", "get isNeedUserCtrl failed,context is null");
            return false;
        }
        ConcurrentHashMap<String, JDispatchAction> concurrentHashMap = b.f8552a;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            for (Map.Entry<String, JDispatchAction> entry : concurrentHashMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(a(context, entry.getKey(), value.getSdkVersion(entry.getKey())))) {
                    return true;
                }
            }
        }
        return false;
    }
}
