package c.c.a.c.r;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* compiled from: TextDrawableHelper.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    public float f5579c;

    /* renamed from: f, reason: collision with root package name */
    public c.c.a.c.t.d f5582f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f5577a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.c.t.f f5578b = new a();

    /* renamed from: d, reason: collision with root package name */
    public boolean f5580d = true;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<b> f5581e = new WeakReference<>(null);

    /* compiled from: TextDrawableHelper.java */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public j(b bVar) {
        a(bVar);
    }

    public TextPaint b() {
        return this.f5577a;
    }

    /* compiled from: TextDrawableHelper.java */
    public class a extends c.c.a.c.t.f {
        public a() {
        }

        @Override // c.c.a.c.t.f
        public void a(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            j.this.f5580d = true;
            b bVar = (b) j.this.f5581e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c.c.a.c.t.f
        public void a(int i2) {
            j.this.f5580d = true;
            b bVar = (b) j.this.f5581e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void a(b bVar) {
        this.f5581e = new WeakReference<>(bVar);
    }

    public void a(boolean z) {
        this.f5580d = z;
    }

    public float a(String str) {
        if (!this.f5580d) {
            return this.f5579c;
        }
        float a2 = a((CharSequence) str);
        this.f5579c = a2;
        this.f5580d = false;
        return a2;
    }

    public final float a(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f5577a.measureText(charSequence, 0, charSequence.length());
    }

    public c.c.a.c.t.d a() {
        return this.f5582f;
    }

    public void a(c.c.a.c.t.d dVar, Context context) {
        if (this.f5582f != dVar) {
            this.f5582f = dVar;
            if (dVar != null) {
                dVar.c(context, this.f5577a, this.f5578b);
                b bVar = this.f5581e.get();
                if (bVar != null) {
                    this.f5577a.drawableState = bVar.getState();
                }
                dVar.b(context, this.f5577a, this.f5578b);
                this.f5580d = true;
            }
            b bVar2 = this.f5581e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void a(Context context) {
        this.f5582f.b(context, this.f5577a, this.f5578b);
    }
}
