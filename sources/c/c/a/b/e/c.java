package c.c.a.b.e;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
public final class c implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0159b a(Context context, String str, DynamiteModule.b.a aVar) throws DynamiteModule.a {
        DynamiteModule.b.C0159b c0159b = new DynamiteModule.b.C0159b();
        int a2 = aVar.a(context, str);
        c0159b.f10181a = a2;
        if (a2 != 0) {
            c0159b.f10183c = -1;
        } else {
            int a3 = aVar.a(context, str, true);
            c0159b.f10182b = a3;
            if (a3 != 0) {
                c0159b.f10183c = 1;
            }
        }
        return c0159b;
    }
}
