package com.alibaba.sdk.android.oss.model;

import java.util.Map;

/* loaded from: classes.dex */
public class GetObjectTaggingResult extends OSSResult {
    public Map<String, String> tags;

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTags(Map<String, String> map) {
        this.tags = map;
    }
}
