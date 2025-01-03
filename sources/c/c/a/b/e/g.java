package c.c.a.b.e;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
public final class g implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0159b a(Context context, String str, DynamiteModule.b.a aVar) throws DynamiteModule.a {
        DynamiteModule.b.C0159b c0159b = new DynamiteModule.b.C0159b();
        int a2 = aVar.a(context, str);
        c0159b.f10181a = a2;
        if (a2 != 0) {
            c0159b.f10182b = aVar.a(context, str, false);
        } else {
            c0159b.f10182b = aVar.a(context, str, true);
        }
        if (c0159b.f10181a == 0 && c0159b.f10182b == 0) {
            c0159b.f10183c = 0;
        } else if (c0159b.f10182b >= c0159b.f10181a) {
            c0159b.f10183c = 1;
        } else {
            c0159b.f10183c = -1;
        }
        return c0159b;
    }
}
