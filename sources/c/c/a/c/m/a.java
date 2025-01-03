package c.c.a.c.m;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: InsetDialogOnTouchListener.java */
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final Dialog f5475a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5476b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5477c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5478d;

    public a(Dialog dialog, Rect rect) {
        this.f5475a = dialog;
        this.f5476b = rect.left;
        this.f5477c = rect.top;
        this.f5478d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = this.f5476b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        if (new RectF(left, this.f5477c + findViewById.getTop(), width, findViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.f5478d;
            obtain.setLocation((-i2) - 1, (-i2) - 1);
        }
        view.performClick();
        return this.f5475a.onTouchEvent(obtain);
    }
}
