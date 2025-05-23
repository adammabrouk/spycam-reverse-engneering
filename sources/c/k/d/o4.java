package c.k.d;

import com.shix.shixipc.utils.MyAudioPlayer;

/* loaded from: classes.dex */
public enum o4 {
    TCP_CONN_FAIL(1),
    TCP_CONN_TIME(2),
    PING_RTT(3),
    CHANNEL_CON_FAIL(4),
    CHANNEL_CON_OK(5),
    ICMP_PING_FAIL(6),
    ICMP_PING_OK(7),
    CHANNEL_ONLINE_RATE(8),
    GSLB_REQUEST_SUCCESS(10000),
    GSLB_TCP_NOACCESS(10101),
    GSLB_TCP_NETUNREACH(10102),
    GSLB_TCP_CONNREFUSED(10103),
    GSLB_TCP_NOROUTETOHOST(10104),
    GSLB_TCP_TIMEOUT(10105),
    GSLB_TCP_INVALARG(10106),
    GSLB_TCP_UKNOWNHOST(10107),
    GSLB_TCP_ERR_OTHER(10199),
    GSLB_ERR(10999),
    CONN_SUCCESS(20000),
    CONN_TCP_NOACCESS(20101),
    CONN_TCP_NETUNREACH(20102),
    CONN_TCP_CONNREFUSED(20103),
    CONN_TCP_NOROUTETOHOST(20104),
    CONN_TCP_TIMEOUT(20105),
    CONN_TCP_INVALARG(20106),
    CONN_TCP_UKNOWNHOST(20107),
    CONN_TCP_ERR_OTHER(20199),
    CONN_XMPP_ERR(20399),
    CONN_BOSH_UNKNOWNHOST(20407),
    CONN_BOSH_ERR(20499),
    BIND_SUCCESS(30000),
    BIND_TCP_READ_TIMEOUT_DEPRECTED(30101),
    BIND_TCP_CONNRESET_DEPRECTED(30102),
    BIND_TCP_BROKEN_PIPE_DEPRECTED(30103),
    BIND_TCP_READ_TIMEOUT(30108),
    BIND_TCP_CONNRESET(30109),
    BIND_TCP_BROKEN_PIPE(30110),
    BIND_TCP_ERR(30199),
    BIND_XMPP_ERR(30399),
    BIND_BOSH_ITEM_NOT_FOUND(30401),
    BIND_BOSH_ERR(30499),
    BIND_TIMEOUT(30501),
    BIND_INVALID_SIG(30502),
    CHANNEL_TCP_READTIMEOUT_DEPRECTED(40101),
    CHANNEL_TCP_CONNRESET_DEPRECTED(40102),
    CHANNEL_TCP_BROKEN_PIPE_DEPRECTED(40103),
    CHANNEL_TCP_READTIMEOUT(40108),
    CHANNEL_TCP_CONNRESET(40109),
    CHANNEL_TCP_BROKEN_PIPE(40110),
    CHANNEL_TCP_ERR(40199),
    CHANNEL_XMPPEXCEPTION(40399),
    CHANNEL_BOSH_ITEMNOTFIND(40401),
    CHANNEL_BOSH_EXCEPTION(40499),
    CHANNEL_TIMER_DELAYED(50001),
    CHANNEL_STATS_COUNTER(MyAudioPlayer.KEY_SAMPLE_RATE);


    /* renamed from: a, reason: collision with other field name */
    public final int f72a;

    o4(int i2) {
        this.f72a = i2;
    }

