package com.shix.shixipc.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.shix.lookcam.R;
import com.shix.lookcam.R$styleable;

/* loaded from: classes.dex */
public class RoundCornerImageView extends AppCompatImageView {
    public boolean mIsCircle;
    public float mRadius;
    public Bitmap mSrcBitmap;
    public Paint paint;
    public Paint paintBorder;

    public RoundCornerImageView(Context context) {
        this(context, null);
    }

    private Bitmap createCircleImage(Bitmap bitmap, int i2, int i3) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawCircle(i2 / 2, i3 / 2, Math.min(i2, i3) / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (i2 - bitmap.getWidth()) / 2, (i3 - bitmap.getHeight()) / 2, paint);
        return createBitmap;
    }

    private Bitmap createRoundImage(Bitmap bitmap, int i2, int i3) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, i2, i3);
        float f2 = this.mRadius;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            Bitmap bitmap = this.mSrcBitmap;
            if (bitmap != null) {
                return bitmap;
            }
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private Bitmap reSizeImage(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private Bitmap reSizeImageC(Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i4 = (i3 - height) / 2;
        if ((i2 - width) / 2 > 0 && i4 > 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, (Matrix) null, true);
        }
        if (width > height) {
            f2 = i2;
            f3 = width;
        } else {
            f2 = i3;
            f3 = height;
        }
        float f4 = f2 / f3;
        Matrix matrix = new Matrix();
        matrix.postScale(f4, f4);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int width = (canvas.getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (canvas.getHeight() - getPaddingTop()) - getPaddingBottom();
        Bitmap drawableToBitmap = drawableToBitmap(getDrawable());
        if (this.mIsCircle) {
            canvas.drawBitmap(createCircleImage(reSizeImageC(drawableToBitmap, width, height), width, height), getPaddingLeft(), getPaddingTop(), (Paint) null);
        } else {
            canvas.drawBitmap(createRoundImage(reSizeImage(drawableToBitmap, width, height), width, height), getPaddingLeft(), getPaddingTop(), (Paint) null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.customImageViewStyle);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CustomImageView, i2, 0);
        this.mRadius = obtainStyledAttributes.getDimension(1, 0.0f);
        this.mIsCircle = obtainStyledAttributes.getBoolean(0, false);
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0);
        if (attributeResourceValue != 0) {
            this.mSrcBitmap = BitmapFactory.decodeResource(getResources(), attributeResourceValue);
        }
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.paintBorder = paint2;
        paint2.setAntiAlias(true);
    }
}
