package com.shix.shixipc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.shix.lookcam.R$styleable;

/* loaded from: classes.dex */
public class RadiuImageView extends AppCompatImageView {
    public int defaultRadius;
    public float height;
    public int leftBottomRadius;
    public int leftTopRadius;
    public int radius;
    public int rightBottomRadius;
    public int rightTopRadius;
    public float width;

    public RadiuImageView(Context context) {
        this(context, null);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundCornerImageView);
        this.radius = obtainStyledAttributes.getDimensionPixelOffset(2, this.defaultRadius);
        this.leftTopRadius = obtainStyledAttributes.getDimensionPixelOffset(1, this.defaultRadius);
        this.rightTopRadius = obtainStyledAttributes.getDimensionPixelOffset(4, this.defaultRadius);
        this.rightBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(3, this.defaultRadius);
        this.leftBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(0, this.defaultRadius);
        if (this.defaultRadius == this.leftTopRadius) {
            this.leftTopRadius = this.radius;
        }
        if (this.defaultRadius == this.rightTopRadius) {
            this.rightTopRadius = this.radius;
        }
        if (this.defaultRadius == this.rightBottomRadius) {
            this.rightBottomRadius = this.radius;
        }
        if (this.defaultRadius == this.leftBottomRadius) {
            this.leftBottomRadius = this.radius;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int max = Math.max(this.leftTopRadius, this.leftBottomRadius) + Math.max(this.rightTopRadius, this.rightBottomRadius);
        int max2 = Math.max(this.leftTopRadius, this.rightTopRadius) + Math.max(this.leftBottomRadius, this.rightBottomRadius);
        if (this.width >= max && this.height > max2) {
            Path path = new Path();
            path.moveTo(this.leftTopRadius, 0.0f);
            path.lineTo(this.width - this.rightTopRadius, 0.0f);
            float f2 = this.width;
            path.quadTo(f2, 0.0f, f2, this.rightTopRadius);
            path.lineTo(this.width, this.height - this.rightBottomRadius);
            float f3 = this.width;
            float f4 = this.height;
            path.quadTo(f3, f4, f3 - this.rightBottomRadius, f4);
            path.lineTo(this.leftBottomRadius, this.height);
            float f5 = this.height;
            path.quadTo(0.0f, f5, 0.0f, f5 - this.leftBottomRadius);
            path.lineTo(0.0f, this.leftTopRadius);
            path.quadTo(0.0f, 0.0f, this.leftTopRadius, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.width = getWidth();
        this.height = getHeight();
    }

    public RadiuImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context, attributeSet);
    }

    public RadiuImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.defaultRadius = 0;
        init(context, attributeSet);
    }
}
