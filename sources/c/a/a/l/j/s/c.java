package c.a.a.l.j.s;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import c.a.a.l.j.n;

/* compiled from: FileDescriptorResourceLoader.java */
/* loaded from: classes.dex */
public class c extends n<ParcelFileDescriptor> implements b<Integer> {

    /* compiled from: FileDescriptorResourceLoader.java */
    public static class a implements m<Integer, ParcelFileDescriptor> {
        @Override // c.a.a.l.j.m
        public l<Integer, ParcelFileDescriptor> a(Context context, c.a.a.l.j.c cVar) {
            return new c(context, cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public c(Context context, l<Uri, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }
}
