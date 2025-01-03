package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import c.e.b.e.a;
import c.e.b.e.c;
import com.lxj.xpopup.R$color;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.core.CenterPopupView;

/* loaded from: classes.dex */
public class ConfirmPopupView extends CenterPopupView implements View.OnClickListener {
    public c A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public CharSequence F;
    public CharSequence G;
    public CharSequence H;
    public CharSequence I;
    public CharSequence J;
    public EditText K;
    public View L;
    public View M;
    public boolean N;
    public a z;

    public ConfirmPopupView(Context context, int i2) {
        super(context);
        this.N = false;
        this.w = i2;
        y();
    }

    public ConfirmPopupView a(c cVar, a aVar) {
        this.z = aVar;
        this.A = cVar;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void b() {
        super.b();
        this.B.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        this.C.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        this.D.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        this.E.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        View view = this.L;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(R$color._xpopup_list_dark_divider));
        }
        View view2 = this.M;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(R$color._xpopup_list_dark_divider));
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void c() {
        super.c();
        this.B.setTextColor(getResources().getColor(R$color._xpopup_content_color));
        this.C.setTextColor(getResources().getColor(R$color._xpopup_content_color));
        this.D.setTextColor(Color.parseColor("#666666"));
        this.E.setTextColor(c.e.b.a.b());
        View view = this.L;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(R$color._xpopup_list_divider));
        }
        View view2 = this.M;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(R$color._xpopup_list_divider));
        }
    }

    public TextView getCancelTextView() {
        return (TextView) findViewById(R$id.tv_cancel);
    }

    public TextView getConfirmTextView() {
        return (TextView) findViewById(R$id.tv_confirm);
    }

    public TextView getContentTextView() {
        return (TextView) findViewById(R$id.tv_content);
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        int i2 = this.w;
        return i2 != 0 ? i2 : R$layout._xpopup_center_impl_confirm;
    }

    public TextView getTitleTextView() {
        return (TextView) findViewById(R$id.tv_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.D) {
            a aVar = this.z;
            if (aVar != null) {
                aVar.a();
            }
            h();
            return;
        }
        if (view == this.E) {
            c cVar = this.A;
            if (cVar != null) {
                cVar.onConfirm();
            }
            if (this.f10740a.f6244d.booleanValue()) {
                h();
            }
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        this.B = (TextView) findViewById(R$id.tv_title);
        this.C = (TextView) findViewById(R$id.tv_content);
        this.D = (TextView) findViewById(R$id.tv_cancel);
        this.E = (TextView) findViewById(R$id.tv_confirm);
        this.C.setMovementMethod(LinkMovementMethod.getInstance());
        this.K = (EditText) findViewById(R$id.et_input);
        this.L = findViewById(R$id.xpopup_divider1);
        this.M = findViewById(R$id.xpopup_divider2);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        if (TextUtils.isEmpty(this.F)) {
            this.B.setVisibility(8);
        } else {
            this.B.setText(this.F);
        }
        if (TextUtils.isEmpty(this.G)) {
            this.C.setVisibility(8);
        } else {
            this.C.setText(this.G);
        }
        if (!TextUtils.isEmpty(this.I)) {
            this.D.setText(this.I);
        }
        if (!TextUtils.isEmpty(this.J)) {
            this.E.setText(this.J);
        }
        if (this.N) {
            this.D.setVisibility(8);
            View view = this.M;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        z();
    }

    public ConfirmPopupView a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.F = charSequence;
        this.G = charSequence2;
        this.H = charSequence3;
        return this;
    }

    public ConfirmPopupView a(CharSequence charSequence) {
        this.I = charSequence;
        return this;
    }

    public ConfirmPopupView b(CharSequence charSequence) {
        this.J = charSequence;
        return this;
    }
}
