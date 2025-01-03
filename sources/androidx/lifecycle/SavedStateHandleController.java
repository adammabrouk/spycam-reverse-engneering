package androidx.lifecycle;

import a.m.f;
import a.m.g;
import a.m.i;
import a.m.r;
import a.m.t;
import a.m.v;
import a.m.w;
import a.q.b;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class SavedStateHandleController implements g {

    /* renamed from: a, reason: collision with root package name */
    public final String f2666a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2667b = false;

    /* renamed from: c, reason: collision with root package name */
    public final r f2668c;

    public static final class a implements SavedStateRegistry.a {
        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(b bVar) {
            if (!(bVar instanceof w)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            v viewModelStore = ((w) bVar).getViewModelStore();
            SavedStateRegistry savedStateRegistry = bVar.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.b().iterator();
            while (it.hasNext()) {
                SavedStateHandleController.a(viewModelStore.a(it.next()), savedStateRegistry, bVar.getLifecycle());
            }
            if (viewModelStore.b().isEmpty()) {
                return;
            }
            savedStateRegistry.a(a.class);
        }
    }

    public SavedStateHandleController(String str, r rVar) {
        this.f2666a = str;
        this.f2668c = rVar;
    }

    public void a(SavedStateRegistry savedStateRegistry, f fVar) {
        if (this.f2667b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f2667b = true;
        fVar.a(this);
        savedStateRegistry.a(this.f2666a, this.f2668c.a());
    }

    public boolean b() {
        return this.f2667b;
    }

    public static void b(final SavedStateRegistry savedStateRegistry, final f fVar) {
        f.c a2 = fVar.a();
        if (a2 == f.c.INITIALIZED || a2.isAtLeast(f.c.STARTED)) {
            savedStateRegistry.a(a.class);
        } else {
            fVar.a(new g() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // a.m.g
                public void a(i iVar, f.b bVar) {
                    if (bVar == f.b.ON_START) {
                        f.this.b(this);
                        savedStateRegistry.a(a.class);
                    }
                }
            });
        }
    }

    @Override // a.m.g
    public void a(i iVar, f.b bVar) {
        if (bVar == f.b.ON_DESTROY) {
            this.f2667b = false;
            iVar.getLifecycle().b(this);
        }
    }

    public r a() {
        return this.f2668c;
    }

    public static SavedStateHandleController a(SavedStateRegistry savedStateRegistry, f fVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, r.a(savedStateRegistry.a(str), bundle));
        savedStateHandleController.a(savedStateRegistry, fVar);
        b(savedStateRegistry, fVar);
        return savedStateHandleController;
    }

    public static void a(t tVar, SavedStateRegistry savedStateRegistry, f fVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) tVar.a("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.b()) {
            return;
        }
        savedStateHandleController.a(savedStateRegistry, fVar);
        b(savedStateRegistry, fVar);
    }
}
