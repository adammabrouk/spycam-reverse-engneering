package c.c.a.c.b;

import a.h.j.y;
import android.view.View;

/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final View f5347a;

    /* renamed from: b, reason: collision with root package name */
    public int f5348b;

    /* renamed from: c, reason: collision with root package name */
    public int f5349c;

    /* renamed from: d, reason: collision with root package name */
    public int f5350d;

    /* renamed from: e, reason: collision with root package name */
    public int f5351e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5352f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5353g = true;

    public d(View view) {
        this.f5347a = view;
    }

    public void a() {
        View view = this.f5347a;
        y.e(view, this.f5350d - (view.getTop() - this.f5348b));
        View view2 = this.f5347a;
        y.d(view2, this.f5351e - (view2.getLeft() - this.f5349c));
    }

    public boolean b(int i2) {
        if (!this.f5352f || this.f5350d == i2) {
            return false;
        }
        this.f5350d = i2;
        a();
        return true;
    }

    public int c() {
        return this.f5350d;
    }

    public void d() {
        this.f5348b = this.f5347a.getTop();
        this.f5349c = this.f5347a.getLeft();
    }

    public boolean a(int i2) {
        if (!this.f5353g || this.f5351e == i2) {
            return false;
        }
        this.f5351e = i2;
        a();
        return true;
    }

    public int b() {
        return this.f5348b;
    }
}
