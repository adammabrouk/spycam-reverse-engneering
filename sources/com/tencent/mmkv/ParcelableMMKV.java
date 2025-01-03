package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f11241a;

    /* renamed from: b, reason: collision with root package name */
    public int f11242b;

    /* renamed from: c, reason: collision with root package name */
    public int f11243c;

    /* renamed from: d, reason: collision with root package name */
    public String f11244d;

    public static class a implements Parcelable.Creator<ParcelableMMKV> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMMKV createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMMKV[] newArray(int i2) {
            return new ParcelableMMKV[i2];
        }
    }

    public /* synthetic */ ParcelableMMKV(String str, int i2, int i3, String str2, a aVar) {
        this(str, i2, i3, str2);
    }

    public MMKV a() {
        int i2;
        int i3 = this.f11242b;
        if (i3 < 0 || (i2 = this.f11243c) < 0) {
            return null;
        }
        return MMKV.a(this.f11241a, i3, i2, this.f11244d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        try {
            parcel.writeString(this.f11241a);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.f11242b);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.f11243c);
            int i3 = i2 | 1;
            fromFd.writeToParcel(parcel, i3);
            fromFd2.writeToParcel(parcel, i3);
            if (this.f11244d != null) {
                parcel.writeString(this.f11244d);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public ParcelableMMKV(MMKV mmkv) {
        this.f11242b = -1;
        this.f11243c = -1;
        this.f11244d = null;
        this.f11241a = mmkv.mmapID();
        this.f11242b = mmkv.ashmemFD();
        this.f11243c = mmkv.ashmemMetaFD();
        this.f11244d = mmkv.cryptKey();
    }

    public ParcelableMMKV(String str, int i2, int i3, String str2) {
        this.f11242b = -1;
        this.f11243c = -1;
        this.f11244d = null;
        this.f11241a = str;
        this.f11242b = i2;
        this.f11243c = i3;
        this.f11244d = str2;
    }
}
