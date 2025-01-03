package c.a.a.l.j.t;

import android.content.Context;
import android.net.Uri;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import c.a.a.l.j.p;
import java.io.InputStream;

/* compiled from: StreamStringLoader.java */
/* loaded from: classes.dex */
public class f extends p<InputStream> implements d<String> {

    /* compiled from: StreamStringLoader.java */
    public static class a implements m<String, InputStream> {
        @Override // c.a.a.l.j.m
        public l<String, InputStream> a(Context context, c.a.a.l.j.c cVar) {
            return new f(cVar.a(Uri.class, InputStream.class));
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public f(l<Uri, InputStream> lVar) {
        super(lVar);
    }
}
