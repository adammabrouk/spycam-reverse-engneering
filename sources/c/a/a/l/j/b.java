package c.a.a.l.j;

import android.net.Uri;
import java.io.File;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class b<T> implements l<File, T> {

    /* renamed from: a, reason: collision with root package name */
    public final l<Uri, T> f3182a;

    public b(l<Uri, T> lVar) {
        this.f3182a = lVar;
    }

    @Override // c.a.a.l.j.l
    public c.a.a.l.h.c<T> a(File file, int i2, int i3) {
        return this.f3182a.a(Uri.fromFile(file), i2, i3);
    }
}
