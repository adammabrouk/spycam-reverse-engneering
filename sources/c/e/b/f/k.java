package c.e.b.f;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener, View.OnLayoutChangeListener {
    public static float P = 4.0f;
    public static float Q = 2.5f;
    public static float R = 1.0f;
    public static int S = 200;
    public static int T = 1;
    public float C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public float N;
    public float O;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f6273h;

    /* renamed from: i, reason: collision with root package name */
    public GestureDetector f6274i;
    public c.e.b.f.b j;
    public c.e.b.f.d p;
    public c.e.b.f.f q;
    public c.e.b.f.e r;
    public j t;
    public View.OnClickListener u;
    public View.OnLongClickListener v;
    public g w;
    public h x;
    public i y;
    public f z;

    /* renamed from: a, reason: collision with root package name */
    public Interpolator f6266a = new AccelerateDecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public int f6267b = S;

    /* renamed from: c, reason: collision with root package name */
    public float f6268c = R;

    /* renamed from: d, reason: collision with root package name */
    public float f6269d = Q;

    /* renamed from: e, reason: collision with root package name */
    public float f6270e = P;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6271f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6272g = false;
    public final Matrix k = new Matrix();
    public final Matrix l = new Matrix();
    public final Matrix m = new Matrix();
    public final RectF n = new RectF();
    public final float[] o = new float[9];
    public int A = 2;
    public int B = 2;
    public boolean J = true;
    public boolean K = false;
    public ImageView.ScaleType L = ImageView.ScaleType.FIT_CENTER;
    public c.e.b.f.c M = new a();

    /* compiled from: PhotoViewAttacher.java */
    public class a implements c.e.b.f.c {
        public a() {
        }

        @Override // c.e.b.f.c
        public void onDrag(float f2, float f3) {
            if (k.this.j.b()) {
                return;
            }
            if (k.this.y != null) {
                k.this.y.onDrag(f2, f3);
            }
            k.this.m.postTranslate(f2, f3);
            k.this.b();
            k kVar = k.this;
            kVar.D = kVar.B == 0 && k.this.j() != 1.0f;
            k kVar2 = k.this;
            kVar2.E = kVar2.B == 1 && k.this.j() != 1.0f;
            k kVar3 = k.this;
            kVar3.F = kVar3.A == 0 && k.this.j() != 1.0f;
            k kVar4 = k.this;
            kVar4.G = kVar4.A == 1 && k.this.j() != 1.0f;
            ViewParent parent = k.this.f6273h.getParent();
            if (parent == null) {
                return;
            }
            if (!k.this.f6271f || k.this.j.b() || k.this.f6272g) {
                if (k.this.A == 2 && k.this.K && k.this.I) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                }
                if ((k.this.A != 1 && k.this.A != 0) || k.this.K || k.this.I) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                } else {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                }
            }
            if ((k.this.A == 2 && !k.this.K) || ((k.this.A == 0 && f2 >= 0.0f && k.this.I) || (k.this.A == 1 && f2 <= -0.0f && k.this.I))) {
                parent.requestDisallowInterceptTouchEvent(false);
                return;
            }
            if (k.this.B != 2 || !k.this.H) {
                k kVar5 = k.this;
                if (!kVar5.D || f3 <= 0.0f || !kVar5.H) {
                    k kVar6 = k.this;
                    if (!kVar6.E || f3 >= 0.0f || !kVar6.H) {
                        if (k.this.K) {
                            if ((k.this.B == 0 && f3 > 0.0f && k.this.H) || (k.this.B == 1 && f3 < 0.0f && k.this.H)) {
                                parent.requestDisallowInterceptTouchEvent(false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            parent.requestDisallowInterceptTouchEvent(false);
        }

        @Override // c.e.b.f.c
        public void onFling(float f2, float f3, float f4, float f5) {
            k kVar = k.this;
            kVar.z = kVar.new f(kVar.f6273h.getContext());
            f fVar = k.this.z;
            k kVar2 = k.this;
            int b2 = kVar2.b(kVar2.f6273h);
            k kVar3 = k.this;
            fVar.a(b2, kVar3.a(kVar3.f6273h), (int) f4, (int) f5);
            k.this.f6273h.post(k.this.z);
        }

        @Override // c.e.b.f.c
        public void onScale(float f2, float f3, float f4) {
            if (k.this.j() < k.this.f6270e || f2 < 1.0f) {
                if (k.this.w != null) {
                    k.this.w.onScaleChange(f2, f3, f4);
                }
                k.this.m.postScale(f2, f2, f3, f4);
                k.this.b();
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (k.this.x == null || k.this.j() > k.R || motionEvent.getPointerCount() > k.T || motionEvent2.getPointerCount() > k.T) {
                return false;
            }
            return k.this.x.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (k.this.v != null) {
                k.this.v.onLongClick(k.this.f6273h);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float j = k.this.j();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (j < k.this.h()) {
                    k.this.a(k.this.h(), x, y, true);
                } else if (j < k.this.h() || j >= k.this.g()) {
                    k.this.a(k.this.i(), x, y, true);
                } else {
                    k.this.a(k.this.g(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (k.this.u != null) {
                k.this.u.onClick(k.this.f6273h);
            }
            RectF d2 = k.this.d();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (k.this.t != null) {
                k.this.t.onViewTap(k.this.f6273h, x, y);
            }
            if (d2 == null) {
                return false;
            }
            if (!d2.contains(x, y)) {
                if (k.this.r == null) {
                    return false;
                }
                k.this.r.a(k.this.f6273h);
                return false;
            }
            float width = (x - d2.left) / d2.width();
            float height = (y - d2.top) / d2.height();
            if (k.this.q == null) {
                return true;
            }
            k.this.q.a(k.this.f6273h, width, height);
            return true;
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6278a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f6278a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6278a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6278a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6278a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final float f6279a;

        /* renamed from: b, reason: collision with root package name */
        public final float f6280b;

        /* renamed from: c, reason: collision with root package name */
        public final long f6281c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        public final float f6282d;

        /* renamed from: e, reason: collision with root package name */
        public final float f6283e;

        public e(float f2, float f3, float f4, float f5) {
            this.f6279a = f4;
            this.f6280b = f5;
            this.f6282d = f2;
            this.f6283e = f3;
        }

        public final float a() {
            return k.this.f6266a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f6281c) * 1.0f) / k.this.f6267b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float a2 = a();
            float f2 = this.f6282d;
            k.this.M.onScale((f2 + ((this.f6283e - f2) * a2)) / k.this.j(), this.f6279a, this.f6280b);
            if (a2 < 1.0f) {
                c.e.b.f.a.a(k.this.f6273h, this);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final OverScroller f6285a;

        /* renamed from: b, reason: collision with root package name */
        public int f6286b;

        /* renamed from: c, reason: collision with root package name */
        public int f6287c;

        public f(Context context) {
            this.f6285a = new OverScroller(context);
        }

        public void a() {
            this.f6285a.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f6285a.isFinished() && this.f6285a.computeScrollOffset()) {
                int currX = this.f6285a.getCurrX();
                int currY = this.f6285a.getCurrY();
                k.this.m.postTranslate(this.f6286b - currX, this.f6287c - currY);
                k.this.b();
                this.f6286b = currX;
                this.f6287c = currY;
                c.e.b.f.a.a(k.this.f6273h, this);
            }
        }

        public void a(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF d2 = k.this.d();
            if (d2 == null) {
                return;
            }
            int round = Math.round(-d2.left);
            float f2 = i2;
            if (f2 < d2.width()) {
                i7 = Math.round(d2.width() - f2);
                i6 = 0;
            } else {
                i6 = round;
                i7 = i6;
            }
            int round2 = Math.round(-d2.top);
            float f3 = i3;
            if (f3 < d2.height()) {
                i9 = Math.round(d2.height() - f3);
                i8 = 0;
            } else {
                i8 = round2;
                i9 = i8;
            }
            this.f6286b = round;
            this.f6287c = round2;
            if (round == i7 && round2 == i9) {
                return;
            }
            this.f6285a.fling(round, round2, i4, i5, i6, i7, i8, i9, 0, 0);
        }
    }

    public k(ImageView imageView) {
        this.f6273h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.C = 0.0f;
        this.j = new c.e.b.f.b(imageView.getContext(), this.M);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f6274i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        a(this.f6273h.getDrawable());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (r0 != 3) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0120  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.b.f.k.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f6274i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.v = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c.e.b.f.d dVar) {
        this.p = dVar;
    }

    public void setOnOutsidePhotoTapListener(c.e.b.f.e eVar) {
        this.r = eVar;
    }

    public void setOnPhotoTapListener(c.e.b.f.f fVar) {
        this.q = fVar;
    }

    public void setOnScaleChangeListener(g gVar) {
        this.w = gVar;
    }

    public void setOnSingleFlingListener(h hVar) {
        this.x = hVar;
    }

    public void setOnViewDragListener(i iVar) {
        this.y = iVar;
    }

    public void setOnViewTapListener(j jVar) {
        this.t = jVar;
    }

    public boolean c(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.f6273h.getDrawable() == null) {
            return false;
        }
        this.m.set(matrix);
        b();
        return true;
    }

    public RectF d() {
        c();
        return a(e());
    }

    public void e(float f2) {
        this.m.setRotate(f2 % 360.0f);
        b();
    }

    public void f(float f2) {
        a(f2, false);
    }

    public float g() {
        return this.f6270e;
    }

    public float h() {
        return this.f6269d;
    }

    public float i() {
        return this.f6268c;
    }

    public float j() {
        return (float) Math.sqrt(((float) Math.pow(a(this.m, 0), 2.0d)) + ((float) Math.pow(a(this.m, 3), 2.0d)));
    }

    public ImageView.ScaleType k() {
        return this.L;
    }

    public final void l() {
        this.m.reset();
        d(this.C);
        d(e());
        c();
    }

    public void m() {
        if (this.J) {
            a(this.f6273h.getDrawable());
        } else {
            l();
        }
    }

    public void b(float f2) {
        l.a(this.f6268c, f2, this.f6270e);
        this.f6269d = f2;
    }

    public Matrix f() {
        return this.l;
    }

    public void a(boolean z) {
        this.f6271f = z;
    }

    public void d(float f2) {
        this.m.postRotate(f2 % 360.0f);
        b();
    }

    public final Matrix e() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    public void a(float f2) {
        l.a(this.f6268c, this.f6269d, f2);
        this.f6270e = f2;
    }

    public void b(boolean z) {
        this.J = z;
        m();
    }

    public void c(float f2) {
        l.a(f2, this.f6269d, this.f6270e);
        this.f6268c = f2;
    }

    public final void d(Matrix matrix) {
        RectF a2;
        this.f6273h.setImageMatrix(matrix);
        if (this.p == null || (a2 = a(matrix)) == null) {
            return;
        }
        this.p.onMatrixChanged(a2);
    }

    public void a(float f2, boolean z) {
        a(f2, this.f6273h.getRight() / 2, this.f6273h.getBottom() / 2, z);
    }

    public void b(Matrix matrix) {
        matrix.set(this.m);
    }

    public void a(float f2, float f3, float f4, boolean z) {
        if (z) {
            this.f6273h.post(new e(j(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            b();
        }
    }

    public final void b() {
        if (c()) {
            d(e());
        }
    }

    public final boolean c() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF a2 = a(e());
        if (a2 == null) {
            return false;
        }
        float height = a2.height();
        float width = a2.width();
        float a3 = a(this.f6273h);
        float f7 = 0.0f;
        if (height <= a3 && a2.top >= 0.0f) {
            int i2 = d.f6278a[this.L.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f5 = (a3 - height) / 2.0f;
                    f6 = a2.top;
                } else {
                    f5 = a3 - height;
                    f6 = a2.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -a2.top;
            }
            this.B = 2;
        } else {
            float f8 = a2.top;
            if (f8 >= 0.0f) {
                this.B = 0;
                f2 = -f8;
            } else {
                float f9 = a2.bottom;
                if (f9 <= a3) {
                    this.B = 1;
                    f2 = a3 - f9;
                } else {
                    this.B = -1;
                    f2 = 0.0f;
                }
            }
        }
        float b2 = b(this.f6273h);
        if (width <= b2 && a2.left >= 0.0f) {
            int i3 = d.f6278a[this.L.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (b2 - width) / 2.0f;
                    f4 = a2.left;
                } else {
                    f3 = b2 - width;
                    f4 = a2.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -a2.left;
            }
            this.A = 2;
        } else {
            float f10 = a2.left;
            if (f10 >= 0.0f) {
                this.A = 0;
                f7 = -f10;
            } else {
                float f11 = a2.right;
                if (f11 <= b2) {
                    f7 = b2 - f11;
                    this.A = 1;
                } else {
                    this.A = -1;
                }
            }
        }
        this.m.postTranslate(f7, f2);
        return true;
    }

    public final int b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!l.a(scaleType) || scaleType == this.L) {
            return;
        }
        this.L = scaleType;
        m();
    }

    public void a(int i2) {
        this.f6267b = i2;
    }

    public float a(Matrix matrix, int i2) {
        matrix.getValues(this.o);
        return this.o[i2];
    }

    public final RectF a(Matrix matrix) {
        if (this.f6273h.getDrawable() == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    public final void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float b2 = b(this.f6273h);
        float a2 = a(this.f6273h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.k.reset();
        float f2 = intrinsicWidth;
        float f3 = b2 / f2;
        float f4 = intrinsicHeight;
        float f5 = a2 / f4;
        ImageView.ScaleType scaleType = this.L;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.k.postTranslate((b2 - f2) / 2.0f, (a2 - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f3, f5);
            this.k.postScale(max, max);
            this.k.postTranslate((b2 - (f2 * max)) / 2.0f, (a2 - (f4 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f3, f5));
            this.k.postScale(min, min);
            this.k.postTranslate((b2 - (f2 * min)) / 2.0f, (a2 - (f4 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, b2, a2);
            if (((int) this.C) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = d.f6278a[this.L.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            } else if (f4 > a2 && (f4 * 1.0f) / f2 > (a2 * 1.0f) / b2) {
                this.K = true;
                this.k.setRectToRect(rectF, new RectF(0.0f, 0.0f, b2, f4 * f3), Matrix.ScaleToFit.START);
            } else {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        l();
    }

    public final int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final void a() {
        f fVar = this.z;
        if (fVar != null) {
            fVar.a();
            this.z = null;
        }
    }
}
