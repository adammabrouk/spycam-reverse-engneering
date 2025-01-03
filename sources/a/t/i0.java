package a.t;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi14.java */
/* loaded from: classes.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static LayoutTransition f1824a;

    /* renamed from: b, reason: collision with root package name */
    public static Field f1825b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1826c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f1827d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f1828e;

    /* compiled from: ViewGroupUtilsApi14.java */
    public static class a extends LayoutTransition {
        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.view.ViewGroup r5, boolean r6) {
        /*
            android.animation.LayoutTransition r0 = a.t.i0.f1824a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L28
            a.t.i0$a r0 = new a.t.i0$a
            r0.<init>()
            a.t.i0.f1824a = r0
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = a.t.i0.f1824a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = a.t.i0.f1824a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = a.t.i0.f1824a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = a.t.i0.f1824a
            r4 = 4
            r0.setAnimator(r4, r3)
        L28:
            if (r6 == 0) goto L48
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L42
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L39
            a(r6)
        L39:
            android.animation.LayoutTransition r0 = a.t.i0.f1824a
            if (r6 == r0) goto L42
            int r0 = androidx.transition.R$id.transition_layout_save
            r5.setTag(r0, r6)
        L42:
            android.animation.LayoutTransition r6 = a.t.i0.f1824a
            r5.setLayoutTransition(r6)
            goto L96
        L48:
            r5.setLayoutTransition(r3)
            boolean r6 = a.t.i0.f1826c
            java.lang.String r0 = "ViewGroupUtilsApi14"
            if (r6 != 0) goto L66
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r4 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L5f
            a.t.i0.f1825b = r6     // Catch: java.lang.NoSuchFieldException -> L5f
            r6.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L5f
            goto L64
        L5f:
            java.lang.String r6 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r6)
        L64:
            a.t.i0.f1826c = r1
        L66:
            java.lang.reflect.Field r6 = a.t.i0.f1825b
            if (r6 == 0) goto L7f
            boolean r6 = r6.getBoolean(r5)     // Catch: java.lang.IllegalAccessException -> L7a
            if (r6 == 0) goto L78
            java.lang.reflect.Field r1 = a.t.i0.f1825b     // Catch: java.lang.IllegalAccessException -> L76
            r1.setBoolean(r5, r2)     // Catch: java.lang.IllegalAccessException -> L76
            goto L78
        L76:
            r2 = r6
            goto L7a
        L78:
            r2 = r6
            goto L7f
        L7a:
            java.lang.String r6 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r6)
        L7f:
            if (r2 == 0) goto L84
            r5.requestLayout()
        L84:
            int r6 = androidx.transition.R$id.transition_layout_save
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L96
            int r0 = androidx.transition.R$id.transition_layout_save
            r5.setTag(r0, r3)
            r5.setLayoutTransition(r6)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.t.i0.a(android.view.ViewGroup, boolean):void");
    }

    public static void a(LayoutTransition layoutTransition) {
        if (!f1828e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f1827d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f1828e = true;
        }
        Method method = f1827d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
