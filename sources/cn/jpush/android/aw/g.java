package cn.jpush.android.aw;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import com.shix.shixipc.utils.SystemBarTintManager;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static int f9438a = 327938;

    /* renamed from: b, reason: collision with root package name */
    public int f9439b = 65824;

    public static int a(Context context) {
        try {
            if (c(context)) {
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier(SystemBarTintManager.SystemBarConfig.NAV_BAR_HEIGHT_RES_NAME, "dimen", "android");
                if (identifier != 0) {
                    return resources.getDimensionPixelSize(identifier);
                }
                return 0;
            }
        } catch (Throwable unused) {
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "current navigate bar height: 0");
        return 0;
    }

    public static int a(Context context, DisplayMetrics displayMetrics, e eVar, boolean z) {
        int g2 = g(context, displayMetrics, eVar);
        return (!c(context, eVar) || z) ? g2 : displayMetrics.heightPixels;
    }

    public static String a(int i2, int i3) {
        if (i3 == 1) {
            if (i2 == 0) {
                return "FULL_SCREEN_PORTRAIT";
            }
            if (i2 == 1) {
                return "BANNER_PORTRAIT";
            }
            if (i2 == 2) {
                return "MODAL_PORTRAIT";
            }
            if (i2 != 3) {
                return null;
            }
            return "FLOAT_PORTRAIT";
        }
        if (i2 == 0) {
            return "FULL_SCREEN_LANDSCAPE";
        }
        if (i2 == 1) {
            return "BANNER_LANDSCAPE";
        }
        if (i2 == 2) {
            return "MODAL_LANDSCAPE";
        }
        if (i2 != 3) {
            return null;
        }
        return "FLOAT_LANDSCAPE";
    }

    public static boolean a(Context context, e eVar) {
        if (eVar.n() != 1) {
            return false;
        }
        DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
        return eVar.a(context, a2, 0) < 0.0f && eVar.a(context, a2, 2) < 0.0f && eVar.t().bF < 0.0f && (eVar.a(context, a2, 1) < 0.0f || eVar.a(context, a2, 3) < 0.0f);
    }

    public static int b(Context context) {
        int i2 = 48;
        if (context != null) {
            try {
                Resources resources = context.getResources();
                i2 = resources.getDimensionPixelSize(resources.getIdentifier(SystemBarTintManager.SystemBarConfig.STATUS_BAR_HEIGHT_RES_NAME, "dimen", "android"));
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InflaterConfigModule", "get status bar height error, " + th.getMessage());
            }
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "status bar height: " + i2);
        return i2;
    }

    public static int b(Context context, DisplayMetrics displayMetrics, e eVar, boolean z) {
        int h2 = h(context, displayMetrics, eVar);
        float f2 = eVar.t().bF;
        return (!c(context, eVar) || z || f2 <= 0.0f) ? h2 : (int) (a(context, displayMetrics, eVar, z) / f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a A[Catch: all -> 0x00af, TryCatch #0 {all -> 0x00af, blocks: (B:6:0x000f, B:8:0x0027, B:9:0x002a, B:13:0x004a, B:14:0x0054, B:16:0x006a, B:17:0x006d, B:21:0x007d, B:22:0x0087, B:25:0x0083, B:26:0x0050), top: B:5:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject b(android.content.Context r14, cn.jpush.android.aw.e r15) {
        /*
            java.lang.String r0 = "r"
            java.lang.String r1 = "h"
            java.lang.String r2 = "w"
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r4 = 0
            if (r15 != 0) goto Lf
            return r4
        Lf:
            android.util.DisplayMetrics r5 = cn.jpush.android.af.a.a(r14)     // Catch: java.lang.Throwable -> Laf
            r6 = 1
            int r7 = a(r14, r5, r15, r6)     // Catch: java.lang.Throwable -> Laf
            int r6 = b(r14, r5, r15, r6)     // Catch: java.lang.Throwable -> Laf
            cn.jpush.android.d.d r8 = r15.t()     // Catch: java.lang.Throwable -> Laf
            float r8 = r8.bF     // Catch: java.lang.Throwable -> Laf
            r9 = 0
            int r10 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r10 > 0) goto L2a
            float r8 = (float) r7     // Catch: java.lang.Throwable -> Laf
            float r10 = (float) r6     // Catch: java.lang.Throwable -> Laf
            float r8 = r8 / r10
        L2a:
            boolean r10 = e(r14, r15)     // Catch: java.lang.Throwable -> Laf
            boolean r11 = a(r14, r15)     // Catch: java.lang.Throwable -> Laf
            java.text.DecimalFormat r12 = new java.text.DecimalFormat     // Catch: java.lang.Throwable -> Laf
            java.lang.String r13 = "######0.00"
            r12.<init>(r13)     // Catch: java.lang.Throwable -> Laf
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Laf
            r13.<init>()     // Catch: java.lang.Throwable -> Laf
            r13.put(r2, r7)     // Catch: java.lang.Throwable -> Laf
            r13.put(r1, r6)     // Catch: java.lang.Throwable -> Laf
            r6 = -1
            if (r10 != 0) goto L50
            if (r11 == 0) goto L4a
            goto L50
        L4a:
            double r7 = (double) r8     // Catch: java.lang.Throwable -> Laf
            java.lang.String r7 = r12.format(r7)     // Catch: java.lang.Throwable -> Laf
            goto L54
        L50:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Laf
        L54:
            r13.put(r0, r7)     // Catch: java.lang.Throwable -> Laf
            r7 = 0
            int r8 = a(r14, r5, r15, r7)     // Catch: java.lang.Throwable -> Laf
            int r14 = b(r14, r5, r15, r7)     // Catch: java.lang.Throwable -> Laf
            cn.jpush.android.d.d r15 = r15.t()     // Catch: java.lang.Throwable -> Laf
            float r15 = r15.bF     // Catch: java.lang.Throwable -> Laf
            int r5 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r5 > 0) goto L6d
            float r15 = (float) r8     // Catch: java.lang.Throwable -> Laf
            float r5 = (float) r14     // Catch: java.lang.Throwable -> Laf
            float r15 = r15 / r5
        L6d:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Laf
            r5.<init>()     // Catch: java.lang.Throwable -> Laf
            r5.put(r2, r8)     // Catch: java.lang.Throwable -> Laf
            r5.put(r1, r14)     // Catch: java.lang.Throwable -> Laf
            if (r10 != 0) goto L83
            if (r11 == 0) goto L7d
            goto L83
        L7d:
            double r14 = (double) r15     // Catch: java.lang.Throwable -> Laf
            java.lang.String r14 = r12.format(r14)     // Catch: java.lang.Throwable -> Laf
            goto L87
        L83:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Laf
        L87:
            r5.put(r0, r14)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r14 = "landscape"
            r3.put(r14, r5)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r14 = "portrait"
            r3.put(r14, r13)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r14 = "InflaterConfigModule"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf
            r15.<init>()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r0 = "containerJSON:"
            r15.append(r0)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> Laf
            r15.append(r0)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r15 = r15.toString()     // Catch: java.lang.Throwable -> Laf
            cn.jpush.android.r.b.b(r14, r15)     // Catch: java.lang.Throwable -> Laf
            return r3
        Laf:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.aw.g.b(android.content.Context, cn.jpush.android.aw.e):org.json.JSONObject");
    }

    public static boolean c(Context context) {
        Activity a2 = cn.jpush.android.p.c.a(context);
        if (a2 == null || a2.isFinishing()) {
            return false;
        }
        Display defaultDisplay = a2.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        }
        View decorView = a2.getWindow().getDecorView();
        if (2 == context.getResources().getConfiguration().orientation) {
            if (point.x == decorView.findViewById(R.id.content).getWidth()) {
                return false;
            }
        } else {
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            if (rect.bottom == point.y) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(Context context, e eVar) {
        if (eVar.n() != 1) {
            return false;
        }
        DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
        return eVar.b(context, a2, 0) < 0 && eVar.b(context, a2, 2) < 0;
    }

    public static boolean d(Context context, e eVar) {
        if (eVar.n() != 1 || eVar.t().bF > 0.0f || a(context, eVar)) {
            return false;
        }
        DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
        return eVar.b(context, a2, 1) < 0 || eVar.b(context, a2, 3) < 0;
    }

    public static boolean e(Context context, e eVar) {
        if (eVar.n() != 2) {
            return false;
        }
        DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
        float a3 = eVar.a(context, a2, 0);
        float a4 = eVar.a(context, a2, 2);
        float a5 = eVar.a(context, a2, 1);
        float a6 = eVar.a(context, a2, 3);
        if (a3 >= 0.0f || a5 >= 0.0f) {
            return false;
        }
        return ((a6 > 0.0f ? 1 : (a6 == 0.0f ? 0 : -1)) < 0) && ((a4 > 0.0f ? 1 : (a4 == 0.0f ? 0 : -1)) < 0) && eVar.t().bF < 0.0f;
    }

    public static int g(Context context, DisplayMetrics displayMetrics, e eVar) {
        int b2;
        int i2;
        int i3 = displayMetrics.widthPixels;
        int n = eVar.n();
        int i4 = 0;
        if (n == 3) {
            int d2 = ((c) eVar).d();
            i2 = d2 <= 0 ? cn.jpush.android.af.a.a(context, 60) : cn.jpush.android.af.a.a(context, d2);
            if (i2 > i3) {
                i2 = cn.jpush.android.af.a.a(context, 60);
            }
            b2 = 0;
        } else {
            i4 = eVar.b(context, displayMetrics, 0);
            b2 = eVar.b(context, displayMetrics, 2);
            i2 = i4 < 0 ? b2 >= 0 ? i3 - b2 : i3 : b2 >= 0 ? (i3 - b2) - i4 : i3 - i4;
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "getWindowWidth msg_type: " + n + ", left: " + i4 + ", right: " + b2 + ", screenW: " + i3 + ", width: " + i2);
        return i2;
    }

    public static int h(Context context, DisplayMetrics displayMetrics, e eVar) {
        int a2;
        int i2 = displayMetrics.heightPixels;
        int n = eVar.n();
        int b2 = eVar.b(context, displayMetrics, 1);
        int b3 = eVar.b(context, displayMetrics, 3);
        if (n == 1) {
            float f2 = eVar.t().bF;
            if (f2 > 0.0f) {
                a2 = (int) (g(context, displayMetrics, eVar) / f2);
            } else {
                if (b2 < 0 || b3 < 0) {
                    int i3 = d(context, eVar) ? 74 : 94;
                    a2 = cn.jpush.android.af.a.a(context, i3);
                    e.f9426a = i3;
                }
                a2 = (i2 - b2) - b3;
            }
        } else if (n != 2) {
            if (n != 3) {
                a2 = 0;
            } else {
                int e2 = ((c) eVar).e();
                int a3 = e2 <= 0 ? cn.jpush.android.af.a.a(context, 120) : cn.jpush.android.af.a.a(context, e2);
                a2 = a3 > i2 ? cn.jpush.android.af.a.a(context, 120) : a3;
            }
        } else if (b2 >= 0) {
            if (b3 < 0) {
                a2 = i2 - b2;
            }
            a2 = (i2 - b2) - b3;
        } else {
            a2 = b3 >= 0 ? i2 - b3 : i2;
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "getWindowHeight msg_type: " + n + ", top: " + b2 + ", bottom: " + b3 + ", screenH: " + i2 + ", height: " + a2);
        return a2;
    }

    public static int i(Context context, DisplayMetrics displayMetrics, e eVar) {
        int i2;
        int i3 = displayMetrics.heightPixels;
        int n = eVar.n();
        int b2 = eVar.b(context, displayMetrics, 1);
        int b3 = eVar.b(context, displayMetrics, 3);
        if (n != 1) {
            if (n == 2) {
                i2 = b2 <= 0 ? b3 >= 0 ? i3 - b3 : i3 : b3 >= 0 ? (i3 - b3) - b2 : i3 - b2;
            } else if (n != 3) {
                i2 = 0;
            }
            cn.jpush.android.r.b.b("InflaterConfigModule", "getMaxWindowHeight msg_type: " + n + ", top: " + b2 + ", bottom: " + b3 + ", screenH: " + i3 + ", height: " + i2);
            return i2;
        }
        i2 = -1;
        cn.jpush.android.r.b.b("InflaterConfigModule", "getMaxWindowHeight msg_type: " + n + ", top: " + b2 + ", bottom: " + b3 + ", screenH: " + i3 + ", height: " + i2);
        return i2;
    }

    public static int j(Context context, DisplayMetrics displayMetrics, e eVar) {
        int i2 = displayMetrics.widthPixels;
        int n = eVar.n();
        eVar.b(context, displayMetrics, 0);
        eVar.b(context, displayMetrics, 2);
        return (n == 1 || n == 2 || n == 3) ? -1 : 0;
    }

    public static int[] k(Context context, DisplayMetrics displayMetrics, e eVar) {
        return new int[]{Math.max(eVar.b(context, displayMetrics, 0), 0), Math.max(eVar.b(context, displayMetrics, 1), 0), Math.max(eVar.b(context, displayMetrics, 2), 0), Math.max(eVar.b(context, displayMetrics, 3), 0)};
    }

    @SuppressLint({"RtlHardcoded"})
    public static int l(Context context, DisplayMetrics displayMetrics, e eVar) {
        int i2;
        int b2 = eVar.b(context, displayMetrics, 0);
        int b3 = eVar.b(context, displayMetrics, 1);
        int b4 = eVar.b(context, displayMetrics, 2);
        int i3 = 3;
        int b5 = eVar.b(context, displayMetrics, 3);
        int n = eVar.n();
        if (n == 1) {
            int i4 = ((b) eVar).e() != 0 ? 80 : 48;
            if (b2 > 0) {
                r0 = i4 | 3;
            } else if (b4 > 0) {
                i2 = i4 | 5;
                r0 = i2;
            } else {
                r0 = i4;
            }
        } else if (n == 2) {
            if (b2 <= 0) {
                i3 = b4 > 0 ? 5 : 0;
            } else if (b2 > b4 && b4 > 0) {
                i3 = 5;
            }
            if (b3 > 0) {
                i2 = (b3 <= b5 || b5 <= 0) ? i3 | 80 : i3 | 48;
                r0 = i2;
            } else {
                r0 = i3 | 80;
            }
        } else if (n == 3) {
            r0 = (eVar.t().aE == 0 ? 1 : 0) != 0 ? 53 : 51;
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "getWindowGravity, position[" + b2 + "," + b3 + "," + b4 + "," + b5 + "], gravity: " + r0);
        return r0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        if (r3 > 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m(android.content.Context r6, android.util.DisplayMetrics r7, cn.jpush.android.aw.e r8) {
        /*
            r0 = 0
            int r1 = r8.b(r6, r7, r0)
            r2 = 2
            int r3 = r8.b(r6, r7, r2)
            int r4 = r8.n()
            r5 = 1
            if (r4 == r5) goto L53
            if (r4 == r2) goto L47
            r2 = 3
            if (r4 == r2) goto L17
            goto L5b
        L17:
            cn.jpush.android.d.d r2 = r8.t()
            int r2 = r2.aE
            if (r2 != 0) goto L20
            r0 = 1
        L20:
            int r8 = g(r6, r7, r8)
            if (r0 == 0) goto L2e
            if (r1 < 0) goto L2e
            int r6 = r7.widthPixels
            int r8 = r8 + r1
        L2b:
            int r0 = r6 - r8
            goto L5b
        L2e:
            if (r0 != 0) goto L38
            if (r1 >= 0) goto L38
            if (r3 < 0) goto L38
            int r6 = r7.widthPixels
            int r8 = r8 + r3
            goto L2b
        L38:
            if (r1 < 0) goto L3c
        L3a:
            r0 = r1
            goto L5b
        L3c:
            if (r3 < 0) goto L40
        L3e:
            r0 = r3
            goto L5b
        L40:
            r7 = 6
            int r6 = cn.jpush.android.af.a.a(r6, r7)
        L45:
            r0 = r6
            goto L5b
        L47:
            if (r1 <= 0) goto L4e
            if (r1 <= r3) goto L3a
            if (r3 <= 0) goto L3a
            goto L3e
        L4e:
            int r0 = java.lang.Math.max(r3, r0)
            goto L5b
        L53:
            if (r1 <= 0) goto L56
            goto L3a
        L56:
            int r6 = java.lang.Math.min(r3, r0)
            goto L45
        L5b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "getWindowMarginX, msg_type: "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = ", left: "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = ", right: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r7 = ", marginX: "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "InflaterConfigModule"
            cn.jpush.android.r.b.b(r7, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.aw.g.m(android.content.Context, android.util.DisplayMetrics, cn.jpush.android.aw.e):int");
    }

    public static int n(Context context, DisplayMetrics displayMetrics, e eVar) {
        int i2;
        int b2 = eVar.b(context, displayMetrics, 1);
        int b3 = eVar.b(context, displayMetrics, 3);
        int b4 = b(context);
        int n = eVar.n();
        if (n == 1) {
            if (((b) eVar).e() != 0) {
                if (b3 >= 0) {
                    b4 = b3;
                }
                i2 = b4;
            }
            i2 = Math.max(b2, b4);
        } else if (n != 2) {
            if (n != 3) {
                i2 = 0;
            } else {
                int h2 = h(context, displayMetrics, eVar);
                if (b2 < 0) {
                    if (b3 >= 0) {
                        i2 = displayMetrics.heightPixels - (h2 + b3);
                    } else {
                        double d2 = displayMetrics.heightPixels - b4;
                        Double.isNaN(d2);
                        i2 = (int) (d2 * 0.6d);
                    }
                }
                i2 = Math.max(b2, b4);
            }
        } else if (b2 >= 0) {
            if (b2 > b3 && b3 > 0) {
                i2 = b2;
            }
            i2 = b3;
        } else {
            if (b3 < 0) {
                i2 = -1;
            }
            i2 = b3;
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "getWindowMarginY, msg_type: " + n + ", top: " + b2 + ", bottom: " + b3 + ", marginY: " + i2);
        return i2;
    }

    public cn.jpush.android.au.c a(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics == null || eVar == null) {
            cn.jpush.android.r.b.b("InflaterConfigModule", "provide portrait banner layout param is null, displayMetrics: " + displayMetrics + ", appMsg: " + eVar);
            return null;
        }
        b bVar = eVar instanceof b ? (b) eVar : null;
        if (bVar == null) {
            cn.jpush.android.r.b.f("InflaterConfigModule", "not banner in app message instance");
            return null;
        }
        bVar.e();
        return cn.jpush.android.au.c.a().a(Float.valueOf(0.3f)).b(Float.valueOf(0.3f)).a(k(context, displayMetrics, bVar)).a(Integer.valueOf(i(context, displayMetrics, bVar))).b(Integer.valueOf(j(context, displayMetrics, bVar))).c(Integer.valueOf(l(context, displayMetrics, bVar))).d(Integer.valueOf(this.f9439b)).e(Integer.valueOf(g(context, displayMetrics, bVar))).f(Integer.valueOf(h(context, displayMetrics, bVar))).e(2).f(2).a(Boolean.TRUE).b(Boolean.valueOf(bVar.c() != -1)).d(m(context, displayMetrics, bVar)).c(n(context, displayMetrics, bVar)).c(Boolean.valueOf(bVar.f())).a(true).a(bVar.g()).b(bVar.h()).c(bVar.i()).a(bVar.c()).b(bVar.d()).a();
    }

    public cn.jpush.android.au.c b(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics == null || eVar == null) {
            cn.jpush.android.r.b.b("InflaterConfigModule", "provide landscape banner layout param is null, displayMetrics: " + displayMetrics + ", appMsg: " + eVar);
            return null;
        }
        b bVar = eVar instanceof b ? (b) eVar : null;
        if (bVar == null) {
            cn.jpush.android.r.b.f("InflaterConfigModule", "not banner in app message instance");
            return null;
        }
        boolean f2 = bVar.f();
        boolean z = bVar.c() != -1;
        int a2 = a(context, displayMetrics, bVar, false);
        boolean c2 = c(context, bVar);
        int b2 = b(context, displayMetrics, bVar, false);
        int m = c2 ? (displayMetrics.widthPixels - a2) / 2 : m(context, displayMetrics, bVar);
        int l = l(context, displayMetrics, bVar);
        if (c2) {
            l |= 3;
        }
        return cn.jpush.android.au.c.a().a(Float.valueOf(0.3f)).b(Float.valueOf(0.3f)).a(k(context, displayMetrics, bVar)).a(Integer.valueOf(i(context, displayMetrics, bVar))).b(Integer.valueOf(j(context, displayMetrics, bVar))).c(Integer.valueOf(l)).d(Integer.valueOf(this.f9439b)).e(Integer.valueOf(a2)).f(Integer.valueOf(b2)).e(20).f(20).d(m).c(n(context, displayMetrics, bVar)).a(Boolean.TRUE).b(Boolean.valueOf(z)).c(Boolean.valueOf(f2)).a(true).a(bVar.g()).b(bVar.h()).c(bVar.i()).a(bVar.c()).b(bVar.d()).a();
    }

    public cn.jpush.android.au.c c(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics != null && eVar != null && context != null) {
            c cVar = eVar instanceof c ? (c) eVar : null;
            if (cVar != null) {
                return cn.jpush.android.au.c.a().a(k(context, displayMetrics, eVar)).a(Integer.valueOf(i(context, displayMetrics, eVar))).b(Integer.valueOf(j(context, displayMetrics, eVar))).b(Float.valueOf(0.4f)).a(Float.valueOf(0.4f)).c(Integer.valueOf(l(context, displayMetrics, eVar))).d(m(context, displayMetrics, eVar)).c(n(context, displayMetrics, eVar)).d(Integer.valueOf(this.f9439b)).e(Integer.valueOf(g(context, displayMetrics, eVar))).f(Integer.valueOf(h(context, displayMetrics, eVar))).a(Boolean.TRUE).b(Boolean.FALSE).c(Boolean.FALSE).a(cVar.a()).b(cVar.b()).c(cVar.c()).a();
            }
            cn.jpush.android.r.b.f("InflaterConfigModule", "not float message instance");
            return null;
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "provide portrait float layout param is null, displayMetrics: " + displayMetrics + ", appMsg: " + eVar + ", context: " + context);
        return null;
    }

    public cn.jpush.android.au.c d(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics != null && eVar != null && context != null) {
            c cVar = eVar instanceof c ? (c) eVar : null;
            if (cVar != null) {
                return cn.jpush.android.au.c.a().a(k(context, displayMetrics, eVar)).a(Integer.valueOf(i(context, displayMetrics, eVar))).b(Integer.valueOf(j(context, displayMetrics, eVar))).b(Float.valueOf(0.8f)).a(Float.valueOf(0.8f)).c(Integer.valueOf(l(context, displayMetrics, eVar))).d(m(context, displayMetrics, eVar)).c(n(context, displayMetrics, eVar)).d(Integer.valueOf(this.f9439b)).e(Integer.valueOf(g(context, displayMetrics, eVar))).f(Integer.valueOf(h(context, displayMetrics, eVar))).a(Boolean.FALSE).b(Boolean.FALSE).c(Boolean.FALSE).a(cVar.a()).b(cVar.b()).c(cVar.c()).a();
            }
            cn.jpush.android.r.b.f("InflaterConfigModule", "not float message instance");
            return null;
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "provide portrait float layout param is null, displayMetrics: " + displayMetrics + ", appMsg: " + eVar + ", context: " + context);
        return null;
    }

    public cn.jpush.android.au.c e(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics != null) {
            return cn.jpush.android.au.c.a().a(k(context, displayMetrics, eVar)).a(Integer.valueOf(i(context, displayMetrics, eVar))).b(Integer.valueOf(j(context, displayMetrics, eVar))).a(Float.valueOf(0.6f)).c(Float.valueOf(0.1f)).b(Float.valueOf(0.9f)).d(Float.valueOf(0.9f)).c(Integer.valueOf(l(context, displayMetrics, eVar))).d(m(context, displayMetrics, eVar)).c(n(context, displayMetrics, eVar)).d(Integer.valueOf(f9438a)).e(Integer.valueOf(g(context, displayMetrics, eVar))).f(Integer.valueOf(h(context, displayMetrics, eVar))).a(Boolean.FALSE).b(Boolean.FALSE).c(Boolean.FALSE).a();
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "provide portrait modal config displayMetrics is null");
        return null;
    }

    public cn.jpush.android.au.c f(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics != null) {
            return cn.jpush.android.au.c.a().a(k(context, displayMetrics, eVar)).a(Integer.valueOf(i(context, displayMetrics, eVar))).b(Integer.valueOf(j(context, displayMetrics, eVar))).a(Float.valueOf(1.0f)).b(Float.valueOf(0.4f)).c(Float.valueOf(0.6f)).d(Float.valueOf(0.4f)).c(Integer.valueOf(l(context, displayMetrics, eVar))).d(m(context, displayMetrics, eVar)).c(n(context, displayMetrics, eVar)).d(Integer.valueOf(f9438a)).e(Integer.valueOf(g(context, displayMetrics, eVar))).f(Integer.valueOf(h(context, displayMetrics, eVar))).a(Boolean.FALSE).b(Boolean.FALSE).c(Boolean.FALSE).a();
        }
        cn.jpush.android.r.b.b("InflaterConfigModule", "provide landscape modal config displayMetrics is null");
        return null;
    }
}
