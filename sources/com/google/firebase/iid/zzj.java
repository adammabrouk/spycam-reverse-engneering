package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import c.c.b.l.h1;
import c.c.b.l.i1;
import c.c.b.l.u0;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public class zzj implements Parcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new u0();

    /* renamed from: a, reason: collision with root package name */
    public Messenger f10723a;

    /* renamed from: b, reason: collision with root package name */
    public i1 f10724b;

    /* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
    public static final class a extends ClassLoader {
        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (!FirebaseInstanceId.p()) {
                return zzj.class;
            }
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            return zzj.class;
        }
    }

    public zzj(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f10723a = new Messenger(iBinder);
        } else {
            this.f10724b = new h1(iBinder);
        }
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f10723a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f10724b.a(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zzj) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.f10723a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f10724b.asBinder());
        }
    }

    public final IBinder a() {
        Messenger messenger = this.f10723a;
        return messenger != null ? messenger.getBinder() : this.f10724b.asBinder();
    }
}
