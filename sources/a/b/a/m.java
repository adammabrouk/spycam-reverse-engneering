package a.b.a;

import a.b.a.a;
import a.b.e.b;
import a.b.e.j.g;
import a.b.f.q;
import a.h.j.c0;
import a.h.j.d0;
import a.h.j.e0;
import a.h.j.f0;
import a.h.j.y;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import com.shix.shixipc.utilcode.LogUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class m extends a.b.a.a implements ActionBarOverlayLayout.d {
    public static final Interpolator B = new AccelerateInterpolator();
    public static final Interpolator C = new DecelerateInterpolator();
    public final f0 A;

    /* renamed from: a, reason: collision with root package name */
    public Context f203a;

    /* renamed from: b, reason: collision with root package name */
    public Context f204b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f205c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f206d;

    /* renamed from: e, reason: collision with root package name */
    public q f207e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f208f;

    /* renamed from: g, reason: collision with root package name */
    public View f209g;

    /* renamed from: h, reason: collision with root package name */
    public ScrollingTabContainerView f210h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f211i;
    public d j;
    public a.b.e.b k;
    public b.a l;
    public boolean m;
    public ArrayList<a.b> n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public a.b.e.h v;
    public boolean w;
    public boolean x;
    public final d0 y;
    public final d0 z;

    /* compiled from: WindowDecorActionBar.java */
    public class a extends e0 {
        public a() {
        }

        @Override // a.h.j.d0
        public void b(View view) {
            View view2;
            m mVar = m.this;
            if (mVar.q && (view2 = mVar.f209g) != null) {
                view2.setTranslationY(0.0f);
                m.this.f206d.setTranslationY(0.0f);
            }
            m.this.f206d.setVisibility(8);
            m.this.f206d.setTransitioning(false);
            m mVar2 = m.this;
            mVar2.v = null;
            mVar2.l();
            ActionBarOverlayLayout actionBarOverlayLayout = m.this.f205c;
            if (actionBarOverlayLayout != null) {
                y.O(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    public class b extends e0 {
        public b() {
        }

        @Override // a.h.j.d0
        public void b(View view) {
            m mVar = m.this;
            mVar.v = null;
            mVar.f206d.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    public class c implements f0 {
        public c() {
        }

        @Override // a.h.j.f0
        public void a(View view) {
            ((View) m.this.f206d.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    public class d extends a.b.e.b implements g.a {

        /* renamed from: c, reason: collision with root package name */
        public final Context f215c;

        /* renamed from: d, reason: collision with root package name */
        public final a.b.e.j.g f216d;

        /* renamed from: e, reason: collision with root package name */
        public b.a f217e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference<View> f218f;

        public d(Context context, b.a aVar) {
            this.f215c = context;
            this.f217e = aVar;
            a.b.e.j.g gVar = new a.b.e.j.g(context);
            gVar.c(1);
            this.f216d = gVar;
            gVar.a(this);
        }

        @Override // a.b.e.b
        public void a() {
            m mVar = m.this;
            if (mVar.j != this) {
                return;
            }
            if (m.a(mVar.r, mVar.s, false)) {
                this.f217e.a(this);
            } else {
                m mVar2 = m.this;
                mVar2.k = this;
                mVar2.l = this.f217e;
            }
            this.f217e = null;
            m.this.e(false);
            m.this.f208f.a();
            m.this.f207e.h().sendAccessibilityEvent(32);
            m mVar3 = m.this;
            mVar3.f205c.setHideOnContentScrollEnabled(mVar3.x);
            m.this.j = null;
        }

        @Override // a.b.e.b
        public void b(CharSequence charSequence) {
            m.this.f208f.setTitle(charSequence);
        }

        @Override // a.b.e.b
        public Menu c() {
            return this.f216d;
        }

        @Override // a.b.e.b
        public MenuInflater d() {
            return new a.b.e.g(this.f215c);
        }

        @Override // a.b.e.b
        public CharSequence e() {
            return m.this.f208f.getSubtitle();
        }

        @Override // a.b.e.b
        public CharSequence g() {
            return m.this.f208f.getTitle();
        }

        @Override // a.b.e.b
        public void i() {
            if (m.this.j != this) {
                return;
            }
            this.f216d.s();
            try {
                this.f217e.a(this, this.f216d);
            } finally {
                this.f216d.r();
            }
        }

        @Override // a.b.e.b
        public boolean j() {
            return m.this.f208f.c();
        }

        public boolean k() {
            this.f216d.s();
            try {
                return this.f217e.b(this, this.f216d);
            } finally {
                this.f216d.r();
            }
        }

        @Override // a.b.e.b
        public void b(int i2) {
            b(m.this.f203a.getResources().getString(i2));
        }

        @Override // a.b.e.b
        public View b() {
            WeakReference<View> weakReference = this.f218f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // a.b.e.b
        public void a(View view) {
            m.this.f208f.setCustomView(view);
            this.f218f = new WeakReference<>(view);
        }

        @Override // a.b.e.b
        public void a(CharSequence charSequence) {
            m.this.f208f.setSubtitle(charSequence);
        }

        @Override // a.b.e.b
        public void a(int i2) {
            a((CharSequence) m.this.f203a.getResources().getString(i2));
        }

        @Override // a.b.e.b
        public void a(boolean z) {
            super.a(z);
            m.this.f208f.setTitleOptional(z);
        }

        @Override // a.b.e.j.g.a
        public boolean a(a.b.e.j.g gVar, MenuItem menuItem) {
            b.a aVar = this.f217e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // a.b.e.j.g.a
        public void a(a.b.e.j.g gVar) {
            if (this.f217e == null) {
                return;
            }
            i();
            m.this.f208f.e();
        }
    }

    public m(Activity activity, boolean z) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (z) {
            return;
        }
        this.f209g = decorView.findViewById(R.id.content);
    }

    public static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q a(View view) {
        if (view instanceof q) {
            return (q) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : LogUtils.NULL);
        throw new IllegalStateException(sb.toString());
    }

    @Override // a.b.a.a
    public void addOnMenuVisibilityListener(a.b bVar) {
        this.n.add(bVar);
    }

    public final void b(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f205c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f207e = a(view.findViewById(R$id.action_bar));
        this.f208f = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f206d = actionBarContainer;
        q qVar = this.f207e;
        if (qVar == null || this.f208f == null || actionBarContainer == null) {
            throw new IllegalStateException(m.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f203a = qVar.i();
        boolean z = (this.f207e.k() & 4) != 0;
        if (z) {
            this.f211i = true;
        }
        a.b.e.a a2 = a.b.e.a.a(this.f203a);
        k(a2.a() || z);
        i(a2.f());
        TypedArray obtainStyledAttributes = this.f203a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            j(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
    }

    @Override // a.b.a.a
    public void c(boolean z) {
        if (this.f211i) {
            return;
        }
        h(z);
    }

    @Override // a.b.a.a
    public void d(boolean z) {
        a.b.e.h hVar;
        this.w = z;
        if (z || (hVar = this.v) == null) {
            return;
        }
        hVar.a();
    }

    public void e(boolean z) {
        c0 a2;
        c0 a3;
        if (z) {
            p();
        } else {
            n();
        }
        if (!o()) {
            if (z) {
                this.f207e.setVisibility(4);
                this.f208f.setVisibility(0);
                return;
            } else {
                this.f207e.setVisibility(0);
                this.f208f.setVisibility(8);
                return;
            }
        }
        if (z) {
            a3 = this.f207e.a(4, 100L);
            a2 = this.f208f.a(0, 200L);
        } else {
            a2 = this.f207e.a(0, 200L);
            a3 = this.f208f.a(8, 100L);
        }
        a.b.e.h hVar = new a.b.e.h();
        hVar.a(a3, a2);
        hVar.c();
    }

    public void f(boolean z) {
        View view;
        a.b.e.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.p != 0 || (!this.w && !z)) {
            this.y.b(null);
            return;
        }
        this.f206d.setAlpha(1.0f);
        this.f206d.setTransitioning(true);
        a.b.e.h hVar2 = new a.b.e.h();
        float f2 = -this.f206d.getHeight();
        if (z) {
            this.f206d.getLocationInWindow(new int[]{0, 0});
            f2 -= r5[1];
        }
        c0 a2 = y.a(this.f206d);
        a2.b(f2);
        a2.a(this.A);
        hVar2.a(a2);
        if (this.q && (view = this.f209g) != null) {
            c0 a3 = y.a(view);
            a3.b(f2);
            hVar2.a(a3);
        }
        hVar2.a(B);
        hVar2.a(250L);
        hVar2.a(this.y);
        this.v = hVar2;
        hVar2.c();
    }

    @Override // a.b.a.a
    public int g() {
        return this.f207e.k();
    }

    public void h(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public final void i(boolean z) {
        this.o = z;
        if (z) {
            this.f206d.setTabContainer(null);
            this.f207e.a(this.f210h);
        } else {
            this.f207e.a((ScrollingTabContainerView) null);
            this.f206d.setTabContainer(this.f210h);
        }
        boolean z2 = m() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f210h;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f205c;
                if (actionBarOverlayLayout != null) {
                    y.O(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f207e.b(!this.o && z2);
        this.f205c.setHasNonEmbeddedTabs(!this.o && z2);
    }

    public void j(boolean z) {
        if (z && !this.f205c.j()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.x = z;
        this.f205c.setHideOnContentScrollEnabled(z);
    }

    public void k(boolean z) {
        this.f207e.a(z);
    }

    public void l() {
        b.a aVar = this.l;
        if (aVar != null) {
            aVar.a(this.k);
            this.k = null;
            this.l = null;
        }
    }

    public int m() {
        return this.f207e.m();
    }

    public final void n() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f205c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    public final boolean o() {
        return y.J(this.f206d);
    }

    public final void p() {
        if (this.t) {
            return;
        }
        this.t = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f205c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        l(false);
    }

    @Override // a.b.a.a
    public void removeOnMenuVisibilityListener(a.b bVar) {
        this.n.remove(bVar);
    }

    public void g(boolean z) {
        View view;
        View view2;
        a.b.e.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f206d.setVisibility(0);
        if (this.p == 0 && (this.w || z)) {
            this.f206d.setTranslationY(0.0f);
            float f2 = -this.f206d.getHeight();
            if (z) {
                this.f206d.getLocationInWindow(new int[]{0, 0});
                f2 -= r5[1];
            }
            this.f206d.setTranslationY(f2);
            a.b.e.h hVar2 = new a.b.e.h();
            c0 a2 = y.a(this.f206d);
            a2.b(0.0f);
            a2.a(this.A);
            hVar2.a(a2);
            if (this.q && (view2 = this.f209g) != null) {
                view2.setTranslationY(f2);
                c0 a3 = y.a(this.f209g);
                a3.b(0.0f);
                hVar2.a(a3);
            }
            hVar2.a(C);
            hVar2.a(250L);
            hVar2.a(this.z);
            this.v = hVar2;
            hVar2.c();
        } else {
            this.f206d.setAlpha(1.0f);
            this.f206d.setTranslationY(0.0f);
            if (this.q && (view = this.f209g) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f205c;
        if (actionBarOverlayLayout != null) {
            y.O(actionBarOverlayLayout);
        }
    }

    @Override // a.b.a.a
    public Context h() {
        if (this.f204b == null) {
            TypedValue typedValue = new TypedValue();
            this.f203a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f204b = new ContextThemeWrapper(this.f203a, i2);
            } else {
                this.f204b = this.f203a;
            }
        }
        return this.f204b;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.s) {
            return;
        }
        this.s = true;
        l(true);
    }

    public final void l(boolean z) {
        if (a(this.r, this.s, this.t)) {
            if (this.u) {
                return;
            }
            this.u = true;
            g(z);
            return;
        }
        if (this.u) {
            this.u = false;
            f(z);
        }
    }

    public void a(float f2) {
        y.a(this.f206d, f2);
    }

    @Override // a.b.a.a
    public void a(Configuration configuration) {
        i(a.b.e.a.a(this.f203a).f());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(int i2) {
        this.p = i2;
    }

    @Override // a.b.a.a
    public void a(CharSequence charSequence) {
        this.f207e.setWindowTitle(charSequence);
    }

    public void a(int i2, int i3) {
        int k = this.f207e.k();
        if ((i3 & 4) != 0) {
            this.f211i = true;
        }
        this.f207e.a((i2 & i3) | ((i3 ^ (-1)) & k));
    }

    public m(Dialog dialog) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        b(dialog.getWindow().getDecorView());
    }

    @Override // a.b.a.a
    public a.b.e.b a(b.a aVar) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.a();
        }
        this.f205c.setHideOnContentScrollEnabled(false);
        this.f208f.d();
        d dVar2 = new d(this.f208f.getContext(), aVar);
        if (!dVar2.k()) {
            return null;
        }
        this.j = dVar2;
        dVar2.i();
        this.f208f.a(dVar2);
        e(true);
        this.f208f.sendAccessibilityEvent(32);
        return dVar2;
    }

    @Override // a.b.a.a
    public void b(boolean z) {
        if (z == this.m) {
            return;
        }
        this.m = z;
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.n.get(i2).a(z);
        }
    }

    @Override // a.b.a.a
    public boolean f() {
        q qVar = this.f207e;
        if (qVar == null || !qVar.j()) {
            return false;
        }
        this.f207e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        a.b.e.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z) {
        this.q = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.s) {
            this.s = false;
            l(true);
        }
    }

    @Override // a.b.a.a
    public boolean a(int i2, KeyEvent keyEvent) {
        Menu c2;
        d dVar = this.j;
        if (dVar == null || (c2 = dVar.c()) == null) {
            return false;
        }
        c2.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return c2.performShortcut(i2, keyEvent, 0);
    }
}
