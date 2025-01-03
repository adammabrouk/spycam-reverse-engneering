package a.h.j.h0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f1167a;

    /* renamed from: b, reason: collision with root package name */
    public final c f1168b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1169c;

    public a(int i2, c cVar, int i3) {
        this.f1167a = i2;
        this.f1168b = cVar;
        this.f1169c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1167a);
        this.f1168b.a(this.f1169c, bundle);
    }
}
