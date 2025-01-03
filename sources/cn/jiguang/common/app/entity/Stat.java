package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Stat extends ProcFile {
    public static final Parcelable.Creator<Stat> CREATOR = new Parcelable.Creator<Stat>() { // from class: cn.jiguang.common.app.entity.Stat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Stat createFromParcel(Parcel parcel) {
            return new Stat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Stat[] newArray(int i2) {
            return new Stat[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String[] f8842a;

    public Stat(Parcel parcel) {
        super(parcel);
        this.f8842a = parcel.createStringArray();
    }

    @Override // cn.jiguang.common.app.entity.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeStringArray(this.f8842a);
    }
}
