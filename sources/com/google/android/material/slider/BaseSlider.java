package com.google.android.material.slider;

import a.h.j.h0.c;
import a.h.j.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import c.c.a.c.r.l;
import c.c.a.c.r.q;
import c.c.a.c.r.r;
import c.c.a.c.w.h;
import c.c.a.c.w.m;
import c.c.a.c.x.a;
import c.c.a.c.x.b;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.slider.BaseSlider;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends c.c.a.c.x.a<S>, T extends c.c.a.c.x.b<S>> extends View {
    public static final String T = BaseSlider.class.getSimpleName();
    public static final int U = R$style.Widget_MaterialComponents_Slider;
    public boolean A;
    public float B;
    public float C;
    public ArrayList<Float> D;
    public int E;
    public int F;
    public float G;
    public float[] H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ColorStateList M;
    public ColorStateList N;
    public ColorStateList O;
    public ColorStateList P;
    public ColorStateList Q;
    public final h R;
    public float S;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f10569a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f10570b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f10571c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f10572d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f10573e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f10574f;

    /* renamed from: g, reason: collision with root package name */
    public final c f10575g;

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f10576h;

    /* renamed from: i, reason: collision with root package name */
    public BaseSlider<S, L, T>.b f10577i;
    public final d j;
    public final List<c.c.a.c.b0.a> k;
    public final List<L> l;
    public final List<T> m;
    public final int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public MotionEvent y;
    public c.c.a.c.x.c z;

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public float f10578a;

        /* renamed from: b, reason: collision with root package name */
        public float f10579b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<Float> f10580c;

        /* renamed from: d, reason: collision with root package name */
        public float f10581d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10582e;

        public static class a implements Parcelable.Creator<SliderState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SliderState[] newArray(int i2) {
                return new SliderState[i2];
            }
        }

        public /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f10578a);
            parcel.writeFloat(this.f10579b);
            parcel.writeList(this.f10580c);
            parcel.writeFloat(this.f10581d);
            parcel.writeBooleanArray(new boolean[]{this.f10582e});
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        public SliderState(Parcel parcel) {
            super(parcel);
            this.f10578a = parcel.readFloat();
            this.f10579b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f10580c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f10581d = parcel.readFloat();
            this.f10582e = parcel.createBooleanArray()[0];
        }
    }

    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttributeSet f10583a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10584b;

        public a(AttributeSet attributeSet, int i2) {
            this.f10583a = attributeSet;
            this.f10584b = i2;
        }

        @Override // com.google.android.material.slider.BaseSlider.d
        public c.c.a.c.b0.a a() {
            TypedArray c2 = l.c(BaseSlider.this.getContext(), this.f10583a, R$styleable.Slider, this.f10584b, BaseSlider.U, new int[0]);
            c.c.a.c.b0.a b2 = BaseSlider.b(BaseSlider.this.getContext(), c2);
            c2.recycle();
            return b2;
        }
    }

    public interface d {
        c.c.a.c.b0.a a();
    }

    public BaseSlider(Context context) {
        this(context, null);
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.D.size() == 1) {
            floatValue2 = this.B;
        }
        float b2 = b(floatValue2);
        float b3 = b(floatValue);
        return j() ? new float[]{b3, b2} : new float[]{b2, b3};
    }

    private float getValueOfTouchPosition() {
        double d2 = d(this.S);
        if (j()) {
            d2 = 1.0d - d2;
        }
        float f2 = this.C;
        float f3 = this.B;
        double d3 = f2 - f3;
        Double.isNaN(d3);
        double d4 = f3;
        Double.isNaN(d4);
        return (float) ((d2 * d3) + d4);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.S;
        if (j()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.C;
        float f4 = this.B;
        return (f2 * (f3 - f4)) + f4;
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.D.size() == arrayList.size() && this.D.equals(arrayList)) {
            return;
        }
        this.D = arrayList;
        this.L = true;
        this.F = 0;
        p();
        d();
        e();
        postInvalidate();
    }

    public void addOnChangeListener(L l) {
        this.l.add(l);
    }

    public void addOnSliderTouchListener(T t) {
        this.m.add(t);
    }

    public final int c() {
        return this.t + (this.p == 1 ? this.k.get(0).getIntrinsicHeight() : 0);
    }

    public final void d() {
        if (this.k.size() > this.D.size()) {
            List<c.c.a.c.b0.a> subList = this.k.subList(this.D.size(), this.k.size());
            for (c.c.a.c.b0.a aVar : subList) {
                if (y.I(this)) {
                    b(aVar);
                }
            }
            subList.clear();
        }
        while (this.k.size() < this.D.size()) {
            c.c.a.c.b0.a a2 = this.j.a();
            this.k.add(a2);
            if (y.I(this)) {
                a(a2);
            }
        }
        int i2 = this.k.size() == 1 ? 0 : 1;
        Iterator<c.c.a.c.b0.a> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().e(i2);
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f10575g.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f10569a.setColor(a(this.Q));
        this.f10570b.setColor(a(this.P));
        this.f10573e.setColor(a(this.O));
        this.f10574f.setColor(a(this.N));
        for (c.c.a.c.b0.a aVar : this.k) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.R.isStateful()) {
            this.R.setState(getDrawableState());
        }
        this.f10572d.setColor(a(this.M));
        this.f10572d.setAlpha(63);
    }

    public final boolean e(float f2) {
        double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.B))).divide(new BigDecimal(Float.toString(this.G)), MathContext.DECIMAL64).doubleValue();
        double round = Math.round(doubleValue);
        Double.isNaN(round);
        return Math.abs(round - doubleValue) < 1.0E-4d;
    }

    public final float f(float f2) {
        return (b(f2) * this.I) + this.r;
    }

    public boolean g() {
        return this.z != null;
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f10575g.d();
    }

    public int getActiveThumbIndex() {
        return this.E;
    }

    public int getFocusedThumbIndex() {
        return this.F;
    }

    public int getHaloRadius() {
        return this.v;
    }

    public ColorStateList getHaloTintList() {
        return this.M;
    }

    public int getLabelBehavior() {
        return this.p;
    }

    public float getStepSize() {
        return this.G;
    }

    public float getThumbElevation() {
        return this.R.g();
    }

    public int getThumbRadius() {
        return this.u;
    }

    public ColorStateList getThumbTintList() {
        return this.R.h();
    }

    public ColorStateList getTickActiveTintList() {
        return this.N;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.O;
    }

    public ColorStateList getTickTintList() {
        if (this.O.equals(this.N)) {
            return this.N;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.P;
    }

    public int getTrackHeight() {
        return this.q;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.Q;
    }

    public int getTrackSidePadding() {
        return this.r;
    }

    public ColorStateList getTrackTintList() {
        if (this.Q.equals(this.P)) {
            return this.P;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.I;
    }

    public float getValueFrom() {
        return this.B;
    }

    public float getValueTo() {
        return this.C;
    }

    public List<Float> getValues() {
        return new ArrayList(this.D);
    }

    public final void h() {
        this.f10569a.setStrokeWidth(this.q);
        this.f10570b.setStrokeWidth(this.q);
        this.f10573e.setStrokeWidth(this.q / 2.0f);
        this.f10574f.setStrokeWidth(this.q / 2.0f);
    }

    public final boolean i() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        return y.q(this) == 1;
    }

    public final void k() {
        Iterator<T> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final void l() {
        Iterator<T> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public boolean m() {
        if (this.E != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float f2 = f(valueOfTouchPositionAbsolute);
        this.E = 0;
        float abs = Math.abs(this.D.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i2 = 1; i2 < this.D.size(); i2++) {
            float abs2 = Math.abs(this.D.get(i2).floatValue() - valueOfTouchPositionAbsolute);
            float f3 = f(this.D.get(i2).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z = !j() ? f3 - f2 >= 0.0f : f3 - f2 <= 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.E = i2;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (Math.abs(f3 - f2) < this.n) {
                        this.E = -1;
                        return false;
                    }
                    if (z) {
                        this.E = i2;
                    }
                }
            }
            abs = abs2;
        }
        return this.E != -1;
    }

    public final boolean n() {
        return this.J || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    public final boolean o() {
        return c(getValueOfTouchPosition());
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<c.c.a.c.b0.a> it = this.k.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.b bVar = this.f10577i;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        Iterator<c.c.a.c.b0.a> it = this.k.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.L) {
            q();
            if (this.G > 0.0f) {
                b();
            }
        }
        super.onDraw(canvas);
        int c2 = c();
        b(canvas, this.I, c2);
        if (((Float) Collections.max(getValues())).floatValue() > this.B) {
            a(canvas, this.I, c2);
        }
        if (this.G > 0.0f) {
            a(canvas);
        }
        if ((this.A || isFocused()) && isEnabled()) {
            d(canvas, this.I, c2);
            if (this.E != -1) {
                f();
            }
        }
        c(canvas, this.I, c2);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z) {
            d(i2);
            this.f10575g.h(this.F);
            return;
        }
        this.E = -1;
        Iterator<c.c.a.c.b0.a> it = this.k.iterator();
        while (it.hasNext()) {
            r.b(this).b(it.next());
        }
        this.f10575g.b(this.F);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.D.size() == 1) {
            this.E = 0;
        }
        if (this.E == -1) {
            Boolean a2 = a(i2, keyEvent);
            return a2 != null ? a2.booleanValue() : super.onKeyDown(i2, keyEvent);
        }
        this.K |= keyEvent.isLongPress();
        Float a3 = a(i2);
        if (a3 != null) {
            if (c(this.D.get(this.E).floatValue() + a3.floatValue())) {
                p();
                postInvalidate();
            }
            return true;
        }
        if (i2 != 23) {
            if (i2 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return e(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return e(-1);
                }
                return false;
            }
            if (i2 != 66) {
                return super.onKeyDown(i2, keyEvent);
            }
        }
        this.E = -1;
        Iterator<c.c.a.c.b0.a> it = this.k.iterator();
        while (it.hasNext()) {
            r.b(this).b(it.next());
        }
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        this.K = false;
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.o + (this.p == 1 ? this.k.get(0).getIntrinsicHeight() : 0), MemoryConstants.GB));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.B = sliderState.f10578a;
        this.C = sliderState.f10579b;
        setValuesInternal(sliderState.f10580c);
        this.G = sliderState.f10581d;
        if (sliderState.f10582e) {
            requestFocus();
        }
        e();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f10578a = this.B;
        sliderState.f10579b = this.C;
        sliderState.f10580c = new ArrayList<>(this.D);
        sliderState.f10581d = this.G;
        sliderState.f10582e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.I = Math.max(i2 - (this.r * 2), 0);
        if (this.G > 0.0f) {
            b();
        }
        p();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float f2 = (x - this.r) / this.I;
        this.S = f2;
        float max = Math.max(0.0f, f2);
        this.S = max;
        this.S = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.x = x;
            if (!i()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (m()) {
                    requestFocus();
                    this.A = true;
                    o();
                    p();
                    invalidate();
                    k();
                }
            }
        } else if (actionMasked == 1) {
            this.A = false;
            MotionEvent motionEvent2 = this.y;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.y.getX() - motionEvent.getX()) <= this.n && Math.abs(this.y.getY() - motionEvent.getY()) <= this.n) {
                m();
            }
            if (this.E != -1) {
                o();
                this.E = -1;
            }
            Iterator<c.c.a.c.b0.a> it = this.k.iterator();
            while (it.hasNext()) {
                r.b(this).b(it.next());
            }
            l();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.A) {
                if (Math.abs(x - this.x) < this.n) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                k();
            }
            if (m()) {
                this.A = true;
                o();
                p();
                invalidate();
            }
        }
        setPressed(this.A);
        this.y = MotionEvent.obtain(motionEvent);
        return true;
    }

    public final void p() {
        if (n() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int b2 = (int) ((b(this.D.get(this.F).floatValue()) * this.I) + this.r);
            int c2 = c();
            int i2 = this.v;
            a.h.c.l.a.a(background, b2 - i2, c2 - i2, b2 + i2, c2 + i2);
        }
    }

    public final void q() {
        if (this.L) {
            s();
            t();
            r();
            u();
            v();
            this.L = false;
        }
    }

    public final void r() {
        if (this.G > 0.0f && !e(this.C)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(this.G), Float.toString(this.B), Float.toString(this.C)));
        }
    }

    public void removeOnChangeListener(L l) {
        this.l.remove(l);
    }

    public void removeOnSliderTouchListener(T t) {
        this.m.remove(t);
    }

    public final void s() {
        if (this.B >= this.C) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.toString(this.B), Float.toString(this.C)));
        }
    }

    public void setActiveThumbIndex(int i2) {
        this.E = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.D.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.F = i2;
        this.f10575g.h(i2);
        postInvalidate();
    }

    public void setHaloRadius(int i2) {
        if (i2 == this.v) {
            return;
        }
        this.v = i2;
        Drawable background = getBackground();
        if (n() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            c.c.a.c.n.a.a((RippleDrawable) background, this.v);
        }
    }

    public void setHaloRadiusResource(int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.M)) {
            return;
        }
        this.M = colorStateList;
        Drawable background = getBackground();
        if (!n() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f10572d.setColor(a(colorStateList));
        this.f10572d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i2) {
        if (this.p != i2) {
            this.p = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(c.c.a.c.x.c cVar) {
        this.z = cVar;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(f2), Float.toString(this.B), Float.toString(this.C)));
        }
        if (this.G != f2) {
            this.G = f2;
            this.L = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        this.R.b(f2);
    }

    public void setThumbElevationResource(int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbRadius(int i2) {
        if (i2 == this.u) {
            return;
        }
        this.u = i2;
        h hVar = this.R;
        m.b n = m.n();
        n.a(0, this.u);
        hVar.setShapeAppearanceModel(n.a());
        h hVar2 = this.R;
        int i3 = this.u;
        hVar2.setBounds(0, 0, i3 * 2, i3 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.R.a(colorStateList);
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.N)) {
            return;
        }
        this.N = colorStateList;
        this.f10574f.setColor(a(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.O)) {
            return;
        }
        this.O = colorStateList;
        this.f10573e.setColor(a(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.P)) {
            return;
        }
        this.P = colorStateList;
        this.f10570b.setColor(a(colorStateList));
        invalidate();
    }

    public void setTrackHeight(int i2) {
        if (this.q != i2) {
            this.q = i2;
            h();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.Q)) {
            return;
        }
        this.Q = colorStateList;
        this.f10569a.setColor(a(colorStateList));
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.B = f2;
        this.L = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.C = f2;
        this.L = true;
        postInvalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public final void t() {
        if (this.C <= this.B) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.toString(this.C), Float.toString(this.B)));
        }
    }

    public final void u() {
        Iterator<Float> it = this.D.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() < this.B || next.floatValue() > this.C) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", Float.toString(next.floatValue()), Float.toString(this.B), Float.toString(this.C)));
            }
            if (this.G > 0.0f && !e(next.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", Float.toString(next.floatValue()), Float.toString(this.B), Float.toString(this.G), Float.toString(this.G)));
            }
        }
    }

    public final void v() {
        float f2 = this.G;
        if (f2 == 0.0f) {
            return;
        }
        if (((int) f2) != f2) {
            Log.w(T, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "stepSize", Float.valueOf(f2)));
        }
        float f3 = this.B;
        if (((int) f3) != f3) {
            Log.w(T, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueFrom", Float.valueOf(f3)));
        }
        float f4 = this.C;
        if (((int) f4) != f4) {
            Log.w(T, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueTo", Float.valueOf(f4)));
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f10586a;

        public b() {
            this.f10586a = -1;
        }

        public void a(int i2) {
            this.f10586a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f10575g.d(this.f10586a, 4);
        }

        public /* synthetic */ b(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    public static c.c.a.c.b0.a b(Context context, TypedArray typedArray) {
        return c.c.a.c.b0.a.a(context, (AttributeSet) null, 0, typedArray.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip));
    }

    public final void f() {
        if (this.p == 2) {
            return;
        }
        Iterator<c.c.a.c.b0.a> it = this.k.iterator();
        for (int i2 = 0; i2 < this.D.size() && it.hasNext(); i2++) {
            if (i2 != this.F) {
                a(it.next(), this.D.get(i2).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.k.size()), Integer.valueOf(this.D.size())));
        }
        a(it.next(), this.D.get(this.F).floatValue());
    }

    public final void g(int i2) {
        BaseSlider<S, L, T>.b bVar = this.f10577i;
        if (bVar == null) {
            this.f10577i = new b(this, null);
        } else {
            removeCallbacks(bVar);
        }
        this.f10577i.a(i2);
        postDelayed(this.f10577i, 200L);
    }

    public static class c extends a.j.a.a {
        public final BaseSlider<?, ?, ?> q;
        public Rect r;

        public c(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.r = new Rect();
            this.q = baseSlider;
        }

        @Override // a.j.a.a
        public int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.q.getValues().size(); i2++) {
                this.q.a(i2, this.r);
                if (this.r.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        public final String k(int i2) {
            return i2 == this.q.getValues().size() + (-1) ? this.q.getContext().getString(R$string.material_slider_range_end) : i2 == 0 ? this.q.getContext().getString(R$string.material_slider_range_start) : "";
        }

        @Override // a.j.a.a
        public void a(List<Integer> list) {
            for (int i2 = 0; i2 < this.q.getValues().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        @Override // a.j.a.a
        public void a(int i2, a.h.j.h0.c cVar) {
            cVar.a(c.a.o);
            List<Float> values = this.q.getValues();
            float floatValue = values.get(i2).floatValue();
            float valueFrom = this.q.getValueFrom();
            float valueTo = this.q.getValueTo();
            if (this.q.isEnabled()) {
                if (floatValue > valueFrom) {
                    cVar.a(8192);
                }
                if (floatValue < valueTo) {
                    cVar.a(4096);
                }
            }
            cVar.a(c.d.a(1, valueFrom, valueTo, floatValue));
            cVar.a((CharSequence) SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.q.getContentDescription() != null) {
                sb.append(this.q.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(k(i2));
                sb.append(this.q.a(floatValue));
            }
            cVar.b((CharSequence) sb.toString());
            this.q.a(i2, this.r);
            cVar.c(this.r);
        }

        @Override // a.j.a.a
        public boolean a(int i2, int i3, Bundle bundle) {
            if (!this.q.isEnabled()) {
                return false;
            }
            if (i3 == 4096 || i3 == 8192) {
                float b2 = this.q.b(20);
                if (i3 == 8192) {
                    b2 = -b2;
                }
                if (this.q.j()) {
                    b2 = -b2;
                }
                if (!this.q.b(i2, a.h.e.a.a(this.q.getValues().get(i2).floatValue() + b2, this.q.getValueFrom(), this.q.getValueTo()))) {
                    return false;
                }
                this.q.p();
                this.q.postInvalidate();
                e(i2);
                return true;
            }
            if (i3 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                if (this.q.b(i2, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                    this.q.p();
                    this.q.postInvalidate();
                    e(i2);
                    return true;
                }
            }
            return false;
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, U), attributeSet, i2);
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.A = false;
        this.D = new ArrayList<>();
        this.E = -1;
        this.F = -1;
        this.G = 0.0f;
        this.K = false;
        this.R = new h();
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f10569a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f10569a.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f10570b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f10570b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.f10571c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f10571c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f10572d = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f10573e = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        this.f10573e.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f10574f = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        this.f10574f.setStrokeCap(Paint.Cap.ROUND);
        a(context2.getResources());
        this.j = new a(attributeSet, i2);
        a(context2, attributeSet, i2);
        setFocusable(true);
        setClickable(true);
        this.R.d(2);
        this.n = ViewConfiguration.get(context2).getScaledTouchSlop();
        c cVar = new c(this);
        this.f10575g = cVar;
        y.a(this, cVar);
        this.f10576h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public final void c(Canvas canvas, int i2, int i3) {
        if (!isEnabled()) {
            Iterator<Float> it = this.D.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.r + (b(it.next().floatValue()) * i2), i3, this.u, this.f10571c);
            }
        }
        Iterator<Float> it2 = this.D.iterator();
        while (it2.hasNext()) {
            Float next = it2.next();
            canvas.save();
            int b2 = this.r + ((int) (b(next.floatValue()) * i2));
            int i4 = this.u;
            canvas.translate(b2 - i4, i3 - i4);
            this.R.draw(canvas);
            canvas.restore();
        }
    }

    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    public final void b(c.c.a.c.b0.a aVar) {
        q b2 = r.b(this);
        if (b2 != null) {
            b2.b(aVar);
            aVar.a(r.a(this));
        }
    }

    public final void a(Resources resources) {
        this.o = resources.getDimensionPixelSize(R$dimen.mtrl_slider_widget_height);
        this.r = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_side_padding);
        this.t = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_top);
        this.w = resources.getDimensionPixelSize(R$dimen.mtrl_slider_label_padding);
    }

    public final void e() {
        for (L l : this.l) {
            Iterator<Float> it = this.D.iterator();
            while (it.hasNext()) {
                l.a(this, it.next().floatValue(), false);
            }
        }
    }

    public final void b() {
        q();
        int min = Math.min((int) (((this.C - this.B) / this.G) + 1.0f), (this.I / (this.q * 2)) + 1);
        float[] fArr = this.H;
        if (fArr == null || fArr.length != min * 2) {
            this.H = new float[min * 2];
        }
        float f2 = this.I / (min - 1);
        for (int i2 = 0; i2 < min * 2; i2 += 2) {
            float[] fArr2 = this.H;
            fArr2[i2] = this.r + ((i2 / 2) * f2);
            fArr2[i2 + 1] = c();
        }
    }

    public final void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray c2 = l.c(context, attributeSet, R$styleable.Slider, i2, U, new int[0]);
        this.B = c2.getFloat(R$styleable.Slider_android_valueFrom, 0.0f);
        this.C = c2.getFloat(R$styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.B));
        this.G = c2.getFloat(R$styleable.Slider_android_stepSize, 0.0f);
        boolean hasValue = c2.hasValue(R$styleable.Slider_trackColor);
        int i3 = hasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorInactive;
        int i4 = hasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorActive;
        ColorStateList a2 = c.c.a.c.t.c.a(context, c2, i3);
        if (a2 == null) {
            a2 = a.b.b.a.a.b(context, R$color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(a2);
        ColorStateList a3 = c.c.a.c.t.c.a(context, c2, i4);
        if (a3 == null) {
            a3 = a.b.b.a.a.b(context, R$color.material_slider_active_track_color);
        }
        setTrackActiveTintList(a3);
        this.R.a(c.c.a.c.t.c.a(context, c2, R$styleable.Slider_thumbColor));
        ColorStateList a4 = c.c.a.c.t.c.a(context, c2, R$styleable.Slider_haloColor);
        if (a4 == null) {
            a4 = a.b.b.a.a.b(context, R$color.material_slider_halo_color);
        }
        setHaloTintList(a4);
        boolean hasValue2 = c2.hasValue(R$styleable.Slider_tickColor);
        int i5 = hasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorInactive;
        int i6 = hasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorActive;
        ColorStateList a5 = c.c.a.c.t.c.a(context, c2, i5);
        if (a5 == null) {
            a5 = a.b.b.a.a.b(context, R$color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(a5);
        ColorStateList a6 = c.c.a.c.t.c.a(context, c2, i6);
        if (a6 == null) {
            a6 = a.b.b.a.a.b(context, R$color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(a6);
        setThumbRadius(c2.getDimensionPixelSize(R$styleable.Slider_thumbRadius, 0));
        setHaloRadius(c2.getDimensionPixelSize(R$styleable.Slider_haloRadius, 0));
        setThumbElevation(c2.getDimension(R$styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(c2.getDimensionPixelSize(R$styleable.Slider_trackHeight, 0));
        this.p = c2.getInt(R$styleable.Slider_labelBehavior, 0);
        if (!c2.getBoolean(R$styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        c2.recycle();
    }

    public final boolean e(int i2) {
        int i3 = this.F;
        int a2 = (int) a.h.e.a.a(i3 + i2, 0L, this.D.size() - 1);
        this.F = a2;
        if (a2 == i3) {
            return false;
        }
        if (this.E != -1) {
            this.E = a2;
        }
        p();
        postInvalidate();
        return true;
    }

    public final boolean f(int i2) {
        if (j()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return e(i2);
    }

    public final boolean c(float f2) {
        return b(this.E, f2);
    }

    public final void d(Canvas canvas, int i2, int i3) {
        if (n()) {
            int b2 = (int) (this.r + (b(this.D.get(this.F).floatValue()) * i2));
            if (Build.VERSION.SDK_INT < 28) {
                int i4 = this.v;
                canvas.clipRect(b2 - i4, i3 - i4, b2 + i4, i4 + i3, Region.Op.UNION);
            }
            canvas.drawCircle(b2, i3, this.v, this.f10572d);
        }
    }

    public final void b(Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        float f2 = i2;
        float f3 = this.r + (activeRange[1] * f2);
        if (f3 < r1 + i2) {
            float f4 = i3;
            canvas.drawLine(f3, f4, r1 + i2, f4, this.f10569a);
        }
        int i4 = this.r;
        float f5 = i4 + (activeRange[0] * f2);
        if (f5 > i4) {
            float f6 = i3;
            canvas.drawLine(i4, f6, f5, f6, this.f10569a);
        }
    }

    public final void c(int i2) {
        Iterator<L> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.D.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f10576h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        g(i2);
    }

    public final double d(float f2) {
        float f3 = this.G;
        if (f3 <= 0.0f) {
            return f2;
        }
        int i2 = (int) ((this.C - this.B) / f3);
        double round = Math.round(f2 * i2);
        double d2 = i2;
        Double.isNaN(round);
        Double.isNaN(d2);
        return round / d2;
    }

    public final float b(float f2) {
        float f3 = this.B;
        float f4 = (f2 - f3) / (this.C - f3);
        return j() ? 1.0f - f4 : f4;
    }

    public final boolean b(int i2, float f2) {
        if (Math.abs(f2 - this.D.get(i2).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.D.set(i2, Float.valueOf(a(i2, f2)));
        this.F = i2;
        c(i2);
        return true;
    }

    public final void d(int i2) {
        if (i2 == 1) {
            e(Integer.MAX_VALUE);
            return;
        }
        if (i2 == 2) {
            e(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            f(Integer.MAX_VALUE);
        } else {
            if (i2 != 66) {
                return;
            }
            f(Integer.MIN_VALUE);
        }
    }

    public final float b(int i2) {
        float a2 = a();
        return (this.C - this.B) / a2 <= i2 ? a2 : Math.round(r1 / r4) * a2;
    }

    public final void a(c.c.a.c.b0.a aVar) {
        aVar.b(r.a(this));
    }

    public final void a(Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        int i4 = this.r;
        float f2 = i2;
        float f3 = i3;
        canvas.drawLine(i4 + (activeRange[0] * f2), f3, i4 + (activeRange[1] * f2), f3, this.f10570b);
    }

    public final void a(Canvas canvas) {
        float[] activeRange = getActiveRange();
        int a2 = a(this.H, activeRange[0]);
        int a3 = a(this.H, activeRange[1]);
        int i2 = a2 * 2;
        canvas.drawPoints(this.H, 0, i2, this.f10573e);
        int i3 = a3 * 2;
        canvas.drawPoints(this.H, i2, i3 - i2, this.f10574f);
        float[] fArr = this.H;
        canvas.drawPoints(fArr, i3, fArr.length - i3, this.f10573e);
    }

    public static int a(float[] fArr, float f2) {
        return Math.round(f2 * ((fArr.length / 2) - 1));
    }

    public final float a(int i2, float f2) {
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        return a.h.e.a.a(f2, i4 < 0 ? this.B : this.D.get(i4).floatValue(), i3 >= this.D.size() ? this.C : this.D.get(i3).floatValue());
    }

    public final String a(float f2) {
        if (g()) {
            return this.z.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    public final void a(c.c.a.c.b0.a aVar, float f2) {
        aVar.a(a(f2));
        int b2 = (this.r + ((int) (b(f2) * this.I))) - (aVar.getIntrinsicWidth() / 2);
        int c2 = c() - (this.w + this.u);
        aVar.setBounds(b2, c2 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + b2, c2);
        Rect rect = new Rect(aVar.getBounds());
        c.c.a.c.r.c.b(r.a(this), this, rect);
        aVar.setBounds(rect);
        r.b(this).a(aVar);
    }

    public final int a(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final Boolean a(int i2, KeyEvent keyEvent) {
        if (i2 != 61) {
            if (i2 != 66) {
                if (i2 != 81) {
                    if (i2 == 69) {
                        e(-1);
                        return true;
                    }
                    if (i2 != 70) {
                        switch (i2) {
                            case 21:
                                f(-1);
                                break;
                            case 22:
                                f(1);
                                break;
                        }
                        return true;
                    }
                }
                e(1);
                return true;
            }
            this.E = this.F;
            postInvalidate();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(e(1));
        }
        if (keyEvent.isShiftPressed()) {
            return Boolean.valueOf(e(-1));
        }
        return false;
    }

    public final Float a(int i2) {
        float b2 = this.K ? b(20) : a();
        if (i2 == 21) {
            if (!j()) {
                b2 = -b2;
            }
            return Float.valueOf(b2);
        }
        if (i2 == 22) {
            if (j()) {
                b2 = -b2;
            }
            return Float.valueOf(b2);
        }
        if (i2 == 69) {
            return Float.valueOf(-b2);
        }
        if (i2 == 70 || i2 == 81) {
            return Float.valueOf(b2);
        }
        return null;
    }

    public final float a() {
        float f2 = this.G;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    public void a(int i2, Rect rect) {
        int b2 = this.r + ((int) (b(getValues().get(i2).floatValue()) * this.I));
        int c2 = c();
        int i3 = this.u;
        rect.set(b2 - i3, c2 - i3, b2 + i3, c2 + i3);
    }
}
