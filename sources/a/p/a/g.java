package a.p.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public int f1670b;

    /* renamed from: c, reason: collision with root package name */
    public int f1671c;

    /* renamed from: d, reason: collision with root package name */
    public int f1672d;

    /* renamed from: e, reason: collision with root package name */
    public int f1673e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1676h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1677i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1669a = true;

    /* renamed from: f, reason: collision with root package name */
    public int f1674f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f1675g = 0;

    public boolean a(RecyclerView.z zVar) {
        int i2 = this.f1671c;
        return i2 >= 0 && i2 < zVar.a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1670b + ", mCurrentPosition=" + this.f1671c + ", mItemDirection=" + this.f1672d + ", mLayoutDirection=" + this.f1673e + ", mStartLine=" + this.f1674f + ", mEndLine=" + this.f1675g + '}';
    }

    public View a(RecyclerView.v vVar) {
        View d2 = vVar.d(this.f1671c);
        this.f1671c += this.f1672d;
        return d2;
    }
}
