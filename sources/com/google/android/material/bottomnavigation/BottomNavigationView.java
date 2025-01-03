package com.google.android.material.bottomnavigation;

import a.b.e.j.g;
import a.h.j.g0;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.customview.view.AbsSavedState;
import c.c.a.c.r.l;
import c.c.a.c.r.r;
import c.c.a.c.w.h;
import c.c.a.c.w.i;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final int f10371h = R$style.Widget_Design_BottomNavigationView;

    /* renamed from: a, reason: collision with root package name */
    public final g f10372a;

    /* renamed from: b, reason: collision with root package name */
    public final BottomNavigationMenuView f10373b;

    /* renamed from: c, reason: collision with root package name */
    public final BottomNavigationPresenter f10374c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f10375d;

    /* renamed from: e, reason: collision with root package name */
    public MenuInflater f10376e;

    /* renamed from: f, reason: collision with root package name */
    public d f10377f;

    /* renamed from: g, reason: collision with root package name */
    public c f10378g;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public Bundle f10379c;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void a(Parcel parcel, ClassLoader classLoader) {
            this.f10379c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f10379c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? SavedState.class.getClassLoader() : classLoader);
        }
    }

    public class a implements g.a {
        public a() {
        }

        @Override // a.b.e.j.g.a
        public void a(g gVar) {
        }

        @Override // a.b.e.j.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            if (BottomNavigationView.this.f10378g == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                return (BottomNavigationView.this.f10377f == null || BottomNavigationView.this.f10377f.a(menuItem)) ? false : true;
            }
            BottomNavigationView.this.f10378g.a(menuItem);
            return true;
        }
    }

    public class b implements r.e {
        public b(BottomNavigationView bottomNavigationView) {
        }

        @Override // c.c.a.c.r.r.e
        public g0 a(View view, g0 g0Var, r.f fVar) {
            fVar.f5604d += g0Var.e();
            fVar.a(view);
            return g0Var;
        }
    }

    public interface c {
        void a(MenuItem menuItem);
    }

    public interface d {
        boolean a(MenuItem menuItem);
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.f10376e == null) {
            this.f10376e = new a.b.e.g(getContext());
        }
        return this.f10376e;
    }

    public Drawable getItemBackground() {
        return this.f10373b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f10373b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f10373b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f10373b.getIconTintList();
    }

    public ColorStateList getItemRippleColor() {
        return this.f10375d;
    }

    public int getItemTextAppearanceActive() {
        return this.f10373b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f10373b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f10373b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f10373b.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.f10372a;
    }

    public int getSelectedItemId() {
        return this.f10373b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f10372a.d(savedState.f10379c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f10379c = bundle;
        this.f10372a.f(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a(this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        this.f10373b.setItemBackground(drawable);
        this.f10375d = null;
    }

    public void setItemBackgroundResource(int i2) {
        this.f10373b.setItemBackgroundRes(i2);
        this.f10375d = null;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f10373b.b() != z) {
            this.f10373b.setItemHorizontalTranslationEnabled(z);
            this.f10374c.a(false);
        }
    }

    public void setItemIconSize(int i2) {
        this.f10373b.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f10373b.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        if (this.f10375d == colorStateList) {
            if (colorStateList != null || this.f10373b.getItemBackground() == null) {
                return;
            }
            this.f10373b.setItemBackground(null);
            return;
        }
        this.f10375d = colorStateList;
        if (colorStateList == null) {
            this.f10373b.setItemBackground(null);
            return;
        }
        ColorStateList a2 = c.c.a.c.u.b.a(colorStateList);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f10373b.setItemBackground(new RippleDrawable(a2, null, null));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(1.0E-5f);
        Drawable i2 = a.h.c.l.a.i(gradientDrawable);
        a.h.c.l.a.a(i2, a2);
        this.f10373b.setItemBackground(i2);
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f10373b.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f10373b.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f10373b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f10373b.getLabelVisibilityMode() != i2) {
            this.f10373b.setLabelVisibilityMode(i2);
            this.f10374c.a(false);
        }
    }

    public void setOnNavigationItemReselectedListener(c cVar) {
        this.f10378g = cVar;
    }

    public void setOnNavigationItemSelectedListener(d dVar) {
        this.f10377f = dVar;
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.f10372a.findItem(i2);
        if (findItem == null || this.f10372a.a(findItem, this.f10374c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomNavigationStyle);
    }

    public final void a() {
        r.a(this, new b(this));
    }

    public final h b(Context context) {
        h hVar = new h();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            hVar.a(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        hVar.a(context);
        return hVar;
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, f10371h), attributeSet, i2);
        this.f10374c = new BottomNavigationPresenter();
        Context context2 = getContext();
        this.f10372a = new c.c.a.c.e.a(context2);
        this.f10373b = new BottomNavigationMenuView(context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f10373b.setLayoutParams(layoutParams);
        this.f10374c.a(this.f10373b);
        this.f10374c.a(1);
        this.f10373b.setPresenter(this.f10374c);
        this.f10372a.a(this.f10374c);
        this.f10374c.a(getContext(), this.f10372a);
        a.b.f.g0 d2 = l.d(context2, attributeSet, R$styleable.BottomNavigationView, i2, R$style.Widget_Design_BottomNavigationView, R$styleable.BottomNavigationView_itemTextAppearanceInactive, R$styleable.BottomNavigationView_itemTextAppearanceActive);
        if (d2.g(R$styleable.BottomNavigationView_itemIconTint)) {
            this.f10373b.setIconTintList(d2.a(R$styleable.BottomNavigationView_itemIconTint));
        } else {
            BottomNavigationMenuView bottomNavigationMenuView = this.f10373b;
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.a(R.attr.textColorSecondary));
        }
        setItemIconSize(d2.c(R$styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_icon_size)));
        if (d2.g(R$styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(d2.g(R$styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (d2.g(R$styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(d2.g(R$styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (d2.g(R$styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(d2.a(R$styleable.BottomNavigationView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            y.a(this, b(context2));
        }
        if (d2.g(R$styleable.BottomNavigationView_elevation)) {
            y.a(this, d2.c(R$styleable.BottomNavigationView_elevation, 0));
        }
        a.h.c.l.a.a(getBackground().mutate(), c.c.a.c.t.c.a(context2, d2, R$styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(d2.e(R$styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(d2.a(R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int g2 = d2.g(R$styleable.BottomNavigationView_itemBackground, 0);
        if (g2 != 0) {
            this.f10373b.setItemBackgroundRes(g2);
        } else {
            setItemRippleColor(c.c.a.c.t.c.a(context2, d2, R$styleable.BottomNavigationView_itemRippleColor));
        }
        if (d2.g(R$styleable.BottomNavigationView_menu)) {
            a(d2.g(R$styleable.BottomNavigationView_menu, 0));
        }
        d2.b();
        addView(this.f10373b, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            a(context2);
        }
        this.f10372a.a(new a());
        a();
    }

    public void a(int i2) {
        this.f10374c.b(true);
        getMenuInflater().inflate(i2, this.f10372a);
        this.f10374c.b(false);
        this.f10374c.a(true);
    }

    public final void a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(a.h.b.a.a(context, R$color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }
}
