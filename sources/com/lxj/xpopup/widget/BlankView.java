package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class BlankView extends View {
    public int color;
    public Paint paint;
    public int radius;
    public RectF rect;
    public int strokeColor;

    public BlankView(Context context) {
        super(context);
        this.paint = new Paint();
        this.rect = null;
        this.radius = 0;
        this.color = -1;
        this.strokeColor = Color.parseColor("#DDDDDD");
    }

    private void init() {
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setColor(this.color);
        RectF rectF = this.rect;
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, this.paint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.strokeColor);
        RectF rectF2 = this.rect;
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, i3, i3, this.paint);
        this.paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.rect = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint();
        this.rect = null;
        this.radius = 0;
        this.color = -1;
        this.strokeColor = Color.parseColor("#DDDDDD");
        init();
    }

    public BlankView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.paint = new Paint();
        this.rect = null;
        this.radius = 0;
        this.color = -1;
        this.strokeColor = Color.parseColor("#DDDDDD");
        init();
    }
}
