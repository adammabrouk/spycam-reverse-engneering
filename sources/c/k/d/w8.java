package c.k.d;

/* loaded from: classes.dex */
public class w8 {

    /* renamed from: a, reason: collision with root package name */
    public static int f7995a = Integer.MAX_VALUE;

    public static void a(t8 t8Var, byte b2) {
        a(t8Var, b2, f7995a);
    }

    public static void a(t8 t8Var, byte b2, int i2) {
        if (i2 <= 0) {
            throw new n8("Maximum skip depth exceeded");
        }
        int i3 = 0;
        switch (b2) {
            case 2:
                t8Var.mo353a();
                return;
            case 3:
                t8Var.a();
                return;
            case 4:
                t8Var.mo340a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                t8Var.mo350a();
                return;
            case 8:
                t8Var.mo341a();
                return;
            case 10:
                t8Var.mo342a();
                return;
            case 11:
                t8Var.mo349a();
                return;
            case 12:
                t8Var.mo347a();
                while (true) {
                    byte b3 = t8Var.mo343a().f7785b;
                    if (b3 == 0) {
                        t8Var.f();
                        return;
                    } else {
                        a(t8Var, b3, i2 - 1);
                        t8Var.g();
                    }
                }
            case 13:
                s8 mo345a = t8Var.mo345a();
                while (i3 < mo345a.f7854c) {
                    int i4 = i2 - 1;
                    a(t8Var, mo345a.f7852a, i4);
                    a(t8Var, mo345a.f7853b, i4);
                    i3++;
                }
                t8Var.h();
                return;
            case 14:
                x8 mo346a = t8Var.mo346a();
                while (i3 < mo346a.f8025b) {
                    a(t8Var, mo346a.f8024a, i2 - 1);
                    i3++;
                }
                t8Var.j();
                return;
            case 15:
                r8 mo344a = t8Var.mo344a();
                while (i3 < mo344a.f7822b) {
                    a(t8Var, mo344a.f7821a, i2 - 1);
                    i3++;
                }
                t8Var.i();
                return;
        }
    }
}
