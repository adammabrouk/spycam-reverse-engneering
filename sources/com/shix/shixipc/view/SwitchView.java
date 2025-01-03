package com.shix.shixipc.view;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.shix.lookcam.R$styleable;

/* loaded from: classes.dex */
public class SwitchView extends View {
    public static final int STATE_SWITCH_OFF = 1;
    public static final int STATE_SWITCH_OFF2 = 2;
    public static final int STATE_SWITCH_ON = 4;
    public static final int STATE_SWITCH_ON2 = 3;
    public final float ANIMATION_SPEED;
    public final int DEFAULT_COLOR_PRIMARY;
    public final int DEFAULT_COLOR_PRIMARY_DARK;
    public final float RATIO_ASPECT;
    public int actuallyDrawingAreaBottom;
    public int actuallyDrawingAreaLeft;
    public int actuallyDrawingAreaRight;
    public int actuallyDrawingAreaTop;
    public float bAnim;
    public float bBottom;
    public float bLeft;
    public float bOff2LeftX;
    public float bOffLeftX;
    public float bOffset;
    public float bOn2LeftX;
    public float bOnLeftX;
    public final Path bPath;
    public float bRadius;
    public final RectF bRectF;
    public float bRight;
    public float bStrokeWidth;
    public float bTop;
    public float bWidth;
    public int colorPrimary;
    public int colorPrimaryDark;
    public boolean hasShadow;
    public final AccelerateInterpolator interpolator;
    public boolean isCanVisibleDrawing;
    public boolean isOpened;
    public int lastState;
    public OnStateChangedListener listener;
    public int mHeight;
    public View.OnClickListener mOnClickListener;
    public int mWidth;
    public final Paint paint;
    public float sAnim;
    public float sBottom;
    public float sCenterX;
    public float sCenterY;
    public float sHeight;
    public float sLeft;
    public final Path sPath;
    public float sRight;
    public float sScale;
    public float sTop;
    public float sWidth;
    public RadialGradient shadowGradient;
    public float shadowReservedHeight;
    public int state;

    public interface OnStateChangedListener {
        void toggleToOff(SwitchView switchView);

        void toggleToOn(SwitchView switchView);
    }

