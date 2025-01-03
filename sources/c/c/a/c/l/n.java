package c.c.a.c.l;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SmoothCalendarLayoutManager.java */
/* loaded from: classes.dex */
public class n extends LinearLayoutManager {

    /* compiled from: SmoothCalendarLayoutManager.java */
    public class a extends a.p.a.h {
        public a(n nVar, Context context) {
            super(context);
        }

        @Override // a.p.a.h
        public float a(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public n(Context context, int i2, boolean z) {
        super(context, i2, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.z zVar, int i2) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.c(i2);
        startSmoothScroll(aVar);
    }
}
