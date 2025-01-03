package androidx.fragment.app;

import a.k.a.r;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f2629a;

    /* renamed from: b, reason: collision with root package name */
    public Context f2630b;

    /* renamed from: c, reason: collision with root package name */
    public FragmentManager f2631c;

    /* renamed from: d, reason: collision with root package name */
    public int f2632d;

    /* renamed from: e, reason: collision with root package name */
    public TabHost.OnTabChangeListener f2633e;

    /* renamed from: f, reason: collision with root package name */
    public a f2634f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2635g;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f2636a;

        public class a implements Parcelable.Creator<SavedState> {
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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f2636a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f2636a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2636a = parcel.readString();
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f2637a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f2638b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f2639c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f2640d;
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.f2629a = new ArrayList<>();
        a(context, (AttributeSet) null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f2632d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f2629a.size();
        r rVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f2629a.get(i2);
            Fragment c2 = this.f2631c.c(aVar.f2637a);
            aVar.f2640d = c2;
            if (c2 != null && !c2.isDetached()) {
                if (aVar.f2637a.equals(currentTabTag)) {
                    this.f2634f = aVar;
                } else {
                    if (rVar == null) {
                        rVar = this.f2631c.b();
                    }
                    rVar.b(aVar.f2640d);
                }
            }
        }
        this.f2635g = true;
        r a2 = a(currentTabTag, rVar);
        if (a2 != null) {
            a2.a();
            this.f2631c.u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2635g = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f2636a);
    }

    @Override // android.view.View
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2636a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        r a2;
        if (this.f2635g && (a2 = a(str, (r) null)) != null) {
            a2.a();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f2633e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f2633e = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2629a = new ArrayList<>();
        a(context, attributeSet);
    }

    public final r a(String str, r rVar) {
        Fragment fragment;
        a a2 = a(str);
        if (this.f2634f != a2) {
            if (rVar == null) {
                rVar = this.f2631c.b();
            }
            a aVar = this.f2634f;
            if (aVar != null && (fragment = aVar.f2640d) != null) {
                rVar.b(fragment);
            }
            if (a2 != null) {
                Fragment fragment2 = a2.f2640d;
                if (fragment2 == null) {
                    Fragment a3 = this.f2631c.y().a(this.f2630b.getClassLoader(), a2.f2638b.getName());
                    a2.f2640d = a3;
                    a3.setArguments(a2.f2639c);
                    rVar.a(this.f2632d, a2.f2640d, a2.f2637a);
                } else {
                    rVar.a(fragment2);
                }
            }
            this.f2634f = a2;
        }
        return rVar;
    }

    public final a a(String str) {
        int size = this.f2629a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f2629a.get(i2);
            if (aVar.f2637a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
