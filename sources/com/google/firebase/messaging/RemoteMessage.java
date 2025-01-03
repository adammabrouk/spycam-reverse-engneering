package com.google.firebase.messaging;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.b.p.w;
import c.c.b.p.y;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new y();

    /* renamed from: a, reason: collision with root package name */
    public Bundle f10729a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f10730b;

    /* renamed from: c, reason: collision with root package name */
    public a f10731c;

    public RemoteMessage(Bundle bundle) {
        this.f10729a = bundle;
    }

    public final Map<String, String> u() {
        if (this.f10730b == null) {
            Bundle bundle = this.f10729a;
            a.e.a aVar = new a.e.a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        aVar.put(str, str2);
                    }
                }
            }
            this.f10730b = aVar;
        }
        return this.f10730b;
    }

    public final a v() {
        if (this.f10731c == null && w.a(this.f10729a)) {
            this.f10731c = new a(new w(this.f10729a));
        }
        return this.f10731c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, this.f10729a, false);
        b.a(parcel, a2);
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10732a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f10733b;

        public a(w wVar) {
            wVar.a("gcm.n.title");
            wVar.e("gcm.n.title");
            a(wVar, "gcm.n.title");
            this.f10732a = wVar.a("gcm.n.body");
            wVar.e("gcm.n.body");
            a(wVar, "gcm.n.body");
            wVar.a("gcm.n.icon");
            wVar.b();
            wVar.a("gcm.n.tag");
            wVar.a("gcm.n.color");
            wVar.a("gcm.n.click_action");
            wVar.a("gcm.n.android_channel_id");
            this.f10733b = wVar.a();
            wVar.a("gcm.n.image");
            wVar.a("gcm.n.ticker");
            wVar.c("gcm.n.notification_priority");
            wVar.c("gcm.n.visibility");
            wVar.c("gcm.n.notification_count");
            wVar.b("gcm.n.sticky");
            wVar.b("gcm.n.local_only");
            wVar.b("gcm.n.default_sound");
            wVar.b("gcm.n.default_vibrate_timings");
            wVar.b("gcm.n.default_light_settings");
            wVar.d("gcm.n.event_time");
            wVar.d();
            wVar.c();
        }

        public static String[] a(w wVar, String str) {
            Object[] f2 = wVar.f(str);
            if (f2 == null) {
                return null;
            }
            String[] strArr = new String[f2.length];
            for (int i2 = 0; i2 < f2.length; i2++) {
                strArr[i2] = String.valueOf(f2[i2]);
            }
            return strArr;
        }

        public String a() {
            return this.f10732a;
        }
    }
}
