package com.shix.shixipc.glview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import com.shix.shixipc.utils.CommonUtil;

/* loaded from: classes.dex */
public class MyLiveViewGLMonitor extends HiGLMonitor implements View.OnTouchListener, GestureDetector.OnGestureListener {
    public static final int FLING_MIN_DISTANCE = 50;
    public static final int PTZ_STEP = 25;
    public int bottom;
    public Activity context;
    public int height;
    public float lastX;
    public float lastY;
    public int left;
    public GestureDetector mGestureDetector;
    public View.OnTouchListener mOnTouchListener;
    public Matrix matrix;
    public double nLenStart;
    public OnfigCangeInterface onfigCangeInterface;
    public long ptzTime;
    public int pyl;
    public float rawX;
    public float rawY;
    public float resetHeight;
    public float resetWidth;
    public float screen_height;
    public float screen_width;
    public SurfaceHolder sfh;
    public int state;
    public int touchMoved;
    public int width;
    public int xlenOld;
    public int ylenOld;

    public interface OnfigCangeInterface {
        void CallBackOnfigStatu(int i2);
    }

    public MyLiveViewGLMonitor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ptzTime = 0L;
        this.matrix = new Matrix();
        this.state = 0;
        this.rawX = 0.0f;
        this.rawY = 0.0f;
        this.lastX = 0.0f;
        this.lastY = 0.0f;
        this.pyl = 20;
        this.nLenStart = 0.0d;
        this.mGestureDetector = new GestureDetector(context, this);
        super.setOnTouchListener(this);
        setOnTouchListener(this);
        setFocusable(true);
        setClickable(true);
        setLongClickable(true);
        Activity activity = (Activity) context;
        this.context = activity;
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.screen_width = r4.heightPixels;
        this.screen_height = r4.widthPixels;
    }

    public int getState() {
        return this.state;
    }

    public int getTouchMove() {
        return this.touchMoved;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        CommonUtil.Log(1, "SHIXNEW onFling velocityX: " + Math.abs(f2) + ", velocityY: " + Math.abs(f3));
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ptzTime > 500) {
            this.ptzTime = currentTimeMillis;
            scrollTo((int) f2, (int) f3);
            invalidate();
            if (this.state == 0) {
                if (motionEvent.getX() - motionEvent2.getX() > 50.0f && Math.abs(f2) > Math.abs(f3)) {
                    CommonUtil.Log(1, "SHIXNEW onFling left");
                    OnfigCangeInterface onfigCangeInterface = this.onfigCangeInterface;
                    if (onfigCangeInterface != null) {
                        onfigCangeInterface.CallBackOnfigStatu(0);
                    }
                } else if (motionEvent2.getX() - motionEvent.getX() > 50.0f && Math.abs(f2) > Math.abs(f3)) {
                    CommonUtil.Log(1, "SHIXNEW onFling right");
                    OnfigCangeInterface onfigCangeInterface2 = this.onfigCangeInterface;
                    if (onfigCangeInterface2 != null) {
                        onfigCangeInterface2.CallBackOnfigStatu(1);
                    }
                } else if (motionEvent.getY() - motionEvent2.getY() > 50.0f && Math.abs(f3) > Math.abs(f2)) {
                    CommonUtil.Log(1, "SHIXNEW onFling up");
                    OnfigCangeInterface onfigCangeInterface3 = this.onfigCangeInterface;
                    if (onfigCangeInterface3 != null) {
                        onfigCangeInterface3.CallBackOnfigStatu(2);
                    }
                } else if (motionEvent2.getY() - motionEvent.getY() > 50.0f && Math.abs(f3) > Math.abs(f2)) {
                    CommonUtil.Log(1, "SHIXNEW onFling down");
                    OnfigCangeInterface onfigCangeInterface4 = this.onfigCangeInterface;
                    if (onfigCangeInterface4 != null) {
                        onfigCangeInterface4.CallBackOnfigStatu(3);
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"WrongCall"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        CommonUtil.Log(1, "SHIXZ onTouch12:");
        View.OnTouchListener onTouchListener = this.mOnTouchListener;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        CommonUtil.Log(1, "SHIXZ mMonitor.state=" + this.state);
        int i2 = this.state;
        if (i2 != 1) {
            if (i2 != 0 || pointerCount != 1) {
                return true;
            }
            CommonUtil.Log(1, "SHIXZ mMonitor.mGestureDetector");
            return this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (pointerCount == 2) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            CommonUtil.Log(1, "SHIXZ mMonitor.ACTION_DOWN");
            this.rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            this.rawY = rawY;
            this.lastX = this.rawX;
            this.lastY = rawY;
        } else if (action == 2 && this.touchMoved != 2) {
            CommonUtil.Log(1, "SHIXZ mMonitor.ACTION_MOVE");
            this.rawX = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            this.rawY = rawY2;
            float f2 = this.rawX - this.lastX;
            float f3 = rawY2 - this.lastY;
            if (Math.abs(f2) < this.pyl && Math.abs(f3) < this.pyl) {
                return false;
            }
            int i3 = (int) (this.left + f2);
            this.left = i3;
            this.bottom = (int) (this.bottom - f3);
            if (i3 > 0) {
                this.left = 0;
            }
            if (this.bottom > 0) {
                this.bottom = 0;
            }
            int i4 = this.left;
            int i5 = this.width;
            float f4 = i4 + i5;
            float f5 = this.screen_width;
            if (f4 < f5) {
                this.left = (int) (f5 - i5);
            }
            int i6 = this.bottom;
            int i7 = this.height;
            float f6 = i6 + i7;
            float f7 = this.screen_height;
            if (f6 < f7) {
                this.bottom = (int) (f7 - i7);
            }
            int i8 = this.left;
            int i9 = this.width;
            if (i8 <= (-i9)) {
                this.left = -i9;
            }
            int i10 = this.bottom;
            int i11 = this.height;
            if (i10 <= (-i11)) {
                this.bottom = -i11;
            }
            setMatrix(this.left, this.bottom, this.width, this.height);
            this.lastX = this.rawX;
            this.lastY = this.rawY;
        }
        return true;
    }

    public void saveMatrix(int i2, int i3, int i4, int i5) {
        this.left = i2;
        this.bottom = i3;
        this.width = i4;
        this.height = i5;
    }

    public void setOnFigListener(OnfigCangeInterface onfigCangeInterface) {
        this.onfigCangeInterface = onfigCangeInterface;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setTouchMove(int i2) {
        this.touchMoved = i2;
    }

    public void setView() {
        WindowManager.LayoutParams attributes = this.context.getWindow().getAttributes();
        attributes.flags |= 1024;
        this.context.getWindow().setAttributes(attributes);
        this.context.getWindow().addFlags(512);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f2 = displayMetrics.widthPixels;
        float f3 = displayMetrics.heightPixels;
        if (this.resetWidth == 0.0f) {
            this.resetWidth = f2;
            this.resetHeight = f3;
        }
        this.resetWidth += 100.0f;
        this.resetHeight += 100.0f;
    }
}
