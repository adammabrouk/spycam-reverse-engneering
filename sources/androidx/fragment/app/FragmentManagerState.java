package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<FragmentState> f2612a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f2613b;

    /* renamed from: c, reason: collision with root package name */
    public BackStackState[] f2614c;

    /* renamed from: d, reason: collision with root package name */
    public int f2615d;

    /* renamed from: e, reason: collision with root package name */
    public String f2616e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<String> f2617f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<Bundle> f2618g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<FragmentManager.LaunchedFragmentInfo> f2619h;

    public class a implements Parcelable.Creator<FragmentManagerState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    }

    public FragmentManagerState() {
        this.f2616e = null;
        this.f2617f = new ArrayList<>();
        this.f2618g = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f2612a);
        parcel.writeStringList(this.f2613b);
        parcel.writeTypedArray(this.f2614c, i2);
        parcel.writeInt(this.f2615d);
        parcel.writeString(this.f2616e);
        parcel.writeStringList(this.f2617f);
        parcel.writeTypedList(this.f2618g);
        parcel.writeTypedList(this.f2619h);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f2616e = null;
        this.f2617f = new ArrayList<>();
        this.f2618g = new ArrayList<>();
        this.f2612a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f2613b = parcel.createStringArrayList();
        this.f2614c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f2615d = parcel.readInt();
        this.f2616e = parcel.readString();
        this.f2617f = parcel.createStringArrayList();
        this.f2618g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f2619h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
