package a.k.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

/* compiled from: FragmentContainer.java */
/* loaded from: classes.dex */
public abstract class e {
    public abstract View a(int i2);

    @Deprecated
    public Fragment a(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    public abstract boolean a();
}
