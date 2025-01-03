package c.e.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import c.e.b.c.b;
import c.e.b.d.f;
import c.e.b.e.c;
import com.lxj.xpopup.impl.ConfirmPopupView;
import com.lxj.xpopup.impl.LoadingPopupView;

/* compiled from: XPopup.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f6196a = Color.parseColor("#121212");

    /* renamed from: b, reason: collision with root package name */
    public static int f6197b = 350;

    /* renamed from: c, reason: collision with root package name */
    public static int f6198c = Color.parseColor("#55000000");

    /* renamed from: d, reason: collision with root package name */
    public static int f6199d = Color.parseColor("#7F000000");

    /* renamed from: e, reason: collision with root package name */
    public static PointF f6200e = null;

    /* compiled from: XPopup.java */
    /* renamed from: c.e.b.a$a, reason: collision with other inner class name */
    public static class C0120a {

        /* renamed from: a, reason: collision with root package name */
        public final b f6201a = new b();

        /* renamed from: b, reason: collision with root package name */
        public Context f6202b;

        public C0120a(Context context) {
            this.f6202b = context;
        }

        public C0120a a(f fVar) {
            this.f6201a.f6241a = fVar;
            return this;
        }

        public C0120a b(Boolean bool) {
            this.f6201a.f6243c = bool;
            return this;
        }

        public C0120a a(Boolean bool) {
            this.f6201a.f6242b = bool;
            return this;
        }

        public C0120a a(boolean z) {
            this.f6201a.I = z;
            return this;
        }

        public ConfirmPopupView a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, c cVar, c.e.b.e.a aVar, boolean z, int i2) {
            a(f.Center);
            ConfirmPopupView confirmPopupView = new ConfirmPopupView(this.f6202b, i2);
            confirmPopupView.a(charSequence, charSequence2, null);
            confirmPopupView.a(charSequence3);
            confirmPopupView.b(charSequence4);
            confirmPopupView.a(cVar, aVar);
            confirmPopupView.N = z;
            confirmPopupView.f10740a = this.f6201a;
            return confirmPopupView;
        }

        public ConfirmPopupView a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, c cVar, c.e.b.e.a aVar, boolean z) {
            return a(charSequence, charSequence2, charSequence3, charSequence4, cVar, aVar, z, 0);
        }

        public LoadingPopupView a(CharSequence charSequence, int i2) {
            a(f.Center);
            LoadingPopupView loadingPopupView = new LoadingPopupView(this.f6202b, i2);
            loadingPopupView.a(charSequence);
            loadingPopupView.f10740a = this.f6201a;
            return loadingPopupView;
        }

        public LoadingPopupView a(CharSequence charSequence) {
            return a(charSequence, 0);
        }
    }

    public static int a() {
        return f6197b;
    }

    public static int b() {
        return f6196a;
    }

    public static int c() {
        return f6199d;
    }
}
