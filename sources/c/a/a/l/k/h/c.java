package c.a.a.l.k.h;

import android.content.Context;
import c.a.a.l.j.o;
import java.io.File;
import java.io.InputStream;

/* compiled from: GifDrawableLoadProvider.java */
/* loaded from: classes.dex */
public class c implements c.a.a.o.b<InputStream, b> {

    /* renamed from: a, reason: collision with root package name */
    public final i f3300a;

    /* renamed from: b, reason: collision with root package name */
    public final j f3301b;

    /* renamed from: c, reason: collision with root package name */
    public final o f3302c = new o();

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.k.g.c<b> f3303d;

    public c(Context context, c.a.a.l.i.m.c cVar) {
        this.f3300a = new i(context, cVar);
        this.f3303d = new c.a.a.l.k.g.c<>(this.f3300a);
        this.f3301b = new j(cVar);
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<File, b> a() {
        return this.f3303d;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.b<InputStream> b() {
        return this.f3302c;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.f<b> e() {
        return this.f3301b;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<InputStream, b> f() {
        return this.f3300a;
    }
}
