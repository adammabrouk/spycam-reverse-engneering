package c.j.a.t;

/* compiled from: ConfigItem.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public String f6654a;

    /* renamed from: b, reason: collision with root package name */
    public String f6655b;

    public d(String str, String str2) {
        this.f6654a = str;
        this.f6655b = str2;
    }

    public final String a() {
        return this.f6654a;
    }

    public final String b() {
        return this.f6655b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f6654a;
        if (str == null) {
            if (dVar.f6654a != null) {
                return false;
            }
        } else if (!str.equals(dVar.f6654a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f6654a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f6654a + "', mValue='" + this.f6655b + "'}";
    }
}
