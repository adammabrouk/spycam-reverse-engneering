package a.k.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

/* compiled from: FragmentLayoutInflaterFactory.java */
/* loaded from: classes.dex */
public class i implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentManager f1371a;

    /* compiled from: FragmentLayoutInflaterFactory.java */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f1372a;

        public a(p pVar) {
            this.f1372a = pVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment k = this.f1372a.k();
            this.f1372a.l();
            x.a((ViewGroup) k.mView.getParent(), i.this.f1371a).b();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public i(FragmentManager fragmentManager) {
        this.f1371a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        p f2;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f1371a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !g.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment b2 = resourceId != -1 ? this.f1371a.b(resourceId) : null;
        if (b2 == null && string != null) {
            b2 = this.f1371a.c(string);
        }
        if (b2 == null && id != -1) {
            b2 = this.f1371a.b(id);
        }
        if (b2 == null) {
            b2 = this.f1371a.y().a(context.getClassLoader(), attributeValue);
            b2.mFromLayout = true;
            b2.mFragmentId = resourceId != 0 ? resourceId : id;
            b2.mContainerId = id;
            b2.mTag = string;
            b2.mInLayout = true;
            FragmentManager fragmentManager = this.f1371a;
            b2.mFragmentManager = fragmentManager;
            b2.mHost = fragmentManager.B();
            b2.onInflate(this.f1371a.B().c(), attributeSet, b2.mSavedFragmentState);
            f2 = this.f1371a.a(b2);
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Fragment " + b2 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (b2.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            b2.mInLayout = true;
            FragmentManager fragmentManager2 = this.f1371a;
            b2.mFragmentManager = fragmentManager2;
            b2.mHost = fragmentManager2.B();
            b2.onInflate(this.f1371a.B().c(), attributeSet, b2.mSavedFragmentState);
            f2 = this.f1371a.f(b2);
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Retained Fragment " + b2 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        b2.mContainer = (ViewGroup) view;
        f2.l();
        f2.j();
        View view2 = b2.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (b2.mView.getTag() == null) {
            b2.mView.setTag(string);
        }
        b2.mView.addOnAttachStateChangeListener(new a(f2));
        return b2.mView;
    }
}
