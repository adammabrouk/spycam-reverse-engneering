package a.k.a;

import a.m.f;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
public class v implements a.q.b, a.m.w {

    /* renamed from: a, reason: collision with root package name */
    public final a.m.v f1473a;

    /* renamed from: b, reason: collision with root package name */
    public a.m.j f1474b = null;

    /* renamed from: c, reason: collision with root package name */
    public a.q.a f1475c = null;

    public v(Fragment fragment, a.m.v vVar) {
        this.f1473a = vVar;
    }

    public void a() {
        if (this.f1474b == null) {
            this.f1474b = new a.m.j(this);
            this.f1475c = a.q.a.a(this);
        }
    }

    public boolean b() {
        return this.f1474b != null;
    }

    @Override // a.m.i
    public a.m.f getLifecycle() {
        a();
        return this.f1474b;
    }

    @Override // a.q.b
    public SavedStateRegistry getSavedStateRegistry() {
        a();
        return this.f1475c.a();
    }

    @Override // a.m.w
    public a.m.v getViewModelStore() {
        a();
        return this.f1473a;
    }

    public void b(Bundle bundle) {
        this.f1475c.b(bundle);
    }

    public void a(f.c cVar) {
        this.f1474b.d(cVar);
    }

    public void a(f.b bVar) {
        this.f1474b.a(bVar);
    }

    public void a(Bundle bundle) {
        this.f1475c.a(bundle);
    }
}
