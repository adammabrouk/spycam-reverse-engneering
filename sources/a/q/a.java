package a.q;

import a.m.f;
import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: SavedStateRegistryController.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f1710a;

    /* renamed from: b, reason: collision with root package name */
    public final SavedStateRegistry f1711b = new SavedStateRegistry();

    public a(b bVar) {
        this.f1710a = bVar;
    }

    public SavedStateRegistry a() {
        return this.f1711b;
    }

    public void b(Bundle bundle) {
        this.f1711b.a(bundle);
    }

    public void a(Bundle bundle) {
        f lifecycle = this.f1710a.getLifecycle();
        if (lifecycle.a() != f.c.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f1710a));
        this.f1711b.a(lifecycle, bundle);
    }

    public static a a(b bVar) {
        return new a(bVar);
    }
}
