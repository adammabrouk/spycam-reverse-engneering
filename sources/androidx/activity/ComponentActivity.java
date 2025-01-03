package androidx.activity;

import a.a.e.d.a;
import a.m.f;
import a.m.g;
import a.m.i;
import a.m.j;
import a.m.q;
import a.m.s;
import a.m.u;
import a.m.v;
import a.m.w;
import a.m.x;
import a.m.y;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.savedstate.SavedStateRegistry;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements i, w, a.q.b, a.a.c, a.a.e.c {
    public static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    public final ActivityResultRegistry mActivityResultRegistry;
    public int mContentLayoutId;
    public final a.a.d.a mContextAwareHelper;
    public u.b mDefaultFactory;
    public final j mLifecycleRegistry;
    public final AtomicInteger mNextLocalRequestCode;
    public final OnBackPressedDispatcher mOnBackPressedDispatcher;
    public final a.q.a mSavedStateRegistryController;
    public v mViewModelStore;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e2;
                }
            }
        }
    }

    public class b extends ActivityResultRegistry {

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f2020a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.C0000a f2021b;

            public a(int i2, a.C0000a c0000a) {
                this.f2020a = i2;
                this.f2021b = c0000a;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a(this.f2020a, (int) this.f2021b.a());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b, reason: collision with other inner class name */
        public class RunnableC0060b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f2023a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f2024b;

            public RunnableC0060b(int i2, IntentSender.SendIntentException sendIntentException) {
                this.f2023a = i2;
                this.f2024b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a(this.f2023a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f2024b));
            }
        }

        public b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void a(int i2, a.a.e.d.a<I, O> aVar, I i3, a.h.a.b bVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0000a<O> b2 = aVar.b(componentActivity, i3);
            if (b2 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i2, b2));
                return;
            }
            Intent a2 = aVar.a((Context) componentActivity, (ComponentActivity) i3);
            Bundle bundle = null;
            if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                a2.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else if (bVar != null) {
                bundle = bVar.a();
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                a.h.a.a.a(componentActivity, stringArrayExtra, i2);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                a.h.a.a.a(componentActivity, a2, i2, bundle2);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                a.h.a.a.a(componentActivity, intentSenderRequest.e(), i2, intentSenderRequest.a(), intentSenderRequest.c(), intentSenderRequest.d(), 0, bundle2);
            } catch (IntentSender.SendIntentException e2) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0060b(i2, e2));
            }
        }
    }

    public class c implements SavedStateRegistry.b {
        public c() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        @SuppressLint({"SyntheticAccessor"})
        public Bundle a() {
            Bundle bundle = new Bundle();
            ComponentActivity.this.mActivityResultRegistry.b(bundle);
            return bundle;
        }
    }

    public class d implements a.a.d.b {
        public d() {
        }

        @Override // a.a.d.b
        @SuppressLint({"SyntheticAccessor"})
        public void a(Context context) {
            Bundle a2 = ComponentActivity.this.getSavedStateRegistry().a(ComponentActivity.ACTIVITY_RESULT_TAG);
            if (a2 != null) {
                ComponentActivity.this.mActivityResultRegistry.a(a2);
            }
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public Object f2028a;

        /* renamed from: b, reason: collision with root package name */
        public v f2029b;
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new a.a.d.a();
        this.mLifecycleRegistry = new j(this);
        this.mSavedStateRegistryController = a.q.a.a(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().a(new g() { // from class: androidx.activity.ComponentActivity.3
                @Override // a.m.g
                public void a(i iVar, f.b bVar) {
                    if (bVar == f.b.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().a(new g() { // from class: androidx.activity.ComponentActivity.4
            @Override // a.m.g
            public void a(i iVar, f.b bVar) {
                if (bVar == f.b.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.a();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.getViewModelStore().a();
                }
            }
        });
        getLifecycle().a(new g() { // from class: androidx.activity.ComponentActivity.5
            @Override // a.m.g
            public void a(i iVar, f.b bVar) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().b(this);
            }
        });
        int i2 = Build.VERSION.SDK_INT;
        if (19 <= i2 && i2 <= 23) {
            getLifecycle().a(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().a(ACTIVITY_RESULT_TAG, new c());
        addOnContextAvailableListener(new d());
    }

    private void initViewTreeOwners() {
        x.a(getWindow().getDecorView(), this);
        y.a(getWindow().getDecorView(), this);
        a.q.c.a(getWindow().getDecorView(), this);
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(a.a.d.b bVar) {
        this.mContextAwareHelper.addOnContextAvailableListener(bVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.f2029b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new v();
            }
        }
    }

    @Override // a.a.e.c
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public u.b getDefaultViewModelProviderFactory() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new s(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f2028a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, a.m.i
    public f getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // a.a.c
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // a.q.b
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    @Override // a.m.w
    public v getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (this.mActivityResultRegistry.a(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.a(bundle);
        this.mContextAwareHelper.a(this);
        super.onCreate(bundle);
        q.a(this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        v vVar = this.mViewModelStore;
        if (vVar == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            vVar = eVar.f2029b;
        }
        if (vVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f2028a = onRetainCustomNonConfigurationInstance;
        eVar2.f2029b = vVar;
        return eVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        f lifecycle = getLifecycle();
        if (lifecycle instanceof j) {
            ((j) lifecycle).d(f.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.b();
    }

    public final <I, O> a.a.e.b<I> registerForActivityResult(a.a.e.d.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, a.a.e.a<O> aVar2) {
        return activityResultRegistry.a("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, aVar2);
    }

    public final void removeOnContextAvailableListener(a.a.d.b bVar) {
        this.mContextAwareHelper.removeOnContextAvailableListener(bVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (a.s.a.b()) {
                a.s.a.a("reportFullyDrawn() for " + getComponentName());
            }
            if (Build.VERSION.SDK_INT > 19) {
                super.reportFullyDrawn();
            } else if (Build.VERSION.SDK_INT == 19 && a.h.b.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
        } finally {
            a.s.a.a();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        initViewTreeOwners();
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    public final <I, O> a.a.e.b<I> registerForActivityResult(a.a.e.d.a<I, O> aVar, a.a.e.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}
