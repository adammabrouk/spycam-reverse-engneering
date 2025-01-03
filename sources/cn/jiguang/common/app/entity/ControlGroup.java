package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: classes.dex */
public class ControlGroup implements Parcelable {
    public static final Parcelable.Creator<ControlGroup> CREATOR = new Parcelable.Creator<ControlGroup>() { // from class: cn.jiguang.common.app.entity.ControlGroup.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlGroup createFromParcel(Parcel parcel) {
            return new ControlGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlGroup[] newArray(int i2) {
            return new ControlGroup[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f8838a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8839b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8840c;

    public ControlGroup(Parcel parcel) {
        this.f8838a = parcel.readInt();
        this.f8839b = parcel.readString();
        this.f8840c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%d:%s:%s", Integer.valueOf(this.f8838a), this.f8839b, this.f8840c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8838a);
        parcel.writeString(this.f8839b);
        parcel.writeString(this.f8840c);
    }
}
