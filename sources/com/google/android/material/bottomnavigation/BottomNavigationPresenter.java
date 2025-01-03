package com.google.android.material.bottomnavigation;

import a.b.e.j.g;
import a.b.e.j.i;
import a.b.e.j.m;
import a.b.e.j.r;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.c.c.a;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes.dex */
public class BottomNavigationPresenter implements m {

    /* renamed from: a, reason: collision with root package name */
    public g f10365a;

    /* renamed from: b, reason: collision with root package name */
    public BottomNavigationMenuView f10366b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10367c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f10368d;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f10369a;

        /* renamed from: b, reason: collision with root package name */
        public ParcelableSparseArray f10370b;

        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f10369a);
            parcel.writeParcelable(this.f10370b, 0);
        }

        public SavedState(Parcel parcel) {
            this.f10369a = parcel.readInt();
            this.f10370b = (ParcelableSparseArray) parcel.readParcelable(SavedState.class.getClassLoader());
        }
    }

    @Override // a.b.e.j.m
    public void a(g gVar, boolean z) {
    }

    @Override // a.b.e.j.m
    public void a(m.a aVar) {
    }

    public void a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f10366b = bottomNavigationMenuView;
    }

    @Override // a.b.e.j.m
    public boolean a(g gVar, i iVar) {
        return false;
    }

    @Override // a.b.e.j.m
    public boolean a(r rVar) {
        return false;
    }

    public void b(boolean z) {
        this.f10367c = z;
    }

    @Override // a.b.e.j.m
    public boolean b(g gVar, i iVar) {
        return false;
    }

    @Override // a.b.e.j.m
    public int c() {
        return this.f10368d;
    }

    @Override // a.b.e.j.m
    public boolean f() {
        return false;
    }

    @Override // a.b.e.j.m
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f10369a = this.f10366b.getSelectedItemId();
        savedState.f10370b = a.a(this.f10366b.getBadgeDrawables());
        return savedState;
    }

    @Override // a.b.e.j.m
    public void a(Context context, g gVar) {
        this.f10365a = gVar;
        this.f10366b.a(gVar);
    }

    @Override // a.b.e.j.m
    public void a(boolean z) {
        if (this.f10367c) {
            return;
        }
        if (z) {
            this.f10366b.a();
        } else {
            this.f10366b.d();
        }
    }

    public void a(int i2) {
        this.f10368d = i2;
    }

    @Override // a.b.e.j.m
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f10366b.c(savedState.f10369a);
            this.f10366b.setBadgeDrawables(a.a(this.f10366b.getContext(), savedState.f10370b));
        }
    }
}
