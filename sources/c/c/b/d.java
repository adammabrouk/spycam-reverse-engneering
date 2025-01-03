package c.c.b;

import c.c.a.b.c.o.r;

/* loaded from: classes.dex */
public class d extends Exception {
    @Deprecated
    public d() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str) {
        super(str);
        r.a(str, (Object) "Detail message must not be empty");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, Throwable th) {
        super(str, th);
        r.a(str, (Object) "Detail message must not be empty");
    }
}
