package a.w;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewBindings.java */
/* loaded from: classes.dex */
public class a {
    public static <T extends View> T a(View view, int i2) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            T t = (T) viewGroup.getChildAt(i3).findViewById(i2);
            if (t != null) {
                return t;
            }
        }
        return null;
    }
}
