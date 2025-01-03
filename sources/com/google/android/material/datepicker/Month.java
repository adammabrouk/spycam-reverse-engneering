package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.c.l.p;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10473a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10474b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10475c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10476d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10477e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10478f;

    /* renamed from: g, reason: collision with root package name */
    public final long f10479g;

    public static class a implements Parcelable.Creator<Month> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Month createFromParcel(Parcel parcel) {
            return Month.a(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    }

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar a2 = p.a(calendar);
        this.f10473a = a2;
        this.f10475c = a2.get(2);
        this.f10476d = this.f10473a.get(1);
        this.f10477e = this.f10473a.getMaximum(7);
        this.f10478f = this.f10473a.getActualMaximum(5);
        this.f10474b = p.g().format(this.f10473a.getTime());
        this.f10479g = this.f10473a.getTimeInMillis();
    }

    public static Month a(int i2, int i3) {
        Calendar f2 = p.f();
        f2.set(1, i2);
        f2.set(2, i3);
        return new Month(f2);
    }

    public static Month b(long j) {
        Calendar f2 = p.f();
        f2.setTimeInMillis(j);
        return new Month(f2);
    }

    public static Month e() {
        return new Month(p.d());
    }

    public String c() {
        return this.f10474b;
    }

    public long d() {
        return this.f10473a.getTimeInMillis();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f10475c == month.f10475c && this.f10476d == month.f10476d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10475c), Integer.valueOf(this.f10476d)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10476d);
        parcel.writeInt(this.f10475c);
    }

    public int b(Month month) {
        if (this.f10473a instanceof GregorianCalendar) {
            return ((month.f10476d - this.f10476d) * 12) + (month.f10475c - this.f10475c);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public int a() {
        int firstDayOfWeek = this.f10473a.get(7) - this.f10473a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f10477e : firstDayOfWeek;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.f10473a.compareTo(month.f10473a);
    }

    public Month b(int i2) {
        Calendar a2 = p.a(this.f10473a);
        a2.add(2, i2);
        return new Month(a2);
    }

    public long a(int i2) {
        Calendar a2 = p.a(this.f10473a);
        a2.set(5, i2);
        return a2.getTimeInMillis();
    }
}
