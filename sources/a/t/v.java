package a.t;

import android.view.ViewGroup;
import androidx.transition.R$id;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f1891a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f1892b;

    public void a() {
        Runnable runnable;
        if (a(this.f1891a) != this || (runnable = this.f1892b) == null) {
            return;
        }
        runnable.run();
    }

    public static void a(ViewGroup viewGroup, v vVar) {
        viewGroup.setTag(R$id.transition_current_scene, vVar);
    }

    public static v a(ViewGroup viewGroup) {
        return (v) viewGroup.getTag(R$id.transition_current_scene);
    }
}
