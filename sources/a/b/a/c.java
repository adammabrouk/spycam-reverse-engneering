package a.b.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;
import com.google.zxing.view.ViewfinderView;

/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class c extends f implements DialogInterface {

    /* renamed from: c, reason: collision with root package name */
    public final AlertController f148c;

    /* compiled from: AlertDialog.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final AlertController.f f149a;

        /* renamed from: b, reason: collision with root package name */
        public final int f150b;

        public a(Context context) {
            this(context, c.b(context, 0));
        }

        public a a(CharSequence charSequence) {
            this.f149a.f2104f = charSequence;
            return this;
        }

        public Context b() {
            return this.f149a.f2099a;
        }

        public a(Context context, int i2) {
            this.f149a = new AlertController.f(new ContextThemeWrapper(context, c.b(context, i2)));
            this.f150b = i2;
        }

        public a a(View view) {
            this.f149a.f2105g = view;
            return this;
        }

        public a a(Drawable drawable) {
            this.f149a.f2102d = drawable;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f149a.u = onKeyListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f149a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a a(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f149a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            fVar.I = i2;
            fVar.H = true;
            return this;
        }

        public c a() {
            c cVar = new c(this.f149a.f2099a, this.f150b);
            this.f149a.a(cVar.f148c);
            cVar.setCancelable(this.f149a.r);
            if (this.f149a.r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f149a.s);
            cVar.setOnDismissListener(this.f149a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f149a.u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }
    }

    public c(Context context, int i2) {
        super(context, b(context, i2));
        this.f148c = new AlertController(getContext(), this, getWindow());
    }

    public static int b(Context context, int i2) {
        if (((i2 >>> 24) & ViewfinderView.OPAQUE) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // a.b.a.f, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f148c.b();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f148c.a(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f148c.b(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // a.b.a.f, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f148c.b(charSequence);
    }

    public ListView b() {
        return this.f148c.a();
    }
}
