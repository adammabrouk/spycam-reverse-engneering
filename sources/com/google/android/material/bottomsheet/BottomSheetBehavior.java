package com.google.android.material.bottomsheet;

import a.h.j.g0;
import a.h.j.h0.c;
import a.h.j.h0.f;
import a.h.j.y;
import a.j.a.c;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import c.c.a.c.r.r;
import c.c.a.c.w.h;
import c.c.a.c.w.m;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int Q = R$style.Widget_Design_BottomSheet_Modal;
    public a.j.a.c A;
    public boolean B;
    public int C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public WeakReference<V> H;
    public WeakReference<View> I;
    public final ArrayList<f> J;
    public VelocityTracker K;
    public int L;
    public int M;
    public boolean N;
    public Map<View, Integer> O;
    public final c.AbstractC0037c P;

    /* renamed from: a, reason: collision with root package name */
    public int f10381a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10382b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10383c;

    /* renamed from: d, reason: collision with root package name */
    public float f10384d;

    /* renamed from: e, reason: collision with root package name */
    public int f10385e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10386f;

    /* renamed from: g, reason: collision with root package name */
    public int f10387g;

    /* renamed from: h, reason: collision with root package name */
    public int f10388h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10389i;
    public h j;
    public int k;
    public boolean l;
    public m m;
    public boolean n;
    public BottomSheetBehavior<V>.g o;
    public ValueAnimator p;
    public int q;
    public int r;
    public int s;
    public float t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10395a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10396b;

        public a(View view, int i2) {
            this.f10395a = view;
            this.f10396b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.a(this.f10395a, this.f10396b);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.j != null) {
                BottomSheetBehavior.this.j.c(floatValue);
            }
        }
    }

    public class c implements r.e {
        public c() {
        }

        @Override // c.c.a.c.r.r.e
        public g0 a(View view, g0 g0Var, r.f fVar) {
            BottomSheetBehavior.this.k = g0Var.d().f978d;
            BottomSheetBehavior.this.g(false);
            return g0Var;
        }
    }

    public class d extends c.AbstractC0037c {
        public d() {
        }

        public final boolean a(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.G + bottomSheetBehavior.f()) / 2;
        }

        @Override // a.j.a.c.AbstractC0037c
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // a.j.a.c.AbstractC0037c
        public int clampViewPositionVertical(View view, int i2, int i3) {
            int f2 = BottomSheetBehavior.this.f();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return a.h.e.a.a(i2, f2, bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u);
        }

        @Override // a.j.a.c.AbstractC0037c
        public int getViewVerticalDragRange(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u;
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewDragStateChanged(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.y) {
                BottomSheetBehavior.this.f(1);
            }
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.a(i3);
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewReleased(View view, float f2, float f3) {
            int i2;
            int i3 = 4;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.f10382b) {
                    i2 = BottomSheetBehavior.this.r;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior.s;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = bottomSheetBehavior.q;
                    }
                }
                i3 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.w && bottomSheetBehavior2.a(view, f3)) {
                    if ((Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) && !a(view)) {
                        if (BottomSheetBehavior.this.f10382b) {
                            i2 = BottomSheetBehavior.this.r;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.q) < Math.abs(view.getTop() - BottomSheetBehavior.this.s)) {
                            i2 = BottomSheetBehavior.this.q;
                        } else {
                            i2 = BottomSheetBehavior.this.s;
                            i3 = 6;
                        }
                        i3 = 3;
                    } else {
                        i2 = BottomSheetBehavior.this.G;
                        i3 = 5;
                    }
                } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                    int top2 = view.getTop();
                    if (!BottomSheetBehavior.this.f10382b) {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i5 = bottomSheetBehavior3.s;
                        if (top2 < i5) {
                            if (top2 < Math.abs(top2 - bottomSheetBehavior3.u)) {
                                i2 = BottomSheetBehavior.this.q;
                                i3 = 3;
                            } else {
                                i2 = BottomSheetBehavior.this.s;
                            }
                        } else if (Math.abs(top2 - i5) < Math.abs(top2 - BottomSheetBehavior.this.u)) {
                            i2 = BottomSheetBehavior.this.s;
                        } else {
                            i2 = BottomSheetBehavior.this.u;
                        }
                        i3 = 6;
                    } else if (Math.abs(top2 - BottomSheetBehavior.this.r) < Math.abs(top2 - BottomSheetBehavior.this.u)) {
                        i2 = BottomSheetBehavior.this.r;
                        i3 = 3;
                    } else {
                        i2 = BottomSheetBehavior.this.u;
                    }
                } else if (BottomSheetBehavior.this.f10382b) {
                    i2 = BottomSheetBehavior.this.u;
                } else {
                    int top3 = view.getTop();
                    if (Math.abs(top3 - BottomSheetBehavior.this.s) < Math.abs(top3 - BottomSheetBehavior.this.u)) {
                        i2 = BottomSheetBehavior.this.s;
                        i3 = 6;
                    } else {
                        i2 = BottomSheetBehavior.this.u;
                    }
                }
            }
            BottomSheetBehavior.this.a(view, i3, i2, true);
        }

        @Override // a.j.a.c.AbstractC0037c
        public boolean tryCaptureView(View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.z;
            if (i3 == 1 || bottomSheetBehavior.N) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.L == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.H;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    public class e implements a.h.j.h0.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f10401a;

        public e(int i2) {
            this.f10401a = i2;
        }

        @Override // a.h.j.h0.f
        public boolean a(View view, f.a aVar) {
            BottomSheetBehavior.this.e(this.f10401a);
            return true;
        }
    }

    public static abstract class f {
        public abstract void a(View view, float f2);

        public abstract void a(View view, int i2);
    }

    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final View f10403a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10404b;

        /* renamed from: c, reason: collision with root package name */
        public int f10405c;

        public g(View view, int i2) {
            this.f10403a = view;
            this.f10405c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.j.a.c cVar = BottomSheetBehavior.this.A;
            if (cVar == null || !cVar.a(true)) {
                BottomSheetBehavior.this.f(this.f10405c);
            } else {
                y.a(this.f10403a, this);
            }
            this.f10404b = false;
        }
    }

    public BottomSheetBehavior() {
        this.f10381a = 0;
        this.f10382b = true;
        this.f10383c = false;
        this.o = null;
        this.t = 0.5f;
        this.v = -1.0f;
        this.y = true;
        this.z = 4;
        this.J = new ArrayList<>();
        this.P = new d();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    public int f() {
        return this.f10382b ? this.r : this.q;
    }

    public final void g(boolean z) {
        V v;
        if (this.H != null) {
            b();
            if (this.z != 4 || (v = this.H.get()) == null) {
                return;
            }
            if (z) {
                g(this.z);
            } else {
                v.requestLayout();
            }
        }
    }

    public boolean h() {
        return this.l;
    }

    public final void i() {
        this.L = -1;
        VelocityTracker velocityTracker = this.K;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.K = null;
        }
    }

    public final void j() {
        V v;
        WeakReference<V> weakReference = this.H;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        y.f(v, 524288);
        y.f(v, 262144);
        y.f(v, MemoryConstants.MB);
        if (this.w && this.z != 5) {
            a((BottomSheetBehavior<V>) v, c.a.l, 5);
        }
        int i2 = this.z;
        if (i2 == 3) {
            a((BottomSheetBehavior<V>) v, c.a.k, this.f10382b ? 4 : 6);
            return;
        }
        if (i2 == 4) {
            a((BottomSheetBehavior<V>) v, c.a.j, this.f10382b ? 3 : 6);
        } else {
            if (i2 != 6) {
                return;
            }
            a((BottomSheetBehavior<V>) v, c.a.k, 4);
            a((BottomSheetBehavior<V>) v, c.a.j, 3);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.z == 1 && actionMasked == 0) {
            return true;
        }
        a.j.a.c cVar = this.A;
        if (cVar != null) {
            cVar.a(motionEvent);
        }
        if (actionMasked == 0) {
            i();
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (this.A != null && actionMasked == 2 && !this.B && Math.abs(this.M - motionEvent.getY()) > this.A.f()) {
            this.A.a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.B;
    }

    public void c(int i2) {
        a(i2, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.d(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    public void e(boolean z) {
        this.x = z;
    }

    public void f(int i2) {
        V v;
        if (this.z == i2) {
            return;
        }
        this.z = i2;
        WeakReference<V> weakReference = this.H;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i2 == 3) {
            f(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            f(false);
        }
        h(i2);
        for (int i3 = 0; i3 < this.J.size(); i3++) {
            this.J.get(i3).a((View) v, i2);
        }
        j();
    }

    public final void h(int i2) {
        ValueAnimator valueAnimator;
        if (i2 == 2) {
            return;
        }
        boolean z = i2 == 3;
        if (this.n != z) {
            this.n = z;
            if (this.j == null || (valueAnimator = this.p) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.p.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.p.setFloatValues(1.0f - f2, f2);
            this.p.start();
        }
    }

    public void c(boolean z) {
        this.l = z;
    }

    public void d(boolean z) {
        if (this.w != z) {
            this.w = z;
            if (!z && this.z == 5) {
                e(4);
            }
            j();
        }
    }

    public void e(int i2) {
        if (i2 == this.z) {
            return;
        }
        if (this.H == null) {
            if (i2 == 4 || i2 == 3 || i2 == 6 || (this.w && i2 == 5)) {
                this.z = i2;
                return;
            }
            return;
        }
        g(i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, (CoordinatorLayout) v, savedState.a());
        a(savedState);
        int i2 = savedState.f10390c;
        if (i2 != 1 && i2 != 2) {
            this.z = i2;
        } else {
            this.z = 4;
        }
    }

    public final void c() {
        this.s = (int) (this.G * (1.0f - this.t));
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public final int f10390c;

        /* renamed from: d, reason: collision with root package name */
        public int f10391d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10392e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f10393f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f10394g;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10390c = parcel.readInt();
            this.f10391d = parcel.readInt();
            this.f10392e = parcel.readInt() == 1;
            this.f10393f = parcel.readInt() == 1;
            this.f10394g = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f10390c);
            parcel.writeInt(this.f10391d);
            parcel.writeInt(this.f10392e ? 1 : 0);
            parcel.writeInt(this.f10393f ? 1 : 0);
            parcel.writeInt(this.f10394g ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f10390c = bottomSheetBehavior.z;
            this.f10391d = bottomSheetBehavior.f10385e;
            this.f10392e = bottomSheetBehavior.f10382b;
            this.f10393f = bottomSheetBehavior.w;
            this.f10394g = bottomSheetBehavior.x;
        }
    }

    public final void g(int i2) {
        V v = this.H.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && y.I(v)) {
            v.post(new a(v, i2));
        } else {
            a((View) v, i2);
        }
    }

    public void d(int i2) {
        this.f10381a = i2;
    }

    public final void e() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.p = ofFloat;
        ofFloat.setDuration(500L);
        this.p.addUpdateListener(new b());
    }

    public final int d() {
        int i2;
        if (this.f10386f) {
            return Math.min(Math.max(this.f10387g, this.G - ((this.F * 9) / 16)), this.E);
        }
        if (!this.l && (i2 = this.k) > 0) {
            return Math.max(this.f10385e, i2 + this.f10388h);
        }
        return this.f10385e;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout.f fVar) {
        super.a(fVar);
        this.H = null;
        this.A = null;
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.f10381a = 0;
        this.f10382b = true;
        this.f10383c = false;
        this.o = null;
        this.t = 0.5f;
        this.v = -1.0f;
        this.y = true;
        this.z = 4;
        this.J = new ArrayList<>();
        this.P = new d();
        this.f10388h = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.f10389i = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            a(context, attributeSet, hasValue, c.c.a.c.t.c.a(context, obtainStyledAttributes, R$styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            a(context, attributeSet, hasValue);
        }
        e();
        if (Build.VERSION.SDK_INT >= 21) {
            this.v = obtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && (i2 = peekValue.data) == -1) {
            c(i2);
        } else {
            c(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        d(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        c(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        b(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        e(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        a(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        d(obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        a(obtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (peekValue2 != null && peekValue2.type == 16) {
            b(peekValue2.data);
        } else {
            b(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        obtainStyledAttributes.recycle();
        this.f10384d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final void f(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.H;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.O != null) {
                    return;
                } else {
                    this.O = new HashMap(childCount);
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.H.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.f10383c) {
                            y.h(childAt, 4);
                        }
                    } else if (this.f10383c && (map = this.O) != null && map.containsKey(childAt)) {
                        y.h(childAt, this.O.get(childAt).intValue());
                    }
                }
            }
            if (z) {
                return;
            }
            this.O = null;
        }
    }

    public final float g() {
        VelocityTracker velocityTracker = this.K;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f10384d);
        return this.K.getYVelocity(this.L);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a() {
        super.a();
        this.H = null;
        this.A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        this.C = 0;
        this.D = false;
        return (i2 & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        h hVar;
        if (y.n(coordinatorLayout) && !y.n(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.H == null) {
            this.f10387g = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            b(v);
            this.H = new WeakReference<>(v);
            if (this.f10389i && (hVar = this.j) != null) {
                y.a(v, hVar);
            }
            h hVar2 = this.j;
            if (hVar2 != null) {
                float f2 = this.v;
                if (f2 == -1.0f) {
                    f2 = y.l(v);
                }
                hVar2.b(f2);
                boolean z = this.z == 3;
                this.n = z;
                this.j.c(z ? 0.0f : 1.0f);
            }
            j();
            if (y.o(v) == 0) {
                y.h(v, 1);
            }
        }
        if (this.A == null) {
            this.A = a.j.a.c.a(coordinatorLayout, this.P);
        }
        int top = v.getTop();
        coordinatorLayout.d(v, i2);
        this.F = coordinatorLayout.getWidth();
        this.G = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.E = height;
        this.r = Math.max(0, this.G - height);
        c();
        b();
        int i3 = this.z;
        if (i3 == 3) {
            y.e(v, f());
        } else if (i3 == 6) {
            y.e(v, this.s);
        } else if (this.w && i3 == 5) {
            y.e(v, this.G);
        } else {
            int i4 = this.z;
            if (i4 == 4) {
                y.e(v, this.u);
            } else if (i4 == 1 || i4 == 2) {
                y.e(v, top - v.getTop());
            }
        }
        this.I = new WeakReference<>(a(v));
        return true;
    }

    public void b(boolean z) {
        if (this.f10382b == z) {
            return;
        }
        this.f10382b = z;
        if (this.H != null) {
            b();
        }
        f((this.f10382b && this.z == 6) ? 3 : this.z);
        j();
    }

    public void b(int i2) {
        if (i2 >= 0) {
            this.q = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public final void b() {
        int d2 = d();
        if (this.f10382b) {
            this.u = Math.max(this.G - d2, this.r);
        } else {
            this.u = this.G - d2;
        }
    }

    public final void b(View view) {
        if (Build.VERSION.SDK_INT < 29 || h() || this.f10386f) {
            return;
        }
        r.a(view, new c());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        a.j.a.c cVar;
        if (v.isShown() && this.y) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                i();
            }
            if (this.K == null) {
                this.K = VelocityTracker.obtain();
            }
            this.K.addMovement(motionEvent);
            if (actionMasked == 0) {
                int x = (int) motionEvent.getX();
                this.M = (int) motionEvent.getY();
                if (this.z != 2) {
                    WeakReference<View> weakReference = this.I;
                    View view = weakReference != null ? weakReference.get() : null;
                    if (view != null && coordinatorLayout.a(view, x, this.M)) {
                        this.L = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.N = true;
                    }
                }
                this.B = this.L == -1 && !coordinatorLayout.a(v, x, this.M);
            } else if (actionMasked == 1 || actionMasked == 3) {
                this.N = false;
                this.L = -1;
                if (this.B) {
                    this.B = false;
                    return false;
                }
            }
            if (!this.B && (cVar = this.A) != null && cVar.c(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.I;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            return (actionMasked != 2 || view2 == null || this.B || this.z == 1 || coordinatorLayout.a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.A == null || Math.abs(((float) this.M) - motionEvent.getY()) <= ((float) this.A.f())) ? false : true;
        }
        this.B = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.I;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i3;
        if (i3 > 0) {
            if (i5 < f()) {
                iArr[1] = top - f();
                y.e(v, -iArr[1]);
                f(3);
            } else {
                if (!this.y) {
                    return;
                }
                iArr[1] = i3;
                y.e(v, -i3);
                f(1);
            }
        } else if (i3 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.u;
            if (i5 > i6 && !this.w) {
                iArr[1] = top - i6;
                y.e(v, -iArr[1]);
                f(4);
            } else {
                if (!this.y) {
                    return;
                }
                iArr[1] = i3;
                y.e(v, -i3);
                f(1);
            }
        }
        a(v.getTop());
        this.C = i3;
        this.D = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
        int i3;
        int i4 = 3;
        if (v.getTop() == f()) {
            f(3);
            return;
        }
        WeakReference<View> weakReference = this.I;
        if (weakReference != null && view == weakReference.get() && this.D) {
            if (this.C > 0) {
                if (this.f10382b) {
                    i3 = this.r;
                } else {
                    int top = v.getTop();
                    int i5 = this.s;
                    if (top > i5) {
                        i3 = i5;
                        i4 = 6;
                    } else {
                        i3 = this.q;
                    }
                }
            } else if (this.w && a(v, g())) {
                i3 = this.G;
                i4 = 5;
            } else if (this.C == 0) {
                int top2 = v.getTop();
                if (this.f10382b) {
                    if (Math.abs(top2 - this.r) < Math.abs(top2 - this.u)) {
                        i3 = this.r;
                    } else {
                        i3 = this.u;
                        i4 = 4;
                    }
                } else {
                    int i6 = this.s;
                    if (top2 < i6) {
                        if (top2 < Math.abs(top2 - this.u)) {
                            i3 = this.q;
                        } else {
                            i3 = this.s;
                        }
                    } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.u)) {
                        i3 = this.s;
                    } else {
                        i3 = this.u;
                        i4 = 4;
                    }
                    i4 = 6;
                }
            } else {
                if (this.f10382b) {
                    i3 = this.u;
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.s) < Math.abs(top3 - this.u)) {
                        i3 = this.s;
                        i4 = 6;
                    } else {
                        i3 = this.u;
                    }
                }
                i4 = 4;
            }
            a((View) v, i4, i3, false);
            this.D = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.I;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.z != 3 || super.a(coordinatorLayout, (CoordinatorLayout) v, view, f2, f3);
    }

    public final void a(int i2, boolean z) {
        boolean z2 = true;
        if (i2 == -1) {
            if (!this.f10386f) {
                this.f10386f = true;
            }
            z2 = false;
        } else {
            if (this.f10386f || this.f10385e != i2) {
                this.f10386f = false;
                this.f10385e = Math.max(0, i2);
            }
            z2 = false;
        }
        if (z2) {
            g(z);
        }
    }

    public void a(float f2) {
        if (f2 > 0.0f && f2 < 1.0f) {
            this.t = f2;
            if (this.H != null) {
                c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void a(boolean z) {
        this.y = z;
    }

    public final void a(SavedState savedState) {
        int i2 = this.f10381a;
        if (i2 == 0) {
            return;
        }
        if (i2 == -1 || (i2 & 1) == 1) {
            this.f10385e = savedState.f10391d;
        }
        int i3 = this.f10381a;
        if (i3 == -1 || (i3 & 2) == 2) {
            this.f10382b = savedState.f10392e;
        }
        int i4 = this.f10381a;
        if (i4 == -1 || (i4 & 4) == 4) {
            this.w = savedState.f10393f;
        }
        int i5 = this.f10381a;
        if (i5 == -1 || (i5 & 8) == 8) {
            this.x = savedState.f10394g;
        }
    }

    public boolean a(View view, float f2) {
        if (this.x) {
            return true;
        }
        if (view.getTop() < this.u) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.u)) / ((float) d()) > 0.5f;
    }

    public View a(View view) {
        if (y.K(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View a2 = a(viewGroup.getChildAt(i2));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public final void a(Context context, AttributeSet attributeSet, boolean z) {
        a(context, attributeSet, z, (ColorStateList) null);
    }

    public final void a(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.f10389i) {
            this.m = m.a(context, attributeSet, R$attr.bottomSheetStyle, Q).a();
            h hVar = new h(this.m);
            this.j = hVar;
            hVar.a(context);
            if (z && colorStateList != null) {
                this.j.a(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.j.setTint(typedValue.data);
        }
    }

    public void a(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.u;
        } else if (i2 == 6) {
            int i5 = this.s;
            if (!this.f10382b || i5 > (i4 = this.r)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = f();
        } else if (this.w && i2 == 5) {
            i3 = this.G;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        }
        a(view, i2, i3, false);
    }

    public void a(View view, int i2, int i3, boolean z) {
        a.j.a.c cVar = this.A;
        if (cVar != null && (!z ? !cVar.b(view, view.getLeft(), i3) : !cVar.e(view.getLeft(), i3))) {
            f(2);
            h(i2);
            if (this.o == null) {
                this.o = new g(view, i2);
            }
            if (!this.o.f10404b) {
                BottomSheetBehavior<V>.g gVar = this.o;
                gVar.f10405c = i2;
                y.a(view, gVar);
                this.o.f10404b = true;
                return;
            }
            this.o.f10405c = i2;
            return;
        }
        f(i2);
    }

    public void a(int i2) {
        float f2;
        float f3;
        V v = this.H.get();
        if (v == null || this.J.isEmpty()) {
            return;
        }
        int i3 = this.u;
        if (i2 <= i3 && i3 != f()) {
            int i4 = this.u;
            f2 = i4 - i2;
            f3 = i4 - f();
        } else {
            int i5 = this.u;
            f2 = i5 - i2;
            f3 = this.G - i5;
        }
        float f4 = f2 / f3;
        for (int i6 = 0; i6 < this.J.size(); i6++) {
            this.J.get(i6).a(v, f4);
        }
    }

    public final void a(V v, c.a aVar, int i2) {
        y.a(v, aVar, null, new e(i2));
    }
}
