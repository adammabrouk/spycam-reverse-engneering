package a.k.a;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentState;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: FragmentStore.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Fragment> f1392a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, p> f1393b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public l f1394c;

    public void a(l lVar) {
        this.f1394c = lVar;
    }

    public void b(p pVar) {
        Fragment k = pVar.k();
        if (k.mRetainInstance) {
            this.f1394c.e(k);
        }
        if (this.f1393b.put(k.mWho, null) != null && FragmentManager.d(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k);
        }
    }

    public void c(Fragment fragment) {
        synchronized (this.f1392a) {
            this.f1392a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public List<Fragment> d() {
        ArrayList arrayList;
        if (this.f1392a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1392a) {
            arrayList = new ArrayList(this.f1392a);
        }
        return arrayList;
    }

    public l e() {
        return this.f1394c;
    }

    public void f() {
        Iterator<Fragment> it = this.f1392a.iterator();
        while (it.hasNext()) {
            p pVar = this.f1393b.get(it.next().mWho);
            if (pVar != null) {
                pVar.l();
            }
        }
        for (p pVar2 : this.f1393b.values()) {
            if (pVar2 != null) {
                pVar2.l();
                Fragment k = pVar2.k();
                if (k.mRemoving && !k.isInBackStack()) {
                    b(pVar2);
                }
            }
        }
    }

    public void g() {
        this.f1393b.clear();
    }

    public ArrayList<FragmentState> h() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f1393b.size());
        for (p pVar : this.f1393b.values()) {
            if (pVar != null) {
                Fragment k = pVar.k();
                FragmentState p = pVar.p();
                arrayList.add(p);
                if (FragmentManager.d(2)) {
                    Log.v("FragmentManager", "Saved state of " + k + ": " + p.m);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> i() {
        synchronized (this.f1392a) {
            if (this.f1392a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f1392a.size());
            Iterator<Fragment> it = this.f1392a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (FragmentManager.d(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }

    public void a(List<String> list) {
        this.f1392a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment b2 = b(str);
                if (b2 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.d(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + b2);
                }
                a(b2);
            }
        }
    }

    public p e(String str) {
        return this.f1393b.get(str);
    }

    public List<Fragment> c() {
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f1393b.values()) {
            if (pVar != null) {
                arrayList.add(pVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public Fragment d(String str) {
        Fragment findFragmentByWho;
        for (p pVar : this.f1393b.values()) {
            if (pVar != null && (findFragmentByWho = pVar.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public List<p> b() {
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f1393b.values()) {
            if (pVar != null) {
                arrayList.add(pVar);
            }
        }
        return arrayList;
    }

    public void a(p pVar) {
        Fragment k = pVar.k();
        if (a(k.mWho)) {
            return;
        }
        this.f1393b.put(k.mWho, pVar);
        if (k.mRetainInstanceChangedWhileDetached) {
            if (k.mRetainInstance) {
                this.f1394c.a(k);
            } else {
                this.f1394c.e(k);
            }
            k.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.d(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + k);
        }
    }

    public Fragment b(int i2) {
        for (int size = this.f1392a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1392a.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (p pVar : this.f1393b.values()) {
            if (pVar != null) {
                Fragment k = pVar.k();
                if (k.mFragmentId == i2) {
                    return k;
                }
            }
        }
        return null;
    }

    public Fragment c(String str) {
        if (str != null) {
            for (int size = this.f1392a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f1392a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (p pVar : this.f1393b.values()) {
            if (pVar != null) {
                Fragment k = pVar.k();
                if (str.equals(k.mTag)) {
                    return k;
                }
            }
        }
        return null;
    }

    public Fragment b(String str) {
        p pVar = this.f1393b.get(str);
        if (pVar != null) {
            return pVar.k();
        }
        return null;
    }

    public int b(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f1392a.indexOf(fragment);
        for (int i2 = indexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = this.f1392a.get(i2);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f1392a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f1392a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public void a(Fragment fragment) {
        if (!this.f1392a.contains(fragment)) {
            synchronized (this.f1392a) {
                this.f1392a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void a(int i2) {
        for (p pVar : this.f1393b.values()) {
            if (pVar != null) {
                pVar.a(i2);
            }
        }
    }

    public void a() {
        this.f1393b.values().removeAll(Collections.singleton(null));
    }

    public boolean a(String str) {
        return this.f1393b.get(str) != null;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f1393b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (p pVar : this.f1393b.values()) {
                printWriter.print(str);
                if (pVar != null) {
                    Fragment k = pVar.k();
                    printWriter.println(k);
                    k.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(LogUtils.NULL);
                }
            }
        }
        int size = this.f1392a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f1392a.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }
}
