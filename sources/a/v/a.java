package a.v;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: VersionedParcel.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final a.e.a<String, Method> f1988a;

    /* renamed from: b, reason: collision with root package name */
    public final a.e.a<String, Method> f1989b;

    /* renamed from: c, reason: collision with root package name */
    public final a.e.a<String, Class> f1990c;

    public a(a.e.a<String, Method> aVar, a.e.a<String, Method> aVar2, a.e.a<String, Class> aVar3) {
        this.f1988a = aVar;
        this.f1989b = aVar2;
        this.f1990c = aVar3;
    }

    public abstract void a();

    public abstract void a(Parcelable parcelable);

    public abstract void a(CharSequence charSequence);

    public abstract void a(boolean z);

    public void a(boolean z, boolean z2) {
    }

    public abstract void a(byte[] bArr);

    public abstract boolean a(int i2);

    public boolean a(boolean z, int i2) {
        return !a(i2) ? z : d();
    }

    public abstract a b();

    public abstract void b(int i2);

    public abstract void b(String str);

    public void b(boolean z, int i2) {
        b(i2);
        a(z);
    }

    public abstract void c(int i2);

    public boolean c() {
        return false;
    }

    public abstract boolean d();

    public abstract byte[] e();

    public abstract CharSequence f();

    public abstract int g();

    public abstract <T extends Parcelable> T h();

    public abstract String i();

    public <T extends c> T j() {
        String i2 = i();
        if (i2 == null) {
            return null;
        }
        return (T) a(i2, b());
    }

    public int a(int i2, int i3) {
        return !a(i3) ? i2 : g();
    }

    public void b(byte[] bArr, int i2) {
        b(i2);
        a(bArr);
    }

    public String a(String str, int i2) {
        return !a(i2) ? str : i();
    }

    public void b(CharSequence charSequence, int i2) {
        b(i2);
        a(charSequence);
    }

    public byte[] a(byte[] bArr, int i2) {
        return !a(i2) ? bArr : e();
    }

    public void b(int i2, int i3) {
        b(i3);
        c(i2);
    }

    public <T extends Parcelable> T a(T t, int i2) {
        return !a(i2) ? t : (T) h();
    }

    public void b(String str, int i2) {
        b(i2);
        b(str);
    }

    public CharSequence a(CharSequence charSequence, int i2) {
        return !a(i2) ? charSequence : f();
    }

    public void b(Parcelable parcelable, int i2) {
        b(i2);
        a(parcelable);
    }

    public void a(c cVar) {
        if (cVar == null) {
            b((String) null);
            return;
        }
        b(cVar);
        a b2 = b();
        a((a) cVar, b2);
        b2.a();
    }

    public void b(c cVar, int i2) {
        b(i2);
        a(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(c cVar) {
        try {
            b(a((Class<? extends c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    public <T extends c> T a(T t, int i2) {
        return !a(i2) ? t : (T) j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method b(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f1989b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class a2 = a((Class<? extends c>) cls);
        System.currentTimeMillis();
        Method declaredMethod = a2.getDeclaredMethod("write", cls, a.class);
        this.f1989b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public <T extends c> T a(String str, a aVar) {
        try {
            return (T) a(str).invoke(null, aVar);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    public <T extends c> void a(T t, a aVar) {
        try {
            b(t.getClass()).invoke(null, t, aVar);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    public final Method a(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f1988a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f1988a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Class a(Class<? extends c> cls) throws ClassNotFoundException {
        Class cls2 = this.f1990c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f1990c.put(cls.getName(), cls3);
        return cls3;
    }
}
