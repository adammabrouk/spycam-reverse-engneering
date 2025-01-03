package androidx.recyclerview.widget;

import a.p.a.h;
import a.p.a.k;
import a.p.a.n;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.system.ContentCommon;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    public static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final float MAX_SCROLL_FACTOR = 0.33333334f;
    public static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    public final a mAnchorInfo;
    public int mInitialPrefetchItemCount;
    public boolean mLastStackFromEnd;
    public final b mLayoutChunkResult;
    public c mLayoutState;
    public int mOrientation;
    public k mOrientationHelper;
    public SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    public boolean mRecycleChildrenOnDetach;
    public int[] mReusableIntPair;
    public boolean mReverseLayout;
    public boolean mShouldReverseLayout;
    public boolean mSmoothScrollbarEnabled;
    public boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f2674a;

        /* renamed from: b, reason: collision with root package name */
        public int f2675b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2676c;

        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        public boolean a() {
            return this.f2674a >= 0;
        }

        public void c() {
            this.f2674a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f2674a);
            parcel.writeInt(this.f2675b);
            parcel.writeInt(this.f2676c ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f2674a = parcel.readInt();
            this.f2675b = parcel.readInt();
            this.f2676c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f2674a = savedState.f2674a;
            this.f2675b = savedState.f2675b;
            this.f2676c = savedState.f2676c;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f2682a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2683b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2684c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2685d;

        public void a() {
            this.f2682a = 0;
            this.f2683b = false;
            this.f2684c = false;
            this.f2685d = false;
        }
    }

    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public int f2687b;

        /* renamed from: c, reason: collision with root package name */
        public int f2688c;

        /* renamed from: d, reason: collision with root package name */
        public int f2689d;

        /* renamed from: e, reason: collision with root package name */
        public int f2690e;

        /* renamed from: f, reason: collision with root package name */
        public int f2691f;

        /* renamed from: g, reason: collision with root package name */
        public int f2692g;
        public boolean j;
        public int k;
        public boolean m;

        /* renamed from: a, reason: collision with root package name */
        public boolean f2686a = true;

        /* renamed from: h, reason: collision with root package name */
        public int f2693h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f2694i = 0;
        public List<RecyclerView.c0> l = null;

        public boolean a(RecyclerView.z zVar) {
            int i2 = this.f2689d;
            return i2 >= 0 && i2 < zVar.a();
        }

        public final View b() {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.l.get(i2).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f2689d == pVar.a()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public View a(RecyclerView.v vVar) {
            if (this.l != null) {
                return b();
            }
            View d2 = vVar.d(this.f2689d);
            this.f2689d += this.f2690e;
            return d2;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.f2689d = -1;
            } else {
                this.f2689d = ((RecyclerView.p) b2.getLayoutParams()).a();
            }
        }

        public View b(View view) {
            int a2;
            int size = this.l.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.l.get(i3).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a2 = (pVar.a() - this.f2689d) * this.f2690e) >= 0 && a2 < i2) {
                    view2 = view3;
                    if (a2 == 0) {
                        break;
                    }
                    i2 = a2;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return n.a(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return n.a(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return n.b(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar) {
        return findReferenceChild(vVar, zVar, 0, getChildCount(), zVar.a());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar) {
        return findReferenceChild(vVar, zVar, getChildCount() - 1, -1, zVar.a());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(vVar, zVar) : findLastReferenceChild(vVar, zVar);
    }

    private View findReferenceChildClosestToStart(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.mShouldReverseLayout ? findLastReferenceChild(vVar, zVar) : findFirstReferenceChild(vVar, zVar);
    }

    private int fixLayoutEndGap(int i2, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int b2;
        int b3 = this.mOrientationHelper.b() - i2;
        if (b3 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(-b3, vVar, zVar);
        int i4 = i2 + i3;
        if (!z || (b2 = this.mOrientationHelper.b() - i4) <= 0) {
            return i3;
        }
        this.mOrientationHelper.a(b2);
        return b2 + i3;
    }

    private int fixLayoutStartGap(int i2, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int f2;
        int f3 = i2 - this.mOrientationHelper.f();
        if (f3 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(f3, vVar, zVar);
        int i4 = i2 + i3;
        if (!z || (f2 = i4 - this.mOrientationHelper.f()) <= 0) {
            return i3;
        }
        this.mOrientationHelper.a(-f2);
        return i3 - f2;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3) {
        if (!zVar.e() || getChildCount() == 0 || zVar.d() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.c0> f2 = vVar.f();
        int size = f2.size();
        int position = getPosition(getChildAt(0));
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView.c0 c0Var = f2.get(i6);
            if (!c0Var.isRemoved()) {
                if (((c0Var.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    i4 += this.mOrientationHelper.b(c0Var.itemView);
                } else {
                    i5 += this.mOrientationHelper.b(c0Var.itemView);
                }
            }
        }
        this.mLayoutState.l = f2;
        if (i4 > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i2);
            c cVar = this.mLayoutState;
            cVar.f2693h = i4;
            cVar.f2688c = 0;
            cVar.a();
            fill(vVar, this.mLayoutState, zVar, false);
        }
        if (i5 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i3);
            c cVar2 = this.mLayoutState;
            cVar2.f2693h = i5;
            cVar2.f2688c = 0;
            cVar2.a();
            fill(vVar, this.mLayoutState, zVar, false);
        }
        this.mLayoutState.l = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.d(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.v vVar, c cVar) {
        if (!cVar.f2686a || cVar.m) {
            return;
        }
        int i2 = cVar.f2692g;
        int i3 = cVar.f2694i;
        if (cVar.f2691f == -1) {
            recycleViewsFromEnd(vVar, i2, i3);
        } else {
            recycleViewsFromStart(vVar, i2, i3);
        }
    }

    private void recycleChildren(RecyclerView.v vVar, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                removeAndRecycleViewAt(i2, vVar);
                i2--;
            }
        } else {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                removeAndRecycleViewAt(i4, vVar);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.v vVar, int i2, int i3) {
        int childCount = getChildCount();
        if (i2 < 0) {
            return;
        }
        int a2 = (this.mOrientationHelper.a() - i2) + i3;
        if (this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.d(childAt) < a2 || this.mOrientationHelper.f(childAt) < a2) {
                    recycleChildren(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.d(childAt2) < a2 || this.mOrientationHelper.f(childAt2) < a2) {
                recycleChildren(vVar, i5, i6);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.v vVar, int i2, int i3) {
        if (i2 < 0) {
            return;
        }
        int i4 = i2 - i3;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (this.mOrientationHelper.a(childAt) > i4 || this.mOrientationHelper.e(childAt) > i4) {
                    recycleChildren(vVar, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = childCount - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View childAt2 = getChildAt(i7);
            if (this.mOrientationHelper.a(childAt2) > i4 || this.mOrientationHelper.e(childAt2) > i4) {
                recycleChildren(vVar, i6, i7);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.a(focusedChild, zVar)) {
            aVar.b(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        View findReferenceChildClosestToEnd = aVar.f2680d ? findReferenceChildClosestToEnd(vVar, zVar) : findReferenceChildClosestToStart(vVar, zVar);
        if (findReferenceChildClosestToEnd == null) {
            return false;
        }
        aVar.a(findReferenceChildClosestToEnd, getPosition(findReferenceChildClosestToEnd));
        if (!zVar.d() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.d(findReferenceChildClosestToEnd) >= this.mOrientationHelper.b() || this.mOrientationHelper.a(findReferenceChildClosestToEnd) < this.mOrientationHelper.f()) {
                aVar.f2679c = aVar.f2680d ? this.mOrientationHelper.b() : this.mOrientationHelper.f();
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.z zVar, a aVar) {
        int i2;
        if (!zVar.d() && (i2 = this.mPendingScrollPosition) != -1) {
            if (i2 >= 0 && i2 < zVar.a()) {
                aVar.f2678b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.a()) {
                    boolean z = this.mPendingSavedState.f2676c;
                    aVar.f2680d = z;
                    if (z) {
                        aVar.f2679c = this.mOrientationHelper.b() - this.mPendingSavedState.f2675b;
                    } else {
                        aVar.f2679c = this.mOrientationHelper.f() + this.mPendingSavedState.f2675b;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z2 = this.mShouldReverseLayout;
                    aVar.f2680d = z2;
                    if (z2) {
                        aVar.f2679c = this.mOrientationHelper.b() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f2679c = this.mOrientationHelper.f() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (findViewByPosition == null) {
                    if (getChildCount() > 0) {
                        aVar.f2680d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    aVar.a();
                } else {
                    if (this.mOrientationHelper.b(findViewByPosition) > this.mOrientationHelper.g()) {
                        aVar.a();
                        return true;
                    }
                    if (this.mOrientationHelper.d(findViewByPosition) - this.mOrientationHelper.f() < 0) {
                        aVar.f2679c = this.mOrientationHelper.f();
                        aVar.f2680d = false;
                        return true;
                    }
                    if (this.mOrientationHelper.b() - this.mOrientationHelper.a(findViewByPosition) < 0) {
                        aVar.f2679c = this.mOrientationHelper.b();
                        aVar.f2680d = true;
                        return true;
                    }
                    aVar.f2679c = aVar.f2680d ? this.mOrientationHelper.a(findViewByPosition) + this.mOrientationHelper.h() : this.mOrientationHelper.d(findViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (updateAnchorFromPendingData(zVar, aVar) || updateAnchorFromChildren(vVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f2678b = this.mStackFromEnd ? zVar.a() - 1 : 0;
    }

    private void updateLayoutState(int i2, int i3, boolean z, RecyclerView.z zVar) {
        int f2;
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f2691f = i2;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(zVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i2 == 1;
        this.mLayoutState.f2693h = z2 ? max2 : max;
        c cVar = this.mLayoutState;
        if (!z2) {
            max = max2;
        }
        cVar.f2694i = max;
        if (z2) {
            this.mLayoutState.f2693h += this.mOrientationHelper.c();
            View childClosestToEnd = getChildClosestToEnd();
            this.mLayoutState.f2690e = this.mShouldReverseLayout ? -1 : 1;
            c cVar2 = this.mLayoutState;
            int position = getPosition(childClosestToEnd);
            c cVar3 = this.mLayoutState;
            cVar2.f2689d = position + cVar3.f2690e;
            cVar3.f2687b = this.mOrientationHelper.a(childClosestToEnd);
            f2 = this.mOrientationHelper.a(childClosestToEnd) - this.mOrientationHelper.b();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f2693h += this.mOrientationHelper.f();
            this.mLayoutState.f2690e = this.mShouldReverseLayout ? 1 : -1;
            c cVar4 = this.mLayoutState;
            int position2 = getPosition(childClosestToStart);
            c cVar5 = this.mLayoutState;
            cVar4.f2689d = position2 + cVar5.f2690e;
            cVar5.f2687b = this.mOrientationHelper.d(childClosestToStart);
            f2 = (-this.mOrientationHelper.d(childClosestToStart)) + this.mOrientationHelper.f();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f2688c = i3;
        if (z) {
            cVar6.f2688c = i3 - f2;
        }
        this.mLayoutState.f2692g = f2;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f2678b, aVar.f2679c);
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f2678b, aVar.f2679c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.z zVar, int[] iArr) {
        int i2;
        int extraLayoutSpace = getExtraLayoutSpace(zVar);
        if (this.mLayoutState.f2691f == -1) {
            i2 = 0;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        if (this.mOrientation != 0) {
            i2 = i3;
        }
        if (getChildCount() == 0 || i2 == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i2 > 0 ? 1 : -1, Math.abs(i2), true, zVar);
        collectPrefetchPositionsForLayoutState(zVar, this.mLayoutState, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectInitialPrefetchPositions(int i2, RecyclerView.o.c cVar) {
        boolean z;
        int i3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState == null || !savedState.a()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i3 = this.mPendingScrollPosition;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z = savedState2.f2676c;
            i3 = savedState2.f2674a;
        }
        int i4 = z ? -1 : 1;
        for (int i5 = 0; i5 < this.mInitialPrefetchItemCount && i3 >= 0 && i3 < i2; i5++) {
            cVar.a(i3, 0);
            i3 += i4;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i2 = cVar.f2689d;
        if (i2 < 0 || i2 >= zVar.a()) {
            return;
        }
        cVar2.a(i2, Math.max(0, cVar.f2692g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        int i3 = (i2 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i3, 0.0f) : new PointF(0.0f, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    public int convertFocusDirectionToLayoutDirection(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    public c createLayoutState() {
        return new c();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z) {
        int i2 = cVar.f2688c;
        int i3 = cVar.f2692g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.f2692g = i3 + i2;
            }
            recycleByLayoutState(vVar, cVar);
        }
        int i4 = cVar.f2688c + cVar.f2693h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m && i4 <= 0) || !cVar.a(zVar)) {
                break;
            }
            bVar.a();
            layoutChunk(vVar, zVar, cVar, bVar);
            if (!bVar.f2683b) {
                cVar.f2687b += bVar.f2682a * cVar.f2691f;
                if (!bVar.f2684c || cVar.l != null || !zVar.d()) {
                    int i5 = cVar.f2688c;
                    int i6 = bVar.f2682a;
                    cVar.f2688c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = cVar.f2692g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + bVar.f2682a;
                    cVar.f2692g = i8;
                    int i9 = cVar.f2688c;
                    if (i9 < 0) {
                        cVar.f2692g = i8 + i9;
                    }
                    recycleByLayoutState(vVar, cVar);
                }
                if (z && bVar.f2685d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f2688c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z, z2) : findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z, z2) : findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i2, int i3) {
        int i4;
        int i5;
        ensureLayoutState();
        if ((i3 > i2 ? (char) 1 : i3 < i2 ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i2);
        }
        if (this.mOrientationHelper.d(getChildAt(i2)) < this.mOrientationHelper.f()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i2, i3, i4, i5) : this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

    public View findOneVisibleChild(int i2, int i3, boolean z, boolean z2) {
        ensureLayoutState();
        int i4 = z ? ContentCommon.CGI_IEGET_CAM_PARAMS : 320;
        int i5 = z2 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i2, i3, i4, i5) : this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

    public View findReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3, int i4) {
        ensureLayoutState();
        int f2 = this.mOrientationHelper.f();
        int b2 = this.mOrientationHelper.b();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4) {
                if (((RecyclerView.p) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.d(childAt) < b2 && this.mOrientationHelper.a(childAt) >= f2) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View findViewByPosition(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i2 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i2) {
                return childAt;
            }
        }
        return super.findViewByPosition(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return new RecyclerView.p(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.z zVar) {
        if (zVar.c()) {
            return this.mOrientationHelper.g();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int c2;
        View a2 = cVar.a(vVar);
        if (a2 == null) {
            bVar.f2683b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) a2.getLayoutParams();
        if (cVar.l == null) {
            if (this.mShouldReverseLayout == (cVar.f2691f == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f2691f == -1)) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        bVar.f2682a = this.mOrientationHelper.b(a2);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                c2 = getWidth() - getPaddingRight();
                i5 = c2 - this.mOrientationHelper.c(a2);
            } else {
                i5 = getPaddingLeft();
                c2 = this.mOrientationHelper.c(a2) + i5;
            }
            if (cVar.f2691f == -1) {
                int i6 = cVar.f2687b;
                i4 = i6;
                i3 = c2;
                i2 = i6 - bVar.f2682a;
            } else {
                int i7 = cVar.f2687b;
                i2 = i7;
                i3 = c2;
                i4 = bVar.f2682a + i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int c3 = this.mOrientationHelper.c(a2) + paddingTop;
            if (cVar.f2691f == -1) {
                int i8 = cVar.f2687b;
                i3 = i8;
                i2 = paddingTop;
                i4 = c3;
                i5 = i8 - bVar.f2682a;
            } else {
                int i9 = cVar.f2687b;
                i2 = paddingTop;
                i3 = bVar.f2682a + i9;
                i4 = c3;
                i5 = i9;
            }
        }
        layoutDecoratedWithMargins(a2, i5, i2, i3, i4);
        if (pVar.c() || pVar.b()) {
            bVar.f2684c = true;
        }
        bVar.f2685d = a2.hasFocusable();
    }

    public void onAnchorReady(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(vVar);
            vVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        int convertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.g() * 0.33333334f), false, zVar);
        c cVar = this.mLayoutState;
        cVar.f2692g = Integer.MIN_VALUE;
        cVar.f2686a = false;
        fill(vVar, cVar, zVar, true);
        View findPartiallyOrCompletelyInvisibleChildClosestToStart = convertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = convertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return findPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (findPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int fixLayoutEndGap;
        int i6;
        View findViewByPosition;
        int d2;
        int i7;
        int i8 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && zVar.a() == 0) {
            removeAndRecycleAllViews(vVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f2674a;
        }
        ensureLayoutState();
        this.mLayoutState.f2686a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.f2681e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.b();
            a aVar = this.mAnchorInfo;
            aVar.f2680d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(vVar, zVar, aVar);
            this.mAnchorInfo.f2681e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.d(focusedChild) >= this.mOrientationHelper.b() || this.mOrientationHelper.a(focusedChild) <= this.mOrientationHelper.f())) {
            this.mAnchorInfo.b(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f2691f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(zVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.f();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.c();
        if (zVar.d() && (i6 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i6)) != null) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.b() - this.mOrientationHelper.a(findViewByPosition);
                d2 = this.mPendingScrollPositionOffset;
            } else {
                d2 = this.mOrientationHelper.d(findViewByPosition) - this.mOrientationHelper.f();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i9 = i7 - d2;
            if (i9 > 0) {
                max += i9;
            } else {
                max2 -= i9;
            }
        }
        if (!this.mAnchorInfo.f2680d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i8 = 1;
        }
        onAnchorReady(vVar, zVar, this.mAnchorInfo, i8);
        detachAndScrapAttachedViews(vVar);
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.j = zVar.d();
        this.mLayoutState.f2694i = 0;
        a aVar2 = this.mAnchorInfo;
        if (aVar2.f2680d) {
            updateLayoutStateToFillStart(aVar2);
            c cVar2 = this.mLayoutState;
            cVar2.f2693h = max;
            fill(vVar, cVar2, zVar, false);
            c cVar3 = this.mLayoutState;
            i3 = cVar3.f2687b;
            int i10 = cVar3.f2689d;
            int i11 = cVar3.f2688c;
            if (i11 > 0) {
                max2 += i11;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f2693h = max2;
            cVar4.f2689d += cVar4.f2690e;
            fill(vVar, cVar4, zVar, false);
            c cVar5 = this.mLayoutState;
            i2 = cVar5.f2687b;
            int i12 = cVar5.f2688c;
            if (i12 > 0) {
                updateLayoutStateToFillStart(i10, i3);
                c cVar6 = this.mLayoutState;
                cVar6.f2693h = i12;
                fill(vVar, cVar6, zVar, false);
                i3 = this.mLayoutState.f2687b;
            }
        } else {
            updateLayoutStateToFillEnd(aVar2);
            c cVar7 = this.mLayoutState;
            cVar7.f2693h = max2;
            fill(vVar, cVar7, zVar, false);
            c cVar8 = this.mLayoutState;
            i2 = cVar8.f2687b;
            int i13 = cVar8.f2689d;
            int i14 = cVar8.f2688c;
            if (i14 > 0) {
                max += i14;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f2693h = max;
            cVar9.f2689d += cVar9.f2690e;
            fill(vVar, cVar9, zVar, false);
            c cVar10 = this.mLayoutState;
            i3 = cVar10.f2687b;
            int i15 = cVar10.f2688c;
            if (i15 > 0) {
                updateLayoutStateToFillEnd(i13, i2);
                c cVar11 = this.mLayoutState;
                cVar11.f2693h = i15;
                fill(vVar, cVar11, zVar, false);
                i2 = this.mLayoutState.f2687b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i2, vVar, zVar, true);
                i4 = i3 + fixLayoutEndGap2;
                i5 = i2 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i4, vVar, zVar, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i3, vVar, zVar, true);
                i4 = i3 + fixLayoutStartGap;
                i5 = i2 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i5, vVar, zVar, false);
            }
            i3 = i4 + fixLayoutEndGap;
            i2 = i5 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(vVar, zVar, i3, i2);
        if (zVar.d()) {
            this.mAnchorInfo.b();
        } else {
            this.mOrientationHelper.i();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.z zVar) {
        super.onLayoutCompleted(zVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.f2676c = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.f2675b = this.mOrientationHelper.b() - this.mOrientationHelper.a(childClosestToEnd);
                savedState.f2674a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.f2674a = getPosition(childClosestToStart);
                savedState.f2675b = this.mOrientationHelper.d(childClosestToStart) - this.mOrientationHelper.f();
            }
        } else {
            savedState.c();
        }
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i2, int i3) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.b() - (this.mOrientationHelper.d(view2) + this.mOrientationHelper.b(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.b() - this.mOrientationHelper.a(view2));
                return;
            }
        }
        if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.a(view2) - this.mOrientationHelper.b(view));
        }
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.d() == 0 && this.mOrientationHelper.a() == 0;
    }

    public int scrollBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f2686a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        updateLayoutState(i3, abs, true, zVar);
        c cVar = this.mLayoutState;
        int fill = cVar.f2692g + fill(vVar, cVar, zVar, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i2 = i3 * fill;
        }
        this.mOrientationHelper.a(-i2);
        this.mLayoutState.k = i2;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i2) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.c();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = i3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.c();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i2, vVar, zVar);
    }

    public void setInitialPrefetchItemCount(int i2) {
        this.mInitialPrefetchItemCount = i2;
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i2);
        }
        assertNotInLayoutOrScroll(null);
        if (i2 != this.mOrientation || this.mOrientationHelper == null) {
            k a2 = k.a(this, i2);
            this.mOrientationHelper = a2;
            this.mAnchorInfo.f2677a = a2;
            this.mOrientation = i2;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.z zVar, int i2) {
        h hVar = new h(recyclerView.getContext());
        hVar.c(i2);
        startSmoothScroll(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int d2 = this.mOrientationHelper.d(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i2 = 1; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                int position2 = getPosition(childAt);
                int d3 = this.mOrientationHelper.d(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(d3 < d2);
                    throw new RuntimeException(sb.toString());
                }
                if (d3 > d2) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i3 = 1; i3 < getChildCount(); i3++) {
            View childAt2 = getChildAt(i3);
            int position3 = getPosition(childAt2);
            int d4 = this.mOrientationHelper.d(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(d4 < d2);
                throw new RuntimeException(sb2.toString());
            }
            if (d4 < d2) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i2);
        setReverseLayout(z);
    }

    private void updateLayoutStateToFillEnd(int i2, int i3) {
        this.mLayoutState.f2688c = this.mOrientationHelper.b() - i3;
        this.mLayoutState.f2690e = this.mShouldReverseLayout ? -1 : 1;
        c cVar = this.mLayoutState;
        cVar.f2689d = i2;
        cVar.f2691f = 1;
        cVar.f2687b = i3;
        cVar.f2692g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i2, int i3) {
        this.mLayoutState.f2688c = i3 - this.mOrientationHelper.f();
        c cVar = this.mLayoutState;
        cVar.f2689d = i2;
        cVar.f2690e = this.mShouldReverseLayout ? 1 : -1;
        c cVar2 = this.mLayoutState;
        cVar2.f2691f = -1;
        cVar2.f2687b = i3;
        cVar2.f2692g = Integer.MIN_VALUE;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public k f2677a;

        /* renamed from: b, reason: collision with root package name */
        public int f2678b;

        /* renamed from: c, reason: collision with root package name */
        public int f2679c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2680d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2681e;

        public a() {
            b();
        }

        public void a() {
            this.f2679c = this.f2680d ? this.f2677a.b() : this.f2677a.f();
        }

        public void b() {
            this.f2678b = -1;
            this.f2679c = Integer.MIN_VALUE;
            this.f2680d = false;
            this.f2681e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2678b + ", mCoordinate=" + this.f2679c + ", mLayoutFromEnd=" + this.f2680d + ", mValid=" + this.f2681e + '}';
        }

        public boolean a(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < zVar.a();
        }

        public void b(View view, int i2) {
            int h2 = this.f2677a.h();
            if (h2 >= 0) {
                a(view, i2);
                return;
            }
            this.f2678b = i2;
            if (this.f2680d) {
                int b2 = (this.f2677a.b() - h2) - this.f2677a.a(view);
                this.f2679c = this.f2677a.b() - b2;
                if (b2 > 0) {
                    int b3 = this.f2679c - this.f2677a.b(view);
                    int f2 = this.f2677a.f();
                    int min = b3 - (f2 + Math.min(this.f2677a.d(view) - f2, 0));
                    if (min < 0) {
                        this.f2679c += Math.min(b2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int d2 = this.f2677a.d(view);
            int f3 = d2 - this.f2677a.f();
            this.f2679c = d2;
            if (f3 > 0) {
                int b4 = (this.f2677a.b() - Math.min(0, (this.f2677a.b() - h2) - this.f2677a.a(view))) - (d2 + this.f2677a.b(view));
                if (b4 < 0) {
                    this.f2679c -= Math.min(f3, -b4);
                }
            }
        }

        public void a(View view, int i2) {
            if (this.f2680d) {
                this.f2679c = this.f2677a.a(view) + this.f2677a.h();
            } else {
                this.f2679c = this.f2677a.d(view);
            }
            this.f2678b = i2;
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.f2719a);
        setReverseLayout(properties.f2721c);
        setStackFromEnd(properties.f2722d);
    }
}
