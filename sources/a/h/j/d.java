package a.h.j;

/* compiled from: DisplayCutoutCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1135a;

    public d(Object obj) {
        this.f1135a = obj;
    }

    public static d a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new d(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return a.h.i.c.a(this.f1135a, ((d) obj).f1135a);
    }

    public int hashCode() {
        Object obj = this.f1135a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f1135a + "}";
    }
}
