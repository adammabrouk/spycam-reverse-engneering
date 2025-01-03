package androidx.viewpager2.widget;

import a.h.j.h0.c;
import a.h.j.h0.f;
import a.h.j.y;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import com.alibaba.sdk.android.oss.common.OSSConstants;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static boolean v = true;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f2873a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f2874b;

    /* renamed from: c, reason: collision with root package name */
    public a.y.b.b f2875c;

    /* renamed from: d, reason: collision with root package name */
    public int f2876d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2877e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView.i f2878f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayoutManager f2879g;

    /* renamed from: h, reason: collision with root package name */
    public int f2880h;

    /* renamed from: i, reason: collision with root package name */
    public Parcelable f2881i;
    public RecyclerView j;
    public a.p.a.l k;
    public a.y.b.e l;
    public a.y.b.b m;
    public a.y.b.c n;
    public a.y.b.d o;
    public RecyclerView.l p;
    public boolean q;
    public boolean r;
    public int t;
    public e u;

    public class a extends g {
        public a() {
            super(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f2877e = true;
            viewPager2.l.g();
        }
    }

    public class b extends i {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i2) {
            if (i2 == 0) {
                ViewPager2.this.g();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i2) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f2876d != i2) {
                viewPager2.f2876d = i2;
                viewPager2.u.g();
            }
        }
    }

    public class c extends i {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i2) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.j.requestFocus(2);
            }
        }
    }

    public class d implements RecyclerView.q {
        public d(ViewPager2 viewPager2) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void a(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) pVar).width != -1 || ((ViewGroup.MarginLayoutParams) pVar).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
        }
    }

    public abstract class e {
        public e(ViewPager2 viewPager2) {
        }

        public void a(a.h.j.h0.c cVar) {
        }

        public void a(a.y.b.b bVar, RecyclerView recyclerView) {
        }

        public void a(AccessibilityEvent accessibilityEvent) {
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void a(RecyclerView.g<?> gVar) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int i2) {
            return false;
        }

        public boolean a(int i2, Bundle bundle) {
            return false;
        }

        public void b(RecyclerView.g<?> gVar) {
        }

        public boolean b() {
            return false;
        }

        public boolean b(int i2, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public String c() {
            throw new IllegalStateException("Not implemented.");
        }

        public void d() {
        }

        public CharSequence e() {
            throw new IllegalStateException("Not implemented.");
        }

        public void f() {
        }

        public void g() {
        }

        public void h() {
        }

        public void i() {
        }

        public /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this(viewPager2);
        }

        public boolean b(int i2) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    public static abstract class g extends RecyclerView.i {
        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void a(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void b(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void c(int i2, int i3) {
            a();
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void a(int i2, int i3, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void a(int i2, int i3, int i4) {
            a();
        }
    }

    public class h extends LinearLayoutManager {
        public h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.z zVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(zVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void onInitializeAccessibilityNodeInfo(RecyclerView.v vVar, RecyclerView.z zVar, a.h.j.h0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(vVar, zVar, cVar);
            ViewPager2.this.u.a(cVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean performAccessibilityAction(RecyclerView.v vVar, RecyclerView.z zVar, int i2, Bundle bundle) {
            return ViewPager2.this.u.a(i2) ? ViewPager2.this.u.b(i2) : super.performAccessibilityAction(vVar, zVar, i2, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    public static abstract class i {
        public void a(int i2) {
        }

        public void a(int i2, float f2, int i3) {
        }

        public void b(int i2) {
        }
    }

    public class j extends e {

        /* renamed from: a, reason: collision with root package name */
        public final a.h.j.h0.f f2890a;

        /* renamed from: b, reason: collision with root package name */
        public final a.h.j.h0.f f2891b;

        /* renamed from: c, reason: collision with root package name */
        public RecyclerView.i f2892c;

        public class a implements a.h.j.h0.f {
            public a() {
            }

            @Override // a.h.j.h0.f
            public boolean a(View view, f.a aVar) {
                j.this.c(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        public class b implements a.h.j.h0.f {
            public b() {
            }

            @Override // a.h.j.h0.f
            public boolean a(View view, f.a aVar) {
                j.this.c(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        public class c extends g {
            public c() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                j.this.j();
            }
        }

        public j() {
            super(ViewPager2.this, null);
            this.f2890a = new a();
            this.f2891b = new b();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(a.y.b.b bVar, RecyclerView recyclerView) {
            y.h(recyclerView, 2);
            this.f2892c = new c();
            if (y.o(ViewPager2.this) == 0) {
                y.h(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a(int i2, Bundle bundle) {
            return i2 == 8192 || i2 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void b(RecyclerView.g<?> gVar) {
            if (gVar != null) {
                gVar.unregisterAdapterDataObserver(this.f2892c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String c() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void d() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void g() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i() {
            j();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        public void j() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i2 = R.id.accessibilityActionPageLeft;
            y.f(viewPager2, R.id.accessibilityActionPageLeft);
            y.f(viewPager2, R.id.accessibilityActionPageRight);
            y.f(viewPager2, R.id.accessibilityActionPageUp);
            y.f(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.d()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f2876d < itemCount - 1) {
                    y.a(viewPager2, new c.a(R.id.accessibilityActionPageDown, null), null, this.f2890a);
                }
                if (ViewPager2.this.f2876d > 0) {
                    y.a(viewPager2, new c.a(R.id.accessibilityActionPageUp, null), null, this.f2891b);
                    return;
                }
                return;
            }
            boolean c2 = ViewPager2.this.c();
            int i3 = c2 ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (c2) {
                i2 = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.f2876d < itemCount - 1) {
                y.a(viewPager2, new c.a(i3, null), null, this.f2890a);
            }
            if (ViewPager2.this.f2876d > 0) {
                y.a(viewPager2, new c.a(i2, null), null, this.f2891b);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i2, Bundle bundle) {
            if (!a(i2, bundle)) {
                throw new IllegalStateException();
            }
            c(i2 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        public void c(int i2) {
            if (ViewPager2.this.d()) {
                ViewPager2.this.b(i2, true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(RecyclerView.g<?> gVar) {
            j();
            if (gVar != null) {
                gVar.registerAdapterDataObserver(this.f2892c);
            }
        }

        public final void c(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.g adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.d()) {
                return;
            }
            if (ViewPager2.this.f2876d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f2876d < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
            b(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                c(accessibilityNodeInfo);
            }
        }

        public final void b(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i2;
            int i3;
            if (ViewPager2.this.getAdapter() == null) {
                i2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i2 = ViewPager2.this.getAdapter().getItemCount();
            } else {
                i3 = ViewPager2.this.getAdapter().getItemCount();
                i2 = 0;
                a.h.j.h0.c.a(accessibilityNodeInfo).a(c.b.a(i2, i3, false, 0));
            }
            i3 = 0;
            a.h.j.h0.c.a(accessibilityNodeInfo).a(c.b.a(i2, i3, false, 0));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(c());
        }
    }

    public interface k {
        void a(View view, float f2);
    }

    public class l extends a.p.a.l {
        public l() {
        }

        @Override // a.p.a.l, a.p.a.p
        public View c(RecyclerView.o oVar) {
            if (ViewPager2.this.b()) {
                return null;
            }
            return super.c(oVar);
        }
    }

    public class m extends RecyclerView {
        public m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.u.b() ? ViewPager2.this.u.e() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f2876d);
            accessibilityEvent.setToIndex(ViewPager2.this.f2876d);
            ViewPager2.this.u.a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.d() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.d() && super.onTouchEvent(motionEvent);
        }
    }

    public static class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f2899a;

        /* renamed from: b, reason: collision with root package name */
        public final RecyclerView f2900b;

        public n(int i2, RecyclerView recyclerView) {
            this.f2899a = i2;
            this.f2900b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2900b.smoothScrollToPosition(this.f2899a);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.f2873a = new Rect();
        this.f2874b = new Rect();
        this.f2875c = new a.y.b.b(3);
        this.f2877e = false;
        this.f2878f = new a();
        this.f2880h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.t = -1;
        a(context, (AttributeSet) null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.u = v ? new j() : new f();
        m mVar = new m(context);
        this.j = mVar;
        mVar.setId(y.b());
        this.j.setDescendantFocusability(OSSConstants.DEFAULT_STREAM_BUFFER_SIZE);
        h hVar = new h(context);
        this.f2879g = hVar;
        this.j.setLayoutManager(hVar);
        this.j.setScrollingTouchSlop(1);
        b(context, attributeSet);
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.j.addOnChildAttachStateChangeListener(a());
        a.y.b.e eVar = new a.y.b.e(this);
        this.l = eVar;
        this.n = new a.y.b.c(this, eVar, this.j);
        l lVar = new l();
        this.k = lVar;
        lVar.a(this.j);
        this.j.addOnScrollListener(this.l);
        a.y.b.b bVar = new a.y.b.b(3);
        this.m = bVar;
        this.l.a(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.m.a(bVar2);
        this.m.a(cVar);
        this.u.a(this.m, this.j);
        this.m.a(this.f2875c);
        a.y.b.d dVar = new a.y.b.d(this.f2879g);
        this.o = dVar;
        this.m.a(dVar);
        RecyclerView recyclerView = this.j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewPager2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R$styleable.ViewPager2, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R$styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean c() {
        return this.f2879g.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.j.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.j.canScrollVertically(i2);
    }

    public boolean d() {
        return this.r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).f2882a;
            sparseArray.put(this.j.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public void e() {
        if (this.o.a() == null) {
            return;
        }
        double b2 = this.l.b();
        int i2 = (int) b2;
        double d2 = i2;
        Double.isNaN(d2);
        float f2 = (float) (b2 - d2);
        this.o.a(i2, f2, Math.round(getPageSize() * f2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        RecyclerView.g adapter;
        if (this.f2880h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f2881i;
        if (parcelable != null) {
            if (adapter instanceof a.y.a.c) {
                ((a.y.a.c) adapter).a(parcelable);
            }
            this.f2881i = null;
        }
        int max = Math.max(0, Math.min(this.f2880h, adapter.getItemCount() - 1));
        this.f2876d = max;
        this.f2880h = -1;
        this.j.scrollToPosition(max);
        this.u.d();
    }

    public void g() {
        a.p.a.l lVar = this.k;
        if (lVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View c2 = lVar.c(this.f2879g);
        if (c2 == null) {
            return;
        }
        int position = this.f2879g.getPosition(c2);
        if (position != this.f2876d && getScrollState() == 0) {
            this.m.b(position);
        }
        this.f2877e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.u.a() ? this.u.c() : super.getAccessibilityClassName();
    }

    public RecyclerView.g getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f2876d;
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.t;
    }

    public int getOrientation() {
        return this.f2879g.getOrientation();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.l.c();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.u.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        this.f2873a.left = getPaddingLeft();
        this.f2873a.right = (i4 - i2) - getPaddingRight();
        this.f2873a.top = getPaddingTop();
        this.f2873a.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f2873a, this.f2874b);
        RecyclerView recyclerView = this.j;
        Rect rect = this.f2874b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f2877e) {
            g();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        measureChild(this.j, i2, i3);
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredState = this.j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2880h = savedState.f2883b;
        this.f2881i = savedState.f2884c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2882a = this.j.getId();
        int i2 = this.f2880h;
        if (i2 == -1) {
            i2 = this.f2876d;
        }
        savedState.f2883b = i2;
        Parcelable parcelable = this.f2881i;
        if (parcelable != null) {
            savedState.f2884c = parcelable;
        } else {
            Object adapter = this.j.getAdapter();
            if (adapter instanceof a.y.a.c) {
                savedState.f2884c = ((a.y.a.c) adapter).a();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.u.a(i2, bundle) ? this.u.b(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void setAdapter(RecyclerView.g gVar) {
        RecyclerView.g adapter = this.j.getAdapter();
        this.u.b((RecyclerView.g<?>) adapter);
        b(adapter);
        this.j.setAdapter(gVar);
        this.f2876d = 0;
        f();
        this.u.a((RecyclerView.g<?>) gVar);
        a(gVar);
    }

    public void setCurrentItem(int i2) {
        a(i2, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.u.f();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.t = i2;
        this.j.requestLayout();
    }

    public void setOrientation(int i2) {
        this.f2879g.setOrientation(i2);
        this.u.h();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.q) {
                this.p = this.j.getItemAnimator();
                this.q = true;
            }
            this.j.setItemAnimator(null);
        } else if (this.q) {
            this.j.setItemAnimator(this.p);
            this.p = null;
            this.q = false;
        }
        if (kVar == this.o.a()) {
            return;
        }
        this.o.a(kVar);
        e();
    }

    public void setUserInputEnabled(boolean z) {
        this.r = z;
        this.u.i();
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f2882a;

        /* renamed from: b, reason: collision with root package name */
        public int f2883b;

        /* renamed from: c, reason: collision with root package name */
        public Parcelable f2884c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        public final void a(Parcel parcel, ClassLoader classLoader) {
            this.f2882a = parcel.readInt();
            this.f2883b = parcel.readInt();
            this.f2884c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2882a);
            parcel.writeInt(this.f2883b);
            parcel.writeParcelable(this.f2884c, i2);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public class f extends e {
        public f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a(int i2) {
            return (i2 == 8192 || i2 == 4096) && !ViewPager2.this.d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i2) {
            if (a(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence e() {
            if (b()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(a.h.j.h0.c cVar) {
            if (ViewPager2.this.d()) {
                return;
            }
            cVar.b(c.a.f1178i);
            cVar.b(c.a.f1177h);
            cVar.l(false);
        }
    }

    public final void b(RecyclerView.g<?> gVar) {
        if (gVar != null) {
            gVar.unregisterAdapterDataObserver(this.f2878f);
        }
    }

    public void b(int i2, boolean z) {
        RecyclerView.g adapter = getAdapter();
        if (adapter == null) {
            if (this.f2880h != -1) {
                this.f2880h = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (min == this.f2876d && this.l.e()) {
            return;
        }
        if (min == this.f2876d && z) {
            return;
        }
        double d2 = this.f2876d;
        this.f2876d = min;
        this.u.g();
        if (!this.l.e()) {
            d2 = this.l.b();
        }
        this.l.a(min, z);
        if (!z) {
            this.j.scrollToPosition(min);
            return;
        }
        double d3 = min;
        Double.isNaN(d3);
        if (Math.abs(d3 - d2) > 3.0d) {
            this.j.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
            RecyclerView recyclerView = this.j;
            recyclerView.post(new n(min, recyclerView));
            return;
        }
        this.j.smoothScrollToPosition(min);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2873a = new Rect();
        this.f2874b = new Rect();
        this.f2875c = new a.y.b.b(3);
        this.f2877e = false;
        this.f2878f = new a();
        this.f2880h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.t = -1;
        a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2873a = new Rect();
        this.f2874b = new Rect();
        this.f2875c = new a.y.b.b(3);
        this.f2877e = false;
        this.f2878f = new a();
        this.f2880h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.t = -1;
        a(context, attributeSet);
    }

    public final RecyclerView.q a() {
        return new d(this);
    }

    public final void a(RecyclerView.g<?> gVar) {
        if (gVar != null) {
            gVar.registerAdapterDataObserver(this.f2878f);
        }
    }

    public void a(int i2, boolean z) {
        if (!b()) {
            b(i2, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public boolean b() {
        return this.n.a();
    }
}
