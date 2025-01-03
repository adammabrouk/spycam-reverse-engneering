package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.e.b.b.c;
import c.e.b.e.i;
import c.e.b.g.e;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.widget.SmartDragLayout;

/* loaded from: classes.dex */
public class BottomPopupView extends BasePopupView {
    public SmartDragLayout v;

    public class a implements SmartDragLayout.OnCloseListener {
        public a() {
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
        public void onClose() {
            BottomPopupView.this.e();
            BottomPopupView bottomPopupView = BottomPopupView.this;
            i iVar = bottomPopupView.f10740a.r;
            if (iVar != null) {
                iVar.e(bottomPopupView);
            }
            BottomPopupView.this.j();
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
        public void onDrag(int i2, float f2, boolean z) {
            BottomPopupView bottomPopupView = BottomPopupView.this;
            c.e.b.c.b bVar = bottomPopupView.f10740a;
            if (bVar == null) {
                return;
            }
            i iVar = bVar.r;
            if (iVar != null) {
                iVar.a(bottomPopupView, i2, f2, z);
            }
            if (!BottomPopupView.this.f10740a.f6245e.booleanValue() || BottomPopupView.this.f10740a.f6246f.booleanValue()) {
                return;
            }
            BottomPopupView bottomPopupView2 = BottomPopupView.this;
            bottomPopupView2.setBackgroundColor(bottomPopupView2.f10742c.a(f2));
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
        public void onOpen() {
            BottomPopupView.super.k();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomPopupView.this.h();
        }
    }

    public BottomPopupView(Context context) {
        super(context);
        this.v = (SmartDragLayout) findViewById(R$id.bottomPopupContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getMaxWidth() {
        int i2 = this.f10740a.l;
        return i2 == 0 ? e.c(getContext()) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public c getPopupAnimator() {
        return null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupLayoutId() {
        return R$layout._xpopup_bottom_popup_view;
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
        this.v.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void k() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void l() {
        c.e.b.b.a aVar;
        if (this.f10740a.f6246f.booleanValue() && (aVar = this.f10743d) != null) {
            aVar.a();
        }
        this.v.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void m() {
        c.e.b.b.a aVar;
        if (this.f10740a.f6246f.booleanValue() && (aVar = this.f10743d) != null) {
            aVar.b();
        }
        this.v.open();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        if (this.v.getChildCount() == 0) {
            y();
        }
        this.v.enableDrag(this.f10740a.A.booleanValue());
        this.v.dismissOnTouchOutside(this.f10740a.f6243c.booleanValue());
        this.v.isThreeDrag(this.f10740a.H);
        getPopupImplView().setTranslationX(this.f10740a.y);
        getPopupImplView().setTranslationY(this.f10740a.z);
        e.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), null);
        this.v.setOnCloseListener(new a());
        this.v.setOnClickListener(new b());
    }

    public void y() {
        this.v.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.v, false));
    }
}
