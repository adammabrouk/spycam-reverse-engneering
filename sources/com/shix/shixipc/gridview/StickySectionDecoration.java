package com.shix.shixipc.gridview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.lookcam.R;
import com.shix.shixipc.bean.GroupInfo;

/* loaded from: classes.dex */
public class StickySectionDecoration extends RecyclerView.n {
    public GroupInfoCallback mCallback;
    public int mDividerHeight;
    public Paint.FontMetrics mFontMetrics;
    public int mHeaderHeight;
    public Paint mPaint;
    public float mTextOffsetX;
    public TextPaint mTextPaint;
    public float mTextSize;

    public interface GroupInfoCallback {
        GroupInfo getGroupInfo(int i2);
    }

    public StickySectionDecoration(Context context, GroupInfoCallback groupInfoCallback) {
        this.mCallback = groupInfoCallback;
        this.mDividerHeight = context.getResources().getDimensionPixelOffset(R.dimen.header_divider_height);
        this.mHeaderHeight = context.getResources().getDimensionPixelOffset(R.dimen.header_height);
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.header_textsize);
        this.mTextSize = dimensionPixelOffset;
        this.mHeaderHeight = (int) Math.max(this.mHeaderHeight, dimensionPixelOffset);
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setColor(-16777216);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mFontMetrics = this.mTextPaint.getFontMetrics();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
    }

    private void drawHeaderRect(Canvas canvas, GroupInfo groupInfo, int i2, int i3, int i4, int i5) {
        float f2 = i2;
        float f3 = i5;
        canvas.drawRect(f2, i3, i4, f3, this.mPaint);
        canvas.drawText(groupInfo.getTitle(), f2 + this.mTextOffsetX, f3 - this.mFontMetrics.descent, this.mTextPaint);
    }

    public GroupInfoCallback getCallback() {
        return this.mCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        super.getItemOffsets(rect, view, recyclerView, zVar);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        GroupInfoCallback groupInfoCallback = this.mCallback;
        if (groupInfoCallback != null) {
            GroupInfo groupInfo = groupInfoCallback.getGroupInfo(childAdapterPosition);
            if (groupInfo == null || !groupInfo.isFirstViewInGroup()) {
                rect.top = this.mDividerHeight;
            } else {
                rect.top = this.mHeaderHeight;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        int i2;
        int i3;
        int bottom;
        RecyclerView recyclerView2 = recyclerView;
        super.onDrawOver(canvas, recyclerView, zVar);
        int childCount = recyclerView.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = recyclerView2.getChildAt(i4);
            int childAdapterPosition = recyclerView2.getChildAdapterPosition(childAt);
            GroupInfoCallback groupInfoCallback = this.mCallback;
            if (groupInfoCallback != null) {
                GroupInfo groupInfo = groupInfoCallback.getGroupInfo(childAdapterPosition);
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                Log.d("tag", " 绘制 i=" + i4 + " view.getTop()= " + childAt.getTop() + " left= " + paddingLeft + " right= " + width + " index= " + childAdapterPosition);
                if (i4 == 0) {
                    i2 = childCount;
                    i3 = i4;
                    int paddingTop = recyclerView.getPaddingTop();
                    int i5 = (!groupInfo.isLastViewInGroup() || (bottom = childAt.getBottom() - this.mHeaderHeight) >= paddingTop) ? paddingTop : bottom;
                    int i6 = i5 + this.mHeaderHeight;
                    drawHeaderRect(canvas, groupInfo, paddingLeft, i5, width, i6);
                    Log.d("tag", " 绘制222 " + groupInfo.toString() + " left= " + paddingLeft + " right= " + width + " top= " + i5 + " bottom= " + i6);
                } else if (groupInfo.isFirstViewInGroup()) {
                    int top = childAt.getTop() - this.mHeaderHeight;
                    i2 = childCount;
                    i3 = i4;
                    drawHeaderRect(canvas, groupInfo, paddingLeft, top, width, childAt.getTop());
                    Log.d("tag", " 绘制111 " + groupInfo.toString() + " left= " + childAt.getLeft() + " right= " + width + " top= " + top + " view.getTop()= " + childAt.getTop());
                }
                i4 = i3 + 1;
                recyclerView2 = recyclerView;
                childCount = i2;
            }
            i2 = childCount;
            i3 = i4;
            i4 = i3 + 1;
            recyclerView2 = recyclerView;
            childCount = i2;
        }
    }

    public void setCallback(GroupInfoCallback groupInfoCallback) {
        this.mCallback = groupInfoCallback;
    }
}
