package com.shix.shixipc.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.shix.lookcam.R$styleable;

@SuppressLint({"Recycle", "AppCompatCustomView"})
/* loaded from: classes.dex */
public class RoundAngleImageView extends ImageView {
    public Paint paint;
    public Paint paint2;
    public int roundHeight;
    public int roundWidth;

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.roundWidth = 5;
        this.roundHeight = 5;
        init(context, attributeSet);
    }

    private void drawLiftDown(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, getHeight() - this.roundHeight);
        path.lineTo(0.0f, getHeight());
        path.lineTo(this.roundWidth, getHeight());
        path.arcTo(new RectF(0.0f, getHeight() - (this.roundHeight * 2), (this.roundWidth * 2) + 0, getHeight()), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawLiftUp(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.roundHeight);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.roundWidth, 0.0f);
        path.arcTo(new RectF(0.0f, 0.0f, this.roundWidth * 2, this.roundHeight * 2), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawRightDown(Canvas canvas) {
        Path path = new Path();
        path.moveTo(getWidth() - this.roundWidth, getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), getHeight() - this.roundHeight);
        path.arcTo(new RectF(getWidth() - (this.roundWidth * 2), getHeight() - (this.roundHeight * 2), getWidth(), getHeight()), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawRightUp(Canvas canvas) {
        Path path = new Path();
        path.moveTo(getWidth(), this.roundHeight);
        path.lineTo(getWidth(), 0.0f);
        path.lineTo(getWidth() - this.roundWidth, 0.0f);
        path.arcTo(new RectF(getWidth() - (this.roundWidth * 2), 0.0f, getWidth(), (this.roundHeight * 2) + 0), -90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundAngleImageView);
            this.roundWidth = obtainStyledAttributes.getDimensionPixelSize(1, this.roundWidth);
            this.roundHeight = obtainStyledAttributes.getDimensionPixelSize(0, this.roundHeight);
        } else {
            float f2 = context.getResources().getDisplayMetrics().density;
            this.roundWidth = (int) (this.roundWidth * f2);
            this.roundHeight = (int) (this.roundHeight * f2);
        }
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.paint2 = paint2;
        paint2.setXfermode(null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        drawLiftUp(canvas2);
        drawRightUp(canvas2);
        drawLiftDown(canvas2);
        drawRightDown(canvas2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.paint2);
        createBitmap.recycle();
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.roundWidth = 5;
        this.roundHeight = 5;
        init(context, attributeSet);
    }

    public RoundAngleImageView(Context context) {
        super(context);
        this.roundWidth = 5;
        this.roundHeight = 5;
        init(context, null);
    }
}
