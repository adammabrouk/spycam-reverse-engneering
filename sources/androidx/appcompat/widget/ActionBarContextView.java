package androidx.appcompat.widget;

import a.b.e.b;
import a.b.e.j.g;
import a.b.f.g0;
import a.b.f.m0;
import a.h.j.y;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class ActionBarContextView extends a.b.f.a {

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f2188i;
    public CharSequence j;
    public View k;
    public View l;
    public View m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public int q;
    public int r;
    public boolean t;
    public int u;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f2189a;

        public a(ActionBarContextView actionBarContextView, b bVar) {
            this.f2189a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f2189a.a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public void a(b bVar) {
        View view = this.k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.u, (ViewGroup) this, false);
            this.k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.k);
        }
        View findViewById = this.k.findViewById(R$id.action_mode_close_button);
        this.l = findViewById;
        findViewById.setOnClickListener(new a(this, bVar));
        g gVar = (g) bVar.c();
        ActionMenuPresenter actionMenuPresenter = this.f417d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f417d = actionMenuPresenter2;
        actionMenuPresenter2.d(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.a(this.f417d, this.f415b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f417d.b(this);
        this.f416c = actionMenuView;
        y.a(actionMenuView, (Drawable) null);
        addView(this.f416c, layoutParams);
    }

    public final void b() {
        if (this.n == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.n = linearLayout;
            this.o = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.p = (TextView) this.n.findViewById(R$id.action_bar_subtitle);
            if (this.q != 0) {
                this.o.setTextAppearance(getContext(), this.q);
            }
            if (this.r != 0) {
                this.p.setTextAppearance(getContext(), this.r);
            }
        }
        this.o.setText(this.f2188i);
        this.p.setText(this.j);
        boolean z = !TextUtils.isEmpty(this.f2188i);
        boolean z2 = !TextUtils.isEmpty(this.j);
        int i2 = 0;
        this.p.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.n;
        if (!z && !z2) {
            i2 = 8;
        }
        linearLayout2.setVisibility(i2);
        if (this.n.getParent() == null) {
            addView(this.n);
        }
    }

    public boolean c() {
        return this.t;
    }

    public void d() {
        removeAllViews();
        this.m = null;
        this.f416c = null;
        this.f417d = null;
        View view = this.l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean e() {
        ActionMenuPresenter actionMenuPresenter = this.f417d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.k();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // a.b.f.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // a.b.f.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f2188i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f417d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.e();
            this.f417d.h();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(ActionBarContextView.class.getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f2188i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean a2 = m0.a(this);
        int paddingRight = a2 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            int i6 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a3 = a.b.f.a.a(paddingRight, i6, a2);
            paddingRight = a.b.f.a.a(a3 + a(this.k, a3, paddingTop, paddingTop2, a2), i7, a2);
        }
        int i8 = paddingRight;
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && this.m == null && linearLayout.getVisibility() != 8) {
            i8 += a(this.n, i8, paddingTop, paddingTop2, a2);
        }
        int i9 = i8;
        View view2 = this.m;
        if (view2 != null) {
            a(view2, i9, paddingTop, paddingTop2, a2);
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f416c;
        if (actionMenuView != null) {
            a(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int i4 = MemoryConstants.GB;
        if (mode != 1073741824) {
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i2);
        int i5 = this.f418e;
        if (i5 <= 0) {
            i5 = View.MeasureSpec.getSize(i3);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i6 = i5 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
        View view = this.k;
        if (view != null) {
            int a2 = a(view, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            paddingLeft = a2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f416c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = a(this.f416c, paddingLeft, makeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && this.m == null) {
            if (this.t) {
                this.n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.n.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.n.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = a(linearLayout, paddingLeft, makeMeasureSpec, 0);
            }
        }
        View view2 = this.m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i7 = layoutParams.width != -2 ? MemoryConstants.GB : Integer.MIN_VALUE;
            int i8 = layoutParams.width;
            if (i8 >= 0) {
                paddingLeft = Math.min(i8, paddingLeft);
            }
            if (layoutParams.height == -2) {
                i4 = Integer.MIN_VALUE;
            }
            int i9 = layoutParams.height;
            if (i9 >= 0) {
                i6 = Math.min(i9, i6);
            }
            this.m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i7), View.MeasureSpec.makeMeasureSpec(i6, i4));
        }
        if (this.f418e > 0) {
            setMeasuredDimension(size, i5);
            return;
        }
        int childCount = getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i10) {
                i10 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i10);
    }

    @Override // a.b.f.a
    public void setContentHeight(int i2) {
        this.f418e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.m;
        if (view2 != null) {
            removeView(view2);
        }
        this.m = view;
        if (view != null && (linearLayout = this.n) != null) {
            removeView(linearLayout);
            this.n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.j = charSequence;
        b();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2188i = charSequence;
        b();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.t) {
            requestLayout();
        }
        this.t = z;
    }

    @Override // a.b.f.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g0 a2 = g0.a(context, attributeSet, R$styleable.ActionMode, i2, 0);
        y.a(this, a2.b(R$styleable.ActionMode_background));
        this.q = a2.g(R$styleable.ActionMode_titleTextStyle, 0);
        this.r = a2.g(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f418e = a2.f(R$styleable.ActionMode_height, 0);
        this.u = a2.g(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        a2.b();
    }

    public void a() {
        if (this.k == null) {
            d();
        }
    }
}
