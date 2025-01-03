package c.c.a.c.q;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.Property;
import android.view.View;
import c.c.a.c.a.h;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseMotionStrategy.java */
/* loaded from: classes.dex */
public abstract class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5487a;

    /* renamed from: b, reason: collision with root package name */
    public final ExtendedFloatingActionButton f5488b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<Animator.AnimatorListener> f5489c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public final a f5490d;

    /* renamed from: e, reason: collision with root package name */
    public h f5491e;

    /* renamed from: f, reason: collision with root package name */
    public h f5492f;

    public b(ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        this.f5488b = extendedFloatingActionButton;
        this.f5487a = extendedFloatingActionButton.getContext();
        this.f5490d = aVar;
    }

    @Override // c.c.a.c.q.f
    public final void a(h hVar) {
        this.f5492f = hVar;
    }

    @Override // c.c.a.c.q.f
    public void b() {
        this.f5490d.b();
    }

    @Override // c.c.a.c.q.f
    public h e() {
        return this.f5492f;
    }

    @Override // c.c.a.c.q.f
    public AnimatorSet f() {
        return b(i());
    }

    @Override // c.c.a.c.q.f
    public final List<Animator.AnimatorListener> g() {
        return this.f5489c;
    }

    public final h i() {
        h hVar = this.f5492f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f5491e == null) {
            this.f5491e = h.a(this.f5487a, c());
        }
        h hVar2 = this.f5491e;
        a.h.i.h.a(hVar2);
        return hVar2;
    }

    @Override // c.c.a.c.q.f
    public void onAnimationStart(Animator animator) {
        this.f5490d.a(animator);
    }

    @Override // c.c.a.c.q.f
    public void a() {
        this.f5490d.b();
    }

    public AnimatorSet b(h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.c("opacity")) {
            arrayList.add(hVar.a("opacity", (String) this.f5488b, (Property<String, ?>) View.ALPHA));
        }
        if (hVar.c("scale")) {
            arrayList.add(hVar.a("scale", (String) this.f5488b, (Property<String, ?>) View.SCALE_Y));
            arrayList.add(hVar.a("scale", (String) this.f5488b, (Property<String, ?>) View.SCALE_X));
        }
        if (hVar.c("width")) {
            arrayList.add(hVar.a("width", (String) this.f5488b, (Property<String, ?>) ExtendedFloatingActionButton.B));
        }
        if (hVar.c("height")) {
            arrayList.add(hVar.a("height", (String) this.f5488b, (Property<String, ?>) ExtendedFloatingActionButton.C));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        c.c.a.c.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }
}
