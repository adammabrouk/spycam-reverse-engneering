package a.b.a;

import a.b.e.b;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;

/* compiled from: ActionBar.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: ActionBar.java */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public a.b.e.b a(b.a aVar) {
        return null;
    }

    public void a(Configuration configuration) {
    }

    public void a(CharSequence charSequence) {
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void addOnMenuVisibilityListener(b bVar);

    public void b(boolean z) {
    }

    public void c(boolean z) {
    }

    public void d(boolean z) {
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public abstract int g();

    public Context h() {
        return null;
    }

    public boolean i() {
        return false;
    }

    public void j() {
    }

    public boolean k() {
        return false;
    }

    public abstract void removeOnMenuVisibilityListener(b bVar);

    /* compiled from: ActionBar.java */
    /* renamed from: a.b.a.a$a, reason: collision with other inner class name */
    public static class C0001a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f147a;

        public C0001a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f147a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f147a = obtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0001a(int i2, int i3) {
            super(i2, i3);
            this.f147a = 0;
            this.f147a = 8388627;
        }

        public C0001a(C0001a c0001a) {
            super((ViewGroup.MarginLayoutParams) c0001a);
            this.f147a = 0;
            this.f147a = c0001a.f147a;
        }

        public C0001a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f147a = 0;
        }
    }
}
