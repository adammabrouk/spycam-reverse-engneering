package a.h.j;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public int f1202a;

    /* renamed from: b, reason: collision with root package name */
    public int f1203b;

    public r(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i2) {
        a(view, view2, i2, 0);
    }

    public void a(View view, View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f1203b = i2;
        } else {
            this.f1202a = i2;
        }
    }

    public int a() {
        return this.f1202a | this.f1203b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i2) {
        if (i2 == 1) {
            this.f1203b = 0;
        } else {
            this.f1202a = 0;
        }
    }
}
