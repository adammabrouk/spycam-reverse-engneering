package a.k.a;

import a.k.a.r;
import a.m.f;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class a extends r implements FragmentManager.n {
    public final FragmentManager q;
    public boolean r;
    public int s;

    public a(FragmentManager fragmentManager) {
        super(fragmentManager.y(), fragmentManager.B() != null ? fragmentManager.B().c().getClassLoader() : null);
        this.s = -1;
        this.q = fragmentManager;
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    @Override // a.k.a.r
    public r b(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.q) {
            super.b(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // a.k.a.r
    public r c(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.q) {
            super.c(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // a.k.a.r
    public r d(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.q) {
            super.d(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // a.k.a.r
    public r e(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.q) {
            super.e(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void f() {
        int size = this.f1395a.size();
        for (int i2 = 0; i2 < size; i2++) {
            r.a aVar = this.f1395a.get(i2);
            Fragment fragment = aVar.f1405b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f1400f);
                fragment.setSharedElementNames(this.m, this.n);
            }
            switch (aVar.f1404a) {
                case 1:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.a(fragment, false);
                    this.q.a(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1404a);
                case 3:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.u(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.n(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.a(fragment, false);
                    this.q.y(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.h(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.a(fragment, false);
                    this.q.c(fragment);
                    break;
                case 8:
                    this.q.w(fragment);
                    break;
                case 9:
                    this.q.w(null);
                    break;
                case 10:
                    this.q.a(fragment, aVar.f1411h);
                    break;
            }
            if (!this.o && aVar.f1404a != 1 && fragment != null && !FragmentManager.P) {
                this.q.s(fragment);
            }
        }
        if (this.o || FragmentManager.P) {
            return;
        }
        FragmentManager fragmentManager = this.q;
        fragmentManager.a(fragmentManager.q, true);
    }

    public String g() {
        return this.f1402h;
    }

    public boolean h() {
        for (int i2 = 0; i2 < this.f1395a.size(); i2++) {
            if (b(this.f1395a.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                this.p.get(i2).run();
            }
            this.p = null;
        }
    }

    public void setOnStartPostponedListener(Fragment.l lVar) {
        for (int i2 = 0; i2 < this.f1395a.size(); i2++) {
            r.a aVar = this.f1395a.get(i2);
            if (b(aVar)) {
                aVar.f1405b.setOnStartEnterTransitionListener(lVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(RecyclerView.c0.FLAG_IGNORE);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.f1402h != null) {
            sb.append(LogUtils.PLACEHOLDER);
            sb.append(this.f1402h);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1402h);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f1400f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1400f));
            }
            if (this.f1396b != 0 || this.f1397c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1396b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1397c));
            }
            if (this.f1398d != 0 || this.f1399e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1398d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1399e));
            }
            if (this.f1403i != 0 || this.j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1403i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.j);
            }
            if (this.k != 0 || this.l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.l);
            }
        }
        if (this.f1395a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1395a.size();
        for (int i2 = 0; i2 < size; i2++) {
            r.a aVar = this.f1395a.get(i2);
            switch (aVar.f1404a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f1404a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(LogUtils.PLACEHOLDER);
            printWriter.println(aVar.f1405b);
            if (z) {
                if (aVar.f1406c != 0 || aVar.f1407d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1406c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1407d));
                }
                if (aVar.f1408e != 0 || aVar.f1409f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1408e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1409f));
                }
            }
        }
    }

    @Override // a.k.a.r
    public int b() {
        return b(true);
    }

    @Override // a.k.a.r
    public void c() {
        e();
        this.q.b((FragmentManager.n) this, false);
    }

    @Override // a.k.a.r
    public void d() {
        e();
        this.q.b((FragmentManager.n) this, true);
    }

    public int b(boolean z) {
        if (!this.r) {
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new w("FragmentManager"));
                a("  ", printWriter);
                printWriter.close();
            }
            this.r = true;
            if (this.f1401g) {
                this.s = this.q.a();
            } else {
                this.s = -1;
            }
            this.q.a(this, z);
            return this.s;
        }
        throw new IllegalStateException("commit already called");
    }

    public void c(boolean z) {
        for (int size = this.f1395a.size() - 1; size >= 0; size--) {
            r.a aVar = this.f1395a.get(size);
            Fragment fragment = aVar.f1405b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.e(this.f1400f));
                fragment.setSharedElementNames(this.n, this.m);
            }
            switch (aVar.f1404a) {
                case 1:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.a(fragment, true);
                    this.q.u(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1404a);
                case 3:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.a(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.y(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.a(fragment, true);
                    this.q.n(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.c(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f1406c, aVar.f1407d, aVar.f1408e, aVar.f1409f);
                    this.q.a(fragment, true);
                    this.q.h(fragment);
                    break;
                case 8:
                    this.q.w(null);
                    break;
                case 9:
                    this.q.w(fragment);
                    break;
                case 10:
                    this.q.a(fragment, aVar.f1410g);
                    break;
            }
            if (!this.o && aVar.f1404a != 3 && fragment != null && !FragmentManager.P) {
                this.q.s(fragment);
            }
        }
        if (this.o || !z || FragmentManager.P) {
            return;
        }
        FragmentManager fragmentManager = this.q;
        fragmentManager.a(fragmentManager.q, true);
    }

    public boolean b(int i2) {
        int size = this.f1395a.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.f1395a.get(i3).f1405b;
            int i4 = fragment != null ? fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f1395a.size() - 1; size >= 0; size--) {
            r.a aVar = this.f1395a.get(size);
            int i2 = aVar.f1404a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f1405b;
                            break;
                        case 10:
                            aVar.f1411h = aVar.f1410g;
                            break;
                    }
                }
                arrayList.add(aVar.f1405b);
            }
            arrayList.remove(aVar.f1405b);
        }
        return fragment;
    }

    public static boolean b(r.a aVar) {
        Fragment fragment = aVar.f1405b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // a.k.a.r
    public void a(int i2, Fragment fragment, String str, int i3) {
        super.a(i2, fragment, str, i3);
        fragment.mFragmentManager = this.q;
    }

    @Override // a.k.a.r
    public r a(Fragment fragment, f.c cVar) {
        if (fragment.mFragmentManager == this.q) {
            if (cVar == f.c.INITIALIZED && fragment.mState > -1) {
                throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + " after the Fragment has been created");
            }
            if (cVar != f.c.DESTROYED) {
                super.a(fragment, cVar);
                return this;
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.q);
    }

    public void a(int i2) {
        if (this.f1401g) {
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f1395a.size();
            for (int i3 = 0; i3 < size; i3++) {
                r.a aVar = this.f1395a.get(i3);
                Fragment fragment = aVar.f1405b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (FragmentManager.d(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1405b + " to " + aVar.f1405b.mBackStackNesting);
                    }
                }
            }
        }
    }

    @Override // a.k.a.r
    public int a() {
        return b(false);
    }

    @Override // androidx.fragment.app.FragmentManager.n
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.d(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.f1401g) {
            return true;
        }
        this.q.a(this);
        return true;
    }

    public boolean a(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f1395a.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f1395a.get(i5).f1405b;
            int i6 = fragment != null ? fragment.mContainerId : 0;
            if (i6 != 0 && i6 != i4) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.f1395a.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = aVar.f1395a.get(i8).f1405b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f1395a.size()) {
            r.a aVar = this.f1395a.get(i2);
            int i3 = aVar.f1404a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = aVar.f1405b;
                    int i4 = fragment3.mContainerId;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.mContainerId == i4) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f1395a.add(i2, new r.a(9, fragment4));
                                    i2++;
                                    fragment2 = null;
                                }
                                r.a aVar2 = new r.a(3, fragment4);
                                aVar2.f1406c = aVar.f1406c;
                                aVar2.f1408e = aVar.f1408e;
                                aVar2.f1407d = aVar.f1407d;
                                aVar2.f1409f = aVar.f1409f;
                                this.f1395a.add(i2, aVar2);
                                arrayList.remove(fragment4);
                                i2++;
                            }
                        }
                    }
                    if (z) {
                        this.f1395a.remove(i2);
                        i2--;
                    } else {
                        aVar.f1404a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i3 == 3 || i3 == 6) {
                    arrayList.remove(aVar.f1405b);
                    Fragment fragment5 = aVar.f1405b;
                    if (fragment5 == fragment2) {
                        this.f1395a.add(i2, new r.a(9, fragment5));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f1395a.add(i2, new r.a(9, fragment2));
                        i2++;
                        fragment2 = aVar.f1405b;
                    }
                }
                i2++;
            }
            arrayList.add(aVar.f1405b);
            i2++;
        }
        return fragment2;
    }
}
