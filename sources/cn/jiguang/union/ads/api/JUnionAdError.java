package cn.jiguang.union.ads.api;

import android.util.SparseArray;

/* loaded from: classes.dex */
public class JUnionAdError {
    public static final SparseArray<String> map;
    public int code;
    public String message;

    public static class Code {
        public static final int PARAM_EMPTY = 2;
        public static final int PARAM_ILLEGAL = 3;
        public static final int SUCCESS = 0;
        public static final int UNKNOWN = 1;
    }

    public static class Message {
        public static final String PARAM_EMPTY = "there are empty param";
        public static final String PARAM_ILLEGAL = "there are illegal param";
        public static final String SUCCESS = "success";
        public static final String UNKNOWN = "unknown";
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        map = sparseArray;
        sparseArray.put(8001, "no available ads");
        map.put(8002, "over frequency");
        map.put(8003, "no match style");
        map.put(8004, "internal error");
        map.put(8005, "pull pattern does not match");
        map.put(8006, "service not opened or loading operation configuration abnormal");
        map.put(8007, "operation has no available ad space");
        map.put(8008, "advertising space exposure frequency control internal error");
        map.put(8009, "ad space exposure interval frequency control");
        map.put(8010, "frequency control of exposure times of advertising space");
        map.put(8011, "uid send down frequency control internal error");
        map.put(8012, "uid send down frequency control interval error");
        map.put(8013, "uid send down frequency control count error");
        map.put(8014, "request timeout");
        map.put(8015, "extra request parameters are not legal");
        map.put(0, Message.SUCCESS);
        map.put(1, "unknown");
    }

    public JUnionAdError(int i2) {
        this.code = i2;
        this.message = map.get(i2);
    }

    public static String getMessage(int i2) {
        return map.get(i2);
    }
}
