package com.lxj.xpopup.impl;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import c.e.b.e.f;
import c.e.b.g.e;

/* loaded from: classes.dex */
public class InputConfirmPopupView extends ConfirmPopupView implements View.OnClickListener {
    public CharSequence O;
    public c.e.b.e.a P;
    public f Q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputConfirmPopupView.this.K.setBackgroundDrawable(e.a(e.a(InputConfirmPopupView.this.getResources(), InputConfirmPopupView.this.K.getMeasuredWidth(), Color.parseColor("#888888")), e.a(InputConfirmPopupView.this.getResources(), InputConfirmPopupView.this.K.getMeasuredWidth(), c.e.b.a.b())));
        }
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void b() {
        super.b();
        this.K.setHintTextColor(Color.parseColor("#888888"));
        this.K.setTextColor(Color.parseColor("#dddddd"));
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void c() {
        super.c();
        this.K.setHintTextColor(Color.parseColor("#888888"));
        this.K.setTextColor(Color.parseColor("#333333"));
    }

    public EditText getEditText() {
        return this.K;
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.D) {
            c.e.b.e.a aVar = this.P;
            if (aVar != null) {
                aVar.a();
            }
            h();
            return;
        }
        if (view == this.E) {
            f fVar = this.Q;
            if (fVar != null) {
                fVar.a(this.K.getText().toString().trim());
            }
            if (this.f10740a.f6244d.booleanValue()) {
                h();
            }
        }
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        this.K.setVisibility(0);
        if (!TextUtils.isEmpty(this.H)) {
            this.K.setHint(this.H);
        }
        if (!TextUtils.isEmpty(this.O)) {
            this.K.setText(this.O);
            this.K.setSelection(this.O.length());
        }
        e.a(this.K, c.e.b.a.b());
        this.K.post(new a());
    }
}
