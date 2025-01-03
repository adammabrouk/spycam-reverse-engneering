package c.k.d;

import java.io.IOException;

/* loaded from: classes.dex */
public class r1 extends IOException {
    public r1(String str) {
        super(str);
    }

    public static r1 a() {
        return new r1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static r1 b() {
        return new r1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static r1 c() {
        return new r1("CodedInputStream encountered a malformed varint.");
    }

    public static r1 d() {
        return new r1("Protocol message contained an invalid tag (zero).");
    }

    public static r1 e() {
        return new r1("Protocol message end-group tag did not match expected tag.");
    }

    public static r1 f() {
        return new r1("Protocol message tag had invalid wire type.");
    }

    public static r1 g() {
        return new r1("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static r1 h() {
        return new r1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
