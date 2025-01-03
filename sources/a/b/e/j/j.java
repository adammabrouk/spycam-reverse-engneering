package a.b.e.j;

import a.h.j.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS.java */
/* loaded from: classes.dex */
public class j extends a.b.e.j.c implements MenuItem {

    /* renamed from: d, reason: collision with root package name */
    public final a.h.d.a.b f381d;

    /* renamed from: e, reason: collision with root package name */
    public Method f382e;

    /* compiled from: MenuItemWrapperICS.java */
    public class a extends a.h.j.b {

        /* renamed from: c, reason: collision with root package name */
        public final ActionProvider f383c;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f383c = actionProvider;
        }

        @Override // a.h.j.b
        public boolean a() {
            return this.f383c.hasSubMenu();
        }

        @Override // a.h.j.b
        public View c() {
            return this.f383c.onCreateActionView();
        }

        @Override // a.h.j.b
        public boolean d() {
            return this.f383c.onPerformDefaultAction();
        }

        @Override // a.h.j.b
        public void a(SubMenu subMenu) {
            this.f383c.onPrepareSubMenu(j.this.a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: e, reason: collision with root package name */
        public b.InterfaceC0027b f385e;

        public b(j jVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // a.h.j.b
        public View a(MenuItem menuItem) {
            return this.f383c.onCreateActionView(menuItem);
        }

        @Override // a.h.j.b
        public boolean b() {
            return this.f383c.isVisible();
        }

        @Override // a.h.j.b
        public boolean e() {
            return this.f383c.overridesItemVisibility();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            b.InterfaceC0027b interfaceC0027b = this.f385e;
            if (interfaceC0027b != null) {
                interfaceC0027b.onActionProviderVisibilityChanged(z);
            }
        }

        @Override // a.h.j.b
        public void a(b.InterfaceC0027b interfaceC0027b) {
            this.f385e = interfaceC0027b;
            this.f383c.setVisibilityListener(interfaceC0027b != null ? this : null);
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    public static class c extends FrameLayout implements a.b.e.c {

        /* renamed from: a, reason: collision with root package name */
        public final CollapsibleActionView f386a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(View view) {
            super(view.getContext());
            this.f386a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // a.b.e.c
        public void a() {
            this.f386a.onActionViewExpanded();
        }

        public View b() {
            return (View) this.f386a;
        }

        @Override // a.b.e.c
        public void c() {
            this.f386a.onActionViewCollapsed();
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f387a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f387a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f387a.onMenuItemActionCollapse(j.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f387a.onMenuItemActionExpand(j.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f389a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f389a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f389a.onMenuItemClick(j.this.a(menuItem));
        }
    }

    public j(Context context, a.h.d.a.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f381d = bVar;
    }

    public void a(boolean z) {
        try {
            if (this.f382e == null) {
                this.f382e = this.f381d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f382e.invoke(this.f381d, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f381d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f381d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        a.h.j.b a2 = this.f381d.a();
        if (a2 instanceof a) {
            return ((a) a2).f383c;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f381d.getActionView();
        return actionView instanceof c ? ((c) actionView).b() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f381d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f381d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f381d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f381d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f381d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f381d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f381d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f381d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f381d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f381d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f381d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f381d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f381d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(this.f381d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f381d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f381d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f381d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f381d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f381d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f381d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f381d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f381d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f381d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        a.h.j.b bVar = Build.VERSION.SDK_INT >= 16 ? new b(this, this.f320a, actionProvider) : new a(this.f320a, actionProvider);
        a.h.d.a.b bVar2 = this.f381d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f381d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f381d.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f381d.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f381d.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f381d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f381d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f381d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f381d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f381d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f381d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f381d.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f381d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f381d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f381d.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i2) {
        this.f381d.setShowAsAction(i2);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i2) {
        this.f381d.setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f381d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f381d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f381d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f381d.setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f381d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f381d.setIcon(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f381d.setNumericShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f381d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f381d.setTitle(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i2) {
        this.f381d.setActionView(i2);
        View actionView = this.f381d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f381d.setActionView(new c(actionView));
        }
        return this;
    }
}
