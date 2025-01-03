package c.c.a.c.w;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AbsoluteCornerSize.java */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f5644a;

    public a(float f2) {
        this.f5644a = f2;
    }

    @Override // c.c.a.c.w.c
    public float a(RectF rectF) {
        return this.f5644a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f5644a == ((a) obj).f5644a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5644a)});
    }
}
