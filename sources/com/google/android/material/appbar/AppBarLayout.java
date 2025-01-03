package com.google.android.material.appbar;

import a.h.j.g0;
import a.h.j.h0.c;
import a.h.j.h0.f;
import a.h.j.m;
import a.h.j.s;
import a.h.j.y;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import androidx.viewpager.widget.ViewPager;
import c.c.a.c.r.l;
import c.c.a.c.w.h;
import c.c.a.c.w.i;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public static final int r = R$style.Widget_Design_AppBarLayout;

    /* renamed from: a, reason: collision with root package name */
    public int f10245a;

    /* renamed from: b, reason: collision with root package name */
    public int f10246b;

    /* renamed from: c, reason: collision with root package name */
    public int f10247c;

    /* renamed from: d, reason: collision with root package name */
    public int f10248d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10249e;

    /* renamed from: f, reason: collision with root package name */
    public int f10250f;

    /* renamed from: g, reason: collision with root package name */
    public g0 f10251g;

    /* renamed from: h, reason: collision with root package name */
    public List<c> f10252h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10253i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public WeakReference<View> n;
    public ValueAnimator o;
    public int[] p;
    public Drawable q;

    public static class BaseBehavior<T extends AppBarLayout> extends c.c.a.c.b.a<T> {
        public int k;
        public int l;
        public ValueAnimator m;
        public int n;
        public boolean o;
        public float p;
        public WeakReference<View> q;
        public d r;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f10257a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f10258b;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f10257a = coordinatorLayout;
                this.f10258b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.c(this.f10257a, (CoordinatorLayout) this.f10258b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public class b implements f {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f10260a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f10261b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f10262c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f10263d;

            public b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
                this.f10260a = coordinatorLayout;
                this.f10261b = appBarLayout;
                this.f10262c = view;
                this.f10263d = i2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // a.h.j.h0.f
            public boolean a(View view, f.a aVar) {
                BaseBehavior.this.a(this.f10260a, (CoordinatorLayout) this.f10261b, this.f10262c, 0, this.f10263d, new int[]{0, 0}, 1);
                return true;
            }
        }

        public class c implements f {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f10265a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f10266b;

            public c(BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
                this.f10265a = appBarLayout;
                this.f10266b = z;
            }

            @Override // a.h.j.h0.f
            public boolean a(View view, f.a aVar) {
                this.f10265a.setExpanded(this.f10266b);
                return true;
            }
        }

        public static abstract class d<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public BaseBehavior() {
            this.n = -1;
        }

        public static boolean a(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        @Override // c.c.a.c.b.a
        public int c(T t) {
            return t.getTotalScrollRange();
        }

        public final void d(CoordinatorLayout coordinatorLayout, T t) {
            int d2 = d();
            int a2 = a((BaseBehavior<T>) t, d2);
            if (a2 >= 0) {
                View childAt = t.getChildAt(a2);
                d dVar = (d) childAt.getLayoutParams();
                int a3 = dVar.a();
                if ((a3 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (a2 == t.getChildCount() - 1) {
                        i3 += t.getTopInset();
                    }
                    if (a(a3, 2)) {
                        i3 += y.r(childAt);
                    } else if (a(a3, 5)) {
                        int r = y.r(childAt) + i3;
                        if (d2 < r) {
                            i2 = r;
                        } else {
                            i3 = r;
                        }
                    }
                    if (a(a3, 32)) {
                        i2 += ((LinearLayout.LayoutParams) dVar).topMargin;
                        i3 -= ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    }
                    if (d2 < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    a(coordinatorLayout, (CoordinatorLayout) t, a.h.e.a.a(i2, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void e(CoordinatorLayout coordinatorLayout, T t) {
            y.f(coordinatorLayout, c.a.f1177h.a());
            y.f(coordinatorLayout, c.a.f1178i.a());
            View a2 = a(coordinatorLayout);
            if (a2 == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.f) a2.getLayoutParams()).d() instanceof ScrollingViewBehavior)) {
                return;
            }
            a(coordinatorLayout, (CoordinatorLayout) t, a2);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
        }

        public final boolean c(CoordinatorLayout coordinatorLayout, T t) {
            List<View> c2 = coordinatorLayout.c(t);
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.c d2 = ((CoordinatorLayout.f) c2.get(i2).getLayoutParams()).d();
                if (d2 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) d2).c() != 0;
                }
            }
            return false;
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: c, reason: collision with root package name */
            public int f10254c;

            /* renamed from: d, reason: collision with root package name */
            public float f10255d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f10256e;

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
                    return new SavedState(parcel, null);
                }
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f10254c = parcel.readInt();
                this.f10255d = parcel.readFloat();
                this.f10256e = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f10254c);
                parcel.writeFloat(this.f10255d);
                parcel.writeByte(this.f10256e ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public final boolean b(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.d() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        @Override // c.c.a.c.b.a
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        public final int b(T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i4);
                d dVar = (d) childAt.getLayoutParams();
                Interpolator b2 = dVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = dVar.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= y.r(childAt);
                        }
                    }
                    if (y.n(childAt)) {
                        i3 -= t.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation((abs - childAt.getTop()) / f2)));
                    }
                }
            }
            return i2;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t.f() || b(coordinatorLayout, (CoordinatorLayout) t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i3;
            return z;
        }

        public static View c(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t.getTotalScrollRange();
                    i5 = i7;
                    i6 = t.getDownNestedPreScrollRange() + i7;
                } else {
                    i5 = -t.getUpNestedPreScrollRange();
                    i6 = 0;
                }
                if (i5 != i6) {
                    iArr[1] = a(coordinatorLayout, (CoordinatorLayout) t, i3, i5, i6);
                }
            }
            if (t.f()) {
                t.b(t.b(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (i5 < 0) {
                iArr[1] = a(coordinatorLayout, (CoordinatorLayout) t, i5, -t.getDownNestedScrollRange(), 0);
            }
            if (i5 == 0) {
                e(coordinatorLayout, (CoordinatorLayout) t);
            }
        }

        @Override // c.c.a.c.b.a
        public int d() {
            return b() + this.k;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.l == 0 || i2 == 1) {
                d(coordinatorLayout, (CoordinatorLayout) t);
                if (t.f()) {
                    t.b(t.b(view));
                }
            }
            this.q = new WeakReference<>(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable d(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable d2 = super.d(coordinatorLayout, (CoordinatorLayout) t);
            int b2 = b();
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(d2);
                    savedState.f10254c = i2;
                    savedState.f10256e = bottom == y.r(childAt) + t.getTopInset();
                    savedState.f10255d = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return d2;
        }

        public final void a(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int height;
            int abs = Math.abs(d() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, (CoordinatorLayout) t, i2, height);
        }

        public final void a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            int d2 = d();
            if (d2 == i2) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(c.c.a.c.a.a.f5310e);
                this.m.addUpdateListener(new a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i3, ViewPager.MAX_SETTLE_DURATION));
            this.m.setIntValues(d2, i2);
            this.m.start();
        }

        public final int a(T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                d dVar = (d) childAt.getLayoutParams();
                if (a(dVar.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) dVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) dVar).bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t.getLayoutParams())).height == -2) {
                coordinatorLayout.a(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                return true;
            }
            return super.a(coordinatorLayout, (CoordinatorLayout) t, i2, i3, i4, i5);
        }

        @Override // c.c.a.c.b.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i2) {
            int round;
            boolean a2 = super.a(coordinatorLayout, (CoordinatorLayout) t, i2);
            int pendingAction = t.getPendingAction();
            int i3 = this.n;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.o) {
                    round = y.r(childAt) + t.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.p);
                }
                c(coordinatorLayout, (CoordinatorLayout) t, i4 + round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, i5, 0.0f);
                    } else {
                        c(coordinatorLayout, (CoordinatorLayout) t, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, 0, 0.0f);
                    } else {
                        c(coordinatorLayout, (CoordinatorLayout) t, 0);
                    }
                }
            }
            t.g();
            this.n = -1;
            a(a.h.e.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (CoordinatorLayout) t, b(), 0, true);
            t.a(b());
            e(coordinatorLayout, (CoordinatorLayout) t);
            return a2;
        }

        public final void a(CoordinatorLayout coordinatorLayout, T t, View view) {
            if (d() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
                a(coordinatorLayout, (CoordinatorLayout) t, c.a.f1177h, false);
            }
            if (d() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i2 = -t.getDownNestedPreScrollRange();
                    if (i2 != 0) {
                        y.a(coordinatorLayout, c.a.f1178i, null, new b(coordinatorLayout, t, view, i2));
                        return;
                    }
                    return;
                }
                a(coordinatorLayout, (CoordinatorLayout) t, c.a.f1178i, true);
            }
        }

        public final void a(CoordinatorLayout coordinatorLayout, T t, c.a aVar, boolean z) {
            y.a(coordinatorLayout, aVar, null, new c(this, t, z));
        }

        @Override // c.c.a.c.b.a
        public boolean a(T t) {
            d dVar = this.r;
            if (dVar != null) {
                return dVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        @Override // c.c.a.c.b.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(CoordinatorLayout coordinatorLayout, T t) {
            d(coordinatorLayout, (CoordinatorLayout) t);
            if (t.f()) {
                t.b(t.b(a(coordinatorLayout)));
            }
        }

        @Override // c.c.a.c.b.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int b(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            int d2 = d();
            int i5 = 0;
            if (i3 != 0 && d2 >= i3 && d2 <= i4) {
                int a2 = a.h.e.a.a(i2, i3, i4);
                if (d2 != a2) {
                    int b2 = t.b() ? b((BaseBehavior<T>) t, a2) : a2;
                    boolean a3 = a(b2);
                    i5 = d2 - a2;
                    this.k = a2 - b2;
                    if (!a3 && t.b()) {
                        coordinatorLayout.a(t);
                    }
                    t.a(b());
                    a(coordinatorLayout, (CoordinatorLayout) t, a2, a2 < d2 ? -1 : 1, false);
                }
            } else {
                this.k = 0;
            }
            e(coordinatorLayout, (CoordinatorLayout) t);
            return i5;
        }

        public final void a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, boolean z) {
            View c2 = c(t, i2);
            if (c2 != null) {
                int a2 = ((d) c2.getLayoutParams()).a();
                boolean z2 = false;
                if ((a2 & 1) != 0) {
                    int r = y.r(c2);
                    if (i3 <= 0 || (a2 & 12) == 0 ? !((a2 & 2) == 0 || (-i2) < (c2.getBottom() - r) - t.getTopInset()) : (-i2) >= (c2.getBottom() - r) - t.getTopInset()) {
                        z2 = true;
                    }
                }
                if (t.f()) {
                    z2 = t.b(a(coordinatorLayout));
                }
                boolean b2 = t.b(z2);
                if (z || (b2 && c(coordinatorLayout, (CoordinatorLayout) t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }

        public final View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof m) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, (CoordinatorLayout) t, savedState.a());
                this.n = savedState.f10254c;
                this.p = savedState.f10255d;
                this.o = savedState.f10256e;
                return;
            }
            super.a(coordinatorLayout, (CoordinatorLayout) t, parcelable);
            this.n = -1;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends c.c.a.c.b.b {
        public ScrollingViewBehavior() {
        }

        @Override // c.c.a.c.b.b
        public /* bridge */ /* synthetic */ View a(List list) {
            return a((List<View>) list);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                y.f(coordinatorLayout, c.a.f1177h.a());
                y.f(coordinatorLayout, c.a.f1178i.a());
            }
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = a(coordinatorLayout.b(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f5340d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        @Override // c.c.a.c.b.b
        public float b(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a2 > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (a2 / i2) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // c.c.a.c.b.b
        public int c(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.c(view);
        }

        public final void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.f()) {
                    appBarLayout.b(appBarLayout.b(view));
                }
            }
        }

        public final void a(View view, View view2) {
            CoordinatorLayout.c d2 = ((CoordinatorLayout.f) view2.getLayoutParams()).d();
            if (d2 instanceof BaseBehavior) {
                y.e(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) d2).k) + d()) - a(view2));
            }
        }

        public static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.c d2 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).d();
            if (d2 instanceof BaseBehavior) {
                return ((BaseBehavior) d2).d();
            }
            return 0;
        }

        @Override // c.c.a.c.b.b
        public AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public class a implements s {
        public a() {
        }

        @Override // a.h.j.s
        public g0 a(View view, g0 g0Var) {
            AppBarLayout.this.a(g0Var);
            return g0Var;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f10268a;

        public b(AppBarLayout appBarLayout, h hVar) {
            this.f10268a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f10268a.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface c<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    public interface e extends c<AppBarLayout> {
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    public void addOnOffsetChangedListener(c cVar) {
        if (this.f10252h == null) {
            this.f10252h = new ArrayList();
        }
        if (cVar == null || this.f10252h.contains(cVar)) {
            return;
        }
        this.f10252h.add(cVar);
    }

    public boolean b() {
        return this.f10249e;
    }

    public final boolean c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((d) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    public boolean d() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (h()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f10245a);
            this.q.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final void e() {
        this.f10246b = -1;
        this.f10247c = -1;
        this.f10248d = -1;
    }

    public boolean f() {
        return this.l;
    }

    public void g() {
        this.f10250f = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i2;
        int r2;
        int i3 = this.f10247c;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = dVar.f10269a;
            if ((i5 & 5) != 5) {
                if (i4 > 0) {
                    break;
                }
            } else {
                int i6 = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                if ((i5 & 8) != 0) {
                    r2 = y.r(childAt);
                } else if ((i5 & 2) != 0) {
                    r2 = measuredHeight - y.r(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && y.n(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                }
                i2 = i6 + r2;
                if (childCount == 0) {
                    i2 = Math.min(i2, measuredHeight - getTopInset());
                }
                i4 += i2;
            }
        }
        int max = Math.max(0, i4);
        this.f10247c = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f10248d;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
            int i5 = dVar.f10269a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= y.r(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f10248d = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int r2 = y.r(this);
        if (r2 == 0) {
            int childCount = getChildCount();
            r2 = childCount >= 1 ? y.r(getChildAt(childCount - 1)) : 0;
            if (r2 == 0) {
                return getHeight() / 3;
            }
        }
        return (r2 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f10250f;
    }

    public Drawable getStatusBarForeground() {
        return this.q;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        g0 g0Var = this.f10251g;
        if (g0Var != null) {
            return g0Var.h();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f10246b;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = dVar.f10269a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
            if (i3 == 0 && y.n(childAt)) {
                i4 -= getTopInset();
            }
            if ((i5 & 2) != 0) {
                i4 -= y.r(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f10246b = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final boolean h() {
        return this.q != null && getTopInset() > 0;
    }

    public final boolean i() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || y.n(childAt)) ? false : true;
    }

    public final void j() {
        setWillNotDraw(!h());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (this.p == null) {
            this.p = new int[4];
        }
        int[] iArr = this.p;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.j ? R$attr.state_liftable : -R$attr.state_liftable;
        iArr[1] = (this.j && this.k) ? R$attr.state_lifted : -R$attr.state_lifted;
        iArr[2] = this.j ? R$attr.state_collapsible : -R$attr.state_collapsible;
        iArr[3] = (this.j && this.k) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        boolean z2 = true;
        if (y.n(this) && i()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                y.e(getChildAt(childCount), topInset);
            }
        }
        e();
        this.f10249e = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            }
            if (((d) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f10249e = true;
                break;
            }
            i6++;
        }
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f10253i) {
            return;
        }
        if (!this.l && !c()) {
            z2 = false;
        }
        a(z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && y.n(this) && i()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = a.h.e.a.a(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        e();
    }

    public void removeOnOffsetChangedListener(c cVar) {
        List<c> list = this.f10252h;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a(this, f2);
    }

    public void setExpanded(boolean z) {
        a(z, y.J(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.l = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.m = i2;
        a();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i2);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.q = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                a.h.c.l.a.a(this.q, y.q(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            j();
            y.N(this);
        }
    }

    public void setStatusBarForegroundColor(int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(int i2) {
        setStatusBarForeground(a.b.b.a.a.c(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.c.a.c.b.e.a(this, f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        this.f10250f = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    public boolean b(boolean z) {
        if (this.k == z) {
            return false;
        }
        this.k = z;
        refreshDrawableState();
        if (!this.l || !(getBackground() instanceof h)) {
            return true;
        }
        a((h) getBackground(), z);
        return true;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, r), attributeSet, i2);
        this.f10246b = -1;
        this.f10247c = -1;
        this.f10248d = -1;
        this.f10250f = 0;
        Context context2 = getContext();
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            c.c.a.c.b.e.a(this);
            c.c.a.c.b.e.a(this, attributeSet, i2, r);
        }
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.AppBarLayout, i2, r, new int[0]);
        y.a(this, c2.getDrawable(R$styleable.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            h hVar = new h();
            hVar.a(ColorStateList.valueOf(colorDrawable.getColor()));
            hVar.a(context2);
            y.a(this, hVar);
        }
        if (c2.hasValue(R$styleable.AppBarLayout_expanded)) {
            a(c2.getBoolean(R$styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && c2.hasValue(R$styleable.AppBarLayout_elevation)) {
            c.c.a.c.b.e.a(this, c2.getDimensionPixelSize(R$styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (c2.hasValue(R$styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(c2.getBoolean(R$styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (c2.hasValue(R$styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(c2.getBoolean(R$styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.l = c2.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
        this.m = c2.getResourceId(R$styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(c2.getDrawable(R$styleable.AppBarLayout_statusBarForeground));
        c2.recycle();
        y.a(this, new a());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public d generateDefaultLayoutParams() {
        return new d(-1, -2);
    }

    public void removeOnOffsetChangedListener(e eVar) {
        removeOnOffsetChangedListener((c) eVar);
    }

    public void a(int i2) {
        this.f10245a = i2;
        if (!willNotDraw()) {
            y.N(this);
        }
        List<c> list = this.f10252h;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = this.f10252h.get(i3);
                if (cVar != null) {
                    cVar.a(this, i2);
                }
            }
        }
    }

    public void addOnOffsetChangedListener(e eVar) {
        addOnOffsetChangedListener((c) eVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new d((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }

    public boolean b(View view) {
        View a2 = a(view);
        if (a2 != null) {
            view = a2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public static class d extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f10269a;

        /* renamed from: b, reason: collision with root package name */
        public Interpolator f10270b;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10269a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.f10269a = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f10270b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f10269a;
        }

        public Interpolator b() {
            return this.f10270b;
        }

        public boolean c() {
            int i2 = this.f10269a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public d(int i2, int i3) {
            super(i2, i3);
            this.f10269a = 1;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f10269a = 1;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f10269a = 1;
        }

        public d(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f10269a = 1;
        }
    }

    public final boolean a(boolean z) {
        if (this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        return true;
    }

    public final void a(h hVar, boolean z) {
        float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
        float f2 = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
        this.o = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
        this.o.setInterpolator(c.c.a.c.a.a.f5306a);
        this.o.addUpdateListener(new b(this, hVar));
        this.o.start();
    }

    public final View a(View view) {
        int i2;
        if (this.n == null && (i2 = this.m) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.m);
            }
            if (findViewById != null) {
                this.n = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void a() {
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    public g0 a(g0 g0Var) {
        g0 g0Var2 = y.n(this) ? g0Var : null;
        if (!a.h.i.c.a(this.f10251g, g0Var2)) {
            this.f10251g = g0Var2;
            j();
            requestLayout();
        }
        return g0Var;
    }
}
