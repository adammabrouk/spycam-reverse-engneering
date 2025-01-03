package com.google.zxing.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.ResultPoint;
import com.google.zxing.camera.CameraManager;
import com.shix.lookcam.R$styleable;
import com.shix.shixipc.he.Constant;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class ViewfinderView extends View {
    public static final long ANIMATION_DELAY = 10;
    public static final int CORNER_RECT_HEIGHT = 40;
    public static final int CORNER_RECT_WIDTH = 8;
    public static final int SCANNER_LINE_HEIGHT = 10;
    public static final int SCANNER_LINE_MOVE_DISTANCE = 5;
    public final int cornerColor;
    public final int frameColor;
    public final String labelText;
    public final int labelTextColor;
    public final float labelTextSize;
    public final int laserColor;
    public Collection<ResultPoint> lastPossibleResultPoints;
    public final int maskColor;
    public final Paint paint;
    public Collection<ResultPoint> possibleResultPoints;
    public Bitmap resultBitmap;
    public final int resultColor;
    public final int resultPointColor;
    public int scannerAlpha;
    public static final int OPAQUE = 255;
    public static final int[] SCANNER_ALPHA = {0, 64, RecyclerView.c0.FLAG_IGNORE, 192, OPAQUE, 192, RecyclerView.c0.FLAG_IGNORE, 64};
    public static int scannerStart = 0;
    public static int scannerEnd = 0;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewfinderView);
        this.laserColor = obtainStyledAttributes.getColor(5, 65280);
        this.cornerColor = obtainStyledAttributes.getColor(0, 65280);
        this.frameColor = obtainStyledAttributes.getColor(1, Constant.PPPP_STATUS_UNKNOWN);
        this.resultPointColor = obtainStyledAttributes.getColor(8, -1056964864);
        this.maskColor = obtainStyledAttributes.getColor(6, 1610612736);
        this.resultColor = obtainStyledAttributes.getColor(7, -1342177280);
        this.labelTextColor = obtainStyledAttributes.getColor(3, -1862270977);
        this.labelText = obtainStyledAttributes.getString(2);
        this.labelTextSize = obtainStyledAttributes.getFloat(4, 36.0f);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.scannerAlpha = 0;
        this.possibleResultPoints = new HashSet(5);
    }

    private void drawCorner(Canvas canvas, Rect rect) {
        this.paint.setColor(this.cornerColor);
        canvas.drawRect(rect.left, rect.top, r0 + 8, r1 + 40, this.paint);
        canvas.drawRect(rect.left, rect.top, r0 + 40, r1 + 8, this.paint);
        int i2 = rect.right;
        canvas.drawRect(i2 - 8, rect.top, i2, r1 + 40, this.paint);
        int i3 = rect.right;
        canvas.drawRect(i3 - 40, rect.top, i3, r1 + 8, this.paint);
        canvas.drawRect(rect.left, r1 - 8, r0 + 40, rect.bottom, this.paint);
        canvas.drawRect(rect.left, r1 - 40, r0 + 8, rect.bottom, this.paint);
        canvas.drawRect(r0 - 8, r1 - 40, rect.right, rect.bottom, this.paint);
        canvas.drawRect(r0 - 40, r10 - 8, rect.right, rect.bottom, this.paint);
    }

    private void drawExterior(Canvas canvas, Rect rect, int i2, int i3) {
        this.paint.setColor(this.resultBitmap != null ? this.resultColor : this.maskColor);
        float f2 = i2;
        canvas.drawRect(0.0f, 0.0f, f2, rect.top, this.paint);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.paint);
        canvas.drawRect(rect.right + 1, rect.top, f2, rect.bottom + 1, this.paint);
        canvas.drawRect(0.0f, rect.bottom + 1, f2, i3, this.paint);
    }

    private void drawFrame(Canvas canvas, Rect rect) {
        this.paint.setColor(this.frameColor);
        canvas.drawRect(rect.left, rect.top, rect.right + 1, r0 + 2, this.paint);
        canvas.drawRect(rect.left, rect.top + 2, r0 + 2, rect.bottom - 1, this.paint);
        int i2 = rect.right;
        canvas.drawRect(i2 - 1, rect.top, i2 + 1, rect.bottom - 1, this.paint);
        float f2 = rect.left;
        int i3 = rect.bottom;
        canvas.drawRect(f2, i3 - 1, rect.right + 1, i3 + 1, this.paint);
    }

    private void drawLaserScanner(Canvas canvas, Rect rect) {
        this.paint.setColor(this.laserColor);
        int i2 = rect.left;
        LinearGradient linearGradient = new LinearGradient(i2, scannerStart, i2, r4 + 10, shadeColor(this.laserColor), this.laserColor, Shader.TileMode.MIRROR);
        float width = rect.left + (rect.width() / 2);
        float f2 = scannerStart + 5;
        int i3 = this.laserColor;
        RadialGradient radialGradient = new RadialGradient(width, f2, 360.0f, i3, shadeColor(i3), Shader.TileMode.MIRROR);
        new SweepGradient(rect.left + (rect.width() / 2), scannerStart + 10, shadeColor(this.laserColor), this.laserColor);
        new ComposeShader(radialGradient, linearGradient, PorterDuff.Mode.ADD);
        this.paint.setShader(radialGradient);
        if (scannerStart <= scannerEnd) {
            canvas.drawOval(new RectF(rect.left + 20, scannerStart, rect.right - 20, r4 + 10), this.paint);
            scannerStart += 5;
        } else {
            scannerStart = rect.top;
        }
        this.paint.setShader(null);
    }

    private void drawTextInfo(Canvas canvas, Rect rect) {
        this.paint.setColor(this.labelTextColor);
        this.paint.setTextSize(this.labelTextSize);
        this.paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(this.labelText, rect.left + (rect.width() / 2), rect.bottom + 60.0f, this.paint);
    }

    public void addPossibleResultPoint(ResultPoint resultPoint) {
        this.possibleResultPoints.add(resultPoint);
    }

    public void drawResultBitmap(Bitmap bitmap) {
        this.resultBitmap = bitmap;
        invalidate();
    }

    public void drawViewfinder() {
        this.resultBitmap = null;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect framingRect = CameraManager.get().getFramingRect();
        if (framingRect == null) {
            return;
        }
        if (scannerStart == 0 || scannerEnd == 0) {
            scannerStart = framingRect.top;
            scannerEnd = framingRect.bottom;
        }
        drawExterior(canvas, framingRect, canvas.getWidth(), canvas.getHeight());
        if (this.resultBitmap != null) {
            this.paint.setAlpha(OPAQUE);
            canvas.drawBitmap(this.resultBitmap, framingRect.left, framingRect.top, this.paint);
            return;
        }
        drawFrame(canvas, framingRect);
        drawCorner(canvas, framingRect);
        drawTextInfo(canvas, framingRect);
        drawLaserScanner(canvas, framingRect);
        Collection<ResultPoint> collection = this.possibleResultPoints;
        Collection<ResultPoint> collection2 = this.lastPossibleResultPoints;
        if (collection.isEmpty()) {
            this.lastPossibleResultPoints = null;
        } else {
            this.possibleResultPoints = new HashSet(5);
            this.lastPossibleResultPoints = collection;
            this.paint.setAlpha(OPAQUE);
            this.paint.setColor(this.resultPointColor);
            for (ResultPoint resultPoint : collection) {
                canvas.drawCircle(framingRect.left + resultPoint.getX(), framingRect.top + resultPoint.getY(), 6.0f, this.paint);
            }
        }
        if (collection2 != null) {
            this.paint.setAlpha(127);
            this.paint.setColor(this.resultPointColor);
            for (ResultPoint resultPoint2 : collection2) {
                canvas.drawCircle(framingRect.left + resultPoint2.getX(), framingRect.top + resultPoint2.getY(), 3.0f, this.paint);
            }
        }
        postInvalidateDelayed(10L, framingRect.left, framingRect.top, framingRect.right, framingRect.bottom);
    }

    public int shadeColor(int i2) {
        return Integer.valueOf("20" + Integer.toHexString(i2).substring(2), 16).intValue();
    }
}
