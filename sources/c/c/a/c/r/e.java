package c.c.a.c.r;

import android.content.Context;
import android.view.SubMenu;

/* compiled from: NavigationMenu.java */
/* loaded from: classes.dex */
public class e extends a.b.e.j.g {
    public e(Context context) {
        super(context);
    }

    @Override // a.b.e.j.g, android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        a.b.e.j.i iVar = (a.b.e.j.i) a(i2, i3, i4, charSequence);
        g gVar = new g(e(), this, iVar);
        iVar.a(gVar);
        return gVar;
    }
}
