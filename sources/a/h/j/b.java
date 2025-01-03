package a.h.j;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public a f1113a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0027b f1114b;

    /* compiled from: ActionProvider.java */
    public interface a {
        void b(boolean z);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: a.h.j.b$b, reason: collision with other inner class name */
    public interface InterfaceC0027b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public b(Context context) {
    }

    public View a(MenuItem menuItem) {
        return c();
    }

    public void a(SubMenu subMenu) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.f1114b = null;
        this.f1113a = null;
    }

    public void a(boolean z) {
        a aVar = this.f1113a;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public void a(a aVar) {
        this.f1113a = aVar;
    }

    public void a(InterfaceC0027b interfaceC0027b) {
        if (this.f1114b != null && interfaceC0027b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1114b = interfaceC0027b;
    }
}
