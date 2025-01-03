package androidx.appcompat.widget;

import a.b.f.b0;
import a.b.f.d;
import a.b.f.d0;
import a.b.f.h;
import a.h.j.x;
import a.h.k.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements x, m {
    public final d mBackgroundTintHelper;
    public final h mImageHelper;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a();
        }
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // a.h.k.m
    public ColorStateList getSupportImageTintList() {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            return hVar.b();
        }
        return null;
    }

    @Override // a.h.k.m
    public PorterDuff.Mode getSupportImageTintMode() {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.d() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    @Override // a.h.k.m
    public void setSupportImageTintList(ColorStateList colorStateList) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a(colorStateList);
        }
    }

    @Override // a.h.k.m
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.a(mode);
        }
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i2) {
        super(d0.b(context), attributeSet, i2);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.mBackgroundTintHelper = dVar;
        dVar.a(attributeSet, i2);
        h hVar = new h(this);
        this.mImageHelper = hVar;
        hVar.a(attributeSet, i2);
    }
}
