package com.shix.shixipc.utils;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SystemBarTintManager {
    public static final int DEFAULT_TINT_COLOR = -1728053248;
    public static String sNavBarOverride;
    public final SystemBarConfig mConfig;
    public boolean mNavBarAvailable;
    public boolean mNavBarTintEnabled;
    public View mNavBarTintView;
    public boolean mStatusBarAvailable;
    public boolean mStatusBarTintEnabled;
    public View mStatusBarTintView;

    public static class SystemBarConfig {
        public static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
        public static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
        public static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
        public static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
        public static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
        public final int mActionBarHeight;
        public final boolean mHasNavigationBar;
        public final boolean mInPortrait;
        public final int mNavigationBarHeight;
        public final int mNavigationBarWidth;
        public final float mSmallestWidthDp;
        public final int mStatusBarHeight;
        public final boolean mTranslucentNavBar;
        public final boolean mTranslucentStatusBar;

        @TargetApi(14)
        private int getActionBarHeight(Context context) {
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        private int getInternalDimensionSize(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        private int getNavigationBarHeight(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return getInternalDimensionSize(resources, this.mInPortrait ? NAV_BAR_HEIGHT_RES_NAME : NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME);
        }

        @TargetApi(14)
        private int getNavigationBarWidth(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return getInternalDimensionSize(resources, NAV_BAR_WIDTH_RES_NAME);
        }

        @SuppressLint({"NewApi"})
        private float getSmallestWidthDp(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f2 = displayMetrics.widthPixels;
            float f3 = displayMetrics.density;
            return Math.min(f2 / f3, displayMetrics.heightPixels / f3);
        }

        @TargetApi(14)
        private boolean hasNavBar(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
            if (identifier == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(SystemBarTintManager.sNavBarOverride)) {
                return false;
            }
            if ("0".equals(SystemBarTintManager.sNavBarOverride)) {
                return true;
            }
            return z;
        }

        public int getPixelInsetBottom() {
            if (this.mTranslucentNavBar && isNavigationAtBottom()) {
                return this.mNavigationBarHeight;
            }
            return 0;
        }

        public int getPixelInsetRight() {
            if (!this.mTranslucentNavBar || isNavigationAtBottom()) {
                return 0;
            }
            return this.mNavigationBarWidth;
        }

        public int getPixelInsetTop(boolean z) {
            return (this.mTranslucentStatusBar ? this.mStatusBarHeight : 0) + (z ? this.mActionBarHeight : 0);
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.mHasNavigationBar;
        }

        public boolean isNavigationAtBottom() {
            return this.mSmallestWidthDp >= 600.0f || this.mInPortrait;
        }

        public SystemBarConfig(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.mInPortrait = resources.getConfiguration().orientation == 1;
            this.mSmallestWidthDp = getSmallestWidthDp(activity);
            this.mStatusBarHeight = getInternalDimensionSize(resources, STATUS_BAR_HEIGHT_RES_NAME);
            this.mActionBarHeight = getActionBarHeight(activity);
            this.mNavigationBarHeight = getNavigationBarHeight(activity);
            this.mNavigationBarWidth = getNavigationBarWidth(activity);
            this.mHasNavigationBar = this.mNavigationBarHeight > 0;
            this.mTranslucentStatusBar = z;
            this.mTranslucentNavBar = z2;
        }

        public int getActionBarHeight() {
            return this.mActionBarHeight;
        }

        public int getNavigationBarWidth() {
            return this.mNavigationBarWidth;
        }

        public int getNavigationBarHeight() {
            return this.mNavigationBarHeight;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                sNavBarOverride = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                sNavBarOverride = null;
            }
        }
    }

    @TargetApi(19)
    public SystemBarTintManager(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{R.attr.windowTranslucentStatus, R.attr.windowTranslucentNavigation});
            try {
                this.mStatusBarAvailable = obtainStyledAttributes.getBoolean(0, false);
                this.mNavBarAvailable = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.mStatusBarAvailable = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.mNavBarAvailable = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        SystemBarConfig systemBarConfig = new SystemBarConfig(activity, this.mStatusBarAvailable, this.mNavBarAvailable);
        this.mConfig = systemBarConfig;
        if (!systemBarConfig.hasNavigtionBar()) {
            this.mNavBarAvailable = false;
        }
        if (this.mStatusBarAvailable) {
            setupStatusBarView(activity, viewGroup);
        }
        if (this.mNavBarAvailable) {
            setupNavBarView(activity, viewGroup);
        }
    }

    private void setupNavBarView(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.mNavBarTintView = new View(context);
        if (this.mConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.mNavBarTintView.setLayoutParams(layoutParams);
        this.mNavBarTintView.setBackgroundColor(DEFAULT_TINT_COLOR);
        this.mNavBarTintView.setVisibility(8);
        viewGroup.addView(this.mNavBarTintView);
    }

    private void setupStatusBarView(Context context, ViewGroup viewGroup) {
        this.mStatusBarTintView = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.mNavBarAvailable && !this.mConfig.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.mConfig.getNavigationBarWidth();
        }
        this.mStatusBarTintView.setLayoutParams(layoutParams);
        this.mStatusBarTintView.setBackgroundColor(DEFAULT_TINT_COLOR);
        this.mStatusBarTintView.setVisibility(8);
        viewGroup.addView(this.mStatusBarTintView);
    }

    public SystemBarConfig getConfig() {
        return this.mConfig;
    }

    public boolean isNavBarTintEnabled() {
        return this.mNavBarTintEnabled;
    }

    public boolean isStatusBarTintEnabled() {
        return this.mStatusBarTintEnabled;
    }

    @TargetApi(11)
    public void setNavigationBarAlpha(float f2) {
        if (!this.mNavBarAvailable || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.mNavBarTintView.setAlpha(f2);
    }

    public void setNavigationBarTintColor(int i2) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundColor(i2);
        }
    }

    public void setNavigationBarTintDrawable(Drawable drawable) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundDrawable(drawable);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        this.mNavBarTintEnabled = z;
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setVisibility(z ? 0 : 8);
        }
    }

    public void setNavigationBarTintResource(int i2) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundResource(i2);
        }
    }

    @TargetApi(11)
    public void setStatusBarAlpha(float f2) {
        if (!this.mStatusBarAvailable || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.mStatusBarTintView.setAlpha(f2);
    }

    public void setStatusBarTintColor(int i2) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundColor(i2);
        }
    }

    public void setStatusBarTintDrawable(Drawable drawable) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundDrawable(drawable);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.mStatusBarTintEnabled = z;
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setVisibility(z ? 0 : 8);
        }
    }

    public void setStatusBarTintResource(int i2) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundResource(i2);
        }
    }

    public void setTintAlpha(float f2) {
        setStatusBarAlpha(f2);
        setNavigationBarAlpha(f2);
    }

    public void setTintColor(int i2) {
        setStatusBarTintColor(i2);
        setNavigationBarTintColor(i2);
    }

    public void setTintDrawable(Drawable drawable) {
        setStatusBarTintDrawable(drawable);
        setNavigationBarTintDrawable(drawable);
    }

    public void setTintResource(int i2) {
        setStatusBarTintResource(i2);
        setNavigationBarTintResource(i2);
    }
}
