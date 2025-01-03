package a.b.f;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import com.shix.shixipc.utils.SystemBarTintManager;

/* compiled from: TooltipPopup.java */
/* loaded from: classes.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f521a;

    /* renamed from: b, reason: collision with root package name */
    public final View f522b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f523c;

    /* renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f524d = new WindowManager.LayoutParams();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f525e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final int[] f526f = new int[2];

    /* renamed from: g, reason: collision with root package name */
    public final int[] f527g = new int[2];

    public k0(Context context) {
        this.f521a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, (ViewGroup) null);
        this.f522b = inflate;
        this.f523c = (TextView) inflate.findViewById(R$id.message);
        this.f524d.setTitle(k0.class.getSimpleName());
        this.f524d.packageName = this.f521a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f524d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void a(View view, int i2, int i3, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.f523c.setText(charSequence);
        a(view, i2, i3, z, this.f524d);
        ((WindowManager) this.f521a.getSystemService("window")).addView(this.f522b, this.f524d);
    }

    public boolean b() {
        return this.f522b.getParent() != null;
    }

    public void a() {
        if (b()) {
            ((WindowManager) this.f521a.getSystemService("window")).removeView(this.f522b);
        }
    }

    public final void a(View view, int i2, int i3, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f521a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f521a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
            height = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f521a.getResources().getDimensionPixelOffset(z ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
        View a2 = a(view);
        if (a2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a2.getWindowVisibleDisplayFrame(this.f525e);
        Rect rect = this.f525e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f521a.getResources();
            int identifier = resources.getIdentifier(SystemBarTintManager.SystemBarConfig.STATUS_BAR_HEIGHT_RES_NAME, "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f525e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a2.getLocationOnScreen(this.f527g);
        view.getLocationOnScreen(this.f526f);
        int[] iArr = this.f526f;
        int i5 = iArr[0];
        int[] iArr2 = this.f527g;
        iArr[0] = i5 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i2) - (a2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f522b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f522b.getMeasuredHeight();
        int[] iArr3 = this.f526f;
        int i6 = ((iArr3[1] + i4) - dimensionPixelOffset3) - measuredHeight;
        int i7 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i6 >= 0) {
                layoutParams.y = i6;
                return;
            } else {
                layoutParams.y = i7;
                return;
            }
        }
        if (measuredHeight + i7 <= this.f525e.height()) {
            layoutParams.y = i7;
        } else {
            layoutParams.y = i6;
        }
    }

    public static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
