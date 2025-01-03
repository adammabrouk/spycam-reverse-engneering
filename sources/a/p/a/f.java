package a.p.a;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<f> f1654e = new ThreadLocal<>();

    /* renamed from: f, reason: collision with root package name */
    public static Comparator<c> f1655f = new a();

    /* renamed from: b, reason: collision with root package name */
    public long f1657b;

    /* renamed from: c, reason: collision with root package name */
    public long f1658c;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<RecyclerView> f1656a = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<c> f1659d = new ArrayList<>();

    /* compiled from: GapWorker.java */
    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            if ((cVar.f1667d == null) != (cVar2.f1667d == null)) {
                return cVar.f1667d == null ? 1 : -1;
            }
            boolean z = cVar.f1664a;
            if (z != cVar2.f1664a) {
                return z ? -1 : 1;
            }
            int i2 = cVar2.f1665b - cVar.f1665b;
            if (i2 != 0) {
                return i2;
            }
            int i3 = cVar.f1666c - cVar2.f1666c;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    }

    /* compiled from: GapWorker.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1664a;

        /* renamed from: b, reason: collision with root package name */
        public int f1665b;

        /* renamed from: c, reason: collision with root package name */
        public int f1666c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f1667d;

        /* renamed from: e, reason: collision with root package name */
        public int f1668e;

        public void a() {
            this.f1664a = false;
            this.f1665b = 0;
            this.f1666c = 0;
            this.f1667d = null;
            this.f1668e = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f1656a.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f1656a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a.h.f.c.a(RecyclerView.TRACE_PREFETCH_TAG);
            if (!this.f1656a.isEmpty()) {
                int size = this.f1656a.size();
                long j = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f1656a.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j) + this.f1658c);
                }
            }
        } finally {
            this.f1657b = 0L;
            a.h.f.c.a();
        }
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f1657b == 0) {
            this.f1657b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.b(i2, i3);
    }

    public void b(long j) {
        a();
        a(j);
    }

    public final void a() {
        c cVar;
        int size = this.f1656a.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f1656a.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.a(recyclerView, false);
                i2 += recyclerView.mPrefetchRegistry.f1663d;
            }
        }
        this.f1659d.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f1656a.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f1660a) + Math.abs(bVar.f1661b);
                for (int i6 = 0; i6 < bVar.f1663d * 2; i6 += 2) {
                    if (i4 >= this.f1659d.size()) {
                        cVar = new c();
                        this.f1659d.add(cVar);
                    } else {
                        cVar = this.f1659d.get(i4);
                    }
                    int i7 = bVar.f1662c[i6 + 1];
                    cVar.f1664a = i7 <= abs;
                    cVar.f1665b = abs;
                    cVar.f1666c = i7;
                    cVar.f1667d = recyclerView2;
                    cVar.f1668e = bVar.f1662c[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f1659d, f1655f);
    }

    /* compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    public static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        public int f1660a;

        /* renamed from: b, reason: collision with root package name */
        public int f1661b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f1662c;

        /* renamed from: d, reason: collision with root package name */
        public int f1663d;

        public void a(RecyclerView recyclerView, boolean z) {
            this.f1663d = 0;
            int[] iArr = this.f1662c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.c()) {
                    oVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.collectAdjacentPrefetchPositions(this.f1660a, this.f1661b, recyclerView.mState, this);
            }
            int i2 = this.f1663d;
            if (i2 > oVar.mPrefetchMaxCountObserved) {
                oVar.mPrefetchMaxCountObserved = i2;
                oVar.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.j();
            }
        }

        public void b(int i2, int i3) {
            this.f1660a = i2;
            this.f1661b = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i3 >= 0) {
                int i4 = this.f1663d * 2;
                int[] iArr = this.f1662c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f1662c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i4 >= iArr.length) {
                    int[] iArr3 = new int[i4 * 2];
                    this.f1662c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f1662c;
                iArr4[i4] = i2;
                iArr4[i4 + 1] = i3;
                this.f1663d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        public boolean a(int i2) {
            if (this.f1662c != null) {
                int i3 = this.f1663d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f1662c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void a() {
            int[] iArr = this.f1662c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1663d = 0;
        }
    }

    public static boolean a(RecyclerView recyclerView, int i2) {
        int b2 = recyclerView.mChildHelper.b();
        for (int i3 = 0; i3 < b2; i3++) {
            RecyclerView.c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.e(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    public final RecyclerView.c0 a(RecyclerView recyclerView, int i2, long j) {
        if (a(recyclerView, i2)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.c0 a2 = vVar.a(i2, false, j);
            if (a2 != null) {
                if (a2.isBound() && !a2.isInvalid()) {
                    vVar.b(a2.itemView);
                } else {
                    vVar.a(a2, false);
                }
            }
            return a2;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public final void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.b() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.a(recyclerView, true);
        if (bVar.f1663d != 0) {
            try {
                a.h.f.c.a(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                recyclerView.mState.a(recyclerView.mAdapter);
                for (int i2 = 0; i2 < bVar.f1663d * 2; i2 += 2) {
                    a(recyclerView, bVar.f1662c[i2], j);
                }
            } finally {
                a.h.f.c.a();
            }
        }
    }

    public final void a(c cVar, long j) {
        RecyclerView.c0 a2 = a(cVar.f1667d, cVar.f1668e, cVar.f1664a ? RecyclerView.FOREVER_NS : j);
        if (a2 == null || a2.mNestedRecyclerView == null || !a2.isBound() || a2.isInvalid()) {
            return;
        }
        a(a2.mNestedRecyclerView.get(), j);
    }

    public final void a(long j) {
        for (int i2 = 0; i2 < this.f1659d.size(); i2++) {
            c cVar = this.f1659d.get(i2);
            if (cVar.f1667d == null) {
                return;
            }
            a(cVar, j);
            cVar.a();
        }
    }
}
