package androidx.savedstate;

import a.m.e;
import a.m.f;
import a.m.i;
import a.q.b;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class Recreator implements e {

    /* renamed from: a, reason: collision with root package name */
    public final b f2807a;

    public Recreator(b bVar) {
        this.f2807a = bVar;
    }

    @Override // a.m.g
    public void a(i iVar, f.b bVar) {
        if (bVar != f.b.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        iVar.getLifecycle().b(this);
        Bundle a2 = this.f2807a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (a2 == null) {
            return;
        }
        ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public static final class a implements SavedStateRegistry.b {

        /* renamed from: a, reason: collision with root package name */
        public final Set<String> f2808a = new HashSet();

        public a(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.a("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f2808a));
            return bundle;
        }

        public void a(String str) {
            this.f2808a.add(str);
        }
    }

    public final void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class);
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.a) declaredConstructor.newInstance(new Object[0])).a(this.f2807a);
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to instantiate " + str, e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("Class " + str + " wasn't found", e4);
        }
    }
}
