package c.c.a.c.w;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AdjustedCornerSize.java */
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f5645a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5646b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f5645a;
            f2 += ((b) cVar).f5646b;
        }
        this.f5645a = cVar;
        this.f5646b = f2;
    }

    @Override // c.c.a.c.w.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f5645a.a(rectF) + this.f5646b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5645a.equals(bVar.f5645a) && this.f5646b == bVar.f5646b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5645a, Float.valueOf(this.f5646b)});
    }
}
