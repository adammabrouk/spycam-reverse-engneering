package c.c.a.b.c.n;

import android.net.Uri;
import c.c.a.b.c.o.q;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f3913a;

    public b(Uri uri) {
        this.f3913a = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return q.a(((b) obj).f3913a, this.f3913a);
    }

    public final int hashCode() {
        return q.a(this.f3913a);
    }
}
