package a.b.e.j;

import a.b.e.j.m;
import a.b.e.j.n;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ExpandedMenuView;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f341a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f342b;

    /* renamed from: c, reason: collision with root package name */
    public g f343c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f344d;

    /* renamed from: e, reason: collision with root package name */
    public int f345e;

    /* renamed from: f, reason: collision with root package name */
    public int f346f;

    /* renamed from: g, reason: collision with root package name */
    public int f347g;

    /* renamed from: h, reason: collision with root package name */
    public m.a f348h;

    /* renamed from: i, reason: collision with root package name */
    public a f349i;
    public int j;

    /* compiled from: ListMenuPresenter.java */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public int f350a = -1;

        public a() {
            a();
        }

        public void a() {
            i f2 = e.this.f343c.f();
            if (f2 != null) {
                ArrayList<i> j = e.this.f343c.j();
                int size = j.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (j.get(i2) == f2) {
                        this.f350a = i2;
                        return;
                    }
                }
            }
            this.f350a = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f343c.j().size() - e.this.f345e;
            return this.f350a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f342b.inflate(eVar.f347g, viewGroup, false);
            }
            ((n.a) view).a(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public i getItem(int i2) {
            ArrayList<i> j = e.this.f343c.j();
            int i3 = i2 + e.this.f345e;
            int i4 = this.f350a;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return j.get(i3);
        }
    }

    public e(Context context, int i2) {
        this(i2, 0);
        this.f341a = context;
        this.f342b = LayoutInflater.from(context);
    }

    @Override // a.b.e.j.m
    public void a(Context context, g gVar) {
        if (this.f346f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f346f);
            this.f341a = contextThemeWrapper;
            this.f342b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f341a != null) {
            this.f341a = context;
            if (this.f342b == null) {
                this.f342b = LayoutInflater.from(context);
            }
        }
        this.f343c = gVar;
        a aVar = this.f349i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // a.b.e.j.m
    public boolean a(g gVar, i iVar) {
        return false;
    }

    public void b(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f344d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // a.b.e.j.m
    public boolean b(g gVar, i iVar) {
        return false;
    }

    @Override // a.b.e.j.m
    public int c() {
        return this.j;
    }

    @Override // a.b.e.j.m
    public boolean f() {
        return false;
    }

    @Override // a.b.e.j.m
    public Parcelable g() {
        if (this.f344d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        b(bundle);
        return bundle;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        this.f343c.a(this.f349i.getItem(i2), this, 0);
    }

    public e(int i2, int i3) {
        this.f347g = i2;
        this.f346f = i3;
    }

    public n a(ViewGroup viewGroup) {
        if (this.f344d == null) {
            this.f344d = (ExpandedMenuView) this.f342b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f349i == null) {
                this.f349i = new a();
            }
            this.f344d.setAdapter((ListAdapter) this.f349i);
            this.f344d.setOnItemClickListener(this);
        }
        return this.f344d;
    }

    public ListAdapter a() {
        if (this.f349i == null) {
            this.f349i = new a();
        }
        return this.f349i;
    }

    @Override // a.b.e.j.m
    public void a(boolean z) {
        a aVar = this.f349i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // a.b.e.j.m
    public void a(m.a aVar) {
        this.f348h = aVar;
    }

    @Override // a.b.e.j.m
    public boolean a(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).a((IBinder) null);
        m.a aVar = this.f348h;
        if (aVar == null) {
            return true;
        }
        aVar.a(rVar);
        return true;
    }

    @Override // a.b.e.j.m
    public void a(g gVar, boolean z) {
        m.a aVar = this.f348h;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public void a(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f344d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // a.b.e.j.m
    public void a(Parcelable parcelable) {
        a((Bundle) parcelable);
    }
}
