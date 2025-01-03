package c.g.a.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.permissionx.guolindev.R$id;
import com.permissionx.guolindev.R$layout;

/* compiled from: PermissionxDefaultDialogLayoutBinding.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f6346a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f6347b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f6348c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f6349d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f6350e;

    /* renamed from: f, reason: collision with root package name */
    public final Button f6351f;

    public a(LinearLayout linearLayout, TextView textView, Button button, LinearLayout linearLayout2, LinearLayout linearLayout3, Button button2, LinearLayout linearLayout4) {
        this.f6346a = linearLayout;
        this.f6347b = textView;
        this.f6348c = button;
        this.f6349d = linearLayout2;
        this.f6350e = linearLayout3;
        this.f6351f = button2;
    }

    public LinearLayout a() {
        return this.f6346a;
    }

    public static a a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static a a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.permissionx_default_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static a a(View view) {
        int i2 = R$id.messageText;
        TextView textView = (TextView) a.w.a.a(view, i2);
        if (textView != null) {
            i2 = R$id.negativeBtn;
            Button button = (Button) a.w.a.a(view, i2);
            if (button != null) {
                i2 = R$id.negativeLayout;
                LinearLayout linearLayout = (LinearLayout) a.w.a.a(view, i2);
                if (linearLayout != null) {
                    i2 = R$id.permissionsLayout;
                    LinearLayout linearLayout2 = (LinearLayout) a.w.a.a(view, i2);
                    if (linearLayout2 != null) {
                        i2 = R$id.positiveBtn;
                        Button button2 = (Button) a.w.a.a(view, i2);
                        if (button2 != null) {
                            i2 = R$id.positiveLayout;
                            LinearLayout linearLayout3 = (LinearLayout) a.w.a.a(view, i2);
                            if (linearLayout3 != null) {
                                return new a((LinearLayout) view, textView, button, linearLayout, linearLayout2, button2, linearLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }
}
