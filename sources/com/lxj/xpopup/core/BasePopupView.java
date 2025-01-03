package com.lxj.xpopup.core;

import a.k.a.r;
import a.m.f;
import a.m.h;
import a.m.p;
import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.e.b.e.i;
import c.e.b.g.c;
import com.lxj.xpopup.impl.FullScreenPopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BasePopupView extends FrameLayout implements h {

    /* renamed from: a, reason: collision with root package name */
    public c.e.b.c.b f10740a;

    /* renamed from: b, reason: collision with root package name */
    public c.e.b.b.c f10741b;

    /* renamed from: c, reason: collision with root package name */
    public c.e.b.b.f f10742c;

    /* renamed from: d, reason: collision with root package name */
    public c.e.b.b.a f10743d;

    /* renamed from: e, reason: collision with root package name */
    public int f10744e;

    /* renamed from: f, reason: collision with root package name */
    public c.e.b.d.e f10745f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10746g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10747h;

    /* renamed from: i, reason: collision with root package name */
    public int f10748i;
    public Handler j;
    public boolean k;
    public final Runnable l;
    public c.e.b.c.a m;
    public final Runnable n;
    public Runnable o;
    public g p;
    public Runnable q;
    public Runnable r;
    public float t;
    public float u;

    public class a implements Runnable {

        /* renamed from: com.lxj.xpopup.core.BasePopupView$a$a, reason: collision with other inner class name */
        public class C0161a implements c.b {
            public C0161a() {
            }

            @Override // c.e.b.g.c.b
            public void onSoftInputChanged(int i2) {
                i iVar;
                BasePopupView.this.a(i2);
                BasePopupView basePopupView = BasePopupView.this;
                c.e.b.c.b bVar = basePopupView.f10740a;
                if (bVar != null && (iVar = bVar.r) != null) {
                    iVar.a(basePopupView, i2);
                }
                if (i2 == 0) {
                    c.e.b.g.e.c(BasePopupView.this);
                    BasePopupView.this.k = false;
                    return;
                }
                if (BasePopupView.this.k) {
                    return;
                }
                BasePopupView basePopupView2 = BasePopupView.this;
                if ((basePopupView2 instanceof FullScreenPopupView) && basePopupView2.f10745f == c.e.b.d.e.Showing) {
                    return;
                }
                BasePopupView basePopupView3 = BasePopupView.this;
                if ((basePopupView3 instanceof PartShadowPopupView) && basePopupView3.f10745f == c.e.b.d.e.Showing) {
                    return;
                }
                c.e.b.g.e.b(i2, BasePopupView.this);
                BasePopupView.this.k = true;
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePopupView.this.d();
            c.e.b.g.c.a(BasePopupView.this.getHostWindow(), BasePopupView.this, new C0161a());
            BasePopupView.this.p();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BasePopupView.this.getHostWindow() == null) {
                return;
            }
            BasePopupView basePopupView = BasePopupView.this;
            i iVar = basePopupView.f10740a.r;
            if (iVar != null) {
                iVar.d(basePopupView);
            }
            BasePopupView basePopupView2 = BasePopupView.this;
            if (!(basePopupView2 instanceof FullScreenPopupView)) {
                basePopupView2.n();
            }
            BasePopupView basePopupView3 = BasePopupView.this;
            if ((basePopupView3 instanceof AttachPopupView) || (basePopupView3 instanceof PositionPopupView) || (basePopupView3 instanceof PartShadowPopupView)) {
                return;
            }
            basePopupView3.q();
            BasePopupView.this.m();
            BasePopupView.this.k();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar;
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f10745f = c.e.b.d.e.Show;
            basePopupView.v();
            BasePopupView basePopupView2 = BasePopupView.this;
            if (basePopupView2 instanceof FullScreenPopupView) {
                basePopupView2.n();
            }
            BasePopupView basePopupView3 = BasePopupView.this;
            c.e.b.c.b bVar = basePopupView3.f10740a;
            if (bVar != null && (iVar = bVar.r) != null) {
                iVar.f(basePopupView3);
            }
            if (BasePopupView.this.getHostWindow() == null || c.e.b.g.e.a(BasePopupView.this.getHostWindow()) <= 0 || BasePopupView.this.k) {
                return;
            }
            c.e.b.g.e.b(c.e.b.g.e.a(BasePopupView.this.getHostWindow()), BasePopupView.this);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View findViewById;
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f10745f = c.e.b.d.e.Dismiss;
            c.e.b.c.b bVar = basePopupView.f10740a;
            if (bVar == null) {
                return;
            }
            if (bVar.q.booleanValue()) {
                BasePopupView basePopupView2 = BasePopupView.this;
                if (basePopupView2 instanceof PartShadowPopupView) {
                    c.e.b.g.c.a(basePopupView2);
                }
            }
            BasePopupView.this.u();
            c.e.b.a.f6200e = null;
            BasePopupView basePopupView3 = BasePopupView.this;
            i iVar = basePopupView3.f10740a.r;
            if (iVar != null) {
                iVar.c(basePopupView3);
            }
            Runnable runnable = BasePopupView.this.r;
            if (runnable != null) {
                runnable.run();
                BasePopupView.this.r = null;
            }
            BasePopupView basePopupView4 = BasePopupView.this;
            if (basePopupView4.f10740a.C && basePopupView4.getWindowDecorView() != null && (findViewById = BasePopupView.this.getWindowDecorView().findViewById(R.id.content)) != null) {
                findViewById.setFocusable(true);
                findViewById.setFocusableInTouchMode(true);
            }
            BasePopupView.this.g();
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10754a;

        static {
            int[] iArr = new int[c.e.b.d.c.values().length];
            f10754a = iArr;
            try {
                iArr[c.e.b.d.c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10754a[c.e.b.d.c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10754a[c.e.b.d.c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10754a[c.e.b.d.c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10754a[c.e.b.d.c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10754a[c.e.b.d.c.TranslateAlphaFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10754a[c.e.b.d.c.TranslateAlphaFromTop.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10754a[c.e.b.d.c.TranslateAlphaFromRight.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10754a[c.e.b.d.c.TranslateAlphaFromBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10754a[c.e.b.d.c.TranslateFromLeft.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10754a[c.e.b.d.c.TranslateFromTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10754a[c.e.b.d.c.TranslateFromRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10754a[c.e.b.d.c.TranslateFromBottom.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10754a[c.e.b.d.c.ScrollAlphaFromLeft.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10754a[c.e.b.d.c.ScrollAlphaFromLeftTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10754a[c.e.b.d.c.ScrollAlphaFromTop.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f10754a[c.e.b.d.c.ScrollAlphaFromRightTop.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f10754a[c.e.b.d.c.ScrollAlphaFromRight.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f10754a[c.e.b.d.c.ScrollAlphaFromRightBottom.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f10754a[c.e.b.d.c.ScrollAlphaFromBottom.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f10754a[c.e.b.d.c.ScrollAlphaFromLeftBottom.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f10754a[c.e.b.d.c.NoAnimation.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    public class f implements View.OnKeyListener {
        public f() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            c.e.b.c.b bVar;
            if (i2 != 4 || keyEvent.getAction() != 1 || (bVar = BasePopupView.this.f10740a) == null) {
                return false;
            }
            if (bVar.f6242b.booleanValue()) {
                BasePopupView basePopupView = BasePopupView.this;
                i iVar = basePopupView.f10740a.r;
                if (iVar == null || !iVar.b(basePopupView)) {
                    BasePopupView.this.i();
                }
            }
            return true;
        }
    }

    public static class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public View f10756a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10757b = false;

        public g(View view) {
            this.f10756a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f10756a;
            if (view == null || this.f10757b) {
                return;
            }
            this.f10757b = true;
            c.e.b.g.c.b(view);
        }
    }

    public BasePopupView(Context context) {
        super(context);
        this.f10745f = c.e.b.d.e.Dismiss;
        this.f10746g = false;
        this.f10747h = false;
        this.f10748i = -1;
        this.j = new Handler(Looper.getMainLooper());
        this.k = false;
        this.l = new a();
        this.n = new b();
        this.o = new c();
        this.q = new d();
        if (context == null) {
            return;
        }
        if (context instanceof Application) {
            throw new IllegalArgumentException("XPopup的Context必须是Activity类型！");
        }
        this.f10744e = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f10742c = new c.e.b.b.f(this);
        View inflate = LayoutInflater.from(context).inflate(getPopupLayoutId(), (ViewGroup) this, false);
        inflate.setAlpha(0.0f);
        addView(inflate);
    }

    public void a(int i2) {
    }

    public void b() {
    }

    public void c() {
    }

    public final void d() {
        if (getContext() instanceof FragmentActivity) {
            ((FragmentActivity) getContext()).getLifecycle().a(this);
        }
        if (this.f10740a.K) {
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
        } else {
            if (this.m == null) {
                c.e.b.c.a aVar = new c.e.b.c.a(getContext());
                aVar.a(this);
                this.m = aVar;
            }
            this.m.show();
        }
        if (this.f10740a == null) {
            throw new IllegalArgumentException("如果弹窗对象是复用的，则不要设置isDestroyOnDismiss(true)");
        }
    }

    public void e() {
    }

    public void f() {
        View view;
        View view2;
        View view3;
        c.e.b.c.b bVar = this.f10740a;
        if (bVar != null) {
            bVar.f6247g = null;
            bVar.f6248h = null;
            bVar.r = null;
            c.e.b.b.c cVar = bVar.j;
            if (cVar != null && (view3 = cVar.f6205a) != null) {
                view3.animate().cancel();
            }
            if (this.f10740a.I) {
                this.f10740a = null;
            }
        }
        c.e.b.c.a aVar = this.m;
        if (aVar != null) {
            aVar.f6240a = null;
            this.m = null;
        }
        c.e.b.b.f fVar = this.f10742c;
        if (fVar != null && (view2 = fVar.f6205a) != null) {
            view2.animate().cancel();
        }
        c.e.b.b.a aVar2 = this.f10743d;
        if (aVar2 == null || (view = aVar2.f6205a) == null) {
            return;
        }
        view.animate().cancel();
        Bitmap bitmap = this.f10743d.f6203c;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f10743d.f6203c.recycle();
        this.f10743d.f6203c = null;
    }

    public final void g() {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null || !bVar.K) {
            c.e.b.c.a aVar = this.m;
            if (aVar != null) {
                aVar.dismiss();
                return;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public int getAnimationDuration() {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null || bVar.f6249i != c.e.b.d.c.NoAnimation) {
            return 10 + c.e.b.a.a();
        }
        return 10;
    }

    public Window getHostWindow() {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar != null && bVar.K) {
            return ((Activity) getContext()).getWindow();
        }
        c.e.b.c.a aVar = this.m;
        if (aVar == null) {
            return null;
        }
        return aVar.getWindow();
    }

    public int getImplLayoutId() {
        return -1;
    }

    public List<String> getInternalFragmentNames() {
        return null;
    }

    public int getMaxHeight() {
        return this.f10740a.m;
    }

    public int getMaxWidth() {
        return this.f10740a.l;
    }

    public c.e.b.b.c getPopupAnimator() {
        return null;
    }

    public View getPopupContentView() {
        return getChildAt(0);
    }

    public int getPopupHeight() {
        return this.f10740a.o;
    }

    public View getPopupImplView() {
        return ((ViewGroup) getPopupContentView()).getChildAt(0);
    }

    public abstract int getPopupLayoutId();

    public int getPopupWidth() {
        return this.f10740a.n;
    }

    public View getWindowDecorView() {
        if (getHostWindow() == null) {
            return null;
        }
        return (ViewGroup) getHostWindow().getDecorView();
    }

    public void h() {
        i iVar;
        c.e.b.c.b bVar = this.f10740a;
        if (bVar != null && bVar.K) {
            x();
        }
        this.j.removeCallbacks(this.l);
        this.j.removeCallbacks(this.n);
        c.e.b.d.e eVar = this.f10745f;
        if (eVar == c.e.b.d.e.Dismissing || eVar == c.e.b.d.e.Dismiss) {
            return;
        }
        this.f10745f = c.e.b.d.e.Dismissing;
        clearFocus();
        c.e.b.c.b bVar2 = this.f10740a;
        if (bVar2 != null && (iVar = bVar2.r) != null) {
            iVar.e(this);
        }
        e();
        l();
        j();
    }

    public void i() {
        if (c.e.b.g.c.f6302a == 0) {
            h();
        } else {
            c.e.b.g.c.a(this);
        }
    }

    public void j() {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar != null && bVar.q.booleanValue() && !(this instanceof PartShadowPopupView)) {
            c.e.b.g.c.a(this);
        }
        this.j.removeCallbacks(this.q);
        this.j.postDelayed(this.q, getAnimationDuration());
    }

    public void k() {
        this.j.removeCallbacks(this.o);
        this.j.postDelayed(this.o, getAnimationDuration());
    }

    public void l() {
        c.e.b.b.a aVar;
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null) {
            return;
        }
        if (bVar.f6245e.booleanValue() && !this.f10740a.f6246f.booleanValue()) {
            this.f10742c.a();
        } else if (this.f10740a.f6246f.booleanValue() && (aVar = this.f10743d) != null) {
            aVar.a();
        }
        c.e.b.b.c cVar = this.f10741b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void m() {
        c.e.b.b.a aVar;
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null) {
            return;
        }
        if (bVar.f6245e.booleanValue() && !this.f10740a.f6246f.booleanValue()) {
            this.f10742c.b();
        } else if (this.f10740a.f6246f.booleanValue() && (aVar = this.f10743d) != null) {
            aVar.b();
        }
        c.e.b.b.c cVar = this.f10741b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void n() {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null || !bVar.C) {
            return;
        }
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new f());
        if (!this.f10740a.D) {
            a((View) this);
        }
        ArrayList arrayList = new ArrayList();
        c.e.b.g.e.a((ArrayList<EditText>) arrayList, (ViewGroup) getPopupContentView());
        if (arrayList.size() > 0) {
            this.f10748i = getHostWindow().getAttributes().softInputMode;
            getHostWindow().setSoftInputMode(16);
            this.f10747h = true;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            EditText editText = (EditText) arrayList.get(i2);
            editText.setOnKeyListener(new f());
            if (i2 == 0 && this.f10740a.D && !editText.hasFocus()) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                a(editText);
            }
        }
    }

    public c.e.b.b.c o() {
        c.e.b.d.c cVar;
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null || (cVar = bVar.f6249i) == null) {
            return null;
        }
        switch (e.f10754a[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new c.e.b.b.d(getPopupContentView(), this.f10740a.f6249i);
            case 6:
            case 7:
            case 8:
            case 9:
                return new c.e.b.b.g(getPopupContentView(), this.f10740a.f6249i);
            case 10:
            case 11:
            case 12:
            case 13:
                return new c.e.b.b.h(getPopupContentView(), this.f10740a.f6249i);
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return new c.e.b.b.e(getPopupContentView(), this.f10740a.f6249i);
            case 22:
                return new c.e.b.b.b(getPopupContentView());
            default:
                return null;
        }
    }

    @p(f.b.ON_DESTROY)
    public void onDestroy() {
        onDetachedFromWindow();
        g();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j.removeCallbacksAndMessages(null);
        if (this.f10740a != null) {
            if (getWindowDecorView() != null) {
                c.e.b.g.c.a(getWindowDecorView(), this);
            }
            if (this.f10740a.K && this.f10747h) {
                getHostWindow().setSoftInputMode(this.f10748i);
                this.f10747h = false;
            }
            if (this.f10740a.I) {
                f();
            }
        }
        if (getContext() != null && (getContext() instanceof FragmentActivity)) {
            ((FragmentActivity) getContext()).getLifecycle().b(this);
        }
        this.f10745f = c.e.b.d.e.Dismiss;
        this.p = null;
        this.k = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c.e.b.c.b bVar;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        getPopupContentView().getGlobalVisibleRect(rect);
        if (!c.e.b.g.e.a(motionEvent.getX(), motionEvent.getY(), rect)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.t = motionEvent.getX();
                this.u = motionEvent.getY();
                a(motionEvent);
            } else if (action == 1 || action == 2 || action == 3) {
                float sqrt = (float) Math.sqrt(Math.pow(motionEvent.getX() - this.t, 2.0d) + Math.pow(motionEvent.getY() - this.u, 2.0d));
                if (!c.e.b.g.e.a(motionEvent.getX(), motionEvent.getY(), rect2)) {
                    a(motionEvent);
                }
                if (sqrt < this.f10744e && (bVar = this.f10740a) != null && bVar.f6243c.booleanValue()) {
                    h();
                    getPopupImplView().getGlobalVisibleRect(rect2);
                }
                this.t = 0.0f;
                this.u = 0.0f;
            }
        }
        return true;
    }

    public void p() {
        if (this.f10740a.f6246f.booleanValue()) {
            c.e.b.b.a aVar = new c.e.b.b.a(this);
            this.f10743d = aVar;
            aVar.f6204d = this.f10740a.f6245e.booleanValue();
            this.f10743d.f6203c = c.e.b.g.e.b(c.e.b.g.e.a((View) this).getWindow().getDecorView());
        }
        if ((this instanceof AttachPopupView) || (this instanceof PartShadowPopupView) || (this instanceof PositionPopupView)) {
            r();
        } else if (!this.f10746g) {
            r();
        }
        if (!this.f10746g) {
            this.f10746g = true;
            t();
            i iVar = this.f10740a.r;
            if (iVar != null) {
                iVar.a(this);
            }
        }
        this.j.postDelayed(this.n, 10L);
    }

    public void q() {
        c.e.b.b.a aVar;
        getPopupContentView().setAlpha(1.0f);
        c.e.b.b.c cVar = this.f10740a.j;
        if (cVar != null) {
            this.f10741b = cVar;
            cVar.f6205a = getPopupContentView();
        } else {
            c.e.b.b.c o = o();
            this.f10741b = o;
            if (o == null) {
                this.f10741b = getPopupAnimator();
            }
        }
        if (this.f10740a.f6245e.booleanValue()) {
            this.f10742c.c();
        }
        if (this.f10740a.f6246f.booleanValue() && (aVar = this.f10743d) != null) {
            aVar.c();
        }
        c.e.b.b.c cVar2 = this.f10741b;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    public void r() {
    }

    public boolean s() {
        return this.f10745f != c.e.b.d.e.Dismiss;
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public BasePopupView w() {
        c.e.b.c.b bVar;
        c.e.b.d.e eVar;
        c.e.b.c.a aVar;
        Activity a2 = c.e.b.g.e.a((View) this);
        if (a2 != null && !a2.isFinishing() && (bVar = this.f10740a) != null && (eVar = this.f10745f) != c.e.b.d.e.Showing && eVar != c.e.b.d.e.Dismissing) {
            this.f10745f = c.e.b.d.e.Showing;
            if (!bVar.K && (aVar = this.m) != null && aVar.isShowing()) {
                return this;
            }
            this.j.post(this.l);
        }
        return this;
    }

    public void x() {
        if (getContext() instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
            List<Fragment> A = supportFragmentManager.A();
            List<String> internalFragmentNames = getInternalFragmentNames();
            if (A == null || A.size() <= 0 || internalFragmentNames == null) {
                return;
            }
            for (int i2 = 0; i2 < A.size(); i2++) {
                if (internalFragmentNames.contains(A.get(i2).getClass().getSimpleName())) {
                    r b2 = supportFragmentManager.b();
                    b2.d(A.get(i2));
                    b2.b();
                }
            }
        }
    }

    public void a(View view) {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null || !bVar.q.booleanValue()) {
            return;
        }
        g gVar = this.p;
        if (gVar == null) {
            this.p = new g(view);
        } else {
            this.j.removeCallbacks(gVar);
        }
        this.j.postDelayed(this.p, 10L);
    }

    public final void a(MotionEvent motionEvent) {
        c.e.b.c.b bVar = this.f10740a;
        if (bVar == null || !bVar.E) {
            return;
        }
        if (bVar.K) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != this) {
                    childAt.dispatchTouchEvent(motionEvent);
                }
            }
            return;
        }
        ((Activity) getContext()).dispatchTouchEvent(motionEvent);
    }
}
