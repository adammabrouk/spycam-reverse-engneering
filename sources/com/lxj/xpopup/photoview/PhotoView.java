package com.lxj.xpopup.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import c.e.b.f.d;
import c.e.b.f.e;
import c.e.b.f.f;
import c.e.b.f.g;
import c.e.b.f.h;
import c.e.b.f.i;
import c.e.b.f.j;
import c.e.b.f.k;

/* loaded from: classes.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    public k f10797a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView.ScaleType f10798b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public void a(Matrix matrix) {
        this.f10797a.b(matrix);
    }

    public final void b() {
        this.f10797a = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f10798b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f10798b = null;
        }
    }

    public k getAttacher() {
        return this.f10797a;
    }

    public RectF getDisplayRect() {
        return this.f10797a.d();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f10797a.f();
    }

    public float getMaximumScale() {
        return this.f10797a.g();
    }

    public float getMediumScale() {
        return this.f10797a.h();
    }

    public float getMinimumScale() {
        return this.f10797a.i();
    }

    public float getScale() {
        return this.f10797a.j();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f10797a.k();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f10797a.a(z);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.f10797a.m();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f10797a;
        if (kVar != null) {
            kVar.m();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        k kVar = this.f10797a;
        if (kVar != null) {
            kVar.m();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f10797a;
        if (kVar != null) {
            kVar.m();
        }
    }

    public void setMaximumScale(float f2) {
        this.f10797a.a(f2);
    }

    public void setMediumScale(float f2) {
        this.f10797a.b(f2);
    }

    public void setMinimumScale(float f2) {
        this.f10797a.c(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f10797a.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f10797a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f10797a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f10797a.setOnMatrixChangeListener(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f10797a.setOnOutsidePhotoTapListener(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f10797a.setOnPhotoTapListener(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f10797a.setOnScaleChangeListener(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f10797a.setOnSingleFlingListener(hVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f10797a.setOnViewDragListener(iVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f10797a.setOnViewTapListener(jVar);
    }

    public void setRotationBy(float f2) {
        this.f10797a.d(f2);
    }

    public void setRotationTo(float f2) {
        this.f10797a.e(f2);
    }

    public void setScale(float f2) {
        this.f10797a.f(f2);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f10797a;
        if (kVar == null) {
            this.f10798b = scaleType;
        } else {
            kVar.a(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i2) {
        this.f10797a.a(i2);
    }

    public void setZoomable(boolean z) {
        this.f10797a.b(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    public boolean b(Matrix matrix) {
        return this.f10797a.c(matrix);
    }
}
