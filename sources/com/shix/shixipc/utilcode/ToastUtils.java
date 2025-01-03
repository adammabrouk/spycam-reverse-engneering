package com.shix.shixipc.utilcode;

import a.h.a.j;
import a.h.b.a;
import a.h.j.y;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.shix.lookcam.R;
import com.shix.shixipc.utilcode.Utils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class ToastUtils {
    public static final int COLOR_DEFAULT = -16777217;
    public static final ToastUtils DEFAULT_MAKER = make();
    public static final String NOTHING = "toast nothing";
    public static final String NULL = "toast null";
    public static final String TAG_TOAST = "TAG_TOAST";
    public static WeakReference<IToast> sWeakToast;
    public String mMode;
    public int mGravity = -1;
    public int mXOffset = -1;
    public int mYOffset = -1;
    public int mBgColor = COLOR_DEFAULT;
    public int mBgResource = -1;
    public int mTextColor = COLOR_DEFAULT;
    public int mTextSize = -1;
    public boolean isLong = false;
    public Drawable[] mIcons = new Drawable[4];
    public boolean isNotUseSystemToast = false;

    public static final class ActivityToast extends AbsToast {
        public static int sShowingIndex;
        public IToast iToast;
        public Utils.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

        public ActivityToast(ToastUtils toastUtils) {
            super(toastUtils);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isShowing() {
            return this.mActivityLifecycleCallbacks != null;
        }

        private void registerLifecycleCallback() {
            final int i2 = sShowingIndex;
            Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Utils.ActivityLifecycleCallbacks() { // from class: com.shix.shixipc.utilcode.ToastUtils.ActivityToast.2
                @Override // com.shix.shixipc.utilcode.Utils.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity) {
                    if (ActivityToast.this.isShowing()) {
                        ActivityToast.this.showWithActivityView(activity, i2, false);
                    }
                }
            };
            this.mActivityLifecycleCallbacks = activityLifecycleCallbacks;
            UtilsBridge.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }

        private IToast showSystemToast(int i2) {
            SystemToast systemToast = new SystemToast(this.mToastUtils);
            systemToast.mToast = this.mToast;
            systemToast.show(i2);
            return systemToast;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showWithActivityView(Activity activity, int i2, boolean z) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.mToast.getGravity();
                layoutParams.bottomMargin = this.mToast.getYOffset() + UtilsBridge.getNavBarHeight();
                layoutParams.topMargin = this.mToast.getYOffset() + UtilsBridge.getStatusBarHeight();
                layoutParams.leftMargin = this.mToast.getXOffset();
                View toastViewSnapshot = getToastViewSnapshot(i2);
                if (z) {
                    toastViewSnapshot.setAlpha(0.0f);
                    toastViewSnapshot.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(toastViewSnapshot, layoutParams);
            }
        }

        private IToast showWithActivityWindow(Activity activity, int i2) {
            WindowManagerToast windowManagerToast = new WindowManagerToast(this.mToastUtils, activity.getWindowManager(), 99);
            windowManagerToast.mToastView = getToastViewSnapshot(-1);
            windowManagerToast.mToast = this.mToast;
            windowManagerToast.show(i2);
            return windowManagerToast;
        }

        private void unregisterLifecycleCallback() {
            UtilsBridge.removeActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
            this.mActivityLifecycleCallbacks = null;
        }

        @Override // com.shix.shixipc.utilcode.ToastUtils.AbsToast, com.shix.shixipc.utilcode.ToastUtils.IToast
        public void cancel() {
            Window window;
            if (isShowing()) {
                unregisterLifecycleCallback();
                for (Activity activity : UtilsBridge.getActivityList()) {
                    if (UtilsBridge.isActivityAlive(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder();
                        sb.append(ToastUtils.TAG_TOAST);
                        sb.append(sShowingIndex - 1);
                        View findViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (findViewWithTag != null) {
                            try {
                                viewGroup.removeView(findViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            IToast iToast = this.iToast;
            if (iToast != null) {
                iToast.cancel();
                this.iToast = null;
            }
            super.cancel();
        }

        @Override // com.shix.shixipc.utilcode.ToastUtils.IToast
        public void show(int i2) {
            if (this.mToast == null) {
                return;
            }
            if (!UtilsBridge.isAppForeground()) {
                this.iToast = showSystemToast(i2);
                return;
            }
            boolean z = false;
            for (Activity activity : UtilsBridge.getActivityList()) {
                if (UtilsBridge.isActivityAlive(activity)) {
                    if (z) {
                        showWithActivityView(activity, sShowingIndex, true);
                    } else {
                        this.iToast = showWithActivityWindow(activity, i2);
                        z = true;
                    }
                }
            }
            if (!z) {
                this.iToast = showSystemToast(i2);
                return;
            }
            registerLifecycleCallback();
            UtilsBridge.runOnUiThreadDelayed(new Runnable() { // from class: com.shix.shixipc.utilcode.ToastUtils.ActivityToast.1
                @Override // java.lang.Runnable
                public void run() {
                    ActivityToast.this.cancel();
                }
            }, i2 == 0 ? 2000L : 3500L);
            sShowingIndex++;
        }
    }

    public interface IToast {
        void cancel();

        void setToastView(View view);

        void setToastView(CharSequence charSequence);

        void show(int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MODE {
        public static final String DARK = "dark";
        public static final String LIGHT = "light";
    }

    public static final class SystemToast extends AbsToast {

        public static class SafeHandler extends Handler {
            public Handler impl;

            public SafeHandler(Handler handler) {
                this.impl = handler;
            }

            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                try {
                    this.impl.dispatchMessage(message);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                this.impl.handleMessage(message);
            }
        }

        public SystemToast(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.mToast);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new SafeHandler((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.shix.shixipc.utilcode.ToastUtils.IToast
        public void show(int i2) {
            Toast toast = this.mToast;
            if (toast == null) {
                return;
            }
            toast.setDuration(i2);
            this.mToast.show();
        }
    }

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {
        public static final int SPACING = UtilsBridge.dp2px(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(UtilsBridge.getAppScreenWidth() - SPACING, Integer.MIN_VALUE), i3);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }
    }

    public static void cancel() {
        UtilsBridge.runOnUiThread(new Runnable() { // from class: com.shix.shixipc.utilcode.ToastUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtils.sWeakToast != null) {
                    IToast iToast = (IToast) ToastUtils.sWeakToast.get();
                    if (iToast != null) {
                        iToast.cancel();
                    }
                    WeakReference unused = ToastUtils.sWeakToast = null;
                }
            }
        });
    }

    public static ToastUtils getDefaultMaker() {
        return DEFAULT_MAKER;
    }

    private int getDuration() {
        return this.isLong ? 1 : 0;
    }

    public static CharSequence getToastFriendlyText(CharSequence charSequence) {
        return charSequence == null ? NULL : charSequence.length() == 0 ? NOTHING : charSequence;
    }

    public static ToastUtils make() {
        return new ToastUtils();
    }

    public static IToast newToast(ToastUtils toastUtils) {
        if (!toastUtils.isNotUseSystemToast && j.a(Utils.getApp()).a()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new SystemToast(toastUtils);
            }
            if (!UtilsBridge.isGrantedDrawOverlays()) {
                return new SystemToast(toastUtils);
            }
        }
        return Build.VERSION.SDK_INT < 25 ? new WindowManagerToast(toastUtils, 2005) : UtilsBridge.isGrantedDrawOverlays() ? Build.VERSION.SDK_INT >= 26 ? new WindowManagerToast(toastUtils, 2038) : new WindowManagerToast(toastUtils, 2002) : new ActivityToast(toastUtils);
    }

    public static void showLong(CharSequence charSequence) {
        show(charSequence, 1, DEFAULT_MAKER);
    }

    public static void showShort(CharSequence charSequence) {
        show(charSequence, 0, DEFAULT_MAKER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View tryApplyUtilsToastView(CharSequence charSequence) {
        if (!MODE.DARK.equals(this.mMode) && !MODE.LIGHT.equals(this.mMode)) {
            Drawable[] drawableArr = this.mIcons;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View layoutId2View = UtilsBridge.layoutId2View(R.layout.utils_toast_view);
        TextView textView = (TextView) layoutId2View.findViewById(android.R.id.message);
        if (MODE.DARK.equals(this.mMode)) {
            ((GradientDrawable) layoutId2View.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.mIcons[0] != null) {
            View findViewById = layoutId2View.findViewById(R.id.utvLeftIconView);
            y.a(findViewById, this.mIcons[0]);
            findViewById.setVisibility(0);
        }
        if (this.mIcons[1] != null) {
            View findViewById2 = layoutId2View.findViewById(R.id.utvTopIconView);
            y.a(findViewById2, this.mIcons[1]);
            findViewById2.setVisibility(0);
        }
        if (this.mIcons[2] != null) {
            View findViewById3 = layoutId2View.findViewById(R.id.utvRightIconView);
            y.a(findViewById3, this.mIcons[2]);
            findViewById3.setVisibility(0);
        }
        if (this.mIcons[3] != null) {
            View findViewById4 = layoutId2View.findViewById(R.id.utvBottomIconView);
            y.a(findViewById4, this.mIcons[3]);
            findViewById4.setVisibility(0);
        }
        return layoutId2View;
    }

    public final ToastUtils setBgColor(int i2) {
        this.mBgColor = i2;
        return this;
    }

    public final ToastUtils setBgResource(int i2) {
        this.mBgResource = i2;
        return this;
    }

    public final ToastUtils setBottomIcon(int i2) {
        return setBottomIcon(a.c(Utils.getApp(), i2));
    }

    public final ToastUtils setDurationIsLong(boolean z) {
        this.isLong = z;
        return this;
    }

    public final ToastUtils setGravity(int i2, int i3, int i4) {
        this.mGravity = i2;
        this.mXOffset = i3;
        this.mYOffset = i4;
        return this;
    }

    public final ToastUtils setLeftIcon(int i2) {
        return setLeftIcon(a.c(Utils.getApp(), i2));
    }

    public final ToastUtils setMode(String str) {
        this.mMode = str;
        return this;
    }

    public final ToastUtils setNotUseSystemToast() {
        this.isNotUseSystemToast = true;
        return this;
    }

    public final ToastUtils setRightIcon(int i2) {
        return setRightIcon(a.c(Utils.getApp(), i2));
    }

    public final ToastUtils setTextColor(int i2) {
        this.mTextColor = i2;
        return this;
    }

    public final ToastUtils setTextSize(int i2) {
        this.mTextSize = i2;
        return this;
    }

    public final ToastUtils setTopIcon(int i2) {
        return setTopIcon(a.c(Utils.getApp(), i2));
    }

    public final void show(CharSequence charSequence) {
        show(charSequence, getDuration(), this);
    }

    public static abstract class AbsToast implements IToast {
        public Toast mToast = new Toast(Utils.getApp());
        public ToastUtils mToastUtils;
        public View mToastView;

        public AbsToast(ToastUtils toastUtils) {
            this.mToastUtils = toastUtils;
            if (toastUtils.mGravity == -1 && this.mToastUtils.mXOffset == -1 && this.mToastUtils.mYOffset == -1) {
                return;
            }
            this.mToast.setGravity(this.mToastUtils.mGravity, this.mToastUtils.mXOffset, this.mToastUtils.mYOffset);
        }

        private void processRtlIfNeed() {
            if (UtilsBridge.isLayoutRtl()) {
                setToastView(getToastViewSnapshot(-1));
            }
        }

        private void setBg(TextView textView) {
            if (this.mToastUtils.mBgResource != -1) {
                this.mToastView.setBackgroundResource(this.mToastUtils.mBgResource);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.mToastUtils.mBgColor != -16777217) {
                Drawable background = this.mToastView.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                } else {
                    this.mToastView.setBackgroundColor(this.mToastUtils.mBgColor);
                }
            }
        }

        @Override // com.shix.shixipc.utilcode.ToastUtils.IToast
        public void cancel() {
            Toast toast = this.mToast;
            if (toast != null) {
                toast.cancel();
            }
            this.mToast = null;
            this.mToastView = null;
        }

        public View getToastViewSnapshot(int i2) {
            Bitmap view2Bitmap = UtilsBridge.view2Bitmap(this.mToastView);
            ImageView imageView = new ImageView(Utils.getApp());
            imageView.setTag(ToastUtils.TAG_TOAST + i2);
            imageView.setImageBitmap(view2Bitmap);
            return imageView;
        }

        @Override // com.shix.shixipc.utilcode.ToastUtils.IToast
        public void setToastView(View view) {
            this.mToastView = view;
            this.mToast.setView(view);
        }

        @Override // com.shix.shixipc.utilcode.ToastUtils.IToast
        public void setToastView(CharSequence charSequence) {
            View tryApplyUtilsToastView = this.mToastUtils.tryApplyUtilsToastView(charSequence);
            if (tryApplyUtilsToastView != null) {
                setToastView(tryApplyUtilsToastView);
                processRtlIfNeed();
                return;
            }
            View view = this.mToast.getView();
            this.mToastView = view;
            if (view == null || view.findViewById(android.R.id.message) == null) {
                setToastView(UtilsBridge.layoutId2View(R.layout.utils_toast_view));
            }
            TextView textView = (TextView) this.mToastView.findViewById(android.R.id.message);
            textView.setText(charSequence);
            if (this.mToastUtils.mTextColor != -16777217) {
                textView.setTextColor(this.mToastUtils.mTextColor);
            }
            if (this.mToastUtils.mTextSize != -1) {
                textView.setTextSize(this.mToastUtils.mTextSize);
            }
            setBg(textView);
            processRtlIfNeed();
        }
    }

    public static void showLong(int i2) {
        show(UtilsBridge.getString(i2), 1, DEFAULT_MAKER);
    }

    public static void showShort(int i2) {
        show(UtilsBridge.getString(i2), 0, DEFAULT_MAKER);
    }

    public final ToastUtils setBottomIcon(Drawable drawable) {
        this.mIcons[3] = drawable;
        return this;
    }

    public final ToastUtils setLeftIcon(Drawable drawable) {
        this.mIcons[0] = drawable;
        return this;
    }

    public final ToastUtils setRightIcon(Drawable drawable) {
        this.mIcons[2] = drawable;
        return this;
    }

    public final ToastUtils setTopIcon(Drawable drawable) {
        this.mIcons[1] = drawable;
        return this;
    }

    public final void show(int i2) {
        show(UtilsBridge.getString(i2), getDuration(), this);
    }

    public static void showLong(int i2, Object... objArr) {
        show(UtilsBridge.getString(i2, objArr), 1, DEFAULT_MAKER);
    }

    public static void showShort(int i2, Object... objArr) {
        show(UtilsBridge.getString(i2, objArr), 0, DEFAULT_MAKER);
    }

    public final void show(int i2, Object... objArr) {
        show(UtilsBridge.getString(i2, objArr), getDuration(), this);
    }

    public static final class WindowManagerToast extends AbsToast {
        public WindowManager.LayoutParams mParams;
        public WindowManager mWM;

        public WindowManagerToast(ToastUtils toastUtils, int i2) {
            super(toastUtils);
            this.mParams = new WindowManager.LayoutParams();
            this.mWM = (WindowManager) Utils.getApp().getSystemService("window");
            this.mParams.type = i2;
        }

        @Override // com.shix.shixipc.utilcode.ToastUtils.AbsToast, com.shix.shixipc.utilcode.ToastUtils.IToast
        public void cancel() {
            try {
                if (this.mWM != null) {
                    this.mWM.removeViewImmediate(this.mToastView);
                    this.mWM = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        @Override // com.shix.shixipc.utilcode.ToastUtils.IToast
        public void show(int i2) {
            if (this.mToast == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = android.R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.mParams;
            layoutParams2.flags = 152;
            layoutParams2.packageName = Utils.getApp().getPackageName();
            this.mParams.gravity = this.mToast.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.mParams;
            if ((layoutParams3.gravity & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            WindowManager.LayoutParams layoutParams4 = this.mParams;
            if ((layoutParams4.gravity & 112) == 112) {
                layoutParams4.verticalWeight = 1.0f;
            }
            this.mParams.x = this.mToast.getXOffset();
            this.mParams.y = this.mToast.getYOffset();
            this.mParams.horizontalMargin = this.mToast.getHorizontalMargin();
            this.mParams.verticalMargin = this.mToast.getVerticalMargin();
            try {
                if (this.mWM != null) {
                    this.mWM.addView(this.mToastView, this.mParams);
                }
            } catch (Exception unused) {
            }
            UtilsBridge.runOnUiThreadDelayed(new Runnable() { // from class: com.shix.shixipc.utilcode.ToastUtils.WindowManagerToast.1
                @Override // java.lang.Runnable
                public void run() {
                    WindowManagerToast.this.cancel();
                }
            }, i2 == 0 ? 2000L : 3500L);
        }

        public WindowManagerToast(ToastUtils toastUtils, WindowManager windowManager, int i2) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.mParams = layoutParams;
            this.mWM = windowManager;
            layoutParams.type = i2;
        }
    }

    public static void showLong(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), 1, DEFAULT_MAKER);
    }

    public static void showShort(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), 0, DEFAULT_MAKER);
    }

    public final void show(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), getDuration(), this);
    }

    public final void show(View view) {
        show(view, getDuration(), this);
    }

    public static void show(CharSequence charSequence, int i2, ToastUtils toastUtils) {
        show(null, getToastFriendlyText(charSequence), i2, toastUtils);
    }

    public static void show(View view, int i2, ToastUtils toastUtils) {
        show(view, null, i2, toastUtils);
    }

    public static void show(final View view, final CharSequence charSequence, final int i2, ToastUtils toastUtils) {
        UtilsBridge.runOnUiThread(new Runnable() { // from class: com.shix.shixipc.utilcode.ToastUtils.2
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.cancel();
                IToast newToast = ToastUtils.newToast(ToastUtils.this);
                WeakReference unused = ToastUtils.sWeakToast = new WeakReference(newToast);
                View view2 = view;
                if (view2 != null) {
                    newToast.setToastView(view2);
                } else {
                    newToast.setToastView(charSequence);
                }
                newToast.show(i2);
            }
        });
    }
}
