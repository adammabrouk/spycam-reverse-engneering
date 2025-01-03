package a.h.a;

import a.h.a.m;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public class a extends a.h.b.a {

    /* renamed from: c, reason: collision with root package name */
    public static d f850c;

    /* compiled from: ActivityCompat.java */
    /* renamed from: a.h.a.a$a, reason: collision with other inner class name */
    public class RunnableC0013a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f851a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f852b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f853c;

        public RunnableC0013a(String[] strArr, Activity activity, int i2) {
            this.f851a = strArr;
            this.f852b = activity;
            this.f853c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f851a.length];
            PackageManager packageManager = this.f852b.getPackageManager();
            String packageName = this.f852b.getPackageName();
            int length = this.f851a.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.f851a[i2], packageName);
            }
            ((c) this.f852b).onRequestPermissionsResult(this.f853c, this.f851a, iArr);
        }
    }

    /* compiled from: ActivityCompat.java */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f854a;

        public b(Activity activity) {
            this.f854a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f854a.isFinishing() || a.h.a.c.a(this.f854a)) {
                return;
            }
            this.f854a.recreate();
        }
    }

    /* compiled from: ActivityCompat.java */
    public interface c {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat.java */
    public interface d {
        boolean a(Activity activity, String[] strArr, int i2);
    }

    /* compiled from: ActivityCompat.java */
    public interface e {
        void validateRequestPermissionsRequestCode(int i2);
    }

    /* compiled from: ActivityCompat.java */
    public static class f extends SharedElementCallback {

        /* renamed from: a, reason: collision with root package name */
        public final m f855a;

        /* compiled from: ActivityCompat.java */
        /* renamed from: a.h.a.a$f$a, reason: collision with other inner class name */
        public class C0014a implements m.a {
            public C0014a(f fVar, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            }
        }

        public f(m mVar) {
            this.f855a = mVar;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f855a.a(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f855a.a(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f855a.a(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f855a.a(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f855a.a(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f855a.b(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f855a.a(list, list2, new C0014a(this, onSharedElementsReadyListener));
        }
    }

    public static void a(Activity activity, Intent intent, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i2, bundle);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void d(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            activity.recreate();
        } else if (i2 <= 23) {
            new Handler(activity.getMainLooper()).post(new b(activity));
        } else {
            if (a.h.a.c.a(activity)) {
                return;
            }
            activity.recreate();
        }
    }

    public static void e(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public static void b(Activity activity, m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(mVar != null ? new f(mVar) : null);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(mVar != null ? new f(mVar) : null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, String[] strArr, int i2) {
        d dVar = f850c;
        if (dVar == null || !dVar.a(activity, strArr, i2)) {
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof e) {
                    ((e) activity).validateRequestPermissionsRequestCode(i2);
                }
                activity.requestPermissions(strArr, i2);
            } else if (activity instanceof c) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0013a(strArr, activity, i2));
            }
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
