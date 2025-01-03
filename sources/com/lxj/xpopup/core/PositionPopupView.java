package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.e.b.b.c;
import c.e.b.b.d;
import c.e.b.c.b;
import c.e.b.g.e;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.widget.PartShadowContainer;

/* loaded from: classes.dex */
public class PositionPopupView extends BasePopupView {
    public PartShadowContainer v;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PositionPopupView positionPopupView = PositionPopupView.this;
            b bVar = positionPopupView.f10740a;
            if (bVar == null) {
                return;
            }
            if (bVar.B) {
                PositionPopupView.this.v.setTranslationX((!e.d(positionPopupView.getContext()) ? e.c(PositionPopupView.this.getContext()) - PositionPopupView.this.v.getMeasuredWidth() : -(e.c(PositionPopupView.this.getContext()) - PositionPopupView.this.v.getMeasuredWidth())) / 2.0f);
            } else {
                positionPopupView.v.setTranslationX(bVar.y);
            }
            PositionPopupView.this.v.setTranslationY(r0.f10740a.z);
            PositionPopupView.this.y();
        }
    }

    public PositionPopupView(Context context) {
        super(context);
        this.v = (PartShadowContainer) findViewById(R$id.attachPopupContainer);
        this.v.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.v, false));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public c getPopupAnimator() {
        return new d(getPopupContentView(), c.e.b.d.c.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupLayoutId() {
        return R$layout._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        e.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a());
    }

    public void y() {
        q();
        m();
        k();
    }
}
