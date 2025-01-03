package a.b.e.j;

import a.b.e.j.m;
import a.h.j.y;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;

/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final Context f392a;

    /* renamed from: b, reason: collision with root package name */
    public final g f393b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f394c;

    /* renamed from: d, reason: collision with root package name */
    public final int f395d;

    /* renamed from: e, reason: collision with root package name */
    public final int f396e;

    /* renamed from: f, reason: collision with root package name */
    public View f397f;

    /* renamed from: g, reason: collision with root package name */
    public int f398g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f399h;

    /* renamed from: i, reason: collision with root package name */
    public m.a f400i;
    public k j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l;

    /* compiled from: MenuPopupHelper.java */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2) {
        this(context, gVar, view, z, i2, 0);
    }

    public void a(View view) {
        this.f397f = view;
    }

    public void b() {
        if (d()) {
            this.j.dismiss();
        }
    }

    public k c() {
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    public boolean d() {
        k kVar = this.j;
        return kVar != null && kVar.a();
    }

    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f() {
        if (!g()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean g() {
        if (d()) {
            return true;
        }
        if (this.f397f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.f398g = 8388611;
        this.l = new a();
        this.f392a = context;
        this.f393b = gVar;
        this.f397f = view;
        this.f394c = z;
        this.f395d = i2;
        this.f396e = i3;
    }

    public void a(boolean z) {
        this.f399h = z;
        k kVar = this.j;
        if (kVar != null) {
            kVar.b(z);
        }
    }

    public void a(int i2) {
        this.f398g = i2;
    }

    public boolean a(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f397f == null) {
            return false;
        }
        a(i2, i3, true, true);
        return true;
    }

    public final k a() {
        k qVar;
        Display defaultDisplay = ((WindowManager) this.f392a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f392a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width)) {
            qVar = new d(this.f392a, this.f397f, this.f395d, this.f396e, this.f394c);
        } else {
            qVar = new q(this.f392a, this.f393b, this.f397f, this.f395d, this.f396e, this.f394c);
        }
        qVar.a(this.f393b);
        qVar.setOnDismissListener(this.l);
        qVar.a(this.f397f);
        qVar.a(this.f400i);
        qVar.b(this.f399h);
        qVar.a(this.f398g);
        return qVar;
    }

    public final void a(int i2, int i3, boolean z, boolean z2) {
        k c2 = c();
        c2.c(z2);
        if (z) {
            if ((a.h.j.e.a(this.f398g, y.q(this.f397f)) & 7) == 5) {
                i2 -= this.f397f.getWidth();
            }
            c2.b(i2);
            c2.c(i3);
            int i4 = (int) ((this.f392a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c2.a(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        c2.d();
    }

    public void a(m.a aVar) {
        this.f400i = aVar;
        k kVar = this.j;
        if (kVar != null) {
            kVar.a(aVar);
        }
    }
}
