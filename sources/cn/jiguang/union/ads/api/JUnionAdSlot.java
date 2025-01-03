package cn.jiguang.union.ads.api;

/* loaded from: classes.dex */
public interface JUnionAdSlot {
    public static final int STYLE_BANNER = 1;
    public static final int STYLE_FLOAT = 4;
    public static final int STYLE_MODAL = 2;

    int getAdCount();

    int getAdStyle();

    String getSequence();

    int getTimeout();
}
