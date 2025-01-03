package c.a.a.l.i.n;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f3170a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3171b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f3172c;

    /* compiled from: MemorySizeCalculator.java */
    public static class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final DisplayMetrics f3173a;

        public a(DisplayMetrics displayMetrics) {
            this.f3173a = displayMetrics;
        }

        @Override // c.a.a.l.i.n.i.b
        public int a() {
            return this.f3173a.heightPixels;
        }

        @Override // c.a.a.l.i.n.i.b
        public int b() {
            return this.f3173a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    public interface b {
        int a();

        int b();
    }

    public i(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    public int a() {
        return this.f3170a;
    }

    public int b() {
        return this.f3171b;
    }

    public i(Context context, ActivityManager activityManager, b bVar) {
        this.f3172c = context;
        int a2 = a(activityManager);
        int b2 = bVar.b() * bVar.a() * 4;
        int i2 = b2 * 4;
        int i3 = b2 * 2;
        int i4 = i3 + i2;
        if (i4 <= a2) {
            this.f3171b = i3;
            this.f3170a = i2;
        } else {
            int round = Math.round(a2 / 6.0f);
            this.f3171b = round * 2;
            this.f3170a = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(a(this.f3171b));
            sb.append(" pool size: ");
            sb.append(a(this.f3170a));
            sb.append(" memory class limited? ");
            sb.append(i4 > a2);
            sb.append(" max size: ");
            sb.append(a(a2));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(b(activityManager));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public static int a(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (b(activityManager) ? 0.33f : 0.4f));
    }

    @TargetApi(19)
    public static boolean b(ActivityManager activityManager) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 11 || (i2 >= 19 && activityManager.isLowRamDevice());
    }

    public final String a(int i2) {
        return Formatter.formatFileSize(this.f3172c, i2);
    }
}
