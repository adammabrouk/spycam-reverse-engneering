package a.p.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
public class n {
    public static int a(RecyclerView.z zVar, k kVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.getChildCount() == 0 || zVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (zVar.a() - Math.max(oVar.getPosition(view), oVar.getPosition(view2))) - 1) : Math.max(0, Math.min(oVar.getPosition(view), oVar.getPosition(view2)));
        if (z) {
            return Math.round((max * (Math.abs(kVar.a(view2) - kVar.d(view)) / (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1))) + (kVar.f() - kVar.d(view)));
        }
        return max;
    }

    public static int b(RecyclerView.z zVar, k kVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.getChildCount() == 0 || zVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return zVar.a();
        }
        return (int) (((kVar.a(view2) - kVar.d(view)) / (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1)) * zVar.a());
    }

    public static int a(RecyclerView.z zVar, k kVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.getChildCount() == 0 || zVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1;
        }
        return Math.min(kVar.g(), kVar.a(view2) - kVar.d(view));
    }
}
