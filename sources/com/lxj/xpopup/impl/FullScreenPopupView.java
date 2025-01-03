package com.lxj.xpopup.impl;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.e.b.b.c;
import c.e.b.b.h;
import c.e.b.c.b;
import c.e.b.g.e;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.core.BasePopupView;

/* loaded from: classes.dex */
public class FullScreenPopupView extends BasePopupView {
    public int A;
    public ArgbEvaluator v;
    public View w;
    public FrameLayout x;
    public Paint y;
    public Rect z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FullScreenPopupView.this.A = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            FullScreenPopupView.this.postInvalidate();
        }
    }

    public FullScreenPopupView(Context context) {
        super(context);
        this.v = new ArgbEvaluator();
        this.y = new Paint();
        this.A = 0;
        this.x = (FrameLayout) findViewById(R$id.fullPopupContainer);
    }

    public void a(boolean z) {
        b bVar = this.f10740a;
        if (bVar == null || !bVar.u.booleanValue()) {
            return;
        }
        ArgbEvaluator argbEvaluator = this.v;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(z ? 0 : c.e.b.a.f6198c);
        objArr[1] = Integer.valueOf(z ? c.e.b.a.f6198c : 0);
        ValueAnimator ofObject = ValueAnimator.ofObject(argbEvaluator, objArr);
        ofObject.addUpdateListener(new a());
        ofObject.setDuration(c.e.b.a.a()).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        b bVar = this.f10740a;
        if (bVar == null || !bVar.u.booleanValue()) {
            return;
        }
        this.y.setColor(this.A);
        Rect rect = new Rect(0, 0, getMeasuredWidth(), e.c());
        this.z = rect;
        canvas.drawRect(rect, this.y);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public c getPopupAnimator() {
        return new h(getPopupContentView(), c.e.b.d.c.TranslateFromBottom);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupLayoutId() {
        return R$layout._xpopup_fullscreen_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void l() {
        super.l();
        a(false);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void m() {
        super.m();
        a(true);
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (this.f10740a != null) {
            getPopupContentView().setTranslationX(this.f10740a.y);
        }
        if (this.f10740a != null) {
            getPopupContentView().setTranslationY(this.f10740a.z);
        }
        super.onDetachedFromWindow();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        if (this.x.getChildCount() == 0) {
            y();
        }
        getPopupContentView().setTranslationX(this.f10740a.y);
        getPopupContentView().setTranslationY(this.f10740a.z);
    }

    public void y() {
        View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.x, false);
        this.w = inflate;
        this.x.addView(inflate);
    }
}
