package a.b.f;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.shix.shixipc.utilcode.NetworkUtils;

/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
public class j0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static j0 j;
    public static j0 k;

    /* renamed from: a, reason: collision with root package name */
    public final View f509a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f510b;

    /* renamed from: c, reason: collision with root package name */
    public final int f511c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f512d = new a();

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f513e = new b();

    /* renamed from: f, reason: collision with root package name */
    public int f514f;

    /* renamed from: g, reason: collision with root package name */
    public int f515g;

    /* renamed from: h, reason: collision with root package name */
    public k0 f516h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f517i;

    /* compiled from: TooltipCompatHandler.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.a(false);
        }
    }

    /* compiled from: TooltipCompatHandler.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.c();
        }
    }

    public j0(View view, CharSequence charSequence) {
        this.f509a = view;
        this.f510b = charSequence;
        this.f511c = a.h.j.z.a(ViewConfiguration.get(view.getContext()));
        b();
        this.f509a.setOnLongClickListener(this);
        this.f509a.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        j0 j0Var = j;
        if (j0Var != null && j0Var.f509a == view) {
            a((j0) null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new j0(view, charSequence);
            return;
        }
        j0 j0Var2 = k;
        if (j0Var2 != null && j0Var2.f509a == view) {
            j0Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f514f = Integer.MAX_VALUE;
        this.f515g = Integer.MAX_VALUE;
    }

    public void c() {
        if (k == this) {
            k = null;
            k0 k0Var = this.f516h;
            if (k0Var != null) {
                k0Var.a();
                this.f516h = null;
                b();
                this.f509a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((j0) null);
        }
        this.f509a.removeCallbacks(this.f513e);
    }

    public final void d() {
        this.f509a.postDelayed(this.f512d, ViewConfiguration.getLongPressTimeout());
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f516h != null && this.f517i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f509a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f509a.isEnabled() && this.f516h == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f514f = view.getWidth() / 2;
        this.f515g = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }

    public void a(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        if (a.h.j.y.I(this.f509a)) {
            a((j0) null);
            j0 j0Var = k;
            if (j0Var != null) {
                j0Var.c();
            }
            k = this;
            this.f517i = z;
            k0 k0Var = new k0(this.f509a.getContext());
            this.f516h = k0Var;
            k0Var.a(this.f509a, this.f514f, this.f515g, this.f517i, this.f510b);
            this.f509a.addOnAttachStateChangeListener(this);
            if (this.f517i) {
                j3 = 2500;
            } else {
                if ((a.h.j.y.C(this.f509a) & 1) == 1) {
                    j2 = NetworkUtils.SCAN_PERIOD_MILLIS;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.f509a.removeCallbacks(this.f513e);
            this.f509a.postDelayed(this.f513e, j3);
        }
    }

    public static void a(j0 j0Var) {
        j0 j0Var2 = j;
        if (j0Var2 != null) {
            j0Var2.a();
        }
        j = j0Var;
        if (j0Var != null) {
            j0Var.d();
        }
    }

    public final void a() {
        this.f509a.removeCallbacks(this.f512d);
    }

    public final boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f514f) <= this.f511c && Math.abs(y - this.f515g) <= this.f511c) {
            return false;
        }
        this.f514f = x;
        this.f515g = y;
        return true;
    }
}
