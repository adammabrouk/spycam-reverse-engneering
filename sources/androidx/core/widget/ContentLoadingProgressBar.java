package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    public long f2495a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2496b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2497c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2498d;

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f2499e;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f2500f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.f2496b = false;
            contentLoadingProgressBar.f2495a = -1L;
            contentLoadingProgressBar.setVisibility(8);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.f2497c = false;
            if (contentLoadingProgressBar.f2498d) {
                return;
            }
            contentLoadingProgressBar.f2495a = System.currentTimeMillis();
            ContentLoadingProgressBar.this.setVisibility(0);
        }
    }

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public final void a() {
        removeCallbacks(this.f2499e);
        removeCallbacks(this.f2500f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2498d = false;
        this.f2499e = new a();
        this.f2500f = new b();
    }
}
