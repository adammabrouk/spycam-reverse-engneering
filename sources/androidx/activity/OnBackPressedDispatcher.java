package androidx.activity;

import a.a.b;
import a.m.f;
import a.m.g;
import a.m.i;
import android.annotation.SuppressLint;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f2035a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f2036b = new ArrayDeque<>();

    public class LifecycleOnBackPressedCancellable implements g, a.a.a {

        /* renamed from: a, reason: collision with root package name */
        public final f f2037a;

        /* renamed from: b, reason: collision with root package name */
        public final b f2038b;

        /* renamed from: c, reason: collision with root package name */
        public a.a.a f2039c;

        public LifecycleOnBackPressedCancellable(f fVar, b bVar) {
            this.f2037a = fVar;
            this.f2038b = bVar;
            fVar.a(this);
        }

        @Override // a.m.g
        public void a(i iVar, f.b bVar) {
            if (bVar == f.b.ON_START) {
                this.f2039c = OnBackPressedDispatcher.this.a(this.f2038b);
                return;
            }
            if (bVar != f.b.ON_STOP) {
                if (bVar == f.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                a.a.a aVar = this.f2039c;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }

        @Override // a.a.a
        public void cancel() {
            this.f2037a.b(this);
            this.f2038b.b(this);
            a.a.a aVar = this.f2039c;
            if (aVar != null) {
                aVar.cancel();
                this.f2039c = null;
            }
        }
    }

    public class a implements a.a.a {

        /* renamed from: a, reason: collision with root package name */
        public final b f2041a;

        public a(b bVar) {
            this.f2041a = bVar;
        }

        @Override // a.a.a
        public void cancel() {
            OnBackPressedDispatcher.this.f2036b.remove(this.f2041a);
            this.f2041a.b(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f2035a = runnable;
    }

    public a.a.a a(b bVar) {
        this.f2036b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    @SuppressLint({"LambdaLast"})
    public void a(i iVar, b bVar) {
        f lifecycle = iVar.getLifecycle();
        if (lifecycle.a() == f.c.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
    }

    public void a() {
        Iterator<b> descendingIterator = this.f2036b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.b()) {
                next.a();
                return;
            }
        }
        Runnable runnable = this.f2035a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
