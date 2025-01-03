package cn.jpush.android.az;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import com.shix.shixipc.system.Rom;
import com.shix.shixipc.utilcode.RomUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static List<String> f9462a;

    /* renamed from: b, reason: collision with root package name */
    public static List<String> f9463b;

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, Integer> f9464c;

    /* renamed from: d, reason: collision with root package name */
    public static Map<String, Map<String, Integer[]>> f9465d;

    /* renamed from: e, reason: collision with root package name */
    public static Map<String, Integer> f9466e;

    /* renamed from: f, reason: collision with root package name */
    public static List<String> f9467f;

    /* renamed from: g, reason: collision with root package name */
    public static long f9468g;

    /* renamed from: h, reason: collision with root package name */
    public static int f9469h;

    /* renamed from: i, reason: collision with root package name */
    public static String f9470i;
    public static String j;
    public static String k;

    static {
        HashMap hashMap = new HashMap();
        f9464c = hashMap;
        hashMap.put("xiaomi", 1);
        f9464c.put("lge", 1);
        ArrayList arrayList = new ArrayList();
        f9462a = arrayList;
        arrayList.add("Smartisan");
        f9462a.add("Lenovo");
        ArrayList arrayList2 = new ArrayList();
        f9463b = arrayList2;
        arrayList2.add("MI 5C");
        ArrayList arrayList3 = new ArrayList();
        f9467f = arrayList3;
        arrayList3.add("nubia");
        HashMap hashMap2 = new HashMap();
        f9466e = hashMap2;
        hashMap2.put("galaxy nexus", 1);
        a();
        f9470i = "";
        j = "";
        k = "";
    }

    public static int a(Context context) {
        if (context == null || context.getResources().getIdentifier("push_notification_banner_layout", "id", context.getPackageName()) <= 0) {
            return 0;
        }
        for (int i2 = 1; i2 < 100; i2++) {
            if (context.getResources().getIdentifier("layout_version_" + i2, "id", context.getPackageName()) > 0) {
                return i2;
            }
        }
        return 0;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, String str, int i2) {
        String a2;
        if (context == null) {
            return 0;
        }
        try {
            a2 = cn.jpush.android.ar.d.a(context);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("SSPHelper", "[checkInAppAndSSPContent] error: " + th.getMessage());
        }
        if (TextUtils.isEmpty(a2)) {
            cn.jpush.android.r.b.b("SSPHelper", "[checkInAppAndSSPContent] getLatestInAppInfo, info: " + a2);
            return 0;
        }
        String[] split = a2.split(",");
        String valueOf = String.valueOf(split[0]);
        long parseLong = Long.parseLong(split[1]);
        long currentTimeMillis = System.currentTimeMillis();
        cn.jpush.android.r.b.b("SSPHelper", "in-app md5-content: " + valueOf + "; md5-sspContent: " + str + ", currentTime: " + currentTimeMillis + ", inAppTime: " + parseLong);
        if (!TextUtils.isEmpty(valueOf) && cn.jpush.android.bm.b.a(currentTimeMillis, parseLong)) {
            cn.jpush.android.r.b.b("SSPHelper", "latest ssp and in-app show in same day");
            if (currentTimeMillis - parseLong <= i2) {
                if (valueOf.equals(str)) {
                    cn.jpush.android.r.b.f("SSPHelper", "same content in-app display now by interval time, drop this ssp message");
                    return 2;
                }
                cn.jpush.android.r.b.f("SSPHelper", "not same content in-app message show recently(3min),ssp delay 3min to notify");
                return 1;
            }
        }
        return 0;
    }

    public static int a(String str) {
        if (Build.MANUFACTURER.toLowerCase().contains("meizu")) {
            return (str.startsWith("Flyme 8") || str.startsWith("Flyme 7.1")) ? 0 : 1;
        }
        return -2;
    }

    public static void a() {
        f9465d = new LinkedHashMap();
        HashMap hashMap = new HashMap();
        hashMap.put("100", new Integer[]{10, 12, 0, 0});
        hashMap.put("101", new Integer[]{0, 1, 0, 1});
        hashMap.put("102", new Integer[]{4, 0, 0, 0});
        hashMap.put("104", new Integer[]{0, 10, 0, 0});
        hashMap.put("105", new Integer[]{0, 2, 0, 0});
        hashMap.put("107", new Integer[]{1});
        hashMap.put("103", new Integer[]{8, 0, 0, 0});
        hashMap.put("106", new Integer[]{0, 8, 8, 0});
        hashMap.put("116", new Integer[]{0, 0, 12, 0});
        hashMap.put("108", new Integer[]{8});
        f9465d.put("EmotionUI_10.0@lv1", hashMap);
        hashMap.put("104", new Integer[]{0, 5, 0, 0});
        f9465d.put("EmotionUI_10.0@lv0", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("101", new Integer[]{0, 1, 0, 1});
        hashMap2.put("100", new Integer[]{15, 2, 15, 4});
        hashMap2.put("112", new Integer[]{0, 8, 0, 0});
        hashMap2.put("116", new Integer[]{0, 8, 0, 0});
        hashMap2.put("106", new Integer[]{6, 0, 0, 6});
        hashMap2.put("102", new Integer[]{5, 0, 0, 0});
        hashMap2.put("107", new Integer[]{1});
        hashMap2.put("103", new Integer[]{6, 0, 0, 0});
        hashMap2.put("108", new Integer[]{8});
        f9465d.put("EmotionUI_10.0@lv2", hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("100", new Integer[]{10, 12, 7, 0});
        hashMap3.put("101", new Integer[]{0, 1, 0, 1});
        hashMap3.put("102", new Integer[]{4, 0, 0, 0});
        hashMap3.put("104", new Integer[]{0, 10, 0, 0});
        hashMap3.put("105", new Integer[]{0, 2, 0, 0});
        hashMap3.put("107", new Integer[]{1});
        hashMap3.put("103", new Integer[]{8, 0, 0, 0});
        hashMap3.put("106", new Integer[]{7, 7, 0, 0});
        hashMap3.put("116", new Integer[]{0, 0, 6, 0});
        hashMap3.put("108", new Integer[]{8});
        f9465d.put("EmotionUI_10.1@lv1", hashMap3);
        hashMap3.put("104", new Integer[]{0, 5, 0, 0});
        f9465d.put("EmotionUI_10.1@lv0", hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("101", new Integer[]{0, 2, 2, 0});
        hashMap4.put("100", new Integer[]{16, 2, 16, 2});
        hashMap4.put("112", new Integer[]{0, 8, 0, 0});
        hashMap4.put("116", new Integer[]{0, 8, 0, 0});
        hashMap4.put("106", new Integer[]{8, 0, 0, 8});
        hashMap4.put("102", new Integer[]{3, 0, 0, 0});
        hashMap4.put("107", new Integer[]{1});
        hashMap4.put("108", new Integer[]{8});
        hashMap4.put("103", new Integer[]{8, 0, 0, 0});
        f9465d.put("EmotionUI_10.1@lv2", hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put("100", new Integer[]{7, 2, 4, 6});
        hashMap5.put("101", new Integer[]{0, 1, 0, 1});
        hashMap5.put("102", new Integer[]{4, 0, 0, 0});
        hashMap5.put("104", new Integer[]{0, 0, 0, 0});
        hashMap5.put("105", new Integer[]{0, 2, 0, 0});
        hashMap5.put("107", new Integer[]{1});
        hashMap5.put("103", new Integer[]{8, 0, 0, 0});
        hashMap5.put("106", new Integer[]{8, 0, 0, 8});
        hashMap5.put("116", new Integer[]{0, 6, 6, 0});
        hashMap5.put("117", new Integer[]{0});
        f9465d.put("EmotionUI_9.1.1@lv1", hashMap5);
        f9465d.put("EmotionUI_9.1.1@lv0", hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put("101", new Integer[]{0, 2, 2, 0});
        hashMap6.put("100", new Integer[]{12, 0, 12, 2});
        hashMap6.put("112", new Integer[]{0, 8, 0, 0});
        hashMap6.put("116", new Integer[]{0, 8, 0, 0});
        hashMap6.put("106", new Integer[]{8, 0, 0, 8});
        hashMap6.put("102", new Integer[]{3, 0, 0, 0});
        hashMap6.put("107", new Integer[]{1});
        hashMap6.put("103", new Integer[]{4, 0, 0, 0});
        hashMap6.put("117", new Integer[]{0});
        f9465d.put("EmotionUI_9.1.1@lv2", hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put("100", new Integer[]{7, 2, 1, 6});
        hashMap7.put("101", new Integer[]{0, 1, 0, 1});
        hashMap7.put("102", new Integer[]{4, 0, 0, 0});
        hashMap7.put("104", new Integer[]{0, 0, 0, 0});
        hashMap7.put("105", new Integer[]{0, 0, 0, 0});
        hashMap7.put("107", new Integer[]{1});
        hashMap7.put("103", new Integer[]{8, 0, 0, 0});
        hashMap7.put("106", new Integer[]{4, 0, 4, 0});
        hashMap7.put("116", new Integer[]{0, 6, 8, 0});
        hashMap7.put("117", new Integer[]{0});
        f9465d.put("EmotionUI_9.0.0@lv1", hashMap7);
        f9465d.put("EmotionUI_9.0.0@lv0", hashMap7);
        HashMap hashMap8 = new HashMap();
        hashMap8.put("101", new Integer[]{0, 2, 2, 0});
        hashMap8.put("100", new Integer[]{12, 0, 12, 2});
        hashMap8.put("112", new Integer[]{0, 8, 0, 0});
        hashMap8.put("116", new Integer[]{0, 8, 0, 0});
        hashMap8.put("106", new Integer[]{8, 8, 0, 0});
        hashMap8.put("102", new Integer[]{3, 0, 0, 0});
        hashMap8.put("107", new Integer[]{1});
        hashMap8.put("103", new Integer[]{4, 0, 0, 0});
        hashMap8.put("117", new Integer[]{0});
        f9465d.put("EmotionUI_9.0.0@lv2", hashMap8);
        HashMap hashMap9 = new HashMap();
        hashMap9.put("100", new Integer[]{7, 7, 4, 0});
        hashMap9.put("101", new Integer[]{0, 1, 0, 1});
        hashMap9.put("102", new Integer[]{4, 0, 0, 0});
        hashMap9.put("104", new Integer[]{0, 10, 0, 0});
        hashMap9.put("105", new Integer[]{0, 2, 0, 0});
        hashMap9.put("107", new Integer[]{1});
        hashMap9.put("103", new Integer[]{8, 0, 0, 0});
        hashMap9.put("106", new Integer[]{8, 8, 0, 0});
        hashMap9.put("116", new Integer[]{0, 0, 6, 0});
        f9465d.put("EmotionUI_9@lv1", hashMap9);
        hashMap9.put("104", new Integer[]{0, 5, 0, 0});
        f9465d.put("EmotionUI_9@lv0", hashMap9);
        HashMap hashMap10 = new HashMap();
        hashMap10.put("101", new Integer[]{0, 2, 2, 0});
        hashMap10.put("100", new Integer[]{12, 0, 12, 2});
        hashMap10.put("112", new Integer[]{0, 8, 0, 0});
        hashMap10.put("116", new Integer[]{0, 8, 0, 0});
        hashMap10.put("106", new Integer[]{8, 0, 0, 8});
        hashMap10.put("102", new Integer[]{3, 0, 0, 0});
        hashMap10.put("107", new Integer[]{1});
        hashMap10.put("103", new Integer[]{4, 0, 0, 0});
        hashMap10.put("117", new Integer[]{0});
        f9465d.put("EmotionUI_9@lv2", hashMap10);
        HashMap hashMap11 = new HashMap();
        hashMap11.put("100", new Integer[]{12, 9, 0, 0});
        hashMap11.put("101", new Integer[]{0, 1, 0, 1});
        hashMap11.put("102", new Integer[]{0, 0, 0, 0});
        hashMap11.put("104", new Integer[]{0, 3, 0, 0});
        hashMap11.put("105", new Integer[]{0, 2, 0, 0});
        hashMap11.put("107", new Integer[]{1});
        hashMap11.put("103", new Integer[]{8, 0, 0, 0});
        hashMap11.put("106", new Integer[]{0, 4, 4, 0});
        hashMap11.put("116", new Integer[]{0, 0, 12, 0});
        hashMap11.put("108", new Integer[]{8});
        f9465d.put("EmotionUI_8@lv1", hashMap11);
        f9465d.put("EmotionUI_8@lv0", hashMap11);
        HashMap hashMap12 = new HashMap();
        hashMap12.put("101", new Integer[]{0, 2, 2, 0});
        hashMap12.put("100", new Integer[]{16, 0, 16, 2});
        hashMap12.put("112", new Integer[]{0, 8, 0, 0});
        hashMap12.put("116", new Integer[]{0, 8, 0, 0});
        hashMap12.put("106", new Integer[]{8, 8, 0, 8});
        hashMap12.put("102", new Integer[]{0, 0, 0, 0});
        hashMap12.put("107", new Integer[]{1});
        hashMap12.put("103", new Integer[]{4, 0, 0, 0});
        hashMap12.put("117", new Integer[]{0});
        f9465d.put("EmotionUI_8@lv2", hashMap12);
        HashMap hashMap13 = new HashMap();
        hashMap13.put("100", new Integer[]{12, 11, 2, 0});
        hashMap13.put("101", new Integer[]{0, 1, 0, 1});
        hashMap13.put("102", new Integer[]{0, 0, 0, 0});
        hashMap13.put("104", new Integer[]{0, 4, 0, 0});
        hashMap13.put("105", new Integer[]{0, 1, 0, 0});
        hashMap13.put("107", new Integer[]{1});
        hashMap13.put("103", new Integer[]{8, 0, 0, 0});
        hashMap13.put("106", new Integer[]{0, 4, 4, 0});
        hashMap13.put("116", new Integer[]{0, 0, 12, 0});
        hashMap13.put("108", new Integer[]{8});
        hashMap13.put("111", new Integer[]{8});
        f9465d.put("EmotionUI_5@lv1", hashMap13);
        f9465d.put("EmotionUI_6@lv1", hashMap13);
        f9465d.put("EmotionUI_7@lv1", hashMap13);
        f9465d.put("EmotionUI_5@lv0", hashMap13);
        f9465d.put("EmotionUI_6@lv0", hashMap13);
        f9465d.put("EmotionUI_7@lv0", hashMap13);
        HashMap hashMap14 = new HashMap();
        hashMap14.put("101", new Integer[]{0, 2, 2, 0});
        hashMap14.put("100", new Integer[]{16, 0, 16, 2});
        hashMap14.put("112", new Integer[]{0, 8, 0, 0});
        hashMap14.put("116", new Integer[]{0, 8, 0, 0});
        hashMap14.put("106", new Integer[]{8, 8, 0, 8});
        hashMap14.put("102", new Integer[]{0, 0, 0, 0});
        hashMap14.put("107", new Integer[]{1});
        hashMap14.put("103", new Integer[]{4, 0, 0, 0});
        hashMap14.put("117", new Integer[]{0});
        f9465d.put("EmotionUI_5@lv2", hashMap14);
        f9465d.put("EmotionUI_6@lv2", hashMap14);
        f9465d.put("EmotionUI_7@lv2", hashMap14);
        HashMap hashMap15 = new HashMap();
        hashMap15.put("100", new Integer[]{1, 0, 0, 0});
        hashMap15.put("102", new Integer[]{7, 11, 0, -1});
        hashMap15.put("103", new Integer[]{0, 11, 0, 0});
        hashMap15.put("105", new Integer[]{7, -1, 0, 0});
        hashMap15.put("107", new Integer[]{1});
        hashMap15.put("106", new Integer[]{3, 11, 9, 1});
        hashMap15.put("115", new Integer[]{10});
        hashMap15.put("116", new Integer[]{0, 12, 0, 0});
        f9465d.put("MIUI_V9@lv1", hashMap15);
        f9465d.put("MIUI_V9@lv0", hashMap15);
        HashMap hashMap16 = new HashMap();
        hashMap16.put("101", new Integer[]{0, 0, 0, 0});
        hashMap16.put("102", new Integer[]{14, 8, 0, 0});
        hashMap16.put("100", new Integer[]{14, 5, 0, 4});
        hashMap16.put("105", new Integer[]{14, 0, 0, 0});
        hashMap16.put("107", new Integer[]{1});
        hashMap16.put("106", new Integer[]{2, 4, 2, 0});
        f9465d.put("MIUI_V9@lv2", hashMap16);
        HashMap hashMap17 = new HashMap();
        hashMap17.put("100", new Integer[]{-1, 0, 0, 0});
        hashMap17.put("102", new Integer[]{-1, 3, 0, 0});
        hashMap17.put("103", new Integer[]{0, 5, 0, 0});
        hashMap17.put("105", new Integer[]{-1, 2, 0, 0});
        hashMap17.put("107", new Integer[]{1});
        hashMap17.put("106", new Integer[]{5, 10, 14, 9});
        hashMap17.put("116", new Integer[]{0, 9, 0, 0});
        f9465d.put("MIUI_V10@lv1", hashMap17);
        f9465d.put("MIUI_V10@lv0", hashMap17);
        HashMap hashMap18 = new HashMap();
        hashMap18.put("101", new Integer[]{0, 0, 0, 0});
        hashMap18.put("102", new Integer[]{0, 8, 0, 0});
        hashMap18.put("100", new Integer[]{0, 5, 0, 0});
        hashMap18.put("105", new Integer[]{0, 0, 0, 0});
        hashMap18.put("107", new Integer[]{1});
        hashMap18.put("106", new Integer[]{4, 14, 14, 4});
        hashMap18.put("117", new Integer[]{0});
        f9465d.put("MIUI_V10@lv2", hashMap18);
        HashMap hashMap19 = new HashMap();
        hashMap19.put("100", new Integer[]{0, 0, 0, 0});
        hashMap19.put("102", new Integer[]{0, 3, 0, 0});
        hashMap19.put("103", new Integer[]{0, 5, 0, 0});
        hashMap19.put("105", new Integer[]{0, 2, 0, 0});
        hashMap19.put("107", new Integer[]{1});
        hashMap19.put("106", new Integer[]{2, 6, 10, 6});
        hashMap19.put("116", new Integer[]{0, 8, 0, 0});
        f9465d.put("MIUI_V11@lv1", hashMap19);
        f9465d.put("MIUI_V11@lv0", hashMap19);
        HashMap hashMap20 = new HashMap();
        hashMap20.put("101", new Integer[]{0, 0, 0, 0});
        hashMap20.put("102", new Integer[]{0, 8, 0, 0});
        hashMap20.put("100", new Integer[]{0, 5, 0, 4});
        hashMap20.put("105", new Integer[]{0, 0, 0, 0});
        hashMap20.put("107", new Integer[]{1});
        hashMap20.put("106", new Integer[]{0, 10, 12, 2});
        f9465d.put("MIUI_V11@lv2", hashMap20);
        HashMap hashMap21 = new HashMap();
        hashMap21.put("101", new Integer[]{0, 0, 0, 0});
        hashMap21.put("102", new Integer[]{0, 3, 0, 0});
        hashMap21.put("100", new Integer[]{0, 0, 14, 0});
        hashMap21.put("105", new Integer[]{2, 0, 0, 0});
        hashMap21.put("107", new Integer[]{2});
        hashMap21.put("106", new Integer[]{12, 0, 12, 24});
        hashMap21.put("111", new Integer[]{8});
        f9465d.put("MIUI_V12@lv2", hashMap21);
        HashMap hashMap22 = new HashMap();
        hashMap22.put("100", new Integer[]{10, 12, 0, 0});
        hashMap22.put("101", new Integer[]{0, 0, 0, 0});
        hashMap22.put("102", new Integer[]{0, 0, 0, 0});
        hashMap22.put("104", new Integer[]{0, 7, 0, 0});
        hashMap22.put("105", new Integer[]{0, 0, 0, 0});
        hashMap22.put("107", new Integer[]{1});
        hashMap22.put("103", new Integer[]{8, 0, 0, 0});
        hashMap22.put("106", new Integer[]{4, 8, 4, 0});
        hashMap22.put("116", new Integer[]{0, 0, 10, 0});
        hashMap22.put("108", new Integer[]{8});
        hashMap22.put("111", new Integer[]{8});
        f9465d.put("OPPO_V6@lv1", hashMap22);
        f9465d.put("OPPO_V6@lv0", hashMap22);
        HashMap hashMap23 = new HashMap();
        hashMap23.put("101", new Integer[]{0, 2, 0, 0});
        hashMap23.put("100", new Integer[]{14, 2, 14, 4});
        hashMap23.put("112", new Integer[]{0, 10, 0, 0});
        hashMap23.put("116", new Integer[]{0, 10, 0, 0});
        hashMap23.put("106", new Integer[]{10, 10, 2, 2});
        hashMap23.put("102", new Integer[]{2, 0, 0, 0});
        hashMap23.put("105", new Integer[]{0, 0, 0, 5});
        hashMap23.put("107", new Integer[]{1});
        hashMap23.put("108", new Integer[]{8});
        hashMap23.put("111", new Integer[]{8});
        f9465d.put("OPPO_V6@lv2", hashMap23);
        HashMap hashMap24 = new HashMap();
        hashMap24.put("100", new Integer[]{10, 12, 0, 0});
        hashMap24.put("101", new Integer[]{0, 2, 0, 2});
        hashMap24.put("102", new Integer[]{0, 0, 0, 0});
        hashMap24.put("104", new Integer[]{0, 7, 0, 0});
        hashMap24.put("105", new Integer[]{0, 0, 0, 0});
        hashMap24.put("107", new Integer[]{1});
        hashMap24.put("103", new Integer[]{8, 0, 0, 0});
        hashMap24.put("106", new Integer[]{5, 10, 5, 0});
        hashMap24.put("116", new Integer[]{0, 0, 10, 0});
        f9465d.put("OPPO_V7@lv1", hashMap24);
        f9465d.put("OPPO_V7@lv0", hashMap24);
        HashMap hashMap25 = new HashMap();
        hashMap25.put("101", new Integer[]{4, 4, 0, 0});
        hashMap25.put("100", new Integer[]{15, 2, 15, 4});
        hashMap25.put("112", new Integer[]{0, 8, 0, 0});
        hashMap25.put("116", new Integer[]{0, 8, 0, 0});
        hashMap25.put("106", new Integer[]{12, 6, 2, 8});
        hashMap25.put("102", new Integer[]{4, 0, 0, 0});
        hashMap25.put("107", new Integer[]{1});
        hashMap25.put("103", new Integer[]{4, 0, 0, 0});
        f9465d.put("OPPO_V7@lv2", hashMap25);
        HashMap hashMap26 = new HashMap();
        hashMap26.put("101", new Integer[]{0, 0, 0, 0});
        hashMap26.put("100", new Integer[]{14, 2, 14, 4});
        hashMap26.put("112", new Integer[]{0, 8, 0, 0});
        hashMap26.put("116", new Integer[]{0, 8, 0, 0});
        hashMap26.put("106", new Integer[]{10, 10, 2, 2});
        hashMap26.put("102", new Integer[]{4, 0, 0, 0});
        hashMap26.put("107", new Integer[]{1});
        hashMap26.put("103", new Integer[]{4, 0, 0, 0});
        f9465d.put("OPPO_V5.1@lv2", hashMap26);
        HashMap hashMap27 = new HashMap();
        hashMap27.put("100", new Integer[]{5, 4, 0, 0});
        hashMap27.put("101", new Integer[]{0, 1, 0, 1});
        hashMap27.put("102", new Integer[]{0, 0, 0, 0});
        hashMap27.put("104", new Integer[]{0, 7, 0, 0});
        hashMap27.put("105", new Integer[]{0, 0, 0, 0});
        hashMap27.put("107", new Integer[]{1});
        hashMap27.put("103", new Integer[]{8, 0, 0, 0});
        hashMap27.put("106", new Integer[]{10, 12, 2, 0});
        hashMap27.put("116", new Integer[]{0, 6, 10, 0});
        f9465d.put("OPPO_V5@lv1", hashMap27);
        f9465d.put("OPPO_V5@lv0", hashMap27);
        HashMap hashMap28 = new HashMap();
        hashMap28.put("101", new Integer[]{0, 2, 0, 0});
        hashMap28.put("100", new Integer[]{10, 0, 10, 4});
        hashMap28.put("112", new Integer[]{0, 8, 0, 0});
        hashMap28.put("116", new Integer[]{0, 8, 0, 0});
        hashMap28.put("106", new Integer[]{12, 10, 2, 4});
        hashMap28.put("102", new Integer[]{4, 0, 0, 0});
        hashMap28.put("107", new Integer[]{1});
        hashMap28.put("103", new Integer[]{4, 0, 0, 0});
        f9465d.put("OPPO_V5@lv2", hashMap28);
        HashMap hashMap29 = new HashMap();
        hashMap29.put("100", new Integer[]{8, 3, 0, 0});
        hashMap29.put("112", new Integer[]{2, 0, 0, 0});
        hashMap29.put("101", new Integer[]{0, 0, 0, 0});
        hashMap29.put("102", new Integer[]{5, 0, 0, 0});
        hashMap29.put("104", new Integer[]{0, 0, 0, 0});
        hashMap29.put("105", new Integer[]{0, 0, 6, 0});
        hashMap29.put("107", new Integer[]{2});
        hashMap29.put("103", new Integer[]{0, 0, 0, 0});
        hashMap29.put("106", new Integer[]{6, 12, 6, 0});
        hashMap29.put("116", new Integer[]{0, 6, 12, 0});
        hashMap29.put("118", new Integer[]{8});
        f9465d.put("Funtouch OS_4.5@lv1", hashMap29);
        f9465d.put("Funtouch OS_4.5@lv0", hashMap29);
        HashMap hashMap30 = new HashMap();
        hashMap30.put("101", new Integer[]{0, 0, 0, 0});
        hashMap30.put("100", new Integer[]{13, 5, 13, 4});
        hashMap30.put("106", new Integer[]{12, 7, 2, 7});
        hashMap30.put("102", new Integer[]{5, 0, 0, 0});
        hashMap30.put("107", new Integer[]{2});
        f9465d.put("Funtouch OS_4.5@lv2", hashMap30);
        HashMap hashMap31 = new HashMap();
        hashMap31.put("100", new Integer[]{9, 3, 0, 0});
        hashMap31.put("112", new Integer[]{2, 0, 0, 0});
        hashMap31.put("101", new Integer[]{0, 0, 0, 0});
        hashMap31.put("102", new Integer[]{3, 0, 0, 0});
        hashMap31.put("104", new Integer[]{0, 0, 0, 0});
        hashMap31.put("105", new Integer[]{0, 0, 6, 0});
        hashMap31.put("107", new Integer[]{2});
        hashMap31.put("103", new Integer[]{8, 0, 0, 0});
        hashMap31.put("106", new Integer[]{6, 12, 6, 0});
        hashMap31.put("116", new Integer[]{0, 6, 12, 0});
        hashMap31.put("118", new Integer[]{8});
        f9465d.put("Funtouch OS_4@lv1", hashMap31);
        f9465d.put("Funtouch OS_4@lv0", hashMap31);
        HashMap hashMap32 = new HashMap();
        hashMap32.put("101", new Integer[]{0, 0, 0, 0});
        hashMap32.put("100", new Integer[]{13, 5, 13, 4});
        hashMap32.put("106", new Integer[]{12, 0, 2, 14});
        hashMap32.put("102", new Integer[]{5, 0, 0, 0});
        hashMap32.put("107", new Integer[]{2});
        f9465d.put("Funtouch OS_4@lv2", hashMap32);
        HashMap hashMap33 = new HashMap();
        hashMap33.put("100", new Integer[]{8, 5, 0, 0});
        hashMap33.put("112", new Integer[]{3, 0, 0, 0});
        hashMap33.put("101", new Integer[]{0, 0, 0, 0});
        hashMap33.put("102", new Integer[]{5, 0, 0, 0});
        hashMap33.put("104", new Integer[]{0, 5, 0, 0});
        hashMap33.put("105", new Integer[]{0, 0, 6, 4});
        hashMap33.put("107", new Integer[]{2});
        hashMap33.put("103", new Integer[]{8, 0, 0, 0});
        hashMap33.put("106", new Integer[]{5, 0, 7, 0});
        hashMap33.put("116", new Integer[]{0, 6, 12, 0});
        hashMap33.put("118", new Integer[]{8});
        f9465d.put("Funtouch OS_9@lv1", hashMap33);
        f9465d.put("Funtouch OS_9@lv0", hashMap33);
        HashMap hashMap34 = new HashMap();
        hashMap34.put("101", new Integer[]{0, 0, 0, 0});
        hashMap34.put("100", new Integer[]{13, 2, 13, 4});
        hashMap34.put("112", new Integer[]{0, 8, 0, 0});
        hashMap34.put("116", new Integer[]{0, 8, 0, 0});
        hashMap34.put("106", new Integer[]{12, 0, 2, 14});
        hashMap34.put("102", new Integer[]{5, 0, 0, 0});
        hashMap34.put("107", new Integer[]{2});
        f9465d.put("Funtouch OS_9@lv2", hashMap34);
        HashMap hashMap35 = new HashMap();
        hashMap35.put("100", new Integer[]{8, 5, 0, 0});
        hashMap35.put("112", new Integer[]{3, 0, 0, 0});
        hashMap35.put("101", new Integer[]{0, 0, 0, 0});
        hashMap35.put("102", new Integer[]{5, 0, 0, 0});
        hashMap35.put("104", new Integer[]{0, 5, 0, 0});
        hashMap35.put("105", new Integer[]{0, 0, 6, 4});
        hashMap35.put("107", new Integer[]{2});
        hashMap35.put("103", new Integer[]{8, 0, 0, 0});
        hashMap35.put("106", new Integer[]{10, 0, 8, 18});
        hashMap35.put("116", new Integer[]{0, 6, 12, 0});
        f9465d.put("Funtouch OS_10@lv1", hashMap35);
        f9465d.put("Funtouch OS_10@lv0", hashMap35);
        HashMap hashMap36 = new HashMap();
        hashMap36.put("101", new Integer[]{0, 0, 1, 0});
        hashMap36.put("100", new Integer[]{14, 2, 14, 4});
        hashMap36.put("112", new Integer[]{0, 8, 0, 0});
        hashMap36.put("116", new Integer[]{0, 8, 0, 0});
        hashMap36.put("106", new Integer[]{16, 4, 2, 14});
        hashMap36.put("102", new Integer[]{5, 0, 0, 0});
        hashMap36.put("107", new Integer[]{1});
        f9465d.put("Funtouch OS_10@lv2", hashMap36);
        HashMap hashMap37 = new HashMap();
        hashMap37.put("100", new Integer[]{22, 4, 18, 0});
        hashMap37.put("112", new Integer[]{0, 10, 0, 0});
        hashMap37.put("116", new Integer[]{0, 10, 0, 0});
        hashMap37.put("101", new Integer[]{2, 2, 2, 2});
        hashMap37.put("102", new Integer[]{0, 0, 0, 0});
        hashMap37.put("104", new Integer[]{0, 0, 0, 2});
        hashMap37.put("108", new Integer[]{8});
        hashMap37.put("103", new Integer[]{8, 0, 0, 0});
        hashMap37.put("107", new Integer[]{1});
        hashMap37.put("106", new Integer[]{6, 6, 6, 6});
        f9465d.put("SAMSUNG_ONEUI_1.5@lv2", hashMap37);
        HashMap hashMap38 = new HashMap();
        hashMap38.put("100", new Integer[]{18, 11, 9, 0});
        hashMap38.put("101", new Integer[]{2, 2, 2, 2});
        hashMap38.put("102", new Integer[]{0, 0, 0, 0});
        hashMap38.put("104", new Integer[]{0, 8, 0, 0});
        hashMap38.put("103", new Integer[]{8, 0, 0, 0});
        hashMap38.put("105", new Integer[]{0, 2, 6, 10});
        hashMap38.put("107", new Integer[]{1});
        hashMap38.put("106", new Integer[]{0, 0, 0, 0});
        hashMap38.put("108", new Integer[]{8});
        hashMap38.put("116", new Integer[]{0, 0, 13, 0});
        f9465d.put("SAMSUNG_ONEUI_1@lv1", hashMap38);
        f9465d.put("SAMSUNG_ONEUI_1@lv0", hashMap38);
        HashMap hashMap39 = new HashMap();
        hashMap39.put("100", new Integer[]{24, 4, 18, 0});
        hashMap39.put("112", new Integer[]{0, 10, 0, 0});
        hashMap39.put("116", new Integer[]{0, 10, 0, 0});
        hashMap39.put("101", new Integer[]{2, 2, 2, 2});
        hashMap39.put("102", new Integer[]{0, 0, 0, 0});
        hashMap39.put("104", new Integer[]{0, 0, 0, 2});
        hashMap39.put("108", new Integer[]{8});
        hashMap39.put("103", new Integer[]{8, 0, 0, 0});
        hashMap39.put("107", new Integer[]{1});
        hashMap39.put("106", new Integer[]{0, 0, 0, 0});
        f9465d.put("SAMSUNG_ONEUI_1@lv2", hashMap39);
        HashMap hashMap40 = new HashMap();
        hashMap40.put("100", new Integer[]{18, 11, 9, 0});
        hashMap40.put("101", new Integer[]{2, 2, 2, 2});
        hashMap40.put("102", new Integer[]{0, 0, 0, 0});
        hashMap40.put("104", new Integer[]{0, 8, 12, 0});
        hashMap40.put("103", new Integer[]{8, 0, 0, 0});
        hashMap40.put("105", new Integer[]{0, 2, 12, 10});
        hashMap40.put("107", new Integer[]{1});
        hashMap40.put("106", new Integer[]{5, 0, 6, 11});
        hashMap40.put("108", new Integer[]{8});
        hashMap40.put("116", new Integer[]{0, 0, 13, 0});
        f9465d.put("SAMSUNG_ONEUI_2@lv1", hashMap40);
        f9465d.put("SAMSUNG_ONEUI_2@lv0", hashMap40);
        HashMap hashMap41 = new HashMap();
        hashMap41.put("100", new Integer[]{22, 4, 18, 4});
        hashMap41.put("112", new Integer[]{0, 10, 0, 0});
        hashMap41.put("116", new Integer[]{0, 10, 0, 0});
        hashMap41.put("101", new Integer[]{2, 2, 2, 2});
        hashMap41.put("102", new Integer[]{0, 0, 0, 0});
        hashMap41.put("104", new Integer[]{0, 0, 12, 2});
        hashMap41.put("105", new Integer[]{0, 1, 12, 0});
        hashMap41.put("108", new Integer[]{8});
        hashMap41.put("103", new Integer[]{8, 0, 0, 0});
        hashMap41.put("107", new Integer[]{1});
        hashMap41.put("106", new Integer[]{6, 6, 6, 6});
        f9465d.put("SAMSUNG_ONEUI_2@lv2", hashMap41);
        HashMap hashMap42 = new HashMap();
        hashMap42.put("100", new Integer[]{18, 8, 9, 0});
        hashMap42.put("101", new Integer[]{2, 2, 2, 2});
        hashMap42.put("102", new Integer[]{0, 0, 0, 0});
        hashMap42.put("104", new Integer[]{0, 6, 12, 0});
        hashMap42.put("103", new Integer[]{8, 0, 0, 0});
        hashMap42.put("105", new Integer[]{0, 2, 12, 10});
        hashMap42.put("107", new Integer[]{1});
        hashMap42.put("106", new Integer[]{5, 0, 6, 11});
        hashMap42.put("108", new Integer[]{8});
        hashMap42.put("116", new Integer[]{0, 0, 13, 0});
        f9465d.put("SAMSUNG_EXUI_9@lv1", hashMap42);
        f9465d.put("SAMSUNG_EXUI_9@lv0", hashMap42);
        HashMap hashMap43 = new HashMap();
        hashMap43.put("100", new Integer[]{22, 4, 16, 4});
        hashMap43.put("112", new Integer[]{0, 10, 0, 0});
        hashMap43.put("116", new Integer[]{0, 10, 0, 0});
        hashMap43.put("101", new Integer[]{2, 2, 2, 2});
        hashMap43.put("102", new Integer[]{0, 0, 0, 0});
        hashMap43.put("104", new Integer[]{0, 0, 12, 2});
        hashMap43.put("105", new Integer[]{0, 1, 12, 0});
        hashMap43.put("108", new Integer[]{8});
        hashMap43.put("103", new Integer[]{8, 0, 0, 0});
        hashMap43.put("107", new Integer[]{1});
        hashMap43.put("106", new Integer[]{5, 5, 5, 5});
        f9465d.put("SAMSUNG_EXUI_9@lv2", hashMap43);
        HashMap hashMap44 = new HashMap();
        hashMap44.put("100", new Integer[]{-5, -2, -5, -10});
        hashMap44.put("101", new Integer[]{2, 2, 2, 2});
        hashMap44.put("102", new Integer[]{3, 0, 0, 0});
        hashMap44.put("104", new Integer[]{0, 9, 12, 0});
        hashMap44.put("105", new Integer[]{0, 2, 12, 10});
        hashMap44.put("107", new Integer[]{1});
        hashMap44.put("113", new Integer[]{8});
        hashMap44.put("108", new Integer[]{8});
        hashMap44.put("111", new Integer[]{8});
        hashMap44.put("116", new Integer[]{0, 0, 8, 0});
        hashMap44.put("117", new Integer[]{0});
        f9465d.put("Flyme 8@lv1", hashMap44);
        f9465d.put("Flyme 8@lv0", hashMap44);
        HashMap hashMap45 = new HashMap();
        hashMap45.put("100", new Integer[]{1, 0, 0, -10});
        hashMap45.put("113", new Integer[]{8});
        hashMap45.put("108", new Integer[]{8});
        hashMap45.put("111", new Integer[]{8});
        hashMap45.put("107", new Integer[]{1});
        hashMap45.put("117", new Integer[]{0});
        hashMap45.put("105", new Integer[]{0, 2, 0, 0});
        f9465d.put("Flyme 8@lv2", hashMap45);
        f9465d.put("Flyme 7@lv2", hashMap45);
        HashMap hashMap46 = new HashMap();
        hashMap46.put("100", new Integer[]{12, 10, 0, 0});
        hashMap46.put("101", new Integer[]{0, 0, 0, 0});
        hashMap46.put("102", new Integer[]{0, 0, 0, 0});
        hashMap46.put("104", new Integer[]{0, 9, 3, 0});
        hashMap46.put("105", new Integer[]{0, 0, 3, 10});
        hashMap46.put("107", new Integer[]{1});
        hashMap46.put("106", new Integer[]{2, 4, 9, 7});
        hashMap46.put("116", new Integer[]{0, 4, 15, 0});
        f9465d.put("Hydrogen OS 9@lv1", hashMap46);
        f9465d.put("OXYGEN_9@lv1", hashMap46);
        f9465d.put("ONEPLUS_9@lv1", hashMap46);
        f9465d.put("ONEPLUS_10@lv1", hashMap46);
        f9465d.put("Hydrogen OS 9@lv0", hashMap46);
        f9465d.put("OXYGEN_9@lv0", hashMap46);
        f9465d.put("ONEPLUS_9@lv0", hashMap46);
        f9465d.put("ONEPLUS_10@lv0", hashMap46);
        HashMap hashMap47 = new HashMap();
        hashMap47.put("100", new Integer[]{14, 2, 14, 0});
        hashMap47.put("112", new Integer[]{0, 8, 0, 0});
        hashMap47.put("116", new Integer[]{0, 8, 0, 0});
        hashMap47.put("107", new Integer[]{1});
        hashMap47.put("106", new Integer[]{8, 5, 2, 5});
        hashMap47.put("103", new Integer[]{2, 0, 0, 0});
        f9465d.put("Hydrogen OS 9@lv2", hashMap47);
        f9465d.put("OXYGEN_9@lv2", hashMap47);
        f9465d.put("ONEPLUS_9@lv2", hashMap47);
        f9465d.put("ONEPLUS_10@lv2", hashMap47);
        HashMap hashMap48 = new HashMap();
        hashMap48.put("100", new Integer[]{6, 14, 0, 0});
        hashMap48.put("101", new Integer[]{1, 1, 1, 1});
        hashMap48.put("102", new Integer[]{0, 0, 0, 0});
        hashMap48.put("104", new Integer[]{0, 4, 12, 0});
        hashMap48.put("105", new Integer[]{0, 2, 12, 10});
        hashMap48.put("107", new Integer[]{1});
        hashMap48.put("106", new Integer[]{16, 9, 3, 10});
        hashMap48.put("108", new Integer[]{8});
        hashMap48.put("111", new Integer[]{8});
        hashMap48.put("114", new Integer[]{5});
        hashMap48.put("116", new Integer[]{0, 0, 10, 0});
        f9465d.put("MEIOS_3@lv1", hashMap48);
        f9465d.put("MEIOS_4@lv1", hashMap48);
        f9465d.put("MEIOS_3@lv0", hashMap48);
        f9465d.put("MEIOS_4@lv0", hashMap48);
        HashMap hashMap49 = new HashMap();
        hashMap49.put("100", new Integer[]{10, 4, 10, 10});
        hashMap49.put("112", new Integer[]{0, 12, 0, 0});
        hashMap49.put("106", new Integer[]{20, 10, 0, 10});
        hashMap49.put("104", new Integer[]{0, 0, 0, 0});
        hashMap49.put("103", new Integer[]{2, 0, 0, 0});
        hashMap49.put("107", new Integer[]{1});
        hashMap49.put("108", new Integer[]{8});
        hashMap49.put("111", new Integer[]{8});
        hashMap49.put("117", new Integer[]{0});
        f9465d.put("MEIOS_3@lv2", hashMap49);
        f9465d.put("MEIOS_4@lv2", hashMap49);
        f9465d.put("default@lv0", new HashMap());
        HashMap hashMap50 = new HashMap();
        hashMap50.put("101", new Integer[]{2, 0, 0, 0});
        hashMap50.put("100", new Integer[]{8, 4, 0, 4});
        hashMap50.put("103", new Integer[]{4, 0, 0, 0});
        f9465d.put("default@lv1", hashMap50);
        HashMap hashMap51 = new HashMap();
        hashMap51.put("101", new Integer[]{2, 0, 0, 0});
        hashMap51.put("100", new Integer[]{8, 6, 8, 4});
        hashMap51.put("103", new Integer[]{4, 0, 0, 0});
        f9465d.put("default@lv2", hashMap51);
    }

    public static byte b(Context context) {
        String messageReceiverClass;
        if (context == null) {
            return (byte) 0;
        }
        try {
            messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("SSPHelper", "[onCheckSspNotificationState]  error. " + th.getMessage());
        }
        if (Class.forName(messageReceiverClass).getMethod("onCheckSspNotificationState", Context.class, String.class) == null) {
            cn.jpush.android.r.b.b("SSPHelper", "not found onCheckSspNotificationState method");
            return (byte) 0;
        }
        if (!TextUtils.isEmpty(messageReceiverClass)) {
            byte onCheckSspNotificationState = ((JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance()).onCheckSspNotificationState(context, cn.jpush.android.bm.a.d(context));
            cn.jpush.android.r.b.c("SSPHelper", "check SspNotificationState:" + ((int) onCheckSspNotificationState));
            return onCheckSspNotificationState;
        }
        return (byte) 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007f A[Catch: all -> 0x0098, TRY_LEAVE, TryCatch #0 {all -> 0x0098, blocks: (B:12:0x005e, B:13:0x0062, B:15:0x007f, B:22:0x0067, B:24:0x006d, B:26:0x0077), top: B:10:0x005c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(java.lang.String r6) {
        /*
            r0 = -2
            java.lang.String r1 = "SSPHelper"
            if (r6 == 0) goto Lae
            java.lang.String r2 = r6.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L11
            goto Lae
        L11:
            java.lang.String r2 = ""
            java.lang.String r3 = "Funtouch"
            java.lang.String r6 = r6.replace(r3, r2)
            java.lang.String r3 = "OS_"
            java.lang.String r6 = r6.replace(r3, r2)
            java.lang.String r6 = r6.trim()
            java.lang.String r2 = "3.1"
            boolean r2 = r6.startsWith(r2)
            r3 = -1
            if (r2 == 0) goto L2d
            return r3
        L2d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "replaceVivoVersion:"
            r2.append(r4)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            cn.jpush.android.r.b.b(r1, r2)
            java.lang.String r2 = "."
            int r2 = r6.indexOf(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "strStartIndex:"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            cn.jpush.android.r.b.b(r1, r4)
            r4 = 0
            if (r2 >= 0) goto L67
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L98
        L62:
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L98
            goto L7d
        L67:
            java.lang.String r6 = r6.substring(r4, r2)     // Catch: java.lang.Throwable -> L98
            if (r6 == 0) goto L7c
            java.lang.String r2 = r6.trim()     // Catch: java.lang.Throwable -> L98
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L98
            if (r2 != 0) goto L7c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L98
            goto L62
        L7c:
            r6 = -1
        L7d:
            if (r6 == r3) goto Lad
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
            r2.<init>()     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = "firstVersion:"
            r2.append(r5)     // Catch: java.lang.Throwable -> L98
            r2.append(r6)     // Catch: java.lang.Throwable -> L98
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L98
            cn.jpush.android.r.b.h(r1, r2)     // Catch: java.lang.Throwable -> L98
            r0 = 3
            if (r6 > r0) goto L97
            return r3
        L97:
            return r4
        L98:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[getVivoNotificationStyle] parse vivo version failed:"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            cn.jpush.android.r.b.h(r1, r6)
        Lad:
            return r0
        Lae:
            java.lang.String r6 = "vivo rom version was empty"
            cn.jpush.android.r.b.b(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.az.e.b(java.lang.String):int");
    }

    public static boolean b() {
        String a2 = cn.jpush.android.w.d.a();
        return (a2 == null || !(a2.startsWith(Rom.ROM_MIUI) || a2.startsWith("Flyme") || a2.startsWith("MEIOS"))) && Build.VERSION.SDK_INT >= 28;
    }

    public static String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            cn.jpush.android.r.b.d("SSPHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            cn.jpush.android.r.b.h("SSPHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    public static boolean c() {
        String a2 = cn.jpush.android.w.d.a();
        if (a2 != null) {
            return (a2.startsWith(Rom.ROM_MIUI) || a2.startsWith("Flyme") || a2.startsWith("MEIOS")) ? false : true;
        }
        return true;
    }

    public static boolean d() {
        try {
            String f2 = f();
            cn.jpush.android.r.b.b("SSPHelper", "vivoVersion:" + f2);
            if (!Build.MANUFACTURER.equalsIgnoreCase("vivo") && !f2.startsWith("Funtouch")) {
                String c2 = c("ro.iqoo.os.build.display.id");
                cn.jpush.android.r.b.b("SSPHelper", "iqooMonsterUI:" + c2);
                if (c2 == null) {
                    return false;
                }
                if (TextUtils.isEmpty(c2.trim())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int e() {
        int a2;
        StringBuilder sb;
        String str;
        try {
            String str2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str2) && f9464c != null && !f9464c.isEmpty() && f9464c.containsKey(str2.toLowerCase())) {
                cn.jpush.android.r.b.b("SSPHelper", "found notify style by manufacturer:" + str2);
                return f9464c.get(str2.toLowerCase()).intValue();
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.b("SSPHelper", "manufacturer fiflter failed:" + th.getMessage());
        }
        try {
            String str3 = Build.MODEL;
            if (!TextUtils.isEmpty(str3) && f9466e != null && !f9466e.isEmpty() && f9466e.containsKey(str3.toLowerCase())) {
                cn.jpush.android.r.b.b("SSPHelper", "found notify style by model:" + str3);
                return f9466e.get(str3.toLowerCase()).intValue();
            }
        } catch (Throwable th2) {
            cn.jpush.android.r.b.b("SSPHelper", "model fiflter failed:" + th2.getMessage());
        }
        String g2 = g();
        if (!TextUtils.isEmpty(g2) && (g2.startsWith("V3.0") || g2.startsWith("V2."))) {
            cn.jpush.android.r.b.b("SSPHelper", "oppo V2.X/V3.0 version use left-right notify style :" + g2);
            return -1;
        }
        String f2 = f();
        if (TextUtils.isEmpty(f2) || (a2 = b(f2)) == -2) {
            String b2 = cn.jpush.android.w.d.b();
            if (TextUtils.isEmpty(b2)) {
                return 0;
            }
            cn.jpush.android.r.b.b("SSPHelper", "flymeVersion notify style :" + b2);
            a2 = a(b2);
            if (a2 == -2) {
                return 0;
            }
            sb = new StringBuilder();
            str = "meizuNotificationStyle notify style :";
        } else {
            sb = new StringBuilder();
            str = "vivoNotificationStyle notify style :";
        }
        sb.append(str);
        sb.append(a2);
        cn.jpush.android.r.b.b("SSPHelper", sb.toString());
        return a2;
    }

    public static String f() {
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        String c2 = c(RomUtils.VERSION_PROPERTY_VIVO);
        k = c2;
        return c2;
    }

    public static String g() {
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        String c2 = c("ro.build.version.opporom");
        j = c2;
        return c2;
    }
}
