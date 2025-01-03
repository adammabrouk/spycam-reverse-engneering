package androidx.fragment.app;

import a.h.a.a;
import a.k.a.f;
import a.k.a.h;
import a.k.a.m;
import a.m.f;
import a.m.j;
import a.m.v;
import a.m.w;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements a.c, a.e {
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public boolean mCreated;
    public final j mFragmentLifecycleRegistry;
    public final f mFragments;
    public boolean mResumed;
    public boolean mStopped;

    public class a implements SavedStateRegistry.b {
        public a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            FragmentActivity.this.markFragmentsCreated();
            FragmentActivity.this.mFragmentLifecycleRegistry.a(f.b.ON_STOP);
            Parcelable l = FragmentActivity.this.mFragments.l();
            if (l != null) {
                bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, l);
            }
            return bundle;
        }
    }

    public class b implements a.a.d.b {
        public b() {
        }

        @Override // a.a.d.b
        public void a(Context context) {
            FragmentActivity.this.mFragments.a((Fragment) null);
            Bundle a2 = FragmentActivity.this.getSavedStateRegistry().a(FragmentActivity.FRAGMENTS_TAG);
            if (a2 != null) {
                FragmentActivity.this.mFragments.a(a2.getParcelable(FragmentActivity.FRAGMENTS_TAG));
            }
        }
    }

    public class c extends h<FragmentActivity> implements w, a.a.c, a.a.e.c, m {
        public c() {
            super(FragmentActivity.this);
        }

        @Override // a.k.a.h
        public boolean a(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // a.k.a.h
        public LayoutInflater f() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // a.k.a.h
        public void g() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // a.a.e.c
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // a.m.i
        public a.m.f getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // a.a.c
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // a.m.w
        public v getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // a.k.a.h
        public boolean a(String str) {
            return a.h.a.a.a((Activity) FragmentActivity.this, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // a.k.a.h
        public FragmentActivity e() {
            return FragmentActivity.this;
        }

        @Override // a.k.a.m
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // a.k.a.h, a.k.a.e
        public View a(int i2) {
            return FragmentActivity.this.findViewById(i2);
        }

        @Override // a.k.a.h, a.k.a.e
        public boolean a() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public FragmentActivity() {
        this.mFragments = a.k.a.f.a(new c());
        this.mFragmentLifecycleRegistry = new j(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().a(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    public static boolean markState(FragmentManager fragmentManager, f.c cVar) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.A()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), cVar);
                }
                a.k.a.v vVar = fragment.mViewLifecycleOwner;
                if (vVar != null && vVar.getLifecycle().a().isAtLeast(f.c.STARTED)) {
                    fragment.mViewLifecycleOwner.a(cVar);
                    z = true;
                }
                if (fragment.mLifecycleRegistry.a().isAtLeast(f.c.STARTED)) {
                    fragment.mLifecycleRegistry.d(cVar);
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            a.n.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.j().a(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.j();
    }

    @Deprecated
    public a.n.a.a getSupportLoaderManager() {
        return a.n.a.a.a(this);
    }

    public void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), f.c.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.k();
        super.onActivityResult(i2, i3, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.k();
        super.onConfigurationChanged(configuration);
        this.mFragments.a(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.a(f.b.ON_CREATE);
        this.mFragments.b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return i2 == 0 ? super.onCreatePanelMenu(i2, menu) | this.mFragments.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.c();
        this.mFragmentLifecycleRegistry.a(f.b.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.mFragments.b(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.mFragments.a(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.a(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.k();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.mFragments.a(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.e();
        this.mFragmentLifecycleRegistry.a(f.b.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.b(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return i2 == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.b(menu) : super.onPreparePanel(i2, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.k();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.k();
        super.onResume();
        this.mResumed = true;
        this.mFragments.i();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.a(f.b.ON_RESUME);
        this.mFragments.f();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.k();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.a();
        }
        this.mFragments.i();
        this.mFragmentLifecycleRegistry.a(f.b.ON_START);
        this.mFragments.g();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.k();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.a(f.b.ON_STOP);
    }

    public void setEnterSharedElementCallback(a.h.a.m mVar) {
        a.h.a.a.a(this, mVar);
    }

    public void setExitSharedElementCallback(a.h.a.m mVar) {
        a.h.a.a.b(this, mVar);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            a.h.a.a.a(this, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        a.h.a.a.b((Activity) this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        a.h.a.a.c((Activity) this);
    }

    public void supportStartPostponedEnterTransition() {
        a.h.a.a.e(this);
    }

    @Override // a.h.a.a.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i2) {
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            a.h.a.a.a(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i2, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public FragmentActivity(int i2) {
        super(i2);
        this.mFragments = a.k.a.f.a(new c());
        this.mFragmentLifecycleRegistry = new j(this);
        this.mStopped = true;
        init();
    }
}
