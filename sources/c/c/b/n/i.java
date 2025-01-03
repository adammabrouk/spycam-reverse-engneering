package c.c.b.n;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class i extends c.c.b.d {
    public final a status;

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public enum a {
        BAD_CONFIG
    }

    public i(a aVar) {
        this.status = aVar;
    }

    public a getStatus() {
        return this.status;
    }

    public i(String str, a aVar) {
        super(str);
        this.status = aVar;
    }

    public i(String str, a aVar, Throwable th) {
        super(str, th);
        this.status = aVar;
    }
}
