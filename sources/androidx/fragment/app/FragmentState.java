package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f2620a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2621b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2622c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2623d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2624e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2625f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2626g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2627h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2628i;
    public final Bundle j;
    public final boolean k;
    public final int l;
    public Bundle m;

    public class a implements Parcelable.Creator<FragmentState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f2620a = fragment.getClass().getName();
        this.f2621b = fragment.mWho;
        this.f2622c = fragment.mFromLayout;
        this.f2623d = fragment.mFragmentId;
        this.f2624e = fragment.mContainerId;
        this.f2625f = fragment.mTag;
        this.f2626g = fragment.mRetainInstance;
        this.f2627h = fragment.mRemoving;
        this.f2628i = fragment.mDetached;
        this.j = fragment.mArguments;
        this.k = fragment.mHidden;
        this.l = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(RecyclerView.c0.FLAG_IGNORE);
        sb.append("FragmentState{");
        sb.append(this.f2620a);
        sb.append(" (");
        sb.append(this.f2621b);
        sb.append(")}:");
        if (this.f2622c) {
            sb.append(" fromLayout");
        }
        if (this.f2624e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2624e));
        }
        String str = this.f2625f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2625f);
        }
        if (this.f2626g) {
            sb.append(" retainInstance");
        }
        if (this.f2627h) {
            sb.append(" removing");
        }
        if (this.f2628i) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f2620a);
        parcel.writeString(this.f2621b);
        parcel.writeInt(this.f2622c ? 1 : 0);
        parcel.writeInt(this.f2623d);
        parcel.writeInt(this.f2624e);
        parcel.writeString(this.f2625f);
        parcel.writeInt(this.f2626g ? 1 : 0);
        parcel.writeInt(this.f2627h ? 1 : 0);
        parcel.writeInt(this.f2628i ? 1 : 0);
        parcel.writeBundle(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.l);
    }

    public FragmentState(Parcel parcel) {
        this.f2620a = parcel.readString();
        this.f2621b = parcel.readString();
        this.f2622c = parcel.readInt() != 0;
        this.f2623d = parcel.readInt();
        this.f2624e = parcel.readInt();
        this.f2625f = parcel.readString();
        this.f2626g = parcel.readInt() != 0;
        this.f2627h = parcel.readInt() != 0;
        this.f2628i = parcel.readInt() != 0;
        this.j = parcel.readBundle();
        this.k = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.l = parcel.readInt();
    }
}
