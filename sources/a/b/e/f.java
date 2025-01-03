package a.b.e;

import a.b.e.b;
import a.b.e.j.j;
import a.b.e.j.o;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper.java */
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f268a;

    /* renamed from: b, reason: collision with root package name */
    public final b f269b;

    public f(Context context, b bVar) {
        this.f268a = context;
        this.f269b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f269b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f269b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.f268a, (a.h.d.a.a) this.f269b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f269b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f269b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f269b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f269b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f269b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f269b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f269b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f269b.a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f269b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f269b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f269b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f269b.a(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        this.f269b.a(i2);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        this.f269b.b(i2);
    }

    /* compiled from: SupportActionModeWrapper.java */
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f270a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f271b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<f> f272c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public final a.e.g<Menu, Menu> f273d = new a.e.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f271b = context;
            this.f270a = callback;
        }

        @Override // a.b.e.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f270a.onPrepareActionMode(b(bVar), a(menu));
        }

        @Override // a.b.e.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f270a.onCreateActionMode(b(bVar), a(menu));
        }

        @Override // a.b.e.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f270a.onActionItemClicked(b(bVar), new j(this.f271b, (a.h.d.a.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.f272c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.f272c.get(i2);
                if (fVar != null && fVar.f269b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f271b, bVar);
            this.f272c.add(fVar2);
            return fVar2;
        }

        @Override // a.b.e.b.a
        public void a(b bVar) {
            this.f270a.onDestroyActionMode(b(bVar));
        }

        public final Menu a(Menu menu) {
            Menu menu2 = this.f273d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f271b, (a.h.d.a.a) menu);
            this.f273d.put(menu, oVar);
            return oVar;
        }
    }
}
