package com.hichip.widget.stickygridheaders;

import android.R;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.zxing.view.ViewfinderView;
import com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class StickyGridHeadersGridView extends GridView implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemLongClickListener {
    public static final int MATCHED_STICKIED_HEADER = -2;
    public static final int NO_MATCHED_HEADER = -1;
    public static final int TOUCH_MODE_DONE_WAITING = 2;
    public static final int TOUCH_MODE_DOWN = 0;
    public static final int TOUCH_MODE_FINISHED_LONG_PRESS = -2;
    public static final int TOUCH_MODE_REST = -1;
    public static final int TOUCH_MODE_TAP = 1;
    public StickyGridHeadersBaseAdapterWrapper mAdapter;
    public boolean mAreHeadersSticky;
    public boolean mClipToPaddingHasBeenSet;
    public final Rect mClippingRect;
    public boolean mClippingToPadding;
    public int mColumnWidth;
    public long mCurrentHeaderId;
    public boolean mDataChanged;
    public DataSetObserver mDataSetObserver;
    public int mHeaderBottomPosition;
    public boolean mHeaderChildBeingPressed;
    public boolean mHeadersIgnorePadding;
    public int mHorizontalSpacing;
    public boolean mMaskStickyHeaderRegion;
    public int mMotionHeaderPosition;
    public float mMotionY;
    public int mNumColumns;
    public boolean mNumColumnsSet;
    public int mNumMeasuredColumns;
    public OnHeaderClickListener mOnHeaderClickListener;
    public OnHeaderLongClickListener mOnHeaderLongClickListener;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    public CheckForHeaderLongPress mPendingCheckForLongPress;
    public CheckForHeaderTap mPendingCheckForTap;
    public PerformHeaderClick mPerformHeaderClick;
    public AbsListView.OnScrollListener mScrollListener;
    public int mScrollState;
    public View mStickiedHeader;
    public int mTouchMode;
    public Runnable mTouchModeReset;
    public int mTouchSlop;
    public int mVerticalSpacing;
    public static final String ERROR_PLATFORM = "Error supporting platform " + Build.VERSION.SDK_INT + ".";
    public static final String TAG = StickyGridHeadersGridView.class.getSimpleName();

    public class CheckForHeaderLongPress extends WindowRunnable implements Runnable {
        public CheckForHeaderLongPress() {
            super(StickyGridHeadersGridView.this, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r6 = this;
                com.hichip.widget.stickygridheaders.StickyGridHeadersGridView r0 = com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.this
                int r1 = r0.mMotionHeaderPosition
                android.view.View r0 = r0.getHeaderAt(r1)
                if (r0 == 0) goto L38
                com.hichip.widget.stickygridheaders.StickyGridHeadersGridView r1 = com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.this
                int r2 = r1.mMotionHeaderPosition
                long r1 = com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.access$1(r1, r2)
                boolean r3 = r6.sameWindow()
                r4 = 0
                if (r3 == 0) goto L24
                com.hichip.widget.stickygridheaders.StickyGridHeadersGridView r3 = com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.this
                boolean r5 = r3.mDataChanged
                if (r5 != 0) goto L24
                boolean r1 = r3.performHeaderLongPress(r0, r1)
                goto L25
            L24:
                r1 = 0
            L25:
                if (r1 == 0) goto L33
                com.hichip.widget.stickygridheaders.StickyGridHeadersGridView r1 = com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.this
                r2 = -2
                r1.mTouchMode = r2
                r1.setPressed(r4)
                r0.setPressed(r4)
                goto L38
            L33:
                com.hichip.widget.stickygridheaders.StickyGridHeadersGridView r0 = com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.this
                r1 = 2
                r0.mTouchMode = r1
            L38:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.CheckForHeaderLongPress.run():void");
        }

        public /* synthetic */ CheckForHeaderLongPress(StickyGridHeadersGridView stickyGridHeadersGridView, CheckForHeaderLongPress checkForHeaderLongPress) {
            this();
        }
    }

    public final class CheckForHeaderTap implements Runnable {
        public CheckForHeaderTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
            if (stickyGridHeadersGridView.mTouchMode == 0) {
                stickyGridHeadersGridView.mTouchMode = 1;
                View headerAt = stickyGridHeadersGridView.getHeaderAt(stickyGridHeadersGridView.mMotionHeaderPosition);
                if (headerAt != null) {
                    StickyGridHeadersGridView stickyGridHeadersGridView2 = StickyGridHeadersGridView.this;
                    if (stickyGridHeadersGridView2.mHeaderChildBeingPressed) {
                        return;
                    }
                    if (stickyGridHeadersGridView2.mDataChanged) {
                        stickyGridHeadersGridView2.mTouchMode = 2;
                        return;
                    }
                    headerAt.setPressed(true);
                    StickyGridHeadersGridView.this.setPressed(true);
                    StickyGridHeadersGridView.this.refreshDrawableState();
                    int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    if (!StickyGridHeadersGridView.this.isLongClickable()) {
                        StickyGridHeadersGridView.this.mTouchMode = 2;
                        return;
                    }
                    StickyGridHeadersGridView stickyGridHeadersGridView3 = StickyGridHeadersGridView.this;
                    if (stickyGridHeadersGridView3.mPendingCheckForLongPress == null) {
                        stickyGridHeadersGridView3.mPendingCheckForLongPress = new CheckForHeaderLongPress(stickyGridHeadersGridView3, null);
                    }
                    StickyGridHeadersGridView.this.mPendingCheckForLongPress.rememberWindowAttachCount();
                    StickyGridHeadersGridView stickyGridHeadersGridView4 = StickyGridHeadersGridView.this;
                    stickyGridHeadersGridView4.postDelayed(stickyGridHeadersGridView4.mPendingCheckForLongPress, longPressTimeout);
                }
            }
        }
    }

    public interface OnHeaderClickListener {
        void onHeaderClick(AdapterView<?> adapterView, View view, long j);
    }

    public interface OnHeaderLongClickListener {
        boolean onHeaderLongClick(AdapterView<?> adapterView, View view, long j);
    }

    public class PerformHeaderClick extends WindowRunnable implements Runnable {
        public int mClickMotionPosition;

        public PerformHeaderClick() {
            super(StickyGridHeadersGridView.this, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper;
            int i2;
            View headerAt;
            StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
            if (stickyGridHeadersGridView.mDataChanged || (stickyGridHeadersBaseAdapterWrapper = stickyGridHeadersGridView.mAdapter) == null || stickyGridHeadersBaseAdapterWrapper.getCount() <= 0 || (i2 = this.mClickMotionPosition) == -1 || i2 >= StickyGridHeadersGridView.this.mAdapter.getCount() || !sameWindow() || (headerAt = StickyGridHeadersGridView.this.getHeaderAt(this.mClickMotionPosition)) == null) {
                return;
            }
            StickyGridHeadersGridView stickyGridHeadersGridView2 = StickyGridHeadersGridView.this;
            stickyGridHeadersGridView2.performHeaderClick(headerAt, stickyGridHeadersGridView2.headerViewPositionToId(this.mClickMotionPosition));
        }

        public /* synthetic */ PerformHeaderClick(StickyGridHeadersGridView stickyGridHeadersGridView, PerformHeaderClick performHeaderClick) {
            this();
        }
    }

    public class RuntimePlatformSupportException extends RuntimeException {
        public static final long serialVersionUID = -6512098808936536538L;

        public RuntimePlatformSupportException(Exception exc) {
            super(StickyGridHeadersGridView.ERROR_PLATFORM, exc);
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        public boolean areHeadersSticky;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.areHeadersSticky + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.areHeadersSticky ? (byte) 1 : (byte) 0);
        }

        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.areHeadersSticky = parcel.readByte() != 0;
        }
    }

    public class WindowRunnable {
        public int mOriginalAttachCount;

        public WindowRunnable() {
        }

        public void rememberWindowAttachCount() {
            this.mOriginalAttachCount = StickyGridHeadersGridView.this.getWindowAttachCount();
        }

        public boolean sameWindow() {
            return StickyGridHeadersGridView.this.hasWindowFocus() && StickyGridHeadersGridView.this.getWindowAttachCount() == this.mOriginalAttachCount;
        }

        public /* synthetic */ WindowRunnable(StickyGridHeadersGridView stickyGridHeadersGridView, WindowRunnable windowRunnable) {
            this();
        }
    }

    public StickyGridHeadersGridView(Context context) {
        this(context, null);
    }

    private int findMotionHeader(float f2) {
        if (this.mStickiedHeader != null && f2 <= this.mHeaderBottomPosition) {
            return -2;
        }
        int i2 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                View childAt = getChildAt(i2);
                int bottom = childAt.getBottom();
                int top = childAt.getTop();
                if (f2 <= bottom && f2 >= top) {
                    return i2;
                }
            }
            int i3 = this.mNumMeasuredColumns;
            firstVisiblePosition += i3;
            i2 += i3;
        }
        return -1;
    }

    private int getHeaderHeight() {
        View view = this.mStickiedHeader;
        if (view != null) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    public static MotionEvent.PointerCoords[] getPointerCoords(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerCoordsArr[i2] = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i2, pointerCoordsArr[i2]);
        }
        return pointerCoordsArr;
    }

    public static int[] getPointerIds(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            iArr[i2] = motionEvent.getPointerId(i2);
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long headerViewPositionToId(int i2) {
        return i2 == -2 ? this.mCurrentHeaderId : this.mAdapter.getHeaderId(getFirstVisiblePosition() + i2);
    }

    private void measureHeader() {
        int i2;
        if (this.mStickiedHeader == null) {
            return;
        }
        int makeMeasureSpec = this.mHeadersIgnorePadding ? View.MeasureSpec.makeMeasureSpec(getWidth(), MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), MemoryConstants.GB);
        ViewGroup.LayoutParams layoutParams = this.mStickiedHeader.getLayoutParams();
        int makeMeasureSpec2 = (layoutParams == null || (i2 = layoutParams.height) <= 0) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i2, MemoryConstants.GB);
        this.mStickiedHeader.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mStickiedHeader.measure(makeMeasureSpec, makeMeasureSpec2);
        if (this.mHeadersIgnorePadding) {
            this.mStickiedHeader.layout(getLeft(), 0, getRight(), this.mStickiedHeader.getMeasuredHeight());
        } else {
            this.mStickiedHeader.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.mStickiedHeader.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.mHeaderBottomPosition = 0;
        swapStickiedHeader(null);
        this.mCurrentHeaderId = Long.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void scrollChanged(int r15) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.scrollChanged(int):void");
    }

    private void swapStickiedHeader(View view) {
        detachHeader(this.mStickiedHeader);
        attachHeader(view);
        this.mStickiedHeader = view;
    }

    private MotionEvent transformEvent(MotionEvent motionEvent, int i2) {
        if (i2 == -2) {
            return motionEvent;
        }
        long downTime = motionEvent.getDownTime();
        long eventTime = motionEvent.getEventTime();
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] pointerIds = getPointerIds(motionEvent);
        MotionEvent.PointerCoords[] pointerCoords = getPointerCoords(motionEvent);
        int metaState = motionEvent.getMetaState();
        float xPrecision = motionEvent.getXPrecision();
        float yPrecision = motionEvent.getYPrecision();
        int deviceId = motionEvent.getDeviceId();
        int edgeFlags = motionEvent.getEdgeFlags();
        int source = motionEvent.getSource();
        int flags = motionEvent.getFlags();
        View childAt = getChildAt(i2);
        int i3 = 0;
        while (i3 < pointerCount) {
            long j = downTime;
            pointerCoords[i3].y -= childAt.getTop();
            i3++;
            downTime = j;
            eventTime = eventTime;
        }
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, pointerIds, pointerCoords, metaState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
    }

    public boolean areHeadersSticky() {
        return this.mAreHeadersSticky;
    }

    public void attachHeader(View view) {
        if (view == null) {
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            declaredField.setAccessible(true);
            Method declaredMethod = View.class.getDeclaredMethod("dispatchAttachedToWindow", Class.forName("android.view.View$AttachInfo"), Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(view, declaredField.get(this), 8);
        } catch (ClassNotFoundException e2) {
            throw new RuntimePlatformSupportException(e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimePlatformSupportException(e3);
        } catch (IllegalArgumentException e4) {
            throw new RuntimePlatformSupportException(e4);
        } catch (NoSuchFieldException e5) {
            throw new RuntimePlatformSupportException(e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimePlatformSupportException(e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimePlatformSupportException(e7);
        }
    }

    public void detachHeader(View view) {
        if (view == null) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("dispatchDetachedFromWindow", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(view, new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new RuntimePlatformSupportException(e2);
        } catch (IllegalArgumentException e3) {
            throw new RuntimePlatformSupportException(e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimePlatformSupportException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimePlatformSupportException(e5);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 8) {
            scrollChanged(getFirstVisiblePosition());
        }
        View view = this.mStickiedHeader;
        int i2 = 0;
        boolean z = view != null && this.mAreHeadersSticky && view.getVisibility() == 0;
        int headerHeight = getHeaderHeight();
        int i3 = this.mHeaderBottomPosition - headerHeight;
        if (z && this.mMaskStickyHeaderRegion) {
            if (this.mHeadersIgnorePadding) {
                Rect rect = this.mClippingRect;
                rect.left = 0;
                rect.right = getWidth();
            } else {
                this.mClippingRect.left = getPaddingLeft();
                this.mClippingRect.right = getWidth() - getPaddingRight();
            }
            Rect rect2 = this.mClippingRect;
            rect2.top = this.mHeaderBottomPosition;
            rect2.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.mClippingRect);
        }
        super.dispatchDraw(canvas);
        ArrayList arrayList = new ArrayList();
        int firstVisiblePosition = getFirstVisiblePosition();
        int i4 = 0;
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i4));
            }
            int i5 = this.mNumMeasuredColumns;
            firstVisiblePosition += i5;
            i4 += i5;
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            View childAt = getChildAt(((Integer) arrayList.get(i6)).intValue());
            try {
                View view2 = (View) childAt.getTag();
                boolean z2 = ((long) ((StickyGridHeadersBaseAdapterWrapper.HeaderFillerView) childAt).getHeaderId()) == this.mCurrentHeaderId && childAt.getTop() < 0 && this.mAreHeadersSticky;
                if (view2.getVisibility() != 0 || z2) {
                    i2 = 0;
                } else {
                    int makeMeasureSpec = this.mHeadersIgnorePadding ? View.MeasureSpec.makeMeasureSpec(getWidth(), MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), MemoryConstants.GB);
                    i2 = 0;
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    view2.measure(makeMeasureSpec, makeMeasureSpec2);
                    if (this.mHeadersIgnorePadding) {
                        view2.layout(getLeft(), 0, getRight(), childAt.getHeight());
                    } else {
                        view2.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), childAt.getHeight());
                    }
                    if (this.mHeadersIgnorePadding) {
                        Rect rect3 = this.mClippingRect;
                        rect3.left = 0;
                        rect3.right = getWidth();
                    } else {
                        this.mClippingRect.left = getPaddingLeft();
                        this.mClippingRect.right = getWidth() - getPaddingRight();
                    }
                    this.mClippingRect.bottom = childAt.getBottom();
                    this.mClippingRect.top = childAt.getTop();
                    canvas.save();
                    canvas.clipRect(this.mClippingRect);
                    if (this.mHeadersIgnorePadding) {
                        canvas.translate(0.0f, childAt.getTop());
                    } else {
                        canvas.translate(getPaddingLeft(), childAt.getTop());
                    }
                    view2.draw(canvas);
                    canvas.restore();
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (z && this.mMaskStickyHeaderRegion) {
            canvas.restore();
        } else if (!z) {
            return;
        }
        if (this.mStickiedHeader.getWidth() != (this.mHeadersIgnorePadding ? getWidth() : (getWidth() - getPaddingLeft()) - getPaddingRight())) {
            int makeMeasureSpec3 = this.mHeadersIgnorePadding ? View.MeasureSpec.makeMeasureSpec(getWidth(), MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), MemoryConstants.GB);
            int makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i2, i2);
            this.mStickiedHeader.measure(View.MeasureSpec.makeMeasureSpec(i2, i2), View.MeasureSpec.makeMeasureSpec(i2, i2));
            this.mStickiedHeader.measure(makeMeasureSpec3, makeMeasureSpec4);
            if (this.mHeadersIgnorePadding) {
                this.mStickiedHeader.layout(getLeft(), i2, getRight(), this.mStickiedHeader.getHeight());
            } else {
                this.mStickiedHeader.layout(getLeft() + getPaddingLeft(), i2, getRight() - getPaddingRight(), this.mStickiedHeader.getHeight());
            }
        }
        if (this.mHeadersIgnorePadding) {
            Rect rect4 = this.mClippingRect;
            rect4.left = i2;
            rect4.right = getWidth();
        } else {
            this.mClippingRect.left = getPaddingLeft();
            this.mClippingRect.right = getWidth() - getPaddingRight();
        }
        Rect rect5 = this.mClippingRect;
        rect5.bottom = i3 + headerHeight;
        if (this.mClippingToPadding) {
            rect5.top = getPaddingTop();
        } else {
            rect5.top = i2;
        }
        canvas.save();
        canvas.clipRect(this.mClippingRect);
        if (this.mHeadersIgnorePadding) {
            canvas.translate(0.0f, i3);
        } else {
            canvas.translate(getPaddingLeft(), i3);
        }
        if (this.mHeaderBottomPosition != headerHeight) {
            canvas.saveLayerAlpha(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), (this.mHeaderBottomPosition * ViewfinderView.OPAQUE) / headerHeight, 31);
        }
        this.mStickiedHeader.draw(canvas);
        if (this.mHeaderBottomPosition != headerHeight) {
            canvas.restore();
        }
        canvas.restore();
    }

    public View getHeaderAt(int i2) {
        if (i2 == -2) {
            return this.mStickiedHeader;
        }
        try {
            return (View) getChildAt(i2).getTag();
        } catch (Exception unused) {
            return null;
        }
    }

    public View getStickiedHeader() {
        return this.mStickiedHeader;
    }

    public boolean getStickyHeaderIsTranscluent() {
        return !this.mMaskStickyHeaderRegion;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        this.mOnItemClickListener.onItemClick(adapterView, view, this.mAdapter.translatePosition(i2).mPosition, j);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
        return this.mOnItemLongClickListener.onItemLongClick(adapterView, view, this.mAdapter.translatePosition(i2).mPosition, j);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
        this.mOnItemSelectedListener.onItemSelected(adapterView, view, this.mAdapter.translatePosition(i2).mPosition, j);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.mNumColumns;
        if (i4 == -1) {
            int i5 = 1;
            if (this.mColumnWidth > 0) {
                int max = Math.max((View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight(), 0);
                int i6 = max / this.mColumnWidth;
                if (i6 > 0) {
                    while (i6 != 1 && (this.mColumnWidth * i6) + ((i6 - 1) * this.mHorizontalSpacing) > max) {
                        i6--;
                    }
                    i5 = i6;
                }
            } else {
                i5 = 2;
            }
            this.mNumMeasuredColumns = i5;
        } else {
            this.mNumMeasuredColumns = i4;
        }
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.mAdapter;
        if (stickyGridHeadersBaseAdapterWrapper != null) {
            stickyGridHeadersBaseAdapterWrapper.setNumColumns(this.mNumMeasuredColumns);
        }
        measureHeader();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.mOnItemSelectedListener.onNothingSelected(adapterView);
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mAreHeadersSticky = savedState.areHeadersSticky;
        requestLayout();
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.areHeadersSticky = this.mAreHeadersSticky;
        return savedState;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            scrollChanged(i2);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AbsListView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
        this.mScrollState = i2;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int action = motionEvent.getAction();
        boolean z = this.mHeaderChildBeingPressed;
        if (z) {
            View headerAt = getHeaderAt(this.mMotionHeaderPosition);
            int i3 = this.mMotionHeaderPosition;
            final View childAt = i3 == -2 ? headerAt : getChildAt(i3);
            if (action == 1 || action == 3) {
                this.mHeaderChildBeingPressed = false;
            }
            if (headerAt != null) {
                headerAt.dispatchTouchEvent(transformEvent(motionEvent, this.mMotionHeaderPosition));
                headerAt.invalidate();
                headerAt.postDelayed(new Runnable() { // from class: com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        StickyGridHeadersGridView.this.invalidate(0, childAt.getTop(), StickyGridHeadersGridView.this.getWidth(), childAt.getTop() + childAt.getHeight());
                    }
                }, ViewConfiguration.getPressedStateDuration());
                invalidate(0, childAt.getTop(), getWidth(), childAt.getTop() + childAt.getHeight());
            }
        }
        int i4 = action & ViewfinderView.OPAQUE;
        if (i4 == 0) {
            if (this.mPendingCheckForTap == null) {
                this.mPendingCheckForTap = new CheckForHeaderTap();
            }
            postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
            float y = (int) motionEvent.getY();
            this.mMotionY = y;
            int findMotionHeader = findMotionHeader(y);
            this.mMotionHeaderPosition = findMotionHeader;
            if (findMotionHeader != -1 && this.mScrollState != 2) {
                View headerAt2 = getHeaderAt(findMotionHeader);
                if (headerAt2 != null) {
                    if (headerAt2.dispatchTouchEvent(transformEvent(motionEvent, this.mMotionHeaderPosition))) {
                        this.mHeaderChildBeingPressed = true;
                        headerAt2.setPressed(true);
                    }
                    headerAt2.invalidate();
                    int i5 = this.mMotionHeaderPosition;
                    if (i5 != -2) {
                        headerAt2 = getChildAt(i5);
                    }
                    invalidate(0, headerAt2.getTop(), getWidth(), headerAt2.getTop() + headerAt2.getHeight());
                }
                this.mTouchMode = 0;
                return true;
            }
        } else if (i4 == 1) {
            int i6 = this.mTouchMode;
            if (i6 == -2) {
                this.mTouchMode = -1;
                return true;
            }
            if (i6 != -1 && (i2 = this.mMotionHeaderPosition) != -1) {
                final View headerAt3 = getHeaderAt(i2);
                if (!z && headerAt3 != null) {
                    if (this.mTouchMode != 0) {
                        headerAt3.setPressed(false);
                    }
                    if (this.mPerformHeaderClick == null) {
                        this.mPerformHeaderClick = new PerformHeaderClick(this, null);
                    }
                    final PerformHeaderClick performHeaderClick = this.mPerformHeaderClick;
                    performHeaderClick.mClickMotionPosition = this.mMotionHeaderPosition;
                    performHeaderClick.rememberWindowAttachCount();
                    int i7 = this.mTouchMode;
                    if (i7 == 0 || i7 == 1) {
                        Handler handler = getHandler();
                        if (handler != null) {
                            handler.removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.mPendingCheckForLongPress);
                        }
                        if (this.mDataChanged) {
                            this.mTouchMode = -1;
                        } else {
                            this.mTouchMode = 1;
                            headerAt3.setPressed(true);
                            setPressed(true);
                            Runnable runnable = this.mTouchModeReset;
                            if (runnable != null) {
                                removeCallbacks(runnable);
                            }
                            Runnable runnable2 = new Runnable() { // from class: com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
                                    stickyGridHeadersGridView.mMotionHeaderPosition = -1;
                                    stickyGridHeadersGridView.mTouchModeReset = null;
                                    StickyGridHeadersGridView.this.mTouchMode = -1;
                                    headerAt3.setPressed(false);
                                    StickyGridHeadersGridView.this.setPressed(false);
                                    headerAt3.invalidate();
                                    StickyGridHeadersGridView.this.invalidate(0, headerAt3.getTop(), StickyGridHeadersGridView.this.getWidth(), headerAt3.getHeight());
                                    if (StickyGridHeadersGridView.this.mDataChanged) {
                                        return;
                                    }
                                    performHeaderClick.run();
                                }
                            };
                            this.mTouchModeReset = runnable2;
                            postDelayed(runnable2, ViewConfiguration.getPressedStateDuration());
                        }
                    } else if (!this.mDataChanged) {
                        performHeaderClick.run();
                    }
                }
                this.mTouchMode = -1;
                return true;
            }
        } else if (i4 == 2 && this.mMotionHeaderPosition != -1 && Math.abs(motionEvent.getY() - this.mMotionY) > this.mTouchSlop) {
            this.mTouchMode = -1;
            View headerAt4 = getHeaderAt(this.mMotionHeaderPosition);
            if (headerAt4 != null) {
                headerAt4.setPressed(false);
                headerAt4.invalidate();
            }
            Handler handler2 = getHandler();
            if (handler2 != null) {
                handler2.removeCallbacks(this.mPendingCheckForLongPress);
            }
            this.mMotionHeaderPosition = -1;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performHeaderClick(View view, long j) {
        if (this.mOnHeaderClickListener == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.mOnHeaderClickListener.onHeaderClick(this, view, j);
        return true;
    }

    public boolean performHeaderLongPress(View view, long j) {
        OnHeaderLongClickListener onHeaderLongClickListener = this.mOnHeaderLongClickListener;
        boolean onHeaderLongClick = onHeaderLongClickListener != null ? onHeaderLongClickListener.onHeaderLongClick(this, view, j) : false;
        if (onHeaderLongClick) {
            if (view != null) {
                view.sendAccessibilityEvent(2);
            }
            performHapticFeedback(0);
        }
        return onHeaderLongClick;
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        StickyGridHeadersBaseAdapter stickyGridHeadersSimpleAdapterWrapper;
        DataSetObserver dataSetObserver;
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.mAdapter;
        if (stickyGridHeadersBaseAdapterWrapper != null && (dataSetObserver = this.mDataSetObserver) != null) {
            stickyGridHeadersBaseAdapterWrapper.unregisterDataSetObserver(dataSetObserver);
        }
        if (!this.mClipToPaddingHasBeenSet) {
            this.mClippingToPadding = true;
        }
        if (listAdapter instanceof StickyGridHeadersBaseAdapter) {
            stickyGridHeadersSimpleAdapterWrapper = (StickyGridHeadersBaseAdapter) listAdapter;
        } else {
            stickyGridHeadersSimpleAdapterWrapper = listAdapter instanceof StickyGridHeadersSimpleAdapter ? new StickyGridHeadersSimpleAdapterWrapper((StickyGridHeadersSimpleAdapter) listAdapter) : new StickyGridHeadersListAdapterWrapper(listAdapter);
        }
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper2 = new StickyGridHeadersBaseAdapterWrapper(getContext(), this, stickyGridHeadersSimpleAdapterWrapper);
        this.mAdapter = stickyGridHeadersBaseAdapterWrapper2;
        stickyGridHeadersBaseAdapterWrapper2.registerDataSetObserver(this.mDataSetObserver);
        reset();
        super.setAdapter((ListAdapter) this.mAdapter);
    }

    public void setAreHeadersSticky(boolean z) {
        if (z != this.mAreHeadersSticky) {
            this.mAreHeadersSticky = z;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.mClippingToPadding = z;
        this.mClipToPaddingHasBeenSet = true;
    }

    @Override // android.widget.GridView
    public void setColumnWidth(int i2) {
        super.setColumnWidth(i2);
        this.mColumnWidth = i2;
    }

    public void setHeadersIgnorePadding(boolean z) {
        this.mHeadersIgnorePadding = z;
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i2) {
        super.setHorizontalSpacing(i2);
        this.mHorizontalSpacing = i2;
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i2) {
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper;
        super.setNumColumns(i2);
        this.mNumColumnsSet = true;
        this.mNumColumns = i2;
        if (i2 == -1 || (stickyGridHeadersBaseAdapterWrapper = this.mAdapter) == null) {
            return;
        }
        stickyGridHeadersBaseAdapterWrapper.setNumColumns(i2);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
    }

    public void setOnHeaderLongClickListener(OnHeaderLongClickListener onHeaderLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnHeaderLongClickListener = onHeaderLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setStickyHeaderIsTranscluent(boolean z) {
        this.mMaskStickyHeaderRegion = !z;
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i2) {
        super.setVerticalSpacing(i2);
        this.mVerticalSpacing = i2;
    }

    public StickyGridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gridViewStyle);
    }

    public StickyGridHeadersGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mAreHeadersSticky = true;
        this.mClippingRect = new Rect();
        this.mCurrentHeaderId = -1L;
        this.mDataSetObserver = new DataSetObserver() { // from class: com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                StickyGridHeadersGridView.this.reset();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                StickyGridHeadersGridView.this.reset();
            }
        };
        this.mMaskStickyHeaderRegion = true;
        this.mNumMeasuredColumns = 1;
        this.mScrollState = 0;
        this.mHeaderChildBeingPressed = false;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.mNumColumnsSet) {
            this.mNumColumns = -1;
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
