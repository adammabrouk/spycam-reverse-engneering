package com.google.android.material.datepicker;

import a.h.i.d;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import c.c.a.c.l.c;
import c.c.a.c.l.g;
import c.c.a.c.l.l;
import c.c.a.c.l.p;
import c.c.a.c.r.r;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public Long f10493a;

    public static class b implements Parcelable.Creator<SingleDateSelector> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f10493a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SingleDateSelector[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<d<Long, Long>> b() {
        return new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void f(long j) {
        this.f10493a = Long.valueOf(j);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean g() {
        return this.f10493a != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> l() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f10493a;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f10493a);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int b(Context context) {
        return c.c.a.c.t.b.a(context, R$attr.materialCalendarTheme, g.class.getCanonicalName());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long o() {
        return this.f10493a;
    }

    public class a extends c {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ l f10494f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, l lVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f10494f = lVar;
        }

        @Override // c.c.a.c.l.c
        public void a(Long l) {
            if (l == null) {
                SingleDateSelector.this.a();
            } else {
                SingleDateSelector.this.f(l.longValue());
            }
            this.f10494f.a(SingleDateSelector.this.o());
        }

        @Override // c.c.a.c.l.c
        public void a() {
            this.f10494f.a();
        }
    }

    public final void a() {
        this.f10493a = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, l<Long> lVar) {
        View inflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R$id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (c.c.a.c.r.d.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat a2 = p.a();
        String a3 = p.a(inflate.getResources(), a2);
        Long l = this.f10493a;
        if (l != null) {
            editText.setText(a2.format(l));
        }
        editText.addTextChangedListener(new a(a3, a2, textInputLayout, calendarConstraints, lVar));
        r.g(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String a(Context context) {
        Resources resources = context.getResources();
        Long l = this.f10493a;
        if (l == null) {
            return resources.getString(R$string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R$string.mtrl_picker_date_header_selected, c.c.a.c.l.d.d(l.longValue()));
    }
}
