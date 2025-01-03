package c.e.b.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import c.e.b.g.e;
import com.lxj.xpopup.R$style;
import com.lxj.xpopup.core.BasePopupView;

/* compiled from: FullScreenDialog.java */
/* loaded from: classes.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public BasePopupView f6240a;

    public a(Context context) {
        super(context, R$style._XPopup_TransparentDialog);
    }

    public void a(int i2, boolean z) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (z) {
            attributes.flags = i2 | attributes.flags;
        } else {
            attributes.flags = (i2 ^ (-1)) & attributes.flags;
        }
        getWindow().setAttributes(attributes);
    }

    public void b() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 6914);
    }

    public boolean c() {
        return Build.VERSION.SDK_INT >= 23 && (((Activity) this.f6240a.getContext()).getWindow().getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    public boolean d() {
        boolean z = Build.MODEL.contains("X") || Build.MODEL.contains("x");
        if (!c.e.b.g.a.e()) {
            return false;
        }
        int i2 = Build.VERSION.SDK_INT;
        return (i2 == 26 || i2 == 27) && !z;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (d()) {
            motionEvent.setLocation(motionEvent.getX(), motionEvent.getY() + e.c());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        BasePopupView basePopupView;
        b bVar;
        super.onCreate(bundle);
        if (getWindow() == null || (basePopupView = this.f6240a) == null || (bVar = basePopupView.f10740a) == null) {
            return;
        }
        if (bVar.G) {
            if (Build.VERSION.SDK_INT >= 26) {
                getWindow().setType(2038);
            } else {
                getWindow().setType(2003);
            }
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setFlags(16777216, 16777216);
        getWindow().setSoftInputMode(16);
        if (d()) {
            getWindow().getDecorView().setTranslationY(-e.c());
            getWindow().setLayout(-1, Math.max(e.a(getContext()), e.b(getContext())));
        } else {
            getWindow().setLayout(-1, Math.max(e.a(getContext()), e.b(getContext())));
        }
        getWindow().getDecorView().setSystemUiVisibility(1280);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19 && i2 < 21) {
            a(201326592, true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a(201326592, false);
            getWindow().setStatusBarColor(0);
            if (this.f6240a.f10740a.x != 0) {
                getWindow().setNavigationBarColor(this.f6240a.f10740a.x);
            }
            getWindow().addFlags(Integer.MIN_VALUE);
        }
        if (Build.VERSION.SDK_INT == 19) {
            getWindow().clearFlags(67108864);
        }
        if (!this.f6240a.f10740a.w.booleanValue()) {
            b();
        }
        if (!this.f6240a.f10740a.C) {
            getWindow().setFlags(8, 8);
        }
        a();
        setContentView(this.f6240a);
    }

    public void a() {
        if (!this.f6240a.f10740a.v.booleanValue()) {
            getWindow().setFlags(1024, 1024);
        } else if (Build.VERSION.SDK_INT >= 23) {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(c() ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public a a(BasePopupView basePopupView) {
        if (basePopupView.getParent() != null) {
            ((ViewGroup) basePopupView.getParent()).removeView(basePopupView);
        }
        this.f6240a = basePopupView;
        return this;
    }
}
