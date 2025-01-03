package a.b.f;

import android.os.Build;
import android.view.View;

/* compiled from: TooltipCompat.java */
/* loaded from: classes.dex */
public class i0 {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            j0.a(view, charSequence);
        }
    }
}
