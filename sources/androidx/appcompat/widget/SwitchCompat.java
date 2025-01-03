package androidx.appcompat.widget;

import a.b.f.b0;
import a.b.f.g0;
import a.b.f.m0;
import a.b.f.n;
import a.b.f.r;
import a.h.j.y;
import a.h.k.i;
import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final Property<SwitchCompat, Float> O = new a(Float.class, "thumbPos");
    public static final int[] P = {R.attr.state_checked};
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final TextPaint G;
    public ColorStateList H;
    public Layout I;
    public Layout J;
    public TransformationMethod K;
    public ObjectAnimator L;
    public final n M;
    public final Rect N;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f2356a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f2357b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f2358c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2359d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2360e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2361f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2362g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2363h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2364i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public CharSequence o;
    public CharSequence p;
    public boolean q;
    public int r;
    public int t;
    public float u;
    public float v;
    public VelocityTracker w;
    public int x;
    public float y;
    public int z;

    public class a extends Property<SwitchCompat, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.y);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private boolean getTargetCheckedState() {
        return this.y > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((m0.a(this) ? 1.0f - this.y : this.y) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f2361f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.N;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f2356a;
        Rect d2 = drawable2 != null ? r.d(drawable2) : r.f566c;
        return ((((this.z - this.B) - rect.left) - rect.right) - d2.left) - d2.right;
    }

    public void a(Context context, int i2) {
        g0 a2 = g0.a(context, i2, R$styleable.TextAppearance);
        ColorStateList a3 = a2.a(R$styleable.TextAppearance_android_textColor);
        if (a3 != null) {
            this.H = a3;
        } else {
            this.H = getTextColors();
        }
        int c2 = a2.c(R$styleable.TextAppearance_android_textSize, 0);
        if (c2 != 0) {
            float f2 = c2;
            if (f2 != this.G.getTextSize()) {
                this.G.setTextSize(f2);
                requestLayout();
            }
        }
        a(a2.d(R$styleable.TextAppearance_android_typeface, -1), a2.d(R$styleable.TextAppearance_android_textStyle, -1));
        if (a2.a(R$styleable.TextAppearance_textAllCaps, false)) {
            this.K = new a.b.d.a(getContext());
        } else {
            this.K = null;
        }
        a2.b();
    }

    public final void b() {
        if (this.f2361f != null) {
            if (this.f2364i || this.j) {
                Drawable mutate = a.h.c.l.a.i(this.f2361f).mutate();
                this.f2361f = mutate;
                if (this.f2364i) {
                    a.h.c.l.a.a(mutate, this.f2362g);
                }
                if (this.j) {
                    a.h.c.l.a.a(this.f2361f, this.f2363h);
                }
                if (this.f2361f.isStateful()) {
                    this.f2361f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public final void d() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.p;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.abc_capital_off);
            }
            y.a(this, charSequence);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect rect = this.N;
        int i4 = this.C;
        int i5 = this.D;
        int i6 = this.E;
        int i7 = this.F;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f2356a;
        Rect d2 = drawable != null ? r.d(drawable) : r.f566c;
        Drawable drawable2 = this.f2361f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i8 = rect.left;
            thumbOffset += i8;
            if (d2 != null) {
                int i9 = d2.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = d2.top;
                int i11 = rect.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = d2.right;
                int i13 = rect.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = d2.bottom;
                int i15 = rect.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f2361f.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f2361f.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f2356a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i16 = thumbOffset - rect.left;
            int i17 = thumbOffset + this.B + rect.right;
            this.f2356a.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                a.h.c.l.a.a(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f2356a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, f2, f3);
        }
        Drawable drawable2 = this.f2361f;
        if (drawable2 != null) {
            a.h.c.l.a.a(drawable2, f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2356a;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f2361f;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public final void e() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.o;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.abc_capital_on);
            }
            y.a(this, charSequence);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!m0.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (m0.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.m : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.q;
    }

    public boolean getSplitTrack() {
        return this.n;
    }

    public int getSwitchMinWidth() {
        return this.l;
    }

    public int getSwitchPadding() {
        return this.m;
    }

    public CharSequence getTextOff() {
        return this.p;
    }

    public CharSequence getTextOn() {
        return this.o;
    }

    public Drawable getThumbDrawable() {
        return this.f2356a;
    }

    public int getThumbTextPadding() {
        return this.k;
    }

    public ColorStateList getThumbTintList() {
        return this.f2357b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f2358c;
    }

    public Drawable getTrackDrawable() {
        return this.f2361f;
    }

    public ColorStateList getTrackTintList() {
        return this.f2362g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f2363h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2356a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2361f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.L.end();
        this.L = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, P);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.N;
        Drawable drawable = this.f2361f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.D;
        int i3 = this.F;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f2356a;
        if (drawable != null) {
            if (!this.n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d2 = r.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d2.left;
                rect.right -= d2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.I : this.J;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.H;
            if (colorStateList != null) {
                this.G.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.G.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i4 + i5) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.o : this.p;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        int i8;
        int i9;
        int i10;
        super.onLayout(z, i2, i3, i4, i5);
        int i11 = 0;
        if (this.f2356a != null) {
            Rect rect = this.N;
            Drawable drawable = this.f2361f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d2 = r.d(this.f2356a);
            i6 = Math.max(0, d2.left - rect.left);
            i11 = Math.max(0, d2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (m0.a(this)) {
            i7 = getPaddingLeft() + i6;
            width = ((this.z + i7) - i6) - i11;
        } else {
            width = (getWidth() - getPaddingRight()) - i11;
            i7 = (width - this.z) + i6 + i11;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i8 = this.A;
            i9 = paddingTop - (i8 / 2);
        } else {
            if (gravity == 80) {
                i10 = getHeight() - getPaddingBottom();
                i9 = i10 - this.A;
                this.C = i7;
                this.D = i9;
                this.F = i10;
                this.E = width;
            }
            i9 = getPaddingTop();
            i8 = this.A;
        }
        i10 = i8 + i9;
        this.C = i7;
        this.D = i9;
        this.F = i10;
        this.E = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.q) {
            if (this.I == null) {
                this.I = a(this.o);
            }
            if (this.J == null) {
                this.J = a(this.p);
            }
        }
        Rect rect = this.N;
        Drawable drawable = this.f2356a;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.f2356a.getIntrinsicWidth() - rect.left) - rect.right;
            i5 = this.f2356a.getIntrinsicHeight();
        } else {
            i4 = 0;
            i5 = 0;
        }
        this.B = Math.max(this.q ? Math.max(this.I.getWidth(), this.J.getWidth()) + (this.k * 2) : 0, i4);
        Drawable drawable2 = this.f2361f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.f2361f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.f2356a;
        if (drawable3 != null) {
            Rect d2 = r.d(drawable3);
            i7 = Math.max(i7, d2.left);
            i8 = Math.max(i8, d2.right);
        }
        int max = Math.max(this.l, (this.B * 2) + i7 + i8);
        int max2 = Math.max(i6, i5);
        this.z = max;
        this.A = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.o : this.p;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r0 != 3) goto L44;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.w
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9f
            r2 = 2
            if (r0 == r1) goto L8b
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8b
            goto Lb9
        L16:
            int r0 = r6.r
            if (r0 == r1) goto L57
            if (r0 == r2) goto L1e
            goto Lb9
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.u
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3d
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L39
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3d
        L39:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3d:
            boolean r0 = a.b.f.m0.a(r6)
            if (r0 == 0) goto L44
            float r2 = -r2
        L44:
            float r0 = r6.y
            float r0 = r0 + r2
            float r0 = a(r0, r4, r3)
            float r2 = r6.y
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L56
            r6.u = r7
            r6.setThumbPosition(r0)
        L56:
            return r1
        L57:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.u
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.t
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7d
            float r4 = r6.v
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.t
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb9
        L7d:
            r6.r = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.u = r0
            r6.v = r3
            return r1
        L8b:
            int r0 = r6.r
            if (r0 != r2) goto L96
            r6.b(r7)
            super.onTouchEvent(r7)
            return r1
        L96:
            r0 = 0
            r6.r = r0
            android.view.VelocityTracker r0 = r6.w
            r0.clear()
            goto Lb9
        L9f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb9
            boolean r3 = r6.a(r0, r2)
            if (r3 == 0) goto Lb9
            r6.r = r1
            r6.u = r0
            r6.v = r2
        Lb9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (isChecked) {
            e();
        } else {
            d();
        }
        if (getWindowToken() != null && y.J(this)) {
            a(isChecked);
        } else {
            c();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.q != z) {
            this.q = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.n = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.l = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.G.getTypeface() == null || this.G.getTypeface().equals(typeface)) && (this.G.getTypeface() != null || typeface == null)) {
            return;
        }
        this.G.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.p = charSequence;
        requestLayout();
        if (isChecked()) {
            return;
        }
        d();
    }

    public void setTextOn(CharSequence charSequence) {
        this.o = charSequence;
        requestLayout();
        if (isChecked()) {
            e();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2356a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2356a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f2) {
        this.y = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(a.b.b.a.a.c(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.k = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2357b = colorStateList;
        this.f2359d = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f2358c = mode;
        this.f2360e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2361f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2361f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(a.b.b.a.a.c(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2362g = colorStateList;
        this.f2364i = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f2363h = mode;
        this.j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2356a || drawable == this.f2361f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2357b = null;
        this.f2358c = null;
        this.f2359d = false;
        this.f2360e = false;
        this.f2362g = null;
        this.f2363h = null;
        this.f2364i = false;
        this.j = false;
        this.w = VelocityTracker.obtain();
        this.N = new Rect();
        b0.a(this, getContext());
        this.G = new TextPaint(1);
        Resources resources = getResources();
        this.G.density = resources.getDisplayMetrics().density;
        g0 a2 = g0.a(context, attributeSet, R$styleable.SwitchCompat, i2, 0);
        y.a(this, context, R$styleable.SwitchCompat, attributeSet, a2.a(), i2, 0);
        Drawable b2 = a2.b(R$styleable.SwitchCompat_android_thumb);
        this.f2356a = b2;
        if (b2 != null) {
            b2.setCallback(this);
        }
        Drawable b3 = a2.b(R$styleable.SwitchCompat_track);
        this.f2361f = b3;
        if (b3 != null) {
            b3.setCallback(this);
        }
        this.o = a2.e(R$styleable.SwitchCompat_android_textOn);
        this.p = a2.e(R$styleable.SwitchCompat_android_textOff);
        this.q = a2.a(R$styleable.SwitchCompat_showText, true);
        this.k = a2.c(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.l = a2.c(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.m = a2.c(R$styleable.SwitchCompat_switchPadding, 0);
        this.n = a2.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList a3 = a2.a(R$styleable.SwitchCompat_thumbTint);
        if (a3 != null) {
            this.f2357b = a3;
            this.f2359d = true;
        }
        PorterDuff.Mode a4 = r.a(a2.d(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f2358c != a4) {
            this.f2358c = a4;
            this.f2360e = true;
        }
        if (this.f2359d || this.f2360e) {
            a();
        }
        ColorStateList a5 = a2.a(R$styleable.SwitchCompat_trackTint);
        if (a5 != null) {
            this.f2362g = a5;
            this.f2364i = true;
        }
        PorterDuff.Mode a6 = r.a(a2.d(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f2363h != a6) {
            this.f2363h = a6;
            this.j = true;
        }
        if (this.f2364i || this.j) {
            b();
        }
        int g2 = a2.g(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (g2 != 0) {
            a(context, g2);
        }
        n nVar = new n(this);
        this.M = nVar;
        nVar.a(attributeSet, i2);
        a2.b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.t = viewConfiguration.getScaledTouchSlop();
        this.x = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public final void b(MotionEvent motionEvent) {
        this.r = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.w.computeCurrentVelocity(1000);
            float xVelocity = this.w.getXVelocity();
            if (Math.abs(xVelocity) > this.x) {
                if (!m0.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z = false;
                }
            } else {
                z = getTargetCheckedState();
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        a(motionEvent);
    }

    public final void a(int i2, int i3) {
        Typeface typeface;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 != 2) {
            typeface = i2 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        a(typeface, i3);
    }

    public void a(Typeface typeface, int i2) {
        Typeface create;
        if (i2 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i2);
            } else {
                create = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(create);
            int style = ((create != null ? create.getStyle() : 0) ^ (-1)) & i2;
            this.G.setFakeBoldText((style & 1) != 0);
            this.G.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.G.setFakeBoldText(false);
        this.G.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public final void a() {
        if (this.f2356a != null) {
            if (this.f2359d || this.f2360e) {
                Drawable mutate = a.h.c.l.a.i(this.f2356a).mutate();
                this.f2356a = mutate;
                if (this.f2359d) {
                    a.h.c.l.a.a(mutate, this.f2357b);
                }
                if (this.f2360e) {
                    a.h.c.l.a.a(this.f2356a, this.f2358c);
                }
                if (this.f2356a.isStateful()) {
                    this.f2356a.setState(getDrawableState());
                }
            }
        }
    }

    public final Layout a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.K;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.G, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public final boolean a(float f2, float f3) {
        if (this.f2356a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2356a.getPadding(this.N);
        int i2 = this.D;
        int i3 = this.t;
        int i4 = i2 - i3;
        int i5 = (this.C + thumbOffset) - i3;
        int i6 = this.B + i5;
        Rect rect = this.N;
        return f2 > ((float) i5) && f2 < ((float) (((i6 + rect.left) + rect.right) + i3)) && f3 > ((float) i4) && f3 < ((float) (this.F + i3));
    }

    public final void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    public final void a(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, O, z ? 1.0f : 0.0f);
        this.L = ofFloat;
        ofFloat.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.L.setAutoCancel(true);
        }
        this.L.start();
    }
}
