package cn.asus.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.a.a.e;

/* loaded from: classes.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new e();

    /* renamed from: a, reason: collision with root package name */
    public String f8095a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f8096b;

    public DataBuffer(Parcel parcel) {
        this.f8095a = parcel.readString();
        this.f8096b = parcel.readBundle();
    }

    public DataBuffer(String str, Bundle bundle) {
        this.f8095a = str;
        this.f8096b = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8095a);
        parcel.writeBundle(this.f8096b);
    }
}
