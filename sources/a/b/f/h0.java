package a.b.f;

import a.b.e.j.g;
import a.b.e.j.m;
import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;

/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class h0 implements q {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f490a;

    /* renamed from: b, reason: collision with root package name */
    public int f491b;

    /* renamed from: c, reason: collision with root package name */
    public View f492c;

    /* renamed from: d, reason: collision with root package name */
    public View f493d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f494e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f495f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f496g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f497h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f498i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public ActionMenuPresenter n;
    public int o;
    public int p;
    public Drawable q;

    /* compiled from: ToolbarWidgetWrapper.java */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final a.b.e.j.a f499a;

        public a() {
            this.f499a = new a.b.e.j.a(h0.this.f490a.getContext(), 0, R.id.home, 0, 0, h0.this.f498i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h0 h0Var = h0.this;
            Window.Callback callback = h0Var.l;
            if (callback == null || !h0Var.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f499a);
        }
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    public class b extends a.h.j.e0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f501a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f502b;

        public b(int i2) {
            this.f502b = i2;
        }

        @Override // a.h.j.e0, a.h.j.d0
        public void a(View view) {
            this.f501a = true;
        }

        @Override // a.h.j.d0
        public void b(View view) {
            if (this.f501a) {
                return;
            }
            h0.this.f490a.setVisibility(this.f502b);
        }

        @Override // a.h.j.e0, a.h.j.d0
        public void c(View view) {
            h0.this.f490a.setVisibility(0);
        }
    }

    public h0(Toolbar toolbar, boolean z) {
        this(toolbar, z, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    public void a(Drawable drawable) {
        this.f495f = drawable;
        s();
    }

    @Override // a.b.f.q
    public void a(boolean z) {
    }

    public void b(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f491b & 8) != 0) {
            this.f490a.setSubtitle(charSequence);
        }
    }

    public void c(int i2) {
        if (i2 == this.p) {
            return;
        }
        this.p = i2;
        if (TextUtils.isEmpty(this.f490a.getNavigationContentDescription())) {
            d(this.p);
        }
    }

    @Override // a.b.f.q
    public void collapseActionView() {
        this.f490a.c();
    }

    public final void d(CharSequence charSequence) {
        this.f498i = charSequence;
        if ((this.f491b & 8) != 0) {
            this.f490a.setTitle(charSequence);
        }
    }

    @Override // a.b.f.q
    public boolean e() {
        return this.f490a.r();
    }

    @Override // a.b.f.q
    public boolean f() {
        return this.f490a.b();
    }

    @Override // a.b.f.q
    public void g() {
        this.f490a.d();
    }

    @Override // a.b.f.q
    public CharSequence getTitle() {
        return this.f490a.getTitle();
    }

    @Override // a.b.f.q
    public ViewGroup h() {
        return this.f490a;
    }

    @Override // a.b.f.q
    public Context i() {
        return this.f490a.getContext();
    }

    @Override // a.b.f.q
    public boolean j() {
        return this.f490a.k();
    }

    @Override // a.b.f.q
    public int k() {
        return this.f491b;
    }

    @Override // a.b.f.q
    public Menu l() {
        return this.f490a.getMenu();
    }

    @Override // a.b.f.q
    public int m() {
        return this.o;
    }

    @Override // a.b.f.q
    public void n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // a.b.f.q
    public void o() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final int p() {
        if (this.f490a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f490a.getNavigationIcon();
        return 15;
    }

    public final void q() {
        if ((this.f491b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.f490a.setNavigationContentDescription(this.p);
            } else {
                this.f490a.setNavigationContentDescription(this.k);
            }
        }
    }

    public final void r() {
        if ((this.f491b & 4) == 0) {
            this.f490a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f490a;
        Drawable drawable = this.f496g;
        if (drawable == null) {
            drawable = this.q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void s() {
        Drawable drawable;
        int i2 = this.f491b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f495f;
            if (drawable == null) {
                drawable = this.f494e;
            }
        } else {
            drawable = this.f494e;
        }
        this.f490a.setLogo(drawable);
    }

    @Override // a.b.f.q
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? a.b.b.a.a.c(i(), i2) : null);
    }

    @Override // a.b.f.q
    public void setVisibility(int i2) {
        this.f490a.setVisibility(i2);
    }

    @Override // a.b.f.q
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // a.b.f.q
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f497h) {
            return;
        }
        d(charSequence);
    }

    public h0(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f490a = toolbar;
        this.f498i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.f497h = this.f498i != null;
        this.f496g = toolbar.getNavigationIcon();
        g0 a2 = g0.a(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.q = a2.b(R$styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e2 = a2.e(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(e2)) {
                c(e2);
            }
            CharSequence e3 = a2.e(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e3)) {
                b(e3);
            }
            Drawable b2 = a2.b(R$styleable.ActionBar_logo);
            if (b2 != null) {
                a(b2);
            }
            Drawable b3 = a2.b(R$styleable.ActionBar_icon);
            if (b3 != null) {
                setIcon(b3);
            }
            if (this.f496g == null && (drawable = this.q) != null) {
                b(drawable);
            }
            a(a2.d(R$styleable.ActionBar_displayOptions, 0));
            int g2 = a2.g(R$styleable.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f490a.getContext()).inflate(g2, (ViewGroup) this.f490a, false));
                a(this.f491b | 16);
            }
            int f2 = a2.f(R$styleable.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f490a.getLayoutParams();
                layoutParams.height = f2;
                this.f490a.setLayoutParams(layoutParams);
            }
            int b4 = a2.b(R$styleable.ActionBar_contentInsetStart, -1);
            int b5 = a2.b(R$styleable.ActionBar_contentInsetEnd, -1);
            if (b4 >= 0 || b5 >= 0) {
                this.f490a.a(Math.max(b4, 0), Math.max(b5, 0));
            }
            int g3 = a2.g(R$styleable.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f490a;
                toolbar2.b(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f490a;
                toolbar3.a(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(R$styleable.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f490a.setPopupTheme(g5);
            }
        } else {
            this.f491b = p();
        }
        a2.b();
        c(i2);
        this.k = this.f490a.getNavigationContentDescription();
        this.f490a.setNavigationOnClickListener(new a());
    }

    @Override // a.b.f.q
    public void setIcon(Drawable drawable) {
        this.f494e = drawable;
        s();
    }

    @Override // a.b.f.q
    public boolean a() {
        return this.f490a.n();
    }

    @Override // a.b.f.q
    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f490a.getContext());
            this.n = actionMenuPresenter;
            actionMenuPresenter.a(R$id.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f490a.a((a.b.e.j.g) menu, this.n);
    }

    @Override // a.b.f.q
    public void b(int i2) {
        a(i2 != 0 ? a.b.b.a.a.c(i(), i2) : null);
    }

    @Override // a.b.f.q
    public boolean d() {
        return this.f490a.l();
    }

    @Override // a.b.f.q
    public void b() {
        this.m = true;
    }

    public void c(CharSequence charSequence) {
        this.f497h = true;
        d(charSequence);
    }

    public void d(int i2) {
        a(i2 == 0 ? null : i().getString(i2));
    }

    @Override // a.b.f.q
    public void b(boolean z) {
        this.f490a.setCollapsible(z);
    }

    public void b(Drawable drawable) {
        this.f496g = drawable;
        r();
    }

    @Override // a.b.f.q
    public boolean c() {
        return this.f490a.m();
    }

    @Override // a.b.f.q
    public void a(int i2) {
        View view;
        int i3 = this.f491b ^ i2;
        this.f491b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    q();
                }
                r();
            }
            if ((i3 & 3) != 0) {
                s();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f490a.setTitle(this.f498i);
                    this.f490a.setSubtitle(this.j);
                } else {
                    this.f490a.setTitle((CharSequence) null);
                    this.f490a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f493d) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.f490a.addView(view);
            } else {
                this.f490a.removeView(view);
            }
        }
    }

    @Override // a.b.f.q
    public void a(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f492c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f490a;
            if (parent == toolbar) {
                toolbar.removeView(this.f492c);
            }
        }
        this.f492c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.o != 2) {
            return;
        }
        this.f490a.addView(scrollingTabContainerView, 0);
        Toolbar.e eVar = (Toolbar.e) this.f492c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.f147a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    public void a(View view) {
        View view2 = this.f493d;
        if (view2 != null && (this.f491b & 16) != 0) {
            this.f490a.removeView(view2);
        }
        this.f493d = view;
        if (view == null || (this.f491b & 16) == 0) {
            return;
        }
        this.f490a.addView(view);
    }

    @Override // a.b.f.q
    public a.h.j.c0 a(int i2, long j) {
        a.h.j.c0 a2 = a.h.j.y.a(this.f490a);
        a2.a(i2 == 0 ? 1.0f : 0.0f);
        a2.a(j);
        a2.a(new b(i2));
        return a2;
    }

    public void a(CharSequence charSequence) {
        this.k = charSequence;
        q();
    }

    @Override // a.b.f.q
    public void a(m.a aVar, g.a aVar2) {
        this.f490a.a(aVar, aVar2);
    }
}
