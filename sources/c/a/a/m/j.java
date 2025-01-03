package c.a.a.m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import java.util.HashSet;

/* compiled from: RequestManagerFragment.java */
@TargetApi(11)
/* loaded from: classes.dex */
public class j extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.m.a f3371a;

    /* renamed from: b, reason: collision with root package name */
    public final l f3372b;

    /* renamed from: c, reason: collision with root package name */
    public c.a.a.h f3373c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet<j> f3374d;

    /* renamed from: e, reason: collision with root package name */
    public j f3375e;

    /* compiled from: RequestManagerFragment.java */
    public class b implements l {
        public b(j jVar) {
        }
    }

    public j() {
        this(new c.a.a.m.a());
    }

    public void a(c.a.a.h hVar) {
        this.f3373c = hVar;
    }

    public c.a.a.h b() {
        return this.f3373c;
    }

    public l c() {
        return this.f3372b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        j a2 = k.a().a(getActivity().getFragmentManager());
        this.f3375e = a2;
        if (a2 != this) {
            a2.a(this);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f3371a.a();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        j jVar = this.f3375e;
        if (jVar != null) {
            jVar.b(this);
            this.f3375e = null;
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        c.a.a.h hVar = this.f3373c;
        if (hVar != null) {
            hVar.g();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f3371a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f3371a.c();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        c.a.a.h hVar = this.f3373c;
        if (hVar != null) {
            hVar.a(i2);
        }
    }

    @SuppressLint({"ValidFragment"})
    public j(c.a.a.m.a aVar) {
        this.f3372b = new b();
        this.f3374d = new HashSet<>();
        this.f3371a = aVar;
    }

    public c.a.a.m.a a() {
        return this.f3371a;
    }

    public final void b(j jVar) {
        this.f3374d.remove(jVar);
    }

    public final void a(j jVar) {
        this.f3374d.add(jVar);
    }
}