    public static o4 a(int i2) {
        if (i2 == 30501) {
            return BIND_TIMEOUT;
        }
        if (i2 == 30502) {
            return BIND_INVALID_SIG;
        }
        switch (i2) {
            case 1:
                return TCP_CONN_FAIL;
            case 2:
                return TCP_CONN_TIME;
            case 3:
                return PING_RTT;
            case 4:
                return CHANNEL_CON_FAIL;
            case 5:
                return CHANNEL_CON_OK;
            case 6:
                return ICMP_PING_FAIL;
            case 7:
                return ICMP_PING_OK;
            case 8:
                return CHANNEL_ONLINE_RATE;
            default:
                switch (i2) {
                    case MyAudioPlayer.KEY_SAMPLE_RATE /* 8000 */:
                        return CHANNEL_STATS_COUNTER;
                    case 10000:
                        return GSLB_REQUEST_SUCCESS;
                    case 10199:
                        return GSLB_TCP_ERR_OTHER;
                    case 10999:
                        return GSLB_ERR;
                    case 20000:
                        return CONN_SUCCESS;
                    case 20199:
                        return CONN_TCP_ERR_OTHER;
                    case 20399:
                        return CONN_XMPP_ERR;
                    case 20407:
                        return CONN_BOSH_UNKNOWNHOST;
                    case 20499:
                        return CONN_BOSH_ERR;
                    case 30000:
                        return BIND_SUCCESS;
                    case 30199:
                        return BIND_TCP_ERR;
                    case 30399:
                        return BIND_XMPP_ERR;
                    case 30401:
                        return BIND_BOSH_ITEM_NOT_FOUND;
                    case 30499:
                        return BIND_BOSH_ERR;
                    case 40199:
                        return CHANNEL_TCP_ERR;
                    case 40399:
                        return CHANNEL_XMPPEXCEPTION;
                    case 40401:
                        return CHANNEL_BOSH_ITEMNOTFIND;
                    case 40499:
                        return CHANNEL_BOSH_EXCEPTION;
                    case 50001:
                        return CHANNEL_TIMER_DELAYED;
                    default:
                        switch (i2) {
                            case 10101:
                                return GSLB_TCP_NOACCESS;
                            case 10102:
                                return GSLB_TCP_NETUNREACH;
                            case 10103:
                                return GSLB_TCP_CONNREFUSED;
                            case 10104:
                                return GSLB_TCP_NOROUTETOHOST;
                            case 10105:
                                return GSLB_TCP_TIMEOUT;
                            case 10106:
                                return GSLB_TCP_INVALARG;
                            case 10107:
                                return GSLB_TCP_UKNOWNHOST;
                            default:
                                switch (i2) {
                                    case 20101:
                                        return CONN_TCP_NOACCESS;
                                    case 20102:
                                        return CONN_TCP_NETUNREACH;
                                    case 20103:
                                        return CONN_TCP_CONNREFUSED;
                                    case 20104:
                                        return CONN_TCP_NOROUTETOHOST;
                                    case 20105:
                                        return CONN_TCP_TIMEOUT;
                                    case 20106:
                                        return CONN_TCP_INVALARG;
                                    case 20107:
                                        return CONN_TCP_UKNOWNHOST;
                                    default:
                                        switch (i2) {
                                            case 30101:
                                                return BIND_TCP_READ_TIMEOUT_DEPRECTED;
                                            case 30102:
                                                return BIND_TCP_CONNRESET_DEPRECTED;
                                            case 30103:
                                                return BIND_TCP_BROKEN_PIPE_DEPRECTED;
                                            default:
                                                switch (i2) {
                                                    case 30108:
                                                        return BIND_TCP_READ_TIMEOUT;
                                                    case 30109:
                                                        return BIND_TCP_CONNRESET;
                                                    case 30110:
                                                        return BIND_TCP_BROKEN_PIPE;
                                                    default:
                                                        switch (i2) {
                                                            case 40101:
                                                                return CHANNEL_TCP_READTIMEOUT_DEPRECTED;
                                                            case 40102:
                                                                return CHANNEL_TCP_CONNRESET_DEPRECTED;
                                                            case 40103:
                                                                return CHANNEL_TCP_BROKEN_PIPE_DEPRECTED;
                                                            default:
                                                                switch (i2) {
                                                                    case 40108:
                                                                        return CHANNEL_TCP_READTIMEOUT;
                                                                    case 40109:
                                                                        return CHANNEL_TCP_CONNRESET;
                                                                    case 40110:
                                                                        return CHANNEL_TCP_BROKEN_PIPE;
                                                                    default:
                                                                        return null;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public int a() {
        return this.f72a;
    }
}
