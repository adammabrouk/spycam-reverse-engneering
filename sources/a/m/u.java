package a.m;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final b f1543a;

    /* renamed from: b, reason: collision with root package name */
    public final v f1544b;

    /* compiled from: ViewModelProvider.java */
    public interface b {
        <T extends t> T a(Class<T> cls);
    }

    /* compiled from: ViewModelProvider.java */
    public static abstract class c extends e implements b {
        public <T extends t> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends t> T a(String str, Class<T> cls);
    }

    /* compiled from: ViewModelProvider.java */
    public static class e {
        public void a(t tVar) {
        }
    }

    public u(v vVar, b bVar) {
        this.f1543a = bVar;
        this.f1544b = vVar;
    }

    public <T extends t> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* compiled from: ViewModelProvider.java */
    public static class a extends d {

        /* renamed from: c, reason: collision with root package name */
        public static a f1545c;

        /* renamed from: b, reason: collision with root package name */
        public Application f1546b;

        public a(Application application) {
            this.f1546b = application;
        }

        public static a a(Application application) {
            if (f1545c == null) {
                f1545c = new a(application);
            }
            return f1545c;
        }

        @Override // a.m.u.d, a.m.u.b
        public <T extends t> T a(Class<T> cls) {
            if (a.m.a.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.f1546b);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (InstantiationException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (NoSuchMethodException e4) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e5);
                }
            }
            return (T) super.a(cls);
        }
    }

    /* compiled from: ViewModelProvider.java */
    public static class d implements b {

        /* renamed from: a, reason: collision with root package name */
        public static d f1547a;

        public static d a() {
            if (f1547a == null) {
                f1547a = new d();
            }
            return f1547a;
        }

        @Override // a.m.u.b
        public <T extends t> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    public <T extends t> T a(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.f1544b.a(str);
        if (cls.isInstance(t2)) {
            Object obj = this.f1543a;
            if (obj instanceof e) {
                ((e) obj).a(t2);
            }
            return t2;
        }
        b bVar = this.f1543a;
        if (bVar instanceof c) {
            t = (T) ((c) bVar).a(str, cls);
        } else {
            t = (T) bVar.a(cls);
        }
        this.f1544b.a(str, t);
        return t;
    }
}
