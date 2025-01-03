package c.a.a.l.k.h;

import android.graphics.Bitmap;
import c.a.a.j.a;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public class a implements a.InterfaceC0063a {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.i.m.c f3281a;

    public a(c.a.a.l.i.m.c cVar) {
        this.f3281a = cVar;
    }

    @Override // c.a.a.j.a.InterfaceC0063a
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f3281a.b(i2, i3, config);
    }

    @Override // c.a.a.j.a.InterfaceC0063a
    public void a(Bitmap bitmap) {
        if (this.f3281a.a(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
