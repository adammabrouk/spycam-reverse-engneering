package com.shix.shixipc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.zxing.client.j2se.DecodeWorker;
import com.shix.lookcam.R$styleable;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class ShadowContainer extends ViewGroup {
    public final float cornerRadius;
    public final float deltaLength;
    public boolean drawShadow;
    public final Paint mShadowPaint;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ShadowContainer(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.drawShadow) {
            if (getLayerType() != 1) {
                setLayerType(1, null);
            }
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int top = childAt.getTop();
            int right = childAt.getRight();
            int bottom = childAt.getBottom();
            if (Build.VERSION.SDK_INT < 21) {
                Path path = new Path();
                float f2 = left;
                float f3 = top;
                path.moveTo(this.cornerRadius + f2, f3);
                float f4 = this.cornerRadius;
                path.arcTo(new RectF(f2, f3, (f4 * 2.0f) + f2, (f4 * 2.0f) + f3), -90.0f, -90.0f, false);
                float f5 = bottom;
                path.lineTo(f2, f5 - this.cornerRadius);
                float f6 = this.cornerRadius;
                path.arcTo(new RectF(f2, f5 - (f6 * 2.0f), (f6 * 2.0f) + f2, f5), 180.0f, -90.0f, false);
                float f7 = right;
                path.lineTo(f7 - this.cornerRadius, f5);
                float f8 = this.cornerRadius;
                path.arcTo(new RectF(f7 - (f8 * 2.0f), f5 - (f8 * 2.0f), f7, f5), 90.0f, -90.0f, false);
                path.lineTo(f7, this.cornerRadius + f3);
                float f9 = this.cornerRadius;
                path.arcTo(new RectF(f7 - (f9 * 2.0f), f3, f7, (f9 * 2.0f) + f3), 0.0f, -90.0f, false);
                path.close();
                canvas.drawPath(path, this.mShadowPaint);
                super.dispatchDraw(canvas);
            }
            float f10 = this.cornerRadius;
            canvas.drawRoundRect(left, top, right, bottom, f10, f10, this.mShadowPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt = getChildAt(0);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = childAt.getMeasuredWidth();
        int measuredHeight2 = childAt.getMeasuredHeight();
        childAt.layout((measuredWidth - measuredWidth2) / 2, (measuredHeight - measuredHeight2) / 2, (measuredWidth + measuredWidth2) / 2, (measuredHeight + measuredHeight2) / 2);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        if (getChildCount() != 1) {
            throw new IllegalStateException("子View只能有一个");
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i6 = 0;
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int max = (int) (Math.max(this.deltaLength, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + 1.0f);
        int max2 = (int) (Math.max(this.deltaLength, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + 1.0f);
        int max3 = (int) (Math.max(this.deltaLength, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + 1.0f);
        int max4 = (int) (Math.max(this.deltaLength, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + 1.0f);
        int i7 = MemoryConstants.GB;
        if (mode == 0) {
            i4 = View.MeasureSpec.getSize(i2);
        } else {
            i4 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            if (i4 == -1) {
                i4 = (measuredWidth - max2) - max3;
            } else if (-2 == i4) {
                i4 = (measuredWidth - max2) - max3;
                i6 = Integer.MIN_VALUE;
            }
            i6 = MemoryConstants.GB;
        }
        if (mode2 == 0) {
            i5 = View.MeasureSpec.getSize(i3);
            i7 = 0;
        } else {
            i5 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            if (i5 == -1) {
                i5 = (measuredHeight - max) - max4;
            } else if (-2 == i5) {
                i5 = (measuredHeight - max) - max4;
                i7 = Integer.MIN_VALUE;
            }
        }
        measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i4, i6), View.MeasureSpec.makeMeasureSpec(i5, i7));
        int mode3 = View.MeasureSpec.getMode(i2);
        int mode4 = View.MeasureSpec.getMode(i3);
        int measuredHeight2 = childAt.getMeasuredHeight();
        int measuredWidth2 = childAt.getMeasuredWidth();
        int i8 = mode4 == Integer.MIN_VALUE ? max4 + measuredHeight2 + max : measuredHeight;
        int i9 = mode3 == Integer.MIN_VALUE ? max3 + measuredWidth2 + max2 : measuredWidth;
        float f2 = i9;
        float f3 = measuredWidth2;
        float f4 = this.deltaLength;
        if (f2 < (f4 * 2.0f) + f3) {
            i9 = (int) (f3 + (f4 * 2.0f));
        }
        float f5 = i8;
        float f6 = measuredHeight2;
        float f7 = this.deltaLength;
        if (f5 < (f7 * 2.0f) + f6) {
            i8 = (int) (f6 + (f7 * 2.0f));
        }
        if (i8 == measuredHeight && i9 == measuredWidth) {
            return;
        }
        setMeasuredDimension(i9, i8);
    }

    public void setDrawShadow(boolean z) {
        if (this.drawShadow == z) {
            return;
        }
        this.drawShadow = z;
        postInvalidate();
    }

    public ShadowContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ShadowContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShadowContainer);
        int color = obtainStyledAttributes.getColor(2, DecodeWorker.RED);
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        this.deltaLength = obtainStyledAttributes.getDimension(1, 0.0f);
        this.cornerRadius = obtainStyledAttributes.getDimension(0, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.drawShadow = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setColor(color);
        this.mShadowPaint.setShadowLayer(dimension, dimension2, dimension3, color);
    }
}
