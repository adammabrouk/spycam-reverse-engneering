package cn.jpush.android.bc;

import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f9501a = 450;

    /* renamed from: b, reason: collision with root package name */
    public static String f9502b = "4.5.0";

    /* renamed from: c, reason: collision with root package name */
    public static final int f9503c = JConstants.SDK_VERSION_INT;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9504d = false;

    public static boolean a() {
        try {
            return JPushConstants.THIRD_ENABLE;
        } catch (Throwable unused) {
            return true;
        }
    }
}
