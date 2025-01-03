package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i2) {
            return new UserInfoBean[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public long f10833a;

    /* renamed from: b, reason: collision with root package name */
    public int f10834b;

    /* renamed from: c, reason: collision with root package name */
    public String f10835c;

    /* renamed from: d, reason: collision with root package name */
    public String f10836d;

    /* renamed from: e, reason: collision with root package name */
    public long f10837e;

    /* renamed from: f, reason: collision with root package name */
    public long f10838f;

    /* renamed from: g, reason: collision with root package name */
    public long f10839g;

    /* renamed from: h, reason: collision with root package name */
    public long f10840h;

    /* renamed from: i, reason: collision with root package name */
    public long f10841i;
    public String j;
    public long k;
    public boolean l;
    public String m;
    public String n;
    public int o;
    public int p;
    public int q;
    public Map<String, String> r;
    public Map<String, String> s;

    public UserInfoBean() {
        this.k = 0L;
        this.l = false;
        this.m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10834b);
        parcel.writeString(this.f10835c);
        parcel.writeString(this.f10836d);
        parcel.writeLong(this.f10837e);
        parcel.writeLong(this.f10838f);
        parcel.writeLong(this.f10839g);
        parcel.writeLong(this.f10840h);
        parcel.writeLong(this.f10841i);
        parcel.writeString(this.j);
        parcel.writeLong(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        z.b(parcel, this.r);
        z.b(parcel, this.s);
        parcel.writeString(this.n);
        parcel.writeInt(this.o);
    }

    public UserInfoBean(Parcel parcel) {
        this.k = 0L;
        this.l = false;
        this.m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.f10834b = parcel.readInt();
        this.f10835c = parcel.readString();
        this.f10836d = parcel.readString();
        this.f10837e = parcel.readLong();
        this.f10838f = parcel.readLong();
        this.f10839g = parcel.readLong();
        this.f10840h = parcel.readLong();
        this.f10841i = parcel.readLong();
        this.j = parcel.readString();
        this.k = parcel.readLong();
        this.l = parcel.readByte() == 1;
        this.m = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = z.b(parcel);
        this.s = z.b(parcel);
        this.n = parcel.readString();
        this.o = parcel.readInt();
    }
}
