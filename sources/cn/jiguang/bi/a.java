package cn.jiguang.bi;

import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f8798d;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, g> f8795a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, JAction> f8796b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, JActionExtra> f8797c = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public static final Object f8799e = new Object();

    public static a a() {
        if (f8798d == null) {
            synchronized (f8799e) {
                if (f8798d == null) {
                    f8798d = new a();
                }
            }
        }
        return f8798d;
    }

    public JAction a(String str) {
        if (f8796b.containsKey(str)) {
            return f8796b.get(str);
        }
        return null;
    }

    public void a(String str, String str2) {
        d.a("DispacthManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f8795a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f8795a.put(str, gVar);
        }
        if (f8796b.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JAction) {
                f8796b.put(str, (JAction) newInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public JActionExtra b(String str) {
        if (f8797c.containsKey(str)) {
            return f8797c.get(str);
        }
        return null;
    }

    public void b(String str, String str2) {
        d.a("DispacthManager", "addActionExtra type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f8795a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f8795a.put(str, gVar);
        }
        if (f8797c.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JActionExtra) {
                f8797c.put(str, (JActionExtra) newInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }
}
