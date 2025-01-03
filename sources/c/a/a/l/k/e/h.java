package c.a.a.l.k.e;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* compiled from: FileDescriptorBitmapDecoder.java */
/* loaded from: classes.dex */
public class h implements c.a.a.l.e<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final r f3238a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.i.m.c f3239b;

    /* renamed from: c, reason: collision with root package name */
    public c.a.a.l.a f3240c;

    public h(c.a.a.l.i.m.c cVar, c.a.a.l.a aVar) {
        this(new r(), cVar, aVar);
    }

    @Override // c.a.a.l.e
    public String c() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }

    public h(r rVar, c.a.a.l.i.m.c cVar, c.a.a.l.a aVar) {
        this.f3238a = rVar;
        this.f3239b = cVar;
        this.f3240c = aVar;
    }

    @Override // c.a.a.l.e
    public c.a.a.l.i.k<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3) throws IOException {
        return c.a(this.f3238a.a(parcelFileDescriptor, this.f3239b, i2, i3, this.f3240c), this.f3239b);
    }
}
