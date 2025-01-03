package c.e.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.e;
import cn.jpush.android.api.JThirdPlatFormInterface;
import f.j.b.g;
import java.util.List;

/* compiled from: MultiItemTypeAdapter.kt */
/* loaded from: classes.dex */
public class d<T> extends RecyclerView.g<c.e.a.e> {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f6180a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<View> f6181b;

    /* renamed from: c, reason: collision with root package name */
    public c.e.a.c<T> f6182c;

    /* renamed from: d, reason: collision with root package name */
    public b f6183d;

    /* renamed from: e, reason: collision with root package name */
    public List<? extends T> f6184e;

    /* compiled from: MultiItemTypeAdapter.kt */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.j.b.d dVar) {
            this();
        }
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    public interface b {
        void a(View view, RecyclerView.c0 c0Var, int i2);

        boolean b(View view, RecyclerView.c0 c0Var, int i2);
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    public static class c implements b {
        @Override // c.e.a.d.b
        public boolean b(View view, RecyclerView.c0 c0Var, int i2) {
            f.j.b.f.d(view, "view");
            f.j.b.f.d(c0Var, "holder");
            return false;
        }
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    /* renamed from: c.e.a.d$d, reason: collision with other inner class name */
    public static final class C0119d extends g implements f.j.a.a<GridLayoutManager, GridLayoutManager.c, Integer, Integer> {
        public C0119d() {
            super(3);
        }

        @Override // f.j.a.a
        public /* bridge */ /* synthetic */ Integer invoke(GridLayoutManager gridLayoutManager, GridLayoutManager.c cVar, Integer num) {
            return Integer.valueOf(invoke(gridLayoutManager, cVar, num.intValue()));
        }

        public final int invoke(GridLayoutManager gridLayoutManager, GridLayoutManager.c cVar, int i2) {
            f.j.b.f.d(gridLayoutManager, "layoutManager");
            f.j.b.f.d(cVar, "oldLookup");
            int itemViewType = d.this.getItemViewType(i2);
            if (d.this.f6180a.get(itemViewType) == null && d.this.f6181b.get(itemViewType) == null) {
                return cVar.getSpanSize(i2);
            }
            return gridLayoutManager.getSpanCount();
        }
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    public static final class e implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.e.a.e f6186b;

        public e(c.e.a.e eVar) {
            this.f6186b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (d.this.e() != null) {
                int adapterPosition = this.f6186b.getAdapterPosition() - d.this.d();
                b e2 = d.this.e();
                if (e2 == null) {
                    f.j.b.f.b();
                    throw null;
                }
                f.j.b.f.a((Object) view, "v");
                e2.a(view, this.f6186b, adapterPosition);
            }
        }
    }

    /* compiled from: MultiItemTypeAdapter.kt */
    public static final class f implements View.OnLongClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.e.a.e f6188b;

        public f(c.e.a.e eVar) {
            this.f6188b = eVar;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            if (d.this.e() == null) {
                return false;
            }
            int adapterPosition = this.f6188b.getAdapterPosition() - d.this.d();
            b e2 = d.this.e();
            if (e2 != null) {
                f.j.b.f.a((Object) view, "v");
                return e2.b(view, this.f6188b, adapterPosition);
            }
            f.j.b.f.b();
            throw null;
        }
    }

    static {
        new a(null);
    }

    public d(List<? extends T> list) {
        f.j.b.f.d(list, JThirdPlatFormInterface.KEY_DATA);
        this.f6184e = list;
        this.f6180a = new SparseArray<>();
        this.f6181b = new SparseArray<>();
        this.f6182c = new c.e.a.c<>();
    }

    public final void a(c.e.a.e eVar, View view) {
        f.j.b.f.d(eVar, "holder");
        f.j.b.f.d(view, "itemView");
    }

    public final boolean a(int i2) {
        return true;
    }

    public final int c() {
        return this.f6181b.size();
    }

    public final int d() {
        return this.f6180a.size();
    }

    public final b e() {
        return this.f6183d;
    }

    public final int f() {
        return (getItemCount() - d()) - c();
    }

    public final boolean g() {
        return this.f6182c.a() > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return d() + c() + this.f6184e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return c(i2) ? this.f6180a.keyAt(i2) : b(i2) ? this.f6181b.keyAt((i2 - d()) - f()) : !g() ? super.getItemViewType(i2) : this.f6182c.a(this.f6184e.get(i2 - d()), i2 - d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        f.j.b.f.d(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        c.e.a.f.f6192a.a(recyclerView, new C0119d());
    }

    public final void setMOnItemClickListener(b bVar) {
        this.f6183d = bVar;
    }

    public final void setOnItemClickListener(b bVar) {
        f.j.b.f.d(bVar, "onItemClickListener");
        this.f6183d = bVar;
    }

    public final void a(c.e.a.e eVar, T t) {
        f.j.b.f.d(eVar, "holder");
        this.f6182c.a(eVar, t, eVar.getAdapterPosition() - d());
    }

    public final List<T> b() {
        return this.f6184e;
    }

    public final boolean c(int i2) {
        return i2 < d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public c.e.a.e onCreateViewHolder(ViewGroup viewGroup, int i2) {
        f.j.b.f.d(viewGroup, "parent");
        if (this.f6180a.get(i2) != null) {
            e.a aVar = c.e.a.e.f6189c;
            View view = this.f6180a.get(i2);
            if (view != null) {
                return aVar.a(view);
            }
            f.j.b.f.b();
            throw null;
        }
        if (this.f6181b.get(i2) != null) {
            e.a aVar2 = c.e.a.e.f6189c;
            View view2 = this.f6181b.get(i2);
            if (view2 != null) {
                return aVar2.a(view2);
            }
            f.j.b.f.b();
            throw null;
        }
        int a2 = this.f6182c.a(i2).a();
        e.a aVar3 = c.e.a.e.f6189c;
        Context context = viewGroup.getContext();
        f.j.b.f.a((Object) context, "parent.context");
        c.e.a.e a3 = aVar3.a(context, viewGroup, a2);
        a(a3, a3.a());
        a(viewGroup, a3, i2);
        return a3;
    }

    public final void a(ViewGroup viewGroup, c.e.a.e eVar, int i2) {
        f.j.b.f.d(viewGroup, "parent");
        f.j.b.f.d(eVar, "viewHolder");
        if (a(i2)) {
            eVar.a().setOnClickListener(new e(eVar));
            eVar.a().setOnLongClickListener(new f(eVar));
        }
    }

    public final boolean b(int i2) {
        return i2 >= d() + f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c.e.a.e eVar, int i2) {
        f.j.b.f.d(eVar, "holder");
        if (c(i2) || b(i2)) {
            return;
        }
        a(eVar, (c.e.a.e) this.f6184e.get(i2 - d()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(c.e.a.e eVar) {
        f.j.b.f.d(eVar, "holder");
        super.onViewAttachedToWindow(eVar);
        int layoutPosition = eVar.getLayoutPosition();
        if (c(layoutPosition) || b(layoutPosition)) {
            c.e.a.f.f6192a.a(eVar);
        }
    }

    public final d<T> a(c.e.a.b<T> bVar) {
        f.j.b.f.d(bVar, "itemViewDelegate");
        this.f6182c.a(bVar);
        return this;
    }
}
