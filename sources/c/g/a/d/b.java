package c.g.a.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.permissionx.guolindev.R$id;
import com.permissionx.guolindev.R$layout;

/* compiled from: PermissionxPermissionItemBinding.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f6352a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f6353b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f6354c;

    public b(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.f6352a = linearLayout;
        this.f6353b = imageView;
        this.f6354c = textView;
    }

    public LinearLayout a() {
        return this.f6352a;
    }

    public static b a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.permissionx_permission_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static b a(View view) {
        int i2 = R$id.permissionIcon;
        ImageView imageView = (ImageView) a.w.a.a(view, i2);
        if (imageView != null) {
            i2 = R$id.permissionText;
            TextView textView = (TextView) a.w.a.a(view, i2);
            if (textView != null) {
                return new b((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }
}
