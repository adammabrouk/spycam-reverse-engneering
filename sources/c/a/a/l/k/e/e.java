package c.a.a.l.k.e;

import android.graphics.Bitmap;

/* compiled from: CenterCrop.java */
/* loaded from: classes.dex */
public class e extends d {
    public e(c.a.a.l.i.m.c cVar) {
        super(cVar);
    }

    @Override // c.a.a.l.k.e.d
    public Bitmap a(c.a.a.l.i.m.c cVar, Bitmap bitmap, int i2, int i3) {
        Bitmap a2 = cVar.a(i2, i3, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap a3 = q.a(a2, bitmap, i2, i3);
        if (a2 != null && a2 != a3 && !cVar.a(a2)) {
            a2.recycle();
        }
        return a3;
    }

    @Override // c.a.a.l.g
    public String c() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
