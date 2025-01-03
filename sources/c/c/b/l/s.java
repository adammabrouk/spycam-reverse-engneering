package c.c.b.l;

import android.os.Bundle;
import cn.jpush.android.api.JThirdPlatFormInterface;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class s extends q<Bundle> {
    public s(int i2, int i3, Bundle bundle) {
        super(i2, 1, bundle);
    }

    @Override // c.c.b.l.q
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(JThirdPlatFormInterface.KEY_DATA);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        a((s) bundle2);
    }

    @Override // c.c.b.l.q
    public final boolean a() {
        return false;
    }
}
