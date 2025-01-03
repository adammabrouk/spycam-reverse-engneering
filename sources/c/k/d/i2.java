package c.k.d;

import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class i2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h2 f7237a;

    public i2(h2 h2Var) {
        this.f7237a = h2Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        String str;
        String str2;
        list = h2.f7212g;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (b.d()) {
                this.f7237a.m191a();
            } else {
                str2 = this.f7237a.f7213a;
                Log.w(str2, "SDCard is unavailable.");
            }
        } catch (Exception e2) {
            str = this.f7237a.f7213a;
            Log.e(str, "", e2);
        }
    }
}
