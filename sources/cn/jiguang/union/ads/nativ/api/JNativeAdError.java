package cn.jiguang.union.ads.nativ.api;

import cn.jiguang.union.ads.api.JUnionAdError;

/* loaded from: classes.dex */
public class JNativeAdError extends JUnionAdError {
    static {
        JUnionAdError.map.put(21000, "native ad load success");
        JUnionAdError.map.put(21001, "native ad load failed, unknown");
        JUnionAdError.map.put(21002, "native ad load failed, unknown");
        JUnionAdError.map.put(21003, "native ad load failed, client limit");
        JUnionAdError.map.put(21004, "native ad load failed, server limit");
        JUnionAdError.map.put(21005, "native ad load failed, network limit");
        JUnionAdError.map.put(21006, "native ad load failed, timeout");
        JUnionAdError.map.put(21007, "native ad load, receive message within time");
        JUnionAdError.map.put(21008, "native ad load, receive message without time");
        JUnionAdError.map.put(21009, "native ad load, parse message failed");
        JUnionAdError.map.put(21010, "native ad load, parse message success");
        JUnionAdError.map.put(21011, "native ad load, tcp disConnected");
        JUnionAdError.map.put(21099, "native ad received, start send broadcast");
        JUnionAdError.map.put(22000, "native ad verify success");
        JUnionAdError.map.put(22001, "native ad verify failed, unknown");
        JUnionAdError.map.put(22002, "verify base failed, expired");
        JUnionAdError.map.put(22003, "verify base failed, appKey count limit");
        JUnionAdError.map.put(22004, "verify base failed, appKey time limit");
        JUnionAdError.map.put(22005, "verify base failed, adCode count limit");
        JUnionAdError.map.put(22006, "verify base failed, adCode time limit");
        JUnionAdError.map.put(22007, "verify base failed, adStyle count limit");
        JUnionAdError.map.put(22008, "verify base failed, adStyle time limit");
        JUnionAdError.map.put(22100, "verify h5 success");
        JUnionAdError.map.put(22101, "verify h5 failed, unknown");
        JUnionAdError.map.put(22102, "verify h5 failed, param empty");
        JUnionAdError.map.put(22103, "verify h5 failed, param illegal");
        JUnionAdError.map.put(22200, "verify deepLink success");
        JUnionAdError.map.put(22201, "verify deepLink failed, unknown");
        JUnionAdError.map.put(22202, "verify deepLink failed, param empty");
        JUnionAdError.map.put(22203, "verify deepLink failed, param illegal");
        JUnionAdError.map.put(22204, "verify deepLink failed, target package not install");
        JUnionAdError.map.put(22300, "verify wechat process success");
        JUnionAdError.map.put(22301, "verify wechat process failed, unknown");
        JUnionAdError.map.put(22302, "verify wechat process failed, param empty");
        JUnionAdError.map.put(22303, "verify wechat process failed, param illegal");
        JUnionAdError.map.put(22304, "verify wechat process failed, target package not install");
        JUnionAdError.map.put(22400, "verify download success");
        JUnionAdError.map.put(22401, "verify download failed, unknown");
        JUnionAdError.map.put(22402, "verify download failed, param empty");
        JUnionAdError.map.put(22403, "verify download failed, param illegal");
        JUnionAdError.map.put(22404, "verify download failed, target package has install");
        JUnionAdError.map.put(23000, "native ad exposure success");
        JUnionAdError.map.put(23001, "native ad exposure failed, unknown");
        JUnionAdError.map.put(23002, "native ad exposure failed, expired");
        JUnionAdError.map.put(23003, "native ad exposure failed, not frontGround");
        JUnionAdError.map.put(23004, "native ad exposure failed, not visible");
        JUnionAdError.map.put(23005, "native ad exposure failed, not on screen");
        JUnionAdError.map.put(23006, "native ad exposure failed, alpha is illegal");
        JUnionAdError.map.put(23100, "verify h5 success");
        JUnionAdError.map.put(23101, "verify h5 failed, unknown");
        JUnionAdError.map.put(23102, "verify h5 failed, param empty");
        JUnionAdError.map.put(23103, "verify h5 failed, param illegal");
        JUnionAdError.map.put(23200, "verify deepLink success");
        JUnionAdError.map.put(23201, "verify deepLink failed, unknown");
        JUnionAdError.map.put(23202, "verify deepLink failed, param empty");
        JUnionAdError.map.put(23203, "verify deepLink failed, param illegal");
        JUnionAdError.map.put(23204, "verify deepLink failed, target package not install");
        JUnionAdError.map.put(23300, "verify wechat process success");
        JUnionAdError.map.put(23301, "verify wechat process failed, unknown");
        JUnionAdError.map.put(23302, "verify wechat process failed, param empty");
        JUnionAdError.map.put(23303, "verify wechat process failed, param illegal");
        JUnionAdError.map.put(23304, "verify wechat process failed, target package not install");
        JUnionAdError.map.put(23400, "verify download success");
        JUnionAdError.map.put(23401, "verify download failed, unknown");
        JUnionAdError.map.put(23402, "verify download failed, param empty");
        JUnionAdError.map.put(23403, "verify download failed, param illegal");
        JUnionAdError.map.put(23404, "verify download failed, target package has install");
        JUnionAdError.map.put(23999, "native ad exposure success finally");
        JUnionAdError.map.put(24000, "native ad click success");
        JUnionAdError.map.put(24001, "native ad click failed, unknown");
        JUnionAdError.map.put(24002, "native ad click failed, expired");
        JUnionAdError.map.put(24003, "native ad click, exposure failed, not frontGround");
        JUnionAdError.map.put(24004, "native ad click, exposure failed, not visible");
        JUnionAdError.map.put(24005, "native ad click, exposure failed, not on screen");
        JUnionAdError.map.put(24006, "native ad click, exposure failed, alpha is illegal");
        JUnionAdError.map.put(24100, "verify h5 success");
        JUnionAdError.map.put(24101, "verify h5 failed, unknown");
        JUnionAdError.map.put(24102, "verify h5 failed, param empty");
        JUnionAdError.map.put(24103, "verify h5 failed, param illegal");
        JUnionAdError.map.put(24200, "verify deepLink success");
        JUnionAdError.map.put(24201, "verify deepLink failed, unknown");
        JUnionAdError.map.put(24202, "verify deepLink failed, param empty");
        JUnionAdError.map.put(24203, "verify deepLink failed, param illegal");
        JUnionAdError.map.put(24204, "verify deepLink failed, target package not install");
        JUnionAdError.map.put(24300, "verify wechat process success");
        JUnionAdError.map.put(24301, "verify wechat process failed, unknown");
        JUnionAdError.map.put(24302, "verify wechat process failed, param empty");
        JUnionAdError.map.put(24303, "verify wechat process failed, param illegal");
        JUnionAdError.map.put(24304, "verify wechat process failed, target package not install");
        JUnionAdError.map.put(24400, "verify download success");
        JUnionAdError.map.put(24401, "verify download failed, unknown");
        JUnionAdError.map.put(24402, "verify download failed, param empty");
        JUnionAdError.map.put(24403, "verify download failed, param illegal");
        JUnionAdError.map.put(24404, "verify download failed, target package has install");
        JUnionAdError.map.put(24999, "native ad click, exposure success finally");
        JUnionAdError.map.put(25000, "native ad jump success");
        JUnionAdError.map.put(25001, "native ad jump failed, unknown");
        JUnionAdError.map.put(25100, "jump h5 success");
        JUnionAdError.map.put(25101, "jump h5 failed");
        JUnionAdError.map.put(25200, "jump deepLink success");
        JUnionAdError.map.put(25201, "jump deepLink failed");
        JUnionAdError.map.put(25300, "jump wechat process success");
        JUnionAdError.map.put(25301, "jump wechat process failed");
        JUnionAdError.map.put(25400, "jump download success");
        JUnionAdError.map.put(25401, "jump download failed");
    }

    public JNativeAdError(int i2) {
        super(i2);
    }
}
