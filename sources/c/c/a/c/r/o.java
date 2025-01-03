package c.c.a.c.r;

import android.annotation.SuppressLint;
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
public class o implements q {

    /* renamed from: a, reason: collision with root package name */
    public a f5587a;

    public o(Context context, ViewGroup viewGroup, View view) {
        this.f5587a = new a(context, viewGroup, view, this);
    }

    public static o a(View view) {
        ViewGroup a2 = r.a(view);
        if (a2 == null) {
            return null;
        }
        int childCount = a2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = a2.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f5591d;
            }
        }
        return new m(a2.getContext(), a2, view);
    }

    @Override // c.c.a.c.r.q
    public void b(Drawable drawable) {
        this.f5587a.b(drawable);
    }

    /* compiled from: ViewOverlayApi14.java */
    @SuppressLint({"ViewConstructor", "PrivateApi"})
    public static class a extends ViewGroup {

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup f5588a;

        /* renamed from: b, reason: collision with root package name */
        public View f5589b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<Drawable> f5590c;

        /* renamed from: d, reason: collision with root package name */
        public o f5591d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f5592e;

        static {
            try {
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public a(Context context, ViewGroup viewGroup, View view, o oVar) {
            super(context);
            this.f5590c = null;
            this.f5588a = viewGroup;
            this.f5589b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f5591d = oVar;
        }

        public void a(Drawable drawable) {
            a();
            if (this.f5590c == null) {
                this.f5590c = new ArrayList<>();
            }
            if (this.f5590c.contains(drawable)) {
                return;
            }
            this.f5590c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f5590c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                b();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            this.f5588a.getLocationOnScreen(new int[2]);
            this.f5589b.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f5589b.getWidth(), this.f5589b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f5590c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f5590c.get(i2).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f5588a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f5588a == null) {
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
            return super.verifyDrawable(drawable) || ((arrayList = this.f5590c) != null && arrayList.contains(drawable));
        }

        public final void b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f5590c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f5592e = true;
                    this.f5588a.removeView(this);
                }
            }
        }

        public final void a() {
            if (this.f5592e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        public final void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f5588a.getLocationOnScreen(iArr2);
            this.f5589b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }
    }

    @Override // c.c.a.c.r.q
    public void a(Drawable drawable) {
        this.f5587a.a(drawable);
    }
}
