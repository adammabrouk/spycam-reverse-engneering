package com.shix.shixipc.utilcode;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class SizeUtils {

    public interface OnGetSizeListener {
        void onGetSize(View view);
    }

    public SizeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static float applyDimension(float f2, int i2) {
        float f3;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (i2 == 0) {
            return f2;
        }
        if (i2 == 1) {
            f3 = displayMetrics.density;
        } else if (i2 == 2) {
            f3 = displayMetrics.scaledDensity;
        } else if (i2 == 3) {
            f2 *= displayMetrics.xdpi;
            f3 = 0.013888889f;
        } else if (i2 == 4) {
            f3 = displayMetrics.xdpi;
        } else {
            if (i2 != 5) {
                return 0.0f;
            }
            f2 *= displayMetrics.xdpi;
            f3 = 0.03937008f;
        }
        return f2 * f3;
    }

    public static int dp2px(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static void forceGetViewSize(final View view, final OnGetSizeListener onGetSizeListener) {
        view.post(new Runnable() { // from class: com.shix.shixipc.utilcode.SizeUtils.1
            @Override // java.lang.Runnable
            public void run() {
                OnGetSizeListener onGetSizeListener2 = OnGetSizeListener.this;
                if (onGetSizeListener2 != null) {
                    onGetSizeListener2.onGetSize(view);
                }
            }
        });
    }

    public static int getMeasuredHeight(View view) {
        return measureView(view)[1];
    }

    public static int getMeasuredWidth(View view) {
        return measureView(view)[0];
    }

    public static int[] measureView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        view.measure(childMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static int px2dp(float f2) {
        return (int) ((f2 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f2) {
        return (int) ((f2 / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
