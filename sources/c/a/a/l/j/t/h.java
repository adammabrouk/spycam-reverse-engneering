package c.a.a.l.j.t;

import android.content.Context;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import c.a.a.l.j.r;
import java.io.InputStream;
import java.net.URL;

/* compiled from: StreamUrlLoader.java */
/* loaded from: classes.dex */
public class h extends r<InputStream> {

    /* compiled from: StreamUrlLoader.java */
    public static class a implements m<URL, InputStream> {
        @Override // c.a.a.l.j.m
        public l<URL, InputStream> a(Context context, c.a.a.l.j.c cVar) {
            return new h(cVar.a(c.a.a.l.j.d.class, InputStream.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public h(l<c.a.a.l.j.d, InputStream> lVar) {
        super(lVar);
    }
}
