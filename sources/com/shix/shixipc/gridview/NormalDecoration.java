package com.shix.shixipc.gridview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class NormalDecoration extends RecyclerView.n {
    public GestureDetector gestureDetector;
    public OnHeaderClickListener headerClickEvent;
    public OnDecorationHeadDraw headerDrawEvent;
    public Paint mHeaderContentPaint;
    public Paint mHeaderTxtPaint;
    public RecyclerView mRecyclerView;
    public final float txtYAxis;
    public String TAG = "QDX";
    public int headerHeight = 136;
    public int textPaddingLeft = 50;
    public int textSize = 50;
    public int textColor = -16777216;
    public int headerContentColor = -1118482;
    public boolean isInitHeight = false;
    public SparseArray<Integer> stickyHeaderPosArray = new SparseArray<>();
    public Map<Integer, View> headViewMap = new HashMap();
    public GestureDetector.OnGestureListener gestureListener = new GestureDetector.OnGestureListener() { // from class: com.shix.shixipc.gridview.NormalDecoration.2
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            for (int i2 = 0; i2 < NormalDecoration.this.stickyHeaderPosArray.size(); i2++) {
                int intValue = ((Integer) NormalDecoration.this.stickyHeaderPosArray.valueAt(i2)).intValue();
                float y = motionEvent.getY();
                NormalDecoration normalDecoration = NormalDecoration.this;
                if (intValue - normalDecoration.headerHeight <= y && y <= intValue) {
                    if (normalDecoration.headerClickEvent == null) {
                        return true;
                    }
                    NormalDecoration.this.headerClickEvent.headerClick(NormalDecoration.this.stickyHeaderPosArray.keyAt(i2));
                    return true;
                }
            }
            return false;
        }
    };
    public Map<String, Drawable> imgDrawableMap = new HashMap();

    public interface OnDecorationHeadDraw {
        View getHeaderView(int i2);
    }

    public interface OnHeaderClickListener {
        void headerClick(int i2);
    }

    public NormalDecoration() {
        Paint paint = new Paint(1);
        this.mHeaderTxtPaint = paint;
        paint.setColor(this.textColor);
        this.mHeaderTxtPaint.setTextSize(this.textSize);
        this.mHeaderTxtPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mHeaderContentPaint = paint2;
        paint2.setColor(this.headerContentColor);
        Paint.FontMetrics fontMetrics = this.mHeaderTxtPaint.getFontMetrics();
        float f2 = -fontMetrics.ascent;
        float f3 = fontMetrics.descent;
        this.txtYAxis = ((f2 + f3) / 2.0f) - f3;
    }

    private Drawable getImg(String str) {
        return this.imgDrawableMap.get(str);
    }

    public abstract String getHeaderName(int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        super.getItemOffsets(rect, view, recyclerView, zVar);
        if (this.mRecyclerView == null) {
            this.mRecyclerView = recyclerView;
        }
        OnDecorationHeadDraw onDecorationHeadDraw = this.headerDrawEvent;
        if (onDecorationHeadDraw != null && !this.isInitHeight) {
            View headerView = onDecorationHeadDraw.getHeaderView(0);
            headerView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.headerHeight = headerView.getMeasuredHeight();
            this.isInitHeight = true;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        String headerName = getHeaderName(childAdapterPosition);
        if (headerName == null) {
            return;
        }
        if (childAdapterPosition == 0 || !headerName.equals(getHeaderName(childAdapterPosition - 1))) {
            rect.top = this.headerHeight;
        }
    }

    public void onDestory() {
        this.headViewMap.clear();
        this.imgDrawableMap.clear();
        this.stickyHeaderPosArray.clear();
        this.mRecyclerView = null;
        setOnHeaderClickListener(null);
        setOnDecorationHeadDraw(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        RecyclerView recyclerView2 = recyclerView;
        super.onDrawOver(canvas, recyclerView, zVar);
        if (this.mRecyclerView == null) {
            this.mRecyclerView = recyclerView2;
        }
        if (this.gestureDetector == null) {
            this.gestureDetector = new GestureDetector(recyclerView.getContext(), this.gestureListener);
            recyclerView2.setOnTouchListener(new View.OnTouchListener() { // from class: com.shix.shixipc.gridview.NormalDecoration.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return NormalDecoration.this.gestureDetector.onTouchEvent(motionEvent);
                }
            });
        }
        this.stickyHeaderPosArray.clear();
        int childCount = recyclerView.getChildCount();
        int left = recyclerView.getLeft() + recyclerView.getPaddingLeft();
        int right = recyclerView.getRight() - recyclerView.getPaddingRight();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        String str2 = null;
        while (i10 < childCount) {
            View childAt = recyclerView2.getChildAt(i10);
            int childAdapterPosition = recyclerView2.getChildAdapterPosition(childAt);
            String headerName = getHeaderName(childAdapterPosition);
            if (i10 == 0) {
                str = headerName;
                i2 = childAdapterPosition;
            } else {
                str = str2;
                i2 = i8;
            }
            if (headerName != null) {
                int paddingTop = recyclerView.getPaddingTop() + childAt.getTop();
                if (childAdapterPosition == 0 || !headerName.equals(getHeaderName(childAdapterPosition - 1))) {
                    if (this.headerDrawEvent != null) {
                        if (this.headViewMap.get(Integer.valueOf(childAdapterPosition)) == null) {
                            View headerView = this.headerDrawEvent.getHeaderView(childAdapterPosition);
                            headerView.measure(View.MeasureSpec.makeMeasureSpec(i7, i7), View.MeasureSpec.makeMeasureSpec(i7, i7));
                            headerView.setDrawingCacheEnabled(true);
                            headerView.layout(i7, i7, right, this.headerHeight);
                            this.headViewMap.put(Integer.valueOf(childAdapterPosition), headerView);
                            canvas.drawBitmap(headerView.getDrawingCache(), left, paddingTop - this.headerHeight, (Paint) null);
                        } else {
                            canvas.drawBitmap(this.headViewMap.get(Integer.valueOf(childAdapterPosition)).getDrawingCache(), left, paddingTop - this.headerHeight, (Paint) null);
                        }
                        i4 = paddingTop;
                        i6 = i9;
                        i3 = childCount;
                        i5 = childAdapterPosition;
                    } else {
                        i4 = paddingTop;
                        i3 = childCount;
                        i5 = childAdapterPosition;
                        i6 = i9;
                        canvas.drawRect(left, paddingTop - this.headerHeight, right, paddingTop, this.mHeaderContentPaint);
                        canvas.drawText(headerName, this.textPaddingLeft + left, (i4 - (this.headerHeight / 2)) + this.txtYAxis, this.mHeaderTxtPaint);
                    }
                    int i11 = this.headerHeight;
                    i9 = (i11 >= i4 || i4 > i11 * 2) ? i6 : i4 - (i11 * 2);
                    this.stickyHeaderPosArray.put(i5, Integer.valueOf(i4));
                    Log.i(this.TAG, "绘制各个头部" + i5);
                    i10++;
                    recyclerView2 = recyclerView;
                    i8 = i2;
                    str2 = str;
                    childCount = i3;
                    i7 = 0;
                }
            }
            i3 = childCount;
            i10++;
            recyclerView2 = recyclerView;
            i8 = i2;
            str2 = str;
            childCount = i3;
            i7 = 0;
        }
        int i12 = i9;
        if (str2 == null) {
            return;
        }
        canvas.save();
        canvas.translate(0.0f, i12);
        if (this.headerDrawEvent == null) {
            canvas.drawRect(left, 0.0f, right, this.headerHeight, this.mHeaderContentPaint);
            canvas.drawText(str2, left + this.textPaddingLeft, (this.headerHeight / 2) + this.txtYAxis, this.mHeaderTxtPaint);
        } else if (this.headViewMap.get(Integer.valueOf(i8)) == null) {
            View headerView2 = this.headerDrawEvent.getHeaderView(i8);
            headerView2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            headerView2.setDrawingCacheEnabled(true);
            headerView2.layout(0, 0, right, this.headerHeight);
            this.headViewMap.put(Integer.valueOf(i8), headerView2);
            canvas.drawBitmap(headerView2.getDrawingCache(), left, 0.0f, (Paint) null);
        } else {
            canvas.drawBitmap(this.headViewMap.get(Integer.valueOf(i8)).getDrawingCache(), left, 0.0f, (Paint) null);
        }
        canvas.restore();
        Log.i(this.TAG, "绘制悬浮头部");
    }

    public void setHeaderContentColor(int i2) {
        this.headerContentColor = i2;
        this.mHeaderContentPaint.setColor(i2);
    }

    public void setHeaderHeight(int i2) {
        this.headerHeight = i2;
    }

    public void setOnDecorationHeadDraw(OnDecorationHeadDraw onDecorationHeadDraw) {
        this.headerDrawEvent = onDecorationHeadDraw;
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.headerClickEvent = onHeaderClickListener;
    }

    public void setTextColor(int i2) {
        this.textColor = i2;
        this.mHeaderTxtPaint.setColor(i2);
    }

    public void setTextPaddingLeft(int i2) {
        this.textPaddingLeft = i2;
    }

    public void setTextSize(int i2) {
        this.textSize = i2;
        this.mHeaderTxtPaint.setTextSize(i2);
    }
}
