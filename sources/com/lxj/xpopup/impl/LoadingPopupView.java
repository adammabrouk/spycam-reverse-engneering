package com.lxj.xpopup.impl;

import a.t.a0;
import a.t.d;
import a.t.g;
import a.t.y;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.e.b.g.e;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.core.CenterPopupView;

/* loaded from: classes.dex */
public class LoadingPopupView extends CenterPopupView {
    public CharSequence A;
    public TextView z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout frameLayout = LoadingPopupView.this.v;
            a0 a0Var = new a0();
            a0Var.a(c.e.b.a.a());
            a0Var.a(new g());
            a0Var.a(new d());
            y.a(frameLayout, a0Var);
            if (LoadingPopupView.this.A == null || LoadingPopupView.this.A.length() == 0) {
                LoadingPopupView.this.z.setVisibility(8);
            } else {
                LoadingPopupView.this.z.setVisibility(0);
                LoadingPopupView.this.z.setText(LoadingPopupView.this.A);
            }
        }
    }

    public LoadingPopupView(Context context, int i2) {
        super(context);
        this.w = i2;
        y();
    }

    public void A() {
        if (this.z == null) {
            return;
        }
        post(new a());
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        int i2 = this.w;
        return i2 != 0 ? i2 : R$layout._xpopup_center_impl_loading;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        this.z = (TextView) findViewById(R$id.tv_title);
        if (Build.VERSION.SDK_INT >= 21) {
            getPopupImplView().setElevation(10.0f);
        }
        if (this.w == 0) {
            getPopupImplView().setBackground(e.a(Color.parseColor("#CF000000"), this.f10740a.p));
        }
        A();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void u() {
        super.u();
        TextView textView = this.z;
        if (textView == null) {
            return;
        }
        textView.setText("");
        this.z.setVisibility(8);
    }

    public LoadingPopupView a(CharSequence charSequence) {
        this.A = charSequence;
        A();
        return this;
    }
}