    @SuppressLint({"ParcelCreator"})
    public static final class SavedState extends View.BaseSavedState {
        public boolean isOpened;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.isOpened ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.isOpened = 1 == parcel.readInt();
        }
    }

    public SwitchView(Context context) {
        this(context, null);
    }

    private void calcBPath(float f2) {
        this.bPath.reset();
        RectF rectF = this.bRectF;
        float f3 = this.bLeft;
        float f4 = this.bStrokeWidth;
        rectF.left = f3 + (f4 / 2.0f);
        rectF.right = this.bRight - (f4 / 2.0f);
        this.bPath.arcTo(rectF, 90.0f, 180.0f);
        RectF rectF2 = this.bRectF;
        float f5 = this.bLeft;
        float f6 = this.bOffset;
        float f7 = this.bStrokeWidth;
        rectF2.left = f5 + (f2 * f6) + (f7 / 2.0f);
        rectF2.right = (this.bRight + (f2 * f6)) - (f7 / 2.0f);
        this.bPath.arcTo(rectF2, 270.0f, 180.0f);
        this.bPath.close();
    }

    private float calcBTranslate(float f2) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int i2 = this.state;
        int i3 = i2 - this.lastState;
        if (i3 != -3) {
            if (i3 != -2) {
                if (i3 != -1) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            if (i2 == 4) {
                                f6 = this.bOnLeftX;
                                f7 = this.bOffLeftX;
                            } else {
                                if (i2 == 4) {
                                    f6 = this.bOn2LeftX;
                                    f7 = this.bOffLeftX;
                                }
                                f5 = 0.0f;
                            }
                            f5 = f6 - ((f6 - f7) * f2);
                        } else if (i3 == 3) {
                            f6 = this.bOnLeftX;
                            f7 = this.bOffLeftX;
                            f5 = f6 - ((f6 - f7) * f2);
                        } else if (i2 == 1) {
                            f5 = this.bOffLeftX;
                        } else {
                            if (i2 == 4) {
                                f5 = this.bOnLeftX;
                            }
                            f5 = 0.0f;
                        }
                    } else if (i2 == 2) {
                        f5 = this.bOffLeftX;
                    } else {
                        if (i2 == 4) {
                            f6 = this.bOnLeftX;
                            f7 = this.bOn2LeftX;
                            f5 = f6 - ((f6 - f7) * f2);
                        }
                        f5 = 0.0f;
                    }
                } else if (i2 == 3) {
                    f3 = this.bOn2LeftX;
                    f4 = this.bOnLeftX;
                } else {
                    if (i2 == 1) {
                        f5 = this.bOffLeftX;
                    }
                    f5 = 0.0f;
                }
            } else if (i2 == 1) {
                f3 = this.bOffLeftX;
                f4 = this.bOn2LeftX;
            } else {
                if (i2 == 2) {
                    f3 = this.bOff2LeftX;
                    f4 = this.bOnLeftX;
                }
                f5 = 0.0f;
            }
            return f5 - this.bOffLeftX;
        }
        f3 = this.bOffLeftX;
        f4 = this.bOnLeftX;
        f5 = f3 + ((f4 - f3) * f2);
        return f5 - this.bOffLeftX;
    }

    private void refreshState(int i2) {
        if (!this.isOpened && i2 == 4) {
            this.isOpened = true;
        } else if (this.isOpened && i2 == 1) {
            this.isOpened = false;
        }
        this.lastState = this.state;
        this.state = i2;
        postInvalidate();
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isCanVisibleDrawing) {
            boolean z = true;
            this.paint.setAntiAlias(true);
            int i2 = this.state;
            boolean z2 = i2 == 4 || i2 == 3;
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(z2 ? this.colorPrimary : -1842205);
            canvas.drawPath(this.sPath, this.paint);
            float f2 = this.sAnim;
            this.sAnim = f2 - 0.1f > 0.0f ? f2 - 0.1f : 0.0f;
            float f3 = this.bAnim;
            this.bAnim = f3 - 0.1f > 0.0f ? f3 - 0.1f : 0.0f;
            float interpolation = this.interpolator.getInterpolation(this.sAnim);
            float interpolation2 = this.interpolator.getInterpolation(this.bAnim);
            float f4 = this.sScale * (z2 ? interpolation : 1.0f - interpolation);
            float f5 = (this.sRight - this.sCenterX) - this.bRadius;
            if (z2) {
                interpolation = 1.0f - interpolation;
            }
            canvas.save();
            canvas.scale(f4, f4, this.sCenterX + (f5 * interpolation), this.sCenterY);
            this.paint.setColor(-1);
            canvas.drawPath(this.sPath, this.paint);
            canvas.restore();
            canvas.save();
            canvas.translate(calcBTranslate(interpolation2), this.shadowReservedHeight);
            int i3 = this.state;
            if (i3 != 3 && i3 != 2) {
                z = false;
            }
            if (z) {
                interpolation2 = 1.0f - interpolation2;
            }
            calcBPath(interpolation2);
            if (this.hasShadow) {
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(-13421773);
                this.paint.setShader(this.shadowGradient);
                canvas.drawPath(this.bPath, this.paint);
                this.paint.setShader(null);
            }
            canvas.translate(0.0f, -this.shadowReservedHeight);
            float f6 = this.bWidth;
            canvas.scale(0.98f, 0.98f, f6 / 2.0f, f6 / 2.0f);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(-1);
            canvas.drawPath(this.bPath, this.paint);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.bStrokeWidth * 0.5f);
            this.paint.setColor(z2 ? this.colorPrimaryDark : -4210753);
            canvas.drawPath(this.bPath, this.paint);
            canvas.restore();
            this.paint.reset();
            if (this.sAnim > 0.0f || this.bAnim > 0.0f) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            int paddingLeft = ((int) ((getResources().getDisplayMetrics().density * 56.0f) + 0.5f)) + getPaddingLeft() + getPaddingRight();
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 != 1073741824) {
            int paddingTop = ((int) (size * 0.68f)) + getPaddingTop() + getPaddingBottom();
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(paddingTop, size2) : paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z = savedState.isOpened;
        this.isOpened = z;
        this.state = z ? 4 : 1;
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpened = this.isOpened;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mWidth = i2;
        this.mHeight = i3;
        boolean z = i2 > getPaddingLeft() + getPaddingRight() && this.mHeight > getPaddingTop() + getPaddingBottom();
        this.isCanVisibleDrawing = z;
        if (z) {
            float paddingLeft = (this.mWidth - getPaddingLeft()) - getPaddingRight();
            float f2 = paddingLeft * 0.68f;
            float paddingTop = (this.mHeight - getPaddingTop()) - getPaddingBottom();
            if (f2 < paddingTop) {
                this.actuallyDrawingAreaLeft = getPaddingLeft();
                this.actuallyDrawingAreaRight = this.mWidth - getPaddingRight();
                int i6 = ((int) (paddingTop - f2)) / 2;
                this.actuallyDrawingAreaTop = getPaddingTop() + i6;
                this.actuallyDrawingAreaBottom = (getHeight() - getPaddingBottom()) - i6;
            } else {
                int i7 = ((int) (paddingLeft - (paddingTop / 0.68f))) / 2;
                this.actuallyDrawingAreaLeft = getPaddingLeft() + i7;
                this.actuallyDrawingAreaRight = (getWidth() - getPaddingRight()) - i7;
                this.actuallyDrawingAreaTop = getPaddingTop();
                this.actuallyDrawingAreaBottom = getHeight() - getPaddingBottom();
            }
            int i8 = this.actuallyDrawingAreaBottom;
            int i9 = this.actuallyDrawingAreaTop;
            float f3 = (int) ((i8 - i9) * 0.09f);
            this.shadowReservedHeight = f3;
            float f4 = this.actuallyDrawingAreaLeft;
            this.sLeft = f4;
            float f5 = i9 + f3;
            this.sTop = f5;
            float f6 = this.actuallyDrawingAreaRight;
            this.sRight = f6;
            float f7 = i8 - f3;
            this.sBottom = f7;
            this.sWidth = f6 - f4;
            float f8 = f7 - f5;
            this.sHeight = f8;
            this.sCenterX = (f6 + f4) / 2.0f;
            this.sCenterY = (f7 + f5) / 2.0f;
            this.bLeft = f4;
            this.bTop = f5;
            this.bBottom = f7;
            float f9 = f7 - f5;
            this.bWidth = f9;
            this.bRight = f4 + f9;
            float f10 = f9 / 2.0f;
            float f11 = 0.95f * f10;
            this.bRadius = f11;
            float f12 = 0.0f * f11;
            this.bOffset = f12;
            float f13 = (f10 - f11) * 2.0f;
            this.bStrokeWidth = f13;
            float f14 = f6 - f9;
            this.bOnLeftX = f14;
            this.bOn2LeftX = f14 - f12;
            this.bOffLeftX = f4;
            this.bOff2LeftX = f4 + f12;
            this.sScale = 1.0f - (f13 / f8);
            this.sPath.reset();
            RectF rectF = new RectF();
            rectF.top = this.sTop;
            rectF.bottom = this.sBottom;
            float f15 = this.sLeft;
            rectF.left = f15;
            rectF.right = f15 + this.sHeight;
            this.sPath.arcTo(rectF, 90.0f, 180.0f);
            float f16 = this.sRight;
            rectF.left = f16 - this.sHeight;
            rectF.right = f16;
            this.sPath.arcTo(rectF, 270.0f, 180.0f);
            this.sPath.close();
            RectF rectF2 = this.bRectF;
            float f17 = this.bLeft;
            rectF2.left = f17;
            float f18 = this.bRight;
            rectF2.right = f18;
            float f19 = this.bTop;
            float f20 = this.bStrokeWidth;
            rectF2.top = (f20 / 2.0f) + f19;
            float f21 = this.bBottom;
            rectF2.bottom = f21 - (f20 / 2.0f);
            this.shadowGradient = new RadialGradient((f18 + f17) / 2.0f, (f21 + f19) / 2.0f, this.bRadius, -16777216, 0, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2 = this.state;
        if ((i2 == 4 || i2 == 1) && this.sAnim * this.bAnim == 0.0f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                return true;
            }
            if (action == 1) {
                int i3 = this.state;
                this.lastState = i3;
                this.bAnim = 1.0f;
                if (i3 == 1) {
                    refreshState(2);
                    this.listener.toggleToOn(this);
                } else if (i3 == 4) {
                    refreshState(3);
                    this.listener.toggleToOff(this);
                }
                View.OnClickListener onClickListener = this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setColor(int i2, int i3) {
        this.colorPrimary = i2;
        this.colorPrimaryDark = i3;
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        if (onStateChangedListener == null) {
            throw new IllegalArgumentException("empty listener");
        }
        this.listener = onStateChangedListener;
    }

    public void setOpened(boolean z) {
        int i2 = z ? 4 : 1;
        if (i2 == this.state) {
            return;
        }
        refreshState(i2);
    }

    public void setShadow(boolean z) {
        this.hasShadow = z;
        invalidate();
    }

    public void toggleSwitch(boolean z) {
        int i2;
        int i3 = z ? 4 : 1;
        int i4 = this.state;
        if (i3 == i4) {
            return;
        }
        if ((i3 == 4 && (i4 == 1 || i4 == 2)) || (i3 == 1 && ((i2 = this.state) == 4 || i2 == 3))) {
            this.sAnim = 1.0f;
        }
        this.bAnim = 1.0f;
        refreshState(i3);
    }

    @TargetApi(11)
    public SwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_COLOR_PRIMARY = -11806877;
        this.DEFAULT_COLOR_PRIMARY_DARK = -12925358;
        this.RATIO_ASPECT = 0.68f;
        this.ANIMATION_SPEED = 0.1f;
        this.interpolator = new AccelerateInterpolator(2.0f);
        this.paint = new Paint();
        this.sPath = new Path();
        this.bPath = new Path();
        this.bRectF = new RectF();
        this.isCanVisibleDrawing = false;
        this.listener = new OnStateChangedListener() { // from class: com.shix.shixipc.view.SwitchView.1
            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOff(SwitchView switchView) {
                SwitchView.this.toggleSwitch(false);
            }

            @Override // com.shix.shixipc.view.SwitchView.OnStateChangedListener
            public void toggleToOn(SwitchView switchView) {
                SwitchView.this.toggleSwitch(true);
            }
        };
        setLayerType(1, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SwitchView);
        this.colorPrimary = obtainStyledAttributes.getColor(2, -11806877);
        this.colorPrimaryDark = obtainStyledAttributes.getColor(3, -12925358);
        this.hasShadow = obtainStyledAttributes.getBoolean(0, true);
        boolean z = obtainStyledAttributes.getBoolean(1, false);
        this.isOpened = z;
        int i2 = z ? 4 : 1;
        this.state = i2;
        this.lastState = i2;
        obtainStyledAttributes.recycle();
        if (this.colorPrimary == -11806877 && this.colorPrimaryDark == -12925358) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
                    if (typedValue.data > 0) {
                        this.colorPrimary = typedValue.data;
                    }
                    TypedValue typedValue2 = new TypedValue();
                    context.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue2, true);
                    if (typedValue2.data > 0) {
                        this.colorPrimaryDark = typedValue2.data;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
