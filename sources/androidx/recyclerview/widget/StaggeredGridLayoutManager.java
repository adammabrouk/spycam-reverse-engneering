package androidx.recyclerview.widget;

import a.h.j.h0.c;
import a.p.a.g;
import a.p.a.h;
import a.p.a.k;
import a.p.a.n;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.y.b {

    /* renamed from: b, reason: collision with root package name */
    public d[] f2768b;

    /* renamed from: c, reason: collision with root package name */
    public k f2769c;

    /* renamed from: d, reason: collision with root package name */
    public k f2770d;

    /* renamed from: e, reason: collision with root package name */
    public int f2771e;

    /* renamed from: f, reason: collision with root package name */
    public int f2772f;

    /* renamed from: g, reason: collision with root package name */
    public final g f2773g;
    public BitSet j;
    public boolean o;
    public boolean p;
    public SavedState q;
    public int r;
    public int[] w;

    /* renamed from: a, reason: collision with root package name */
    public int f2767a = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2774h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2775i = false;
    public int k = -1;
    public int l = Integer.MIN_VALUE;
    public LazySpanLookup m = new LazySpanLookup();
    public int n = 2;
    public final Rect s = new Rect();
    public final b t = new b();
    public boolean u = false;
    public boolean v = true;
    public final Runnable x = new a();

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f2782a;

        /* renamed from: b, reason: collision with root package name */
        public int f2783b;

        /* renamed from: c, reason: collision with root package name */
        public int f2784c;

        /* renamed from: d, reason: collision with root package name */
        public int[] f2785d;

        /* renamed from: e, reason: collision with root package name */
        public int f2786e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f2787f;

        /* renamed from: g, reason: collision with root package name */
        public List<LazySpanLookup.FullSpanItem> f2788g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f2789h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f2790i;
        public boolean j;

        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        public void a() {
            this.f2785d = null;
            this.f2784c = 0;
            this.f2782a = -1;
            this.f2783b = -1;
        }

        public void c() {
            this.f2785d = null;
            this.f2784c = 0;
            this.f2786e = 0;
            this.f2787f = null;
            this.f2788g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f2782a);
            parcel.writeInt(this.f2783b);
            parcel.writeInt(this.f2784c);
            if (this.f2784c > 0) {
                parcel.writeIntArray(this.f2785d);
            }
            parcel.writeInt(this.f2786e);
            if (this.f2786e > 0) {
                parcel.writeIntArray(this.f2787f);
            }
            parcel.writeInt(this.f2789h ? 1 : 0);
            parcel.writeInt(this.f2790i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.f2788g);
        }

        public SavedState(Parcel parcel) {
            this.f2782a = parcel.readInt();
            this.f2783b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f2784c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f2785d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f2786e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f2787f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f2789h = parcel.readInt() == 1;
            this.f2790i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.f2788g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f2784c = savedState.f2784c;
            this.f2782a = savedState.f2782a;
            this.f2783b = savedState.f2783b;
            this.f2785d = savedState.f2785d;
            this.f2786e = savedState.f2786e;
            this.f2787f = savedState.f2787f;
            this.f2789h = savedState.f2789h;
            this.f2790i = savedState.f2790i;
            this.j = savedState.j;
            this.f2788g = savedState.f2788g;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.c();
        }
    }

    public static class c extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        public d f2799e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f2800f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void a(boolean z) {
            this.f2800f = z;
        }

        public final int e() {
            d dVar = this.f2799e;
            if (dVar == null) {
                return -1;
            }
            return dVar.f2805e;
        }

        public boolean f() {
            return this.f2800f;
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<View> f2801a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public int f2802b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        public int f2803c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f2804d = 0;

        /* renamed from: e, reason: collision with root package name */
        public final int f2805e;

        public d(int i2) {
            this.f2805e = i2;
        }

        public int a(int i2) {
            int i3 = this.f2803c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f2801a.size() == 0) {
                return i2;
            }
            a();
            return this.f2803c;
        }

        public int b(int i2) {
            int i3 = this.f2802b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f2801a.size() == 0) {
                return i2;
            }
            b();
            return this.f2802b;
        }

        public void c(View view) {
            c b2 = b(view);
            b2.f2799e = this;
            this.f2801a.add(0, view);
            this.f2802b = Integer.MIN_VALUE;
            if (this.f2801a.size() == 1) {
                this.f2803c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f2804d += StaggeredGridLayoutManager.this.f2769c.b(view);
            }
        }

        public void d(int i2) {
            this.f2802b = i2;
            this.f2803c = i2;
        }

        public int e() {
            return StaggeredGridLayoutManager.this.f2774h ? a(0, this.f2801a.size(), true) : a(this.f2801a.size() - 1, -1, true);
        }

        public int f() {
            return this.f2804d;
        }

        public int g() {
            int i2 = this.f2803c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            a();
            return this.f2803c;
        }

        public int h() {
            int i2 = this.f2802b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            b();
            return this.f2802b;
        }

        public void i() {
            this.f2802b = Integer.MIN_VALUE;
            this.f2803c = Integer.MIN_VALUE;
        }

        public void j() {
            int size = this.f2801a.size();
            View remove = this.f2801a.remove(size - 1);
            c b2 = b(remove);
            b2.f2799e = null;
            if (b2.c() || b2.b()) {
                this.f2804d -= StaggeredGridLayoutManager.this.f2769c.b(remove);
            }
            if (size == 1) {
                this.f2802b = Integer.MIN_VALUE;
            }
            this.f2803c = Integer.MIN_VALUE;
        }

        public void k() {
            View remove = this.f2801a.remove(0);
            c b2 = b(remove);
            b2.f2799e = null;
            if (this.f2801a.size() == 0) {
                this.f2803c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f2804d -= StaggeredGridLayoutManager.this.f2769c.b(remove);
            }
            this.f2802b = Integer.MIN_VALUE;
        }

        public int d() {
            return StaggeredGridLayoutManager.this.f2774h ? a(this.f2801a.size() - 1, -1, true) : a(0, this.f2801a.size(), true);
        }

        public void a() {
            LazySpanLookup.FullSpanItem c2;
            ArrayList<View> arrayList = this.f2801a;
            View view = arrayList.get(arrayList.size() - 1);
            c b2 = b(view);
            this.f2803c = StaggeredGridLayoutManager.this.f2769c.a(view);
            if (b2.f2800f && (c2 = StaggeredGridLayoutManager.this.m.c(b2.a())) != null && c2.f2779b == 1) {
                this.f2803c += c2.a(this.f2805e);
            }
        }

        public void b() {
            LazySpanLookup.FullSpanItem c2;
            View view = this.f2801a.get(0);
            c b2 = b(view);
            this.f2802b = StaggeredGridLayoutManager.this.f2769c.d(view);
            if (b2.f2800f && (c2 = StaggeredGridLayoutManager.this.m.c(b2.a())) != null && c2.f2779b == -1) {
                this.f2802b -= c2.a(this.f2805e);
            }
        }

        public void c() {
            this.f2801a.clear();
            i();
            this.f2804d = 0;
        }

        public void c(int i2) {
            int i3 = this.f2802b;
            if (i3 != Integer.MIN_VALUE) {
                this.f2802b = i3 + i2;
            }
            int i4 = this.f2803c;
            if (i4 != Integer.MIN_VALUE) {
                this.f2803c = i4 + i2;
            }
        }

        public void a(View view) {
            c b2 = b(view);
            b2.f2799e = this;
            this.f2801a.add(view);
            this.f2803c = Integer.MIN_VALUE;
            if (this.f2801a.size() == 1) {
                this.f2802b = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f2804d += StaggeredGridLayoutManager.this.f2769c.b(view);
            }
        }

        public c b(View view) {
            return (c) view.getLayoutParams();
        }

        public void a(boolean z, int i2) {
            int b2;
            if (z) {
                b2 = a(Integer.MIN_VALUE);
            } else {
                b2 = b(Integer.MIN_VALUE);
            }
            c();
            if (b2 == Integer.MIN_VALUE) {
                return;
            }
            if (!z || b2 >= StaggeredGridLayoutManager.this.f2769c.b()) {
                if (z || b2 <= StaggeredGridLayoutManager.this.f2769c.f()) {
                    if (i2 != Integer.MIN_VALUE) {
                        b2 += i2;
                    }
                    this.f2803c = b2;
                    this.f2802b = b2;
                }
            }
        }

        public int a(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int f2 = StaggeredGridLayoutManager.this.f2769c.f();
            int b2 = StaggeredGridLayoutManager.this.f2769c.b();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.f2801a.get(i2);
                int d2 = StaggeredGridLayoutManager.this.f2769c.d(view);
                int a2 = StaggeredGridLayoutManager.this.f2769c.a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? d2 >= b2 : d2 > b2;
                if (!z3 ? a2 > f2 : a2 >= f2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (d2 >= f2 && a2 <= b2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (d2 < f2 || a2 > b2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i2 += i4;
            }
            return -1;
        }

        public int a(int i2, int i3, boolean z) {
            return a(i2, i3, false, false, z);
        }

        public View a(int i2, int i3) {
            View view = null;
            if (i3 == -1) {
                int size = this.f2801a.size();
                int i4 = 0;
                while (i4 < size) {
                    View view2 = this.f2801a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f2774h && staggeredGridLayoutManager.getPosition(view2) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f2774h && staggeredGridLayoutManager2.getPosition(view2) >= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view2;
                }
            } else {
                int size2 = this.f2801a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f2801a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f2774h && staggeredGridLayoutManager3.getPosition(view3) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f2774h && staggeredGridLayoutManager4.getPosition(view3) <= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.f2719a);
        setSpanCount(properties.f2720b);
        setReverseLayout(properties.f2721c);
        this.f2773g = new g();
        d();
    }

    public final boolean a(d dVar) {
        if (this.f2775i) {
            if (dVar.g() < this.f2769c.b()) {
                ArrayList<View> arrayList = dVar.f2801a;
                return !dVar.b(arrayList.get(arrayList.size() - 1)).f2800f;
            }
        } else if (dVar.h() > this.f2769c.f()) {
            return !dVar.b(dVar.f2801a.get(0)).f2800f;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean b(RecyclerView.z zVar, b bVar) {
        int i2;
        if (!zVar.d() && (i2 = this.k) != -1) {
            if (i2 >= 0 && i2 < zVar.a()) {
                SavedState savedState = this.q;
                if (savedState == null || savedState.f2782a == -1 || savedState.f2784c < 1) {
                    View findViewByPosition = findViewByPosition(this.k);
                    if (findViewByPosition != null) {
                        bVar.f2792a = this.f2775i ? g() : f();
                        if (this.l != Integer.MIN_VALUE) {
                            if (bVar.f2794c) {
                                bVar.f2793b = (this.f2769c.b() - this.l) - this.f2769c.a(findViewByPosition);
                            } else {
                                bVar.f2793b = (this.f2769c.f() + this.l) - this.f2769c.d(findViewByPosition);
                            }
                            return true;
                        }
                        if (this.f2769c.b(findViewByPosition) > this.f2769c.g()) {
                            bVar.f2793b = bVar.f2794c ? this.f2769c.b() : this.f2769c.f();
                            return true;
                        }
                        int d2 = this.f2769c.d(findViewByPosition) - this.f2769c.f();
                        if (d2 < 0) {
                            bVar.f2793b = -d2;
                            return true;
                        }
                        int b2 = this.f2769c.b() - this.f2769c.a(findViewByPosition);
                        if (b2 < 0) {
                            bVar.f2793b = b2;
                            return true;
                        }
                        bVar.f2793b = Integer.MIN_VALUE;
                    } else {
                        int i3 = this.k;
                        bVar.f2792a = i3;
                        int i4 = this.l;
                        if (i4 == Integer.MIN_VALUE) {
                            bVar.f2794c = a(i3) == 1;
                            bVar.a();
                        } else {
                            bVar.a(i4);
                        }
                        bVar.f2795d = true;
                    }
                } else {
                    bVar.f2793b = Integer.MIN_VALUE;
                    bVar.f2792a = this.k;
                }
                return true;
            }
            this.k = -1;
            this.l = Integer.MIN_VALUE;
        }
        return false;
    }

    public boolean c() {
        int f2;
        int g2;
        if (getChildCount() == 0 || this.n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f2775i) {
            f2 = g();
            g2 = f();
        } else {
            f2 = f();
            g2 = g();
        }
        if (f2 == 0 && h() != null) {
            this.m.a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.u) {
            return false;
        }
        int i2 = this.f2775i ? -1 : 1;
        int i3 = g2 + 1;
        LazySpanLookup.FullSpanItem a2 = this.m.a(f2, i3, i2, true);
        if (a2 == null) {
            this.u = false;
            this.m.b(i3);
            return false;
        }
        LazySpanLookup.FullSpanItem a3 = this.m.a(f2, a2.f2778a, i2 * (-1), true);
        if (a3 == null) {
            this.m.b(a2.f2778a);
        } else {
            this.m.b(a3.f2778a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        return this.f2771e == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return this.f2771e == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        int a2;
        int i4;
        if (this.f2771e != 0) {
            i2 = i3;
        }
        if (getChildCount() == 0 || i2 == 0) {
            return;
        }
        a(i2, zVar);
        int[] iArr = this.w;
        if (iArr == null || iArr.length < this.f2767a) {
            this.w = new int[this.f2767a];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f2767a; i6++) {
            g gVar = this.f2773g;
            if (gVar.f1672d == -1) {
                a2 = gVar.f1674f;
                i4 = this.f2768b[i6].b(a2);
            } else {
                a2 = this.f2768b[i6].a(gVar.f1675g);
                i4 = this.f2773g.f1675g;
            }
            int i7 = a2 - i4;
            if (i7 >= 0) {
                this.w[i5] = i7;
                i5++;
            }
        }
        Arrays.sort(this.w, 0, i5);
        for (int i8 = 0; i8 < i5 && this.f2773g.a(zVar); i8++) {
            cVar.a(this.f2773g.f1671c, this.w[i8]);
            g gVar2 = this.f2773g;
            gVar2.f1671c += gVar2.f1672d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    public final int computeScrollExtent(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return n.a(zVar, this.f2769c, b(!this.v), a(!this.v), this, this.v);
    }

    public final int computeScrollOffset(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return n.a(zVar, this.f2769c, b(!this.v), a(!this.v), this, this.v, this.f2775i);
    }

    public final int computeScrollRange(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return n.b(zVar, this.f2769c, b(!this.v), a(!this.v), this, this.v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF computeScrollVectorForPosition(int i2) {
        int a2 = a(i2);
        PointF pointF = new PointF();
        if (a2 == 0) {
            return null;
        }
        if (this.f2771e == 0) {
            pointF.x = a2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = a2;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    public final int convertFocusDirectionToLayoutDirection(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.f2771e == 1) ? 1 : Integer.MIN_VALUE : this.f2771e == 0 ? 1 : Integer.MIN_VALUE : this.f2771e == 1 ? -1 : Integer.MIN_VALUE : this.f2771e == 0 ? -1 : Integer.MIN_VALUE : (this.f2771e != 1 && isLayoutRTL()) ? -1 : 1 : (this.f2771e != 1 && isLayoutRTL()) ? 1 : -1;
    }

    public final void d() {
        this.f2769c = k.a(this, this.f2771e);
        this.f2770d = k.a(this, 1 - this.f2771e);
    }

    public int e() {
        View a2 = this.f2775i ? a(true) : b(true);
        if (a2 == null) {
            return -1;
        }
        return getPosition(a2);
    }

    public final int f(int i2) {
        int a2 = this.f2768b[0].a(i2);
        for (int i3 = 1; i3 < this.f2767a; i3++) {
            int a3 = this.f2768b[i3].a(i2);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    public final int g(int i2) {
        int b2 = this.f2768b[0].b(i2);
        for (int i3 = 1; i3 < this.f2767a; i3++) {
            int b3 = this.f2768b[i3].b(i2);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return this.f2771e == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f2771e == 1 ? this.f2767a : super.getColumnCountForAccessibility(vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f2771e == 0 ? this.f2767a : super.getRowCountForAccessibility(vVar, zVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View h() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f2767a
            r2.<init>(r3)
            int r3 = r12.f2767a
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f2771e
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.f2775i
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f2799e
            int r9 = r9.f2805e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f2799e
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f2799e
            int r9 = r9.f2805e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f2800f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f2775i
            if (r10 == 0) goto L77
            a.p.a.k r10 = r12.f2769c
            int r10 = r10.a(r7)
            a.p.a.k r11 = r12.f2769c
            int r11 = r11.a(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            a.p.a.k r10 = r12.f2769c
            int r10 = r10.d(r7)
            a.p.a.k r11 = r12.f2769c
            int r11 = r11.d(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r8 = r8.f2799e
            int r8 = r8.f2805e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r9.f2799e
            int r9 = r9.f2805e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.h():android.view.View");
    }

    public void i() {
        this.m.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public final void j() {
        if (this.f2770d.d() == 1073741824) {
            return;
        }
        float f2 = 0.0f;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            float b2 = this.f2770d.b(childAt);
            if (b2 >= f2) {
                if (((c) childAt.getLayoutParams()).f()) {
                    b2 = (b2 * 1.0f) / this.f2767a;
                }
                f2 = Math.max(f2, b2);
            }
        }
        int i3 = this.f2772f;
        int round = Math.round(f2 * this.f2767a);
        if (this.f2770d.d() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f2770d.g());
        }
        l(round);
        if (this.f2772f == i3) {
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            c cVar = (c) childAt2.getLayoutParams();
            if (!cVar.f2800f) {
                if (isLayoutRTL() && this.f2771e == 1) {
                    int i5 = this.f2767a;
                    int i6 = cVar.f2799e.f2805e;
                    childAt2.offsetLeftAndRight(((-((i5 - 1) - i6)) * this.f2772f) - ((-((i5 - 1) - i6)) * i3));
                } else {
                    int i7 = cVar.f2799e.f2805e;
                    int i8 = this.f2772f * i7;
                    int i9 = i7 * i3;
                    if (this.f2771e == 1) {
                        childAt2.offsetLeftAndRight(i8 - i9);
                    } else {
                        childAt2.offsetTopAndBottom(i8 - i9);
                    }
                }
            }
        }
    }

    public final void k(int i2) {
        g gVar = this.f2773g;
        gVar.f1673e = i2;
        gVar.f1672d = this.f2775i != (i2 == -1) ? -1 : 1;
    }

    public void l(int i2) {
        this.f2772f = i2 / this.f2767a;
        this.r = View.MeasureSpec.makeMeasureSpec(i2, this.f2770d.d());
    }

    public final void measureChildWithDecorationsAndMargin(View view, int i2, int i3, boolean z) {
        calculateItemDecorationsForChild(view, this.s);
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.s;
        int b2 = b(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.s;
        int b3 = b(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z ? shouldReMeasureChild(view, b2, b3, cVar) : shouldMeasureChild(view, b2, b3, cVar)) {
            view.measure(b2, b3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void offsetChildrenHorizontal(int i2) {
        super.offsetChildrenHorizontal(i2);
        for (int i3 = 0; i3 < this.f2767a; i3++) {
            this.f2768b[i3].c(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void offsetChildrenVertical(int i2) {
        super.offsetChildrenVertical(i2);
        for (int i3 = 0; i3 < this.f2767a; i3++) {
            this.f2768b[i3].c(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        removeCallbacks(this.x);
        for (int i2 = 0; i2 < this.f2767a; i2++) {
            this.f2768b[i2].c();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        View findContainingItemView;
        View a2;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) findContainingItemView.getLayoutParams();
        boolean z = cVar.f2800f;
        d dVar = cVar.f2799e;
        int g2 = convertFocusDirectionToLayoutDirection == 1 ? g() : f();
        b(g2, zVar);
        k(convertFocusDirectionToLayoutDirection);
        g gVar = this.f2773g;
        gVar.f1671c = gVar.f1672d + g2;
        gVar.f1670b = (int) (this.f2769c.g() * 0.33333334f);
        g gVar2 = this.f2773g;
        gVar2.f1676h = true;
        gVar2.f1669a = false;
        a(vVar, gVar2, zVar);
        this.o = this.f2775i;
        if (!z && (a2 = dVar.a(g2, convertFocusDirectionToLayoutDirection)) != null && a2 != findContainingItemView) {
            return a2;
        }
        if (j(convertFocusDirectionToLayoutDirection)) {
            for (int i3 = this.f2767a - 1; i3 >= 0; i3--) {
                View a3 = this.f2768b[i3].a(g2, convertFocusDirectionToLayoutDirection);
                if (a3 != null && a3 != findContainingItemView) {
                    return a3;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.f2767a; i4++) {
                View a4 = this.f2768b[i4].a(g2, convertFocusDirectionToLayoutDirection);
                if (a4 != null && a4 != findContainingItemView) {
                    return a4;
                }
            }
        }
        boolean z2 = (this.f2774h ^ true) == (convertFocusDirectionToLayoutDirection == -1);
        if (!z) {
            View findViewByPosition = findViewByPosition(z2 ? dVar.d() : dVar.e());
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (j(convertFocusDirectionToLayoutDirection)) {
            for (int i5 = this.f2767a - 1; i5 >= 0; i5--) {
                if (i5 != dVar.f2805e) {
                    View findViewByPosition2 = findViewByPosition(z2 ? this.f2768b[i5].d() : this.f2768b[i5].e());
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.f2767a; i6++) {
                View findViewByPosition3 = findViewByPosition(z2 ? this.f2768b[i6].d() : this.f2768b[i6].e());
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View b2 = b(false);
            View a2 = a(false);
            if (b2 == null || a2 == null) {
                return;
            }
            int position = getPosition(b2);
            int position2 = getPosition(a2);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.z zVar, View view, a.h.j.h0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        if (this.f2771e == 0) {
            cVar.b(c.C0028c.a(cVar2.e(), cVar2.f2800f ? this.f2767a : 1, -1, -1, false, false));
        } else {
            cVar.b(c.C0028c.a(-1, -1, cVar2.e(), cVar2.f2800f ? this.f2767a : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        a(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.m.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        a(i2, i3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        a(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        a(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        c(vVar, zVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.z zVar) {
        super.onLayoutCompleted(zVar);
        this.k = -1;
        this.l = Integer.MIN_VALUE;
        this.q = null;
        this.t.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.q = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        int b2;
        int f2;
        int[] iArr;
        if (this.q != null) {
            return new SavedState(this.q);
        }
        SavedState savedState = new SavedState();
        savedState.f2789h = this.f2774h;
        savedState.f2790i = this.o;
        savedState.j = this.p;
        LazySpanLookup lazySpanLookup = this.m;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f2776a) == null) {
            savedState.f2786e = 0;
        } else {
            savedState.f2787f = iArr;
            savedState.f2786e = iArr.length;
            savedState.f2788g = lazySpanLookup.f2777b;
        }
        if (getChildCount() > 0) {
            savedState.f2782a = this.o ? g() : f();
            savedState.f2783b = e();
            int i2 = this.f2767a;
            savedState.f2784c = i2;
            savedState.f2785d = new int[i2];
            for (int i3 = 0; i3 < this.f2767a; i3++) {
                if (this.o) {
                    b2 = this.f2768b[i3].a(Integer.MIN_VALUE);
                    if (b2 != Integer.MIN_VALUE) {
                        f2 = this.f2769c.b();
                        b2 -= f2;
                        savedState.f2785d[i3] = b2;
                    } else {
                        savedState.f2785d[i3] = b2;
                    }
                } else {
                    b2 = this.f2768b[i3].b(Integer.MIN_VALUE);
                    if (b2 != Integer.MIN_VALUE) {
                        f2 = this.f2769c.f();
                        b2 -= f2;
                        savedState.f2785d[i3] = b2;
                    } else {
                        savedState.f2785d[i3] = b2;
                    }
                }
            }
        } else {
            savedState.f2782a = -1;
            savedState.f2783b = -1;
            savedState.f2784c = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onScrollStateChanged(int i2) {
        if (i2 == 0) {
            c();
        }
    }

    public final void resolveShouldLayoutReverse() {
        if (this.f2771e == 1 || !isLayoutRTL()) {
            this.f2775i = this.f2774h;
        } else {
            this.f2775i = !this.f2774h;
        }
    }

    public int scrollBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        a(i2, zVar);
        int a2 = a(vVar, this.f2773g, zVar);
        if (this.f2773g.f1670b >= a2) {
            i2 = i2 < 0 ? -a2 : a2;
        }
        this.f2769c.a(-i2);
        this.o = this.f2775i;
        g gVar = this.f2773g;
        gVar.f1670b = 0;
        a(vVar, gVar);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        return scrollBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i2) {
        SavedState savedState = this.q;
        if (savedState != null && savedState.f2782a != i2) {
            savedState.a();
        }
        this.k = i2;
        this.l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        return scrollBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f2771e == 1) {
            chooseSize2 = RecyclerView.o.chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.o.chooseSize(i2, (this.f2772f * this.f2767a) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.o.chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.o.chooseSize(i3, (this.f2772f * this.f2767a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i2 == this.f2771e) {
            return;
        }
        this.f2771e = i2;
        k kVar = this.f2769c;
        this.f2769c = this.f2770d;
        this.f2770d = kVar;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.q;
        if (savedState != null && savedState.f2789h != z) {
            savedState.f2789h = z;
        }
        this.f2774h = z;
        requestLayout();
    }

    public void setSpanCount(int i2) {
        assertNotInLayoutOrScroll(null);
        if (i2 != this.f2767a) {
            i();
            this.f2767a = i2;
            this.j = new BitSet(this.f2767a);
            this.f2768b = new d[this.f2767a];
            for (int i3 = 0; i3 < this.f2767a; i3++) {
                this.f2768b[i3] = new d(i3);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.z zVar, int i2) {
        h hVar = new h(recyclerView.getContext());
        hVar.c(i2);
        startSmoothScroll(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.q == null;
    }

    public static class LazySpanLookup {

        /* renamed from: a, reason: collision with root package name */
        public int[] f2776a;

        /* renamed from: b, reason: collision with root package name */
        public List<FullSpanItem> f2777b;

        public void a(int i2, d dVar) {
            a(i2);
            this.f2776a[i2] = dVar.f2805e;
        }

        public int b(int i2) {
            List<FullSpanItem> list = this.f2777b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f2777b.get(size).f2778a >= i2) {
                        this.f2777b.remove(size);
                    }
                }
            }
            return e(i2);
        }

        public final void c(int i2, int i3) {
            List<FullSpanItem> list = this.f2777b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f2777b.get(size);
                int i4 = fullSpanItem.f2778a;
                if (i4 >= i2) {
                    fullSpanItem.f2778a = i4 + i3;
                }
            }
        }

        public int d(int i2) {
            int[] iArr = this.f2776a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        public int e(int i2) {
            int[] iArr = this.f2776a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int f2 = f(i2);
            if (f2 == -1) {
                int[] iArr2 = this.f2776a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f2776a.length;
            }
            int i3 = f2 + 1;
            Arrays.fill(this.f2776a, i2, i3, -1);
            return i3;
        }

        public final int f(int i2) {
            if (this.f2777b == null) {
                return -1;
            }
            FullSpanItem c2 = c(i2);
            if (c2 != null) {
                this.f2777b.remove(c2);
            }
            int size = this.f2777b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (this.f2777b.get(i3).f2778a >= i2) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f2777b.get(i3);
            this.f2777b.remove(i3);
            return fullSpanItem.f2778a;
        }

        public int g(int i2) {
            int length = this.f2776a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        public void a(int i2) {
            int[] iArr = this.f2776a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i2, 10) + 1];
                this.f2776a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[g(i2)];
                this.f2776a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f2776a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public final void d(int i2, int i3) {
            List<FullSpanItem> list = this.f2777b;
            if (list == null) {
                return;
            }
            int i4 = i2 + i3;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f2777b.get(size);
                int i5 = fullSpanItem.f2778a;
                if (i5 >= i2) {
                    if (i5 < i4) {
                        this.f2777b.remove(size);
                    } else {
                        fullSpanItem.f2778a = i5 - i3;
                    }
                }
            }
        }

        public FullSpanItem c(int i2) {
            List<FullSpanItem> list = this.f2777b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f2777b.get(size);
                if (fullSpanItem.f2778a == i2) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            public int f2778a;

            /* renamed from: b, reason: collision with root package name */
            public int f2779b;

            /* renamed from: c, reason: collision with root package name */
            public int[] f2780c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f2781d;

            public static class a implements Parcelable.Creator<FullSpanItem> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.f2778a = parcel.readInt();
                this.f2779b = parcel.readInt();
                this.f2781d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f2780c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i2) {
                int[] iArr = this.f2780c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2778a + ", mGapDir=" + this.f2779b + ", mHasUnwantedGapAfter=" + this.f2781d + ", mGapPerSpan=" + Arrays.toString(this.f2780c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f2778a);
                parcel.writeInt(this.f2779b);
                parcel.writeInt(this.f2781d ? 1 : 0);
                int[] iArr = this.f2780c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f2780c);
                }
            }

            public FullSpanItem() {
            }
        }

        public void b(int i2, int i3) {
            int[] iArr = this.f2776a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            a(i4);
            int[] iArr2 = this.f2776a;
            System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
            int[] iArr3 = this.f2776a;
            Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
            d(i2, i3);
        }

        public void a() {
            int[] iArr = this.f2776a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2777b = null;
        }

        public void a(int i2, int i3) {
            int[] iArr = this.f2776a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            a(i4);
            int[] iArr2 = this.f2776a;
            System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
            Arrays.fill(this.f2776a, i2, i4, -1);
            c(i2, i3);
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f2777b == null) {
                this.f2777b = new ArrayList();
            }
            int size = this.f2777b.size();
            for (int i2 = 0; i2 < size; i2++) {
                FullSpanItem fullSpanItem2 = this.f2777b.get(i2);
                if (fullSpanItem2.f2778a == fullSpanItem.f2778a) {
                    this.f2777b.remove(i2);
                }
                if (fullSpanItem2.f2778a >= fullSpanItem.f2778a) {
                    this.f2777b.add(i2, fullSpanItem);
                    return;
                }
            }
            this.f2777b.add(fullSpanItem);
        }

        public FullSpanItem a(int i2, int i3, int i4, boolean z) {
            List<FullSpanItem> list = this.f2777b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem = this.f2777b.get(i5);
                int i6 = fullSpanItem.f2778a;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || fullSpanItem.f2779b == i4 || (z && fullSpanItem.f2781d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public final int i(int i2) {
        int b2 = this.f2768b[0].b(i2);
        for (int i3 = 1; i3 < this.f2767a; i3++) {
            int b3 = this.f2768b[i3].b(i2);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f2792a;

        /* renamed from: b, reason: collision with root package name */
        public int f2793b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2794c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2795d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2796e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f2797f;

        public b() {
            b();
        }

        public void a(d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f2797f;
            if (iArr == null || iArr.length < length) {
                this.f2797f = new int[StaggeredGridLayoutManager.this.f2768b.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f2797f[i2] = dVarArr[i2].b(Integer.MIN_VALUE);
            }
        }

        public void b() {
            this.f2792a = -1;
            this.f2793b = Integer.MIN_VALUE;
            this.f2794c = false;
            this.f2795d = false;
            this.f2796e = false;
            int[] iArr = this.f2797f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void a() {
            this.f2793b = this.f2794c ? StaggeredGridLayoutManager.this.f2769c.b() : StaggeredGridLayoutManager.this.f2769c.f();
        }

        public void a(int i2) {
            if (this.f2794c) {
                this.f2793b = StaggeredGridLayoutManager.this.f2769c.b() - i2;
            } else {
                this.f2793b = StaggeredGridLayoutManager.this.f2769c.f() + i2;
            }
        }
    }

    public final int d(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            int position = getPosition(getChildAt(i3));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    public final int e(int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    public int f() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int g() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final void a(b bVar) {
        int f2;
        SavedState savedState = this.q;
        int i2 = savedState.f2784c;
        if (i2 > 0) {
            if (i2 == this.f2767a) {
                for (int i3 = 0; i3 < this.f2767a; i3++) {
                    this.f2768b[i3].c();
                    SavedState savedState2 = this.q;
                    int i4 = savedState2.f2785d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (savedState2.f2790i) {
                            f2 = this.f2769c.b();
                        } else {
                            f2 = this.f2769c.f();
                        }
                        i4 += f2;
                    }
                    this.f2768b[i3].d(i4);
                }
            } else {
                savedState.c();
                SavedState savedState3 = this.q;
                savedState3.f2782a = savedState3.f2783b;
            }
        }
        SavedState savedState4 = this.q;
        this.p = savedState4.j;
        setReverseLayout(savedState4.f2789h);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.q;
        int i5 = savedState5.f2782a;
        if (i5 != -1) {
            this.k = i5;
            bVar.f2794c = savedState5.f2790i;
        } else {
            bVar.f2794c = this.f2775i;
        }
        SavedState savedState6 = this.q;
        if (savedState6.f2786e > 1) {
            LazySpanLookup lazySpanLookup = this.m;
            lazySpanLookup.f2776a = savedState6.f2787f;
            lazySpanLookup.f2777b = savedState6.f2788g;
        }
    }

    public final int h(int i2) {
        int a2 = this.f2768b[0].a(i2);
        for (int i3 = 1; i3 < this.f2767a; i3++) {
            int a3 = this.f2768b[i3].a(i2);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0157, code lost:
    
        if (c() != false) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.z r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean):void");
    }

    public final boolean j(int i2) {
        if (this.f2771e == 0) {
            return (i2 == -1) != this.f2775i;
        }
        return ((i2 == -1) == this.f2775i) == isLayoutRTL();
    }

    public final boolean a(RecyclerView.z zVar, b bVar) {
        int d2;
        if (this.o) {
            d2 = e(zVar.a());
        } else {
            d2 = d(zVar.a());
        }
        bVar.f2792a = d2;
        bVar.f2793b = Integer.MIN_VALUE;
        return true;
    }

    public final void a(View view, c cVar, boolean z) {
        if (cVar.f2800f) {
            if (this.f2771e == 1) {
                measureChildWithDecorationsAndMargin(view, this.r, RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
                return;
            } else {
                measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.r, z);
                return;
            }
        }
        if (this.f2771e == 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(this.f2772f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
        } else {
            measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.getChildMeasureSpec(this.f2772f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z);
        }
    }

    public final int b(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    public View b(boolean z) {
        int f2 = this.f2769c.f();
        int b2 = this.f2769c.b();
        int childCount = getChildCount();
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int d2 = this.f2769c.d(childAt);
            if (this.f2769c.a(childAt) > f2 && d2 < b2) {
                if (d2 >= f2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void b(RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int f2;
        int i2 = i(Integer.MAX_VALUE);
        if (i2 != Integer.MAX_VALUE && (f2 = i2 - this.f2769c.f()) > 0) {
            int scrollBy = f2 - scrollBy(f2, vVar, zVar);
            if (!z || scrollBy <= 0) {
                return;
            }
            this.f2769c.a(-scrollBy);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(int r5, androidx.recyclerview.widget.RecyclerView.z r6) {
        /*
            r4 = this;
            a.p.a.g r0 = r4.f2773g
            r1 = 0
            r0.f1670b = r1
            r0.f1671c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.b()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.f2775i
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            a.p.a.k r5 = r4.f2769c
            int r5 = r5.g()
            goto L2f
        L25:
            a.p.a.k r5 = r4.f2769c
            int r5 = r5.g()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L4d
            a.p.a.g r0 = r4.f2773g
            a.p.a.k r3 = r4.f2769c
            int r3 = r3.f()
            int r3 = r3 - r6
            r0.f1674f = r3
            a.p.a.g r6 = r4.f2773g
            a.p.a.k r0 = r4.f2769c
            int r0 = r0.b()
            int r0 = r0 + r5
            r6.f1675g = r0
            goto L5d
        L4d:
            a.p.a.g r0 = r4.f2773g
            a.p.a.k r3 = r4.f2769c
            int r3 = r3.a()
            int r3 = r3 + r5
            r0.f1675g = r3
            a.p.a.g r5 = r4.f2773g
            int r6 = -r6
            r5.f1674f = r6
        L5d:
            a.p.a.g r5 = r4.f2773g
            r5.f1676h = r1
            r5.f1669a = r2
            a.p.a.k r6 = r4.f2769c
            int r6 = r6.d()
            if (r6 != 0) goto L74
            a.p.a.k r6 = r4.f2769c
            int r6 = r6.a()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.f1677i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$z):void");
    }

    public View a(boolean z) {
        int f2 = this.f2769c.f();
        int b2 = this.f2769c.b();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int d2 = this.f2769c.d(childAt);
            int a2 = this.f2769c.a(childAt);
            if (a2 > f2 && d2 < b2) {
                if (a2 <= b2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final LazySpanLookup.FullSpanItem b(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f2780c = new int[this.f2767a];
        for (int i3 = 0; i3 < this.f2767a; i3++) {
            fullSpanItem.f2780c[i3] = i2 - this.f2768b[i3].a(i2);
        }
        return fullSpanItem;
    }

    public final void b(View view) {
        for (int i2 = this.f2767a - 1; i2 >= 0; i2--) {
            this.f2768b[i2].c(view);
        }
    }

    public final void a(RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int b2;
        int f2 = f(Integer.MIN_VALUE);
        if (f2 != Integer.MIN_VALUE && (b2 = this.f2769c.b() - f2) > 0) {
            int i2 = b2 - (-scrollBy(-b2, vVar, zVar));
            if (!z || i2 <= 0) {
                return;
            }
            this.f2769c.a(i2);
        }
    }

    public boolean b() {
        int b2 = this.f2768b[0].b(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f2767a; i2++) {
            if (this.f2768b[i2].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f2775i
            if (r0 == 0) goto L9
            int r0 = r6.g()
            goto Ld
        L9:
            int r0 = r6.f()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.m
            r4.e(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.m
            r9.b(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.m
            r7.a(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.m
            r9.b(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.m
            r9.a(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.f2775i
            if (r7 == 0) goto L4d
            int r7 = r6.f()
            goto L51
        L4d:
            int r7 = r6.g()
        L51:
            if (r3 > r7) goto L56
            r6.requestLayout()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int, int, int):void");
    }

    public final void b(RecyclerView.v vVar, int i2) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f2769c.a(childAt) > i2 || this.f2769c.e(childAt) > i2) {
                return;
            }
            c cVar = (c) childAt.getLayoutParams();
            if (cVar.f2800f) {
                for (int i3 = 0; i3 < this.f2767a; i3++) {
                    if (this.f2768b[i3].f2801a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.f2767a; i4++) {
                    this.f2768b[i4].k();
                }
            } else if (cVar.f2799e.f2801a.size() == 1) {
                return;
            } else {
                cVar.f2799e.k();
            }
            removeAndRecycleView(childAt, vVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final int a(RecyclerView.v vVar, g gVar, RecyclerView.z zVar) {
        int i2;
        int i3;
        int f2;
        int f3;
        d dVar;
        int b2;
        int i4;
        int i5;
        int b3;
        boolean b4;
        ?? r9 = 0;
        this.j.set(0, this.f2767a, true);
        if (this.f2773g.f1677i) {
            i3 = gVar.f1673e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (gVar.f1673e == 1) {
                i2 = gVar.f1675g + gVar.f1670b;
            } else {
                i2 = gVar.f1674f - gVar.f1670b;
            }
            i3 = i2;
        }
        a(gVar.f1673e, i3);
        if (this.f2775i) {
            f2 = this.f2769c.b();
        } else {
            f2 = this.f2769c.f();
        }
        int i6 = f2;
        boolean z = false;
        while (gVar.a(zVar) && (this.f2773g.f1677i || !this.j.isEmpty())) {
            View a2 = gVar.a(vVar);
            c cVar = (c) a2.getLayoutParams();
            int a3 = cVar.a();
            int d2 = this.m.d(a3);
            boolean z2 = d2 == -1;
            if (z2) {
                dVar = cVar.f2800f ? this.f2768b[r9] : a(gVar);
                this.m.a(a3, dVar);
            } else {
                dVar = this.f2768b[d2];
            }
            d dVar2 = dVar;
            cVar.f2799e = dVar2;
            if (gVar.f1673e == 1) {
                addView(a2);
            } else {
                addView(a2, r9);
            }
            a(a2, cVar, (boolean) r9);
            if (gVar.f1673e == 1) {
                int f4 = cVar.f2800f ? f(i6) : dVar2.a(i6);
                int b5 = this.f2769c.b(a2) + f4;
                if (z2 && cVar.f2800f) {
                    LazySpanLookup.FullSpanItem b6 = b(f4);
                    b6.f2779b = -1;
                    b6.f2778a = a3;
                    this.m.a(b6);
                }
                i4 = b5;
                b2 = f4;
            } else {
                int i7 = cVar.f2800f ? i(i6) : dVar2.b(i6);
                b2 = i7 - this.f2769c.b(a2);
                if (z2 && cVar.f2800f) {
                    LazySpanLookup.FullSpanItem c2 = c(i7);
                    c2.f2779b = 1;
                    c2.f2778a = a3;
                    this.m.a(c2);
                }
                i4 = i7;
            }
            if (cVar.f2800f && gVar.f1672d == -1) {
                if (z2) {
                    this.u = true;
                } else {
                    if (gVar.f1673e == 1) {
                        b4 = a();
                    } else {
                        b4 = b();
                    }
                    if (!b4) {
                        LazySpanLookup.FullSpanItem c3 = this.m.c(a3);
                        if (c3 != null) {
                            c3.f2781d = true;
                        }
                        this.u = true;
                    }
                }
            }
            a(a2, cVar, gVar);
            if (isLayoutRTL() && this.f2771e == 1) {
                int b7 = cVar.f2800f ? this.f2770d.b() : this.f2770d.b() - (((this.f2767a - 1) - dVar2.f2805e) * this.f2772f);
                b3 = b7;
                i5 = b7 - this.f2770d.b(a2);
            } else {
                int f5 = cVar.f2800f ? this.f2770d.f() : (dVar2.f2805e * this.f2772f) + this.f2770d.f();
                i5 = f5;
                b3 = this.f2770d.b(a2) + f5;
            }
            if (this.f2771e == 1) {
                layoutDecoratedWithMargins(a2, i5, b2, b3, i4);
            } else {
                layoutDecoratedWithMargins(a2, b2, i5, i4, b3);
            }
            if (cVar.f2800f) {
                a(this.f2773g.f1673e, i3);
            } else {
                a(dVar2, this.f2773g.f1673e, i3);
            }
            a(vVar, this.f2773g);
            if (this.f2773g.f1676h && a2.hasFocusable()) {
                if (cVar.f2800f) {
                    this.j.clear();
                } else {
                    this.j.set(dVar2.f2805e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            a(vVar, this.f2773g);
        }
        if (this.f2773g.f1673e == -1) {
            f3 = this.f2769c.f() - i(this.f2769c.f());
        } else {
            f3 = f(this.f2769c.b()) - this.f2769c.b();
        }
        if (f3 > 0) {
            return Math.min(gVar.f1670b, f3);
        }
        return 0;
    }

    public void c(RecyclerView.z zVar, b bVar) {
        if (b(zVar, bVar) || a(zVar, bVar)) {
            return;
        }
        bVar.a();
        bVar.f2792a = 0;
    }

    public final LazySpanLookup.FullSpanItem c(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f2780c = new int[this.f2767a];
        for (int i3 = 0; i3 < this.f2767a; i3++) {
            fullSpanItem.f2780c[i3] = this.f2768b[i3].b(i2) - i2;
        }
        return fullSpanItem;
    }

    public final void a(View view, c cVar, g gVar) {
        if (gVar.f1673e == 1) {
            if (cVar.f2800f) {
                a(view);
                return;
            } else {
                cVar.f2799e.a(view);
                return;
            }
        }
        if (cVar.f2800f) {
            b(view);
        } else {
            cVar.f2799e.c(view);
        }
    }

    public final void a(RecyclerView.v vVar, g gVar) {
        int min;
        int min2;
        if (!gVar.f1669a || gVar.f1677i) {
            return;
        }
        if (gVar.f1670b == 0) {
            if (gVar.f1673e == -1) {
                a(vVar, gVar.f1675g);
                return;
            } else {
                b(vVar, gVar.f1674f);
                return;
            }
        }
        if (gVar.f1673e == -1) {
            int i2 = gVar.f1674f;
            int g2 = i2 - g(i2);
            if (g2 < 0) {
                min2 = gVar.f1675g;
            } else {
                min2 = gVar.f1675g - Math.min(g2, gVar.f1670b);
            }
            a(vVar, min2);
            return;
        }
        int h2 = h(gVar.f1675g) - gVar.f1675g;
        if (h2 < 0) {
            min = gVar.f1674f;
        } else {
            min = Math.min(h2, gVar.f1670b) + gVar.f1674f;
        }
        b(vVar, min);
    }

    public final void a(View view) {
        for (int i2 = this.f2767a - 1; i2 >= 0; i2--) {
            this.f2768b[i2].a(view);
        }
    }

    public final void a(int i2, int i3) {
        for (int i4 = 0; i4 < this.f2767a; i4++) {
            if (!this.f2768b[i4].f2801a.isEmpty()) {
                a(this.f2768b[i4], i2, i3);
            }
        }
    }

    public final void a(d dVar, int i2, int i3) {
        int f2 = dVar.f();
        if (i2 == -1) {
            if (dVar.h() + f2 <= i3) {
                this.j.set(dVar.f2805e, false);
            }
        } else if (dVar.g() - f2 >= i3) {
            this.j.set(dVar.f2805e, false);
        }
    }

    public boolean a() {
        int a2 = this.f2768b[0].a(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f2767a; i2++) {
            if (this.f2768b[i2].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    public final void a(RecyclerView.v vVar, int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f2769c.d(childAt) < i2 || this.f2769c.f(childAt) < i2) {
                return;
            }
            c cVar = (c) childAt.getLayoutParams();
            if (cVar.f2800f) {
                for (int i3 = 0; i3 < this.f2767a; i3++) {
                    if (this.f2768b[i3].f2801a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.f2767a; i4++) {
                    this.f2768b[i4].j();
                }
            } else if (cVar.f2799e.f2801a.size() == 1) {
                return;
            } else {
                cVar.f2799e.j();
            }
            removeAndRecycleView(childAt, vVar);
        }
    }

    public final d a(g gVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (j(gVar.f1673e)) {
            i2 = this.f2767a - 1;
            i3 = -1;
        } else {
            i2 = 0;
            i4 = this.f2767a;
            i3 = 1;
        }
        d dVar = null;
        if (gVar.f1673e == 1) {
            int i5 = Integer.MAX_VALUE;
            int f2 = this.f2769c.f();
            while (i2 != i4) {
                d dVar2 = this.f2768b[i2];
                int a2 = dVar2.a(f2);
                if (a2 < i5) {
                    dVar = dVar2;
                    i5 = a2;
                }
                i2 += i3;
            }
            return dVar;
        }
        int i6 = Integer.MIN_VALUE;
        int b2 = this.f2769c.b();
        while (i2 != i4) {
            d dVar3 = this.f2768b[i2];
            int b3 = dVar3.b(b2);
            if (b3 > i6) {
                dVar = dVar3;
                i6 = b3;
            }
            i2 += i3;
        }
        return dVar;
    }

    public final int a(int i2) {
        if (getChildCount() == 0) {
            return this.f2775i ? 1 : -1;
        }
        return (i2 < f()) != this.f2775i ? -1 : 1;
    }

    public void a(int i2, RecyclerView.z zVar) {
        int f2;
        int i3;
        if (i2 > 0) {
            f2 = g();
            i3 = 1;
        } else {
            f2 = f();
            i3 = -1;
        }
        this.f2773g.f1669a = true;
        b(f2, zVar);
        k(i3);
        g gVar = this.f2773g;
        gVar.f1671c = f2 + gVar.f1672d;
        gVar.f1670b = Math.abs(i2);
    }
}
