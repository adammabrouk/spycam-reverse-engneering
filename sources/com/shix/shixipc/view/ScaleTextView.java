package com.shix.shixipc.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utils.MyLogUtils;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class ScaleTextView extends GLSurfaceView implements View.OnTouchListener {
    public static final float SCALE_MAX = 8.0f;
    public static final float SCALE_MIN = 1.0f;
    public double downX;
    public double downY;
    public boolean isCanTouch;
    public double moveDist;
    public double moveRawX;
    public double moveRawY;
    public double moveX;
    public double moveY;
    public double oldDist;
    public int point_num;

    public ScaleTextView(Context context) {
        super(context);
        this.isCanTouch = false;
        this.point_num = 0;
        this.oldDist = 0.0d;
        this.moveDist = 0.0d;
        this.moveX = 0.0d;
        this.moveY = 0.0d;
        this.downX = 0.0d;
        this.downY = 0.0d;
        this.moveRawX = 0.0d;
        this.moveRawY = 0.0d;
    }

    private void setSelfPivot(float f2, float f3) {
        float pivotX = getPivotX() + f2;
        float pivotY = getPivotY() + f3;
        Log.e("lawwingLog", "setPivotX:" + pivotX + "  setPivotY:" + pivotY + "  getWidth:" + getWidth() + "  getHeight:" + getHeight());
        if (pivotX >= 0.0f || pivotY >= 0.0f) {
            if (pivotX > 0.0f && pivotY < 0.0f) {
                if (pivotX > getWidth()) {
                    pivotX = getWidth();
                }
                pivotY = 0.0f;
            } else if (pivotX >= 0.0f || pivotY <= 0.0f) {
                if (pivotX > getWidth()) {
                    pivotX = getWidth();
                }
                if (pivotY > getHeight()) {
                    pivotY = getHeight();
                }
            } else if (pivotY > getHeight()) {
                pivotY = getHeight();
            }
            setPivot(pivotX, pivotY);
        }
        pivotY = 0.0f;
        pivotX = 0.0f;
        setPivot(pivotX, pivotY);
    }

    private double spacing(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return 0.0d;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return Math.sqrt((x * x) + (y * y));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        MyLogUtils.d("ggg", "sss=");
        if (!this.isCanTouch) {
            return false;
        }
        int action = motionEvent.getAction() & ViewfinderView.OPAQUE;
        if (action == 0) {
            this.point_num = 1;
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
        } else if (action == 1) {
            this.point_num = 0;
            this.downX = 0.0d;
            this.downY = 0.0d;
        } else if (action == 2) {
            int i2 = this.point_num;
            if (i2 == 1) {
                double d2 = this.downX;
                double x = motionEvent.getX();
                Double.isNaN(x);
                float f2 = (float) (d2 - x);
                double d3 = this.downY;
                double y = motionEvent.getY();
                Double.isNaN(y);
                this.moveX = motionEvent.getX();
                this.moveY = motionEvent.getY();
                this.moveRawX = motionEvent.getRawX();
                this.moveRawY = motionEvent.getRawY();
                setSelfPivot(f2, (float) (d3 - y));
            } else if (i2 == 2) {
                double spacing = spacing(motionEvent);
                this.moveDist = spacing;
                double d4 = spacing - this.oldDist;
                double scaleX = getScaleX();
                double width = getWidth();
                Double.isNaN(width);
                Double.isNaN(scaleX);
                float f3 = (float) (scaleX + (d4 / width));
                if (f3 > 1.0f && f3 < 8.0f) {
                    setScale(f3);
                } else if (f3 < 1.0f) {
                    setScale(1.0f);
                }
            }
        } else if (action == 5) {
            this.oldDist = spacing(motionEvent);
            this.point_num++;
        } else if (action == 6) {
            this.point_num--;
        }
        return true;
    }

    public void setInitScale() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setPivot(getWidth() / 2, getHeight() / 2);
    }

    public void setIsCanTouch(boolean z) {
        this.isCanTouch = z;
    }

    public void setPivot(float f2, float f3) {
        setPivotX(f2);
        setPivotY(f3);
    }

    public void setScale(float f2) {
        setScaleX(f2);
        setScaleY(f2);
    }

    public ScaleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isCanTouch = false;
        this.point_num = 0;
        this.oldDist = 0.0d;
        this.moveDist = 0.0d;
        this.moveX = 0.0d;
        this.moveY = 0.0d;
        this.downX = 0.0d;
        this.downY = 0.0d;
        this.moveRawX = 0.0d;
        this.moveRawY = 0.0d;
    }
}
