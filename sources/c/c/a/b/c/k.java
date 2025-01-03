package c.c.a.b.c;

import android.content.Intent;

/* loaded from: classes.dex */
public class k extends Exception {
    public final Intent mIntent;

    public k(String str, Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public Intent getIntent() {
        return new Intent(this.mIntent);
    }
}
