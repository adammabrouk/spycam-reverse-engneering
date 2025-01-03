package a.b.e;

import a.b.e.b;
import a.b.e.j.g;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e extends b implements g.a {

    /* renamed from: c, reason: collision with root package name */
    public Context f262c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContextView f263d;

    /* renamed from: e, reason: collision with root package name */
    public b.a f264e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<View> f265f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f266g;

    /* renamed from: h, reason: collision with root package name */
    public a.b.e.j.g f267h;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f262c = context;
        this.f263d = actionBarContextView;
        this.f264e = aVar;
        a.b.e.j.g gVar = new a.b.e.j.g(actionBarContextView.getContext());
        gVar.c(1);
        this.f267h = gVar;
        gVar.a(this);
    }

    @Override // a.b.e.b
    public void a(CharSequence charSequence) {
        this.f263d.setSubtitle(charSequence);
    }

    @Override // a.b.e.b
    public void b(CharSequence charSequence) {
        this.f263d.setTitle(charSequence);
    }

    @Override // a.b.e.b
    public Menu c() {
        return this.f267h;
    }

    @Override // a.b.e.b
    public MenuInflater d() {
        return new g(this.f263d.getContext());
    }

    @Override // a.b.e.b
    public CharSequence e() {
        return this.f263d.getSubtitle();
    }

    @Override // a.b.e.b
    public CharSequence g() {
        return this.f263d.getTitle();
    }

    @Override // a.b.e.b
    public void i() {
        this.f264e.a(this, this.f267h);
    }

    @Override // a.b.e.b
    public boolean j() {
        return this.f263d.c();
    }

    @Override // a.b.e.b
    public void a(int i2) {
        a((CharSequence) this.f262c.getString(i2));
    }

    @Override // a.b.e.b
    public void b(int i2) {
        b(this.f262c.getString(i2));
    }

    @Override // a.b.e.b
    public void a(boolean z) {
        super.a(z);
        this.f263d.setTitleOptional(z);
    }

    @Override // a.b.e.b
    public View b() {
        WeakReference<View> weakReference = this.f265f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // a.b.e.b
    public void a(View view) {
        this.f263d.setCustomView(view);
        this.f265f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // a.b.e.b
    public void a() {
        if (this.f266g) {
            return;
        }
        this.f266g = true;
        this.f263d.sendAccessibilityEvent(32);
        this.f264e.a(this);
    }

    @Override // a.b.e.j.g.a
    public boolean a(a.b.e.j.g gVar, MenuItem menuItem) {
        return this.f264e.a(this, menuItem);
    }

    @Override // a.b.e.j.g.a
    public void a(a.b.e.j.g gVar) {
        i();
        this.f263d.e();
    }
}
