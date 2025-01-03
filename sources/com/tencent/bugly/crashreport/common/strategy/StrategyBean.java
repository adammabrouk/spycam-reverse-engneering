package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i2) {
            return new StrategyBean[i2];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public static String f10882a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b, reason: collision with root package name */
    public static String f10883b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c, reason: collision with root package name */
    public long f10884c;

    /* renamed from: d, reason: collision with root package name */
    public long f10885d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10886e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10887f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10888g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10889h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10890i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public long n;
    public long o;
    public String p;
    public String q;
    public String r;
    public Map<String, String> s;
    public int t;
    public long u;
    public long v;

    public StrategyBean() {
        this.f10884c = -1L;
        this.f10885d = -1L;
        this.f10886e = true;
        this.f10887f = true;
        this.f10888g = true;
        this.f10889h = true;
        this.f10890i = false;
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = true;
        this.o = 30000L;
        this.p = f10882a;
        this.q = f10883b;
        this.t = 10;
        this.u = 300000L;
        this.v = -1L;
        this.f10885d = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L");
        sb.append("@)");
        sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K");
        sb.append("@!");
        this.r = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f10885d);
        parcel.writeByte(this.f10886e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10887f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10888g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        z.b(parcel, this.s);
        parcel.writeByte(this.f10889h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10890i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.n);
        parcel.writeInt(this.t);
        parcel.writeLong(this.u);
        parcel.writeLong(this.v);
    }

    public StrategyBean(Parcel parcel) {
        this.f10884c = -1L;
        this.f10885d = -1L;
        boolean z = true;
        this.f10886e = true;
        this.f10887f = true;
        this.f10888g = true;
        this.f10889h = true;
        this.f10890i = false;
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = true;
        this.o = 30000L;
        this.p = f10882a;
        this.q = f10883b;
        this.t = 10;
        this.u = 300000L;
        this.v = -1L;
        try {
            String str = "S(@L@L@)";
            this.f10885d = parcel.readLong();
            this.f10886e = parcel.readByte() == 1;
            this.f10887f = parcel.readByte() == 1;
            this.f10888g = parcel.readByte() == 1;
            this.p = parcel.readString();
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = z.b(parcel);
            this.f10889h = parcel.readByte() == 1;
            this.f10890i = parcel.readByte() == 1;
            this.l = parcel.readByte() == 1;
            this.m = parcel.readByte() == 1;
            this.o = parcel.readLong();
            this.j = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.k = z;
            this.n = parcel.readLong();
            this.t = parcel.readInt();
            this.u = parcel.readLong();
            this.v = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
