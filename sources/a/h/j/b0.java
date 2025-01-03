package a.h.j;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ViewParentCompat.java */
/* loaded from: classes.dex */
public final class b0 {
    @Deprecated
    public static boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean b(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof o) {
            return ((o) viewParent).b(view, view2, i2, i3);
        }
        if (i3 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21) {
            if (viewParent instanceof q) {
                return ((q) viewParent).onStartNestedScroll(view, view2, i2);
            }
            return false;
        }
        try {
            return viewParent.onStartNestedScroll(view, view2, i2);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e2);
            return false;
        }
    }

    public static void a(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof o) {
            ((o) viewParent).a(view, view2, i2, i3);
            return;
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof q) {
                    ((q) viewParent).onNestedScrollAccepted(view, view2, i2);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedScrollAccepted(view, view2, i2);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e2);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof o) {
            ((o) viewParent).a(view, i2);
            return;
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e2);
                    return;
                }
            }
            if (viewParent instanceof q) {
                ((q) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (viewParent instanceof p) {
            ((p) viewParent).a(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent instanceof o) {
            ((o) viewParent).a(view, i2, i3, i4, i5, i6);
            return;
        }
        if (i6 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i2, i3, i4, i5);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e2);
                    return;
                }
            }
            if (viewParent instanceof q) {
                ((q) viewParent).onNestedScroll(view, i2, i3, i4, i5);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof o) {
            ((o) viewParent).a(view, i2, i3, iArr, i4);
            return;
        }
        if (i4 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i2, i3, iArr);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
                    return;
                }
            }
            if (viewParent instanceof q) {
                ((q) viewParent).onNestedPreScroll(view, i2, i3, iArr);
            }
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
                return false;
            }
        }
        if (viewParent instanceof q) {
            return ((q) viewParent).onNestedFling(view, f2, f3, z);
        }
        return false;
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
                return false;
            }
        }
        if (viewParent instanceof q) {
            return ((q) viewParent).onNestedPreFling(view, f2, f3);
        }
        return false;
    }
}
