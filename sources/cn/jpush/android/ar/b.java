package cn.jpush.android.ar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import cn.jpush.android.aw.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    public interface a {
        void a();
    }

    public static void a(Context context, View view, int i2, WindowManager windowManager) {
        if (view != null) {
            try {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = i2;
                cn.jpush.android.r.b.b("InAppAnimator", "setViewGroupHeigthStart:" + layoutParams.height);
                view.setLayoutParams(layoutParams);
                windowManager.updateViewLayout(view, layoutParams);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context, final View view, AnimatorListenerAdapter animatorListenerAdapter, List<List<a.b.C0148a>> list) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        int i2 = cn.jpush.android.af.a.a(context).widthPixels;
        int i3 = 0;
        while (i3 < list.size()) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            ArrayList arrayList2 = new ArrayList();
            List<a.b.C0148a> list2 = list.get(i3);
            cn.jpush.android.r.b.b("InAppAnimator", "inAnimatorVals.size():" + list2.size());
            int i4 = 0;
            while (i4 < list2.size()) {
                a.b.C0148a c0148a = list2.get(i4);
                String trim = c0148a.f9392a.trim();
                List<Float> list3 = c0148a.f9393b;
                int size = list3.size();
                float[] fArr = new float[size];
                List<a.b.C0148a> list4 = list2;
                for (int i5 = 0; i5 < list3.size(); i5++) {
                    fArr[i5] = list3.get(i5).floatValue();
                }
                if ("translationY".equals(trim) || "translationX".equals(trim) || "width".equals(trim) || "height".equals(trim)) {
                    int i6 = 0;
                    while (i6 < size) {
                        fArr[i6] = (fArr[i6] * i2) / 100.0f;
                        i6++;
                        size = size;
                    }
                }
                AnimatorSet animatorSet3 = animatorSet;
                ArrayList arrayList3 = arrayList;
                long j = c0148a.f9394c;
                StringBuilder sb = new StringBuilder();
                int i7 = i2;
                sb.append("type:");
                sb.append(trim);
                cn.jpush.android.r.b.b("InAppAnimator", sb.toString());
                cn.jpush.android.r.b.b("InAppAnimator", "duration:" + j);
                cn.jpush.android.r.b.b("InAppAnimator", "valuesP:" + Arrays.toString(fArr));
                if ("width".equals(trim)) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
                    ofFloat.setDuration(j);
                    animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.ar.b.5
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            view.setLayoutParams(layoutParams);
                        }
                    };
                    objectAnimator2 = ofFloat;
                } else if ("height".equals(trim)) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(fArr);
                    ofFloat2.setDuration(j);
                    animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.ar.b.6
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            view.setLayoutParams(layoutParams);
                        }
                    };
                    objectAnimator2 = ofFloat2;
                } else {
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, trim, fArr);
                    ofFloat3.setDuration(j);
                    objectAnimator = ofFloat3;
                    arrayList2.add(objectAnimator);
                    i4++;
                    animatorSet = animatorSet3;
                    arrayList = arrayList3;
                    list2 = list4;
                    i2 = i7;
                }
                objectAnimator2.addUpdateListener(animatorUpdateListener);
                objectAnimator = objectAnimator2;
                arrayList2.add(objectAnimator);
                i4++;
                animatorSet = animatorSet3;
                arrayList = arrayList3;
                list2 = list4;
                i2 = i7;
            }
            ArrayList arrayList4 = arrayList;
            animatorSet2.playTogether(arrayList2);
            arrayList4.add(animatorSet2);
            i3++;
            arrayList = arrayList4;
            animatorSet = animatorSet;
        }
        AnimatorSet animatorSet4 = animatorSet;
        animatorSet4.addListener(animatorListenerAdapter);
        animatorSet4.playSequentially(arrayList);
        animatorSet4.start();
    }

    public static void a(Context context, View view, Point point, long j, final a aVar) {
        if (view != null) {
            view.animate().translationX(point.x).translationY(point.y).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.ar.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
            cn.jpush.android.r.b.d("InAppAnimator", "slideOutOfView, end[" + point.x + ", " + point.y + "], dismissTime: " + j);
        }
    }

    public static void a(Context context, final View view, Point point, final Point point2, final long j, final a aVar) {
        if (view != null) {
            try {
                view.setAlpha(0.0f);
                view.animate().translationX(point.x).translationY(point.y).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.ar.b.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        try {
                            view.animate().translationX(point2.x).translationY(point2.y).alpha(1.0f).setDuration(j).setListener(null);
                            if (aVar != null) {
                                aVar.a();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                cn.jpush.android.r.b.d("InAppAnimator", "[slideIntoView] start[ " + point.x + "," + point.y + "], , end[" + point2.x + "," + point2.y + "], showElapseTime: " + j);
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppAnimator", "in-app message slideIntoView error. " + th.getMessage());
            }
        }
    }

    public static void a(final Context context, View view, final View view2, final a aVar, final WindowManager windowManager) {
        if (context == null || view == null) {
            return;
        }
        try {
            final boolean z = context.getResources().getConfiguration().orientation == 2;
            List<List<a.b.C0148a>> b2 = cn.jpush.android.au.a.b(context, z);
            a(context, view2, cn.jpush.android.au.a.d(context, z), windowManager);
            a(context, view, new AnimatorListenerAdapter() { // from class: cn.jpush.android.ar.b.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    cn.jpush.android.r.b.b("InAppAnimator", "slideOutOfViewNotification onAnimationEnd:");
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    b.b(context, view2, cn.jpush.android.au.a.f(context, z), windowManager, true);
                }
            }, b2);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppAnimator", "in-app message slideOutOfViewNotification error. " + th.getMessage());
        }
    }

    public static void a(final Context context, View view, final View view2, final a aVar, final WindowManager windowManager, boolean z) {
        try {
            cn.jpush.android.r.b.b("InAppAnimator", "slideIntoViewNotification");
            if (context != null && view != null) {
                boolean z2 = context.getResources().getConfiguration().orientation == 2;
                List<List<a.b.C0148a>> a2 = cn.jpush.android.au.a.a(context, z2);
                final boolean z3 = z2;
                AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: cn.jpush.android.ar.b.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        cn.jpush.android.r.b.b("InAppAnimator", "slideIntoViewNotification onAnimationEnd:");
                        super.onAnimationEnd(animator);
                        a aVar2 = a.this;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                        b.b(context, view2, cn.jpush.android.au.a.e(context, z3), windowManager, false);
                    }
                };
                a(context, view2, cn.jpush.android.au.a.c(context, z2), windowManager);
                a(context, view, animatorListenerAdapter, a2);
                List<Long> a3 = cn.jpush.android.au.a.a(context);
                if (z) {
                    try {
                        a(context, a3);
                    } catch (Throwable th) {
                        cn.jpush.android.r.b.f("InAppAnimator", "startVibrator e:" + th.getMessage());
                    }
                }
            }
        } catch (Throwable th2) {
            cn.jpush.android.r.b.f("InAppAnimator", "in-app message slideIntoViewNotification error. " + th2.getMessage());
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, List<Long> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        long[] jArr = new long[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            jArr[i2] = list.get(i2).longValue();
        }
        vibrator.vibrate(jArr, -1);
    }

    public static void b(Context context, View view, int i2, WindowManager windowManager, boolean z) {
        if (view == null || z) {
            return;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i2;
            cn.jpush.android.r.b.b("InAppAnimator", "setViewGroupHeigthLast:" + layoutParams.height);
            view.setLayoutParams(layoutParams);
            windowManager.updateViewLayout(view, layoutParams);
        } catch (Throwable unused) {
        }
    }
}
