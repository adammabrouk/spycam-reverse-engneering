package c.a.a.m;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.util.HashSet;

/* compiled from: SupportRequestManagerFragment.java */
/* loaded from: classes.dex */
public class n extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public c.a.a.h f3384a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.m.a f3385b;

    /* renamed from: c, reason: collision with root package name */
    public final l f3386c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet<n> f3387d;

    /* renamed from: e, reason: collision with root package name */
    public n f3388e;

    /* compiled from: SupportRequestManagerFragment.java */
    public class b implements l {
        public b(n nVar) {
        }
    }

    public n() {
        this(new c.a.a.m.a());
    }

    public void a(c.a.a.h hVar) {
        this.f3384a = hVar;
    }

    public l b() {
        return this.f3386c;
    }

    public c.a.a.m.a getLifecycle() {
        return this.f3385b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        n a2 = k.a().a(getActivity().getSupportFragmentManager());
        this.f3388e = a2;
        if (a2 != this) {
            a2.a(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f3385b.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        n nVar = this.f3388e;
        if (nVar != null) {
            nVar.b(this);
            this.f3388e = null;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        c.a.a.h hVar = this.f3384a;
        if (hVar != null) {
            hVar.g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f3385b.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f3385b.c();
    }

    @SuppressLint({"ValidFragment"})
    public n(c.a.a.m.a aVar) {
        this.f3386c = new b();
        this.f3387d = new HashSet<>();
        this.f3385b = aVar;
    }

    public c.a.a.h a() {
        return this.f3384a;
    }

    public final void b(n nVar) {
        this.f3387d.remove(nVar);
    }

    public final void a(n nVar) {
        this.f3387d.add(nVar);
    }
}
