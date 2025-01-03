package com.shix.shixipc.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.shix.shixipc.utils.MyLogUtils;

/* loaded from: classes.dex */
public class HackyViewPager extends ViewPager {
    public static final String TAG = "HackyViewPager";

    public HackyViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException unused) {
            MyLogUtils.e(TAG, "hacky viewpager error2");
            return false;
        } catch (IllegalArgumentException unused2) {
            MyLogUtils.e(TAG, "hacky viewpager error1");
            return false;
        }
    }

    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
