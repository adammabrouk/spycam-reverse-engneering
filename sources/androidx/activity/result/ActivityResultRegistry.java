package androidx.activity.result;

import a.m.f;
import a.m.g;
import a.m.i;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a, reason: collision with root package name */
    public Random f2045a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, String> f2046b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f2047c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, d> f2048d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f2049e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public final transient Map<String, c<?>> f2050f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f2051g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final Bundle f2052h = new Bundle();

    public static class c<O> {

        /* renamed from: a, reason: collision with root package name */
        public final a.a.e.a<O> f2065a;

        /* renamed from: b, reason: collision with root package name */
        public final a.a.e.d.a<?, O> f2066b;

        public c(a.a.e.a<O> aVar, a.a.e.d.a<?, O> aVar2) {
            this.f2065a = aVar;
            this.f2066b = aVar2;
        }
    }

    public final <I, O> a.a.e.b<I> a(final String str, i iVar, final a.a.e.d.a<I, O> aVar, final a.a.e.a<O> aVar2) {
        f lifecycle = iVar.getLifecycle();
        if (lifecycle.a().isAtLeast(f.c.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + iVar + " is attempting to register while current state is " + lifecycle.a() + ". LifecycleOwners must call register before they are STARTED.");
        }
        int a2 = a(str);
        d dVar = this.f2048d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new g() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // a.m.g
            public void a(i iVar2, f.b bVar) {
                if (!f.b.ON_START.equals(bVar)) {
                    if (f.b.ON_STOP.equals(bVar)) {
                        ActivityResultRegistry.this.f2050f.remove(str);
                        return;
                    } else {
                        if (f.b.ON_DESTROY.equals(bVar)) {
                            ActivityResultRegistry.this.b(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f2050f.put(str, new c<>(aVar2, aVar));
                if (ActivityResultRegistry.this.f2051g.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f2051g.get(str);
                    ActivityResultRegistry.this.f2051g.remove(str);
                    aVar2.a(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f2052h.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.f2052h.remove(str);
                    aVar2.a(aVar.a(activityResult.c(), activityResult.a()));
                }
            }
        });
        this.f2048d.put(str, dVar);
        return new a(str, a2, aVar);
    }

    public abstract <I, O> void a(int i2, a.a.e.d.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i3, a.h.a.b bVar);

    public final void b(String str) {
        Integer remove;
        if (!this.f2049e.contains(str) && (remove = this.f2047c.remove(str)) != null) {
            this.f2046b.remove(remove);
        }
        this.f2050f.remove(str);
        if (this.f2051g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f2051g.get(str));
            this.f2051g.remove(str);
        }
        if (this.f2052h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f2052h.getParcelable(str));
            this.f2052h.remove(str);
        }
        d dVar = this.f2048d.get(str);
        if (dVar != null) {
            dVar.a();
            this.f2048d.remove(str);
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final f f2067a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<g> f2068b = new ArrayList<>();

        public d(f fVar) {
            this.f2067a = fVar;
        }

        public void a(g gVar) {
            this.f2067a.a(gVar);
            this.f2068b.add(gVar);
        }

        public void a() {
            Iterator<g> it = this.f2068b.iterator();
            while (it.hasNext()) {
                this.f2067a.b(it.next());
            }
            this.f2068b.clear();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class a<I> extends a.a.e.b<I> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2057a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2058b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.a.e.d.a f2059c;

        public a(String str, int i2, a.a.e.d.a aVar) {
            this.f2057a = str;
            this.f2058b = i2;
            this.f2059c = aVar;
        }

        @Override // a.a.e.b
        public void a(I i2, a.h.a.b bVar) {
            ActivityResultRegistry.this.f2049e.add(this.f2057a);
            Integer num = ActivityResultRegistry.this.f2047c.get(this.f2057a);
            ActivityResultRegistry.this.a(num != null ? num.intValue() : this.f2058b, (a.a.e.d.a<a.a.e.d.a, O>) this.f2059c, (a.a.e.d.a) i2, bVar);
        }

        @Override // a.a.e.b
        public void a() {
            ActivityResultRegistry.this.b(this.f2057a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class b<I> extends a.a.e.b<I> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2061a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2062b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.a.e.d.a f2063c;

        public b(String str, int i2, a.a.e.d.a aVar) {
            this.f2061a = str;
            this.f2062b = i2;
            this.f2063c = aVar;
        }

        @Override // a.a.e.b
        public void a(I i2, a.h.a.b bVar) {
            ActivityResultRegistry.this.f2049e.add(this.f2061a);
            Integer num = ActivityResultRegistry.this.f2047c.get(this.f2061a);
            ActivityResultRegistry.this.a(num != null ? num.intValue() : this.f2062b, (a.a.e.d.a<a.a.e.d.a, O>) this.f2063c, (a.a.e.d.a) i2, bVar);
        }

        @Override // a.a.e.b
        public void a() {
            ActivityResultRegistry.this.b(this.f2061a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> a.a.e.b<I> a(String str, a.a.e.d.a<I, O> aVar, a.a.e.a<O> aVar2) {
        int a2 = a(str);
        this.f2050f.put(str, new c<>(aVar2, aVar));
        if (this.f2051g.containsKey(str)) {
            Object obj = this.f2051g.get(str);
            this.f2051g.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f2052h.getParcelable(str);
        if (activityResult != null) {
            this.f2052h.remove(str);
            aVar2.a(aVar.a(activityResult.c(), activityResult.a()));
        }
        return new b(str, a2, aVar);
    }

    public final void b(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f2047c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f2047c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f2049e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f2052h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f2045a);
    }

    public final void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f2049e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f2045a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f2052h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
            String str = stringArrayList.get(i2);
            if (this.f2047c.containsKey(str)) {
                Integer remove = this.f2047c.remove(str);
                if (!this.f2052h.containsKey(str)) {
                    this.f2046b.remove(remove);
                }
            }
            a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
        }
    }

    public final boolean a(int i2, int i3, Intent intent) {
        String str = this.f2046b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        this.f2049e.remove(str);
        a(str, i3, intent, this.f2050f.get(str));
        return true;
    }

    public final <O> boolean a(int i2, @SuppressLint({"UnknownNullness"}) O o) {
        a.a.e.a<?> aVar;
        String str = this.f2046b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        this.f2049e.remove(str);
        c<?> cVar = this.f2050f.get(str);
        if (cVar != null && (aVar = cVar.f2065a) != null) {
            aVar.a(o);
            return true;
        }
        this.f2052h.remove(str);
        this.f2051g.put(str, o);
        return true;
    }

    public final <O> void a(String str, int i2, Intent intent, c<O> cVar) {
        a.a.e.a<O> aVar;
        if (cVar != null && (aVar = cVar.f2065a) != null) {
            aVar.a(cVar.f2066b.a(i2, intent));
        } else {
            this.f2051g.remove(str);
            this.f2052h.putParcelable(str, new ActivityResult(i2, intent));
        }
    }

    public final int a(String str) {
        Integer num = this.f2047c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int a2 = a();
        a(a2, str);
        return a2;
    }

    public final int a() {
        int nextInt = this.f2045a.nextInt(2147418112);
        while (true) {
            int i2 = nextInt + 65536;
            if (!this.f2046b.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            nextInt = this.f2045a.nextInt(2147418112);
        }
    }

    public final void a(int i2, String str) {
        this.f2046b.put(Integer.valueOf(i2), str);
        this.f2047c.put(str, Integer.valueOf(i2));
    }
}
