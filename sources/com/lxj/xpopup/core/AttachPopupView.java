package com.lxj.xpopup.core;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.e.b.d.d;
import c.e.b.g.e;
import com.lxj.xpopup.R$color;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.widget.PartShadowContainer;

/* loaded from: classes.dex */
public abstract class AttachPopupView extends BasePopupView {
    public int A;
    public float B;
    public float C;
    public float D;
    public int E;
    public float F;
    public int v;
    public int w;
    public PartShadowContainer x;
    public boolean y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttachPopupView.this.A();
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f10735a;

        public b(boolean z) {
            this.f10735a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            float c2;
            if (this.f10735a) {
                AttachPopupView attachPopupView = AttachPopupView.this;
                if (attachPopupView.z) {
                    c2 = ((e.c(attachPopupView.getContext()) - AttachPopupView.this.f10740a.k.x) - r2.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.w;
                } else {
                    c2 = (e.c(attachPopupView.getContext()) - AttachPopupView.this.f10740a.k.x) + r2.w;
                }
                attachPopupView.B = -c2;
            } else {
                AttachPopupView attachPopupView2 = AttachPopupView.this;
                attachPopupView2.B = attachPopupView2.z ? attachPopupView2.f10740a.k.x + attachPopupView2.w : (attachPopupView2.f10740a.k.x - attachPopupView2.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.w;
            }
            AttachPopupView attachPopupView3 = AttachPopupView.this;
            if (attachPopupView3.f10740a.B) {
                if (attachPopupView3.z) {
                    if (this.f10735a) {
                        attachPopupView3.B += attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                    } else {
                        attachPopupView3.B -= attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                    }
                } else if (this.f10735a) {
                    attachPopupView3.B -= attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                } else {
                    attachPopupView3.B += attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                }
            }
            if (AttachPopupView.this.C()) {
                AttachPopupView attachPopupView4 = AttachPopupView.this;
                attachPopupView4.C = (attachPopupView4.f10740a.k.y - attachPopupView4.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.v;
            } else {
                AttachPopupView attachPopupView5 = AttachPopupView.this;
                attachPopupView5.C = attachPopupView5.f10740a.k.y + attachPopupView5.v;
            }
            AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.B);
            AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.C);
            AttachPopupView.this.B();
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f10737a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Rect f10738b;

        public c(boolean z, Rect rect) {
            this.f10737a = z;
            this.f10738b = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10737a) {
                AttachPopupView attachPopupView = AttachPopupView.this;
                attachPopupView.B = -(attachPopupView.z ? ((e.c(attachPopupView.getContext()) - this.f10738b.left) - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.w : (e.c(attachPopupView.getContext()) - this.f10738b.right) + AttachPopupView.this.w);
            } else {
                AttachPopupView attachPopupView2 = AttachPopupView.this;
                attachPopupView2.B = attachPopupView2.z ? this.f10738b.left + attachPopupView2.w : (this.f10738b.right - attachPopupView2.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.w;
            }
            AttachPopupView attachPopupView3 = AttachPopupView.this;
            if (attachPopupView3.f10740a.B) {
                if (attachPopupView3.z) {
                    if (this.f10737a) {
                        attachPopupView3.B -= (this.f10738b.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    } else {
                        attachPopupView3.B += (this.f10738b.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    }
                } else if (this.f10737a) {
                    attachPopupView3.B += (this.f10738b.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                } else {
                    attachPopupView3.B -= (this.f10738b.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                }
            }
            if (AttachPopupView.this.C()) {
                AttachPopupView.this.C = (this.f10738b.top - r0.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.v;
            } else {
                AttachPopupView.this.C = this.f10738b.bottom + r0.v;
            }
            AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.B);
            AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.C);
            AttachPopupView.this.B();
        }
    }

    public AttachPopupView(Context context) {
        super(context);
        this.v = 0;
        this.w = 0;
        this.A = 6;
        this.B = 0.0f;
        this.C = 0.0f;
        this.D = e.a(getContext());
        this.E = e.a(getContext(), 10.0f);
        this.F = 0.0f;
        this.x = (PartShadowContainer) findViewById(R$id.attachPopupContainer);
    }

    public void A() {
        int b2;
        int i2;
        float b3;
        int i3;
        this.D = e.a(getContext()) - this.E;
        boolean d2 = e.d(getContext());
        c.e.b.c.b bVar = this.f10740a;
        if (bVar.k != null) {
            PointF pointF = c.e.b.a.f6200e;
            if (pointF != null) {
                bVar.k = pointF;
            }
            float f2 = this.f10740a.k.y;
            this.F = f2;
            if (f2 + ((float) getPopupContentView().getMeasuredHeight()) > this.D) {
                this.y = this.f10740a.k.y > ((float) (e.b(getContext()) / 2));
            } else {
                this.y = false;
            }
            this.z = this.f10740a.k.x < ((float) (e.c(getContext()) / 2));
            ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
            if (C()) {
                b3 = this.f10740a.k.y - e.c();
                i3 = this.E;
            } else {
                b3 = e.b(getContext()) - this.f10740a.k.y;
                i3 = this.E;
            }
            int i4 = (int) (b3 - i3);
            int c2 = (int) ((this.z ? e.c(getContext()) - this.f10740a.k.x : this.f10740a.k.x) - this.E);
            if (getPopupContentView().getMeasuredHeight() > i4) {
                layoutParams.height = i4;
            }
            if (getPopupContentView().getMeasuredWidth() > c2) {
                layoutParams.width = c2;
            }
            getPopupContentView().setLayoutParams(layoutParams);
            getPopupContentView().post(new b(d2));
            return;
        }
        int[] iArr = new int[2];
        bVar.a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f10740a.a().getMeasuredWidth(), iArr[1] + this.f10740a.a().getMeasuredHeight());
        int i5 = (rect.left + rect.right) / 2;
        boolean z = ((float) (rect.bottom + getPopupContentView().getMeasuredHeight())) > this.D;
        this.F = (rect.top + rect.bottom) / 2;
        if (z) {
            this.y = true;
        } else {
            this.y = false;
        }
        this.z = i5 < e.c(getContext()) / 2;
        ViewGroup.LayoutParams layoutParams2 = getPopupContentView().getLayoutParams();
        if (C()) {
            b2 = rect.top - e.c();
            i2 = this.E;
        } else {
            b2 = e.b(getContext()) - rect.bottom;
            i2 = this.E;
        }
        int i6 = b2 - i2;
        int c3 = (this.z ? e.c(getContext()) - rect.left : rect.right) - this.E;
        if (getPopupContentView().getMeasuredHeight() > i6) {
            layoutParams2.height = i6;
        }
        if (getPopupContentView().getMeasuredWidth() > c3) {
            layoutParams2.width = c3;
        }
        getPopupContentView().setLayoutParams(layoutParams2);
        getPopupContentView().post(new c(d2, rect));
    }

    public void B() {
        q();
        m();
        k();
    }

    public boolean C() {
        c.e.b.c.b bVar = this.f10740a;
        return bVar.J ? this.F > ((float) (e.a(getContext()) / 2)) : (this.y || bVar.t == d.Top) && this.f10740a.t != d.Bottom;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public c.e.b.b.c getPopupAnimator() {
        c.e.b.b.e eVar;
        if (C()) {
            eVar = new c.e.b.b.e(getPopupContentView(), this.z ? c.e.b.d.c.ScrollAlphaFromLeftBottom : c.e.b.d.c.ScrollAlphaFromRightBottom);
        } else {
            eVar = new c.e.b.b.e(getPopupContentView(), this.z ? c.e.b.d.c.ScrollAlphaFromLeftTop : c.e.b.d.c.ScrollAlphaFromRightTop);
        }
        return eVar;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupLayoutId() {
        return R$layout._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        if (this.x.getChildCount() == 0) {
            y();
        }
        if (this.f10740a.a() == null && this.f10740a.k == null) {
            throw new IllegalArgumentException("atView() or watchView() must be call for AttachPopupView before show()！");
        }
        int i2 = this.f10740a.z;
        if (i2 == 0) {
            i2 = e.a(getContext(), 4.0f);
        }
        this.v = i2;
        int i3 = this.f10740a.y;
        this.w = i3;
        this.x.setTranslationX(i3);
        this.x.setTranslationY(this.f10740a.z);
        z();
        e.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a());
    }

    public void y() {
        this.x.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.x, false));
    }

    public void z() {
        if (this.f10746g) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (getPopupImplView().getBackground() != null) {
                Drawable.ConstantState constantState = getPopupImplView().getBackground().getConstantState();
                if (constantState != null) {
                    this.x.setBackground(constantState.newDrawable());
                    getPopupImplView().setBackground(null);
                }
            } else {
                this.x.setBackground(e.a(getResources().getColor(this.f10740a.F ? R$color._xpopup_dark_color : R$color._xpopup_light_color), this.f10740a.p));
            }
            this.x.setElevation(e.a(getContext(), 20.0f));
            return;
        }
        if (getPopupImplView().getBackground() == null) {
            int i2 = this.w;
            int i3 = this.A;
            this.w = i2 - i3;
            this.v -= i3;
            this.x.setBackground(e.a(getResources().getColor(this.f10740a.F ? R$color._xpopup_dark_color : R$color._xpopup_light_color), this.f10740a.p));
            return;
        }
        Drawable.ConstantState constantState2 = getPopupImplView().getBackground().getConstantState();
        if (constantState2 != null) {
            this.x.setBackground(constantState2.newDrawable());
            getPopupImplView().setBackground(null);
        }
    }
}
