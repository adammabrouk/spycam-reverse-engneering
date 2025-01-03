package cn.jiguang.union.ads.api;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.union.ads.core.config.JUnionAdConfig;
import cn.jiguang.union.ads.nativ.api.JNativeAdApi;
import cn.jpush.android.u.a;

/* loaded from: classes.dex */
public class JUnionAdApi {
    public static JNativeAdApi buildNativeAdApi(Context context) {
        checkContext(context);
        return JNativeAdApi.getInstance();
    }

    public static void checkContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        a.a(context.getApplicationContext());
    }

    @Deprecated
    public static void config(Context context, Bundle bundle) {
        a.a(bundle);
    }

    public static void config(Context context, JUnionAdConfig jUnionAdConfig) {
        checkContext(context);
        if (jUnionAdConfig == null) {
            throw new IllegalArgumentException("NULL config");
        }
        a.a(jUnionAdConfig);
    }
}
