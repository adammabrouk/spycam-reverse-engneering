package a.b.e.j;

import a.b.e.j.m;
import a.b.f.w;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuPopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = R$layout.abc_cascading_menu_item_layout;
    public PopupWindow.OnDismissListener A;
    public boolean B;

    /* renamed from: b, reason: collision with root package name */
    public final Context f323b;

    /* renamed from: c, reason: collision with root package name */
    public final int f324c;

    /* renamed from: d, reason: collision with root package name */
    public final int f325d;

    /* renamed from: e, reason: collision with root package name */
    public final int f326e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f327f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f328g;
    public View o;
    public View p;
    public boolean r;
    public boolean t;
    public int u;
    public int v;
    public boolean x;
    public m.a y;
    public ViewTreeObserver z;

    /* renamed from: h, reason: collision with root package name */
    public final List<g> f329h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final List<C0005d> f330i = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener j = new a();
    public final View.OnAttachStateChangeListener k = new b();
    public final w l = new c();
    public int m = 0;
    public int n = 0;
    public boolean w = false;
    public int q = j();

    /* compiled from: CascadingMenuPopup.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.a() || d.this.f330i.size() <= 0 || d.this.f330i.get(0).f338a.q()) {
                return;
            }
            View view = d.this.p;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            Iterator<C0005d> it = d.this.f330i.iterator();
            while (it.hasNext()) {
                it.next().f338a.d();
            }
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.z = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.z.removeGlobalOnLayoutListener(dVar.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    public class c implements w {

        /* compiled from: CascadingMenuPopup.java */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0005d f334a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f335b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ g f336c;

            public a(C0005d c0005d, MenuItem menuItem, g gVar) {
                this.f334a = c0005d;
                this.f335b = menuItem;
                this.f336c = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0005d c0005d = this.f334a;
                if (c0005d != null) {
                    d.this.B = true;
                    c0005d.f339b.a(false);
                    d.this.B = false;
                }
                if (this.f335b.isEnabled() && this.f335b.hasSubMenu()) {
                    this.f336c.a(this.f335b, 4);
                }
            }
        }

        public c() {
        }

        @Override // a.b.f.w
        public void a(g gVar, MenuItem menuItem) {
            d.this.f328g.removeCallbacksAndMessages(null);
            int size = d.this.f330i.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.f330i.get(i2).f339b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            d.this.f328g.postAtTime(new a(i3 < d.this.f330i.size() ? d.this.f330i.get(i3) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // a.b.f.w
        public void b(g gVar, MenuItem menuItem) {
            d.this.f328g.removeCallbacksAndMessages(gVar);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: a.b.e.j.d$d, reason: collision with other inner class name */
    public static class C0005d {

        /* renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f338a;

        /* renamed from: b, reason: collision with root package name */
        public final g f339b;

        /* renamed from: c, reason: collision with root package name */
        public final int f340c;

        public C0005d(MenuPopupWindow menuPopupWindow, g gVar, int i2) {
            this.f338a = menuPopupWindow;
            this.f339b = gVar;
            this.f340c = i2;
        }

        public ListView a() {
            return this.f338a.e();
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z) {
        this.f323b = context;
        this.o = view;
        this.f325d = i2;
        this.f326e = i3;
        this.f327f = z;
        Resources resources = context.getResources();
        this.f324c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f328g = new Handler();
    }

    @Override // a.b.e.j.k
    public void a(g gVar) {
        gVar.a(this, this.f323b);
        if (a()) {
            d(gVar);
        } else {
            this.f329h.add(gVar);
        }
    }

    @Override // a.b.e.j.m
    public void a(Parcelable parcelable) {
    }

    @Override // a.b.e.j.k
    public void b(boolean z) {
        this.w = z;
    }

    @Override // a.b.e.j.k
    public boolean b() {
        return false;
    }

    public final int c(g gVar) {
        int size = this.f330i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (gVar == this.f330i.get(i2).f339b) {
                return i2;
            }
        }
        return -1;
    }

    @Override // a.b.e.j.p
    public void d() {
        if (a()) {
            return;
        }
        Iterator<g> it = this.f329h.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
        this.f329h.clear();
        View view = this.o;
        this.p = view;
        if (view != null) {
            boolean z = this.z == null;
            ViewTreeObserver viewTreeObserver = this.p.getViewTreeObserver();
            this.z = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.j);
            }
            this.p.addOnAttachStateChangeListener(this.k);
        }
    }

    @Override // a.b.e.j.p
    public void dismiss() {
        int size = this.f330i.size();
        if (size > 0) {
            C0005d[] c0005dArr = (C0005d[]) this.f330i.toArray(new C0005d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0005d c0005d = c0005dArr[i2];
                if (c0005d.f338a.a()) {
                    c0005d.f338a.dismiss();
                }
            }
        }
    }

    @Override // a.b.e.j.p
    public ListView e() {
        if (this.f330i.isEmpty()) {
            return null;
        }
        return this.f330i.get(r0.size() - 1).a();
    }

    @Override // a.b.e.j.m
    public boolean f() {
        return false;
    }

    @Override // a.b.e.j.m
    public Parcelable g() {
        return null;
    }

    public final MenuPopupWindow i() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f323b, null, this.f325d, this.f326e);
        menuPopupWindow.a(this.l);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.a(this.o);
        menuPopupWindow.f(this.n);
        menuPopupWindow.a(true);
        menuPopupWindow.g(2);
        return menuPopupWindow;
    }

    public final int j() {
        return y.q(this.o) == 1 ? 0 : 1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0005d c0005d;
        int size = this.f330i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                c0005d = null;
                break;
            }
            c0005d = this.f330i.get(i2);
            if (!c0005d.f338a.a()) {
                break;
            } else {
                i2++;
            }
        }
        if (c0005d != null) {
            c0005d.f339b.a(false);
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
        this.A = onDismissListener;
    }

    @Override // a.b.e.j.k
    public void b(int i2) {
        this.r = true;
        this.u = i2;
    }

    @Override // a.b.e.j.k
    public void c(int i2) {
        this.t = true;
        this.v = i2;
    }

    public final MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Override // a.b.e.j.k
    public void c(boolean z) {
        this.x = z;
    }

    public final View a(C0005d c0005d, g gVar) {
        f fVar;
        int i2;
        int firstVisiblePosition;
        MenuItem a2 = a(c0005d.f339b, gVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = c0005d.a();
        ListAdapter adapter = a3.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i2 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            }
            if (a2 == fVar.getItem(i3)) {
                break;
            }
            i3++;
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int d(int i2) {
        List<C0005d> list = this.f330i;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.p.getWindowVisibleDisplayFrame(rect);
        return this.q == 1 ? (iArr[0] + a2.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    public final void d(g gVar) {
        C0005d c0005d;
        View view;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f323b);
        f fVar = new f(gVar, from, this.f327f, C);
        if (!a() && this.w) {
            fVar.a(true);
        } else if (a()) {
            fVar.a(k.b(gVar));
        }
        int a2 = k.a(fVar, null, this.f323b, this.f324c);
        MenuPopupWindow i5 = i();
        i5.a((ListAdapter) fVar);
        i5.e(a2);
        i5.f(this.n);
        if (this.f330i.size() > 0) {
            List<C0005d> list = this.f330i;
            c0005d = list.get(list.size() - 1);
            view = a(c0005d, gVar);
        } else {
            c0005d = null;
            view = null;
        }
        if (view != null) {
            i5.d(false);
            i5.a((Object) null);
            int d2 = d(a2);
            boolean z = d2 == 1;
            this.q = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                i5.a(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.n & 7) == 5) {
                    iArr[0] = iArr[0] + this.o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.n & 5) == 5) {
                if (!z) {
                    a2 = view.getWidth();
                    i4 = i2 - a2;
                }
                i4 = i2 + a2;
            } else {
                if (z) {
                    a2 = view.getWidth();
                    i4 = i2 + a2;
                }
                i4 = i2 - a2;
            }
            i5.c(i4);
            i5.b(true);
            i5.a(i3);
        } else {
            if (this.r) {
                i5.c(this.u);
            }
            if (this.t) {
                i5.a(this.v);
            }
            i5.a(h());
        }
        this.f330i.add(new C0005d(i5, gVar, this.q));
        i5.d();
        ListView e2 = i5.e();
        e2.setOnKeyListener(this);
        if (c0005d == null && this.x && gVar.h() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) e2, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.h());
            e2.addHeaderView(frameLayout, null, false);
            i5.d();
        }
    }

    @Override // a.b.e.j.p
    public boolean a() {
        return this.f330i.size() > 0 && this.f330i.get(0).f338a.a();
    }

    @Override // a.b.e.j.m
    public void a(boolean z) {
        Iterator<C0005d> it = this.f330i.iterator();
        while (it.hasNext()) {
            k.a(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // a.b.e.j.m
    public void a(m.a aVar) {
        this.y = aVar;
    }

    @Override // a.b.e.j.m
    public boolean a(r rVar) {
        for (C0005d c0005d : this.f330i) {
            if (rVar == c0005d.f339b) {
                c0005d.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        a((g) rVar);
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.a(rVar);
        }
        return true;
    }

    @Override // a.b.e.j.m
    public void a(g gVar, boolean z) {
        int c2 = c(gVar);
        if (c2 < 0) {
            return;
        }
        int i2 = c2 + 1;
        if (i2 < this.f330i.size()) {
            this.f330i.get(i2).f339b.a(false);
        }
        C0005d remove = this.f330i.remove(c2);
        remove.f339b.b(this);
        if (this.B) {
            remove.f338a.b((Object) null);
            remove.f338a.d(0);
        }
        remove.f338a.dismiss();
        int size = this.f330i.size();
        if (size > 0) {
            this.q = this.f330i.get(size - 1).f340c;
        } else {
            this.q = j();
        }
        if (size != 0) {
            if (z) {
                this.f330i.get(0).f339b.a(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.a(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.z.removeGlobalOnLayoutListener(this.j);
            }
            this.z = null;
        }
        this.p.removeOnAttachStateChangeListener(this.k);
        this.A.onDismiss();
    }

    @Override // a.b.e.j.k
    public void a(int i2) {
        if (this.m != i2) {
            this.m = i2;
            this.n = a.h.j.e.a(i2, y.q(this.o));
        }
    }

    @Override // a.b.e.j.k
    public void a(View view) {
        if (this.o != view) {
            this.o = view;
            this.n = a.h.j.e.a(this.m, y.q(view));
        }
    }
}
