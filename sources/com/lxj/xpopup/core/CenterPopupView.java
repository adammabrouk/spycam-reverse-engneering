package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.e.b.b.c;
import c.e.b.b.d;
import c.e.b.g.e;
import com.lxj.xpopup.R$color;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;

/* loaded from: classes.dex */
public class CenterPopupView extends BasePopupView {
    public FrameLayout v;
    public int w;
    public int x;
    public View y;

    public CenterPopupView(Context context) {
        super(context);
        this.v = (FrameLayout) findViewById(R$id.centerPopupContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void b() {
        super.b();
        this.v.setBackground(e.a(getResources().getColor(R$color._xpopup_dark_color), this.f10740a.p));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void c() {
        super.c();
        this.v.setBackground(e.a(getResources().getColor(R$color._xpopup_light_color), this.f10740a.p));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getMaxWidth() {
        int i2 = this.f10740a.l;
        return i2 == 0 ? (int) (e.c(getContext()) * 0.8f) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public c getPopupAnimator() {
        return new d(getPopupContentView(), c.e.b.d.c.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupLayoutId() {
        return R$layout._xpopup_center_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setTranslationY(0.0f);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        if (this.v.getChildCount() == 0) {
            y();
        }
        getPopupContentView().setTranslationX(this.f10740a.y);
        getPopupContentView().setTranslationY(this.f10740a.z);
        e.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), null);
    }

    public void y() {
        View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.v, false);
        this.y = inflate;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 17;
        this.v.addView(this.y, layoutParams);
    }

    public void z() {
        if (this.w == 0) {
            if (this.f10740a.F) {
                b();
            } else {
                c();
            }
        }
    }
}
