package c.c.a.c.j;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import c.c.a.c.j.c;

/* compiled from: CircularRevealHelper.java */
/* loaded from: classes.dex */
public class b {
    public static final int j;

    /* renamed from: a, reason: collision with root package name */
    public final a f5381a;

    /* renamed from: b, reason: collision with root package name */
    public final View f5382b;

    /* renamed from: c, reason: collision with root package name */
    public final Path f5383c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f5384d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f5385e;

    /* renamed from: f, reason: collision with root package name */
    public c.e f5386f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f5387g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5388h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5389i;

    /* compiled from: CircularRevealHelper.java */
    public interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            j = 2;
        } else if (i2 >= 18) {
            j = 1;
        } else {
            j = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f5381a = aVar;
        View view = (View) aVar;
        this.f5382b = view;
        view.setWillNotDraw(false);
        this.f5383c = new Path();
        this.f5384d = new Paint(7);
        Paint paint = new Paint(1);
        this.f5385e = paint;
        paint.setColor(0);
    }

    public void a() {
        if (j == 0) {
            this.f5388h = true;
            this.f5389i = false;
            this.f5382b.buildDrawingCache();
            Bitmap drawingCache = this.f5382b.getDrawingCache();
            if (drawingCache == null && this.f5382b.getWidth() != 0 && this.f5382b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f5382b.getWidth(), this.f5382b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f5382b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f5384d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f5388h = false;
            this.f5389i = true;
        }
    }

    public void b() {
        if (j == 0) {
            this.f5389i = false;
            this.f5382b.destroyDrawingCache();
            this.f5384d.setShader(null);
            this.f5382b.invalidate();
        }
    }

    public Drawable c() {
        return this.f5387g;
    }

    public int d() {
        return this.f5385e.getColor();
    }

    public c.e e() {
        c.e eVar = this.f5386f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.f5396c = a(eVar2);
        }
        return eVar2;
    }

    public final void f() {
        if (j == 1) {
            this.f5383c.rewind();
            c.e eVar = this.f5386f;
            if (eVar != null) {
                this.f5383c.addCircle(eVar.f5394a, eVar.f5395b, eVar.f5396c, Path.Direction.CW);
            }
        }
        this.f5382b.invalidate();
    }

    public boolean g() {
        return this.f5381a.c() && !h();
    }

    public final boolean h() {
        c.e eVar = this.f5386f;
        boolean z = eVar == null || eVar.a();
        return j == 0 ? !z && this.f5389i : !z;
    }

    public final boolean i() {
        return (this.f5388h || this.f5387g == null || this.f5386f == null) ? false : true;
    }

    public final boolean j() {
        return (this.f5388h || Color.alpha(this.f5385e.getColor()) == 0) ? false : true;
    }

    public void b(c.e eVar) {
        if (eVar == null) {
            this.f5386f = null;
        } else {
            c.e eVar2 = this.f5386f;
            if (eVar2 == null) {
                this.f5386f = new c.e(eVar);
            } else {
                eVar2.a(eVar);
            }
            if (c.c.a.c.s.a.a(eVar.f5396c, a(eVar), 1.0E-4f)) {
                this.f5386f.f5396c = Float.MAX_VALUE;
            }
        }
        f();
    }

    public void a(int i2) {
        this.f5385e.setColor(i2);
        this.f5382b.invalidate();
    }

    public void a(Drawable drawable) {
        this.f5387g = drawable;
        this.f5382b.invalidate();
    }

    public final void b(Canvas canvas) {
        if (i()) {
            Rect bounds = this.f5387g.getBounds();
            float width = this.f5386f.f5394a - (bounds.width() / 2.0f);
            float height = this.f5386f.f5395b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f5387g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public final float a(c.e eVar) {
        return c.c.a.c.s.a.a(eVar.f5394a, eVar.f5395b, 0.0f, 0.0f, this.f5382b.getWidth(), this.f5382b.getHeight());
    }

    public void a(Canvas canvas) {
        if (h()) {
            int i2 = j;
            if (i2 == 0) {
                c.e eVar = this.f5386f;
                canvas.drawCircle(eVar.f5394a, eVar.f5395b, eVar.f5396c, this.f5384d);
                if (j()) {
                    c.e eVar2 = this.f5386f;
                    canvas.drawCircle(eVar2.f5394a, eVar2.f5395b, eVar2.f5396c, this.f5385e);
                }
            } else if (i2 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.f5383c);
                this.f5381a.a(canvas);
                if (j()) {
                    canvas.drawRect(0.0f, 0.0f, this.f5382b.getWidth(), this.f5382b.getHeight(), this.f5385e);
                }
                canvas.restoreToCount(save);
            } else if (i2 == 2) {
                this.f5381a.a(canvas);
                if (j()) {
                    canvas.drawRect(0.0f, 0.0f, this.f5382b.getWidth(), this.f5382b.getHeight(), this.f5385e);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + j);
            }
        } else {
            this.f5381a.a(canvas);
            if (j()) {
                canvas.drawRect(0.0f, 0.0f, this.f5382b.getWidth(), this.f5382b.getHeight(), this.f5385e);
            }
        }
        b(canvas);
    }
}
