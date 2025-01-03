package c.a.a.l.j.s;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import c.a.a.l.j.q;

/* compiled from: FileDescriptorUriLoader.java */
/* loaded from: classes.dex */
public class e extends q<ParcelFileDescriptor> implements b<Uri> {

    /* compiled from: FileDescriptorUriLoader.java */
    public static class a implements m<Uri, ParcelFileDescriptor> {
        @Override // c.a.a.l.j.m
        public l<Uri, ParcelFileDescriptor> a(Context context, c.a.a.l.j.c cVar) {
            return new e(context, cVar.a(c.a.a.l.j.d.class, ParcelFileDescriptor.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public e(Context context, l<c.a.a.l.j.d, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }

    @Override // c.a.a.l.j.q
    public c.a.a.l.h.c<ParcelFileDescriptor> a(Context context, Uri uri) {
        return new c.a.a.l.h.e(context, uri);
    }

    @Override // c.a.a.l.j.q
    public c.a.a.l.h.c<ParcelFileDescriptor> a(Context context, String str) {
        return new c.a.a.l.h.d(context.getApplicationContext().getAssets(), str);
    }
}
