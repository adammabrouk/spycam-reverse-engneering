package a.p.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SnapHelper.java */
/* loaded from: classes.dex */
public abstract class p extends RecyclerView.r {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f1692a;

    /* renamed from: b, reason: collision with root package name */
    public Scroller f1693b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView.t f1694c = new a();

    public abstract int a(RecyclerView.o oVar, int i2, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i2, int i3) {
        RecyclerView.o layoutManager = this.f1692a.getLayoutManager();
        if (layoutManager == null || this.f1692a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1692a.getMinFlingVelocity();
        return (Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && b(layoutManager, i2, i3);
    }

    public abstract int[] a(RecyclerView.o oVar, View view);

    public final void b() throws IllegalStateException {
        if (this.f1692a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f1692a.addOnScrollListener(this.f1694c);
        this.f1692a.setOnFlingListener(this);
    }

    public abstract View c(RecyclerView.o oVar);

    public void c() {
        RecyclerView.o layoutManager;
        View c2;
        RecyclerView recyclerView = this.f1692a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (c2 = c(layoutManager)) == null) {
            return;
        }
        int[] a2 = a(layoutManager, c2);
        if (a2[0] == 0 && a2[1] == 0) {
            return;
        }
        this.f1692a.smoothScrollBy(a2[0], a2[1]);
    }

    /* compiled from: SnapHelper.java */
    public class a extends RecyclerView.t {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1695a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i2) {
            super.a(recyclerView, i2);
            if (i2 == 0 && this.f1695a) {
                this.f1695a = false;
                p.this.c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i2, int i3) {
            if (i2 == 0 && i3 == 0) {
                return;
            }
            this.f1695a = true;
        }
    }

    public int[] b(int i2, int i3) {
        this.f1693b.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f1693b.getFinalX(), this.f1693b.getFinalY()};
    }

    /* compiled from: SnapHelper.java */
    public class b extends h {
        public b(Context context) {
            super(context);
        }

        @Override // a.p.a.h, androidx.recyclerview.widget.RecyclerView.y
        public void a(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            p pVar = p.this;
            RecyclerView recyclerView = pVar.f1692a;
            if (recyclerView == null) {
                return;
            }
            int[] a2 = pVar.a(recyclerView.getLayoutManager(), view);
            int i2 = a2[0];
            int i3 = a2[1];
            int d2 = d(Math.max(Math.abs(i2), Math.abs(i3)));
            if (d2 > 0) {
                aVar.a(i2, i3, d2, this.j);
            }
        }

        @Override // a.p.a.h
        public float a(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public void a(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f1692a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            a();
        }
        this.f1692a = recyclerView;
        if (recyclerView != null) {
            b();
            this.f1693b = new Scroller(this.f1692a.getContext(), new DecelerateInterpolator());
            c();
        }
    }

    public final boolean b(RecyclerView.o oVar, int i2, int i3) {
        RecyclerView.y a2;
        int a3;
        if (!(oVar instanceof RecyclerView.y.b) || (a2 = a(oVar)) == null || (a3 = a(oVar, i2, i3)) == -1) {
            return false;
        }
        a2.c(a3);
        oVar.startSmoothScroll(a2);
        return true;
    }

    public final void a() {
        this.f1692a.removeOnScrollListener(this.f1694c);
        this.f1692a.setOnFlingListener(null);
    }

    @Deprecated
    public h b(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.y.b) {
            return new b(this.f1692a.getContext());
        }
        return null;
    }

    public RecyclerView.y a(RecyclerView.o oVar) {
        return b(oVar);
    }
}
