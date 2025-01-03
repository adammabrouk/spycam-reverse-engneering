package cn.jpush.android.f;

import android.annotation.TargetApi;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f9719a;

    /* renamed from: b, reason: collision with root package name */
    public long f9720b;

    public b(String str, long j) {
        this.f9719a = str;
        this.f9720b = j;
    }

    @TargetApi(19)
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f9720b == bVar.f9720b && Objects.equals(this.f9719a, bVar.f9719a)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(19)
    public final int hashCode() {
        return Objects.hash(this.f9719a, Long.valueOf(this.f9720b));
    }
}
