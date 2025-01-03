package a.b.e.j;

import a.b.e.j.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuBuilder.java */
/* loaded from: classes.dex */
public class r extends g implements SubMenu {
    public g B;
    public i C;

    public r(Context context, g gVar, i iVar) {
        super(context);
        this.B = gVar;
        this.C = iVar;
    }

    @Override // a.b.e.j.g
    public void a(g.a aVar) {
        this.B.a(aVar);
    }

    @Override // a.b.e.j.g
    public boolean b(i iVar) {
        return this.B.b(iVar);
    }

    @Override // a.b.e.j.g
    public String d() {
        i iVar = this.C;
        int itemId = iVar != null ? iVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.d() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override // a.b.e.j.g
    public g m() {
        return this.B.m();
    }

    @Override // a.b.e.j.g
    public boolean o() {
        return this.B.o();
    }

    @Override // a.b.e.j.g
    public boolean p() {
        return this.B.p();
    }

    @Override // a.b.e.j.g
    public boolean q() {
        return this.B.q();
    }

    @Override // a.b.e.j.g, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // a.b.e.j.g, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public Menu t() {
        return this.B;
    }

    @Override // a.b.e.j.g
    public boolean a(g gVar, MenuItem menuItem) {
        return super.a(gVar, menuItem) || this.B.a(gVar, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        super.d(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        super.e(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.C.setIcon(i2);
        return this;
    }

    @Override // a.b.e.j.g
    public boolean a(i iVar) {
        return this.B.a(iVar);
    }
}
