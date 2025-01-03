package com.google.android.material.datepicker;

import a.h.i.d;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import c.c.a.c.l.g;
import c.c.a.c.l.l;
import c.c.a.c.l.p;
import c.c.a.c.r.r;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import com.shix.shixipc.utilcode.LogUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    public String f10480a;

    /* renamed from: b, reason: collision with root package name */
    public Long f10481b = null;

    /* renamed from: c, reason: collision with root package name */
    public Long f10482c = null;

    /* renamed from: d, reason: collision with root package name */
    public Long f10483d = null;

    /* renamed from: e, reason: collision with root package name */
    public Long f10484e = null;

    public static class c implements Parcelable.Creator<RangeDateSelector> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f10481b = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f10482c = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RangeDateSelector[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }
    }

    public final boolean a(long j, long j2) {
        return j <= j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void f(long j) {
        Long l = this.f10481b;
        if (l == null) {
            this.f10481b = Long.valueOf(j);
        } else if (this.f10482c == null && a(l.longValue(), j)) {
            this.f10482c = Long.valueOf(j);
        } else {
            this.f10482c = null;
            this.f10481b = Long.valueOf(j);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean g() {
        Long l = this.f10481b;
        return (l == null || this.f10482c == null || !a(l.longValue(), this.f10482c.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> l() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f10481b;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.f10482c;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f10481b);
        parcel.writeValue(this.f10482c);
    }

    public class a extends c.c.a.c.l.c {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f10485f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f10486g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ l f10487h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, l lVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f10485f = textInputLayout2;
            this.f10486g = textInputLayout3;
            this.f10487h = lVar;
        }

        @Override // c.c.a.c.l.c
        public void a(Long l) {
            RangeDateSelector.this.f10483d = l;
            RangeDateSelector.this.a(this.f10485f, this.f10486g, this.f10487h);
        }

        @Override // c.c.a.c.l.c
        public void a() {
            RangeDateSelector.this.f10483d = null;
            RangeDateSelector.this.a(this.f10485f, this.f10486g, this.f10487h);
        }
    }

    public class b extends c.c.a.c.l.c {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f10489f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f10490g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ l f10491h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, l lVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f10489f = textInputLayout2;
            this.f10490g = textInputLayout3;
            this.f10491h = lVar;
        }

        @Override // c.c.a.c.l.c
        public void a(Long l) {
            RangeDateSelector.this.f10484e = l;
            RangeDateSelector.this.a(this.f10489f, this.f10490g, this.f10491h);
        }

        @Override // c.c.a.c.l.c
        public void a() {
            RangeDateSelector.this.f10484e = null;
            RangeDateSelector.this.a(this.f10489f, this.f10490g, this.f10491h);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<d<Long, Long>> b() {
        if (this.f10481b == null || this.f10482c == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(this.f10481b, this.f10482c));
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public d<Long, Long> o() {
        return new d<>(this.f10481b, this.f10482c);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String a(Context context) {
        Resources resources = context.getResources();
        if (this.f10481b == null && this.f10482c == null) {
            return resources.getString(R$string.mtrl_picker_range_header_unselected);
        }
        Long l = this.f10482c;
        if (l == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_start_selected, c.c.a.c.l.d.a(this.f10481b.longValue()));
        }
        Long l2 = this.f10481b;
        if (l2 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_end_selected, c.c.a.c.l.d.a(l.longValue()));
        }
        d<String, String> a2 = c.c.a.c.l.d.a(l2, l);
        return resources.getString(R$string.mtrl_picker_range_header_selected, a2.f1104a, a2.f1105b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int b(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return c.c.a.c.t.b.a(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R$dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R$attr.materialCalendarTheme : R$attr.materialCalendarFullscreenTheme, g.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, l<d<Long, Long>> lVar) {
        View inflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R$id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R$id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (c.c.a.c.r.d.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f10480a = inflate.getResources().getString(R$string.mtrl_picker_invalid_range);
        SimpleDateFormat a2 = p.a();
        Long l = this.f10481b;
        if (l != null) {
            editText.setText(a2.format(l));
            this.f10483d = this.f10481b;
        }
        Long l2 = this.f10482c;
        if (l2 != null) {
            editText2.setText(a2.format(l2));
            this.f10484e = this.f10482c;
        }
        String a3 = p.a(inflate.getResources(), a2);
        editText.addTextChangedListener(new a(a3, a2, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, lVar));
        editText2.addTextChangedListener(new b(a3, a2, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, lVar));
        r.g(editText);
        return inflate;
    }

    public final void b(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f10480a);
        textInputLayout2.setError(LogUtils.PLACEHOLDER);
    }

    public final void a(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, l<d<Long, Long>> lVar) {
        Long l = this.f10483d;
        if (l != null && this.f10484e != null) {
            if (a(l.longValue(), this.f10484e.longValue())) {
                this.f10481b = this.f10483d;
                this.f10482c = this.f10484e;
                lVar.a(o());
                return;
            } else {
                b(textInputLayout, textInputLayout2);
                lVar.a();
                return;
            }
        }
        a(textInputLayout, textInputLayout2);
        lVar.a();
    }

    public final void a(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f10480a.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !LogUtils.PLACEHOLDER.contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }
}
