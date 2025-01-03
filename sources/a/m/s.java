package a.m;

import a.m.u;
import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* compiled from: SavedStateViewModelFactory.java */
/* loaded from: classes.dex */
public final class s extends u.c {

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f1534f = {Application.class, r.class};

    /* renamed from: g, reason: collision with root package name */
    public static final Class<?>[] f1535g = {r.class};

    /* renamed from: a, reason: collision with root package name */
    public final Application f1536a;

    /* renamed from: b, reason: collision with root package name */
    public final u.b f1537b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f1538c;

    /* renamed from: d, reason: collision with root package name */
    public final f f1539d;

    /* renamed from: e, reason: collision with root package name */
    public final SavedStateRegistry f1540e;

    @SuppressLint({"LambdaLast"})
    public s(Application application, a.q.b bVar, Bundle bundle) {
        this.f1540e = bVar.getSavedStateRegistry();
        this.f1539d = bVar.getLifecycle();
        this.f1538c = bundle;
        this.f1536a = application;
        this.f1537b = application != null ? u.a.a(application) : u.d.a();
    }

    @Override // a.m.u.c
    public <T extends t> T a(String str, Class<T> cls) {
        T t;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor a2 = (!isAssignableFrom || this.f1536a == null) ? a(cls, f1535g) : a(cls, f1534f);
        if (a2 == null) {
            return (T) this.f1537b.a(cls);
        }
        SavedStateHandleController a3 = SavedStateHandleController.a(this.f1540e, this.f1539d, str, this.f1538c);
        if (isAssignableFrom) {
            try {
                if (this.f1536a != null) {
                    t = (T) a2.newInstance(this.f1536a, a3.a());
                    t.a("androidx.lifecycle.savedstate.vm.tag", a3);
                    return t;
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        }
        t = (T) a2.newInstance(a3.a());
        t.a("androidx.lifecycle.savedstate.vm.tag", a3);
        return t;
    }

    @Override // a.m.u.c, a.m.u.b
    public <T extends t> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) a(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public static <T> Constructor<T> a(Class<T> cls, Class<?>[] clsArr) {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    @Override // a.m.u.e
    public void a(t tVar) {
        SavedStateHandleController.a(tVar, this.f1540e, this.f1539d);
    }
}
