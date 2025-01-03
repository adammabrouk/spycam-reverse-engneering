package a.h.a;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

/* compiled from: ActivityOptionsCompat.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: ActivityOptionsCompat.java */
    public static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final ActivityOptions f856a;

        public a(ActivityOptions activityOptions) {
            this.f856a = activityOptions;
        }

        @Override // a.h.a.b
        public Bundle a() {
            return this.f856a.toBundle();
        }
    }

    public static b a(Context context, int i2, int i3) {
        return Build.VERSION.SDK_INT >= 16 ? new a(ActivityOptions.makeCustomAnimation(context, i2, i3)) : new b();
    }

    public Bundle a() {
        return null;
    }

    public static b a(Activity activity, a.h.i.d<View, String>... dVarArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            Pair[] pairArr = null;
            if (dVarArr != null) {
                pairArr = new Pair[dVarArr.length];
                for (int i2 = 0; i2 < dVarArr.length; i2++) {
                    pairArr[i2] = Pair.create(dVarArr[i2].f1104a, dVarArr[i2].f1105b);
                }
            }
            return new a(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr));
        }
        return new b();
    }
}
