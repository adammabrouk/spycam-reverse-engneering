package androidx.appcompat.widget;

import a.h.j.y;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TypedValue f2290a;

    /* renamed from: b, reason: collision with root package name */
    public TypedValue f2291b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f2292c;

    /* renamed from: d, reason: collision with root package name */
    public TypedValue f2293d;

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f2294e;

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f2295f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f2296g;

    /* renamed from: h, reason: collision with root package name */
    public a f2297h;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2294e == null) {
            this.f2294e = new TypedValue();
        }
        return this.f2294e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2295f == null) {
            this.f2295f = new TypedValue();
        }
        return this.f2295f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2292c == null) {
            this.f2292c = new TypedValue();
        }
        return this.f2292c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2293d == null) {
            this.f2293d = new TypedValue();
        }
        return this.f2293d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2290a == null) {
            this.f2290a = new TypedValue();
        }
        return this.f2290a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2291b == null) {
            this.f2291b = new TypedValue();
        }
        return this.f2291b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f2297h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f2297h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f2297h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f2296g.set(i2, i3, i4, i5);
        if (y.J(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2296g = new Rect();
    }
}
