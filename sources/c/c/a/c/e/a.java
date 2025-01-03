package c.c.a.c.e;

import a.b.e.j.g;
import a.b.e.j.i;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: BottomNavigationMenu.java */
/* loaded from: classes.dex */
public final class a extends g {
    public a(Context context) {
        super(context);
    }

    @Override // a.b.e.j.g
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        s();
        MenuItem a2 = super.a(i2, i3, i4, charSequence);
        if (a2 instanceof i) {
            ((i) a2).c(true);
        }
        r();
        return a2;
    }

    @Override // a.b.e.j.g, android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }
}
