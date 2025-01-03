package a.p.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.xpopup.widget.SmartDivider;

/* compiled from: DividerItemDecoration.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.n {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1636d = {R.attr.listDivider};

    /* renamed from: a, reason: collision with root package name */
    public Drawable f1637a;

    /* renamed from: b, reason: collision with root package name */
    public int f1638b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f1639c = new Rect();

    public d(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f1636d);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f1637a = drawable;
        if (drawable == null) {
            Log.w(SmartDivider.TAG, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        setOrientation(i2);
    }

    public final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int i2;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            i2 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.f1639c);
            int round = this.f1639c.right + Math.round(childAt.getTranslationX());
            this.f1637a.setBounds(round - this.f1637a.getIntrinsicWidth(), i2, round, height);
            this.f1637a.draw(canvas);
        }
        canvas.restore();
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int i2;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i2, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            i2 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.f1639c);
            int round = this.f1639c.bottom + Math.round(childAt.getTranslationY());
            this.f1637a.setBounds(i2, round - this.f1637a.getIntrinsicHeight(), width, round);
            this.f1637a.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        Drawable drawable = this.f1637a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f1638b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (recyclerView.getLayoutManager() == null || this.f1637a == null) {
            return;
        }
        if (this.f1638b == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f1637a = drawable;
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f1638b = i2;
    }
}
