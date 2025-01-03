package cn.jiguang.az;

import android.content.Context;

/* loaded from: classes.dex */
public class e {
    public static Object a(Context context, String str, Object obj) {
        try {
            return cn.jiguang.h.b.a(context, str, obj);
        } catch (Throwable th) {
            cn.jiguang.as.d.h("JCommonPresenter", "jcommon call failed:" + th.getMessage());
            return null;
        }
    }
}
