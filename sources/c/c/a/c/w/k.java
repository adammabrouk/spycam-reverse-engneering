package c.c.a.c.w;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: RelativeCornerSize.java */
/* loaded from: classes.dex */
public final class k implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f5671a;

    public k(float f2) {
        this.f5671a = f2;
    }

    @Override // c.c.a.c.w.c
    public float a(RectF rectF) {
        return this.f5671a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.f5671a == ((k) obj).f5671a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5671a)});
    }
}
