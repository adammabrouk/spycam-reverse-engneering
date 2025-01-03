package com.google.android.material.behavior;

import a.h.j.h0.c;
import a.h.j.h0.f;
import a.h.j.y;
import a.j.a.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    public a.j.a.c f10308a;

    /* renamed from: b, reason: collision with root package name */
    public c f10309b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10310c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10312e;

    /* renamed from: d, reason: collision with root package name */
    public float f10311d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public int f10313f = 2;

    /* renamed from: g, reason: collision with root package name */
    public float f10314g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    public float f10315h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f10316i = 0.5f;
    public final c.AbstractC0037c j = new a();

    public class a extends c.AbstractC0037c {

        /* renamed from: a, reason: collision with root package name */
        public int f10317a;

        /* renamed from: b, reason: collision with root package name */
        public int f10318b = -1;

        public a() {
        }

        public final boolean a(View view, float f2) {
            if (f2 == 0.0f) {
                return Math.abs(view.getLeft() - this.f10317a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f10314g);
            }
            boolean z = y.q(view) == 1;
            int i2 = SwipeDismissBehavior.this.f10313f;
            if (i2 == 2) {
                return true;
            }
            if (i2 == 0) {
                if (z) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (f2 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            if (z) {
                if (f2 <= 0.0f) {
                    return false;
                }
            } else if (f2 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // a.j.a.c.AbstractC0037c
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            boolean z = y.q(view) == 1;
            int i4 = SwipeDismissBehavior.this.f10313f;
            if (i4 == 0) {
                if (z) {
                    width = this.f10317a - view.getWidth();
                    width2 = this.f10317a;
                } else {
                    width = this.f10317a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.f10317a - view.getWidth();
                width2 = view.getWidth() + this.f10317a;
            } else if (z) {
                width = this.f10317a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f10317a - view.getWidth();
                width2 = this.f10317a;
            }
            return SwipeDismissBehavior.a(width, i2, width2);
        }

        @Override // a.j.a.c.AbstractC0037c
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // a.j.a.c.AbstractC0037c
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewCaptured(View view, int i2) {
            this.f10318b = i2;
            this.f10317a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewDragStateChanged(int i2) {
            c cVar = SwipeDismissBehavior.this.f10309b;
            if (cVar != null) {
                cVar.a(i2);
            }
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            float width = this.f10317a + (view.getWidth() * SwipeDismissBehavior.this.f10315h);
            float width2 = this.f10317a + (view.getWidth() * SwipeDismissBehavior.this.f10316i);
            float f2 = i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
            }
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewReleased(View view, float f2, float f3) {
            int i2;
            boolean z;
            c cVar;
            this.f10318b = -1;
            int width = view.getWidth();
            if (a(view, f2)) {
                int left = view.getLeft();
                int i3 = this.f10317a;
                i2 = left < i3 ? i3 - width : i3 + width;
                z = true;
            } else {
                i2 = this.f10317a;
                z = false;
            }
            if (SwipeDismissBehavior.this.f10308a.e(i2, view.getTop())) {
                y.a(view, new d(view, z));
            } else {
                if (!z || (cVar = SwipeDismissBehavior.this.f10309b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // a.j.a.c.AbstractC0037c
        public boolean tryCaptureView(View view, int i2) {
            int i3 = this.f10318b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.a(view);
        }
    }

    public class b implements f {
        public b() {
        }

        @Override // a.h.j.h0.f
        public boolean a(View view, f.a aVar) {
            boolean z = false;
            if (!SwipeDismissBehavior.this.a(view)) {
                return false;
            }
            boolean z2 = y.q(view) == 1;
            if ((SwipeDismissBehavior.this.f10313f == 0 && z2) || (SwipeDismissBehavior.this.f10313f == 1 && !z2)) {
                z = true;
            }
            int width = view.getWidth();
            if (z) {
                width = -width;
            }
            y.d(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f10309b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(int i2);

        void a(View view);
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final View f10321a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10322b;

        public d(View view, boolean z) {
            this.f10321a = view;
            this.f10322b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            a.j.a.c cVar2 = SwipeDismissBehavior.this.f10308a;
            if (cVar2 != null && cVar2.a(true)) {
                y.a(this.f10321a, this);
            } else {
                if (!this.f10322b || (cVar = SwipeDismissBehavior.this.f10309b) == null) {
                    return;
                }
                cVar.a(this.f10321a);
            }
        }
    }

    public static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public void a(int i2) {
        this.f10313f = i2;
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f2) {
        this.f10315h = a(0.0f, f2, 1.0f);
    }

    public void setListener(c cVar) {
        this.f10309b = cVar;
    }

    public void a(float f2) {
        this.f10316i = a(0.0f, f2, 1.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        a.j.a.c cVar = this.f10308a;
        if (cVar == null) {
            return false;
        }
        cVar.a(motionEvent);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        boolean a2 = super.a(coordinatorLayout, (CoordinatorLayout) v, i2);
        if (y.o(v) == 0) {
            y.h(v, 1);
            b(v);
        }
        return a2;
    }

    public final void b(View view) {
        y.f(view, MemoryConstants.MB);
        if (a(view)) {
            y.a(view, c.a.l, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f10310c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f10310c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f10310c = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f10308a.c(motionEvent);
    }

    public final void a(ViewGroup viewGroup) {
        a.j.a.c a2;
        if (this.f10308a == null) {
            if (this.f10312e) {
                a2 = a.j.a.c.a(viewGroup, this.f10311d, this.j);
            } else {
                a2 = a.j.a.c.a(viewGroup, this.j);
            }
            this.f10308a = a2;
        }
    }

    public static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    public static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
