package c.g.a.e;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import java.util.List;

/* compiled from: RationaleDialog.java */
/* loaded from: classes.dex */
public abstract class c extends Dialog {
    public c(Context context, int i2) {
        super(context, i2);
    }

    public abstract View a();

    public abstract List<String> b();

    public abstract View c();
}
