package c.c.a.c.y;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.c.a.c.y.d;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public d.b f5731a;

    public a(SwipeDismissBehavior<?> swipeDismissBehavior) {
        swipeDismissBehavior.b(0.1f);
        swipeDismissBehavior.a(0.6f);
        swipeDismissBehavior.a(0);
    }

    public boolean a(View view) {
        return view instanceof BaseTransientBottomBar$SnackbarBaseLayout;
    }

    public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                d.a().b(this.f5731a);
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            d.a().c(this.f5731a);
        }
    }
}
