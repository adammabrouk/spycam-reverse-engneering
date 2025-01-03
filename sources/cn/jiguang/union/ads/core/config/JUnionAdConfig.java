package cn.jiguang.union.ads.core.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class JUnionAdConfig {
    public Boolean allowRunningProcess;
    public boolean debug;
    public Map<String, Object> extra;

    public static class Builder {
        public boolean debug = false;
        public Boolean allowRunningProcess = null;
        public Map<String, Object> extra = new HashMap();

        public Builder allowRunningProcess(boolean z) {
            this.allowRunningProcess = Boolean.valueOf(z);
            return this;
        }

        public JUnionAdConfig build() {
            JUnionAdConfig jUnionAdConfig = new JUnionAdConfig();
            jUnionAdConfig.setDebug(this.debug);
            jUnionAdConfig.setAllowRunningProcess(this.allowRunningProcess);
            jUnionAdConfig.setExtra(this.extra);
            return jUnionAdConfig;
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setExtra(Map<String, Object> map) {
            this.extra = map;
            return this;
        }
    }

    public static class KEY {
        public static final String PROBES_INTERVAL = "probes_interval";
    }

    public JUnionAdConfig() {
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public Boolean isAllowRunningProcess() {
        return this.allowRunningProcess;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setAllowRunningProcess(Boolean bool) {
        this.allowRunningProcess = bool;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setExtra(Map<String, Object> map) {
        this.extra = map;
    }
}
