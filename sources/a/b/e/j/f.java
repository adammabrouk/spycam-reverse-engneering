package a.b.e.j;

import a.b.e.j.n;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public g f352a;

    /* renamed from: b, reason: collision with root package name */
    public int f353b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f354c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f355d;

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f356e;

    /* renamed from: f, reason: collision with root package name */
    public final int f357f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f355d = z;
        this.f356e = layoutInflater;
        this.f352a = gVar;
        this.f357f = i2;
        a();
    }

    public void a(boolean z) {
        this.f354c = z;
    }

    public g b() {
        return this.f352a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f353b < 0 ? (this.f355d ? this.f352a.j() : this.f352a.n()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f356e.inflate(this.f357f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f352a.o() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f354c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public void a() {
        i f2 = this.f352a.f();
        if (f2 != null) {
            ArrayList<i> j = this.f352a.j();
            int size = j.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (j.get(i2) == f2) {
                    this.f353b = i2;
                    return;
                }
            }
        }
        this.f353b = -1;
    }

    @Override // android.widget.Adapter
    public i getItem(int i2) {
        ArrayList<i> j = this.f355d ? this.f352a.j() : this.f352a.n();
        int i3 = this.f353b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return j.get(i2);
    }
}
