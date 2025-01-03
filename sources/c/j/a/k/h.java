package c.j.a.k;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PushClientTaskFactory.java */
/* loaded from: classes.dex */
public final class h {
    public static c.j.a.r a(c.j.a.v vVar) {
        c.j.a.r gVar;
        int b2 = vVar.b();
        if (b2 == 20) {
            gVar = new g(vVar);
        } else if (b2 == 100) {
            gVar = new k(vVar);
        } else if (b2 != 101) {
            switch (b2) {
                case 0:
                    break;
                case 1:
                    gVar = new b(vVar);
                    break;
                case 2:
                    gVar = new q(vVar);
                    break;
                case 3:
                    gVar = new y(vVar);
                    break;
                case 4:
                    gVar = new a0(vVar);
                    break;
                case 5:
                    gVar = new d0(vVar);
                    break;
                case 6:
                    gVar = new g0(vVar);
                    break;
                case 7:
                    gVar = new w(vVar);
                    break;
                case 8:
                    gVar = new u(vVar);
                    break;
                case 9:
                    gVar = new p(vVar);
                    break;
                case 10:
                    gVar = new m(vVar);
                    break;
                case 11:
                    gVar = new e(vVar);
                    break;
                case 12:
                    gVar = new o(vVar);
                    break;
                default:
                    switch (b2) {
                        case RecyclerView.MAX_SCROLL_DURATION /* 2000 */:
                        case 2001:
                        case 2002:
                        case 2003:
                        case 2004:
                        case 2005:
                        case 2008:
                        case 2009:
                        case 2010:
                        case 2011:
                        case 2012:
                        case 2013:
                        case 2014:
                        case 2015:
                            break;
                        case 2006:
                            gVar = new a(vVar);
                            break;
                        case 2007:
                            gVar = new j(vVar);
                            break;
                        default:
                            return null;
                    }
            }
            gVar = new i(vVar);
        } else {
            gVar = new l(vVar);
        }
        return gVar;
    }

    public static i0 b(c.j.a.v vVar) {
        i0 gVar;
        int b2 = vVar.b();
        if (b2 == 20) {
            gVar = new g(vVar);
        } else if (b2 != 2016) {
            switch (b2) {
                case 1:
                    gVar = new b(vVar);
                    break;
                case 2:
                    gVar = new q(vVar);
                    break;
                case 3:
                    gVar = new y(vVar);
                    break;
                case 4:
                    gVar = new a0(vVar);
                    break;
                case 5:
                    gVar = new d0(vVar);
                    break;
                case 6:
                    gVar = new g0(vVar);
                    break;
                case 7:
                    gVar = new w(vVar);
                    break;
                case 8:
                    gVar = new u(vVar);
                    break;
                case 9:
                    gVar = new p(vVar);
                    break;
                case 10:
                    gVar = new m(vVar);
                    break;
                case 11:
                    gVar = new e(vVar);
                    break;
                default:
                    return null;
            }
        } else {
            gVar = new t(vVar);
        }
        return gVar;
    }
}
