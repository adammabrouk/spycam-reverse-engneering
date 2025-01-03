package c.k.d.p9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import c.k.d.u9;
import c.k.d.v9;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static long f7613a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f7614a;

        /* renamed from: b, reason: collision with root package name */
        public int f7615b;

        public a(byte[] bArr, int i2) {
            this.f7614a = bArr;
            this.f7615b = i2;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f7616a;

        /* renamed from: b, reason: collision with root package name */
        public long f7617b;

        public b(Bitmap bitmap, long j) {
            this.f7616a = bitmap;
            this.f7617b = j;
        }
    }

    public static int a(Context context, InputStream inputStream) {
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            c.k.a.a.a.c.m6a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        int i3 = options.outWidth;
        if (i3 <= round || (i2 = options.outHeight) <= round) {
            return 1;
        }
        return Math.min(i3 / round, i2 / round);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int a2;
        Uri parse = Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
                try {
                    a2 = a(context, inputStream);
                    inputStream2 = context.getContentResolver().openInputStream(parse);
                } catch (IOException e2) {
                    e = e2;
                    inputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    v9.a((Closeable) r0);
                    v9.a(inputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                inputStream2 = null;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                v9.a(inputStream2);
                v9.a(inputStream);
                return decodeStream;
            } catch (IOException e4) {
                e = e4;
                c.k.a.a.a.c.a(e);
                v9.a(inputStream2);
                v9.a(inputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            r0 = context;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fc, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ff, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00df, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dd, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0101: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:67:0x0101 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static c.k.d.p9.j.a a(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.j.a(java.lang.String, boolean):c.k.d.p9.j$a");
    }

    public static b a(Context context, String str, boolean z) {
        a a2;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        Bitmap b2 = b(context, str);
        try {
            if (b2 != null) {
                bVar.f7616a = b2;
                return bVar;
            }
            try {
                a2 = a(str, z);
            } catch (Exception e2) {
                e = e2;
            }
            if (a2 == null) {
                v9.a((Closeable) null);
                return bVar;
            }
            bVar.f7617b = a2.f7615b;
            byte[] bArr = a2.f7614a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.f7616a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayInputStream = byteArrayInputStream2;
                        c.k.a.a.a.c.a(e);
                        v9.a(byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        v9.a(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f7616a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f7614a, str);
            v9.a(byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (f7613a == 0) {
                f7613a = u9.a(file);
            }
            if (f7613a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        if (!listFiles[i2].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i2].lastModified()) > 1209600) {
                            listFiles[i2].delete();
                        }
                    }
                } catch (Exception e2) {
                    c.k.a.a.a.c.a(e2);
                }
                f7613a = 0L;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, byte[] r6, java.lang.String r7) {
        /*
            if (r6 != 0) goto L8
            java.lang.String r5 = "cannot save small icon cause bitmap is null"
            c.k.a.a.a.c.m6a(r5)
            return
        L8:
            a(r5)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = r5.getCacheDir()
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "mipush_icon"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L37
            r0.mkdirs()
        L37:
            java.io.File r1 = new java.io.File
            java.lang.String r7 = c.k.d.k0.a(r7)
            r1.<init>(r0, r7)
            r7 = 0
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            if (r0 != 0) goto L4a
            r1.createNewFile()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
        L4a:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> La9
            r3.<init>(r0)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> La9
            r3.write(r6)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            r3.flush()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            c.k.d.v9.a(r3)
            goto L71
        L5e:
            r5 = move-exception
            r7 = r3
            goto Laa
        L61:
            r6 = move-exception
            r7 = r3
            goto L6b
        L64:
            r6 = move-exception
            goto L6b
        L66:
            r5 = move-exception
            r0 = r7
            goto Laa
        L69:
            r6 = move-exception
            r0 = r7
        L6b:
            c.k.a.a.a.c.a(r6)     // Catch: java.lang.Throwable -> La9
            c.k.d.v9.a(r7)
        L71:
            c.k.d.v9.a(r0)
            long r6 = c.k.d.p9.j.f7613a
            r3 = 0
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto La8
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.io.File r5 = r5.getCacheDir()
            java.lang.String r5 = r5.getPath()
            r7.append(r5)
            java.lang.String r5 = java.io.File.separator
            r7.append(r5)
            r7.append(r2)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            long r5 = c.k.d.u9.a(r6)
            long r0 = r1.length()
            long r5 = r5 + r0
            c.k.d.p9.j.f7613a = r5
        La8:
            return
        La9:
            r5 = move-exception
        Laa:
            c.k.d.v9.a(r7)
            c.k.d.v9.a(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.j.a(android.content.Context, byte[], java.lang.String):void");
    }

    public static Bitmap b(Context context, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        Bitmap bitmap;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", c.k.d.k0.a(str));
        FileInputStream fileInputStream2 = null;
        Bitmap bitmap2 = null;
        fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmap2 = BitmapFactory.decodeStream(fileInputStream);
                    file.setLastModified(System.currentTimeMillis());
                    v9.a(fileInputStream);
                    return bitmap2;
                } catch (Exception e2) {
                    e = e2;
                    Bitmap bitmap3 = bitmap2;
                    fileInputStream2 = fileInputStream;
                    bitmap = bitmap3;
                    c.k.a.a.a.c.a(e);
                    v9.a(fileInputStream2);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    v9.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th = th3;
                fileInputStream = fileInputStream3;
            }
        } catch (Exception e3) {
            e = e3;
            bitmap = null;
        }
    }
}
