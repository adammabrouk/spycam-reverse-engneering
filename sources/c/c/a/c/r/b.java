package c.c.a.c.r;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* compiled from: ContextUtils.java */
/* loaded from: classes.dex */
public class b {
    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
