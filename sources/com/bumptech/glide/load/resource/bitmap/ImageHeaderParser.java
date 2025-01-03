package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.google.zxing.client.j2se.DecodeWorker;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.system.ContentCommon;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class ImageHeaderParser {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f9983b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f9984c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: a, reason: collision with root package name */
    public final b f9985a;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);

        public final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f9986a;

        public a(byte[] bArr) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f9986a = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        public void a(ByteOrder byteOrder) {
            this.f9986a.order(byteOrder);
        }

        public int b(int i2) {
            return this.f9986a.getInt(i2);
        }

        public int a() {
            return this.f9986a.array().length;
        }

        public short a(int i2) {
            return this.f9986a.getShort(i2);
        }
    }

    static {
        byte[] bArr = new byte[0];
        try {
            bArr = "Exif\u0000\u0000".getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        f9983b = bArr;
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.f9985a = new b(inputStream);
    }

    public static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    public static boolean a(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    public final byte[] a() throws IOException {
        short c2;
        int b2;
        long j;
        long a2;
        do {
            short c3 = this.f9985a.c();
            if (c3 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) c3));
                }
                return null;
            }
            c2 = this.f9985a.c();
            if (c2 == 218) {
                return null;
            }
            if (c2 == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return null;
            }
            b2 = this.f9985a.b() - 2;
            if (c2 == 225) {
                byte[] bArr = new byte[b2];
                int a3 = this.f9985a.a(bArr);
                if (a3 == b2) {
                    return bArr;
                }
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unable to read segment data, type: " + ((int) c2) + ", length: " + b2 + ", actually read: " + a3);
                }
                return null;
            }
            j = b2;
            a2 = this.f9985a.a(j);
        } while (a2 == j);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) c2) + ", wanted to skip: " + b2 + ", but actually skipped: " + a2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b() throws java.io.IOException {
        /*
            r7 = this;
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$b r0 = r7.f9985a
            int r0 = r0.b()
            boolean r0 = a(r0)
            r1 = -1
            if (r0 != 0) goto Le
            return r1
        Le:
            byte[] r0 = r7.a()
            r2 = 0
            if (r0 == 0) goto L1d
            int r3 = r0.length
            byte[] r4 = com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.f9983b
            int r4 = r4.length
            if (r3 <= r4) goto L1d
            r3 = 1
            goto L1e
        L1d:
            r3 = 0
        L1e:
            if (r3 == 0) goto L30
            r4 = 0
        L21:
            byte[] r5 = com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.f9983b
            int r6 = r5.length
            if (r4 >= r6) goto L30
            r6 = r0[r4]
            r5 = r5[r4]
            if (r6 == r5) goto L2d
            goto L31
        L2d:
            int r4 = r4 + 1
            goto L21
        L30:
            r2 = r3
        L31:
            if (r2 == 0) goto L3d
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$a r1 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$a
            r1.<init>(r0)
            int r0 = a(r1)
            return r0
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.b():int");
    }

    public ImageType c() throws IOException {
        int b2 = this.f9985a.b();
        if (b2 == 65496) {
            return ImageType.JPEG;
        }
        int b3 = ((b2 << 16) & DecodeWorker.RED) | (this.f9985a.b() & ContentCommon.INVALID_OPTION);
        if (b3 != -1991225785) {
            return (b3 >> 8) == 4671814 ? ImageType.GIF : ImageType.UNKNOWN;
        }
        this.f9985a.a(21L);
        return this.f9985a.a() >= 3 ? ImageType.PNG_A : ImageType.PNG;
    }

    public boolean d() throws IOException {
        return c().hasAlpha();
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final InputStream f9987a;

        public b(InputStream inputStream) {
            this.f9987a = inputStream;
        }

        public long a(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f9987a.skip(j2);
                if (skip <= 0) {
                    if (this.f9987a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        public int b() throws IOException {
            return ((this.f9987a.read() << 8) & 65280) | (this.f9987a.read() & ViewfinderView.OPAQUE);
        }

        public short c() throws IOException {
            return (short) (this.f9987a.read() & ViewfinderView.OPAQUE);
        }

        public int a(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int read = this.f9987a.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public int a() throws IOException {
            return this.f9987a.read();
        }
    }

    public static int a(a aVar) {
        ByteOrder byteOrder;
        short a2 = aVar.a(6);
        if (a2 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) a2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.a(byteOrder);
        int b2 = aVar.b(10) + 6;
        short a3 = aVar.a(b2);
        for (int i2 = 0; i2 < a3; i2++) {
            int a4 = a(b2, i2);
            short a5 = aVar.a(a4);
            if (a5 == 274) {
                short a6 = aVar.a(a4 + 2);
                if (a6 >= 1 && a6 <= 12) {
                    int b3 = aVar.b(a4 + 4);
                    if (b3 < 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + ((int) a5) + " formatCode=" + ((int) a6) + " componentCount=" + b3);
                        }
                        int i3 = b3 + f9984c[a6];
                        if (i3 > 4) {
                            if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a6));
                            }
                        } else {
                            int i4 = a4 + 8;
                            if (i4 >= 0 && i4 <= aVar.a()) {
                                if (i3 >= 0 && i3 + i4 <= aVar.a()) {
                                    return aVar.a(i4);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a5));
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) a5));
                            }
                        }
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code=" + ((int) a6));
                }
            }
        }
        return -1;
    }
}
