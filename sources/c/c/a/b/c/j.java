package c.c.a.b.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import c.c.a.b.c.o.r;

/* loaded from: classes.dex */
public class j extends a.k.a.c {
    public Dialog q = null;
    public DialogInterface.OnCancelListener r = null;

    @Override // a.k.a.c
    public Dialog a(Bundle bundle) {
        if (this.q == null) {
            a(false);
        }
        return this.q;
    }

    @Override // a.k.a.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.r;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public static j a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        j jVar = new j();
        r.a(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        jVar.q = dialog2;
        if (onCancelListener != null) {
            jVar.r = onCancelListener;
        }
        return jVar;
    }

    @Override // a.k.a.c
    public void a(FragmentManager fragmentManager, String str) {
        super.a(fragmentManager, str);
    }
}
