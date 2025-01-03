package a.b.e.j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f320a;

    /* renamed from: b, reason: collision with root package name */
    public a.e.g<a.h.d.a.b, MenuItem> f321b;

    /* renamed from: c, reason: collision with root package name */
    public a.e.g<a.h.d.a.c, SubMenu> f322c;

    public c(Context context) {
        this.f320a = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof a.h.d.a.b)) {
            return menuItem;
        }
        a.h.d.a.b bVar = (a.h.d.a.b) menuItem;
        if (this.f321b == null) {
            this.f321b = new a.e.g<>();
        }
        MenuItem menuItem2 = this.f321b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f320a, bVar);
        this.f321b.put(bVar, jVar);
        return jVar;
    }

    public final void b() {
        a.e.g<a.h.d.a.b, MenuItem> gVar = this.f321b;
        if (gVar != null) {
            gVar.clear();
        }
        a.e.g<a.h.d.a.c, SubMenu> gVar2 = this.f322c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    public final void b(int i2) {
        if (this.f321b == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f321b.size(); i3++) {
            if (this.f321b.c(i3).getItemId() == i2) {
                this.f321b.d(i3);
                return;
            }
        }
    }

    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof a.h.d.a.c)) {
            return subMenu;
        }
        a.h.d.a.c cVar = (a.h.d.a.c) subMenu;
        if (this.f322c == null) {
            this.f322c = new a.e.g<>();
        }
        SubMenu subMenu2 = this.f322c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f320a, cVar);
        this.f322c.put(cVar, sVar);
        return sVar;
    }

    public final void a(int i2) {
        if (this.f321b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f321b.size()) {
            if (this.f321b.c(i3).getGroupId() == i2) {
                this.f321b.d(i3);
                i3--;
            }
            i3++;
        }
    }
}
