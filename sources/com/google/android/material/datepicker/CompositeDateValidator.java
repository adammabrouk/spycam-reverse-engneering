package com.google.android.material.datepicker;

import a.h.i.h;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<CalendarConstraints.DateValidator> f10469a;

    public static class a implements Parcelable.Creator<CompositeDateValidator> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            h.a(readArrayList);
            return new CompositeDateValidator(readArrayList, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompositeDateValidator[] newArray(int i2) {
            return new CompositeDateValidator[i2];
        }
    }

    public /* synthetic */ CompositeDateValidator(List list, a aVar) {
        this(list);
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean a(long j) {
        for (CalendarConstraints.DateValidator dateValidator : this.f10469a) {
            if (dateValidator != null && !dateValidator.a(j)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompositeDateValidator) {
            return this.f10469a.equals(((CompositeDateValidator) obj).f10469a);
        }
        return false;
    }

    public int hashCode() {
        return this.f10469a.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f10469a);
    }

    public CompositeDateValidator(List<CalendarConstraints.DateValidator> list) {
        this.f10469a = list;
    }
}
