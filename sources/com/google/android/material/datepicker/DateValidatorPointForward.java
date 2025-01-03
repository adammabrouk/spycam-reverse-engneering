package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

/* loaded from: classes.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final long f10471a;

    public static class a implements Parcelable.Creator<DateValidatorPointForward> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DateValidatorPointForward[] newArray(int i2) {
            return new DateValidatorPointForward[i2];
        }
    }

    public /* synthetic */ DateValidatorPointForward(long j, a aVar) {
        this(j);
    }

    public static DateValidatorPointForward b(long j) {
        return new DateValidatorPointForward(j);
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean a(long j) {
        return j >= this.f10471a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f10471a == ((DateValidatorPointForward) obj).f10471a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f10471a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f10471a);
    }

    public DateValidatorPointForward(long j) {
        this.f10471a = j;
    }
}
