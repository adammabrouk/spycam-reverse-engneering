package c.c.b.n;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final byte f6057a = Byte.parseByte("01110000", 2);

    /* renamed from: b, reason: collision with root package name */
    public static final byte f6058b = Byte.parseByte("00001111", 2);

    public String a() {
        byte[] a2 = a(UUID.randomUUID(), new byte[17]);
        a2[16] = a2[0];
        a2[0] = (byte) ((f6058b & a2[0]) | f6057a);
        return a(a2);
    }

    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }
}
