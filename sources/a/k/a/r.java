package a.k.a;

import a.m.f;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction.java */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: b, reason: collision with root package name */
    public int f1396b;

    /* renamed from: c, reason: collision with root package name */
    public int f1397c;

    /* renamed from: d, reason: collision with root package name */
    public int f1398d;

    /* renamed from: e, reason: collision with root package name */
    public int f1399e;

    /* renamed from: f, reason: collision with root package name */
    public int f1400f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1401g;

    /* renamed from: h, reason: collision with root package name */
    public String f1402h;

    /* renamed from: i, reason: collision with root package name */
    public int f1403i;
    public CharSequence j;
    public int k;
    public CharSequence l;
    public ArrayList<String> m;
    public ArrayList<String> n;
    public ArrayList<Runnable> p;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f1395a = new ArrayList<>();
    public boolean o = false;

    /* compiled from: FragmentTransaction.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1404a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f1405b;

        /* renamed from: c, reason: collision with root package name */
        public int f1406c;

        /* renamed from: d, reason: collision with root package name */
        public int f1407d;

        /* renamed from: e, reason: collision with root package name */
        public int f1408e;

        /* renamed from: f, reason: collision with root package name */
        public int f1409f;

        /* renamed from: g, reason: collision with root package name */
        public f.c f1410g;

        /* renamed from: h, reason: collision with root package name */
        public f.c f1411h;

        public a() {
        }

        public a(int i2, Fragment fragment) {
            this.f1404a = i2;
            this.f1405b = fragment;
            f.c cVar = f.c.RESUMED;
            this.f1410g = cVar;
            this.f1411h = cVar;
        }

        public a(int i2, Fragment fragment, f.c cVar) {
            this.f1404a = i2;
            this.f1405b = fragment;
            this.f1410g = fragment.mMaxState;
            this.f1411h = cVar;
        }
    }

    public r(g gVar, ClassLoader classLoader) {
    }

    public abstract int a();

    public void a(a aVar) {
        this.f1395a.add(aVar);
        aVar.f1406c = this.f1396b;
        aVar.f1407d = this.f1397c;
        aVar.f1408e = this.f1398d;
        aVar.f1409f = this.f1399e;
    }

    public abstract int b();

    public r b(int i2, Fragment fragment, String str) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i2, fragment, str, 2);
        return this;
    }

    public r c(Fragment fragment) {
        a(new a(4, fragment));
        return this;
    }

    public abstract void c();

    public r d(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public abstract void d();

    public r e(Fragment fragment) {
        a(new a(5, fragment));
        return this;
    }

    public r e() {
        if (this.f1401g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return this;
    }

    public r b(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public r a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public r a(int i2, Fragment fragment, String str) {
        a(i2, fragment, str, 1);
        return this;
    }

    public r a(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        a(viewGroup.getId(), fragment, str);
        return this;
    }

    public void a(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str2 = fragment.mTag;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
                }
                fragment.mTag = str;
            }
            if (i2 != 0) {
                if (i2 != -1) {
                    int i4 = fragment.mFragmentId;
                    if (i4 != 0 && i4 != i2) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
                    }
                    fragment.mFragmentId = i2;
                    fragment.mContainerId = i2;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            a(new a(i3, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public r a(int i2, Fragment fragment) {
        b(i2, fragment, null);
        return this;
    }

    public r a(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public r a(Fragment fragment, f.c cVar) {
        a(new a(10, fragment, cVar));
        return this;
    }

    public r a(boolean z) {
        this.o = z;
        return this;
    }
}
