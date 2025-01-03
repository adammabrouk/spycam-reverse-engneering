package c.a.a.l.j;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ImageVideoWrapperEncoder.java */
/* loaded from: classes.dex */
public class h implements c.a.a.l.b<g> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.b<InputStream> f3199a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.b<ParcelFileDescriptor> f3200b;

    /* renamed from: c, reason: collision with root package name */
    public String f3201c;

    public h(c.a.a.l.b<InputStream> bVar, c.a.a.l.b<ParcelFileDescriptor> bVar2) {
        this.f3199a = bVar;
        this.f3200b = bVar2;
    }

    @Override // c.a.a.l.b
    public String c() {
        if (this.f3201c == null) {
            this.f3201c = this.f3199a.c() + this.f3200b.c();
        }
        return this.f3201c;
    }

    @Override // c.a.a.l.b
    public boolean a(g gVar, OutputStream outputStream) {
        return gVar.b() != null ? this.f3199a.a(gVar.b(), outputStream) : this.f3200b.a(gVar.a(), outputStream);
    }
}
