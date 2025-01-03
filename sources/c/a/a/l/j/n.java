package c.a.a.l.j;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class n<T> implements l<Integer, T> {

    /* renamed from: a, reason: collision with root package name */
    public final l<Uri, T> f3213a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f3214b;

    public n(Context context, l<Uri, T> lVar) {
        this(context.getResources(), lVar);
    }

    public n(Resources resources, l<Uri, T> lVar) {
        this.f3214b = resources;
        this.f3213a = lVar;
    }

    @Override // c.a.a.l.j.l
    public c.a.a.l.h.c<T> a(Integer num, int i2, int i3) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.f3214b.getResourcePackageName(num.intValue()) + '/' + this.f3214b.getResourceTypeName(num.intValue()) + '/' + this.f3214b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            }
            uri = null;
        }
        if (uri != null) {
            return this.f3213a.a(uri, i2, i3);
        }
        return null;
    }
}
