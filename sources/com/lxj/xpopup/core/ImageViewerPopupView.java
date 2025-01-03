package com.lxj.xpopup.core;

import a.t.a0;
import a.t.w;
import a.t.x;
import a.t.y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import c.e.b.e.h;
import c.e.b.e.j;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.photoview.PhotoView;
import com.lxj.xpopup.util.XPermission;
import com.lxj.xpopup.widget.BlankView;
import com.lxj.xpopup.widget.HackyViewPager;
import com.lxj.xpopup.widget.PhotoViewContainer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ImageViewerPopupView extends BasePopupView implements c.e.b.e.d, View.OnClickListener {
    public HackyViewPager A;
    public ArgbEvaluator B;
    public List<Object> C;
    public j D;
    public h E;
    public int F;
    public Rect G;
    public ImageView H;
    public PhotoView I;
    public boolean J;
    public int K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public View Q;
    public int R;
    public c.e.b.e.e S;
    public ViewPager.m T;
    public FrameLayout v;
    public PhotoViewContainer w;
    public BlankView x;
    public TextView y;
    public TextView z;

    public class a extends ViewPager.m {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.m, androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i2) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.F = i2;
            imageViewerPopupView.B();
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            h hVar = imageViewerPopupView2.E;
            if (hVar != null) {
                hVar.a(imageViewerPopupView2, i2);
            }
        }
    }

    public class b implements Runnable {

        public class a extends x {
            public a() {
            }

            @Override // a.t.w.f
            public void e(w wVar) {
                ImageViewerPopupView.this.A.setVisibility(0);
                ImageViewerPopupView.this.I.setVisibility(4);
                ImageViewerPopupView.this.B();
                ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
                imageViewerPopupView.w.isReleasing = false;
                ImageViewerPopupView.super.k();
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) ImageViewerPopupView.this.I.getParent();
            a0 a0Var = new a0();
            a0Var.a(ImageViewerPopupView.this.getDuration());
            a0Var.a(new a.t.d());
            a0Var.a(new a.t.f());
            a0Var.a(new a.t.e());
            y.a(viewGroup, a0Var.a((TimeInterpolator) new a.l.a.a.b()).a((w.f) new a()));
            ImageViewerPopupView.this.I.setTranslationY(0.0f);
            ImageViewerPopupView.this.I.setTranslationX(0.0f);
            ImageViewerPopupView.this.I.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            c.e.b.g.e.a(imageViewerPopupView.I, imageViewerPopupView.w.getWidth(), ImageViewerPopupView.this.w.getHeight());
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            imageViewerPopupView2.b(imageViewerPopupView2.R);
            View view = ImageViewerPopupView.this.Q;
            if (view != null) {
                view.animate().alpha(1.0f).setDuration(ImageViewerPopupView.this.getDuration()).start();
            }
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f10765a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10766b;

        public c(int i2, int i3) {
            this.f10765a = i2;
            this.f10766b = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.w.setBackgroundColor(((Integer) imageViewerPopupView.B.evaluate(valueAnimator.getAnimatedFraction(), Integer.valueOf(this.f10765a), Integer.valueOf(this.f10766b))).intValue());
        }
    }

    public class d implements Runnable {

        public class a extends x {
            public a() {
            }

            @Override // a.t.w.f
            public void e(w wVar) {
                ImageViewerPopupView.this.j();
                ImageViewerPopupView.this.A.setVisibility(4);
                ImageViewerPopupView.this.I.setVisibility(0);
                ImageViewerPopupView.this.A.setScaleX(1.0f);
                ImageViewerPopupView.this.A.setScaleY(1.0f);
                ImageViewerPopupView.this.I.setScaleX(1.0f);
                ImageViewerPopupView.this.I.setScaleY(1.0f);
                ImageViewerPopupView.this.x.setVisibility(4);
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View view = ImageViewerPopupView.this.Q;
                if (view != null) {
                    view.setVisibility(4);
                }
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) ImageViewerPopupView.this.I.getParent();
            a0 a0Var = new a0();
            a0Var.a(ImageViewerPopupView.this.getDuration());
            a0Var.a(new a.t.d());
            a0Var.a(new a.t.f());
            a0Var.a(new a.t.e());
            y.a(viewGroup, a0Var.a((TimeInterpolator) new a.l.a.a.b()).a((w.f) new a()));
            ImageViewerPopupView.this.I.setScaleX(1.0f);
            ImageViewerPopupView.this.I.setScaleY(1.0f);
            ImageViewerPopupView.this.I.setTranslationY(r0.G.top);
            ImageViewerPopupView.this.I.setTranslationX(r0.G.left);
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.I.setScaleType(imageViewerPopupView.H.getScaleType());
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            c.e.b.g.e.a(imageViewerPopupView2.I, imageViewerPopupView2.G.width(), ImageViewerPopupView.this.G.height());
            ImageViewerPopupView.this.b(0);
            View view = ImageViewerPopupView.this.Q;
            if (view != null) {
                view.animate().alpha(0.0f).setDuration(ImageViewerPopupView.this.getDuration()).setListener(new b()).start();
            }
        }
    }

    public class e implements XPermission.d {
        public e() {
        }

        @Override // com.lxj.xpopup.util.XPermission.d
        public void a() {
            XPermission.l().e();
            Context context = ImageViewerPopupView.this.getContext();
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            j jVar = imageViewerPopupView.D;
            List<Object> list = imageViewerPopupView.C;
            boolean z = imageViewerPopupView.P;
            int i2 = imageViewerPopupView.F;
            if (z) {
                i2 %= list.size();
            }
            c.e.b.g.e.a(context, jVar, list.get(i2));
        }

        @Override // com.lxj.xpopup.util.XPermission.d
        public void b() {
            XPermission.l().e();
            Toast.makeText(ImageViewerPopupView.this.getContext(), "没有保存权限，保存功能无法使用！", 0).show();
        }
    }

    public class f extends a.x.a.a {

        public class a implements c.e.b.f.d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PhotoView f10773a;

            public a(PhotoView photoView) {
                this.f10773a = photoView;
            }

            @Override // c.e.b.f.d
            public void onMatrixChanged(RectF rectF) {
                if (ImageViewerPopupView.this.I != null) {
                    Matrix matrix = new Matrix();
                    this.f10773a.a(matrix);
                    ImageViewerPopupView.this.I.b(matrix);
                }
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerPopupView.this.h();
            }
        }

        public class c implements View.OnLongClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f10776a;

            public c(int i2) {
                this.f10776a = i2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
                imageViewerPopupView.S.a(imageViewerPopupView, this.f10776a);
                return false;
            }
        }

        public f() {
        }

        @Override // a.x.a.a
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // a.x.a.a
        public int getCount() {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            if (imageViewerPopupView.P) {
                return 1073741823;
            }
            return imageViewerPopupView.C.size();
        }

        @Override // a.x.a.a
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            PhotoView photoView = new PhotoView(viewGroup.getContext());
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            j jVar = imageViewerPopupView.D;
            if (jVar != null) {
                List<Object> list = imageViewerPopupView.C;
                jVar.a(i2, list.get(imageViewerPopupView.P ? i2 % list.size() : i2), photoView);
            }
            photoView.setOnMatrixChangeListener(new a(photoView));
            viewGroup.addView(photoView);
            photoView.setOnClickListener(new b());
            if (ImageViewerPopupView.this.S != null) {
                photoView.setOnLongClickListener(new c(i2));
            }
            return photoView;
        }

        @Override // a.x.a.a
        public boolean isViewFromObject(View view, Object obj) {
            return obj == view;
        }
    }

    public ImageViewerPopupView(Context context) {
        super(context);
        this.B = new ArgbEvaluator();
        this.C = new ArrayList();
        this.G = null;
        this.J = true;
        this.K = Color.parseColor("#f1f1f1");
        this.L = -1;
        this.M = -1;
        this.N = true;
        this.O = true;
        this.P = false;
        this.R = Color.rgb(32, 36, 46);
        this.T = new a();
        this.v = (FrameLayout) findViewById(R$id.container);
        if (getImplLayoutId() > 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.v, false);
            this.Q = inflate;
            inflate.setVisibility(4);
            this.Q.setAlpha(0.0f);
            this.v.addView(this.Q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDuration() {
        return c.e.b.a.a() + 60;
    }

    public final void A() {
        this.x.setVisibility(this.J ? 0 : 4);
        if (this.J) {
            int i2 = this.K;
            if (i2 != -1) {
                this.x.color = i2;
            }
            int i3 = this.M;
            if (i3 != -1) {
                this.x.radius = i3;
            }
            int i4 = this.L;
            if (i4 != -1) {
                this.x.strokeColor = i4;
            }
            c.e.b.g.e.a(this.x, this.G.width(), this.G.height());
            this.x.setTranslationX(this.G.left);
            this.x.setTranslationY(this.G.top);
            this.x.invalidate();
        }
    }

    public final void B() {
        if (this.C.size() > 1) {
            int size = this.P ? this.F % this.C.size() : this.F;
            this.y.setText((size + 1) + "/" + this.C.size());
        }
        if (this.N) {
            this.z.setVisibility(0);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void f() {
        super.f();
        this.A.removeOnPageChangeListener(this.T);
        this.D = null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupLayoutId() {
        return R$layout._xpopup_image_viewer_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void h() {
        if (this.f10745f != c.e.b.d.e.Show) {
            return;
        }
        this.f10745f = c.e.b.d.e.Dismissing;
        l();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void k() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void l() {
        if (this.H == null) {
            this.w.setBackgroundColor(0);
            j();
            this.A.setVisibility(4);
            this.x.setVisibility(4);
            return;
        }
        this.y.setVisibility(4);
        this.z.setVisibility(4);
        this.A.setVisibility(4);
        this.w.isReleasing = true;
        this.I.setVisibility(0);
        this.I.post(new d());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void m() {
        if (this.H == null) {
            this.w.setBackgroundColor(this.R);
            this.A.setVisibility(0);
            B();
            this.w.isReleasing = false;
            super.k();
            return;
        }
        this.w.isReleasing = true;
        View view = this.Q;
        if (view != null) {
            view.setVisibility(0);
        }
        this.I.setVisibility(0);
        this.I.post(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.z) {
            z();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void r() {
        super.r();
        this.y = (TextView) findViewById(R$id.tv_pager_indicator);
        this.z = (TextView) findViewById(R$id.tv_save);
        this.x = (BlankView) findViewById(R$id.placeholderView);
        PhotoViewContainer photoViewContainer = (PhotoViewContainer) findViewById(R$id.photoViewContainer);
        this.w = photoViewContainer;
        photoViewContainer.setOnDragChangeListener(this);
        HackyViewPager hackyViewPager = (HackyViewPager) findViewById(R$id.pager);
        this.A = hackyViewPager;
        hackyViewPager.setAdapter(new f());
        this.A.setCurrentItem(this.F);
        this.A.setVisibility(4);
        y();
        if (this.P) {
            this.A.setOffscreenPageLimit(this.C.size() / 2);
        }
        this.A.addOnPageChangeListener(this.T);
        if (!this.O) {
            this.y.setVisibility(8);
        }
        if (this.N) {
            this.z.setOnClickListener(this);
        } else {
            this.z.setVisibility(8);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void u() {
        super.u();
        this.H = null;
        this.E = null;
    }

    public final void y() {
        if (this.H == null) {
            return;
        }
        if (this.I == null) {
            PhotoView photoView = new PhotoView(getContext());
            this.I = photoView;
            this.w.addView(photoView);
            this.I.setScaleType(this.H.getScaleType());
            this.I.setTranslationX(this.G.left);
            this.I.setTranslationY(this.G.top);
            c.e.b.g.e.a(this.I, this.G.width(), this.G.height());
        }
        A();
        j jVar = this.D;
        if (jVar != null) {
            int i2 = this.F;
            jVar.a(i2, this.C.get(i2), this.I);
        }
    }

    public void z() {
        XPermission a2 = XPermission.a(getContext(), "android.permission-group.STORAGE");
        a2.a(new e());
        a2.f();
    }

    public final void b(int i2) {
        int color = ((ColorDrawable) this.w.getBackground()).getColor();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new c(color, i2));
        ofFloat.setDuration(getDuration()).setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    @Override // c.e.b.e.d
    public void a() {
        h();
    }

    @Override // c.e.b.e.d
    public void a(int i2, float f2, float f3) {
        float f4 = 1.0f - f3;
        this.y.setAlpha(f4);
        View view = this.Q;
        if (view != null) {
            view.setAlpha(f4);
        }
        if (this.N) {
            this.z.setAlpha(f4);
        }
        this.w.setBackgroundColor(((Integer) this.B.evaluate(f3 * 0.8f, Integer.valueOf(this.R), 0)).intValue());
    }
}
