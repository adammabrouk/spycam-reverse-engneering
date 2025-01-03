package a.b.a;

import a.b.e.b;
import a.h.j.f;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;

/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class f extends Dialog implements d {

    /* renamed from: a, reason: collision with root package name */
    public e f154a;

    /* renamed from: b, reason: collision with root package name */
    public final f.a f155b;

    /* compiled from: AppCompatDialog.java */
    public class a implements f.a {
        public a() {
        }

        @Override // a.h.j.f.a
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent);
        }
    }

    public f(Context context, int i2) {
        super(context, a(context, i2));
        this.f155b = new a();
        e a2 = a();
        a2.d(a(context, i2));
        a2.a((Bundle) null);
    }

    public boolean a(int i2) {
        return a().b(i2);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().g();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a.h.j.f.a(this.f155b, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) a().a(i2);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().f();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().e();
        super.onCreate(bundle);
        a().a(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        a().j();
    }

    @Override // a.b.a.d
    public void onSupportActionModeFinished(a.b.e.b bVar) {
    }

    @Override // a.b.a.d
    public void onSupportActionModeStarted(a.b.e.b bVar) {
    }

    @Override // a.b.a.d
    public a.b.e.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        a().c(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }

    public e a() {
        if (this.f154a == null) {
            this.f154a = e.a(this, this);
        }
        return this.f154a;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        a().a(getContext().getString(i2));
    }

    public static int a(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
