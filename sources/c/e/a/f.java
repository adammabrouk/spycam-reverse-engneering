package c.e.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: WrapperUtils.kt */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f6192a = new f();

    /* compiled from: WrapperUtils.kt */
    public static final class a extends GridLayoutManager.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f.j.a.a f6193a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.o f6194b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager.c f6195c;

        public a(f.j.a.a aVar, RecyclerView.o oVar, GridLayoutManager.c cVar) {
            this.f6193a = aVar;
            this.f6194b = oVar;
            this.f6195c = cVar;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i2) {
            f.j.a.a aVar = this.f6193a;
            RecyclerView.o oVar = this.f6194b;
            GridLayoutManager.c cVar = this.f6195c;
            f.j.b.f.a((Object) cVar, "spanSizeLookup");
            return ((Number) aVar.invoke(oVar, cVar, Integer.valueOf(i2))).intValue();
        }
    }

    public final void a(RecyclerView recyclerView, f.j.a.a<? super GridLayoutManager, ? super GridLayoutManager.c, ? super Integer, Integer> aVar) {
        f.j.b.f.d(recyclerView, "recyclerView");
        f.j.b.f.d(aVar, "fn");
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(aVar, layoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    public final void a(RecyclerView.c0 c0Var) {
        f.j.b.f.d(c0Var, "holder");
        View view = c0Var.itemView;
        f.j.b.f.a((Object) view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof StaggeredGridLayoutManager.c)) {
            return;
        }
        ((StaggeredGridLayoutManager.c) layoutParams).a(true);
    }
}
