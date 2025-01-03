package androidx.viewpager2.adapter;

import a.m.f;
import a.m.g;
import a.m.i;
import android.os.Handler;

/* loaded from: classes.dex */
public class FragmentStateAdapter$5 implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f2870a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f2871b;

    @Override // a.m.g
    public void a(i iVar, f.b bVar) {
        if (bVar == f.b.ON_DESTROY) {
            this.f2870a.removeCallbacks(this.f2871b);
            iVar.getLifecycle().b(this);
        }
    }
}
