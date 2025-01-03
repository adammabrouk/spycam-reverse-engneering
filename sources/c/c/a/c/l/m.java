package c.c.a.c.l;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* compiled from: PickerFragment.java */
/* loaded from: classes.dex */
public abstract class m<S> extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<l<S>> f5466a = new LinkedHashSet<>();

    public boolean a(l<S> lVar) {
        return this.f5466a.add(lVar);
    }

    public void a() {
        this.f5466a.clear();
    }
}
