package c.a.a.l.k.e;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* compiled from: VideoBitmapDecoder.java */
/* loaded from: classes.dex */
public class r implements c.a.a.l.k.e.a<ParcelFileDescriptor> {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3271c = new a();

    /* renamed from: a, reason: collision with root package name */
    public a f3272a;

    /* renamed from: b, reason: collision with root package name */
    public int f3273b;

    /* compiled from: VideoBitmapDecoder.java */
    public static class a {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public r() {
        this(f3271c, -1);
    }

    public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, c.a.a.l.i.m.c cVar, int i2, int i3, c.a.a.l.a aVar) throws IOException {
        MediaMetadataRetriever a2 = this.f3272a.a();
        a2.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i4 = this.f3273b;
        Bitmap frameAtTime = i4 >= 0 ? a2.getFrameAtTime(i4) : a2.getFrameAtTime();
        a2.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    @Override // c.a.a.l.k.e.a
    public String c() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    public r(a aVar, int i2) {
        this.f3272a = aVar;
        this.f3273b = i2;
    }
}
