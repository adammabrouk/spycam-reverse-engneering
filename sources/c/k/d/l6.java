package c.k.d;

import java.net.UnknownHostException;

/* loaded from: classes.dex */
public final class l6 {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public o4 f7350a;

        /* renamed from: b, reason: collision with root package name */
        public String f7351b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    public static a a(Exception exc) {
        m285a(exc);
        boolean z = exc instanceof l5;
        Exception exc2 = exc;
        if (z) {
            l5 l5Var = (l5) exc;
            exc2 = exc;
            if (l5Var.a() != null) {
                exc2 = l5Var.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = b5.a(exc2);
        if (a2 != 0) {
            aVar.f7350a = o4.a(o4.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.f7350a == null) {
            aVar.f7350a = o4.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f7350a == o4.GSLB_TCP_ERR_OTHER) {
            aVar.f7351b = str;
        }
        return aVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m285a(Exception exc) {
        if (exc == null) {
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Throwable] */
    public static a b(Exception exc) {
        o4 o4Var;
        o4 o4Var2;
        Throwable cause;
        m285a(exc);
        boolean z = exc instanceof l5;
        Exception exc2 = exc;
        if (z) {
            l5 l5Var = (l5) exc;
            exc2 = exc;
            if (l5Var.a() != null) {
                exc2 = l5Var.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = b5.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            o4 a3 = o4.a(o4.CONN_SUCCESS.a() + a2);
            aVar.f7350a = a3;
            if (a3 == o4.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                o4Var = o4.CONN_BOSH_UNKNOWNHOST;
            }
            o4Var2 = aVar.f7350a;
            if (o4Var2 != o4.CONN_TCP_ERR_OTHER || o4Var2 == o4.CONN_XMPP_ERR || o4Var2 == o4.CONN_BOSH_ERR) {
                aVar.f7351b = str;
            }
            return aVar;
        }
        o4Var = o4.CONN_XMPP_ERR;
        aVar.f7350a = o4Var;
        o4Var2 = aVar.f7350a;
        if (o4Var2 != o4.CONN_TCP_ERR_OTHER) {
        }
        aVar.f7351b = str;
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    public static a c(Exception exc) {
        o4 o4Var;
        o4 o4Var2;
        m285a(exc);
        boolean z = exc instanceof l5;
        Exception exc2 = exc;
        if (z) {
            l5 l5Var = (l5) exc;
            exc2 = exc;
            if (l5Var.a() != null) {
                exc2 = l5Var.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = b5.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            o4Var = o4.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            o4Var = o4.BIND_TCP_ERR;
        } else {
            if (a2 == 499) {
                aVar.f7350a = o4.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    o4Var = o4.BIND_BOSH_ITEM_NOT_FOUND;
                }
                o4Var2 = aVar.f7350a;
                if (o4Var2 != o4.BIND_TCP_ERR || o4Var2 == o4.BIND_XMPP_ERR || o4Var2 == o4.BIND_BOSH_ERR) {
                    aVar.f7351b = str;
                }
                return aVar;
            }
            o4Var = a2 != 109 ? a2 != 110 ? o4.BIND_XMPP_ERR : o4.BIND_TCP_BROKEN_PIPE : o4.BIND_TCP_CONNRESET;
        }
        aVar.f7350a = o4Var;
        o4Var2 = aVar.f7350a;
        if (o4Var2 != o4.BIND_TCP_ERR) {
        }
        aVar.f7351b = str;
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    public static a d(Exception exc) {
        o4 o4Var;
        o4 o4Var2;
        m285a(exc);
        boolean z = exc instanceof l5;
        Exception exc2 = exc;
        if (z) {
            l5 l5Var = (l5) exc;
            exc2 = exc;
            if (l5Var.a() != null) {
                exc2 = l5Var.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = b5.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            o4Var = o4.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            o4Var = o4.CHANNEL_TCP_ERR;
        } else {
            if (a2 == 499) {
                aVar.f7350a = o4.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    o4Var = o4.CHANNEL_BOSH_ITEMNOTFIND;
                }
                o4Var2 = aVar.f7350a;
                if (o4Var2 != o4.CHANNEL_TCP_ERR || o4Var2 == o4.CHANNEL_XMPPEXCEPTION || o4Var2 == o4.CHANNEL_BOSH_EXCEPTION) {
                    aVar.f7351b = str;
                }
                return aVar;
            }
            o4Var = a2 != 109 ? a2 != 110 ? o4.CHANNEL_XMPPEXCEPTION : o4.CHANNEL_TCP_BROKEN_PIPE : o4.CHANNEL_TCP_CONNRESET;
        }
        aVar.f7350a = o4Var;
        o4Var2 = aVar.f7350a;
        if (o4Var2 != o4.CHANNEL_TCP_ERR) {
        }
        aVar.f7351b = str;
        return aVar;
    }
}
