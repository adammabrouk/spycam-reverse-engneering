package com.lxj.xpopup.impl;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.d;
import c.e.a.e;
import c.e.b.e.g;
import com.lxj.xpopup.R$color;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class AttachListPopupView extends AttachPopupView {
    public RecyclerView G;
    public int H;
    public int I;
    public int J;
    public String[] K;
    public int[] L;
    public g M;

    public class a extends c.e.a.a<String> {
        public a(List list, int i2) {
            super(list, i2);
        }

        @Override // c.e.a.a
        public void a(e eVar, String str, int i2) {
            eVar.setText(R$id.tv_text, str);
            int[] iArr = AttachListPopupView.this.L;
            if (iArr == null || iArr.length <= i2) {
                eVar.getView(R$id.iv_image).setVisibility(8);
            } else {
                eVar.getView(R$id.iv_image).setVisibility(0);
                eVar.getView(R$id.iv_image).setBackgroundResource(AttachListPopupView.this.L[i2]);
            }
            AttachListPopupView attachListPopupView = AttachListPopupView.this;
            if (attachListPopupView.I == 0) {
                if (attachListPopupView.f10740a.F) {
                    ((TextView) eVar.getView(R$id.tv_text)).setTextColor(AttachListPopupView.this.getResources().getColor(R$color._xpopup_white_color));
                } else {
                    ((TextView) eVar.getView(R$id.tv_text)).setTextColor(AttachListPopupView.this.getResources().getColor(R$color._xpopup_dark_color));
                }
                ((LinearLayout) eVar.getView(R$id._ll_temp)).setGravity(AttachListPopupView.this.J);
            }
        }
    }

    public class b extends d.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.e.a.a f10780a;

        public b(c.e.a.a aVar) {
            this.f10780a = aVar;
        }

        @Override // c.e.a.d.b
        public void a(View view, RecyclerView.c0 c0Var, int i2) {
            if (AttachListPopupView.this.M != null) {
                AttachListPopupView.this.M.a(i2, (String) this.f10780a.b().get(i2));
            }
            if (AttachListPopupView.this.f10740a.f6244d.booleanValue()) {
                AttachListPopupView.this.h();
            }
        }
    }

    public void D() {
        if (this.H == 0) {
            if (this.f10740a.F) {
                b();
            } else {
                c();
            }
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void b() {
        super.b();
        ((VerticalRecyclerView) this.G).setupDivider(true);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void c() {
        super.c();
        ((VerticalRecyclerView) this.G).setupDivider(false);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        int i2 = this.H;
        return i2 == 0 ? R$layout._xpopup_attach_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void t() {
        super.t();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.recyclerView);
        this.G = recyclerView;
        if (this.H != 0) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        List asList = Arrays.asList(this.K);
        int i2 = this.I;
        if (i2 == 0) {
            i2 = R$layout._xpopup_adapter_text;
        }
        a aVar = new a(asList, i2);
        aVar.setOnItemClickListener(new b(aVar));
        this.G.setAdapter(aVar);
        D();
    }
}
