package c.k.d;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class a2 {
    public static int a(Context context, int i2) {
        int a2 = g6.a(context);
        if (-1 == a2) {
            return -1;
        }
        return (i2 * (a2 == 0 ? 13 : 11)) / 10;
    }

    public static int a(i8 i8Var, v6 v6Var) {
        int a2;
        switch (b2.f6986a[v6Var.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return i4.a(v6Var.a());
            case 11:
                a2 = i4.a(v6Var.a());
                if (i8Var != null) {
                    try {
                        if (i8Var instanceof n7) {
                            String str = ((n7) i8Var).f7436d;
                            if (!TextUtils.isEmpty(str) && i4.a(i4.m220a(str)) != -1) {
                                a2 = i4.a(i4.m220a(str));
                                break;
                            }
                        } else if (i8Var instanceof v7) {
                            String str2 = ((v7) i8Var).f7963d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (i4.a(i4.m220a(str2)) != -1) {
                                    a2 = i4.a(i4.m220a(str2));
                                }
                                if (g7.UploadTinyData.equals(i4.m220a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        c.k.a.a.a.c.d("PERF_ERROR : parse Notification type error");
                        return a2;
                    }
                }
                break;
            case 12:
                a2 = i4.a(v6Var.a());
                if (i8Var != null) {
                    try {
                        if (i8Var instanceof r7) {
                            String a3 = ((r7) i8Var).a();
                            if (!TextUtils.isEmpty(a3) && n4.a(a3) != -1) {
                                a2 = n4.a(a3);
                                break;
                            }
                        } else if (i8Var instanceof q7) {
                            String a4 = ((q7) i8Var).a();
                            if (!TextUtils.isEmpty(a4) && n4.a(a4) != -1) {
                                return n4.a(a4);
                            }
                        }
                    } catch (Exception unused2) {
                        c.k.a.a.a.c.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a2;
    }

    public static int a(v6 v6Var) {
        return i4.a(v6Var.a());
    }

    public static void a(String str, Context context, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        int a2 = a(context, i3);
        if (i2 != i4.a(g7.UploadTinyData)) {
            j4.a(context.getApplicationContext()).a(str, i2, 1L, a2);
        }
    }

    public static void a(String str, Context context, i8 i8Var, v6 v6Var, int i2) {
        a(str, context, a(i8Var, v6Var), i2);
    }

    public static void a(String str, Context context, s7 s7Var, int i2) {
        v6 m469a;
        if (context == null || s7Var == null || (m469a = s7Var.m469a()) == null) {
            return;
        }
        int a2 = a(m469a);
        if (i2 <= 0) {
            byte[] a3 = h8.a(s7Var);
            i2 = a3 != null ? a3.length : 0;
        }
        a(str, context, a2, i2);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        s7 s7Var = new s7();
        try {
            h8.a(s7Var, bArr);
            a(str, context, s7Var, bArr.length);
        } catch (n8 unused) {
            c.k.a.a.a.c.m6a("fail to convert bytes to container");
        }
    }
}
