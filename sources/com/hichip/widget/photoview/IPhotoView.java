package com.hichip.widget.photoview;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.hichip.widget.photoview.PhotoViewAttacher;

/* loaded from: classes.dex */
public interface IPhotoView {
    public static final float DEFAULT_MAX_SCALE = 3.0f;
    public static final float DEFAULT_MID_SCALE = 1.75f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;
    public static final int DEFAULT_ZOOM_DURATION = 200;

    boolean canZoom();

    Matrix getDisplayMatrix();

    RectF getDisplayRect();

    IPhotoView getIPhotoViewImplementation();

    @Deprecated
    float getMaxScale();

    float getMaximumScale();

    float getMediumScale();

    @Deprecated
    float getMidScale();

    @Deprecated
    float getMinScale();

    float getMinimumScale();

    PhotoViewAttacher.OnPhotoTapListener getOnPhotoTapListener();

    PhotoViewAttacher.OnViewTapListener getOnViewTapListener();

    float getScale();

    ImageView.ScaleType getScaleType();

    Bitmap getVisibleRectangleBitmap();

    void setAllowParentInterceptOnEdge(boolean z);

    boolean setDisplayMatrix(Matrix matrix);

    @Deprecated
    void setMaxScale(float f2);

    void setMaximumScale(float f2);

    void setMediumScale(float f2);

    @Deprecated
    void setMidScale(float f2);

    @Deprecated
    void setMinScale(float f2);

    void setMinimumScale(float f2);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener onMatrixChangedListener);

    void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener onPhotoTapListener);

    void setOnScaleChangeListener(PhotoViewAttacher.OnScaleChangeListener onScaleChangeListener);

    void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener onViewTapListener);

    void setPhotoViewRotation(float f2);

    void setRotationBy(float f2);

    void setRotationTo(float f2);

    void setScale(float f2);

    void setScale(float f2, float f3, float f4, boolean z);

    void setScale(float f2, boolean z);

    void setScaleLevels(float f2, float f3, float f4);

    void setScaleType(ImageView.ScaleType scaleType);

    void setZoomTransitionDuration(int i2);

    void setZoomable(boolean z);
}
