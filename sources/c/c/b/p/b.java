package c.c.b.p;

import java.util.Locale;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class b extends Exception {
    public static final int ERROR_INVALID_PARAMETERS = 1;
    public static final int ERROR_SIZE = 2;
    public static final int ERROR_TOO_MANY_MESSAGES = 4;
    public static final int ERROR_TTL_EXCEEDED = 3;
    public static final int ERROR_UNKNOWN = 0;
    public final int zza;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public b(String str) {
        super(str);
        int i2 = 0;
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.US);
            char c2 = 65535;
            switch (lowerCase.hashCode()) {
                case -1743242157:
                    if (lowerCase.equals("service_not_available")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1290953729:
                    if (lowerCase.equals("toomanymessages")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -920906446:
                    if (lowerCase.equals("invalid_parameters")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -617027085:
                    if (lowerCase.equals("messagetoobig")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -95047692:
                    if (lowerCase.equals("missing_to")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                i2 = 1;
            } else if (c2 == 2) {
                i2 = 2;
            } else if (c2 == 3) {
                i2 = 3;
            } else if (c2 == 4) {
                i2 = 4;
            }
        }
        this.zza = i2;
    }

    public final int getErrorCode() {
        return this.zza;
    }
}
