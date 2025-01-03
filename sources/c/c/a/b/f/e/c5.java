package c.c.a.b.f.e;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public class c5 extends IOException {
    public d6 zza;

    public c5(String str) {
        super(str);
        this.zza = null;
    }

    public static c5 zza() {
        return new c5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static c5 zzb() {
        return new c5("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static c5 zzc() {
        return new c5("CodedInputStream encountered a malformed varint.");
    }

    public static c5 zzd() {
        return new c5("Protocol message contained an invalid tag (zero).");
    }

    public static c5 zze() {
        return new c5("Protocol message end-group tag did not match expected tag.");
    }

    public static b5 zzf() {
        return new b5("Protocol message tag had invalid wire type.");
    }

    public static c5 zzg() {
        return new c5("Failed to parse the message.");
    }

    public static c5 zzh() {
        return new c5("Protocol message had invalid UTF-8.");
    }
}
