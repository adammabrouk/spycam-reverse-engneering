package a.a.e.d;

import a.a.e.d.a;
import android.content.Context;
import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ActivityResultContracts.java */
/* loaded from: classes.dex */
public final class b extends a<String[], Map<String, Boolean>> {
    @Override // a.a.e.d.a
    public a.C0000a<Map<String, Boolean>> b(Context context, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new a.C0000a<>(Collections.emptyMap());
        }
        a.e.a aVar = new a.e.a();
        boolean z = true;
        for (String str : strArr) {
            boolean z2 = a.h.b.a.a(context, str) == 0;
            aVar.put(str, Boolean.valueOf(z2));
            if (!z2) {
                z = false;
            }
        }
        if (z) {
            return new a.C0000a<>(aVar);
        }
        return null;
    }

    @Override // a.a.e.d.a
    public Intent a(Context context, String[] strArr) {
        return a(strArr);
    }

    @Override // a.a.e.d.a
    public Map<String, Boolean> a(int i2, Intent intent) {
        if (i2 != -1) {
            return Collections.emptyMap();
        }
        if (intent == null) {
            return Collections.emptyMap();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra != null && stringArrayExtra != null) {
            HashMap hashMap = new HashMap();
            int length = stringArrayExtra.length;
            for (int i3 = 0; i3 < length; i3++) {
                hashMap.put(stringArrayExtra[i3], Boolean.valueOf(intArrayExtra[i3] == 0));
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public static Intent a(String[] strArr) {
        return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
    }
}
