package com.hichip.widget.photoview.scrollerproxy;

import android.content.Context;
import android.widget.Scroller;

/* loaded from: classes.dex */
public class PreGingerScroller extends ScrollerProxy {
    public final Scroller mScroller;

    public PreGingerScroller(Context context) {
        this.mScroller = new Scroller(context);
    }

    @Override // com.hichip.widget.photoview.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Override // com.hichip.widget.photoview.scrollerproxy.ScrollerProxy
    public void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.mScroller.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Override // com.hichip.widget.photoview.scrollerproxy.ScrollerProxy
    public void forceFinished(boolean z) {
        this.mScroller.forceFinished(z);
    }

    @Override // com.hichip.widget.photoview.scrollerproxy.ScrollerProxy
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Override // com.hichip.widget.photoview.scrollerproxy.ScrollerProxy
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Override // com.hichip.widget.photoview.scrollerproxy.ScrollerProxy
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }
}
