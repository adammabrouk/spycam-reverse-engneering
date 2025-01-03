package c.a.a.l.k.h;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import c.a.a.j.a;
import c.a.a.l.k.h.f;

/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class b extends c.a.a.l.k.f.b implements f.c {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f3282a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f3283b;

    /* renamed from: c, reason: collision with root package name */
    public final a f3284c;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.j.a f3285d;

    /* renamed from: e, reason: collision with root package name */
    public final f f3286e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3287f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3288g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3289h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3290i;
    public int j;
    public int k;
    public boolean l;

    /* compiled from: GifDrawable.java */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public c.a.a.j.c f3291a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f3292b;

        /* renamed from: c, reason: collision with root package name */
        public Context f3293c;

        /* renamed from: d, reason: collision with root package name */
        public c.a.a.l.g<Bitmap> f3294d;

        /* renamed from: e, reason: collision with root package name */
        public int f3295e;

        /* renamed from: f, reason: collision with root package name */
        public int f3296f;

        /* renamed from: g, reason: collision with root package name */
        public a.InterfaceC0063a f3297g;

        /* renamed from: h, reason: collision with root package name */
        public c.a.a.l.i.m.c f3298h;

        /* renamed from: i, reason: collision with root package name */
        public Bitmap f3299i;

        public a(c.a.a.j.c cVar, byte[] bArr, Context context, c.a.a.l.g<Bitmap> gVar, int i2, int i3, a.InterfaceC0063a interfaceC0063a, c.a.a.l.i.m.c cVar2, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.f3291a = cVar;
            this.f3292b = bArr;
            this.f3298h = cVar2;
            this.f3299i = bitmap;
            this.f3293c = context.getApplicationContext();
            this.f3294d = gVar;
            this.f3295e = i2;
            this.f3296f = i3;
            this.f3297g = interfaceC0063a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this);
        }
    }

    public b(Context context, a.InterfaceC0063a interfaceC0063a, c.a.a.l.i.m.c cVar, c.a.a.l.g<Bitmap> gVar, int i2, int i3, c.a.a.j.c cVar2, byte[] bArr, Bitmap bitmap) {
        this(new a(cVar2, bArr, context, gVar, i2, i3, interfaceC0063a, cVar, bitmap));
    }

    @Override // c.a.a.l.k.h.f.c
    @TargetApi(11)
    public void a(int i2) {
        if (Build.VERSION.SDK_INT >= 11 && getCallback() == null) {
            stop();
            g();
            return;
        }
        invalidateSelf();
        if (i2 == this.f3285d.d() - 1) {
            this.j++;
        }
        int i3 = this.k;
        if (i3 == -1 || this.j < i3) {
            return;
        }
        stop();
    }

    @Override // c.a.a.l.k.f.b
    public boolean a() {
        return true;
    }

    public byte[] b() {
        return this.f3284c.f3292b;
    }

    public Bitmap c() {
        return this.f3284c.f3299i;
    }

    public int d() {
        return this.f3285d.d();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3289h) {
            return;
        }
        if (this.l) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f3283b);
            this.l = false;
        }
        Bitmap b2 = this.f3286e.b();
        if (b2 == null) {
            b2 = this.f3284c.f3299i;
        }
        canvas.drawBitmap(b2, (Rect) null, this.f3283b, this.f3282a);
    }

    public c.a.a.l.g<Bitmap> e() {
        return this.f3284c.f3294d;
    }

    public void f() {
        this.f3289h = true;
        a aVar = this.f3284c;
        aVar.f3298h.a(aVar.f3299i);
        this.f3286e.a();
        this.f3286e.e();
    }

    public final void g() {
        this.f3286e.a();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f3284c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3284c.f3299i.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3284c.f3299i.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final void h() {
        this.j = 0;
    }

    public final void i() {
        if (this.f3285d.d() == 1) {
            invalidateSelf();
        } else {
            if (this.f3287f) {
                return;
            }
            this.f3287f = true;
            this.f3286e.d();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3287f;
    }

    public final void j() {
        this.f3287f = false;
        this.f3286e.e();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f3282a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3282a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.f3290i = z;
        if (!z) {
            j();
        } else if (this.f3288g) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f3288g = true;
        h();
        if (this.f3290i) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f3288g = false;
        j();
        if (Build.VERSION.SDK_INT < 11) {
            g();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(c.a.a.l.k.h.b r12, android.graphics.Bitmap r13, c.a.a.l.g<android.graphics.Bitmap> r14) {
        /*
            r11 = this;
            c.a.a.l.k.h.b$a r10 = new c.a.a.l.k.h.b$a
            c.a.a.l.k.h.b$a r12 = r12.f3284c
            c.a.a.j.c r1 = r12.f3291a
            byte[] r2 = r12.f3292b
            android.content.Context r3 = r12.f3293c
            int r5 = r12.f3295e
            int r6 = r12.f3296f
            c.a.a.j.a$a r7 = r12.f3297g
            c.a.a.l.i.m.c r8 = r12.f3298h
            r0 = r10
            r4 = r14
            r9 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.<init>(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.l.k.h.b.<init>(c.a.a.l.k.h.b, android.graphics.Bitmap, c.a.a.l.g):void");
    }

    @Override // c.a.a.l.k.f.b
    public void b(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i2 == 0) {
            this.k = this.f3285d.e();
        } else {
            this.k = i2;
        }
    }

    public b(a aVar) {
        this.f3283b = new Rect();
        this.f3290i = true;
        this.k = -1;
        if (aVar != null) {
            this.f3284c = aVar;
            this.f3285d = new c.a.a.j.a(aVar.f3297g);
            this.f3282a = new Paint();
            this.f3285d.a(aVar.f3291a, aVar.f3292b);
            f fVar = new f(aVar.f3293c, this, this.f3285d, aVar.f3295e, aVar.f3296f);
            this.f3286e = fVar;
            fVar.a(aVar.f3294d);
            return;
        }
        throw new NullPointerException("GifState must not be null");
    }
}
