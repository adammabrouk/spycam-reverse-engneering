package c.a.a.l.j.s;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import java.io.File;

/* compiled from: FileDescriptorFileLoader.java */
/* loaded from: classes.dex */
public class a extends c.a.a.l.j.b<ParcelFileDescriptor> implements b<File> {

    /* compiled from: FileDescriptorFileLoader.java */
    /* renamed from: c.a.a.l.j.s.a$a, reason: collision with other inner class name */
    public static class C0072a implements m<File, ParcelFileDescriptor> {
        @Override // c.a.a.l.j.m
        public l<File, ParcelFileDescriptor> a(Context context, c.a.a.l.j.c cVar) {
            return new a(cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public a(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}
