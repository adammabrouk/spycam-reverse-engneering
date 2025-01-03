package cn.jpush.android.au;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jpush.android.aw.a;
import cn.jpush.android.helper.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f9363a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static int f9364b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static cn.jpush.android.aw.a f9365c;

    public static float a(List<List<a.b.C0148a>> list) {
        float f2 = 0.0f;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                for (a.b.C0148a c0148a : list.get(i2)) {
                    if ("translationY".equals(c0148a.f9392a)) {
                        for (Float f3 : c0148a.f9393b) {
                            if (f3.floatValue() > f2) {
                                f2 = f3.floatValue();
                            }
                        }
                    }
                }
            }
        }
        return f2;
    }

    public static int a(Context context, float f2) {
        d(context);
        int i2 = (int) ((f9363a * f2) / 100.0f);
        Logger.d("InAppAniConfigUtils", "getW proportion:" + f2 + ",w:" + i2);
        return i2;
    }

    public static cn.jpush.android.aw.a a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Logger.d("InAppAniConfigUtils", "dataJson: " + jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("in_app_banner");
            if (optJSONObject != null) {
                return cn.jpush.android.aw.a.a().a(optJSONObject.optString("shake")).b(optJSONObject.optString("animator")).c(optJSONObject.optString("container")).d(optJSONObject.optString("h5_extras")).a();
            }
            return null;
        } catch (Throwable th) {
            Logger.w("InAppAniConfigUtils", "build animator config failed, " + th.getMessage());
            return null;
        }
    }

    public static List<Long> a(Context context) {
        cn.jpush.android.aw.a e2 = e(context);
        return e2 == null ? new ArrayList() : e2.f9385b;
    }

    public static List<List<a.b.C0148a>> a(Context context, boolean z) {
        a.b bVar;
        List<List<a.b.C0148a>> arrayList = new ArrayList<>();
        cn.jpush.android.aw.a e2 = e(context);
        if (e2 != null && (bVar = e2.f9386c) != null) {
            if (z) {
                a.b.C0149b c0149b = bVar.f9390a;
                if (c0149b != null) {
                    arrayList = c0149b.f9395a;
                }
            } else {
                a.b.C0149b c0149b2 = bVar.f9391b;
                if (c0149b2 != null) {
                    arrayList = c0149b2.f9395a;
                }
            }
        }
        Logger.d("InAppAniConfigUtils", "landscape:" + z);
        Logger.d("InAppAniConfigUtils", "getAnimatorShow:" + arrayList);
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public static float b(List<List<a.b.C0148a>> list) {
        List<Float> list2;
        float f2 = 0.0f;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                for (a.b.C0148a c0148a : list.get(i2)) {
                    if ("translationY".equals(c0148a.f9392a) && (list2 = c0148a.f9393b) != null && list2.size() > 0) {
                        f2 = list2.get(list2.size() - 1).floatValue();
                    }
                }
            }
        }
        return f2;
    }

    public static List<List<a.b.C0148a>> b(Context context, boolean z) {
        a.b bVar;
        List<List<a.b.C0148a>> arrayList = new ArrayList<>();
        cn.jpush.android.aw.a e2 = e(context);
        if (e2 != null && (bVar = e2.f9386c) != null) {
            if (z) {
                a.b.C0149b c0149b = bVar.f9390a;
                if (c0149b != null) {
                    arrayList = c0149b.f9396b;
                }
            } else {
                a.b.C0149b c0149b2 = bVar.f9391b;
                if (c0149b2 != null) {
                    arrayList = c0149b2.f9396b;
                }
            }
        }
        Logger.d("InAppAniConfigUtils", "landscape:" + z);
        Logger.d("InAppAniConfigUtils", "getAnimatorHide:" + arrayList);
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (e(context) != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("w", g(context, true));
                jSONObject2.put("h", h(context, true));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("w", g(context, false));
                jSONObject3.put("h", h(context, false));
                jSONObject.put("landscape", jSONObject2);
                jSONObject.put("portrait", jSONObject3);
            }
            Logger.d("InAppAniConfigUtils", "containerJSON:" + jSONObject.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static int c(Context context, boolean z) {
        return h(context, z) + a(context, a(a(context, z)));
    }

    public static String c(Context context) {
        cn.jpush.android.aw.a e2 = e(context);
        return e2 == null ? "" : e2.f9388e;
    }

    public static int d(Context context, boolean z) {
        return h(context, z) + a(context, a(b(context, z)));
    }

    public static void d(Context context) {
        DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
        f9363a = a2.widthPixels;
        f9364b = a2.heightPixels;
        Logger.d("InAppAniConfigUtils", "initScreen screenW:" + f9363a + ",screenH:" + f9364b);
        StringBuilder sb = new StringBuilder();
        sb.append("initScreen metrics:");
        sb.append(a2);
        Logger.d("InAppAniConfigUtils", sb.toString());
    }

    public static int e(Context context, boolean z) {
        return h(context, z) + a(context, b(a(context, z)));
    }

    public static cn.jpush.android.aw.a e(Context context) {
        if (f9365c == null) {
            cn.jpush.android.aw.a a2 = a(cn.jpush.android.at.a.a().a(context));
            if (a2 == null) {
                a2 = a(cn.jpush.android.aw.a.f9384a);
            }
            f9365c = a2;
        }
        return f9365c;
    }

    public static int f(Context context, boolean z) {
        return h(context, z) + a(context, b(b(context, z)));
    }

    public static int g(Context context, boolean z) {
        a.c cVar;
        cn.jpush.android.aw.a e2 = e(context);
        float f2 = 0.0f;
        if (e2 != null && (cVar = e2.f9387d) != null) {
            if (z) {
                a.c.C0150a c0150a = cVar.f9397a;
                if (c0150a != null) {
                    f2 = c0150a.f9399a;
                }
            } else {
                a.c.C0150a c0150a2 = cVar.f9398b;
                if (c0150a2 != null) {
                    f2 = c0150a2.f9399a;
                }
            }
        }
        return a(context, f2);
    }

    public static int h(Context context, boolean z) {
        a.c cVar;
        cn.jpush.android.aw.a e2 = e(context);
        float f2 = 0.0f;
        if (e2 != null && (cVar = e2.f9387d) != null) {
            if (z) {
                a.c.C0150a c0150a = cVar.f9397a;
                if (c0150a != null) {
                    f2 = c0150a.f9400b;
                }
            } else {
                a.c.C0150a c0150a2 = cVar.f9398b;
                if (c0150a2 != null) {
                    f2 = c0150a2.f9400b;
                }
            }
        }
        Logger.d("InAppAniConfigUtils", "getContainerHeight proportionH:" + f2);
        return a(context, f2);
    }
}
