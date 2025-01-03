package a.k.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final h<?> f1365a;

    public f(h<?> hVar) {
        this.f1365a = hVar;
    }

    public static f a(h<?> hVar) {
        a.h.i.h.a(hVar, "callbacks == null");
        return new f(hVar);
    }

    public void b() {
        this.f1365a.f1370d.i();
    }

    public void c() {
        this.f1365a.f1370d.j();
    }

    public void d() {
        this.f1365a.f1370d.l();
    }

    public void e() {
        this.f1365a.f1370d.m();
    }

    public void f() {
        this.f1365a.f1370d.o();
    }

    public void g() {
        this.f1365a.f1370d.p();
    }

    public void h() {
        this.f1365a.f1370d.q();
    }

    public boolean i() {
        return this.f1365a.f1370d.d(true);
    }

    public FragmentManager j() {
        return this.f1365a.f1370d;
    }

    public void k() {
        this.f1365a.f1370d.K();
    }

    public Parcelable l() {
        return this.f1365a.f1370d.N();
    }

    public void a(Fragment fragment) {
        h<?> hVar = this.f1365a;
        hVar.f1370d.a(hVar, hVar, fragment);
    }

    public void b(boolean z) {
        this.f1365a.f1370d.b(z);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1365a.f1370d.C().onCreateView(view, str, context, attributeSet);
    }

    public boolean b(Menu menu) {
        return this.f1365a.f1370d.b(menu);
    }

    public boolean b(MenuItem menuItem) {
        return this.f1365a.f1370d.b(menuItem);
    }

    public void a(Parcelable parcelable) {
        h<?> hVar = this.f1365a;
        if (hVar instanceof a.m.w) {
            hVar.f1370d.a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public void a() {
        this.f1365a.f1370d.g();
    }

    public void a(boolean z) {
        this.f1365a.f1370d.a(z);
    }

    public void a(Configuration configuration) {
        this.f1365a.f1370d.a(configuration);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f1365a.f1370d.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f1365a.f1370d.a(menuItem);
    }

    public void a(Menu menu) {
        this.f1365a.f1370d.a(menu);
    }
}
