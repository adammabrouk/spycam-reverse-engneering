package com.shix.shixipc.he;

import android.os.Parcelable;
import com.tencent.mmkv.MMKV;
import f.j.b.f;
import java.util.Collections;
import java.util.Set;

/* compiled from: SPutil.kt */
/* loaded from: classes.dex */
public final class SpUtil {
    public static final SpUtil INSTANCE = new SpUtil();
    public static MMKV mmkv = MMKV.a();

    public final void clearAll() {
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            mmkv2.clearAll();
        }
    }

    public final Boolean decodeBoolean(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Boolean.valueOf(mmkv2.a(str, false));
        }
        return null;
    }

    public final byte[] decodeByteArray(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.b(str);
        }
        return null;
    }

    public final Double decodeDouble(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Double.valueOf(mmkv2.a(str, 0.0d));
        }
        return null;
    }

    public final Float decodeFloat(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Float.valueOf(mmkv2.a(str, 0.0f));
        }
        return null;
    }

    public final Integer decodeInt(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Integer.valueOf(mmkv2.a(str, 0));
        }
        return null;
    }

    public final Integer decodeIntDDC(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Integer.valueOf(mmkv2.a(str, -1));
        }
        return null;
    }

    public final Long decodeLong(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Long.valueOf(mmkv2.a(str, 0L));
        }
        return null;
    }

    public final <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        f.c(str, "key");
        f.c(cls, "tClass");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return (T) mmkv2.a(str, cls);
        }
        return null;
    }

    public final String decodeString(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.a(str, "");
        }
        return null;
    }

    public final Set<String> decodeStringSet(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.a(str, Collections.emptySet());
        }
        return null;
    }

    public final void encode(String str, Object obj) {
        f.c(str, "key");
        if (obj instanceof String) {
            MMKV mmkv2 = mmkv;
            if (mmkv2 != null) {
                mmkv2.b(str, (String) obj);
                return;
            }
            return;
        }
        if (obj instanceof Float) {
            MMKV mmkv3 = mmkv;
            if (mmkv3 != null) {
                mmkv3.b(str, ((Number) obj).floatValue());
                return;
            }
            return;
        }
        if (obj instanceof Boolean) {
            MMKV mmkv4 = mmkv;
            if (mmkv4 != null) {
                mmkv4.b(str, ((Boolean) obj).booleanValue());
                return;
            }
            return;
        }
        if (obj instanceof Integer) {
            MMKV mmkv5 = mmkv;
            if (mmkv5 != null) {
                mmkv5.b(str, ((Number) obj).intValue());
                return;
            }
            return;
        }
        if (obj instanceof Long) {
            MMKV mmkv6 = mmkv;
            if (mmkv6 != null) {
                mmkv6.b(str, ((Number) obj).longValue());
                return;
            }
            return;
        }
        if (obj instanceof Double) {
            MMKV mmkv7 = mmkv;
            if (mmkv7 != null) {
                mmkv7.b(str, ((Number) obj).doubleValue());
                return;
            }
            return;
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof Void) {
            }
            return;
        }
        MMKV mmkv8 = mmkv;
        if (mmkv8 != null) {
            mmkv8.b(str, (byte[]) obj);
        }
    }

    public final MMKV getMmkv() {
        return mmkv;
    }

    public final Boolean queryKey(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Boolean.valueOf(mmkv2.a(str));
        }
        return null;
    }

    public final void removeKey(String str) {
        f.c(str, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            mmkv2.c(str);
        }
    }

    public final void setMmkv(MMKV mmkv2) {
        mmkv = mmkv2;
    }

    public final <T extends Parcelable> void encode(String str, T t) {
        MMKV mmkv2;
        f.c(str, "key");
        if (t == null || (mmkv2 = mmkv) == null) {
            return;
        }
        mmkv2.a(str, t);
    }

    public final void encode(String str, Set<String> set) {
        MMKV mmkv2;
        f.c(str, "key");
        if (set == null || (mmkv2 = mmkv) == null) {
            return;
        }
        mmkv2.b(str, set);
    }
}
