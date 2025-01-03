package a.a.d;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ContextAwareHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Set<b> f144a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public volatile Context f145b;

    public void a(Context context) {
        this.f145b = context;
        Iterator<b> it = this.f144a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    public void addOnContextAvailableListener(b bVar) {
        if (this.f145b != null) {
            bVar.a(this.f145b);
        }
        this.f144a.add(bVar);
    }

    public Context b() {
        return this.f145b;
    }

    public void removeOnContextAvailableListener(b bVar) {
        this.f144a.remove(bVar);
    }

    public void a() {
        this.f145b = null;
    }
}
