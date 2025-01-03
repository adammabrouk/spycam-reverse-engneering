package a.b.f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;

/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final CompoundButton f463a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f464b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f465c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f466d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f467e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f468f;

    public e(CompoundButton compoundButton) {
        this.f463a = compoundButton;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:3:0x001f, B:5:0x0027, B:8:0x002f, B:11:0x0043, B:13:0x004b, B:15:0x0053, B:16:0x0062, B:18:0x006a, B:19:0x0075, B:21:0x007d), top: B:2:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[Catch: all -> 0x0092, TRY_LEAVE, TryCatch #0 {all -> 0x0092, blocks: (B:3:0x001f, B:5:0x0027, B:8:0x002f, B:11:0x0043, B:13:0x004b, B:15:0x0053, B:16:0x0062, B:18:0x006a, B:19:0x0075, B:21:0x007d), top: B:2:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.f463a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R$styleable.CompoundButton
            r2 = 0
            a.b.f.g0 r0 = a.b.f.g0.a(r0, r11, r1, r12, r2)
            android.widget.CompoundButton r3 = r10.f463a
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R$styleable.CompoundButton
            android.content.res.TypedArray r7 = r0.a()
            r9 = 0
            r6 = r11
            r8 = r12
            a.h.j.y.a(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L92
            boolean r11 = r0.g(r11)     // Catch: java.lang.Throwable -> L92
            if (r11 == 0) goto L40
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L92
            int r11 = r0.g(r11, r2)     // Catch: java.lang.Throwable -> L92
            if (r11 == 0) goto L40
            android.widget.CompoundButton r12 = r10.f463a     // Catch: android.content.res.Resources.NotFoundException -> L40 java.lang.Throwable -> L92
            android.widget.CompoundButton r1 = r10.f463a     // Catch: android.content.res.Resources.NotFoundException -> L40 java.lang.Throwable -> L92
            android.content.Context r1 = r1.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L40 java.lang.Throwable -> L92
            android.graphics.drawable.Drawable r11 = a.b.b.a.a.c(r1, r11)     // Catch: android.content.res.Resources.NotFoundException -> L40 java.lang.Throwable -> L92
            r12.setButtonDrawable(r11)     // Catch: android.content.res.Resources.NotFoundException -> L40 java.lang.Throwable -> L92
            r11 = 1
            goto L41
        L40:
            r11 = 0
        L41:
            if (r11 != 0) goto L62
            int r11 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L92
            boolean r11 = r0.g(r11)     // Catch: java.lang.Throwable -> L92
            if (r11 == 0) goto L62
            int r11 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L92
            int r11 = r0.g(r11, r2)     // Catch: java.lang.Throwable -> L92
            if (r11 == 0) goto L62
            android.widget.CompoundButton r12 = r10.f463a     // Catch: java.lang.Throwable -> L92
            android.widget.CompoundButton r1 = r10.f463a     // Catch: java.lang.Throwable -> L92
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L92
            android.graphics.drawable.Drawable r11 = a.b.b.a.a.c(r1, r11)     // Catch: java.lang.Throwable -> L92
            r12.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L92
        L62:
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L92
            boolean r11 = r0.g(r11)     // Catch: java.lang.Throwable -> L92
            if (r11 == 0) goto L75
            android.widget.CompoundButton r11 = r10.f463a     // Catch: java.lang.Throwable -> L92
            int r12 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L92
            android.content.res.ColorStateList r12 = r0.a(r12)     // Catch: java.lang.Throwable -> L92
            a.h.k.c.a(r11, r12)     // Catch: java.lang.Throwable -> L92
        L75:
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L92
            boolean r11 = r0.g(r11)     // Catch: java.lang.Throwable -> L92
            if (r11 == 0) goto L8e
            android.widget.CompoundButton r11 = r10.f463a     // Catch: java.lang.Throwable -> L92
            int r12 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L92
            r1 = -1
            int r12 = r0.d(r12, r1)     // Catch: java.lang.Throwable -> L92
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = a.b.f.r.a(r12, r1)     // Catch: java.lang.Throwable -> L92
            a.h.k.c.a(r11, r12)     // Catch: java.lang.Throwable -> L92
        L8e:
            r0.b()
            return
        L92:
            r11 = move-exception
            r0.b()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.f.e.a(android.util.AttributeSet, int):void");
    }

    public ColorStateList b() {
        return this.f464b;
    }

    public PorterDuff.Mode c() {
        return this.f465c;
    }

    public void d() {
        if (this.f468f) {
            this.f468f = false;
        } else {
            this.f468f = true;
            a();
        }
    }

    public void a(ColorStateList colorStateList) {
        this.f464b = colorStateList;
        this.f466d = true;
        a();
    }

    public void a(PorterDuff.Mode mode) {
        this.f465c = mode;
        this.f467e = true;
        a();
    }

    public void a() {
        Drawable a2 = a.h.k.c.a(this.f463a);
        if (a2 != null) {
            if (this.f466d || this.f467e) {
                Drawable mutate = a.h.c.l.a.i(a2).mutate();
                if (this.f466d) {
                    a.h.c.l.a.a(mutate, this.f464b);
                }
                if (this.f467e) {
                    a.h.c.l.a.a(mutate, this.f465c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f463a.getDrawableState());
                }
                this.f463a.setButtonDrawable(mutate);
            }
        }
    }

    public int a(int i2) {
        Drawable a2;
        return (Build.VERSION.SDK_INT >= 17 || (a2 = a.h.k.c.a(this.f463a)) == null) ? i2 : i2 + a2.getIntrinsicWidth();
    }
}
