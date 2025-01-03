package com.lxj.xpopup.impl;

import android.graphics.Color;
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
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.widget.CheckView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class BottomListPopupView extends BottomPopupView {
    public int A;
    public int B;
    public CharSequence C;
    public String[] D;
    public int[] E;
    public g F;
    public int G;
    public RecyclerView w;
    public TextView x;
    public TextView y;
    public View z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomListPopupView.this.h();
        }
    }

    public class b extends c.e.a.a<String> {
        public b(List list, int i2) {
            super(list, i2);
        }

        @Override // c.e.a.a
        public void a(e eVar, String str, int i2) {
            eVar.setText(R$id.tv_text, str);
            int[] iArr = BottomListPopupView.this.E;
            if (iArr == null || iArr.length <= i2) {
                eVar.getView(R$id.iv_image).setVisibility(8);
            } else {
                eVar.getView(R$id.iv_image).setVisibility(0);
                eVar.getView(R$id.iv_image).setBackgroundResource(BottomListPopupView.this.E[i2]);
            }
            if (BottomListPopupView.this.G != -1) {
                if (eVar.getViewOrNull(R$id.check_view) != null) {
                    eVar.getView(R$id.check_view).setVisibility(i2 != BottomListPopupView.this.G ? 8 : 0);
                    ((CheckView) eVar.getView(R$id.check_view)).setColor(c.e.b.a.b());
                }
                TextView textView = (TextView) eVar.getView(R$id.tv_text);
                BottomListPopupView bottomListPopupView = BottomListPopupView.this;
                textView.setTextColor(i2 == bottomListPopupView.G ? c.e.b.a.b() : bottomListPopupView.getResources().getColor(R$color._xpopup_title_color));
            } else {
                if (eVar.getViewOrNull(R$id.check_view) != null) {
                    eVar.getView(R$id.check_view).setVisibility(8);
                }
                ((TextView) eVar.getView(R$id.tv_text)).setGravity(17);
            }
            BottomListPopupView bottomListPopupView2 = BottomListPopupView.this;
            if (bottomListPopupView2.B == 0) {
                if (bottomListPopupView2.f10740a.F) {
                    ((TextView) eVar.getView(R$id.tv_text)).setTextColor(BottomListPopupView.this.getResources().getColor(R$color._xpopup_white_color));
                } else {
                    ((TextView) eVar.getView(R$id.tv_text)).setTextColor(BottomListPopupView.this.getResources().getColor(R$color._xpopup_dark_color));
                }
            }
        }
    }

    public class c extends d.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.e.a.a f10784a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BottomListPopupView.this.f10740a.f6244d.booleanValue()) {
                    BottomListPopupView.this.h();
                }
            }
        }

        public c(c.e.a.a aVar) {
            this.f10784a = aVar;
        }

        @Override // c.e.a.d.b
        public void a(View view, RecyclerView.c0 c0Var, int i2) {
            if (BottomListPopupView.this.F != null) {
                BottomListPopupView.this.F.a(i2, (String) this.f10784a.b().get(i2));
            }
            BottomListPopupView bottomListPopupView = BottomListPopupView.this;
            if (bottomListPopupView.G != -1) {
                bottomListPopupView.G = i2;
                this.f10784a.notifyDataSetChanged();
            }
            BottomListPopupView.this.postDelayed(new a(), 100L);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void b() {
        super.b();
        ((VerticalRecyclerView) this.w).setupDivider(true);
        this.x.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        TextView textView = this.y;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        }
        findViewById(R$id.xpopup_divider).setBackgroundColor(getResources().getColor(R$color._xpopup_list_dark_divider));
        View view = this.z;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor("#1B1B1B"));
        }
        View popupImplView = getPopupImplView();
        int color = getResources().getColor(R$color._xpopup_dark_color);
        float f2 = this.f10740a.p;
        popupImplView.setBackground(c.e.b.g.e.a(color, f2, f2, 0.0f, 0.0f));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void c() {
        super.c();
        ((VerticalRecyclerView) this.w).setupDivider(false);
        this.x.setTextColor(getResources().getColor(R$color._xpopup_dark_color));
        TextView textView = this.y;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R$color._xpopup_dark_color));
        }
        findViewById(R$id.xpopup_divider).setBackgroundColor(getResources().getColor(R$color._xpopup_list_divider));
        View view = this.z;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(R$color._xpopup_white_color));
        }
        View popupImplView = getPopupImplView();
        int color = getResources().getColor(R$color._xpopup_light_color);
        float f2 = this.f10740a.p;
        popupImplView.setBackground(c.e.b.g.e.a(color, f2, f2, 0.0f, 0.0f));
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        int i2 = this.A;
        return i2 == 0 ? R$layout._xpopup_bottom_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.recyclerView);
        this.w = recyclerView;
        if (this.A != 0) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        this.x = (TextView) findViewById(R$id.tv_title);
        this.y = (TextView) findViewById(R$id.tv_cancel);
        this.z = findViewById(R$id.vv_divider);
        TextView textView = this.y;
        if (textView != null) {
            textView.setOnClickListener(new a());
        }
        if (this.x != null) {
            if (TextUtils.isEmpty(this.C)) {
                this.x.setVisibility(8);
                if (findViewById(R$id.xpopup_divider) != null) {
                    findViewById(R$id.xpopup_divider).setVisibility(8);
                }
            } else {
                this.x.setText(this.C);
            }
        }
        List asList = Arrays.asList(this.D);
        int i2 = this.B;
        if (i2 == 0) {
            i2 = R$layout._xpopup_adapter_text_match;
        }
        b bVar = new b(asList, i2);
        bVar.setOnItemClickListener(new c(bVar));
        this.w.setAdapter(bVar);
        z();
    }

    public void z() {
        if (this.A == 0) {
            if (this.f10740a.F) {
                b();
            } else {
                c();
            }
        }
    }
}
