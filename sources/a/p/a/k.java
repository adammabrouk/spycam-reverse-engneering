package a.p.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f1682a;

    /* renamed from: b, reason: collision with root package name */
    public int f1683b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f1684c;

    /* compiled from: OrientationHelper.java */
    public static class a extends k {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // a.p.a.k
        public int a() {
            return this.f1682a.getWidth();
        }

        @Override // a.p.a.k
        public int b() {
            return this.f1682a.getWidth() - this.f1682a.getPaddingRight();
        }

        @Override // a.p.a.k
        public int c(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1682a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // a.p.a.k
        public int d(View view) {
            return this.f1682a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // a.p.a.k
        public int e(View view) {
            this.f1682a.getTransformedBoundingBox(view, true, this.f1684c);
            return this.f1684c.right;
        }

        @Override // a.p.a.k
        public int f() {
            return this.f1682a.getPaddingLeft();
        }

        @Override // a.p.a.k
        public int g() {
            return (this.f1682a.getWidth() - this.f1682a.getPaddingLeft()) - this.f1682a.getPaddingRight();
        }

        @Override // a.p.a.k
        public void a(int i2) {
            this.f1682a.offsetChildrenHorizontal(i2);
        }

        @Override // a.p.a.k
        public int b(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1682a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // a.p.a.k
        public int f(View view) {
            this.f1682a.getTransformedBoundingBox(view, true, this.f1684c);
            return this.f1684c.left;
        }

        @Override // a.p.a.k
        public int a(View view) {
            return this.f1682a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // a.p.a.k
        public int c() {
            return this.f1682a.getPaddingRight();
        }

        @Override // a.p.a.k
        public int d() {
            return this.f1682a.getWidthMode();
        }

        @Override // a.p.a.k
        public int e() {
            return this.f1682a.getHeightMode();
        }
    }

    /* compiled from: OrientationHelper.java */
    public static class b extends k {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // a.p.a.k
        public int a() {
            return this.f1682a.getHeight();
        }

        @Override // a.p.a.k
        public int b() {
            return this.f1682a.getHeight() - this.f1682a.getPaddingBottom();
        }

        @Override // a.p.a.k
        public int c(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1682a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // a.p.a.k
        public int d(View view) {
            return this.f1682a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // a.p.a.k
        public int e(View view) {
            this.f1682a.getTransformedBoundingBox(view, true, this.f1684c);
            return this.f1684c.bottom;
        }

        @Override // a.p.a.k
        public int f() {
            return this.f1682a.getPaddingTop();
        }

        @Override // a.p.a.k
        public int g() {
            return (this.f1682a.getHeight() - this.f1682a.getPaddingTop()) - this.f1682a.getPaddingBottom();
        }

        @Override // a.p.a.k
        public void a(int i2) {
            this.f1682a.offsetChildrenVertical(i2);
        }

        @Override // a.p.a.k
        public int b(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1682a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // a.p.a.k
        public int f(View view) {
            this.f1682a.getTransformedBoundingBox(view, true, this.f1684c);
            return this.f1684c.top;
        }

        @Override // a.p.a.k
        public int a(View view) {
            return this.f1682a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // a.p.a.k
        public int c() {
            return this.f1682a.getPaddingBottom();
        }

        @Override // a.p.a.k
        public int d() {
            return this.f1682a.getHeightMode();
        }

        @Override // a.p.a.k
        public int e() {
            return this.f1682a.getWidthMode();
        }
    }

    public /* synthetic */ k(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static k a(RecyclerView.o oVar, int i2) {
        if (i2 == 0) {
            return a(oVar);
        }
        if (i2 == 1) {
            return b(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static k b(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i2);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.f1683b) {
            return 0;
        }
        return g() - this.f1683b;
    }

    public void i() {
        this.f1683b = g();
    }

    public k(RecyclerView.o oVar) {
        this.f1683b = Integer.MIN_VALUE;
        this.f1684c = new Rect();
        this.f1682a = oVar;
    }

    public static k a(RecyclerView.o oVar) {
        return new a(oVar);
    }
}
