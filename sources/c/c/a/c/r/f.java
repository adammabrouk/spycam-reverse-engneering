package c.c.a.c.r;

import a.b.e.j.m;
import a.h.j.g0;
import a.h.j.h0.c;
import a.h.j.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ParcelableSparseArray;
import java.util.ArrayList;

/* compiled from: NavigationMenuPresenter.java */
/* loaded from: classes.dex */
public class f implements a.b.e.j.m {

    /* renamed from: a, reason: collision with root package name */
    public NavigationMenuView f5542a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f5543b;

    /* renamed from: c, reason: collision with root package name */
    public m.a f5544c;

    /* renamed from: d, reason: collision with root package name */
    public a.b.e.j.g f5545d;

    /* renamed from: e, reason: collision with root package name */
    public int f5546e;

    /* renamed from: f, reason: collision with root package name */
    public c f5547f;

    /* renamed from: g, reason: collision with root package name */
    public LayoutInflater f5548g;

    /* renamed from: h, reason: collision with root package name */
    public int f5549h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5550i;
    public ColorStateList j;
    public ColorStateList k;
    public Drawable l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int r;
    public int t;
    public int u;
    public boolean q = true;
    public int v = -1;
    public final View.OnClickListener w = new a();

    /* compiled from: NavigationMenuPresenter.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            f.this.c(true);
            a.b.e.j.i itemData = ((NavigationMenuItemView) view).getItemData();
            f fVar = f.this;
            boolean a2 = fVar.f5545d.a(itemData, fVar, 0);
            if (itemData != null && itemData.isCheckable() && a2) {
                f.this.f5547f.a(itemData);
            } else {
                z = false;
            }
            f.this.c(false);
            if (z) {
                f.this.a(false);
            }
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public class c extends RecyclerView.g<l> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<e> f5552a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public a.b.e.j.i f5553b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f5554c;

        public c() {
            e();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(l lVar, int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) lVar.itemView).setText(((g) this.f5552a.get(i2)).a().getTitle());
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    C0106f c0106f = (C0106f) this.f5552a.get(i2);
                    lVar.itemView.setPadding(0, c0106f.b(), 0, c0106f.a());
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(f.this.k);
            f fVar = f.this;
            if (fVar.f5550i) {
                navigationMenuItemView.setTextAppearance(fVar.f5549h);
            }
            ColorStateList colorStateList = f.this.j;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = f.this.l;
            y.a(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            g gVar = (g) this.f5552a.get(i2);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f5559b);
            navigationMenuItemView.setHorizontalPadding(f.this.m);
            navigationMenuItemView.setIconPadding(f.this.n);
            f fVar2 = f.this;
            if (fVar2.p) {
                navigationMenuItemView.setIconSize(fVar2.o);
            }
            navigationMenuItemView.setMaxLines(f.this.r);
            navigationMenuItemView.a(gVar.a(), 0);
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            a.b.e.j.i iVar = this.f5553b;
            if (iVar != null) {
                bundle.putInt("android:menu:checked", iVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f5552a.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.f5552a.get(i2);
                if (eVar instanceof g) {
                    a.b.e.j.i a2 = ((g) eVar).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public a.b.e.j.i c() {
            return this.f5553b;
        }

        public int d() {
            int i2 = f.this.f5543b.getChildCount() == 0 ? 0 : 1;
            for (int i3 = 0; i3 < f.this.f5547f.getItemCount(); i3++) {
                if (f.this.f5547f.getItemViewType(i3) == 0) {
                    i2++;
                }
            }
            return i2;
        }

        public final void e() {
            if (this.f5554c) {
                return;
            }
            this.f5554c = true;
            this.f5552a.clear();
            this.f5552a.add(new d());
            int i2 = -1;
            int size = f.this.f5545d.n().size();
            boolean z = false;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                a.b.e.j.i iVar = f.this.f5545d.n().get(i4);
                if (iVar.isChecked()) {
                    a(iVar);
                }
                if (iVar.isCheckable()) {
                    iVar.c(false);
                }
                if (iVar.hasSubMenu()) {
                    SubMenu subMenu = iVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i4 != 0) {
                            this.f5552a.add(new C0106f(f.this.u, 0));
                        }
                        this.f5552a.add(new g(iVar));
                        int size2 = this.f5552a.size();
                        int size3 = subMenu.size();
                        boolean z2 = false;
                        for (int i5 = 0; i5 < size3; i5++) {
                            a.b.e.j.i iVar2 = (a.b.e.j.i) subMenu.getItem(i5);
                            if (iVar2.isVisible()) {
                                if (!z2 && iVar2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (iVar2.isCheckable()) {
                                    iVar2.c(false);
                                }
                                if (iVar.isChecked()) {
                                    a(iVar);
                                }
                                this.f5552a.add(new g(iVar2));
                            }
                        }
                        if (z2) {
                            a(size2, this.f5552a.size());
                        }
                    }
                } else {
                    int groupId = iVar.getGroupId();
                    if (groupId != i2) {
                        i3 = this.f5552a.size();
                        z = iVar.getIcon() != null;
                        if (i4 != 0) {
                            i3++;
                            ArrayList<e> arrayList = this.f5552a;
                            int i6 = f.this.u;
                            arrayList.add(new C0106f(i6, i6));
                        }
                    } else if (!z && iVar.getIcon() != null) {
                        a(i3, this.f5552a.size());
                        z = true;
                    }
                    g gVar = new g(iVar);
                    gVar.f5559b = z;
                    this.f5552a.add(gVar);
                    i2 = groupId;
                }
            }
            this.f5554c = false;
        }

        public void f() {
            e();
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f5552a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public long getItemId(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemViewType(int i2) {
            e eVar = this.f5552a.get(i2);
            if (eVar instanceof C0106f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public l onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                f fVar = f.this;
                return new i(fVar.f5548g, viewGroup, fVar.w);
            }
            if (i2 == 1) {
                return new k(f.this.f5548g, viewGroup);
            }
            if (i2 == 2) {
                return new j(f.this.f5548g, viewGroup);
            }
            if (i2 != 3) {
                return null;
            }
            return new b(f.this.f5543b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).f();
            }
        }

        public final void a(int i2, int i3) {
            while (i2 < i3) {
                ((g) this.f5552a.get(i2)).f5559b = true;
                i2++;
            }
        }

        public void a(a.b.e.j.i iVar) {
            if (this.f5553b == iVar || !iVar.isCheckable()) {
                return;
            }
            a.b.e.j.i iVar2 = this.f5553b;
            if (iVar2 != null) {
                iVar2.setChecked(false);
            }
            this.f5553b = iVar;
            iVar.setChecked(true);
        }

        public void a(Bundle bundle) {
            a.b.e.j.i a2;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            a.b.e.j.i a3;
            int i2 = bundle.getInt("android:menu:checked", 0);
            if (i2 != 0) {
                this.f5554c = true;
                int size = this.f5552a.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    e eVar = this.f5552a.get(i3);
                    if ((eVar instanceof g) && (a3 = ((g) eVar).a()) != null && a3.getItemId() == i2) {
                        a(a3);
                        break;
                    }
                    i3++;
                }
                this.f5554c = false;
                e();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f5552a.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    e eVar2 = this.f5552a.get(i4);
                    if ((eVar2 instanceof g) && (a2 = ((g) eVar2).a()) != null && (actionView = a2.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a2.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void a(boolean z) {
            this.f5554c = z;
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class d implements e {
    }

    /* compiled from: NavigationMenuPresenter.java */
    public interface e {
    }

