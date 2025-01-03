package cn.jiguang.api.utils;

import android.content.Context;
import cn.jiguang.api.JCoreManager;

/* loaded from: classes.dex */
public class JCollectionAuth {
    public static void setAuth(Context context, boolean z) {
        JCoreManager.onEvent(context, null, 96, null, null, Boolean.valueOf(z));
    }
}
