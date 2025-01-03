package c.c.a.a;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f3468a;

    public b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f3468a = str;
    }

    public static b a(String str) {
        return new b(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f3468a.equals(((b) obj).f3468a);
        }
        return false;
    }

    public int hashCode() {
        return this.f3468a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f3468a + "\"}";
    }

    public String a() {
        return this.f3468a;
    }
}
