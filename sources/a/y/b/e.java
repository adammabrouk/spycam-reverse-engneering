package a.y.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: ScrollEventAdapter.java */
/* loaded from: classes.dex */
public final class e extends RecyclerView.t {

    /* renamed from: a, reason: collision with root package name */
    public ViewPager2.i f2003a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f2004b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f2005c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f2006d;

    /* renamed from: e, reason: collision with root package name */
    public int f2007e;

    /* renamed from: f, reason: collision with root package name */
    public int f2008f;

    /* renamed from: g, reason: collision with root package name */
    public a f2009g;

    /* renamed from: h, reason: collision with root package name */
    public int f2010h;

    /* renamed from: i, reason: collision with root package name */
    public int f2011i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* compiled from: ScrollEventAdapter.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f2012a;

        /* renamed from: b, reason: collision with root package name */
        public float f2013b;

        /* renamed from: c, reason: collision with root package name */
        public int f2014c;

        public void a() {
            this.f2012a = -1;
            this.f2013b = 0.0f;
            this.f2014c = 0;
        }
    }

    public e(ViewPager2 viewPager2) {
        this.f2004b = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.f2005c = recyclerView;
        this.f2006d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f2009g = new a();
        h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i2) {
        boolean z = true;
        if (!(this.f2007e == 1 && this.f2008f == 1) && i2 == 1) {
            a(false);
            return;
        }
        if (f() && i2 == 2) {
            if (this.k) {
                b(2);
                this.j = true;
                return;
            }
            return;
        }
        if (f() && i2 == 0) {
            i();
            if (this.k) {
                a aVar = this.f2009g;
                if (aVar.f2014c == 0) {
                    int i3 = this.f2010h;
                    int i4 = aVar.f2012a;
                    if (i3 != i4) {
                        a(i4);
                    }
                } else {
                    z = false;
                }
            } else {
                int i5 = this.f2009g.f2012a;
                if (i5 != -1) {
                    a(i5, 0.0f, 0);
                }
            }
            if (z) {
                b(0);
                h();
            }
        }
        if (this.f2007e == 2 && i2 == 0 && this.l) {
            i();
            a aVar2 = this.f2009g;
            if (aVar2.f2014c == 0) {
                int i6 = this.f2011i;
                int i7 = aVar2.f2012a;
                if (i6 != i7) {
                    if (i7 == -1) {
                        i7 = 0;
                    }
                    a(i7);
                }
                b(0);
                h();
            }
        }
    }

    public double b() {
        i();
        a aVar = this.f2009g;
        double d2 = aVar.f2012a;
        double d3 = aVar.f2013b;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 + d3;
    }

    public int c() {
        return this.f2008f;
    }

    public boolean d() {
        return this.m;
    }

    public boolean e() {
        return this.f2008f == 0;
    }

    public final boolean f() {
        int i2 = this.f2007e;
        return i2 == 1 || i2 == 4;
    }

    public void g() {
        this.l = true;
    }

    public final void h() {
        this.f2007e = 0;
        this.f2008f = 0;
        this.f2009g.a();
        this.f2010h = -1;
        this.f2011i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    public final void i() {
        int top;
        a aVar = this.f2009g;
        int findFirstVisibleItemPosition = this.f2006d.findFirstVisibleItemPosition();
        aVar.f2012a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            aVar.a();
            return;
        }
        View findViewByPosition = this.f2006d.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.f2006d.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f2006d.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f2006d.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f2006d.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f2006d.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f2005c.getPaddingLeft();
            if (this.f2004b.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.f2005c.getPaddingTop();
        }
        int i2 = -top;
        aVar.f2014c = i2;
        if (i2 >= 0) {
            aVar.f2013b = height == 0 ? 0.0f : i2 / height;
        } else {
            if (!new a.y.b.a(this.f2006d).c()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f2014c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    public final void b(int i2) {
        if ((this.f2007e == 3 && this.f2008f == 0) || this.f2008f == i2) {
            return;
        }
        this.f2008f = i2;
        ViewPager2.i iVar = this.f2003a;
        if (iVar != null) {
            iVar.a(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r5 < 0) == r3.f2004b.c()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.k = r4
            r3.i()
            boolean r0 = r3.j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3d
            r3.j = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f2004b
            boolean r6 = r6.c()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            a.y.b.e$a r5 = r3.f2009g
            int r6 = r5.f2014c
            if (r6 == 0) goto L2f
            int r5 = r5.f2012a
            int r5 = r5 + r4
            goto L33
        L2f:
            a.y.b.e$a r5 = r3.f2009g
            int r5 = r5.f2012a
        L33:
            r3.f2011i = r5
            int r6 = r3.f2010h
            if (r6 == r5) goto L4b
            r3.a(r5)
            goto L4b
        L3d:
            int r5 = r3.f2007e
            if (r5 != 0) goto L4b
            a.y.b.e$a r5 = r3.f2009g
            int r5 = r5.f2012a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.a(r5)
        L4b:
            a.y.b.e$a r5 = r3.f2009g
            int r5 = r5.f2012a
            if (r5 != r1) goto L52
            r5 = 0
        L52:
            a.y.b.e$a r6 = r3.f2009g
            float r0 = r6.f2013b
            int r6 = r6.f2014c
            r3.a(r5, r0, r6)
            a.y.b.e$a r5 = r3.f2009g
            int r5 = r5.f2012a
            int r6 = r3.f2011i
            if (r5 == r6) goto L65
            if (r6 != r1) goto L75
        L65:
            a.y.b.e$a r5 = r3.f2009g
            int r5 = r5.f2014c
            if (r5 != 0) goto L75
            int r5 = r3.f2008f
            if (r5 == r4) goto L75
            r3.b(r2)
            r3.h()
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.y.b.e.a(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void a(boolean z) {
        this.m = z;
        this.f2007e = z ? 4 : 1;
        int i2 = this.f2011i;
        if (i2 != -1) {
            this.f2010h = i2;
            this.f2011i = -1;
        } else if (this.f2010h == -1) {
            this.f2010h = a();
        }
        b(1);
    }

    public void a(int i2, boolean z) {
        this.f2007e = z ? 2 : 3;
        this.m = false;
        boolean z2 = this.f2011i != i2;
        this.f2011i = i2;
        b(2);
        if (z2) {
            a(i2);
        }
    }

    public void a(ViewPager2.i iVar) {
        this.f2003a = iVar;
    }

    public final void a(int i2) {
        ViewPager2.i iVar = this.f2003a;
        if (iVar != null) {
            iVar.b(i2);
        }
    }

    public final void a(int i2, float f2, int i3) {
        ViewPager2.i iVar = this.f2003a;
        if (iVar != null) {
            iVar.a(i2, f2, i3);
        }
    }

    public final int a() {
        return this.f2006d.findFirstVisibleItemPosition();
    }
}
