package com.shix.shixipc.utilcode;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.drawerlayout.widget.DrawerLayout;
import com.shix.shixipc.utils.SystemBarTintManager;

/* loaded from: classes.dex */
public final class BarUtils {
    public static final int KEY_OFFSET = -123;
    public static final String TAG_OFFSET = "TAG_OFFSET";
    public static final String TAG_STATUS_BAR = "TAG_STATUS_BAR";

    public BarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void addMarginTopEqualStatusBarHeight(View view) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        view.setTag(TAG_OFFSET);
        Object tag = view.getTag(KEY_OFFSET);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(KEY_OFFSET, true);
        }
    }

    public static View applyStatusBarColor(Activity activity, int i2, boolean z) {
        return applyStatusBarColor(activity.getWindow(), i2, z);
    }

    public static View createStatusBarView(Context context, int i2) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight()));
        view.setBackgroundColor(i2);
        view.setTag(TAG_STATUS_BAR);
        return view;
    }

    public static int getActionBarHeight() {
        TypedValue typedValue = new TypedValue();
        if (Utils.getApp().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, Utils.getApp().getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static int getNavBarColor(Activity activity) {
        return getNavBarColor(activity.getWindow());
    }

    public static int getNavBarHeight() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier(SystemBarTintManager.SystemBarConfig.NAV_BAR_HEIGHT_RES_NAME, "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getResNameById(int i2) {
        try {
            return Utils.getApp().getResources().getResourceEntryName(i2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getStatusBarHeight() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier(SystemBarTintManager.SystemBarConfig.STATUS_BAR_HEIGHT_RES_NAME, "dimen", "android"));
    }

    public static void hideStatusBarView(Activity activity) {
        hideStatusBarView(activity.getWindow());
    }

    public static void invokePanels(String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(Utils.getApp().getSystemService("statusbar"), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean isNavBarLightMode(Activity activity) {
        return isNavBarLightMode(activity.getWindow());
    }

    public static boolean isNavBarVisible(Activity activity) {
        return isNavBarVisible(activity.getWindow());
    }

    public static boolean isStatusBarLightMode(Activity activity) {
        return isStatusBarLightMode(activity.getWindow());
    }

    public static boolean isStatusBarVisible(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 0;
    }

    public static boolean isSupportNavBar() {
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(Utils.getApp()).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.y == point.y && point2.x == point.x) ? false : true;
    }

    public static void setNavBarColor(Activity activity, int i2) {
        setNavBarColor(activity.getWindow(), i2);
    }

    public static void setNavBarLightMode(Activity activity, boolean z) {
        setNavBarLightMode(activity.getWindow(), z);
    }

    public static void setNavBarVisibility(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        setNavBarVisibility(activity.getWindow(), z);
    }

    public static void setNotificationBarVisibility(boolean z) {
        invokePanels(z ? Build.VERSION.SDK_INT <= 16 ? "expand" : "expandNotificationsPanel" : Build.VERSION.SDK_INT <= 16 ? "collapse" : "collapsePanels");
    }

    public static View setStatusBarColor(Activity activity, int i2) {
        return setStatusBarColor(activity, i2, false);
    }

    public static void setStatusBarColor4Drawer(DrawerLayout drawerLayout, View view, int i2) {
        setStatusBarColor4Drawer(drawerLayout, view, i2, false);
    }

    public static void setStatusBarCustom(View view) {
        Activity activityByContext;
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            view.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight()));
            } else {
                layoutParams.width = -1;
                layoutParams.height = getStatusBarHeight();
            }
        }
    }

    public static void setStatusBarLightMode(Activity activity, boolean z) {
        setStatusBarLightMode(activity.getWindow(), z);
    }

    public static void setStatusBarVisibility(Activity activity, boolean z) {
        setStatusBarVisibility(activity.getWindow(), z);
    }

    public static void showStatusBarView(Window window) {
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag == null) {
            return;
        }
        findViewWithTag.setVisibility(0);
    }

    public static void subtractMarginTopEqualStatusBarHeight(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 19 && (tag = view.getTag(KEY_OFFSET)) != null && ((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin - getStatusBarHeight(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(KEY_OFFSET, false);
        }
    }

    public static void transparentNavBar(Activity activity) {
        transparentNavBar(activity.getWindow());
    }

    public static void transparentStatusBar(Activity activity) {
        transparentStatusBar(activity.getWindow());
    }

    public static View applyStatusBarColor(Window window, int i2, boolean z) {
        ViewGroup viewGroup = z ? (ViewGroup) window.getDecorView() : (ViewGroup) window.findViewById(R.id.content);
        View findViewWithTag = viewGroup.findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag == null) {
            View createStatusBarView = createStatusBarView(window.getContext(), i2);
            viewGroup.addView(createStatusBarView);
            return createStatusBarView;
        }
        if (findViewWithTag.getVisibility() == 8) {
            findViewWithTag.setVisibility(0);
        }
        findViewWithTag.setBackgroundColor(i2);
        return findViewWithTag;
    }

    public static int getNavBarColor(Window window) {
        return window.getNavigationBarColor();
    }

    public static void hideStatusBarView(Window window) {
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag == null) {
            return;
        }
        findViewWithTag.setVisibility(8);
    }

    public static boolean isNavBarLightMode(Window window) {
        return Build.VERSION.SDK_INT >= 26 && (window.getDecorView().getSystemUiVisibility() & 16) != 0;
    }

    public static boolean isNavBarVisible(Window window) {
        boolean z;
        int i2;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i3);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(getResNameById(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i3++;
        }
        if (!z) {
            return z;
        }
        if (UtilsBridge.isSamsung() && (i2 = Build.VERSION.SDK_INT) >= 17 && i2 < 29) {
            try {
                return Settings.Global.getInt(Utils.getApp().getContentResolver(), "navigationbar_hide_bar_enabled") == 0;
            } catch (Exception unused) {
            }
        }
        return (viewGroup.getSystemUiVisibility() & 2) == 0;
    }

    public static boolean isStatusBarLightMode(Window window) {
        return Build.VERSION.SDK_INT >= 23 && (window.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    public static void setNavBarColor(Window window, int i2) {
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i2);
    }

    public static void setNavBarLightMode(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        }
    }

    public static View setStatusBarColor(Activity activity, int i2, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        transparentStatusBar(activity);
        return applyStatusBarColor(activity, i2, z);
    }

    public static void setStatusBarColor4Drawer(DrawerLayout drawerLayout, View view, int i2, boolean z) {
        Activity activityByContext;
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            drawerLayout.setFitsSystemWindows(false);
            setStatusBarColor(view, i2);
            int childCount = drawerLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                drawerLayout.getChildAt(i3).setFitsSystemWindows(false);
            }
            if (z) {
                hideStatusBarView(activityByContext);
            } else {
                setStatusBarColor(activityByContext, i2, false);
            }
        }
    }

    public static void setStatusBarLightMode(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static void setStatusBarVisibility(Window window, boolean z) {
        if (z) {
            window.clearFlags(1024);
            showStatusBarView(window);
            addMarginTopEqualStatusBarHeight(window);
        } else {
            window.addFlags(1024);
            hideStatusBarView(window);
            subtractMarginTopEqualStatusBarHeight(window);
        }
    }

    public static void transparentNavBar(Window window) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            return;
        }
        if (i2 >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            window.setNavigationBarColor(0);
        } else if (i3 >= 19 && (window.getAttributes().flags & 134217728) == 0) {
            window.addFlags(134217728);
        }
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
    }

    public static void transparentStatusBar(Window window) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            return;
        }
        if (i2 < 21) {
            window.addFlags(67108864);
            return;
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }

    public static void setNavBarVisibility(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(getResNameById(id))) {
                childAt.setVisibility(z ? 0 : 4);
            }
        }
        if (z) {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & (-4611));
        } else {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4610);
        }
    }

    public static View setStatusBarColor(Window window, int i2) {
        return setStatusBarColor(window, i2, false);
    }

    public static View setStatusBarColor(Window window, int i2, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        transparentStatusBar(window);
        return applyStatusBarColor(window, i2, z);
    }

    public static void setStatusBarColor(View view, int i2) {
        Activity activityByContext;
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            view.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = getStatusBarHeight();
            view.setBackgroundColor(i2);
        }
    }

    public static void subtractMarginTopEqualStatusBarHeight(Window window) {
        View findViewWithTag;
        if (Build.VERSION.SDK_INT >= 19 && (findViewWithTag = window.getDecorView().findViewWithTag(TAG_OFFSET)) != null) {
            subtractMarginTopEqualStatusBarHeight(findViewWithTag);
        }
    }

    public static void addMarginTopEqualStatusBarHeight(Window window) {
        View findViewWithTag;
        if (Build.VERSION.SDK_INT >= 19 && (findViewWithTag = window.getDecorView().findViewWithTag(TAG_OFFSET)) != null) {
            addMarginTopEqualStatusBarHeight(findViewWithTag);
        }
    }
}
