package a.k.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* compiled from: DialogFragment.java */
/* loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public Handler f1332a;
    public boolean j;
    public Dialog l;
    public boolean m;
    public boolean n;
    public boolean o;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f1333b = new a();

    /* renamed from: c, reason: collision with root package name */
    public DialogInterface.OnCancelListener f1334c = new b();

    /* renamed from: d, reason: collision with root package name */
    public DialogInterface.OnDismissListener f1335d = new DialogInterfaceOnDismissListenerC0039c();

    /* renamed from: e, reason: collision with root package name */
    public int f1336e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1337f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1338g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1339h = true;

    /* renamed from: i, reason: collision with root package name */
    public int f1340i = -1;
    public a.m.o<a.m.i> k = new d();
    public boolean p = false;

    /* compiled from: DialogFragment.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            c.this.f1335d.onDismiss(c.this.l);
        }
    }

    /* compiled from: DialogFragment.java */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.l != null) {
                c cVar = c.this;
                cVar.onCancel(cVar.l);
            }
        }
    }

    /* compiled from: DialogFragment.java */
    /* renamed from: a.k.a.c$c, reason: collision with other inner class name */
    public class DialogInterfaceOnDismissListenerC0039c implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0039c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.l != null) {
                c cVar = c.this;
                cVar.onDismiss(cVar.l);
            }
        }
    }

    /* compiled from: DialogFragment.java */
    public class d implements a.m.o<a.m.i> {
        public d() {
        }

        @Override // a.m.o
        @SuppressLint({"SyntheticAccessor"})
        public void a(a.m.i iVar) {
            if (iVar == null || !c.this.f1339h) {
                return;
            }
            View requireView = c.this.requireView();
            if (requireView.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (c.this.l != null) {
                if (FragmentManager.d(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + c.this.l);
                }
                c.this.l.setContentView(requireView);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public a.k.a.e createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    public boolean d() {
        return this.p;
    }

    public final Dialog e() {
        Dialog b2 = b();
        if (b2 != null) {
            return b2;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().a(this.k);
        if (this.o) {
            return;
        }
        this.n = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1332a = new Handler();
        this.f1339h = this.mContainerId == 0;
        if (bundle != null) {
            this.f1336e = bundle.getInt("android:style", 0);
            this.f1337f = bundle.getInt("android:theme", 0);
            this.f1338g = bundle.getBoolean("android:cancelable", true);
            this.f1339h = bundle.getBoolean("android:showsDialog", this.f1339h);
            this.f1340i = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.l;
        if (dialog != null) {
            this.m = true;
            dialog.setOnDismissListener(null);
            this.l.dismiss();
            if (!this.n) {
                onDismiss(this.l);
            }
            this.l = null;
            this.p = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (!this.o && !this.n) {
            this.n = true;
        }
        getViewLifecycleOwnerLiveData().b(this.k);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.m) {
            return;
        }
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        a(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (this.f1339h && !this.j) {
            b(bundle);
            if (FragmentManager.d(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.l;
            return dialog != null ? onGetLayoutInflater.cloneInContext(dialog.getContext()) : onGetLayoutInflater;
        }
        if (FragmentManager.d(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.f1339h) {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            } else {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            }
        }
        return onGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.l;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i2 = this.f1336e;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.f1337f;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.f1338g;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.f1339h;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.f1340i;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.l;
        if (dialog != null) {
            this.m = false;
            dialog.show();
            View decorView = this.l.getWindow().getDecorView();
            a.m.x.a(decorView, this);
            a.m.y.a(decorView, this);
            a.q.c.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.l.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.l.onRestoreInstanceState(bundle2);
    }

    public void a(FragmentManager fragmentManager, String str) {
        this.n = false;
        this.o = true;
        r b2 = fragmentManager.b();
        b2.a(this, str);
        b2.a();
    }

    public Dialog b() {
        return this.l;
    }

    public int c() {
        return this.f1337f;
    }

    /* compiled from: DialogFragment.java */
    public class e extends a.k.a.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.k.a.e f1345a;

        public e(a.k.a.e eVar) {
            this.f1345a = eVar;
        }

        @Override // a.k.a.e
        public View a(int i2) {
            return this.f1345a.a() ? this.f1345a.a(i2) : c.this.a(i2);
        }

        @Override // a.k.a.e
        public boolean a() {
            return this.f1345a.a() || c.this.d();
        }
    }

    public final void b(Bundle bundle) {
        if (this.f1339h && !this.p) {
            try {
                this.j = true;
                Dialog a2 = a(bundle);
                this.l = a2;
                if (this.f1339h) {
                    a(a2, this.f1336e);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.l.setOwnerActivity((Activity) context);
                    }
                    this.l.setCancelable(this.f1338g);
                    this.l.setOnCancelListener(this.f1334c);
                    this.l.setOnDismissListener(this.f1335d);
                    this.p = true;
                } else {
                    this.l = null;
                }
            } finally {
                this.j = false;
            }
        }
    }

    public void a() {
        a(false, false);
    }

    public final void a(boolean z, boolean z2) {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o = false;
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.l.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.f1332a.getLooper()) {
                    onDismiss(this.l);
                } else {
                    this.f1332a.post(this.f1333b);
                }
            }
        }
        this.m = true;
        if (this.f1340i >= 0) {
            getParentFragmentManager().a(this.f1340i, 1);
            this.f1340i = -1;
            return;
        }
        r b2 = getParentFragmentManager().b();
        b2.d(this);
        if (z) {
            b2.b();
        } else {
            b2.a();
        }
    }

    public void a(boolean z) {
        this.f1339h = z;
    }

    public View a(int i2) {
        Dialog dialog = this.l;
        if (dialog != null) {
            return dialog.findViewById(i2);
        }
        return null;
    }

    public void a(Dialog dialog, int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog a(Bundle bundle) {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), c());
    }
}
