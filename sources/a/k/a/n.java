package a.k.a;

import a.m.f;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* compiled from: FragmentPagerAdapter.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class n extends a.x.a.a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    public static final boolean DEBUG = false;
    public static final String TAG = "FragmentPagerAdapter";
    public final int mBehavior;
    public r mCurTransaction;
    public Fragment mCurrentPrimaryItem;
    public boolean mExecutingFinishUpdate;
    public final FragmentManager mFragmentManager;

    @Deprecated
    public n(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public static String makeFragmentName(int i2, long j) {
        return "android:switcher:" + i2 + ":" + j;
    }

    @Override // a.x.a.a
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.b();
        }
        this.mCurTransaction.b(fragment);
        if (fragment.equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    @Override // a.x.a.a
    public void finishUpdate(ViewGroup viewGroup) {
        r rVar = this.mCurTransaction;
        if (rVar != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    rVar.d();
                } finally {
                    this.mExecutingFinishUpdate = false;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i2);

    public long getItemId(int i2) {
        return i2;
    }

    @Override // a.x.a.a
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.b();
        }
        long itemId = getItemId(i2);
        Fragment c2 = this.mFragmentManager.c(makeFragmentName(viewGroup.getId(), itemId));
        if (c2 != null) {
            this.mCurTransaction.a(c2);
        } else {
            c2 = getItem(i2);
            this.mCurTransaction.a(viewGroup.getId(), c2, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (c2 != this.mCurrentPrimaryItem) {
            c2.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.a(c2, f.c.STARTED);
            } else {
                c2.setUserVisibleHint(false);
            }
        }
        return c2;
    }

    @Override // a.x.a.a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // a.x.a.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // a.x.a.a
    public Parcelable saveState() {
        return null;
    }

    @Override // a.x.a.a
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.b();
                    }
                    this.mCurTransaction.a(this.mCurrentPrimaryItem, f.c.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.b();
                }
                this.mCurTransaction.a(fragment, f.c.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // a.x.a.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public n(FragmentManager fragmentManager, int i2) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
        this.mBehavior = i2;
    }
}
