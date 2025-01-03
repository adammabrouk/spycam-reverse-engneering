package a.b.a;

import a.b.a.a;
import a.b.e.j.g;
import a.b.e.j.m;
import a.b.f.h0;
import a.b.f.q;
import a.h.j.y;
import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
public class j extends a.b.a.a {

    /* renamed from: a, reason: collision with root package name */
    public q f175a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f176b;

    /* renamed from: c, reason: collision with root package name */
    public Window.Callback f177c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f178d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f179e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<a.b> f180f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f181g = new a();

    /* renamed from: h, reason: collision with root package name */
    public final Toolbar.f f182h = new b();

    /* compiled from: ToolbarActionBar.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.n();
        }
    }

    /* compiled from: ToolbarActionBar.java */
    public class b implements Toolbar.f {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return j.this.f177c.onMenuItemSelected(0, menuItem);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    public final class d implements g.a {
        public d() {
        }

        @Override // a.b.e.j.g.a
        public void a(a.b.e.j.g gVar) {
            j jVar = j.this;
            if (jVar.f177c != null) {
                if (jVar.f175a.a()) {
                    j.this.f177c.onPanelClosed(108, gVar);
                } else if (j.this.f177c.onPreparePanel(0, null, gVar)) {
                    j.this.f177c.onMenuOpened(108, gVar);
                }
            }
        }

        @Override // a.b.e.j.g.a
        public boolean a(a.b.e.j.g gVar, MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    public class e extends a.b.e.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public View onCreatePanelView(int i2) {
            return i2 == 0 ? new View(j.this.f175a.i()) : super.onCreatePanelView(i2);
        }

        @Override // a.b.e.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (onPreparePanel) {
                j jVar = j.this;
                if (!jVar.f176b) {
                    jVar.f175a.b();
                    j.this.f176b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public j(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f175a = new h0(toolbar, false);
        e eVar = new e(callback);
        this.f177c = eVar;
        this.f175a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(this.f182h);
        this.f175a.setWindowTitle(charSequence);
    }

    @Override // a.b.a.a
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // a.b.a.a
    public void addOnMenuVisibilityListener(a.b bVar) {
        this.f180f.add(bVar);
    }

    @Override // a.b.a.a
    public void b(boolean z) {
        if (z == this.f179e) {
            return;
        }
        this.f179e = z;
        int size = this.f180f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f180f.get(i2).a(z);
        }
    }

    @Override // a.b.a.a
    public void c(boolean z) {
    }

    @Override // a.b.a.a
    public void d(boolean z) {
    }

    @Override // a.b.a.a
    public boolean e() {
        return this.f175a.d();
    }

    @Override // a.b.a.a
    public boolean f() {
        if (!this.f175a.j()) {
            return false;
        }
        this.f175a.collapseActionView();
        return true;
    }

    @Override // a.b.a.a
    public int g() {
        return this.f175a.k();
    }

    @Override // a.b.a.a
    public Context h() {
        return this.f175a.i();
    }

    @Override // a.b.a.a
    public boolean i() {
        this.f175a.h().removeCallbacks(this.f181g);
        y.a(this.f175a.h(), this.f181g);
        return true;
    }

    @Override // a.b.a.a
    public void j() {
        this.f175a.h().removeCallbacks(this.f181g);
    }

    @Override // a.b.a.a
    public boolean k() {
        return this.f175a.e();
    }

    public final Menu l() {
        if (!this.f178d) {
            this.f175a.a(new c(), new d());
            this.f178d = true;
        }
        return this.f175a.l();
    }

    public Window.Callback m() {
        return this.f177c;
    }

    public void n() {
        Menu l = l();
        a.b.e.j.g gVar = l instanceof a.b.e.j.g ? (a.b.e.j.g) l : null;
        if (gVar != null) {
            gVar.s();
        }
        try {
            l.clear();
            if (!this.f177c.onCreatePanelMenu(0, l) || !this.f177c.onPreparePanel(0, null, l)) {
                l.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.r();
            }
        }
    }

    @Override // a.b.a.a
    public void removeOnMenuVisibilityListener(a.b bVar) {
        this.f180f.remove(bVar);
    }

    /* compiled from: ToolbarActionBar.java */
    public final class c implements m.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f185a;

        public c() {
        }

        @Override // a.b.e.j.m.a
        public boolean a(a.b.e.j.g gVar) {
            Window.Callback callback = j.this.f177c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }

        @Override // a.b.e.j.m.a
        public void a(a.b.e.j.g gVar, boolean z) {
            if (this.f185a) {
                return;
            }
            this.f185a = true;
            j.this.f175a.g();
            Window.Callback callback = j.this.f177c;
            if (callback != null) {
                callback.onPanelClosed(108, gVar);
            }
            this.f185a = false;
        }
    }

    @Override // a.b.a.a
    public void a(CharSequence charSequence) {
        this.f175a.setWindowTitle(charSequence);
    }

    @Override // a.b.a.a
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    @Override // a.b.a.a
    public boolean a(int i2, KeyEvent keyEvent) {
        Menu l = l();
        if (l == null) {
            return false;
        }
        l.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return l.performShortcut(i2, keyEvent, 0);
    }
}
