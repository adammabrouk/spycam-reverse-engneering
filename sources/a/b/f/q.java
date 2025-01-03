package a.b.f;

import a.b.e.j.g;
import a.b.e.j.m;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* compiled from: DecorToolbar.java */
/* loaded from: classes.dex */
public interface q {
    a.h.j.c0 a(int i2, long j);

    void a(int i2);

    void a(m.a aVar, g.a aVar2);

    void a(Menu menu, m.a aVar);

    void a(ScrollingTabContainerView scrollingTabContainerView);

    void a(boolean z);

    boolean a();

    void b();

    void b(int i2);

    void b(boolean z);

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    void g();

    CharSequence getTitle();

    ViewGroup h();

    Context i();

    boolean j();

    int k();

    Menu l();

    int m();

    void n();

    void o();

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setVisibility(int i2);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
