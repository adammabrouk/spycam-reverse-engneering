package cn.jiguang.bg;

import java.util.UUID;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f8750a = new e(new UUID(0, 0));

    /* renamed from: b, reason: collision with root package name */
    public final UUID f8751b;

    public e() {
        this(null);
    }

    public e(UUID uuid) {
        this.f8751b = uuid == null ? UUID.randomUUID() : uuid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && e.class == obj.getClass() && this.f8751b.compareTo(((e) obj).f8751b) == 0;
    }

    public int hashCode() {
        return this.f8751b.hashCode();
    }

    public String toString() {
        return this.f8751b.toString().replace("-", "");
    }
}
