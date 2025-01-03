package com.lxj.xpopup.core;

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
import c.e.b.d.d;
import c.e.b.e.i;
import c.e.b.g.e;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.widget.PopupDrawerLayout;

/* loaded from: classes.dex */
public abstract class DrawerPopupView extends BasePopupView {
    public ArgbEvaluator A;
    public int B;
    public int C;
    public PopupDrawerLayout v;
    public FrameLayout w;
    public float x;
    public Paint y;
    public Rect z;

    public class a implements PopupDrawerLayout.OnCloseListener {
        public a() {
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
        public void onClose() {
            i iVar;
            DrawerPopupView.this.e();
            DrawerPopupView drawerPopupView = DrawerPopupView.this;
            c.e.b.c.b bVar = drawerPopupView.f10740a;
            if (bVar != null && (iVar = bVar.r) != null) {
                iVar.e(drawerPopupView);
            }
            DrawerPopupView.this.j();
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
        public void onDrag(int i2, float f2, boolean z) {
            i iVar;
            DrawerPopupView drawerPopupView = DrawerPopupView.this;
            drawerPopupView.v.isDrawStatusBarShadow = drawerPopupView.f10740a.u.booleanValue();
            DrawerPopupView drawerPopupView2 = DrawerPopupView.this;
            c.e.b.c.b bVar = drawerPopupView2.f10740a;
            if (bVar != null && (iVar = bVar.r) != null) {
                iVar.a(drawerPopupView2, i2, f2, z);
            }
            DrawerPopupView drawerPopupView3 = DrawerPopupView.this;
            drawerPopupView3.x = f2;
            drawerPopupView3.postInvalidate();
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
        public void onOpen() {
            DrawerPopupView.super.k();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DrawerPopupView.this.B = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            DrawerPopupView.this.postInvalidate();
        }
    }

    public DrawerPopupView(Context context) {
        super(context);
        this.x = 0.0f;
        this.y = new Paint();
        this.A = new ArgbEvaluator();
        this.C = 0;
        this.v = (PopupDrawerLayout) findViewById(R$id.drawerLayout);
        this.w = (FrameLayout) findViewById(R$id.drawerContentContainer);
        this.w.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.w, false));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null || !bVar.u.booleanValue()) {
            return;
        }
        if (this.z == null) {
            this.z = new Rect(0, 0, getMeasuredWidth(), e.c());
        }
        this.y.setColor(((Integer) this.A.evaluate(this.x, Integer.valueOf(this.C), Integer.valueOf(c.e.b.a.f6198c))).intValue());
        canvas.drawRect(this.z, this.y);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public c getPopupAnimator() {
        return null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public View getPopupImplView() {
        return this.w.getChildAt(0);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupLayoutId() {
        return R$layout._xpopup_drawer_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void h() {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null) {
            return;
        }
        c.e.b.d.e eVar = this.f10745f;
        c.e.b.d.e eVar2 = c.e.b.d.e.Dismissing;
        if (eVar == eVar2) {
            return;
        }
        this.f10745f = eVar2;
        if (bVar.q.booleanValue()) {
            c.e.b.g.c.a(this);
        }
        clearFocus();
        a(false);
        this.v.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void k() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void l() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void m() {
        this.v.open();
        a(true);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        this.v.enableShadow = this.f10740a.f6245e.booleanValue();
        this.v.isDismissOnTouchOutside = this.f10740a.f6243c.booleanValue();
        this.v.setOnCloseListener(new a());
        getPopupImplView().setTranslationX(this.f10740a.y);
        getPopupImplView().setTranslationY(this.f10740a.z);
        PopupDrawerLayout popupDrawerLayout = this.v;
        d dVar = this.f10740a.t;
        if (dVar == null) {
            dVar = d.Left;
        }
        popupDrawerLayout.setDrawerPosition(dVar);
        this.v.enableDrag = this.f10740a.A.booleanValue();
    }

    public void a(boolean z) {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null || !bVar.u.booleanValue()) {
            return;
        }
        ArgbEvaluator argbEvaluator = this.A;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(z ? 0 : c.e.b.a.f6198c);
        objArr[1] = Integer.valueOf(z ? c.e.b.a.f6198c : 0);
        ValueAnimator ofObject = ValueAnimator.ofObject(argbEvaluator, objArr);
        ofObject.addUpdateListener(new b());
        ofObject.setDuration(c.e.b.a.a()).start();
    }
}
