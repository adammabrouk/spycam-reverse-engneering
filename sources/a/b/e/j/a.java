package a.b.e.j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionMenuItem.java */
/* loaded from: classes.dex */
public class a implements a.h.d.a.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f302a;

    /* renamed from: b, reason: collision with root package name */
    public final int f303b;

    /* renamed from: c, reason: collision with root package name */
    public final int f304c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f305d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f306e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f307f;

    /* renamed from: g, reason: collision with root package name */
    public char f308g;

    /* renamed from: i, reason: collision with root package name */
    public char f310i;
    public Drawable k;
    public Context l;
    public CharSequence m;
    public CharSequence n;

    /* renamed from: h, reason: collision with root package name */
    public int f309h = 4096;
    public int j = 4096;
    public ColorStateList o = null;
    public PorterDuff.Mode p = null;
    public boolean q = false;
    public boolean r = false;
    public int s = 16;

    public a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.l = context;
        this.f302a = i3;
        this.f303b = i2;
        this.f304c = i5;
        this.f305d = charSequence;
    }

    @Override // a.h.d.a.b
    public a.h.d.a.b a(a.h.j.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // a.h.d.a.b
    public a.h.j.b a() {
        return null;
    }

    public final void b() {
        if (this.k != null) {
            if (this.q || this.r) {
                Drawable i2 = a.h.c.l.a.i(this.k);
                this.k = i2;
                Drawable mutate = i2.mutate();
                this.k = mutate;
                if (this.q) {
                    a.h.c.l.a.a(mutate, this.o);
                }
                if (this.r) {
                    a.h.c.l.a.a(this.k, this.p);
                }
            }
        }
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f310i;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f303b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.k;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f307f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f302a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f309h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f308g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f304c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f305d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f306e;
        return charSequence != null ? charSequence : this.f305d;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i2) {
        setActionView(i2);
        throw null;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f310i = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.s = (z ? 1 : 0) | (this.s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.s = (z ? 2 : 0) | (this.s & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.s = (z ? 16 : 0) | (this.s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        b();
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        b();
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.r = true;
        b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f307f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f308g = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f308g = c2;
        this.f310i = Character.toLowerCase(c3);
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f305d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f306e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.s = (this.s & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        setActionView(view);
        throw null;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f310i = Character.toLowerCase(c2);
        this.j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public a.h.d.a.b setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f308g = c2;
        this.f309h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public a.h.d.a.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f305d = this.l.getResources().getString(i2);
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public a.h.d.a.b setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public a.h.d.a.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.k = a.h.b.a.c(this.l, i2);
        b();
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f308g = c2;
        this.f309h = KeyEvent.normalizeMetaState(i2);
        this.f310i = Character.toLowerCase(c3);
        this.j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // a.h.d.a.b, android.view.MenuItem
    public a.h.d.a.b setActionView(int i2) {
        throw new UnsupportedOperationException();
    }
}
