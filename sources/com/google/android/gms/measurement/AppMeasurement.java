package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import c.c.a.b.c.o.r;
import c.c.a.b.g.b.a5;
import c.c.a.b.g.b.c7;
import c.c.a.b.g.b.f6;
import c.c.a.b.g.b.x5;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
@Deprecated
/* loaded from: classes.dex */
public class AppMeasurement {

    /* renamed from: d, reason: collision with root package name */
    public static volatile AppMeasurement f10193d;

    /* renamed from: a, reason: collision with root package name */
    public final a5 f10194a;

    /* renamed from: b, reason: collision with root package name */
    public final c7 f10195b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10196c;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString(OSSHeaders.ORIGIN, str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                x5.a(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }

        public ConditionalUserProperty(Bundle bundle) {
            r.a(bundle);
            this.mAppId = (String) x5.a(bundle, "app_id", String.class, null);
            this.mOrigin = (String) x5.a(bundle, OSSHeaders.ORIGIN, String.class, null);
            this.mName = (String) x5.a(bundle, "name", String.class, null);
            this.mValue = x5.a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) x5.a(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) x5.a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) x5.a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) x5.a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) x5.a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) x5.a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) x5.a(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) x5.a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) x5.a(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) x5.a(bundle, "active", Boolean.class, false)).booleanValue();
            this.mCreationTimestamp = ((Long) x5.a(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) x5.a(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
    public interface a extends f6 {
    }

    public AppMeasurement(a5 a5Var) {
        r.a(a5Var);
        this.f10194a = a5Var;
        this.f10195b = null;
        this.f10196c = false;
    }

    public static AppMeasurement a(Context context, String str, String str2) {
        if (f10193d == null) {
            synchronized (AppMeasurement.class) {
                if (f10193d == null) {
                    c7 b2 = b(context, null);
                    if (b2 != null) {
                        f10193d = new AppMeasurement(b2);
                    } else {
                        f10193d = new AppMeasurement(a5.a(context, null, null, null));
                    }
                }
            }
        }
        return f10193d;
    }

    public static c7 b(Context context, Bundle bundle) {
        try {
            return (c7) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, bundle);
        } catch (ClassNotFoundException | Exception unused) {
            return null;
        }
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return a(context, (String) null, (String) null);
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        if (this.f10196c) {
            this.f10195b.a(str);
        } else {
            this.f10194a.I().a(str, this.f10194a.b().b());
        }
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (this.f10196c) {
            this.f10195b.a(str, str2, bundle);
        } else {
            this.f10194a.u().c(str, str2, bundle);
        }
    }

    @Keep
    public void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        if (this.f10196c) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f10194a.u().a(str, str2, str3, bundle);
        throw null;
    }

    @Keep
    public void endAdUnitExposure(String str) {
        if (this.f10196c) {
            this.f10195b.c(str);
        } else {
            this.f10194a.I().b(str, this.f10194a.b().b());
        }
    }

    @Keep
    public long generateEventId() {
        return this.f10196c ? this.f10195b.E() : this.f10194a.v().s();
    }

    @Keep
    public String getAppInstanceId() {
        return this.f10196c ? this.f10195b.C() : this.f10194a.u().H();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> a2 = this.f10196c ? this.f10195b.a(str, str2) : this.f10194a.u().a(str, str2);
        ArrayList arrayList = new ArrayList(a2 == null ? 0 : a2.size());
        Iterator<Bundle> it = a2.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        if (this.f10196c) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f10194a.u().a(str, str2, str3);
        throw null;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.f10196c ? this.f10195b.zzb() : this.f10194a.u().K();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.f10196c ? this.f10195b.zza() : this.f10194a.u().J();
    }

    @Keep
    public String getGmpAppId() {
        return this.f10196c ? this.f10195b.D() : this.f10194a.u().L();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        if (this.f10196c) {
            return this.f10195b.b(str);
        }
        this.f10194a.u();
        r.b(str);
        return 25;
    }

    @Keep
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.f10196c ? this.f10195b.a(str, str2, z) : this.f10194a.u().a(str, str2, z);
    }

    @Keep
    public Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        if (this.f10196c) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f10194a.u().a(str, str2, str3, z);
        throw null;
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f10196c) {
            this.f10195b.b(str, str2, bundle);
        } else {
            this.f10194a.u().a(str, str2, bundle);
        }
    }

    public void registerOnMeasurementEventListener(a aVar) {
        if (this.f10196c) {
            this.f10195b.a(aVar);
        } else {
            this.f10194a.u().a(aVar);
        }
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        r.a(conditionalUserProperty);
        if (this.f10196c) {
            this.f10195b.a(conditionalUserProperty.a());
        } else {
            this.f10194a.u().a(conditionalUserProperty.a());
        }
    }

    @Keep
    public void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        r.a(conditionalUserProperty);
        if (this.f10196c) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f10194a.u().b(conditionalUserProperty.a());
        throw null;
    }

    public void unregisterOnMeasurementEventListener(a aVar) {
        if (this.f10196c) {
            this.f10195b.b(aVar);
        } else {
            this.f10194a.u().b(aVar);
        }
    }

    public AppMeasurement(c7 c7Var) {
        r.a(c7Var);
        this.f10195b = c7Var;
        this.f10194a = null;
        this.f10196c = true;
    }

    public static AppMeasurement a(Context context, Bundle bundle) {
        if (f10193d == null) {
            synchronized (AppMeasurement.class) {
                if (f10193d == null) {
                    c7 b2 = b(context, bundle);
                    if (b2 != null) {
                        f10193d = new AppMeasurement(b2);
                    } else {
                        f10193d = new AppMeasurement(a5.a(context, null, null, bundle));
                    }
                }
            }
        }
        return f10193d;
    }

    public final void a(boolean z) {
        if (this.f10196c) {
            this.f10195b.a(z);
        } else {
            this.f10194a.u().b(z);
        }
    }

    public void a(String str, String str2, Object obj) {
        r.b(str);
        if (this.f10196c) {
            this.f10195b.a(str, str2, obj);
        } else {
            this.f10194a.u().a(str, str2, obj, true);
        }
    }
}
