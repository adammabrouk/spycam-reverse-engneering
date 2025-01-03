package a.h.c;

import android.graphics.Insets;
import android.graphics.Rect;

/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f974e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f975a;

    /* renamed from: b, reason: collision with root package name */
    public final int f976b;

    /* renamed from: c, reason: collision with root package name */
    public final int f977c;

    /* renamed from: d, reason: collision with root package name */
    public final int f978d;

    public b(int i2, int i3, int i4, int i5) {
        this.f975a = i2;
        this.f976b = i3;
        this.f977c = i4;
        this.f978d = i5;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f974e : new b(i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f978d == bVar.f978d && this.f975a == bVar.f975a && this.f977c == bVar.f977c && this.f976b == bVar.f976b;
    }

    public int hashCode() {
        return (((((this.f975a * 31) + this.f976b) * 31) + this.f977c) * 31) + this.f978d;
    }

    public String toString() {
        return "Insets{left=" + this.f975a + ", top=" + this.f976b + ", right=" + this.f977c + ", bottom=" + this.f978d + '}';
    }

    public static b a(Rect rect) {
        return a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b a(b bVar, b bVar2) {
        return a(Math.max(bVar.f975a, bVar2.f975a), Math.max(bVar.f976b, bVar2.f976b), Math.max(bVar.f977c, bVar2.f977c), Math.max(bVar.f978d, bVar2.f978d));
    }

    public static b a(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets a() {
        return Insets.of(this.f975a, this.f976b, this.f977c, this.f978d);
    }
}
