package com.google.android.material.bottomnavigation;

import a.b.e.j.i;
import a.b.e.j.n;
import a.b.f.i0;
import a.h.j.h0.c;
import a.h.j.w;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes.dex */
public class BottomNavigationItemView extends FrameLayout implements n.a {
    public static final int[] p = {R.attr.state_checked};

    /* renamed from: a, reason: collision with root package name */
    public final int f10345a;

    /* renamed from: b, reason: collision with root package name */
    public float f10346b;

    /* renamed from: c, reason: collision with root package name */
    public float f10347c;

    /* renamed from: d, reason: collision with root package name */
    public float f10348d;

    /* renamed from: e, reason: collision with root package name */
    public int f10349e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10350f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f10351g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f10352h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f10353i;
    public int j;
    public i k;
    public ColorStateList l;
    public Drawable m;
    public Drawable n;
    public BadgeDrawable o;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (BottomNavigationItemView.this.f10351g.getVisibility() == 0) {
                BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                bottomNavigationItemView.d(bottomNavigationItemView.f10351g);
            }
        }
    }

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public final void b(View view) {
        if (a() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            c.c.a.c.c.a.a(this.o, view, a(view));
        }
    }

    @Override // a.b.e.j.n.a
    public boolean b() {
        return false;
    }

    public void c() {
        c(this.f10351g);
    }

    public final void d(View view) {
        if (a()) {
            c.c.a.c.c.a.c(this.o, view, a(view));
        }
    }

    public BadgeDrawable getBadge() {
        return this.o;
    }

    @Override // a.b.e.j.n.a
    public i getItemData() {
        return this.k;
    }

    public int getItemPosition() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.k;
        if (iVar != null && iVar.isCheckable() && this.k.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, p);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.o;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.k.getTitle();
            if (!TextUtils.isEmpty(this.k.getContentDescription())) {
                title = this.k.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.o.c()));
        }
        c a2 = c.a(accessibilityNodeInfo);
        a2.b(c.C0028c.a(0, 1, getItemPosition(), 1, false, isSelected()));
        if (isSelected()) {
            a2.e(false);
            a2.b(c.a.f1176g);
        }
        a2.g(getResources().getString(R$string.item_view_role_description));
    }

    public void setBadge(BadgeDrawable badgeDrawable) {
        this.o = badgeDrawable;
        ImageView imageView = this.f10351g;
        if (imageView != null) {
            b(imageView);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.f10353i.setPivotX(r0.getWidth() / 2);
        this.f10353i.setPivotY(r0.getBaseline());
        this.f10352h.setPivotX(r0.getWidth() / 2);
        this.f10352h.setPivotY(r0.getBaseline());
        int i2 = this.f10349e;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    a(this.f10351g, this.f10345a, 49);
                    a(this.f10353i, 1.0f, 1.0f, 0);
                } else {
                    a(this.f10351g, this.f10345a, 17);
                    a(this.f10353i, 0.5f, 0.5f, 4);
                }
                this.f10352h.setVisibility(4);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    a(this.f10351g, this.f10345a, 17);
                    this.f10353i.setVisibility(8);
                    this.f10352h.setVisibility(8);
                }
            } else if (z) {
                a(this.f10351g, (int) (this.f10345a + this.f10346b), 49);
                a(this.f10353i, 1.0f, 1.0f, 0);
                TextView textView = this.f10352h;
                float f2 = this.f10347c;
                a(textView, f2, f2, 4);
            } else {
                a(this.f10351g, this.f10345a, 49);
                TextView textView2 = this.f10353i;
                float f3 = this.f10348d;
                a(textView2, f3, f3, 4);
                a(this.f10352h, 1.0f, 1.0f, 0);
            }
        } else if (this.f10350f) {
            if (z) {
                a(this.f10351g, this.f10345a, 49);
                a(this.f10353i, 1.0f, 1.0f, 0);
            } else {
                a(this.f10351g, this.f10345a, 17);
                a(this.f10353i, 0.5f, 0.5f, 4);
            }
            this.f10352h.setVisibility(4);
        } else if (z) {
            a(this.f10351g, (int) (this.f10345a + this.f10346b), 49);
            a(this.f10353i, 1.0f, 1.0f, 0);
            TextView textView3 = this.f10352h;
            float f4 = this.f10347c;
            a(textView3, f4, f4, 4);
        } else {
            a(this.f10351g, this.f10345a, 49);
            TextView textView4 = this.f10353i;
            float f5 = this.f10348d;
            a(textView4, f5, f5, 4);
            a(this.f10352h, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f10352h.setEnabled(z);
        this.f10353i.setEnabled(z);
        this.f10351g.setEnabled(z);
        if (z) {
            y.a(this, w.a(getContext(), 1002));
        } else {
            y.a(this, (w) null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.m) {
            return;
        }
        this.m = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = a.h.c.l.a.i(drawable).mutate();
            this.n = drawable;
            ColorStateList colorStateList = this.l;
            if (colorStateList != null) {
                a.h.c.l.a.a(drawable, colorStateList);
            }
        }
        this.f10351g.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10351g.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f10351g.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.l = colorStateList;
        if (this.k == null || (drawable = this.n) == null) {
            return;
        }
        a.h.c.l.a.a(drawable, colorStateList);
        this.n.invalidateSelf();
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : a.h.b.a.c(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.j = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f10349e != i2) {
            this.f10349e = i2;
            if (this.k != null) {
                setChecked(this.k.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f10350f != z) {
            this.f10350f = z;
            if (this.k != null) {
                setChecked(this.k.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i2) {
        a.h.k.i.d(this.f10353i, i2);
        a(this.f10352h.getTextSize(), this.f10353i.getTextSize());
    }

    public void setTextAppearanceInactive(int i2) {
        a.h.k.i.d(this.f10352h, i2);
        a(this.f10352h.getTextSize(), this.f10353i.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f10352h.setTextColor(colorStateList);
            this.f10353i.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f10352h.setText(charSequence);
        this.f10353i.setText(charSequence);
        i iVar = this.k;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        i iVar2 = this.k;
        if (iVar2 != null && !TextUtils.isEmpty(iVar2.getTooltipText())) {
            charSequence = this.k.getTooltipText();
        }
        i0.a(this, charSequence);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c(View view) {
        if (a()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                c.c.a.c.c.a.b(this.o, view, a(view));
            }
            this.o = null;
        }
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(R$layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(R$drawable.design_bottom_navigation_item_background);
        this.f10345a = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_margin);
        this.f10351g = (ImageView) findViewById(R$id.icon);
        this.f10352h = (TextView) findViewById(R$id.smallLabel);
        this.f10353i = (TextView) findViewById(R$id.largeLabel);
        y.h(this.f10352h, 2);
        y.h(this.f10353i, 2);
        setFocusable(true);
        a(this.f10352h.getTextSize(), this.f10353i.getTextSize());
        ImageView imageView = this.f10351g;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    @Override // a.b.e.j.n.a
    public void a(i iVar, int i2) {
        CharSequence title;
        this.k = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        if (!TextUtils.isEmpty(iVar.getTooltipText())) {
            title = iVar.getTooltipText();
        } else {
            title = iVar.getTitle();
        }
        i0.a(this, title);
        setVisibility(iVar.isVisible() ? 0 : 8);
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        y.a(this, drawable);
    }

    public final void a(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    public final void a(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    public final void a(float f2, float f3) {
        this.f10346b = f2 - f3;
        this.f10347c = (f3 * 1.0f) / f2;
        this.f10348d = (f2 * 1.0f) / f3;
    }

    public final boolean a() {
        return this.o != null;
    }

    public final FrameLayout a(View view) {
        ImageView imageView = this.f10351g;
        if (view == imageView && c.c.a.c.c.a.f5356a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }
}
