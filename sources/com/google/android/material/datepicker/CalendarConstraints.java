package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.c.l.g;
import c.c.a.c.l.p;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Month f10457a;

    /* renamed from: b, reason: collision with root package name */
    public final Month f10458b;

    /* renamed from: c, reason: collision with root package name */
    public final Month f10459c;

    /* renamed from: d, reason: collision with root package name */
    public final DateValidator f10460d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10461e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10462f;

    public interface DateValidator extends Parcelable {
        boolean a(long j);
    }

    public static class a implements Parcelable.Creator<CalendarConstraints> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    }

    public static final class b {

        /* renamed from: e, reason: collision with root package name */
        public static final long f10463e = p.a(Month.a(1900, 0).f10479g);

        /* renamed from: f, reason: collision with root package name */
        public static final long f10464f = p.a(Month.a(2100, 11).f10479g);

        /* renamed from: a, reason: collision with root package name */
        public long f10465a;

        /* renamed from: b, reason: collision with root package name */
        public long f10466b;

        /* renamed from: c, reason: collision with root package name */
        public Long f10467c;

        /* renamed from: d, reason: collision with root package name */
        public DateValidator f10468d;

        public b(CalendarConstraints calendarConstraints) {
            this.f10465a = f10463e;
            this.f10466b = f10464f;
            this.f10468d = DateValidatorPointForward.b(Long.MIN_VALUE);
            this.f10465a = calendarConstraints.f10457a.f10479g;
            this.f10466b = calendarConstraints.f10458b.f10479g;
            this.f10467c = Long.valueOf(calendarConstraints.f10459c.f10479g);
            this.f10468d = calendarConstraints.f10460d;
        }

        public b a(long j) {
            this.f10467c = Long.valueOf(j);
            return this;
        }

        public CalendarConstraints a() {
            if (this.f10467c == null) {
                long j = g.j();
                if (this.f10465a > j || j > this.f10466b) {
                    j = this.f10465a;
                }
                this.f10467c = Long.valueOf(j);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f10468d);
            return new CalendarConstraints(Month.b(this.f10465a), Month.b(this.f10466b), Month.b(this.f10467c.longValue()), (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY"), null);
        }
    }

    public /* synthetic */ CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator, a aVar) {
        this(month, month2, month3, dateValidator);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Month e() {
        return this.f10459c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f10457a.equals(calendarConstraints.f10457a) && this.f10458b.equals(calendarConstraints.f10458b) && this.f10459c.equals(calendarConstraints.f10459c) && this.f10460d.equals(calendarConstraints.f10460d);
    }

    public Month f() {
        return this.f10457a;
    }

    public int h() {
        return this.f10461e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10457a, this.f10458b, this.f10459c, this.f10460d});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f10457a, 0);
        parcel.writeParcelable(this.f10458b, 0);
        parcel.writeParcelable(this.f10459c, 0);
        parcel.writeParcelable(this.f10460d, 0);
    }

    public CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator) {
        this.f10457a = month;
        this.f10458b = month2;
        this.f10459c = month3;
        this.f10460d = dateValidator;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f10462f = month.b(month2) + 1;
        this.f10461e = (month2.f10476d - month.f10476d) + 1;
    }

    public DateValidator a() {
        return this.f10460d;
    }

    public boolean b(long j) {
        if (this.f10457a.a(1) <= j) {
            Month month = this.f10458b;
            if (j <= month.a(month.f10478f)) {
                return true;
            }
        }
        return false;
    }

    public Month c() {
        return this.f10458b;
    }

    public int d() {
        return this.f10462f;
    }

    public Month a(Month month) {
        if (month.compareTo(this.f10457a) < 0) {
            return this.f10457a;
        }
        return month.compareTo(this.f10458b) > 0 ? this.f10458b : month;
    }
}
