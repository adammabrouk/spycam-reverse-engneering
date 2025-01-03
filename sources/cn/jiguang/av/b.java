package cn.jiguang.av;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.as.d;
import cn.jiguang.az.h;
import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8399a = false;

    /* renamed from: b, reason: collision with root package name */
    public static int f8400b;

    public static void a(Context context) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 38, null, null, new Object[0]);
    }

    public static void a(Context context, int i2) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 51, "", null, Integer.valueOf(i2));
    }

    public static void a(Context context, long j) {
        if (j > 0) {
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 37, null, null, Long.valueOf(j));
        }
    }

    public static void a(Context context, long j, String str, String str2) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 35, null, null, Long.valueOf(j), str, str2);
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle != null) {
            f8399a = bundle.getBoolean("foreground");
            int i2 = bundle.getInt("user_type");
            f8400b = i2;
            if (i2 == -1) {
                f8400b = f8399a ? 1 : 0;
            }
            d.c("JCoreManagerInternal", "changeForeGroundStat:" + f8399a + ", userActiveType:" + f8400b);
            if (!f8399a || h.a().f() < 120) {
                return;
            }
            h.a().i();
        }
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 39, null, null, obj);
    }

    public static void a(Context context, String str) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 36, null, null, str);
    }

    public static void a(Context context, String str, int i2, int i3, long j, long j2, byte[] bArr) {
        a(context, str, i2, i3, j, j2, bArr, true);
    }

    public static void a(Context context, String str, int i2, int i3, long j, long j2, byte[] bArr, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i2);
        bundle.putInt("ver", i3);
        bundle.putLong("rid", j);
        bundle.putLong("timeout", j2);
        bundle.putByteArray("body", bArr);
        JCoreManager.onEvent(context, str, z ? 17 : 16, null, bundle, new Object[0]);
    }

    public static void a(Runnable runnable, int i2, int... iArr) {
        JCoreManager.onEvent(null, null, 83, null, null, runnable, Integer.valueOf(i2));
    }

    public static void a(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 78, null, null, runnable);
    }

    public static void a(String str) {
        JCoreManager.onEvent(null, null, 13, str, null, new Object[0]);
    }

    public static void b(Context context) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 48, null, null, new Object[0]);
    }

    public static void b(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 75, null, null, runnable);
    }

    public static void c(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 77, null, null, runnable);
    }

    public static void d(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 76, null, null, runnable);
    }
}
