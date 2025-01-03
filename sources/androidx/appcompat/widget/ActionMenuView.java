package androidx.appcompat.widget;

import a.b.e.j.g;
import a.b.e.j.i;
import a.b.e.j.m;
import a.b.e.j.n;
import a.b.f.m0;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements g.b, n {
    public int A;
    public e B;
    public g p;
    public Context q;
    public int r;
    public boolean t;
    public ActionMenuPresenter u;
    public m.a v;
    public g.a w;
    public boolean x;
    public int y;
    public int z;

    public interface a {
        boolean a();

        boolean c();
    }

    public static class b implements m.a {
        @Override // a.b.e.j.m.a
        public void a(g gVar, boolean z) {
        }

        @Override // a.b.e.j.m.a
        public boolean a(g gVar) {
            return false;
        }
    }

    public static class c extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f2208a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f2209b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f2210c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f2211d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f2212e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f2213f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f2208a = cVar.f2208a;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f2208a = false;
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public static int b(View view, int i2, int i3, int i4, int i5) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.e();
        int i6 = 2;
        if (i3 <= 0 || (z && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z || i7 >= 2) {
                i6 = i7;
            }
        }
        cVar.f2211d = !cVar.f2208a && z;
        cVar.f2209b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, MemoryConstants.GB), makeMeasureSpec);
        return i6;
    }

    @Override // a.b.e.j.g.b
    public boolean a(i iVar) {
        return this.p.a(iVar, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public void d() {
        ActionMenuPresenter actionMenuPresenter = this.u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    public final void e(int i2, int i3) {
        int i4;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        boolean z3;
        int i7;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.z;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int childCount = getChildCount();
        int i13 = 0;
        int i14 = 0;
        boolean z4 = false;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        long j = 0;
        while (i14 < childCount) {
            View childAt = getChildAt(i14);
            int i18 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i19 = i15 + 1;
                if (z5) {
                    int i20 = this.A;
                    i7 = i19;
                    r14 = 0;
                    childAt.setPadding(i20, 0, i20, 0);
                } else {
                    i7 = i19;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f2213f = r14;
                cVar.f2210c = r14;
                cVar.f2209b = r14;
                cVar.f2211d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f2212e = z5 && ((ActionMenuItemView) childAt).e();
                int b2 = b(childAt, i12, cVar.f2208a ? 1 : i10, childMeasureSpec, paddingTop);
                i16 = Math.max(i16, b2);
                if (cVar.f2211d) {
                    i17++;
                }
                if (cVar.f2208a) {
                    z4 = true;
                }
                i10 -= b2;
                i13 = Math.max(i13, childAt.getMeasuredHeight());
                if (b2 == 1) {
                    j |= 1 << i14;
                    i13 = i13;
                }
                i15 = i7;
            }
            i14++;
            size2 = i18;
        }
        int i21 = size2;
        boolean z6 = z4 && i15 == 2;
        boolean z7 = false;
        while (i17 > 0 && i10 > 0) {
            int i22 = 0;
            int i23 = 0;
            int i24 = Integer.MAX_VALUE;
            long j2 = 0;
            while (i23 < childCount) {
                boolean z8 = z7;
                c cVar2 = (c) getChildAt(i23).getLayoutParams();
                int i25 = i13;
                if (cVar2.f2211d) {
                    int i26 = cVar2.f2209b;
                    if (i26 < i24) {
                        j2 = 1 << i23;
                        i24 = i26;
                        i22 = 1;
                    } else if (i26 == i24) {
                        i22++;
                        j2 |= 1 << i23;
                    }
                }
                i23++;
                i13 = i25;
                z7 = z8;
            }
            z = z7;
            i6 = i13;
            j |= j2;
            if (i22 > i10) {
                i4 = mode;
                i5 = i8;
                break;
            }
            int i27 = i24 + 1;
            int i28 = 0;
            while (i28 < childCount) {
                View childAt2 = getChildAt(i28);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i29 = i8;
                int i30 = mode;
                long j3 = 1 << i28;
                if ((j2 & j3) == 0) {
                    if (cVar3.f2209b == i27) {
                        j |= j3;
                    }
                    z3 = z6;
                } else {
                    if (z6 && cVar3.f2212e && i10 == 1) {
                        int i31 = this.A;
                        z3 = z6;
                        childAt2.setPadding(i31 + i12, 0, i31, 0);
                    } else {
                        z3 = z6;
                    }
                    cVar3.f2209b++;
                    cVar3.f2213f = true;
                    i10--;
                }
                i28++;
                mode = i30;
                i8 = i29;
                z6 = z3;
            }
            i13 = i6;
            z7 = true;
        }
        i4 = mode;
        i5 = i8;
        z = z7;
        i6 = i13;
        boolean z9 = !z4 && i15 == 1;
        if (i10 <= 0 || j == 0 || (i10 >= i15 - 1 && !z9 && i16 <= 1)) {
            z2 = z;
        } else {
            float bitCount = Long.bitCount(j);
            if (!z9) {
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f2212e) {
                    bitCount -= 0.5f;
                }
                int i32 = childCount - 1;
                if ((j & (1 << i32)) != 0 && !((c) getChildAt(i32).getLayoutParams()).f2212e) {
                    bitCount -= 0.5f;
                }
            }
            int i33 = bitCount > 0.0f ? (int) ((i10 * i12) / bitCount) : 0;
            z2 = z;
            for (int i34 = 0; i34 < childCount; i34++) {
                if ((j & (1 << i34)) != 0) {
                    View childAt3 = getChildAt(i34);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f2210c = i33;
                        cVar4.f2213f = true;
                        if (i34 == 0 && !cVar4.f2212e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i33) / 2;
                        }
                    } else if (cVar4.f2208a) {
                        cVar4.f2210c = i33;
                        cVar4.f2213f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i33) / 2;
                    } else {
                        if (i34 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i33 / 2;
                        }
                        if (i34 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i33 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i35 = 0; i35 < childCount; i35++) {
                View childAt4 = getChildAt(i35);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f2213f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f2209b * i12) + cVar5.f2210c, MemoryConstants.GB), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i5, i4 != 1073741824 ? i6 : i21);
    }

    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.u;
        return actionMenuPresenter != null && actionMenuPresenter.e();
    }

    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.u;
        return actionMenuPresenter != null && actionMenuPresenter.i();
    }

    public Menu getMenu() {
        if (this.p == null) {
            Context context = getContext();
            g gVar = new g(context);
            this.p = gVar;
            gVar.a(new d());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.u = actionMenuPresenter;
            actionMenuPresenter.d(true);
            ActionMenuPresenter actionMenuPresenter2 = this.u;
            m.a aVar = this.v;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter2.a(aVar);
            this.p.a(this.u, this.q);
            this.u.a(this);
        }
        return this.p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.u.d();
    }

    public int getPopupTheme() {
        return this.r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.u;
        return actionMenuPresenter != null && actionMenuPresenter.j();
    }

    public boolean i() {
        return this.t;
    }

    public g j() {
        return this.p;
    }

    public boolean k() {
        ActionMenuPresenter actionMenuPresenter = this.u;
        return actionMenuPresenter != null && actionMenuPresenter.k();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(false);
            if (this.u.j()) {
                this.u.e();
                this.u.k();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int width;
        int i6;
        if (!this.x) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i4 - i2;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = m0.a(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2208a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (d(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i6 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = i6 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i6 = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(i6, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    d(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int max = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f2208a) {
                    int i17 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f2208a) {
                int i20 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i2, int i3) {
        g gVar;
        boolean z = this.x;
        boolean z2 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.x = z2;
        if (z != z2) {
            this.y = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.x && (gVar = this.p) != null && size != this.y) {
            this.y = size;
            gVar.c(true);
        }
        int childCount = getChildCount();
        if (this.x && childCount > 0) {
            e(i2, i3);
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            c cVar = (c) getChildAt(i4).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.u.c(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.u.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.t = z;
    }

    public void setPopupTheme(int i2) {
        if (this.r != i2) {
            this.r = i2;
            if (i2 == 0) {
                this.q = getContext();
            } else {
                this.q = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.u = actionMenuPresenter;
        actionMenuPresenter.a(this);
    }

    public class d implements g.a {
        public d() {
        }

        @Override // a.b.e.j.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.B;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // a.b.e.j.g.a
        public void a(g gVar) {
            g.a aVar = ActionMenuView.this.w;
            if (aVar != null) {
                aVar.a(gVar);
            }
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.z = (int) (56.0f * f2);
        this.A = (int) (f2 * 4.0f);
        this.q = context;
        this.r = 0;
    }

    @Override // a.b.e.j.n
    public void a(g gVar) {
        this.p = gVar;
    }

    public void a(m.a aVar, g.a aVar2) {
        this.v = aVar;
        this.w = aVar2;
    }

    public boolean d(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i2 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).c();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams != null) {
            if (layoutParams instanceof c) {
                cVar = new c((c) layoutParams);
            } else {
                cVar = new c(layoutParams);
            }
            if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
                ((LinearLayout.LayoutParams) cVar).gravity = 16;
            }
            return cVar;
        }
        return generateDefaultLayoutParams();
    }

    public c e() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f2208a = true;
        return generateDefaultLayoutParams;
    }
}
