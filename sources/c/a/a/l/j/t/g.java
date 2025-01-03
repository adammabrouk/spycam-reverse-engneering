package c.a.a.l.j.t;

import android.content.Context;
import android.net.Uri;
import c.a.a.l.h.i;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import c.a.a.l.j.q;
import java.io.InputStream;

/* compiled from: StreamUriLoader.java */
/* loaded from: classes.dex */
public class g extends q<InputStream> implements d<Uri> {

    /* compiled from: StreamUriLoader.java */
    public static class a implements m<Uri, InputStream> {
        @Override // c.a.a.l.j.m
        public l<Uri, InputStream> a(Context context, c.a.a.l.j.c cVar) {
            return new g(context, cVar.a(c.a.a.l.j.d.class, InputStream.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public g(Context context, l<c.a.a.l.j.d, InputStream> lVar) {
        super(context, lVar);
    }

    @Override // c.a.a.l.j.q
    public c.a.a.l.h.c<InputStream> a(Context context, Uri uri) {
        return new i(context, uri);
    }

    @Override // c.a.a.l.j.q
    public c.a.a.l.h.c<InputStream> a(Context context, String str) {
        return new c.a.a.l.h.h(context.getApplicationContext().getAssets(), str);
    }
}