    /* compiled from: NavigationMenuPresenter.java */
    /* renamed from: c.c.a.c.r.f$f, reason: collision with other inner class name */
    public static class C0106f implements e {

        /* renamed from: a, reason: collision with root package name */
        public final int f5556a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5557b;

        public C0106f(int i2, int i3) {
            this.f5556a = i2;
            this.f5557b = i3;
        }

        public int a() {
            return this.f5557b;
        }

        public int b() {
            return this.f5556a;
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class g implements e {

        /* renamed from: a, reason: collision with root package name */
        public final a.b.e.j.i f5558a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5559b;

        public g(a.b.e.j.i iVar) {
            this.f5558a = iVar;
        }

        public a.b.e.j.i a() {
            return this.f5558a;
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public class h extends a.p.a.m {
        public h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // a.p.a.m, a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            super.a(view, cVar);
            cVar.a(c.b.a(f.this.f5547f.d(), 0, false));
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class i extends l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static abstract class l extends RecyclerView.c0 {
        public l(View view) {
            super(view);
        }
    }

    @Override // a.b.e.j.m
    public boolean a(a.b.e.j.g gVar, a.b.e.j.i iVar) {
        return false;
    }

    @Override // a.b.e.j.m
    public boolean a(a.b.e.j.r rVar) {
        return false;
    }

    public void b(int i2) {
        this.f5546e = i2;
    }

    @Override // a.b.e.j.m
    public boolean b(a.b.e.j.g gVar, a.b.e.j.i iVar) {
        return false;
    }

    @Override // a.b.e.j.m
    public int c() {
        return this.f5546e;
    }

    public Drawable d() {
        return this.l;
    }

    public int e() {
        return this.m;
    }

    public void f(int i2) {
        this.r = i2;
        a(false);
    }

    @Override // a.b.e.j.m
    public boolean f() {
        return false;
    }

    @Override // a.b.e.j.m
    public Parcelable g() {
        Bundle bundle = new Bundle();
        if (this.f5542a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f5542a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f5547f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.b());
        }
        if (this.f5543b != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f5543b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public int h() {
        return this.n;
    }

    public int i() {
        return this.r;
    }

    public ColorStateList j() {
        return this.j;
    }

    public ColorStateList k() {
        return this.k;
    }

    public final void l() {
        int i2 = (this.f5543b.getChildCount() == 0 && this.q) ? this.t : 0;
        NavigationMenuView navigationMenuView = this.f5542a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // a.b.e.j.m
    public void a(Context context, a.b.e.j.g gVar) {
        this.f5548g = LayoutInflater.from(context);
        this.f5545d = gVar;
        this.u = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    public int b() {
        return this.f5543b.getChildCount();
    }

    public void c(int i2) {
        this.m = i2;
        a(false);
    }

    public void d(int i2) {
        this.n = i2;
        a(false);
    }

    public void e(int i2) {
        if (this.o != i2) {
            this.o = i2;
            this.p = true;
            a(false);
        }
    }

    public void h(int i2) {
        this.v = i2;
        NavigationMenuView navigationMenuView = this.f5542a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void b(ColorStateList colorStateList) {
        this.j = colorStateList;
        a(false);
    }

    public void c(boolean z) {
        c cVar = this.f5547f;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    public void b(boolean z) {
        if (this.q != z) {
            this.q = z;
            l();
        }
    }

    public a.b.e.j.n a(ViewGroup viewGroup) {
        if (this.f5542a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f5548g.inflate(R$layout.design_navigation_menu, viewGroup, false);
            this.f5542a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f5542a));
            if (this.f5547f == null) {
                this.f5547f = new c();
            }
            int i2 = this.v;
            if (i2 != -1) {
                this.f5542a.setOverScrollMode(i2);
            }
            this.f5543b = (LinearLayout) this.f5548g.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.f5542a, false);
            this.f5542a.setAdapter(this.f5547f);
        }
        return this.f5542a;
    }

    public void g(int i2) {
        this.f5549h = i2;
        this.f5550i = true;
        a(false);
    }

    @Override // a.b.e.j.m
    public void a(boolean z) {
        c cVar = this.f5547f;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // a.b.e.j.m
    public void a(m.a aVar) {
        this.f5544c = aVar;
    }

    @Override // a.b.e.j.m
    public void a(a.b.e.j.g gVar, boolean z) {
        m.a aVar = this.f5544c;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // a.b.e.j.m
    public void a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f5542a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f5547f.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f5543b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void a(a.b.e.j.i iVar) {
        this.f5547f.a(iVar);
    }

    public a.b.e.j.i a() {
        return this.f5547f.c();
    }

    public View a(int i2) {
        View inflate = this.f5548g.inflate(i2, (ViewGroup) this.f5543b, false);
        a(inflate);
        return inflate;
    }

    public void a(View view) {
        this.f5543b.addView(view);
        NavigationMenuView navigationMenuView = this.f5542a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void a(ColorStateList colorStateList) {
        this.k = colorStateList;
        a(false);
    }

    public void a(Drawable drawable) {
        this.l = drawable;
        a(false);
    }

    public void a(g0 g0Var) {
        int h2 = g0Var.h();
        if (this.t != h2) {
            this.t = h2;
            l();
        }
        NavigationMenuView navigationMenuView = this.f5542a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, g0Var.e());
        y.a(this.f5543b, g0Var);
    }
}
