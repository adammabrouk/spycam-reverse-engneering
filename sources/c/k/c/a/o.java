package c.k.c.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class o implements PushMessageHandler.a {
    public static final int MESSAGE_TYPE_ACCOUNT = 3;
    public static final int MESSAGE_TYPE_ALIAS = 1;
    public static final int MESSAGE_TYPE_REG = 0;
    public static final int MESSAGE_TYPE_TOPIC = 2;
    public static final long serialVersionUID = 1;
    public String alias;
    public String category;
    public String content;
    public String description;
    public boolean isNotified;
    public String messageId;
    public int messageType;
    public int notifyId;
    public int notifyType;
    public int passThrough;
    public String title;
    public String topic;
    public String userAccount;
    public boolean arrived = false;
    public HashMap<String, String> extra = new HashMap<>();

    public static o fromBundle(Bundle bundle) {
        o oVar = new o();
        oVar.messageId = bundle.getString("messageId");
        oVar.messageType = bundle.getInt("messageType");
        oVar.passThrough = bundle.getInt("passThrough");
        oVar.alias = bundle.getString("alias");
        oVar.userAccount = bundle.getString("user_account");
        oVar.topic = bundle.getString("topic");
        oVar.content = bundle.getString("content");
        oVar.description = bundle.getString("description");
        oVar.title = bundle.getString("title");
        oVar.isNotified = bundle.getBoolean("isNotified");
        oVar.notifyId = bundle.getInt("notifyId");
        oVar.notifyType = bundle.getInt("notifyType");
        oVar.category = bundle.getString("category");
        oVar.extra = (HashMap) bundle.getSerializable("extra");
        return oVar;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCategory() {
        return this.category;
    }

    public String getContent() {
        return this.content;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public int getPassThrough() {
        return this.passThrough;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public boolean isArrivedMessage() {
        return this.arrived;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setArrivedMessage(boolean z) {
        this.arrived = z;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtra(Map<String, String> map) {
        this.extra.clear();
        if (map != null) {
            this.extra.putAll(map);
        }
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i2) {
        this.messageType = i2;
    }

    public void setNotified(boolean z) {
        this.isNotified = z;
    }

    public void setNotifyId(int i2) {
        this.notifyId = i2;
    }

    public void setNotifyType(int i2) {
        this.notifyType = i2;
    }

    public void setPassThrough(int i2) {
        this.passThrough = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public void setUserAccount(String str) {
        this.userAccount = str;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("messageId", this.messageId);
        bundle.putInt("passThrough", this.passThrough);
        bundle.putInt("messageType", this.messageType);
        if (!TextUtils.isEmpty(this.alias)) {
            bundle.putString("alias", this.alias);
        }
        if (!TextUtils.isEmpty(this.userAccount)) {
            bundle.putString("user_account", this.userAccount);
        }
        if (!TextUtils.isEmpty(this.topic)) {
            bundle.putString("topic", this.topic);
        }
        bundle.putString("content", this.content);
        if (!TextUtils.isEmpty(this.description)) {
            bundle.putString("description", this.description);
        }
        if (!TextUtils.isEmpty(this.title)) {
            bundle.putString("title", this.title);
        }
        bundle.putBoolean("isNotified", this.isNotified);
        bundle.putInt("notifyId", this.notifyId);
        bundle.putInt("notifyType", this.notifyType);
        if (!TextUtils.isEmpty(this.category)) {
            bundle.putString("category", this.category);
        }
        HashMap<String, String> hashMap = this.extra;
        if (hashMap != null) {
            bundle.putSerializable("extra", hashMap);
        }
        return bundle;
    }

    public String toString() {
        return "messageId={" + this.messageId + "},passThrough={" + this.passThrough + "},alias={" + this.alias + "},topic={" + this.topic + "},userAccount={" + this.userAccount + "},content={" + this.content + "},description={" + this.description + "},title={" + this.title + "},isNotified={" + this.isNotified + "},notifyId={" + this.notifyId + "},notifyType={" + this.notifyType + "}, category={" + this.category + "}, extra={" + this.extra + "}";
    }
}
