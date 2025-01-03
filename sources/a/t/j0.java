package a.t;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* compiled from: ViewOverlayApi14.java */
/* loaded from: classes.dex */
public class j0 implements l0 {

    /* renamed from: a, reason: collision with root package name */
    public a f1829a;

    public j0(Context context, ViewGroup viewGroup, View view) {
        this.f1829a = new a(context, viewGroup, view, this);
    }

    public static j0 c(View view) {
        ViewGroup d2 = d(view);
        if (d2 == null) {
            return null;
        }
        int childCount = d2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = d2.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f1833d;
            }
        }
        return new e0(d2.getContext(), d2, view);
    }

    public static ViewGroup d(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // a.t.l0
    public void a(Drawable drawable) {
        this.f1829a.a(drawable);
    }

    @Override // a.t.l0
    public void b(Drawable drawable) {
        this.f1829a.b(drawable);
    }

    /* compiled from: ViewOverlayApi14.java */
    public static class a extends ViewGroup {

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup f1830a;

        /* renamed from: b, reason: collision with root package name */
        public View f1831b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<Drawable> f1832c;

        /* renamed from: d, reason: collision with root package name */
        public j0 f1833d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1834e;

        static {
            try {
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public a(Context context, ViewGroup viewGroup, View view, j0 j0Var) {
            super(context);
            this.f1832c = null;
            this.f1830a = viewGroup;
            this.f1831b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f1833d = j0Var;
        }

        public void a(Drawable drawable) {
            a();
            if (this.f1832c == null) {
                this.f1832c = new ArrayList<>();
            }
            if (this.f1832c.contains(drawable)) {
                return;
            }
            this.f1832c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f1832c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                b();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            this.f1830a.getLocationOnScreen(new int[2]);
            this.f1831b.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f1831b.getWidth(), this.f1831b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f1832c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1832c.get(i2).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f1830a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (!(this.f1830a instanceof ViewGroup)) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            a(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f1832c) != null && arrayList.contains(drawable));
        }

        public void b(View view) {
            super.removeView(view);
            b();
        }

        public void a(View view) {
            a();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f1830a && viewGroup.getParent() != null && a.h.j.y.I(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f1830a.getLocationOnScreen(iArr2);
                    a.h.j.y.d(view, iArr[0] - iArr2[0]);
                    a.h.j.y.e(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public final void b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f1832c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f1834e = true;
                    this.f1830a.removeView(this);
                }
            }
        }

        public final void a() {
            if (this.f1834e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        public final void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f1830a.getLocationOnScreen(iArr2);
            this.f1831b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }
    }
}
