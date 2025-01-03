package c.a.a.l.j.t;

import android.content.Context;
import android.net.Uri;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import c.a.a.l.j.n;
import java.io.InputStream;

/* compiled from: StreamResourceLoader.java */
/* loaded from: classes.dex */
public class e extends n<InputStream> implements d<Integer> {

    /* compiled from: StreamResourceLoader.java */
    public static class a implements m<Integer, InputStream> {
        @Override // c.a.a.l.j.m
        public l<Integer, InputStream> a(Context context, c.a.a.l.j.c cVar) {
            return new e(context, cVar.a(Uri.class, InputStream.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public e(Context context, l<Uri, InputStream> lVar) {
        super(context, lVar);
    }
}
