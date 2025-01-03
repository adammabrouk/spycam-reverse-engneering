package c.a.a.l.k.e;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;

/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class b implements c.a.a.l.f<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap.CompressFormat f3226a;

    /* renamed from: b, reason: collision with root package name */
    public int f3227b;

    public b() {
        this(null, 90);
    }

    @Override // c.a.a.l.b
    public String c() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    public b(Bitmap.CompressFormat compressFormat, int i2) {
        this.f3226a = compressFormat;
        this.f3227b = i2;
    }

    @Override // c.a.a.l.b
    public boolean a(c.a.a.l.i.k<Bitmap> kVar, OutputStream outputStream) {
        Bitmap bitmap = kVar.get();
        long a2 = c.a.a.r.d.a();
        Bitmap.CompressFormat a3 = a(bitmap);
        bitmap.compress(a3, this.f3227b, outputStream);
        if (!Log.isLoggable("BitmapEncoder", 2)) {
            return true;
        }
        Log.v("BitmapEncoder", "Compressed with type: " + a3 + " of size " + c.a.a.r.h.a(bitmap) + " in " + c.a.a.r.d.a(a2));
        return true;
    }

    public final Bitmap.CompressFormat a(Bitmap bitmap) {
        Bitmap.CompressFormat compressFormat = this.f3226a;
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }
}
