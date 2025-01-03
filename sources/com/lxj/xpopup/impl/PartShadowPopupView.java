package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.e.b.b.h;
import c.e.b.g.e;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.widget.PartShadowContainer;

/* loaded from: classes.dex */
public abstract class PartShadowPopupView extends BasePopupView {
    public PartShadowContainer v;
    public boolean w;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PartShadowPopupView.this.z();
            PartShadowPopupView.this.A();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PartShadowPopupView.this.z();
        }
    }

    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!PartShadowPopupView.this.f10740a.f6243c.booleanValue()) {
                return false;
            }
            PartShadowPopupView.this.h();
            return false;
        }
    }

    public class d implements c.e.b.e.b {
        public d() {
        }

        @Override // c.e.b.e.b
        public void a() {
            if (PartShadowPopupView.this.f10740a.f6243c.booleanValue()) {
                PartShadowPopupView.this.h();
            }
        }
    }

    public PartShadowPopupView(Context context) {
        super(context);
        this.v = (PartShadowContainer) findViewById(R$id.attachPopupContainer);
    }

    public final void A() {
        q();
        m();
        k();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public c.e.b.b.c getPopupAnimator() {
        return new h(getPopupImplView(), this.w ? c.e.b.d.c.TranslateFromBottom : c.e.b.d.c.TranslateFromTop);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupLayoutId() {
        return R$layout._xpopup_partshadow_popup_view;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new b());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void r() {
        if (this.v.getChildCount() == 0) {
            y();
        }
        if (this.f10740a.f6245e.booleanValue()) {
            this.f10742c.f6205a = getPopupContentView();
        }
        getPopupImplView().setTranslationY(this.f10740a.z);
        e.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a());
    }

    public void y() {
        this.v.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.v, false));
    }

    public void z() {
        if (this.f10740a.a() == null) {
            throw new IllegalArgumentException("atView must not be null for PartShadowPopupView！");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getPopupContentView().getLayoutParams();
        marginLayoutParams.width = getMeasuredWidth();
        int[] iArr = new int[2];
        this.f10740a.a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f10740a.a().getMeasuredWidth(), iArr[1] + this.f10740a.a().getMeasuredHeight());
        if (!this.f10740a.B || getPopupImplView() == null) {
            int i2 = rect.left + this.f10740a.y;
            if (getPopupImplView().getMeasuredWidth() + i2 > e.c(getContext())) {
                i2 -= (getPopupImplView().getMeasuredWidth() + i2) - e.c(getContext());
            }
            getPopupImplView().setTranslationX(i2);
        } else {
            getPopupImplView().setTranslationX(((rect.left + rect.right) / 2) - (getPopupImplView().getMeasuredWidth() / 2));
        }
        int height = rect.top + (rect.height() / 2);
        View childAt = ((ViewGroup) getPopupContentView()).getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if ((height > getMeasuredHeight() / 2 || this.f10740a.t == c.e.b.d.d.Top) && this.f10740a.t != c.e.b.d.d.Bottom) {
            marginLayoutParams.height = rect.top;
            this.w = true;
            layoutParams.gravity = 80;
            if (getMaxHeight() != 0) {
                layoutParams.height = Math.min(childAt.getMeasuredHeight(), getMaxHeight());
            }
        } else {
            int measuredHeight = getMeasuredHeight();
            int i3 = rect.bottom;
            marginLayoutParams.height = measuredHeight - i3;
            this.w = false;
            marginLayoutParams.topMargin = i3;
            layoutParams.gravity = 48;
            if (getMaxHeight() != 0) {
                layoutParams.height = Math.min(childAt.getMeasuredHeight(), getMaxHeight());
            }
            childAt.setLayoutParams(layoutParams);
        }
        getPopupContentView().setLayoutParams(marginLayoutParams);
        childAt.setLayoutParams(layoutParams);
        this.v.setOnLongClickListener(new c());
        this.v.setOnClickOutsideListener(new d());
    }
}
