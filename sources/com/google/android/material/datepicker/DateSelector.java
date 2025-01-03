package com.google.android.material.datepicker;

import a.h.i.d;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.c.a.c.l.l;
import java.util.Collection;

/* loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, l<S> lVar);

    String a(Context context);

    int b(Context context);

    Collection<d<Long, Long>> b();

    void f(long j);

    boolean g();

    Collection<Long> l();

    S o();
}
