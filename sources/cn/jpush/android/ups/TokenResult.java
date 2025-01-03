package cn.jpush.android.ups;

/* loaded from: classes.dex */
public class TokenResult {
    public String actionType;
    public int returnCode;
    public String token;

    public TokenResult(String str, int i2) {
        this.token = str;
        this.returnCode = i2;
    }

    public TokenResult(String str, int i2, String str2) {
        this.token = str;
        this.returnCode = i2;
        this.actionType = str2;
    }

    public String getActionType() {
        return this.actionType;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setActionType(String str) {
        this.actionType = str;
    }

    public void setReturnCode(int i2) {
        this.returnCode = i2;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "TokenResult{token='" + this.token + "', returnCode=" + this.returnCode + ", actionType='" + this.actionType + "'}";
    }
}
