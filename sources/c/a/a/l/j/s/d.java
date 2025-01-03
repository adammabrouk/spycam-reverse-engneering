package c.a.a.l.j.s;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import c.a.a.l.j.p;

/* compiled from: FileDescriptorStringLoader.java */
/* loaded from: classes.dex */
public class d extends p<ParcelFileDescriptor> implements b<String> {

    /* compiled from: FileDescriptorStringLoader.java */
    public static class a implements m<String, ParcelFileDescriptor> {
        @Override // c.a.a.l.j.m
        public l<String, ParcelFileDescriptor> a(Context context, c.a.a.l.j.c cVar) {
            return new d(cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public d(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}
