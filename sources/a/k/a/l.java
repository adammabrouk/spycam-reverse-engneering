package a.k.a;

import a.m.u;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel.java */
/* loaded from: classes.dex */
public final class l extends a.m.t {
    public static final u.b j = new a();

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1381f;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Fragment> f1378c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, l> f1379d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<String, a.m.v> f1380e = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public boolean f1382g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1383h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1384i = false;

    /* compiled from: FragmentManagerViewModel.java */
    public class a implements u.b {
        @Override // a.m.u.b
        public <T extends a.m.t> T a(Class<T> cls) {
            return new l(true);
        }
    }

    public l(boolean z) {
        this.f1381f = z;
    }

    public static l a(a.m.v vVar) {
        return (l) new a.m.u(vVar, j).a(l.class);
    }

    @Override // a.m.t
    public void b() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1382g = true;
    }

    public Collection<Fragment> c() {
        return new ArrayList(this.f1378c.values());
    }

    public boolean d() {
        return this.f1382g;
    }

    public void e(Fragment fragment) {
        if (this.f1384i) {
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f1378c.remove(fragment.mWho) != null) && FragmentManager.d(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f1378c.equals(lVar.f1378c) && this.f1379d.equals(lVar.f1379d) && this.f1380e.equals(lVar.f1380e);
    }

    public boolean f(Fragment fragment) {
        if (this.f1378c.containsKey(fragment.mWho)) {
            return this.f1381f ? this.f1382g : !this.f1383h;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f1378c.hashCode() * 31) + this.f1379d.hashCode()) * 31) + this.f1380e.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1378c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1379d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1380e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public l c(Fragment fragment) {
        l lVar = this.f1379d.get(fragment.mWho);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this.f1381f);
        this.f1379d.put(fragment.mWho, lVar2);
        return lVar2;
    }

    public a.m.v d(Fragment fragment) {
        a.m.v vVar = this.f1380e.get(fragment.mWho);
        if (vVar != null) {
            return vVar;
        }
        a.m.v vVar2 = new a.m.v();
        this.f1380e.put(fragment.mWho, vVar2);
        return vVar2;
    }

    public void a(boolean z) {
        this.f1384i = z;
    }

    public void a(Fragment fragment) {
        if (this.f1384i) {
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f1378c.containsKey(fragment.mWho)) {
                return;
            }
            this.f1378c.put(fragment.mWho, fragment);
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public Fragment b(String str) {
        return this.f1378c.get(str);
    }

    public void b(Fragment fragment) {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        l lVar = this.f1379d.get(fragment.mWho);
        if (lVar != null) {
            lVar.b();
            this.f1379d.remove(fragment.mWho);
        }
        a.m.v vVar = this.f1380e.get(fragment.mWho);
        if (vVar != null) {
            vVar.a();
            this.f1380e.remove(fragment.mWho);
        }
    }
}
