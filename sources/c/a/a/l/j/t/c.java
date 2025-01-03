package c.a.a.l.j.t;

import android.content.Context;
import android.net.Uri;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import java.io.File;
import java.io.InputStream;

/* compiled from: StreamFileLoader.java */
/* loaded from: classes.dex */
public class c extends c.a.a.l.j.b<InputStream> implements d<File> {

    /* compiled from: StreamFileLoader.java */
    public static class a implements m<File, InputStream> {
        @Override // c.a.a.l.j.m
        public l<File, InputStream> a(Context context, c.a.a.l.j.c cVar) {
            return new c(cVar.a(Uri.class, InputStream.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public c(l<Uri, InputStream> lVar) {
        super(lVar);
    }
}
