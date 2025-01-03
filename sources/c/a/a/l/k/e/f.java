package c.a.a.l.k.e;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public abstract class f implements c.a.a.l.k.e.a<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f3231a = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);

    /* renamed from: b, reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f3232b = c.a.a.r.h.a(0);

    /* renamed from: c, reason: collision with root package name */
    public static final f f3233c = new a();

    /* compiled from: Downsampler.java */
    public static class a extends f {
        @Override // c.a.a.l.k.e.f
        public int a(int i2, int i3, int i4, int i5) {
            return Math.min(i3 / i5, i2 / i4);
        }

        @Override // c.a.a.l.k.e.a
        public String c() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }
    }

    /* compiled from: Downsampler.java */
    public static class b extends f {
        @Override // c.a.a.l.k.e.f
        public int a(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return max << (max >= ceil ? 0 : 1);
        }

        @Override // c.a.a.l.k.e.a
        public String c() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }
    }

    /* compiled from: Downsampler.java */
    public static class c extends f {
        @Override // c.a.a.l.k.e.f
        public int a(int i2, int i3, int i4, int i5) {
            return 0;
        }

        @Override // c.a.a.l.k.e.a
        public String c() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }
    }

    static {
        new b();
        new c();
    }

    public static Bitmap b(c.a.a.r.f fVar, n nVar, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            fVar.mark(5242880);
        } else {
            nVar.a();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(fVar, null, options);
        try {
            if (options.inJustDecodeBounds) {
                fVar.reset();
            }
        } catch (IOException e2) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e2);
            }
        }
        return decodeStream;
    }

    public abstract int a(int i2, int i3, int i4, int i5);

    public Bitmap a(InputStream inputStream, c.a.a.l.i.m.c cVar, int i2, int i3, c.a.a.l.a aVar) {
        int i4;
        c.a.a.r.a b2 = c.a.a.r.a.b();
        byte[] a2 = b2.a();
        byte[] a3 = b2.a();
        BitmapFactory.Options a4 = a();
        n nVar = new n(inputStream, a3);
        c.a.a.r.c b3 = c.a.a.r.c.b(nVar);
        c.a.a.r.f fVar = new c.a.a.r.f(b3);
        try {
            b3.mark(5242880);
            try {
                try {
                    int b4 = new ImageHeaderParser(b3).b();
                    try {
                        b3.reset();
                    } catch (IOException e2) {
                        if (Log.isLoggable("Downsampler", 5)) {
                            Log.w("Downsampler", "Cannot reset the input stream", e2);
                        }
                    }
                    i4 = b4;
                } catch (IOException e3) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot determine the image orientation from header", e3);
                    }
                    try {
                        b3.reset();
                    } catch (IOException e4) {
                        if (Log.isLoggable("Downsampler", 5)) {
                            Log.w("Downsampler", "Cannot reset the input stream", e4);
                        }
                    }
                    i4 = 0;
                }
                a4.inTempStorage = a2;
                int[] a5 = a(fVar, nVar, a4);
                int i5 = a5[0];
                int i6 = a5[1];
                Bitmap a6 = a(fVar, nVar, a4, cVar, i5, i6, a(q.a(i4), i5, i6, i2, i3), aVar);
                IOException a7 = b3.a();
                if (a7 != null) {
                    throw new RuntimeException(a7);
                }
                Bitmap bitmap = null;
                if (a6 != null) {
                    bitmap = q.a(a6, cVar, i4);
                    if (!a6.equals(bitmap) && !cVar.a(a6)) {
                        a6.recycle();
                    }
                }
                return bitmap;
            } finally {
            }
        } finally {
            b2.a(a2);
            b2.a(a3);
            b3.b();
            a(a4);
        }
    }

    @TargetApi(11)
    public static void b(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    public final int a(int i2, int i3, int i4, int i5, int i6) {
        int a2;
        if (i6 == Integer.MIN_VALUE) {
            i6 = i4;
        }
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i2 != 90 && i2 != 270) {
            a2 = a(i3, i4, i5, i6);
        } else {
            a2 = a(i4, i3, i5, i6);
        }
        return Math.max(1, a2 == 0 ? 0 : Integer.highestOneBit(a2));
    }

    public final Bitmap a(c.a.a.r.f fVar, n nVar, BitmapFactory.Options options, c.a.a.l.i.m.c cVar, int i2, int i3, int i4, c.a.a.l.a aVar) {
        Bitmap.Config a2 = a(fVar, aVar);
        options.inSampleSize = i4;
        options.inPreferredConfig = a2;
        if ((i4 == 1 || 19 <= Build.VERSION.SDK_INT) && a(fVar)) {
            double d2 = i2;
            double d3 = i4;
            Double.isNaN(d2);
            Double.isNaN(d3);
            int ceil = (int) Math.ceil(d2 / d3);
            double d4 = i3;
            Double.isNaN(d4);
            Double.isNaN(d3);
            a(options, cVar.b(ceil, (int) Math.ceil(d4 / d3), a2));
        }
        return b(fVar, nVar, options);
    }

    public static boolean a(InputStream inputStream) {
        if (19 <= Build.VERSION.SDK_INT) {
            return true;
        }
        inputStream.mark(1024);
        try {
            try {
                return f3231a.contains(new ImageHeaderParser(inputStream).c());
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine the image type from header", e2);
                }
                try {
                    inputStream.reset();
                    return false;
                } catch (IOException e3) {
                    if (!Log.isLoggable("Downsampler", 5)) {
                        return false;
                    }
                    Log.w("Downsampler", "Cannot reset the input stream", e3);
                    return false;
                }
            }
        } finally {
            try {
                inputStream.reset();
            } catch (IOException e4) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot reset the input stream", e4);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (android.util.Log.isLoggable("Downsampler", 5) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        android.util.Log.w("Downsampler", "Cannot reset the input stream", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0058, code lost:
    
        if (android.util.Log.isLoggable("Downsampler", 5) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap.Config a(java.io.InputStream r7, c.a.a.l.a r8) {
        /*
            java.lang.String r0 = "Cannot reset the input stream"
            java.lang.String r1 = "Downsampler"
            c.a.a.l.a r2 = c.a.a.l.a.ALWAYS_ARGB_8888
            if (r8 == r2) goto L72
            c.a.a.l.a r2 = c.a.a.l.a.PREFER_ARGB_8888
            if (r8 == r2) goto L72
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 16
            if (r2 != r3) goto L13
            goto L72
        L13:
            r2 = 0
            r3 = 1024(0x400, float:1.435E-42)
            r7.mark(r3)
            r3 = 5
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser r4 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            boolean r2 = r4.d()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r7.reset()     // Catch: java.io.IOException -> L27
            goto L5b
        L27:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5b
        L2e:
            android.util.Log.w(r1, r0, r7)
            goto L5b
        L32:
            r8 = move-exception
            goto L63
        L34:
            r4 = move-exception
            boolean r5 = android.util.Log.isLoggable(r1, r3)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L4f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r5.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r6 = "Cannot determine whether the image has alpha or not from header for format "
            r5.append(r6)     // Catch: java.lang.Throwable -> L32
            r5.append(r8)     // Catch: java.lang.Throwable -> L32
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L32
            android.util.Log.w(r1, r8, r4)     // Catch: java.lang.Throwable -> L32
        L4f:
            r7.reset()     // Catch: java.io.IOException -> L53
            goto L5b
        L53:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5b
            goto L2e
        L5b:
            if (r2 == 0) goto L60
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            goto L62
        L60:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGB_565
        L62:
            return r7
        L63:
            r7.reset()     // Catch: java.io.IOException -> L67
            goto L71
        L67:
            r7 = move-exception
            boolean r2 = android.util.Log.isLoggable(r1, r3)
            if (r2 == 0) goto L71
            android.util.Log.w(r1, r0, r7)
        L71:
            throw r8
        L72:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.l.k.e.f.a(java.io.InputStream, c.a.a.l.a):android.graphics.Bitmap$Config");
    }

    public int[] a(c.a.a.r.f fVar, n nVar, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        b(fVar, nVar, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    @TargetApi(11)
    public static void a(BitmapFactory.Options options, Bitmap bitmap) {
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    @TargetApi(11)
    public static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (f.class) {
            synchronized (f3232b) {
                poll = f3232b.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                b(poll);
            }
        }
        return poll;
    }

    public static void a(BitmapFactory.Options options) {
        b(options);
        synchronized (f3232b) {
            f3232b.offer(options);
        }
    }
}
