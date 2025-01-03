package com.shix.shixipc.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.shix.shixipc.he.Constant;

/* loaded from: classes.dex */
public class ZoomView extends FrameLayout {
    public static final String TAG = "ZoomView";
    public Bitmap ch;
    public long lastTapTime;
    public float lastd;
    public float lastdx1;
    public float lastdx2;
    public float lastdy1;
    public float lastdy2;
    public ZoomViewListener listener;
    public final Matrix m;
    public float maxZoom;
    public String miniMapCaption;
    public int miniMapCaptionColor;
    public float miniMapCaptionSize;
    public int miniMapColor;
    public int miniMapHeight;
    public final Paint p;
    public boolean pinching;
    public boolean scrolling;
    public boolean showMinimap;
    public float smoothZoom;
    public float smoothZoomX;
    public float smoothZoomY;
    public float startd;
    public float touchLastX;
    public float touchLastY;
    public float touchStartX;
    public float touchStartY;
    public float zoom;
    public float zoomX;
    public float zoomY;

    public interface ZoomViewListener {
        void onZoomEnded(float f2, float f3, float f4);

        void onZoomStarted(float f2, float f3, float f4);

        void onZooming(float f2, float f3, float f4);
    }

    public ZoomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.zoom = 1.0f;
        this.maxZoom = 3.0f;
        this.smoothZoom = 1.0f;
        this.showMinimap = false;
        this.miniMapColor = -1;
        this.miniMapHeight = -1;
        this.miniMapCaptionSize = 10.0f;
        this.miniMapCaptionColor = -1;
        this.m = new Matrix();
        this.p = new Paint();
    }

    private float bias(float f2, float f3, float f4) {
        float f5 = f3 - f2;
        return Math.abs(f5) >= f4 ? f2 + (f4 * Math.signum(f5)) : f3;
    }

    private float clamp(float f2, float f3, float f4) {
        return Math.max(f2, Math.min(f3, f4));
    }

    private float lerp(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    private void processDoubleTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        float f2 = x - this.lastdx1;
        this.lastdx1 = x;
        float y = motionEvent.getY(0);
        float f3 = y - this.lastdy1;
        this.lastdy1 = y;
        float x2 = motionEvent.getX(1);
        float f4 = x2 - this.lastdx2;
        this.lastdx2 = x2;
        float y2 = motionEvent.getY(1);
        float f5 = y2 - this.lastdy2;
        this.lastdy2 = y2;
        double d2 = x2 - x;
        double d3 = y2 - y;
        float hypot = (float) Math.hypot(d2, d3);
        float f6 = hypot - this.lastd;
        this.lastd = hypot;
        float abs = Math.abs(hypot - this.startd);
        Math.atan2(d3, d2);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startd = hypot;
            this.pinching = false;
        } else if (action != 2) {
            this.pinching = false;
        } else if (this.pinching || abs > 30.0f) {
            this.pinching = true;
            float max = Math.max(1.0f, (this.zoom * hypot) / (hypot - f6));
            float f7 = this.zoomX;
            float f8 = this.zoom;
            smoothZoomTo(max, f7 - (((f2 + f4) * 0.5f) / f8), this.zoomY - (((f3 + f5) * 0.5f) / f8));
        }
        motionEvent.setAction(3);
        super.dispatchTouchEvent(motionEvent);
    }

    private void processSingleTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z = x >= 10.0f && x <= ((((float) this.miniMapHeight) * ((float) getWidth())) / ((float) getHeight())) + 10.0f && y >= 10.0f && y <= ((float) this.miniMapHeight) + 10.0f;
        if (this.showMinimap && this.smoothZoom > 1.0f && z) {
            processSingleTouchOnMinimap(motionEvent);
        } else {
            processSingleTouchOutsideMinimap(motionEvent);
        }
    }

    private void processSingleTouchOnMinimap(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        smoothZoomTo(this.smoothZoom, ((x - 10.0f) / ((this.miniMapHeight * getWidth()) / getHeight())) * getWidth(), ((y - 10.0f) / this.miniMapHeight) * getHeight());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r5 != 4) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void processSingleTouchOutsideMinimap(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.view.ZoomView.processSingleTouchOutsideMinimap(android.view.MotionEvent):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        ZoomViewListener zoomViewListener;
        this.zoom = lerp(bias(this.zoom, this.smoothZoom, 0.05f), this.smoothZoom, 0.2f);
        this.smoothZoomX = clamp((getWidth() * 0.5f) / this.smoothZoom, this.smoothZoomX, getWidth() - ((getWidth() * 0.5f) / this.smoothZoom));
        this.smoothZoomY = clamp((getHeight() * 0.5f) / this.smoothZoom, this.smoothZoomY, getHeight() - ((getHeight() * 0.5f) / this.smoothZoom));
        this.zoomX = lerp(bias(this.zoomX, this.smoothZoomX, 0.1f), this.smoothZoomX, 0.35f);
        float lerp = lerp(bias(this.zoomY, this.smoothZoomY, 0.1f), this.smoothZoomY, 0.35f);
        this.zoomY = lerp;
        float f2 = this.zoom;
        if (f2 != this.smoothZoom && (zoomViewListener = this.listener) != null) {
            zoomViewListener.onZooming(f2, this.zoomX, lerp);
        }
        boolean z = Math.abs(this.zoom - this.smoothZoom) > 1.0E-7f || Math.abs(this.zoomX - this.smoothZoomX) > 1.0E-7f || Math.abs(this.zoomY - this.smoothZoomY) > 1.0E-7f;
        if (getChildCount() == 0) {
            return;
        }
        this.m.setTranslate(getWidth() * 0.5f, getHeight() * 0.5f);
        Matrix matrix = this.m;
        float f3 = this.zoom;
        matrix.preScale(f3, f3);
        this.m.preTranslate(-clamp((getWidth() * 0.5f) / this.zoom, this.zoomX, getWidth() - ((getWidth() * 0.5f) / this.zoom)), -clamp((getHeight() * 0.5f) / this.zoom, this.zoomY, getHeight() - ((getHeight() * 0.5f) / this.zoom)));
        View childAt = getChildAt(0);
        this.m.preTranslate(childAt.getLeft(), childAt.getTop());
        if (z && isAnimationCacheEnabled() && this.ch != null) {
            this.p.setColor(-1);
            canvas.drawBitmap(this.ch, this.m, this.p);
        } else {
            this.ch = null;
            canvas.save();
            canvas.concat(this.m);
            childAt.draw(canvas);
            canvas.restore();
        }
        if (this.showMinimap) {
            if (this.miniMapHeight < 0) {
                this.miniMapHeight = getHeight() / 4;
            }
            canvas.translate(10.0f, 10.0f);
            this.p.setColor((this.miniMapColor & Constant.PPPP_STATUS_UNKNOWN) | Integer.MIN_VALUE);
            float width = (this.miniMapHeight * getWidth()) / getHeight();
            float f4 = this.miniMapHeight;
            canvas.drawRect(0.0f, 0.0f, width, f4, this.p);
            String str = this.miniMapCaption;
            if (str != null && str.length() > 0) {
                this.p.setTextSize(this.miniMapCaptionSize);
                this.p.setColor(this.miniMapCaptionColor);
                this.p.setAntiAlias(true);
                canvas.drawText(this.miniMapCaption, 10.0f, this.miniMapCaptionSize + 10.0f, this.p);
                this.p.setAntiAlias(false);
            }
            this.p.setColor((this.miniMapColor & Constant.PPPP_STATUS_UNKNOWN) | Integer.MIN_VALUE);
            float width2 = (this.zoomX * width) / getWidth();
            float height = (this.zoomY * f4) / getHeight();
            float f5 = width * 0.5f;
            float f6 = this.zoom;
            float f7 = f4 * 0.5f;
            canvas.drawRect(width2 - (f5 / f6), height - (f7 / f6), width2 + (f5 / f6), height + (f7 / f6), this.p);
            canvas.translate(-10.0f, -10.0f);
        }
        getRootView().invalidate();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            processSingleTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2) {
            processDoubleTouchEvent(motionEvent);
        }
        return true;
    }

    public ZoomViewListener getListener() {
        return this.listener;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public String getMiniMapCaption() {
        return this.miniMapCaption;
    }

    public int getMiniMapCaptionColor() {
        return this.miniMapCaptionColor;
    }

    public float getMiniMapCaptionSize() {
        return this.miniMapCaptionSize;
    }

    public int getMiniMapColor() {
        return this.miniMapColor;
    }

    public int getMiniMapHeight() {
        return this.miniMapHeight;
    }

    public float getZoom() {
        return this.zoom;
    }

    public float getZoomFocusX() {
        return this.zoomX * this.zoom;
    }

    public float getZoomFocusY() {
        return this.zoomY * this.zoom;
    }

    public boolean isMiniMapEnabled() {
        return this.showMinimap;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }

    public void setListner(ZoomViewListener zoomViewListener) {
        this.listener = zoomViewListener;
    }

    public void setMaxZoom(float f2) {
        if (f2 < 1.0f) {
            return;
        }
        this.maxZoom = f2;
    }

    public void setMiniMapCaption(String str) {
        this.miniMapCaption = str;
    }

    public void setMiniMapCaptionColor(int i2) {
        this.miniMapCaptionColor = i2;
    }

    public void setMiniMapCaptionSize(float f2) {
        this.miniMapCaptionSize = f2;
    }

    public void setMiniMapColor(int i2) {
        this.miniMapColor = i2;
    }

    public void setMiniMapEnabled(boolean z) {
        this.showMinimap = z;
    }

    public void setMiniMapHeight(int i2) {
        if (i2 < 0) {
            return;
        }
        this.miniMapHeight = i2;
    }

    public void smoothZoomTo(float f2, float f3, float f4) {
        float clamp = clamp(1.0f, f2, this.maxZoom);
        this.smoothZoom = clamp;
        this.smoothZoomX = f3;
        this.smoothZoomY = f4;
        ZoomViewListener zoomViewListener = this.listener;
        if (zoomViewListener != null) {
            zoomViewListener.onZoomStarted(clamp, f3, f4);
        }
    }

    public void zoomTo(float f2, float f3, float f4) {
        float min = Math.min(f2, this.maxZoom);
        this.zoom = min;
        this.zoomX = f3;
        this.zoomY = f4;
        smoothZoomTo(min, f3, f4);
    }

    public ZoomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zoom = 1.0f;
        this.maxZoom = 3.0f;
        this.smoothZoom = 1.0f;
        this.showMinimap = false;
        this.miniMapColor = -1;
        this.miniMapHeight = -1;
        this.miniMapCaptionSize = 10.0f;
        this.miniMapCaptionColor = -1;
        this.m = new Matrix();
        this.p = new Paint();
    }

    public ZoomView(Context context) {
        super(context);
        this.zoom = 1.0f;
        this.maxZoom = 3.0f;
        this.smoothZoom = 1.0f;
        this.showMinimap = false;
        this.miniMapColor = -1;
        this.miniMapHeight = -1;
        this.miniMapCaptionSize = 10.0f;
        this.miniMapCaptionColor = -1;
        this.m = new Matrix();
        this.p = new Paint();
    }
}
