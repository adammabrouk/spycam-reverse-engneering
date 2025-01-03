package com.google.android.material.bottomnavigation;

import a.b.e.j.g;
import a.b.e.j.i;
import a.b.e.j.n;
import a.h.i.e;
import a.h.j.h0.c;
import a.t.a0;
import a.t.b;
import a.t.y;
import android.R;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R$attr;
import c.c.a.c.r.k;
import com.google.android.material.R$dimen;
import com.google.android.material.badge.BadgeDrawable;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.util.HashSet;

/* loaded from: classes.dex */
public class BottomNavigationMenuView extends ViewGroup implements n {
    public static final int[] A = {R.attr.state_checked};
    public static final int[] B = {-16842910};

    /* renamed from: a, reason: collision with root package name */
    public final a0 f10355a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10356b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10357c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10358d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10359e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10360f;

    /* renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f10361g;

    /* renamed from: h, reason: collision with root package name */
    public final e<BottomNavigationItemView> f10362h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10363i;
    public int j;
    public BottomNavigationItemView[] k;
    public int l;
    public int m;
    public ColorStateList n;
    public int o;
    public ColorStateList p;
    public final ColorStateList q;
    public int r;
    public int t;
    public Drawable u;
    public int v;
    public int[] w;
    public SparseArray<BadgeDrawable> x;
    public BottomNavigationPresenter y;
    public g z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i itemData = ((BottomNavigationItemView) view).getItemData();
            if (BottomNavigationMenuView.this.z.a(itemData, BottomNavigationMenuView.this.y, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView a2 = this.f10362h.a();
        return a2 == null ? new BottomNavigationItemView(getContext()) : a2;
    }

    private void setBadgeIfNeeded(BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        int id = bottomNavigationItemView.getId();
        if (b(id) && (badgeDrawable = this.x.get(id)) != null) {
            bottomNavigationItemView.setBadge(badgeDrawable);
        }
    }

    public final boolean a(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    public final boolean b(int i2) {
        return i2 != -1;
    }

    public void c(int i2) {
        int size = this.z.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.z.getItem(i3);
            if (i2 == item.getItemId()) {
                this.l = i2;
                this.m = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void d() {
        g gVar = this.z;
        if (gVar == null || this.k == null) {
            return;
        }
        int size = gVar.size();
        if (size != this.k.length) {
            a();
            return;
        }
        int i2 = this.l;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.z.getItem(i3);
            if (item.isChecked()) {
                this.l = item.getItemId();
                this.m = i3;
            }
        }
        if (i2 != this.l) {
            y.a(this, this.f10355a);
        }
        boolean a2 = a(this.j, this.z.n().size());
        for (int i4 = 0; i4 < size; i4++) {
            this.y.b(true);
            this.k[i4].setLabelVisibilityMode(this.j);
            this.k[i4].setShifting(a2);
            this.k[i4].a((i) this.z.getItem(i4), 0);
            this.y.b(false);
        }
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.x;
    }

    public ColorStateList getIconTintList() {
        return this.n;
    }

    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        return (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) ? this.u : bottomNavigationItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.v;
    }

    public int getItemIconSize() {
        return this.o;
    }

    public int getItemTextAppearanceActive() {
        return this.t;
    }

    public int getItemTextAppearanceInactive() {
        return this.r;
    }

    public ColorStateList getItemTextColor() {
        return this.p;
    }

    public int getLabelVisibilityMode() {
        return this.j;
    }

    public int getSelectedItemId() {
        return this.l;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        c.a(accessibilityNodeInfo).a(c.b.a(1, this.z.n().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (a.h.j.y.q(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.z.n().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f10360f, MemoryConstants.GB);
        if (a(this.j, size2) && this.f10363i) {
            View childAt = getChildAt(this.m);
            int i4 = this.f10359e;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f10358d, Integer.MIN_VALUE), makeMeasureSpec);
                i4 = Math.max(i4, childAt.getMeasuredWidth());
            }
            int i5 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.f10357c * i5), Math.min(i4, this.f10358d));
            int i6 = size - min;
            int min2 = Math.min(i6 / (i5 == 0 ? 1 : i5), this.f10356b);
            int i7 = i6 - (i5 * min2);
            int i8 = 0;
            while (i8 < childCount) {
                if (getChildAt(i8).getVisibility() != 8) {
                    this.w[i8] = i8 == this.m ? min : min2;
                    if (i7 > 0) {
                        int[] iArr = this.w;
                        iArr[i8] = iArr[i8] + 1;
                        i7--;
                    }
                } else {
                    this.w[i8] = 0;
                }
                i8++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f10358d);
            int i9 = size - (size2 * min3);
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getVisibility() != 8) {
                    int[] iArr2 = this.w;
                    iArr2[i10] = min3;
                    if (i9 > 0) {
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.w[i10] = 0;
                }
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.w[i12], MemoryConstants.GB), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, MemoryConstants.GB), 0), View.resolveSizeAndState(this.f10360f, makeMeasureSpec, 0));
    }

    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.x = sparseArray;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.n = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.u = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.v = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.f10363i = z;
    }

    public void setItemIconSize(int i2) {
        this.o = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.t = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.p;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.r = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.p;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.p = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.j = i2;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.y = bottomNavigationPresenter;
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10362h = new a.h.i.g(5);
        this.l = 0;
        this.m = 0;
        this.x = new SparseArray<>(5);
        Resources resources = getResources();
        this.f10356b = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.f10357c = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.f10358d = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.f10359e = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
        this.f10360f = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_height);
        this.q = a(R.attr.textColorSecondary);
        b bVar = new b();
        this.f10355a = bVar;
        bVar.b(0);
        this.f10355a.a(115L);
        this.f10355a.a((TimeInterpolator) new a.l.a.a.b());
        this.f10355a.a(new k());
        this.f10361g = new a();
        this.w = new int[5];
        a.h.j.y.h(this, 1);
    }

    @Override // a.b.e.j.n
    public void a(g gVar) {
        this.z = gVar;
    }

    public boolean b() {
        return this.f10363i;
    }

    public ColorStateList a(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList b2 = a.b.b.a.a.b(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = b2.getDefaultColor();
        return new ColorStateList(new int[][]{B, A, ViewGroup.EMPTY_STATE_SET}, new int[]{b2.getColorForState(B, defaultColor), i3, defaultColor});
    }

    public final void c() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            hashSet.add(Integer.valueOf(this.z.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.x.size(); i3++) {
            int keyAt = this.x.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.x.delete(keyAt);
            }
        }
    }

    public void a() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.f10362h.a(bottomNavigationItemView);
                    bottomNavigationItemView.c();
                }
            }
        }
        if (this.z.size() == 0) {
            this.l = 0;
            this.m = 0;
            this.k = null;
            return;
        }
        c();
        this.k = new BottomNavigationItemView[this.z.size()];
        boolean a2 = a(this.j, this.z.n().size());
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            this.y.b(true);
            this.z.getItem(i2).setCheckable(true);
            this.y.b(false);
            BottomNavigationItemView newItem = getNewItem();
            this.k[i2] = newItem;
            newItem.setIconTintList(this.n);
            newItem.setIconSize(this.o);
            newItem.setTextColor(this.q);
            newItem.setTextAppearanceInactive(this.r);
            newItem.setTextAppearanceActive(this.t);
            newItem.setTextColor(this.p);
            Drawable drawable = this.u;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.v);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.j);
            newItem.a((i) this.z.getItem(i2), 0);
            newItem.setItemPosition(i2);
            newItem.setOnClickListener(this.f10361g);
            if (this.l != 0 && this.z.getItem(i2).getItemId() == this.l) {
                this.m = i2;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.z.size() - 1, this.m);
        this.m = min;
        this.z.getItem(min).setChecked(true);
    }
}
