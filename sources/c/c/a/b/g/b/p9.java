package c.c.a.b.g.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.c.a.b.c.o.v.a;
import c.c.a.b.f.e.b1;
import c.c.a.b.f.e.f1;
import c.c.a.b.f.e.x0;
import c.c.a.b.f.e.z0;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzm;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class p9 extends i9 {
    public p9(l9 l9Var) {
        super(l9Var);
    }

    public static c.c.a.b.f.e.z0 b(c.c.a.b.f.e.x0 x0Var, String str) {
        for (c.c.a.b.f.e.z0 z0Var : x0Var.zza()) {
            if (z0Var.n().equals(str)) {
                return z0Var;
            }
        }
        return null;
    }

    public final void a(f1.a aVar, Object obj) {
        c.c.a.b.c.o.r.a(obj);
        aVar.zza();
        aVar.j();
        aVar.k();
        if (obj instanceof String) {
            aVar.b((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.b(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.a(((Double) obj).doubleValue());
        } else {
            c().t().a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final byte[] c(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            c().t().a("Failed to gzip content", e2);
            throw e2;
        }
    }

    @Override // c.c.a.b.g.b.i9
    public final boolean s() {
        return false;
    }

    public final List<Integer> t() {
        Map<String, String> a2 = r.a(this.f4840b.d());
        if (a2 == null || a2.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = r.P.a(null).intValue();
        for (Map.Entry<String, String> entry : a2.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            c().w().a("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e2) {
                    c().w().a("Experiment ID NumberFormatException", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public final byte[] b(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            c().t().a("Failed to ungzip content", e2);
            throw e2;
        }
    }

    public final void a(z0.a aVar, Object obj) {
        c.c.a.b.c.o.r.a(obj);
        aVar.zza();
        aVar.j();
        aVar.k();
        aVar.m();
        if (obj instanceof String) {
            aVar.b((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.a(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            aVar.a(((Double) obj).doubleValue());
        } else if (c.c.a.b.f.e.d9.a() && l().a(r.H0) && (obj instanceof Bundle[])) {
            aVar.a(a((Bundle[]) obj));
        } else {
            c().t().a("Ignoring invalid (type) event param value", obj);
        }
    }

    public final Object a(c.c.a.b.f.e.x0 x0Var, String str) {
        c.c.a.b.f.e.z0 b2 = b(x0Var, str);
        if (b2 == null) {
            return null;
        }
        if (b2.o()) {
            return b2.p();
        }
        if (b2.q()) {
            return Long.valueOf(b2.r());
        }
        if (b2.s()) {
            return Double.valueOf(b2.t());
        }
        if (!c.c.a.b.f.e.d9.a() || !l().a(r.H0) || b2.v() <= 0) {
            return null;
        }
        List<c.c.a.b.f.e.z0> u = b2.u();
        ArrayList arrayList = new ArrayList();
        for (c.c.a.b.f.e.z0 z0Var : u) {
            if (z0Var != null) {
                Bundle bundle = new Bundle();
                for (c.c.a.b.f.e.z0 z0Var2 : z0Var.u()) {
                    if (z0Var2.o()) {
                        bundle.putString(z0Var2.n(), z0Var2.p());
                    } else if (z0Var2.q()) {
                        bundle.putLong(z0Var2.n(), z0Var2.r());
                    } else if (z0Var2.s()) {
                        bundle.putDouble(z0Var2.n(), z0Var2.t());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final void a(x0.a aVar, String str, Object obj) {
        List<c.c.a.b.f.e.z0> zza = aVar.zza();
        int i2 = 0;
        while (true) {
            if (i2 >= zza.size()) {
                i2 = -1;
                break;
            } else if (str.equals(zza.get(i2).n())) {
                break;
            } else {
                i2++;
            }
        }
        z0.a B = c.c.a.b.f.e.z0.B();
        B.a(str);
        if (obj instanceof Long) {
            B.a(((Long) obj).longValue());
        } else if (obj instanceof String) {
            B.b((String) obj);
        } else if (obj instanceof Double) {
            B.a(((Double) obj).doubleValue());
        } else if (c.c.a.b.f.e.d9.a() && l().a(r.H0) && (obj instanceof Bundle[])) {
            B.a(a((Bundle[]) obj));
        }
        if (i2 >= 0) {
            aVar.a(i2, B);
        } else {
            aVar.a(B);
        }
    }

    public final String a(c.c.a.b.f.e.a1 a1Var) {
        if (a1Var == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (c.c.a.b.f.e.b1 b1Var : a1Var.zza()) {
            if (b1Var != null) {
                a(sb, 1);
                sb.append("bundle {\n");
                if (b1Var.zza()) {
                    a(sb, 1, "protocol_version", Integer.valueOf(b1Var.P()));
                }
                a(sb, 1, JThirdPlatFormInterface.KEY_PLATFORM, b1Var.r0());
                if (b1Var.y0()) {
                    a(sb, 1, "gmp_version", Long.valueOf(b1Var.n()));
                }
                if (b1Var.o()) {
                    a(sb, 1, "uploading_gmp_version", Long.valueOf(b1Var.p()));
                }
                if (b1Var.S()) {
                    a(sb, 1, "dynamite_version", Long.valueOf(b1Var.T()));
                }
                if (b1Var.J()) {
                    a(sb, 1, "config_version", Long.valueOf(b1Var.K()));
                }
                a(sb, 1, "gmp_app_id", b1Var.z());
                a(sb, 1, "admob_app_id", b1Var.R());
                a(sb, 1, "app_id", b1Var.w0());
                a(sb, 1, "app_version", b1Var.x0());
                if (b1Var.E()) {
                    a(sb, 1, "app_version_major", Integer.valueOf(b1Var.G()));
                }
                a(sb, 1, "firebase_instance_id", b1Var.D());
                if (b1Var.u()) {
                    a(sb, 1, "dev_cert_hash", Long.valueOf(b1Var.v()));
                }
                a(sb, 1, "app_store", b1Var.v0());
                if (b1Var.h0()) {
                    a(sb, 1, "upload_timestamp_millis", Long.valueOf(b1Var.i0()));
                }
                if (b1Var.j0()) {
                    a(sb, 1, "start_timestamp_millis", Long.valueOf(b1Var.k0()));
                }
                if (b1Var.l0()) {
                    a(sb, 1, "end_timestamp_millis", Long.valueOf(b1Var.m0()));
                }
                if (b1Var.n0()) {
                    a(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(b1Var.o0()));
                }
                if (b1Var.p0()) {
                    a(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(b1Var.q0()));
                }
                a(sb, 1, "app_instance_id", b1Var.t());
                a(sb, 1, "resettable_device_id", b1Var.q());
                a(sb, 1, "device_id", b1Var.I());
                a(sb, 1, "ds_id", b1Var.N());
                if (b1Var.r()) {
                    a(sb, 1, "limited_ad_tracking", Boolean.valueOf(b1Var.s()));
                }
                a(sb, 1, "os_version", b1Var.s0());
                a(sb, 1, "device_model", b1Var.t0());
                a(sb, 1, "user_default_language", b1Var.H());
                if (b1Var.F()) {
                    a(sb, 1, "time_zone_offset_minutes", Integer.valueOf(b1Var.u0()));
                }
                if (b1Var.w()) {
                    a(sb, 1, "bundle_sequential_index", Integer.valueOf(b1Var.x()));
                }
                if (b1Var.A()) {
                    a(sb, 1, "service_upload", Boolean.valueOf(b1Var.B()));
                }
                a(sb, 1, "health_monitor", b1Var.y());
                if (!l().a(r.N0) && b1Var.L() && b1Var.M() != 0) {
                    a(sb, 1, "android_id", Long.valueOf(b1Var.M()));
                }
                if (b1Var.O()) {
                    a(sb, 1, "retry_counter", Integer.valueOf(b1Var.Q()));
                }
                List<c.c.a.b.f.e.f1> f0 = b1Var.f0();
                if (f0 != null) {
                    for (c.c.a.b.f.e.f1 f1Var : f0) {
                        if (f1Var != null) {
                            a(sb, 2);
                            sb.append("user_property {\n");
                            a(sb, 2, "set_timestamp_millis", f1Var.zza() ? Long.valueOf(f1Var.n()) : null);
                            a(sb, 2, "name", i().c(f1Var.o()));
                            a(sb, 2, "string_value", f1Var.q());
                            a(sb, 2, "int_value", f1Var.r() ? Long.valueOf(f1Var.s()) : null);
                            a(sb, 2, "double_value", f1Var.t() ? Double.valueOf(f1Var.u()) : null);
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<c.c.a.b.f.e.v0> C = b1Var.C();
                String w0 = b1Var.w0();
                if (C != null) {
                    for (c.c.a.b.f.e.v0 v0Var : C) {
                        if (v0Var != null) {
                            a(sb, 2);
                            sb.append("audience_membership {\n");
                            if (v0Var.zza()) {
                                a(sb, 2, "audience_id", Integer.valueOf(v0Var.n()));
                            }
                            if (v0Var.r()) {
                                a(sb, 2, "new_audience", Boolean.valueOf(v0Var.s()));
                            }
                            a(sb, 2, "current_data", v0Var.o(), w0);
                            if (v0Var.p()) {
                                a(sb, 2, "previous_data", v0Var.q(), w0);
                            }
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<c.c.a.b.f.e.x0> b0 = b1Var.b0();
                if (b0 != null) {
                    for (c.c.a.b.f.e.x0 x0Var : b0) {
                        if (x0Var != null) {
                            a(sb, 2);
                            sb.append("event {\n");
                            a(sb, 2, "name", i().a(x0Var.o()));
                            if (x0Var.p()) {
                                a(sb, 2, "timestamp_millis", Long.valueOf(x0Var.q()));
                            }
                            if (x0Var.r()) {
                                a(sb, 2, "previous_timestamp_millis", Long.valueOf(x0Var.s()));
                            }
                            if (x0Var.t()) {
                                a(sb, 2, "count", Integer.valueOf(x0Var.u()));
                            }
                            if (x0Var.n() != 0) {
                                a(sb, 2, x0Var.zza());
                            }
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                a(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public final String a(c.c.a.b.f.e.h0 h0Var) {
        if (h0Var == null) {
            return LogUtils.NULL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (h0Var.zza()) {
            a(sb, 0, "filter_id", Integer.valueOf(h0Var.n()));
        }
        a(sb, 0, "event_name", i().a(h0Var.o()));
        String a2 = a(h0Var.t(), h0Var.u(), h0Var.w());
        if (!a2.isEmpty()) {
            a(sb, 0, "filter_type", a2);
        }
        if (h0Var.r()) {
            a(sb, 1, "event_count_filter", h0Var.s());
        }
        if (h0Var.q() > 0) {
            sb.append("  filters {\n");
            Iterator<c.c.a.b.f.e.i0> it = h0Var.p().iterator();
            while (it.hasNext()) {
                a(sb, 2, it.next());
            }
        }
        a(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    public final String a(c.c.a.b.f.e.k0 k0Var) {
        if (k0Var == null) {
            return LogUtils.NULL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (k0Var.zza()) {
            a(sb, 0, "filter_id", Integer.valueOf(k0Var.n()));
        }
        a(sb, 0, "property_name", i().c(k0Var.o()));
        String a2 = a(k0Var.q(), k0Var.r(), k0Var.t());
        if (!a2.isEmpty()) {
            a(sb, 0, "filter_type", a2);
        }
        a(sb, 1, k0Var.p());
        sb.append("}\n");
        return sb.toString();
    }

    public static String a(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public final void a(StringBuilder sb, int i2, List<c.c.a.b.f.e.z0> list) {
        if (list == null) {
            return;
        }
        int i3 = i2 + 1;
        for (c.c.a.b.f.e.z0 z0Var : list) {
            if (z0Var != null) {
                a(sb, i3);
                sb.append("param {\n");
                if (c.c.a.b.f.e.d9.a() && l().a(r.F0)) {
                    a(sb, i3, "name", z0Var.zza() ? i().b(z0Var.n()) : null);
                    a(sb, i3, "string_value", z0Var.o() ? z0Var.p() : null);
                    a(sb, i3, "int_value", z0Var.q() ? Long.valueOf(z0Var.r()) : null);
                    a(sb, i3, "double_value", z0Var.s() ? Double.valueOf(z0Var.t()) : null);
                    if (z0Var.v() > 0) {
                        a(sb, i3, z0Var.u());
                    }
                } else {
                    a(sb, i3, "name", i().b(z0Var.n()));
                    a(sb, i3, "string_value", z0Var.p());
                    a(sb, i3, "int_value", z0Var.q() ? Long.valueOf(z0Var.r()) : null);
                    a(sb, i3, "double_value", z0Var.s() ? Double.valueOf(z0Var.t()) : null);
                }
                a(sb, i3);
                sb.append("}\n");
            }
        }
    }

    public static void a(StringBuilder sb, int i2, String str, c.c.a.b.f.e.d1 d1Var, String str2) {
        if (d1Var == null) {
            return;
        }
        a(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (d1Var.p() != 0) {
            a(sb, 4);
            sb.append("results: ");
            int i3 = 0;
            for (Long l : d1Var.o()) {
                int i4 = i3 + 1;
                if (i3 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i3 = i4;
            }
            sb.append('\n');
        }
        if (d1Var.n() != 0) {
            a(sb, 4);
            sb.append("status: ");
            int i5 = 0;
            for (Long l2 : d1Var.zza()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i5 = i6;
            }
            sb.append('\n');
        }
        if (d1Var.r() != 0) {
            a(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i7 = 0;
            for (c.c.a.b.f.e.w0 w0Var : d1Var.q()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(w0Var.zza() ? Integer.valueOf(w0Var.n()) : null);
                sb.append(":");
                sb.append(w0Var.o() ? Long.valueOf(w0Var.p()) : null);
                i7 = i8;
            }
            sb.append("}\n");
        }
        if (d1Var.t() != 0) {
            a(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i9 = 0;
            for (c.c.a.b.f.e.e1 e1Var : d1Var.s()) {
                int i10 = i9 + 1;
                if (i9 != 0) {
                    sb.append(", ");
                }
                sb.append(e1Var.zza() ? Integer.valueOf(e1Var.n()) : null);
                sb.append(": [");
                Iterator<Long> it = e1Var.o().iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i11 = i12;
                }
                sb.append("]");
                i9 = i10;
            }
            sb.append("}\n");
        }
        a(sb, 3);
        sb.append("}\n");
    }

    public final void a(StringBuilder sb, int i2, String str, c.c.a.b.f.e.j0 j0Var) {
        if (j0Var == null) {
            return;
        }
        a(sb, i2);
        sb.append(str);
        sb.append(" {\n");
        if (j0Var.zza()) {
            a(sb, i2, "comparison_type", j0Var.n().name());
        }
        if (j0Var.o()) {
            a(sb, i2, "match_as_float", Boolean.valueOf(j0Var.p()));
        }
        if (j0Var.q()) {
            a(sb, i2, "comparison_value", j0Var.r());
        }
        if (j0Var.s()) {
            a(sb, i2, "min_comparison_value", j0Var.t());
        }
        if (j0Var.u()) {
            a(sb, i2, "max_comparison_value", j0Var.v());
        }
        a(sb, i2);
        sb.append("}\n");
    }

    public final void a(StringBuilder sb, int i2, c.c.a.b.f.e.i0 i0Var) {
        if (i0Var == null) {
            return;
        }
        a(sb, i2);
        sb.append("filter {\n");
        if (i0Var.q()) {
            a(sb, i2, "complement", Boolean.valueOf(i0Var.r()));
        }
        if (i0Var.s()) {
            a(sb, i2, "param_name", i().b(i0Var.t()));
        }
        if (i0Var.zza()) {
            int i3 = i2 + 1;
            c.c.a.b.f.e.l0 n = i0Var.n();
            if (n != null) {
                a(sb, i3);
                sb.append("string_filter");
                sb.append(" {\n");
                if (n.zza()) {
                    a(sb, i3, "match_type", n.n().name());
                }
                if (n.o()) {
                    a(sb, i3, "expression", n.p());
                }
                if (n.q()) {
                    a(sb, i3, "case_sensitive", Boolean.valueOf(n.r()));
                }
                if (n.t() > 0) {
                    a(sb, i3 + 1);
                    sb.append("expression_list {\n");
                    for (String str : n.s()) {
                        a(sb, i3 + 2);
                        sb.append(str);
                        sb.append(OSSUtils.NEW_LINE);
                    }
                    sb.append("}\n");
                }
                a(sb, i3);
                sb.append("}\n");
            }
        }
        if (i0Var.o()) {
            a(sb, i2 + 1, "number_filter", i0Var.p());
        }
        a(sb, i2);
        sb.append("}\n");
    }

    public static void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
    }

    public static void a(StringBuilder sb, int i2, String str, Object obj) {
        if (obj == null) {
            return;
        }
        a(sb, i2 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public final <T extends Parcelable> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (a.C0090a unused) {
            c().t().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    public static boolean a(zzaq zzaqVar, zzm zzmVar) {
        c.c.a.b.c.o.r.a(zzaqVar);
        c.c.a.b.c.o.r.a(zzmVar);
        return (TextUtils.isEmpty(zzmVar.f10219b) && TextUtils.isEmpty(zzmVar.r)) ? false : true;
    }

    public static boolean a(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean a(List<Long> list, int i2) {
        if (i2 < (list.size() << 6)) {
            return ((1 << (i2 % 64)) & list.get(i2 / 64).longValue()) != 0;
        }
        return false;
    }

    public static List<Long> a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            long j = 0;
            for (int i3 = 0; i3 < 64; i3++) {
                int i4 = (i2 << 6) + i3;
                if (i4 < bitSet.length()) {
                    if (bitSet.get(i4)) {
                        j |= 1 << i3;
                    }
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public final List<Long> a(List<Long> list, List<Integer> list2) {
        int i2;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                c().w().a("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    c().w().a("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (num.intValue() % 64)) ^ (-1))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i3 = size2;
            i2 = size;
            size = i3;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i2);
    }

    public final boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(b().a() - j) > j2;
    }

    public final long a(byte[] bArr) {
        c.c.a.b.c.o.r.a(bArr);
        j().g();
        MessageDigest x = s9.x();
        if (x == null) {
            c().t().a("Failed to get MD5");
            return 0L;
        }
        return s9.a(x.digest(bArr));
    }

    public static <Builder extends c.c.a.b.f.e.c6> Builder a(Builder builder, byte[] bArr) throws c.c.a.b.f.e.c5 {
        c.c.a.b.f.e.e4 b2 = c.c.a.b.f.e.e4.b();
        if (b2 != null) {
            builder.a(bArr, b2);
            return builder;
        }
        builder.b(bArr);
        return builder;
    }

    public static int a(b1.a aVar, String str) {
        if (aVar == null) {
            return -1;
        }
        for (int i2 = 0; i2 < aVar.m(); i2++) {
            if (str.equals(aVar.d(i2).o())) {
                return i2;
            }
        }
        return -1;
    }

    public static List<c.c.a.b.f.e.z0> a(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                z0.a B = c.c.a.b.f.e.z0.B();
                for (String str : bundle.keySet()) {
                    z0.a B2 = c.c.a.b.f.e.z0.B();
                    B2.a(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        B2.a(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        B2.b((String) obj);
                    } else if (obj instanceof Double) {
                        B2.a(((Double) obj).doubleValue());
                    }
                    B.a(B2);
                }
                if (B.l() > 0) {
                    arrayList.add((c.c.a.b.f.e.z0) ((c.c.a.b.f.e.s4) B.F()));
                }
            }
        }
        return arrayList;
    }
}
