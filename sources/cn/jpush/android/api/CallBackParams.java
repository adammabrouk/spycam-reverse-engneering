package cn.jpush.android.api;

import cn.jpush.android.helper.f;
import java.util.Set;

/* loaded from: classes.dex */
public class CallBackParams {
    public int action;
    public String alias;
    public int protoType;
    public long sendTime;
    public int sequence;
    public TagAliasCallback tagAliasCallBack;
    public Set<String> tags;

    public CallBackParams(int i2, String str, long j, int i3, int i4) {
        this.protoType = 0;
        this.action = 0;
        this.sequence = i2;
        this.alias = str;
        this.sendTime = j;
        this.protoType = i3;
        this.action = i4;
    }

    public CallBackParams(int i2, Set<String> set, long j, int i3, int i4) {
        this.protoType = 0;
        this.action = 0;
        this.sequence = i2;
        this.tags = set;
        this.sendTime = j;
        this.protoType = i3;
        this.action = i4;
    }

    public CallBackParams(String str, Set<String> set, TagAliasCallback tagAliasCallback, long j, int i2, int i3) {
        this.protoType = 0;
        this.action = 0;
        this.alias = str;
        this.tags = set;
        this.tagAliasCallBack = tagAliasCallback;
        this.sendTime = j;
        this.protoType = i2;
        this.action = i3;
        this.sequence = (int) f.a();
    }

    public boolean isTimeOut(long j) {
        return this.protoType == 0 && System.currentTimeMillis() - this.sendTime > j + 10000;
    }

    public String toString() {
        return "CallBackParams{sendTime=" + this.sendTime + ", alias='" + this.alias + "', tags=" + this.tags + ", tagAliasCallBack=" + this.tagAliasCallBack + ", sequence=" + this.sequence + ", protoType=" + this.protoType + ", action=" + this.action + '}';
    }
}
