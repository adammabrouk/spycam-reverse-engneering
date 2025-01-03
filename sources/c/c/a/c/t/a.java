package c.c.a.c.t;

import android.graphics.Typeface;

/* compiled from: CancelableFontCallback.java */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f5605a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0107a f5606b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5607c;

    /* compiled from: CancelableFontCallback.java */
    /* renamed from: c.c.a.c.t.a$a, reason: collision with other inner class name */
    public interface InterfaceC0107a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0107a interfaceC0107a, Typeface typeface) {
        this.f5605a = typeface;
        this.f5606b = interfaceC0107a;
    }

    @Override // c.c.a.c.t.f
    public void a(Typeface typeface, boolean z) {
        a(typeface);
    }

    @Override // c.c.a.c.t.f
    public void a(int i2) {
        a(this.f5605a);
    }

    public void a() {
        this.f5607c = true;
    }

    public final void a(Typeface typeface) {
        if (this.f5607c) {
            return;
        }
        this.f5606b.a(typeface);
    }
}
