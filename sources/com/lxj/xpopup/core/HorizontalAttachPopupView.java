package com.lxj.xpopup.core;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import c.e.b.a;
import c.e.b.b.c;
import c.e.b.c.b;
import c.e.b.d.d;
import c.e.b.g.e;

/* loaded from: classes.dex */
public class HorizontalAttachPopupView extends AttachPopupView {
    public HorizontalAttachPopupView(Context context) {
        super(context);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView
    public void A() {
        boolean z;
        int i2;
        float f2;
        float height;
        boolean d2 = e.d(getContext());
        int measuredWidth = getPopupContentView().getMeasuredWidth();
        int measuredHeight = getPopupContentView().getMeasuredHeight();
        b bVar = this.f10740a;
        if (bVar.k != null) {
            PointF pointF = a.f6200e;
            if (pointF != null) {
                bVar.k = pointF;
            }
            z = this.f10740a.k.x > ((float) (e.c(getContext()) / 2));
            this.z = z;
            if (d2) {
                f2 = -(z ? (e.c(getContext()) - this.f10740a.k.x) + this.w : ((e.c(getContext()) - this.f10740a.k.x) - getPopupContentView().getMeasuredWidth()) - this.w);
            } else {
                f2 = D() ? (this.f10740a.k.x - measuredWidth) - this.w : this.f10740a.k.x + this.w;
            }
            height = (this.f10740a.k.y - (measuredHeight * 0.5f)) + this.v;
        } else {
            int[] iArr = new int[2];
            bVar.a().getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f10740a.a().getMeasuredWidth(), iArr[1] + this.f10740a.a().getMeasuredHeight());
            z = (rect.left + rect.right) / 2 > e.c(getContext()) / 2;
            this.z = z;
            if (d2) {
                i2 = -(z ? (e.c(getContext()) - rect.left) + this.w : ((e.c(getContext()) - rect.right) - getPopupContentView().getMeasuredWidth()) - this.w);
            } else {
                i2 = D() ? (rect.left - measuredWidth) - this.w : rect.right + this.w;
            }
            f2 = i2;
            height = rect.top + ((rect.height() - measuredHeight) / 2) + this.v;
        }
        getPopupContentView().setTranslationX(f2);
        getPopupContentView().setTranslationY(height);
        B();
    }

    public final boolean D() {
        return (this.z || this.f10740a.t == d.Left) && this.f10740a.t != d.Right;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    public c getPopupAnimator() {
        c.e.b.b.e eVar = D() ? new c.e.b.b.e(getPopupContentView(), c.e.b.d.c.ScrollAlphaFromRight) : new c.e.b.b.e(getPopupContentView(), c.e.b.d.c.ScrollAlphaFromLeft);
        eVar.f6216h = true;
        return eVar;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        b bVar = this.f10740a;
        this.v = bVar.z;
        int i2 = bVar.y;
        if (i2 == 0) {
            i2 = e.a(getContext(), 4.0f);
        }
        this.w = i2;
    }
}
