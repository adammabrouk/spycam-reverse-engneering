package androidx.appcompat.widget;

import a.b.a.a;
import a.b.e.j.g;
import a.b.e.j.i;
import a.b.e.j.m;
import a.b.e.j.r;
import a.b.f.g0;
import a.b.f.h0;
import a.b.f.m0;
import a.b.f.q;
import a.b.f.z;
import a.h.j.h;
import a.h.j.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public final ArrayList<View> E;
    public final ArrayList<View> F;
    public final int[] G;
    public f H;
    public final ActionMenuView.e I;
    public h0 J;
    public ActionMenuPresenter K;
    public d L;
    public m.a M;
    public g.a N;
    public boolean O;
    public final Runnable P;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f2365a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f2366b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f2367c;

    /* renamed from: d, reason: collision with root package name */
    public ImageButton f2368d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f2369e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2370f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f2371g;

    /* renamed from: h, reason: collision with root package name */
    public ImageButton f2372h;

    /* renamed from: i, reason: collision with root package name */
    public View f2373i;
    public Context j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int t;
    public z u;
    public int v;
    public int w;
    public int x;
    public CharSequence y;
    public CharSequence z;

    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.H;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.r();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.c();
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        return new a.b.e.g(getContext());
    }

    public void a(g gVar, ActionMenuPresenter actionMenuPresenter) {
        if (gVar == null && this.f2365a == null) {
            return;
        }
        i();
        g j = this.f2365a.j();
        if (j == gVar) {
            return;
        }
        if (j != null) {
            j.b(this.K);
            j.b(this.L);
        }
        if (this.L == null) {
            this.L = new d();
        }
        actionMenuPresenter.c(true);
        if (gVar != null) {
            gVar.a(actionMenuPresenter, this.j);
            gVar.a(this.L, this.j);
        } else {
            actionMenuPresenter.a(this.j, (g) null);
            this.L.a(this.j, (g) null);
            actionMenuPresenter.a(true);
            this.L.a(true);
        }
        this.f2365a.setPopupTheme(this.k);
        this.f2365a.setPresenter(actionMenuPresenter);
        this.K = actionMenuPresenter;
    }

    public boolean b() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f2365a) != null && actionMenuView.i();
    }

    public void c() {
        d dVar = this.L;
        i iVar = dVar == null ? null : dVar.f2380b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public void d() {
        ActionMenuView actionMenuView = this.f2365a;
        if (actionMenuView != null) {
            actionMenuView.d();
        }
    }

    public void e() {
        if (this.f2372h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f2372h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f2370f);
            this.f2372h.setContentDescription(this.f2371g);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f147a = 8388611 | (this.n & 112);
            generateDefaultLayoutParams.f2382b = 2;
            this.f2372h.setLayoutParams(generateDefaultLayoutParams);
            this.f2372h.setOnClickListener(new c());
        }
    }

    public final void f() {
        if (this.u == null) {
            this.u = new z();
        }
    }

    public final void g() {
        if (this.f2369e == null) {
            this.f2369e = new AppCompatImageView(getContext());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f2372h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f2372h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        z zVar = this.u;
        if (zVar != null) {
            return zVar.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.w;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        z zVar = this.u;
        if (zVar != null) {
            return zVar.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        z zVar = this.u;
        if (zVar != null) {
            return zVar.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        z zVar = this.u;
        if (zVar != null) {
            return zVar.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        g j;
        ActionMenuView actionMenuView = this.f2365a;
        return actionMenuView != null && (j = actionMenuView.j()) != null && j.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return y.q(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return y.q(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f2369e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f2369e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        h();
        return this.f2365a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f2368d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f2368d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        h();
        return this.f2365a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public final TextView getSubtitleTextView() {
        return this.f2367c;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    public final TextView getTitleTextView() {
        return this.f2366b;
    }

    public q getWrapper() {
        if (this.J == null) {
            this.J = new h0(this, true);
        }
        return this.J;
    }

    public final void h() {
        i();
        if (this.f2365a.j() == null) {
            g gVar = (g) this.f2365a.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.f2365a.setExpandedActionViewsExclusive(true);
            gVar.a(this.L, this.j);
        }
    }

    public final void i() {
        if (this.f2365a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f2365a = actionMenuView;
            actionMenuView.setPopupTheme(this.k);
            this.f2365a.setOnMenuItemClickListener(this.I);
            this.f2365a.a(this.M, this.N);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f147a = 8388613 | (this.n & 112);
            this.f2365a.setLayoutParams(generateDefaultLayoutParams);
            a((View) this.f2365a, false);
        }
    }

    public final void j() {
        if (this.f2368d == null) {
            this.f2368d = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f147a = 8388611 | (this.n & 112);
            this.f2368d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    public boolean k() {
        d dVar = this.L;
        return (dVar == null || dVar.f2380b == null) ? false : true;
    }

    public boolean l() {
        ActionMenuView actionMenuView = this.f2365a;
        return actionMenuView != null && actionMenuView.f();
    }

    public boolean m() {
        ActionMenuView actionMenuView = this.f2365a;
        return actionMenuView != null && actionMenuView.g();
    }

    public boolean n() {
        ActionMenuView actionMenuView = this.f2365a;
        return actionMenuView != null && actionMenuView.h();
    }

    public final void o() {
        removeCallbacks(this.P);
        post(this.P);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02a3 A[LOOP:0: B:41:0x02a1->B:42:0x02a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c5 A[LOOP:1: B:45:0x02c3->B:46:0x02c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02fe A[LOOP:2: B:54:0x02fc->B:55:0x02fe, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0229  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 787
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.G;
        if (m0.a(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (d(this.f2368d)) {
            a(this.f2368d, i2, 0, i3, 0, this.o);
            i4 = this.f2368d.getMeasuredWidth() + a(this.f2368d);
            i5 = Math.max(0, this.f2368d.getMeasuredHeight() + b(this.f2368d));
            i6 = View.combineMeasuredStates(0, this.f2368d.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (d(this.f2372h)) {
            a(this.f2372h, i2, 0, i3, 0, this.o);
            i4 = this.f2372h.getMeasuredWidth() + a(this.f2372h);
            i5 = Math.max(i5, this.f2372h.getMeasuredHeight() + b(this.f2372h));
            i6 = View.combineMeasuredStates(i6, this.f2372h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i4);
        iArr[c2] = Math.max(0, currentContentInsetStart - i4);
        if (d(this.f2365a)) {
            a(this.f2365a, i2, max, i3, 0, this.o);
            i7 = this.f2365a.getMeasuredWidth() + a(this.f2365a);
            i5 = Math.max(i5, this.f2365a.getMeasuredHeight() + b(this.f2365a));
            i6 = View.combineMeasuredStates(i6, this.f2365a.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c3] = Math.max(0, currentContentInsetEnd - i7);
        if (d(this.f2373i)) {
            max2 += a(this.f2373i, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f2373i.getMeasuredHeight() + b(this.f2373i));
            i6 = View.combineMeasuredStates(i6, this.f2373i.getMeasuredState());
        }
        if (d(this.f2369e)) {
            max2 += a(this.f2369e, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f2369e.getMeasuredHeight() + b(this.f2369e));
            i6 = View.combineMeasuredStates(i6, this.f2369e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((e) childAt.getLayoutParams()).f2382b == 0 && d(childAt)) {
                max2 += a(childAt, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, childAt.getMeasuredHeight() + b(childAt));
                i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
            }
        }
        int i12 = this.r + this.t;
        int i13 = this.p + this.q;
        if (d(this.f2366b)) {
            a(this.f2366b, i2, max2 + i13, i3, i12, iArr);
            int measuredWidth = this.f2366b.getMeasuredWidth() + a(this.f2366b);
            i10 = this.f2366b.getMeasuredHeight() + b(this.f2366b);
            i8 = View.combineMeasuredStates(i6, this.f2366b.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i8 = i6;
            i9 = 0;
            i10 = 0;
        }
        if (d(this.f2367c)) {
            i9 = Math.max(i9, a(this.f2367c, i2, max2 + i13, i3, i10 + i12, iArr));
            i10 += this.f2367c.getMeasuredHeight() + b(this.f2367c);
            i8 = View.combineMeasuredStates(i8, this.f2367c.getMeasuredState());
        }
        int max3 = Math.max(i5, i10);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i9 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & i8), q() ? 0 : View.resolveSizeAndState(Math.max(max3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, i8 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f2365a;
        g j = actionMenuView != null ? actionMenuView.j() : null;
        int i2 = savedState.f2374c;
        if (i2 != 0 && this.L != null && j != null && (findItem = j.findItem(i2)) != null) {
            findItem.expandActionView();
        }
        if (savedState.f2375d) {
            o();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        f();
        this.u.a(i2 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.L;
        if (dVar != null && (iVar = dVar.f2380b) != null) {
            savedState.f2374c = iVar.getItemId();
        }
        savedState.f2375d = n();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void p() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f2382b != 2 && childAt != this.f2365a) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public final boolean q() {
        if (!this.O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (d(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean r() {
        ActionMenuView actionMenuView = this.f2365a;
        return actionMenuView != null && actionMenuView.k();
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(a.b.b.a.a.c(getContext(), i2));
    }

    public void setCollapsible(boolean z) {
        this.O = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.w) {
            this.w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.v) {
            this.v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(a.b.b.a.a.c(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(a.b.b.a.a.c(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        j();
        this.f2368d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.H = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        h();
        this.f2365a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.k != i2) {
            this.k = i2;
            if (i2 == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.t = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.p = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public static class e extends a.C0001a {

        /* renamed from: b, reason: collision with root package name */
        public int f2382b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2382b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i2, int i3) {
            super(i2, i3);
            this.f2382b = 0;
            this.f147a = 8388627;
        }

        public e(e eVar) {
            super((a.C0001a) eVar);
            this.f2382b = 0;
            this.f2382b = eVar.f2382b;
        }

        public e(a.C0001a c0001a) {
            super(c0001a);
            this.f2382b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2382b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2382b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public void b(Context context, int i2) {
        this.l = i2;
        TextView textView = this.f2366b;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    @Override // android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.f2372h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            e();
            this.f2372h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f2372h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f2370f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!c(this.f2369e)) {
                a((View) this.f2369e, true);
            }
        } else {
            ImageView imageView = this.f2369e;
            if (imageView != null && c(imageView)) {
                removeView(this.f2369e);
                this.F.remove(this.f2369e);
            }
        }
        ImageView imageView2 = this.f2369e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageView imageView = this.f2369e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        ImageButton imageButton = this.f2368d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!c(this.f2368d)) {
                a((View) this.f2368d, true);
            }
        } else {
            ImageButton imageButton = this.f2368d;
            if (imageButton != null && c(imageButton)) {
                removeView(this.f2368d);
                this.F.remove(this.f2368d);
            }
        }
        ImageButton imageButton2 = this.f2368d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2367c;
            if (textView != null && c(textView)) {
                removeView(this.f2367c);
                this.F.remove(this.f2367c);
            }
        } else {
            if (this.f2367c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2367c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2367c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.f2367c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f2367c.setTextColor(colorStateList);
                }
            }
            if (!c(this.f2367c)) {
                a((View) this.f2367c, true);
            }
        }
        TextView textView2 = this.f2367c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f2367c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2366b;
            if (textView != null && c(textView)) {
                removeView(this.f2366b);
                this.F.remove(this.f2366b);
            }
        } else {
            if (this.f2366b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2366b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2366b.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.l;
                if (i2 != 0) {
                    this.f2366b.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f2366b.setTextColor(colorStateList);
                }
            }
            if (!c(this.f2366b)) {
                a((View) this.f2366b, true);
            }
        }
        TextView textView2 = this.f2366b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f2366b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public int f2374c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2375d;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            this.f2374c = parcel.readInt();
            this.f2375d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2374c);
            parcel.writeInt(this.f2375d ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public class d implements m {

        /* renamed from: a, reason: collision with root package name */
        public g f2379a;

        /* renamed from: b, reason: collision with root package name */
        public i f2380b;

        public d() {
        }

        @Override // a.b.e.j.m
        public void a(g gVar, boolean z) {
        }

        @Override // a.b.e.j.m
        public void a(m.a aVar) {
        }

        @Override // a.b.e.j.m
        public void a(Context context, g gVar) {
            i iVar;
            g gVar2 = this.f2379a;
            if (gVar2 != null && (iVar = this.f2380b) != null) {
                gVar2.a(iVar);
            }
            this.f2379a = gVar;
        }

        @Override // a.b.e.j.m
        public void a(Parcelable parcelable) {
        }

        @Override // a.b.e.j.m
        public boolean a(r rVar) {
            return false;
        }

        @Override // a.b.e.j.m
        public boolean b(g gVar, i iVar) {
            Toolbar.this.e();
            ViewParent parent = Toolbar.this.f2372h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f2372h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f2372h);
            }
            Toolbar.this.f2373i = iVar.getActionView();
            this.f2380b = iVar;
            ViewParent parent2 = Toolbar.this.f2373i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f2373i);
                }
                e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f147a = 8388611 | (toolbar4.n & 112);
                generateDefaultLayoutParams.f2382b = 2;
                toolbar4.f2373i.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f2373i);
            }
            Toolbar.this.p();
            Toolbar.this.requestLayout();
            iVar.a(true);
            KeyEvent.Callback callback = Toolbar.this.f2373i;
            if (callback instanceof a.b.e.c) {
                ((a.b.e.c) callback).a();
            }
            return true;
        }

        @Override // a.b.e.j.m
        public int c() {
            return 0;
        }

        @Override // a.b.e.j.m
        public boolean f() {
            return false;
        }

        @Override // a.b.e.j.m
        public Parcelable g() {
            return null;
        }

        @Override // a.b.e.j.m
        public void a(boolean z) {
            if (this.f2380b != null) {
                g gVar = this.f2379a;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        if (this.f2379a.getItem(i2) == this.f2380b) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (z2) {
                    return;
                }
                a(this.f2379a, this.f2380b);
            }
        }

        @Override // a.b.e.j.m
        public boolean a(g gVar, i iVar) {
            KeyEvent.Callback callback = Toolbar.this.f2373i;
            if (callback instanceof a.b.e.c) {
                ((a.b.e.c) callback).c();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f2373i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f2372h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f2373i = null;
            toolbar3.a();
            this.f2380b = null;
            Toolbar.this.requestLayout();
            iVar.a(false);
            return true;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.P = new b();
        g0 a2 = g0.a(getContext(), attributeSet, R$styleable.Toolbar, i2, 0);
        y.a(this, context, R$styleable.Toolbar, attributeSet, a2.a(), i2, 0);
        this.l = a2.g(R$styleable.Toolbar_titleTextAppearance, 0);
        this.m = a2.g(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.x = a2.e(R$styleable.Toolbar_android_gravity, this.x);
        this.n = a2.e(R$styleable.Toolbar_buttonGravity, 48);
        int b2 = a2.b(R$styleable.Toolbar_titleMargin, 0);
        b2 = a2.g(R$styleable.Toolbar_titleMargins) ? a2.b(R$styleable.Toolbar_titleMargins, b2) : b2;
        this.t = b2;
        this.r = b2;
        this.q = b2;
        this.p = b2;
        int b3 = a2.b(R$styleable.Toolbar_titleMarginStart, -1);
        if (b3 >= 0) {
            this.p = b3;
        }
        int b4 = a2.b(R$styleable.Toolbar_titleMarginEnd, -1);
        if (b4 >= 0) {
            this.q = b4;
        }
        int b5 = a2.b(R$styleable.Toolbar_titleMarginTop, -1);
        if (b5 >= 0) {
            this.r = b5;
        }
        int b6 = a2.b(R$styleable.Toolbar_titleMarginBottom, -1);
        if (b6 >= 0) {
            this.t = b6;
        }
        this.o = a2.c(R$styleable.Toolbar_maxButtonHeight, -1);
        int b7 = a2.b(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int b8 = a2.b(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int c2 = a2.c(R$styleable.Toolbar_contentInsetLeft, 0);
        int c3 = a2.c(R$styleable.Toolbar_contentInsetRight, 0);
        f();
        this.u.a(c2, c3);
        if (b7 != Integer.MIN_VALUE || b8 != Integer.MIN_VALUE) {
            this.u.b(b7, b8);
        }
        this.v = a2.b(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = a2.b(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f2370f = a2.b(R$styleable.Toolbar_collapseIcon);
        this.f2371g = a2.e(R$styleable.Toolbar_collapseContentDescription);
        CharSequence e2 = a2.e(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(e2)) {
            setTitle(e2);
        }
        CharSequence e3 = a2.e(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(e3)) {
            setSubtitle(e3);
        }
        this.j = getContext();
        setPopupTheme(a2.g(R$styleable.Toolbar_popupTheme, 0));
        Drawable b9 = a2.b(R$styleable.Toolbar_navigationIcon);
        if (b9 != null) {
            setNavigationIcon(b9);
        }
        CharSequence e4 = a2.e(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(e4)) {
            setNavigationContentDescription(e4);
        }
        Drawable b10 = a2.b(R$styleable.Toolbar_logo);
        if (b10 != null) {
            setLogo(b10);
        }
        CharSequence e5 = a2.e(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(e5)) {
            setLogoDescription(e5);
        }
        if (a2.g(R$styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.a(R$styleable.Toolbar_titleTextColor));
        }
        if (a2.g(R$styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.a(R$styleable.Toolbar_subtitleTextColor));
        }
        if (a2.g(R$styleable.Toolbar_menu)) {
            c(a2.g(R$styleable.Toolbar_menu, 0));
        }
        a2.b();
    }

    public final boolean d(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void c(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof a.C0001a) {
            return new e((a.C0001a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    public final int b(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    public final boolean c(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public final int b(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.x & 112;
    }

    public final int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public void a(Context context, int i2) {
        this.m = i2;
        TextView textView = this.f2367c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void a(int i2, int i3) {
        f();
        this.u.b(i2, i3);
    }

    public final void a(View view, boolean z) {
        e eVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            eVar = generateLayoutParams(layoutParams);
        } else {
            eVar = (e) layoutParams;
        }
        eVar.f2382b = 1;
        if (z && this.f2373i != null) {
            view.setLayoutParams(eVar);
            this.F.add(view);
        } else {
            addView(view, eVar);
        }
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, MemoryConstants.GB);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final int a(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final int a(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = list.get(i4);
            e eVar = (e) view.getLayoutParams();
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i2;
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = max4;
            i2 = max3;
        }
        return i5;
    }

    public final int a(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    public final int a(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int b2 = b(eVar.f147a);
        if (b2 == 48) {
            return getPaddingTop() - i3;
        }
        if (b2 != 80) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
            int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
            if (i4 < i5) {
                i4 = i5;
            } else {
                int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                if (i6 < i7) {
                    i4 = Math.max(0, i4 - (i7 - i6));
                }
            }
            return paddingTop + i4;
        }
        return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i3;
    }

    public final void a(List<View> list, int i2) {
        boolean z = y.q(this) == 1;
        int childCount = getChildCount();
        int a2 = a.h.j.e.a(i2, y.q(this));
        list.clear();
        if (!z) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f2382b == 0 && d(childAt) && a(eVar.f147a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f2382b == 0 && d(childAt2) && a(eVar2.f147a) == a2) {
                list.add(childAt2);
            }
        }
    }

    public final int a(int i2) {
        int q = y.q(this);
        int a2 = a.h.j.e.a(i2, q) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : q == 1 ? 5 : 3;
    }

    public final int a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return h.b(marginLayoutParams) + h.a(marginLayoutParams);
    }

    public void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    public void a(m.a aVar, g.a aVar2) {
        this.M = aVar;
        this.N = aVar2;
        ActionMenuView actionMenuView = this.f2365a;
        if (actionMenuView != null) {
            actionMenuView.a(aVar, aVar2);
        }
    }
}
