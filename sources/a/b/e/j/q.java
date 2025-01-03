package a.b.e.j;

import a.b.e.j.m;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuPopupWindow;

/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    public static final int w = R$layout.abc_popup_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    public final Context f403b;

    /* renamed from: c, reason: collision with root package name */
    public final g f404c;

    /* renamed from: d, reason: collision with root package name */
    public final f f405d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f406e;

    /* renamed from: f, reason: collision with root package name */
    public final int f407f;

    /* renamed from: g, reason: collision with root package name */
    public final int f408g;

    /* renamed from: h, reason: collision with root package name */
    public final int f409h;

    /* renamed from: i, reason: collision with root package name */
    public final MenuPopupWindow f410i;
    public PopupWindow.OnDismissListener l;
    public View m;
    public View n;
    public m.a o;
    public ViewTreeObserver p;
    public boolean q;
    public boolean r;
    public int t;
    public boolean v;
    public final ViewTreeObserver.OnGlobalLayoutListener j = new a();
    public final View.OnAttachStateChangeListener k = new b();
    public int u = 0;

    /* compiled from: StandardMenuPopup.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.a() || q.this.f410i.q()) {
                return;
            }
            View view = q.this.n;
            if (view == null || !view.isShown()) {
                q.this.dismiss();
            } else {
                q.this.f410i.d();
            }
        }
    }

    /* compiled from: StandardMenuPopup.java */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.p = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.p.removeGlobalOnLayoutListener(qVar.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.f403b = context;
        this.f404c = gVar;
        this.f406e = z;
        this.f405d = new f(gVar, LayoutInflater.from(context), this.f406e, w);
        this.f408g = i2;
        this.f409h = i3;
        Resources resources = context.getResources();
        this.f407f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.m = view;
        this.f410i = new MenuPopupWindow(this.f403b, null, this.f408g, this.f409h);
        gVar.a(this, context);
    }

    @Override // a.b.e.j.k
    public void a(int i2) {
        this.u = i2;
    }

    @Override // a.b.e.j.k
    public void a(g gVar) {
    }

    @Override // a.b.e.j.m
    public void a(Parcelable parcelable) {
    }

    @Override // a.b.e.j.k
    public void b(boolean z) {
        this.f405d.a(z);
    }

    @Override // a.b.e.j.k
    public void c(int i2) {
        this.f410i.a(i2);
    }

    @Override // a.b.e.j.p
    public void d() {
        if (!i()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // a.b.e.j.p
    public void dismiss() {
        if (a()) {
            this.f410i.dismiss();
        }
    }

    @Override // a.b.e.j.p
    public ListView e() {
        return this.f410i.e();
    }

    @Override // a.b.e.j.m
    public boolean f() {
        return false;
    }

    @Override // a.b.e.j.m
    public Parcelable g() {
        return null;
    }

    public final boolean i() {
        View view;
        if (a()) {
            return true;
        }
        if (this.q || (view = this.m) == null) {
            return false;
        }
        this.n = view;
        this.f410i.setOnDismissListener(this);
        this.f410i.setOnItemClickListener(this);
        this.f410i.a(true);
        View view2 = this.n;
        boolean z = this.p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.p = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.j);
        }
        view2.addOnAttachStateChangeListener(this.k);
        this.f410i.a(view2);
        this.f410i.f(this.u);
        if (!this.r) {
            this.t = k.a(this.f405d, null, this.f403b, this.f407f);
            this.r = true;
        }
        this.f410i.e(this.t);
        this.f410i.g(2);
        this.f410i.a(h());
        this.f410i.d();
        ListView e2 = this.f410i.e();
        e2.setOnKeyListener(this);
        if (this.v && this.f404c.h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f403b).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) e2, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f404c.h());
            }
            frameLayout.setEnabled(false);
            e2.addHeaderView(frameLayout, null, false);
        }
        this.f410i.a((ListAdapter) this.f405d);
        this.f410i.d();
        return true;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.q = true;
        this.f404c.close();
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // a.b.e.j.k
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    @Override // a.b.e.j.p
    public boolean a() {
        return !this.q && this.f410i.a();
    }

    @Override // a.b.e.j.k
    public void b(int i2) {
        this.f410i.c(i2);
    }

    @Override // a.b.e.j.k
    public void c(boolean z) {
        this.v = z;
    }

    @Override // a.b.e.j.m
    public void a(boolean z) {
        this.r = false;
        f fVar = this.f405d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // a.b.e.j.m
    public void a(m.a aVar) {
        this.o = aVar;
    }

    @Override // a.b.e.j.m
    public boolean a(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f403b, rVar, this.n, this.f406e, this.f408g, this.f409h);
            lVar.a(this.o);
            lVar.a(k.b(rVar));
            lVar.setOnDismissListener(this.l);
            this.l = null;
            this.f404c.a(false);
            int b2 = this.f410i.b();
            int f2 = this.f410i.f();
            if ((Gravity.getAbsoluteGravity(this.u, y.q(this.m)) & 7) == 5) {
                b2 += this.m.getWidth();
            }
            if (lVar.a(b2, f2)) {
                m.a aVar = this.o;
                if (aVar == null) {
                    return true;
                }
                aVar.a(rVar);
                return true;
            }
        }
        return false;
    }

    @Override // a.b.e.j.m
    public void a(g gVar, boolean z) {
        if (gVar != this.f404c) {
            return;
        }
        dismiss();
        m.a aVar = this.o;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // a.b.e.j.k
    public void a(View view) {
        this.m = view;
    }
}
