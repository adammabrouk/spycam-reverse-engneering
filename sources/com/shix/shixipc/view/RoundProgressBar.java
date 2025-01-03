package com.shix.shixipc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.camera.CameraManager;
import com.google.zxing.client.j2se.DecodeWorker;
import com.shix.lookcam.R$styleable;
import com.shix.shixipc.utils.MyLogUtils;

/* loaded from: classes.dex */
public class RoundProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    public int max;
    public Paint paint;
    public int progress;
    public int roundColor;
    public int roundProgressColor;
    public float roundWidth;
    public int style;
    public int textColor;
    public boolean textIsDisplayable;
    public float textSize;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public int getCricleColor() {
        return this.roundColor;
    }

    public int getCricleProgressColor() {
        return this.roundProgressColor;
    }

    public synchronized int getMax() {
        return this.max;
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f2 = width;
        int i2 = (int) (f2 - (this.roundWidth / 2.0f));
        this.paint.setColor(this.roundColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        canvas.drawCircle(f2, f2, i2, this.paint);
        MyLogUtils.e("log", width + "");
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD);
        int i3 = (int) ((this.progress / this.max) * 100.0f);
        float measureText = this.paint.measureText(i3 + "%");
        if (this.textIsDisplayable && this.style == 0) {
            canvas.drawText(i3 + "%", f2 - (measureText / 2.0f), f2 + (this.textSize / 2.0f), this.paint);
        }
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundProgressColor);
        float f3 = width - i2;
        float f4 = width + i2;
        RectF rectF = new RectF(f3, f3, f4, f4);
        int i4 = this.style;
        if (i4 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, 0.0f, (this.progress * CameraManager.MAX_FRAME_HEIGHT) / this.max, false, this.paint);
        } else {
            if (i4 != 1) {
                return;
            }
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.progress != 0) {
                canvas.drawArc(rectF, 0.0f, (r0 * CameraManager.MAX_FRAME_HEIGHT) / this.max, true, this.paint);
            }
        }
    }

    public void setCricleColor(int i2) {
        this.roundColor = i2;
    }

    public void setCricleProgressColor(int i2) {
        this.roundProgressColor = i2;
    }

    public synchronized void setMax(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.max = i2;
    }

    public synchronized void setProgress(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i2 > this.max) {
            i2 = this.max;
        }
        if (i2 <= this.max) {
            this.progress = i2;
            postInvalidate();
        }
    }

    public void setRoundWidth(float f2) {
        this.roundWidth = f2;
    }

    public void setTextColor(int i2) {
        this.textColor = i2;
    }

    public void setTextSize(float f2) {
        this.textSize = f2;
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundProgressBar);
        this.roundColor = obtainStyledAttributes.getColor(1, DecodeWorker.RED);
        this.roundProgressColor = obtainStyledAttributes.getColor(2, -16711936);
        this.textColor = obtainStyledAttributes.getColor(5, -16711936);
        this.textSize = obtainStyledAttributes.getDimension(7, 15.0f);
        this.roundWidth = obtainStyledAttributes.getDimension(3, 5.0f);
        this.max = obtainStyledAttributes.getInteger(0, 100);
        this.textIsDisplayable = obtainStyledAttributes.getBoolean(6, true);
        this.style = obtainStyledAttributes.getInt(4, 0);
        obtainStyledAttributes.recycle();
    }
}
