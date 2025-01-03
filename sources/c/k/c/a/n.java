package c.k.c.a;

import android.os.Bundle;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class n implements PushMessageHandler.a {
    public static final long serialVersionUID = 1;
    public String category;
    public String command;
    public List<String> commandArguments;
    public String reason;
    public long resultCode;

    public static n fromBundle(Bundle bundle) {
        n nVar = new n();
        nVar.command = bundle.getString("command");
        nVar.resultCode = bundle.getLong("resultCode");
        nVar.reason = bundle.getString("reason");
        nVar.commandArguments = bundle.getStringArrayList("commandArguments");
        nVar.category = bundle.getString("category");
        return nVar;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCommand() {
        return this.command;
    }

    public List<String> getCommandArguments() {
        return this.commandArguments;
    }

    public String getReason() {
        return this.reason;
    }

    public long getResultCode() {
        return this.resultCode;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setCommandArguments(List<String> list) {
        this.commandArguments = list;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setResultCode(long j) {
        this.resultCode = j;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("command", this.command);
        bundle.putLong("resultCode", this.resultCode);
        bundle.putString("reason", this.reason);
        List<String> list = this.commandArguments;
        if (list != null) {
            bundle.putStringArrayList("commandArguments", (ArrayList) list);
        }
        bundle.putString("category", this.category);
        return bundle;
    }

    public String toString() {
        return "command={" + this.command + "}, resultCode={" + this.resultCode + "}, reason={" + this.reason + "}, category={" + this.category + "}, commandArguments={" + this.commandArguments + "}";
    }
}
