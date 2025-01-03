package a.a.e.d;

import a.a.e.d.a;
import android.content.Context;
import android.content.Intent;

/* compiled from: ActivityResultContracts.java */
/* loaded from: classes.dex */
public final class c extends a<String, Boolean> {
    @Override // a.a.e.d.a
    public a.C0000a<Boolean> b(Context context, String str) {
        if (str == null) {
            return new a.C0000a<>(false);
        }
        if (a.h.b.a.a(context, str) == 0) {
            return new a.C0000a<>(true);
        }
        return null;
    }

    @Override // a.a.e.d.a
    public Intent a(Context context, String str) {
        return b.a(new String[]{str});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // a.a.e.d.a
    public Boolean a(int i2, Intent intent) {
        int[] intArrayExtra;
        if (intent == null || i2 != -1 || (intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS")) == null || intArrayExtra.length == 0) {
            return false;
        }
        return Boolean.valueOf(intArrayExtra[0] == 0);
    }
}
