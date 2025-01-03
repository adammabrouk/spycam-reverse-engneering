package c.a.a.r;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f3462a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f3463b = new char[64];

    /* compiled from: Util.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3464a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f3464a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3464a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3464a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3464a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String a(byte[] bArr) {
        String a2;
        synchronized (f3463b) {
            a2 = a(bArr, f3463b);
        }
        return a2;
    }

    public static boolean b() {
        return !c();
    }

    public static boolean b(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String a(byte[] bArr, char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & ThreadUtils.TYPE_SINGLE;
            int i4 = i2 * 2;
            char[] cArr2 = f3462a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int a(int i2, int i3, Bitmap.Config config) {
        return i2 * i3 * a(config);
    }

    public static int a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = a.f3464a[config.ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3) ? 2 : 4;
        }
        return 1;
    }

    public static boolean a(int i2, int i3) {
        return b(i2) && b(i3);
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static <T> Queue<T> a(int i2) {
        return new ArrayDeque(i2);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
