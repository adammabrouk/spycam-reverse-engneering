package a.b.e.j;

import a.b.e.j.m;
import a.b.e.j.n;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter.java */
/* loaded from: classes.dex */
public abstract class b implements m {

    /* renamed from: a, reason: collision with root package name */
    public Context f311a;

    /* renamed from: b, reason: collision with root package name */
    public Context f312b;

    /* renamed from: c, reason: collision with root package name */
    public g f313c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f314d;

    /* renamed from: e, reason: collision with root package name */
    public m.a f315e;

    /* renamed from: f, reason: collision with root package name */
    public int f316f;

    /* renamed from: g, reason: collision with root package name */
    public int f317g;

    /* renamed from: h, reason: collision with root package name */
    public n f318h;

    /* renamed from: i, reason: collision with root package name */
    public int f319i;

    public b(Context context, int i2, int i3) {
        this.f311a = context;
        this.f314d = LayoutInflater.from(context);
        this.f316f = i2;
        this.f317g = i3;
    }

    public abstract void a(i iVar, n.a aVar);

    @Override // a.b.e.j.m
    public void a(Context context, g gVar) {
        this.f312b = context;
        LayoutInflater.from(context);
        this.f313c = gVar;
    }

    public abstract boolean a(int i2, i iVar);

    @Override // a.b.e.j.m
    public boolean a(g gVar, i iVar) {
        return false;
    }

    public n b(ViewGroup viewGroup) {
        if (this.f318h == null) {
            n nVar = (n) this.f314d.inflate(this.f316f, viewGroup, false);
            this.f318h = nVar;
            nVar.a(this.f313c);
            a(true);
        }
        return this.f318h;
    }

    @Override // a.b.e.j.m
    public boolean b(g gVar, i iVar) {
        return false;
    }

    @Override // a.b.e.j.m
    public int c() {
        return this.f319i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.b.e.j.m
    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f318h;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f313c;
        int i2 = 0;
        if (gVar != null) {
            gVar.b();
            ArrayList<i> n = this.f313c.n();
            int size = n.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                i iVar = n.get(i4);
                if (a(i3, iVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View a2 = a(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        a2.setPressed(false);
                        a2.jumpDrawablesToCurrentState();
                    }
                    if (a2 != childAt) {
                        a(a2, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!a(viewGroup, i2)) {
                i2++;
            }
        }
    }

    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f318h).addView(view, i2);
    }

    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    @Override // a.b.e.j.m
    public void a(m.a aVar) {
        this.f315e = aVar;
    }

    public m.a a() {
        return this.f315e;
    }

    public n.a a(ViewGroup viewGroup) {
        return (n.a) this.f314d.inflate(this.f317g, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        if (view instanceof n.a) {
            aVar = (n.a) view;
        } else {
            aVar = a(viewGroup);
        }
        a(iVar, aVar);
        return (View) aVar;
    }

    @Override // a.b.e.j.m
    public void a(g gVar, boolean z) {
        m.a aVar = this.f315e;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [a.b.e.j.g] */
    @Override // a.b.e.j.m
    public boolean a(r rVar) {
        m.a aVar = this.f315e;
        r rVar2 = rVar;
        if (aVar == null) {
            return false;
        }
        if (rVar == null) {
            rVar2 = this.f313c;
        }
        return aVar.a(rVar2);
    }

    public void a(int i2) {
        this.f319i = i2;
    }
}
