package c.c.a.c.l;

import a.h.j.y;
import a.k.a.r;
import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.Month;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: MaterialDatePicker.java */
/* loaded from: classes.dex */
public final class g<S> extends a.k.a.c {
    public static final Object I = "CONFIRM_BUTTON_TAG";
    public static final Object J = "CANCEL_BUTTON_TAG";
    public static final Object K = "TOGGLE_BUTTON_TAG";
    public int A;
    public CharSequence B;
    public boolean C;
    public int D;
    public TextView E;
    public CheckableImageButton F;
    public c.c.a.c.w.h G;
    public Button H;
    public final LinkedHashSet<h<? super S>> q = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> r = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> t = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> u = new LinkedHashSet<>();
    public int v;
    public DateSelector<S> w;
    public m<S> x;
    public CalendarConstraints y;
    public f<S> z;

    /* compiled from: MaterialDatePicker.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = g.this.q.iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(g.this.g());
            }
            g.this.a();
        }
    }

    /* compiled from: MaterialDatePicker.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = g.this.r.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            g.this.a();
        }
    }

    /* compiled from: MaterialDatePicker.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.H.setEnabled(g.this.w.g());
            g.this.F.toggle();
            g gVar = g.this;
            gVar.a(gVar.F);
            g.this.h();
        }
    }

    public static long j() {
        return Month.e().f10479g;
    }

    public final void h() {
        this.z = f.a(this.w, a(requireContext()), this.y);
        this.x = this.F.isChecked() ? i.a(this.w, this.y) : this.z;
        i();
        r b2 = getChildFragmentManager().b();
        b2.a(R$id.mtrl_calendar_frame, this.x);
        b2.c();
        this.x.a(new c());
    }

    public final void i() {
        String f2 = f();
        this.E.setContentDescription(String.format(getString(R$string.mtrl_picker_announce_current_selection), f2));
        this.E.setText(f2);
    }

    @Override // a.k.a.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.t.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // a.k.a.c, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.v = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.w = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.y = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.A = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.B = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.D = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.C ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.C) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(e(context), -2));
        } else {
            View findViewById = inflate.findViewById(R$id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R$id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(e(context), -1));
            findViewById2.setMinimumHeight(d(requireContext()));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.E = textView;
        y.g(textView, 1);
        this.F = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.B;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.A);
        }
        b(context);
        this.H = (Button) inflate.findViewById(R$id.confirm_button);
        if (this.w.g()) {
            this.H.setEnabled(true);
        } else {
            this.H.setEnabled(false);
        }
        this.H.setTag(I);
        this.H.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag(J);
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // a.k.a.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // a.k.a.c, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.v);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.w);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.y);
        if (this.z.e() != null) {
            bVar.a(this.z.e().f10479g);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.A);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.B);
    }

    @Override // a.k.a.c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = e().getWindow();
        if (this.C) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.G);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.G, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new c.c.a.c.m.a(e(), rect));
        }
        h();
    }

    @Override // a.k.a.c, androidx.fragment.app.Fragment
    public void onStop() {
        this.x.a();
        super.onStop();
    }

    /* compiled from: MaterialDatePicker.java */
    public class c extends l<S> {
        public c() {
        }

        @Override // c.c.a.c.l.l
        public void a(S s) {
            g.this.i();
            g.this.H.setEnabled(g.this.w.g());
        }

        @Override // c.c.a.c.l.l
        public void a() {
            g.this.H.setEnabled(false);
        }
    }

    public static Drawable c(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, a.b.b.a.a.c(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], a.b.b.a.a.c(context, R$drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    public static int d(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height) + (j.f5453e * resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height)) + ((j.f5453e - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding);
    }

    public static int e(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i2 = Month.e().f10477e;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding));
    }

    public final void b(Context context) {
        this.F.setTag(K);
        this.F.setImageDrawable(c(context));
        this.F.setChecked(this.D != 0);
        y.a(this.F, (a.h.j.a) null);
        a(this.F);
        this.F.setOnClickListener(new d());
    }

    public String f() {
        return this.w.a(getContext());
    }

    public final S g() {
        return this.w.o();
    }

    public static boolean f(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.c.a.c.t.b.a(context, R$attr.materialCalendarStyle, f.class.getCanonicalName()), new int[]{R.attr.windowFullscreen});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final int a(Context context) {
        int i2 = this.v;
        return i2 != 0 ? i2 : this.w.b(context);
    }

    @Override // a.k.a.c
    public final Dialog a(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), a(requireContext()));
        Context context = dialog.getContext();
        this.C = f(context);
        int a2 = c.c.a.c.t.b.a(context, R$attr.colorSurface, g.class.getCanonicalName());
        c.c.a.c.w.h hVar = new c.c.a.c.w.h(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.G = hVar;
        hVar.a(context);
        this.G.a(ColorStateList.valueOf(a2));
        this.G.b(y.l(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public final void a(CheckableImageButton checkableImageButton) {
        String string;
        if (this.F.isChecked()) {
            string = checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.F.setContentDescription(string);
    }
}
