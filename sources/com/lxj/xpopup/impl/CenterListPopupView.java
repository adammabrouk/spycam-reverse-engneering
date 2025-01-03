package com.lxj.xpopup.impl;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.d;
import c.e.a.e;
import c.e.b.e.g;
import com.lxj.xpopup.R$color;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.widget.CheckView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class CenterListPopupView extends CenterPopupView {
    public TextView A;
    public CharSequence B;
    public String[] C;
    public int[] D;
    public g E;
    public int F;
    public RecyclerView z;

    public class a extends c.e.a.a<String> {
        public a(List list, int i2) {
            super(list, i2);
        }

        @Override // c.e.a.a
        public void a(e eVar, String str, int i2) {
            eVar.setText(R$id.tv_text, str);
            int[] iArr = CenterListPopupView.this.D;
            if (iArr == null || iArr.length <= i2) {
                eVar.getView(R$id.iv_image).setVisibility(8);
            } else {
                eVar.getView(R$id.iv_image).setVisibility(0);
                eVar.getView(R$id.iv_image).setBackgroundResource(CenterListPopupView.this.D[i2]);
            }
            if (CenterListPopupView.this.F != -1) {
                if (eVar.getViewOrNull(R$id.check_view) != null) {
                    eVar.getView(R$id.check_view).setVisibility(i2 != CenterListPopupView.this.F ? 8 : 0);
                    ((CheckView) eVar.getView(R$id.check_view)).setColor(c.e.b.a.b());
                }
                TextView textView = (TextView) eVar.getView(R$id.tv_text);
                CenterListPopupView centerListPopupView = CenterListPopupView.this;
                textView.setTextColor(i2 == centerListPopupView.F ? c.e.b.a.b() : centerListPopupView.getResources().getColor(R$color._xpopup_title_color));
            } else {
                if (eVar.getViewOrNull(R$id.check_view) != null) {
                    eVar.getView(R$id.check_view).setVisibility(8);
                }
                ((TextView) eVar.getView(R$id.tv_text)).setGravity(17);
            }
            if (CenterListPopupView.this.x == 0) {
                if (CenterListPopupView.this.f10740a.F) {
                    ((TextView) eVar.getView(R$id.tv_text)).setTextColor(CenterListPopupView.this.getResources().getColor(R$color._xpopup_white_color));
                } else {
                    ((TextView) eVar.getView(R$id.tv_text)).setTextColor(CenterListPopupView.this.getResources().getColor(R$color._xpopup_dark_color));
                }
            }
        }
    }

    public class b extends d.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.e.a.a f10788a;

        public b(c.e.a.a aVar) {
            this.f10788a = aVar;
        }

        @Override // c.e.a.d.b
        public void a(View view, RecyclerView.c0 c0Var, int i2) {
            if (CenterListPopupView.this.E != null && i2 >= 0 && i2 < this.f10788a.b().size()) {
                CenterListPopupView.this.E.a(i2, (String) this.f10788a.b().get(i2));
            }
            CenterListPopupView centerListPopupView = CenterListPopupView.this;
            if (centerListPopupView.F != -1) {
                centerListPopupView.F = i2;
                this.f10788a.notifyDataSetChanged();
            }
            if (CenterListPopupView.this.f10740a.f6244d.booleanValue()) {
                CenterListPopupView.this.h();
            }
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void c() {
        super.c();
        ((VerticalRecyclerView) this.z).setupDivider(false);
        this.A.setTextColor(getResources().getColor(R$color._xpopup_dark_color));
        findViewById(R$id.xpopup_divider).setBackgroundColor(getResources().getColor(R$color._xpopup_list_divider));
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        int i2 = this.w;
        return i2 == 0 ? R$layout._xpopup_center_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getMaxWidth() {
        int i2 = this.f10740a.l;
        return i2 == 0 ? (int) (super.getMaxWidth() * 0.8f) : i2;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.recyclerView);
        this.z = recyclerView;
        if (this.w != 0) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        TextView textView = (TextView) findViewById(R$id.tv_title);
        this.A = textView;
        if (textView != null) {
            if (TextUtils.isEmpty(this.B)) {
                this.A.setVisibility(8);
                if (findViewById(R$id.xpopup_divider) != null) {
                    findViewById(R$id.xpopup_divider).setVisibility(8);
                }
            } else {
                this.A.setText(this.B);
            }
        }
        List asList = Arrays.asList(this.C);
        int i2 = this.x;
        if (i2 == 0) {
            i2 = R$layout._xpopup_adapter_text_match;
        }
        a aVar = new a(asList, i2);
        aVar.setOnItemClickListener(new b(aVar));
        this.z.setAdapter(aVar);
        z();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public void b() {
        super.b();
        ((VerticalRecyclerView) this.z).setupDivider(true);
        this.A.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        findViewById(R$id.xpopup_divider).setBackgroundColor(getResources().getColor(R$color._xpopup_list_dark_divider));
    }
}
