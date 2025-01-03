package a.k.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f1374a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final FragmentManager f1375b;

    /* compiled from: FragmentLifecycleCallbacksDispatcher.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final FragmentManager.l f1376a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1377b;
    }

    public j(FragmentManager fragmentManager) {
        this.f1375b = fragmentManager;
    }

    public void a(Fragment fragment, boolean z) {
        Context c2 = this.f1375b.B().c();
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().a(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.a(this.f1375b, fragment, c2);
            }
        }
    }

    public void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().b(fragment, bundle, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.b(this.f1375b, fragment, bundle);
            }
        }
    }

    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.c(this.f1375b, fragment, bundle);
            }
        }
    }

    public void d(Fragment fragment, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().d(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.c(this.f1375b, fragment);
            }
        }
    }

    public void e(Fragment fragment, boolean z) {
        Context c2 = this.f1375b.B().c();
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().e(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.b(this.f1375b, fragment, c2);
            }
        }
    }

    public void f(Fragment fragment, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().f(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.d(this.f1375b, fragment);
            }
        }
    }

    public void g(Fragment fragment, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().g(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.e(this.f1375b, fragment);
            }
        }
    }

    public void h(Fragment fragment, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().h(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.f(this.f1375b, fragment);
            }
        }
    }

    public void i(Fragment fragment, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().i(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.g(this.f1375b, fragment);
            }
        }
    }

    public void b(Fragment fragment, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().b(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.a(this.f1375b, fragment);
            }
        }
    }

    public void c(Fragment fragment, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().c(fragment, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.b(this.f1375b, fragment);
            }
        }
    }

    public void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().d(fragment, bundle, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.d(this.f1375b, fragment, bundle);
            }
        }
    }

    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.a(this.f1375b, fragment, bundle);
            }
        }
    }

    public void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment E = this.f1375b.E();
        if (E != null) {
            E.getParentFragmentManager().D().a(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f1374a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1377b) {
                next.f1376a.a(this.f1375b, fragment, view, bundle);
            }
        }
    }
}
