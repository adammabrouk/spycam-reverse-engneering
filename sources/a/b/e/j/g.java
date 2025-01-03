package a.b.e.j;

import a.h.j.z;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import com.shix.shixipc.system.ContentCommon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class g implements a.h.d.a.a {
    public static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f358a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f359b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f360c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f361d;

    /* renamed from: e, reason: collision with root package name */
    public a f362e;
    public ContextMenu.ContextMenuInfo m;
    public CharSequence n;
    public Drawable o;
    public View p;
    public i x;
    public boolean z;
    public int l = 0;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public ArrayList<i> v = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<m>> w = new CopyOnWriteArrayList<>();
    public boolean y = false;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<i> f363f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<i> f364g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public boolean f365h = true;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<i> f366i = new ArrayList<>();
    public ArrayList<i> j = new ArrayList<>();
    public boolean k = true;

    /* compiled from: MenuBuilder.java */
    public interface a {
        void a(g gVar);

        boolean a(g gVar, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder.java */
    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        this.f358a = context;
        this.f359b = context.getResources();
        e(true);
    }

    public void a(m mVar) {
        a(mVar, this.f358a);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f358a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m mVar) {
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.w.remove(next);
            }
        }
    }

    public g c(int i2) {
        this.l = i2;
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        i iVar = this.x;
        if (iVar != null) {
            a(iVar);
        }
        this.f363f.clear();
        c(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        c(false);
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    public String d() {
        return "android:menu:actionviewstates";
    }

    public void d(Bundle bundle) {
        a(bundle);
    }

    public void e(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).e(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(d(), sparseArray);
        }
    }

    public void f(Bundle bundle) {
        b(bundle);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f363f.get(i3);
            if (iVar.getItemId() == i2) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public Drawable g() {
        return this.o;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return this.f363f.get(i2);
    }

    public CharSequence h() {
        return this.n;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f363f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public View i() {
        return this.p;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public ArrayList<i> j() {
        b();
        return this.j;
    }

    public boolean k() {
        return this.t;
    }

    public Resources l() {
        return this.f359b;
    }

    public g m() {
        return this;
    }

    public ArrayList<i> n() {
        if (!this.f365h) {
            return this.f364g;
        }
        this.f364g.clear();
        int size = this.f363f.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.f363f.get(i2);
            if (iVar.isVisible()) {
                this.f364g.add(iVar);
            }
        }
        this.f365h = false;
        this.k = true;
        return this.f364g;
    }

    public boolean o() {
        return this.y;
    }

    public boolean p() {
        return this.f360c;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        i a2 = a(i2, keyEvent);
        boolean a3 = a2 != null ? a(a2, i3) : false;
        if ((i3 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    public boolean q() {
        return this.f361d;
    }

    public void r() {
        this.q = false;
        if (this.r) {
            this.r = false;
            c(this.s);
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int a2 = a(i2);
        if (a2 >= 0) {
            int size = this.f363f.size() - a2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f363f.get(a2).getGroupId() != i2) {
                    break;
                }
                a(a2, false);
                i3 = i4;
            }
            c(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        a(b(i2), true);
    }

    public void s() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.r = false;
        this.s = false;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        int size = this.f363f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f363f.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.c(z2);
                iVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z) {
        int size = this.f363f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f363f.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z) {
        int size = this.f363f.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f363f.get(i3);
            if (iVar.getGroupId() == i2 && iVar.e(z)) {
                z2 = true;
            }
        }
        if (z2) {
            c(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f360c = z;
        c(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f363f.size();
    }

    public static int f(int i2) {
        int i3 = ((-65536) & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = A;
            if (i3 < iArr.length) {
                return (i2 & ContentCommon.INVALID_OPTION) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void a(m mVar, Context context) {
        this.w.add(new WeakReference<>(mVar));
        mVar.a(context, this);
        this.k = true;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f359b.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f359b.getString(i2));
    }

    public void c(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(d());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).c(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (findItem = findItem(i3)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void d(i iVar) {
        this.f365h = true;
        c(true);
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        r rVar = new r(this.f358a, this, iVar);
        iVar.a(rVar);
        return rVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f359b.getString(i5));
    }

    public final void b(boolean z) {
        if (this.w.isEmpty()) {
            return;
        }
        s();
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.w.remove(next);
            } else {
                mVar.a(z);
            }
        }
        r();
    }

    public g d(int i2) {
        a(0, null, i2, null, null);
        return this;
    }

    public final boolean a(r rVar, m mVar) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean a2 = mVar != null ? mVar.a(rVar) : false;
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null) {
                this.w.remove(next);
            } else if (!a2) {
                a2 = mVar2.a(rVar);
            }
        }
        return a2;
    }

    public void d(boolean z) {
        this.z = z;
    }

    public i f() {
        return this.x;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f359b.getString(i5));
    }

    public final void a(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.w.isEmpty()) {
            return;
        }
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.w.remove(next);
            } else {
                int c2 = mVar.c();
                if (c2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(c2)) != null) {
                    mVar.a(parcelable);
                }
            }
        }
    }

    public final void b(Bundle bundle) {
        Parcelable g2;
        if (this.w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.w.remove(next);
            } else {
                int c2 = mVar.c();
                if (c2 > 0 && (g2 = mVar.g()) != null) {
                    sparseArray.put(c2, g2);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public final void e(boolean z) {
        this.f361d = z && this.f359b.getConfiguration().keyboard != 1 && z.d(ViewConfiguration.get(this.f358a), this.f358a);
    }

    public void c(boolean z) {
        if (!this.q) {
            if (z) {
                this.f365h = true;
                this.k = true;
            }
            b(z);
            return;
        }
        this.r = true;
        if (z) {
            this.s = true;
        }
    }

    public Context e() {
        return this.f358a;
    }

    public g e(int i2) {
        a(i2, null, 0, null, null);
        return this;
    }

    public void a(a aVar) {
        this.f362e = aVar;
    }

    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int f2 = f(i4);
        i a2 = a(i2, i3, i4, f2, charSequence, this.l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
        if (contextMenuInfo != null) {
            a2.a(contextMenuInfo);
        }
        ArrayList<i> arrayList = this.f363f;
        arrayList.add(a(arrayList, f2), a2);
        c(true);
        return a2;
    }

    public int b(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f363f.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void c(i iVar) {
        this.k = true;
        c(true);
    }

    public void b() {
        ArrayList<i> n = n();
        if (this.k) {
            Iterator<WeakReference<m>> it = this.w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.w.remove(next);
                } else {
                    z |= mVar.f();
                }
            }
            if (z) {
                this.f366i.clear();
                this.j.clear();
                int size = n.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = n.get(i2);
                    if (iVar.h()) {
                        this.f366i.add(iVar);
                    } else {
                        this.j.add(iVar);
                    }
                }
            } else {
                this.f366i.clear();
                this.j.clear();
                this.j.addAll(n());
            }
            this.k = false;
        }
    }

    public ArrayList<i> c() {
        b();
        return this.f366i;
    }

    public final i a(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new i(this, i2, i3, i4, i5, charSequence, i6);
    }

    public final void a(int i2, boolean z) {
        if (i2 < 0 || i2 >= this.f363f.size()) {
            return;
        }
        this.f363f.remove(i2);
        if (z) {
            c(true);
        }
    }

    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f363f.size();
        s();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.f363f.get(i2);
            if (iVar.getGroupId() == groupId && iVar.i() && iVar.isCheckable()) {
                iVar.b(iVar == menuItem);
            }
        }
        r();
    }

    public int a(int i2) {
        return a(i2, 0);
    }

    public int a(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f363f.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean b(i iVar) {
        boolean z = false;
        if (this.w.isEmpty()) {
            return false;
        }
        s();
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.w.remove(next);
            } else {
                z = mVar.b(this, iVar);
                if (z) {
                    break;
                }
            }
        }
        r();
        if (z) {
            this.x = iVar;
        }
        return z;
    }

    public boolean a(g gVar, MenuItem menuItem) {
        a aVar = this.f362e;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public void a() {
        a aVar = this.f362e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public static int a(ArrayList<i> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    public void a(List<i> list, int i2, KeyEvent keyEvent) {
        boolean p = p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f363f.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = this.f363f.get(i3);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).a(list, i2, keyEvent);
                }
                char alphabeticShortcut = p ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if (((modifiers & 69647) == ((p ? iVar.getAlphabeticModifiers() : iVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (p && alphabeticShortcut == '\b' && i2 == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    public i a(int i2, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<i> arrayList = this.v;
        arrayList.clear();
        a(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean p = p();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = arrayList.get(i3);
            if (p) {
                numericShortcut = iVar.getAlphabeticShortcut();
            } else {
                numericShortcut = iVar.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (p && numericShortcut == '\b' && i2 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    public boolean a(MenuItem menuItem, int i2) {
        return a(menuItem, (m) null, i2);
    }

    public boolean a(MenuItem menuItem, m mVar, int i2) {
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean g2 = iVar.g();
        a.h.j.b a2 = iVar.a();
        boolean z = a2 != null && a2.a();
        if (iVar.f()) {
            g2 |= iVar.expandActionView();
            if (g2) {
                a(true);
            }
        } else if (iVar.hasSubMenu() || z) {
            if ((i2 & 4) == 0) {
                a(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.a(new r(e(), this, iVar));
            }
            r rVar = (r) iVar.getSubMenu();
            if (z) {
                a2.a(rVar);
            }
            g2 |= a(rVar, mVar);
            if (!g2) {
                a(true);
            }
        } else if ((i2 & 1) == 0) {
            a(true);
        }
        return g2;
    }

    public final void a(boolean z) {
        if (this.u) {
            return;
        }
        this.u = true;
        Iterator<WeakReference<m>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.w.remove(next);
            } else {
                mVar.a(this, z);
            }
        }
        this.u = false;
    }

    public final void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources l = l();
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i2 > 0) {
                this.n = l.getText(i2);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i3 > 0) {
                this.o = a.h.b.a.c(e(), i3);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        c(false);
    }

    public g a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    public g a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    public g a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public boolean a(i iVar) {
        boolean z = false;
        if (!this.w.isEmpty() && this.x == iVar) {
            s();
            Iterator<WeakReference<m>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.w.remove(next);
                } else {
                    z = mVar.a(this, iVar);
                    if (z) {
                        break;
                    }
                }
            }
            r();
            if (z) {
                this.x = null;
            }
        }
        return z;
    }
}
