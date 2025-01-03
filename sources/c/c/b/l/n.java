package c.c.b.l;

import android.os.Bundle;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class n extends q<Void> {
    public n(int i2, int i3, Bundle bundle) {
        super(i2, 2, bundle);
    }

    @Override // c.c.b.l.q
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a((n) null);
        } else {
            a(new p(4, "Invalid response to one way request"));
        }
    }

    @Override // c.c.b.l.q
    public final boolean a() {
        return true;
    }
}
