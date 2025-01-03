package com.shix.shixipc.utilcode;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.shix.shixipc.utils.SystemBarTintManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class AdaptScreenUtils {
    public static List<Field> sMetricsFields;

    public AdaptScreenUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Resources adaptHeight(Resources resources, int i2) {
        return adaptHeight(resources, i2, false);
    }

    public static Resources adaptWidth(Resources resources, int i2) {
        applyDisplayMetrics(resources, (resources.getDisplayMetrics().widthPixels * 72.0f) / i2);
        return resources;
    }

    public static void applyDisplayMetrics(Resources resources, float f2) {
        resources.getDisplayMetrics().xdpi = f2;
        Utils.getApp().getResources().getDisplayMetrics().xdpi = f2;
        applyOtherDisplayMetrics(resources, f2);
    }

    public static void applyMetricsFields(Resources resources, float f2) {
        Iterator<Field> it = sMetricsFields.iterator();
        while (it.hasNext()) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) it.next().get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void applyOtherDisplayMetrics(Resources resources, float f2) {
        if (sMetricsFields != null) {
            applyMetricsFields(resources, f2);
            return;
        }
        sMetricsFields = new ArrayList();
        Class<?> cls = resources.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        while (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                    field.setAccessible(true);
                    DisplayMetrics metricsFromField = getMetricsFromField(resources, field);
                    if (metricsFromField != null) {
                        sMetricsFields.add(field);
                        metricsFromField.xdpi = f2;
                    }
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                return;
            } else {
                declaredFields = cls.getDeclaredFields();
            }
        }
    }

    public static Resources closeAdapt(Resources resources) {
        applyDisplayMetrics(resources, Resources.getSystem().getDisplayMetrics().density * 72.0f);
        return resources;
    }

    public static DisplayMetrics getMetricsFromField(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getNavBarHeight(Resources resources) {
        int identifier = resources.getIdentifier(SystemBarTintManager.SystemBarConfig.NAV_BAR_HEIGHT_RES_NAME, "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Runnable getPreLoadRunnable() {
        return new Runnable() { // from class: com.shix.shixipc.utilcode.AdaptScreenUtils.1
            @Override // java.lang.Runnable
            public void run() {
                AdaptScreenUtils.preLoad();
            }
        };
    }

    public static void preLoad() {
        applyDisplayMetrics(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }

    public static int pt2Px(float f2) {
        double d2 = (f2 * Utils.getApp().getResources().getDisplayMetrics().xdpi) / 72.0f;
        Double.isNaN(d2);
        return (int) (d2 + 0.5d);
    }

    public static int px2Pt(float f2) {
        double d2 = (f2 * 72.0f) / Utils.getApp().getResources().getDisplayMetrics().xdpi;
        Double.isNaN(d2);
        return (int) (d2 + 0.5d);
    }

    public static Resources adaptHeight(Resources resources, int i2, boolean z) {
        applyDisplayMetrics(resources, ((resources.getDisplayMetrics().heightPixels + (z ? getNavBarHeight(resources) : 0)) * 72.0f) / i2);
        return resources;
    }
}
