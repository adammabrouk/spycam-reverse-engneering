package cn.jpush.android.bj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f9608a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f9609b;

    public b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jpush.statistics", 0);
        this.f9608a = sharedPreferences;
        this.f9609b = sharedPreferences.edit();
    }

    public Map<String, Integer> a() {
        return this.f9608a.getAll();
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a(String str) {
        this.f9609b.putInt(str, this.f9608a.getInt(str, 0) + 1);
        this.f9609b.apply();
    }

    public void b() {
        this.f9609b.clear();
        this.f9609b.apply();
    }
}
