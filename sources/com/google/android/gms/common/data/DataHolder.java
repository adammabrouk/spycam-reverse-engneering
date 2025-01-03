package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import c.c.a.b.c.m.b;
import c.c.a.b.c.m.c;
import c.c.a.b.c.o.r;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    public final int f10056a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f10057b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f10058c;

    /* renamed from: d, reason: collision with root package name */
    public final CursorWindow[] f10059d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10060e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f10061f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f10062g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10063h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10064i = true;

    static {
        new b(new String[0], null);
    }

    public DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f10056a = i2;
        this.f10057b = strArr;
        this.f10059d = cursorWindowArr;
        this.f10060e = i3;
        this.f10061f = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.f10063h) {
                this.f10063h = true;
                for (int i2 = 0; i2 < this.f10059d.length; i2++) {
                    this.f10059d[i2].close();
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (this.f10064i && this.f10059d.length > 0 && !w()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle u() {
        return this.f10061f;
    }

    public final int v() {
        return this.f10060e;
    }

    public final boolean w() {
        boolean z;
        synchronized (this) {
            z = this.f10063h;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.c.a.b.c.o.v.b.a(parcel);
        c.c.a.b.c.o.v.b.a(parcel, 1, this.f10057b, false);
        c.c.a.b.c.o.v.b.a(parcel, 2, (Parcelable[]) this.f10059d, i2, false);
        c.c.a.b.c.o.v.b.a(parcel, 3, v());
        c.c.a.b.c.o.v.b.a(parcel, 4, u(), false);
        c.c.a.b.c.o.v.b.a(parcel, 1000, this.f10056a);
        c.c.a.b.c.o.v.b.a(parcel, a2);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    public final void x() {
        this.f10058c = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.f10057b;
            if (i3 >= strArr.length) {
                break;
            }
            this.f10058c.putInt(strArr[i3], i3);
            i3++;
        }
        this.f10062g = new int[this.f10059d.length];
        int i4 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f10059d;
            if (i2 >= cursorWindowArr.length) {
                return;
            }
            this.f10062g[i2] = i4;
            i4 += this.f10059d[i2].getNumRows() - (i4 - cursorWindowArr[i2].getStartPosition());
            i2++;
        }
    }

    public static class a {
        public a(String[] strArr, String str) {
            r.a(strArr);
            new ArrayList();
            new HashMap();
        }

        public /* synthetic */ a(String[] strArr, String str, b bVar) {
            this(strArr, null);
        }
    }
}
