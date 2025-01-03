package c.a.a.l.k.e;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ImageVideoBitmapDecoder.java */
/* loaded from: classes.dex */
public class l implements c.a.a.l.e<c.a.a.l.j.g, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.e<InputStream, Bitmap> f3252a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.e<ParcelFileDescriptor, Bitmap> f3253b;

    public l(c.a.a.l.e<InputStream, Bitmap> eVar, c.a.a.l.e<ParcelFileDescriptor, Bitmap> eVar2) {
        this.f3252a = eVar;
        this.f3253b = eVar2;
    }

    @Override // c.a.a.l.e
    public String c() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // c.a.a.l.e
    public c.a.a.l.i.k<Bitmap> a(c.a.a.l.j.g gVar, int i2, int i3) throws IOException {
        c.a.a.l.i.k<Bitmap> a2;
        ParcelFileDescriptor a3;
        InputStream b2 = gVar.b();
        if (b2 != null) {
            try {
                a2 = this.f3252a.a(b2, i2, i3);
            } catch (IOException e2) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e2);
                }
            }
            return (a2 != null || (a3 = gVar.a()) == null) ? a2 : this.f3253b.a(a3, i2, i3);
        }
        a2 = null;
        if (a2 != null) {
            return a2;
        }
    }
}
