package a.a.e.d;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;

/* compiled from: ActivityResultContracts.java */
/* loaded from: classes.dex */
public final class d extends a<Intent, ActivityResult> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public Intent a2(Context context, Intent intent) {
        return intent;
    }

    @Override // a.a.e.d.a
    public /* bridge */ /* synthetic */ Intent a(Context context, Intent intent) {
        Intent intent2 = intent;
        a2(context, intent2);
        return intent2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // a.a.e.d.a
    public ActivityResult a(int i2, Intent intent) {
        return new ActivityResult(i2, intent);
    }
}
