package c.b.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.shix.shixipc.utils.MyLogUtils;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: BitmapUtil.java */
/* loaded from: classes.dex */
public class a {
    public static Bitmap a(Context context, Uri uri, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i4 = 1;
        options.inJustDecodeBounds = true;
        b(context, uri, options);
        for (int i5 = 0; i5 < Integer.MAX_VALUE; i5++) {
            int i6 = options.outWidth;
            if (i6 / i4 > i2) {
                double d2 = i6 / i4;
                double d3 = i2;
                Double.isNaN(d3);
                if (d2 > d3 * 1.4d) {
                    continue;
                    i4++;
                }
            }
            int i7 = options.outHeight;
            if (i7 / i4 <= i3) {
                break;
            }
            double d4 = i7 / i4;
            double d5 = i3;
            Double.isNaN(d5);
            if (d4 <= d5 * 1.4d) {
                break;
            }
            i4++;
        }
        options.inSampleSize = i4;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            return a(context, uri, options);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void b(Context context, Uri uri, BitmapFactory.Options options) {
        StringBuilder sb;
        if (uri == null) {
            return;
        }
        String scheme = uri.getScheme();
        if (!"content".equals(scheme) && !"file".equals(scheme)) {
            if ("android.resource".equals(scheme)) {
                MyLogUtils.e("readBitmapScale", "Unable to close content: " + uri);
                return;
            }
            MyLogUtils.e("readBitmapScale", "Unable to close content: " + uri);
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    BitmapFactory.decodeStream(openInputStream, null, options);
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused) {
                            sb = new StringBuilder();
                            sb.append("Unable to close content: ");
                            sb.append(uri);
                            MyLogUtils.e("readBitmapScale", sb.toString());
                        }
                    }
                } catch (Exception unused2) {
                    inputStream = openInputStream;
                    MyLogUtils.w("readBitmapScale", "Unable to open content: " + uri);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                            sb = new StringBuilder();
                            sb.append("Unable to close content: ");
                            sb.append(uri);
                            MyLogUtils.e("readBitmapScale", sb.toString());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = openInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                            MyLogUtils.e("readBitmapScale", "Unable to close content: " + uri);
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r5, android.net.Uri r6, android.graphics.BitmapFactory.Options r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = r6.getScheme()
            java.lang.String r2 = "content"
            boolean r2 = r2.equals(r1)
            java.lang.String r3 = "Unable to close content: "
            java.lang.String r4 = "readBitmapData"
            if (r2 != 0) goto L4c
            java.lang.String r2 = "file"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L1d
            goto L4c
        L1d:
            java.lang.String r5 = "android.resource"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L39
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.shix.shixipc.utils.MyLogUtils.e(r4, r5)
            goto La4
        L39:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.shix.shixipc.utils.MyLogUtils.e(r4, r5)
            goto La4
        L4c:
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.io.InputStream r5 = r5.openInputStream(r6)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r5, r0, r7)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L78
            if (r5 == 0) goto L70
            r5.close()     // Catch: java.io.IOException -> L5e
            goto L70
        L5e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.shix.shixipc.utils.MyLogUtils.e(r4, r5)
        L70:
            r0 = r7
            goto La4
        L72:
            r7 = move-exception
            r0 = r5
            goto La5
        L75:
            r7 = move-exception
            goto La5
        L77:
            r5 = r0
        L78:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72
            r7.<init>()     // Catch: java.lang.Throwable -> L72
            java.lang.String r1 = "Unable to open content: "
            r7.append(r1)     // Catch: java.lang.Throwable -> L72
            r7.append(r6)     // Catch: java.lang.Throwable -> L72
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L72
            com.shix.shixipc.utils.MyLogUtils.e(r4, r7)     // Catch: java.lang.Throwable -> L72
            if (r5 == 0) goto La4
            r5.close()     // Catch: java.io.IOException -> L92
            goto La4
        L92:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.shix.shixipc.utils.MyLogUtils.e(r4, r5)
        La4:
            return r0
        La5:
            if (r0 == 0) goto Lbd
            r0.close()     // Catch: java.io.IOException -> Lab
            goto Lbd
        Lab:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.shix.shixipc.utils.MyLogUtils.e(r4, r5)
        Lbd:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.a.a.a(android.content.Context, android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }
}
