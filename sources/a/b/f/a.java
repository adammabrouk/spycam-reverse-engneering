package a.b.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;

/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C0006a f414a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f415b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f416c;

    /* renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f417d;

    /* renamed from: e, reason: collision with root package name */
    public int f418e;

    /* renamed from: f, reason: collision with root package name */
    public a.h.j.c0 f419f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f420g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f421h;

    public a(Context context) {
        this(context, null);
    }

    public static int a(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    public int getAnimatedVisibility() {
        return this.f419f != null ? this.f414a.f423b : getVisibility();
    }

    public int getContentHeight() {
        return this.f418e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f417d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f421h = false;
        }
        if (!this.f421h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f421h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f421h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f420g = false;
        }
        if (!this.f420g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f420g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f420g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            a.h.j.c0 c0Var = this.f419f;
            if (c0Var != null) {
                c0Var.a();
            }
            super.setVisibility(i2);
        }
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: a.b.f.a$a, reason: collision with other inner class name */
    public class C0006a implements a.h.j.d0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f422a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f423b;

        public C0006a() {
        }

        public C0006a a(a.h.j.c0 c0Var, int i2) {
            a.this.f419f = c0Var;
            this.f423b = i2;
            return this;
        }

        @Override // a.h.j.d0
        public void b(View view) {
            if (this.f422a) {
                return;
            }
            a aVar = a.this;
            aVar.f419f = null;
            a.super.setVisibility(this.f423b);
        }

        @Override // a.h.j.d0
        public void c(View view) {
            a.super.setVisibility(0);
            this.f422a = false;
        }

        @Override // a.h.j.d0
        public void a(View view) {
            this.f422a = true;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a.h.j.c0 a(int i2, long j) {
        a.h.j.c0 c0Var = this.f419f;
        if (c0Var != null) {
            c0Var.a();
        }
        if (i2 != 0) {
            a.h.j.c0 a2 = a.h.j.y.a(this);
            a2.a(0.0f);
            a2.a(j);
            C0006a c0006a = this.f414a;
            c0006a.a(a2, i2);
            a2.a(c0006a);
            return a2;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        a.h.j.c0 a3 = a.h.j.y.a(this);
        a3.a(1.0f);
        a3.a(j);
        C0006a c0006a2 = this.f414a;
        c0006a2.a(a3, i2);
        a3.a(c0006a2);
        return a3;
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f414a = new C0006a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f415b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f415b = context;
        }
    }

    public int a(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    public int a(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
