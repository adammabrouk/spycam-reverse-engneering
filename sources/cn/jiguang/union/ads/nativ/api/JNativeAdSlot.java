package cn.jiguang.union.ads.nativ.api;

import cn.jiguang.union.ads.api.JUnionAdSlot;
import com.shix.shixipc.activity.AddCameraActivity;
import java.util.UUID;

/* loaded from: classes.dex */
public class JNativeAdSlot implements JUnionAdSlot {
    public String adCode;
    public int adStyle;
    public String sequence;
    public int adCount = 1;
    public int timeout = AddCameraActivity.SEARCH_TIME;

    public static class Builder {
        public String adCode;
        public int adCount;
        public int adStyle;
        public int timeout;

        public JNativeAdSlot build() {
            JNativeAdSlot jNativeAdSlot = new JNativeAdSlot();
            jNativeAdSlot.sequence = String.valueOf(UUID.randomUUID()).toLowerCase();
            jNativeAdSlot.adCode = this.adCode;
            jNativeAdSlot.adStyle = this.adStyle;
            jNativeAdSlot.adCount = this.adCount;
            jNativeAdSlot.timeout = this.timeout;
            return jNativeAdSlot;
        }

        public Builder setAdCode(String str) {
            this.adCode = str;
            return this;
        }

        public Builder setAdCount(int i2) {
            this.adCount = i2;
            return this;
        }

        public Builder setAdStyle(int i2) {
            this.adStyle = i2;
            return this;
        }

        public Builder setTimeout(int i2) {
            this.timeout = i2;
            return this;
        }
    }

    public String getAdCode() {
        return this.adCode;
    }

    @Override // cn.jiguang.union.ads.api.JUnionAdSlot
    public int getAdCount() {
        return this.adCount;
    }

    @Override // cn.jiguang.union.ads.api.JUnionAdSlot
    public int getAdStyle() {
        return this.adStyle;
    }

    @Override // cn.jiguang.union.ads.api.JUnionAdSlot
    public String getSequence() {
        return this.sequence;
    }

    @Override // cn.jiguang.union.ads.api.JUnionAdSlot
    public int getTimeout() {
        return this.timeout;
    }
}
