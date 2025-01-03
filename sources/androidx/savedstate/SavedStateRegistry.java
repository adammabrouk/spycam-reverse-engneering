package androidx.savedstate;

import a.m.e;
import a.m.f;
import a.m.i;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b, reason: collision with root package name */
    public Bundle f2810b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2811c;

    /* renamed from: d, reason: collision with root package name */
    public Recreator.a f2812d;

    /* renamed from: a, reason: collision with root package name */
    public a.c.a.b.b<String, b> f2809a = new a.c.a.b.b<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f2813e = true;

    public interface a {
        void a(a.q.b bVar);
    }

    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (!this.f2811c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f2810b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f2810b.remove(str);
        if (this.f2810b.isEmpty()) {
            this.f2810b = null;
        }
        return bundle2;
    }

    public void a(String str, b bVar) {
        if (this.f2809a.b(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void a(Class<? extends a> cls) {
        if (this.f2813e) {
            if (this.f2812d == null) {
                this.f2812d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f2812d.a(cls.getName());
                return;
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public void a(f fVar, Bundle bundle) {
        if (!this.f2811c) {
            if (bundle != null) {
                this.f2810b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            fVar.a(new e() { // from class: androidx.savedstate.SavedStateRegistry.1
                @Override // a.m.g
                public void a(i iVar, f.b bVar) {
                    if (bVar == f.b.ON_START) {
                        SavedStateRegistry.this.f2813e = true;
                    } else if (bVar == f.b.ON_STOP) {
                        SavedStateRegistry.this.f2813e = false;
                    }
                }
            });
            this.f2811c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2810b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        a.c.a.b.b<String, b>.d e2 = this.f2809a.e();
        while (e2.hasNext()) {
            Map.Entry next = e2.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
