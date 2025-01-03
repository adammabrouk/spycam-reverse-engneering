package cn.jpush.android.ai;

import android.view.View;
import cn.jiguang.union.ads.api.JUnionAdImage;
import cn.jiguang.union.ads.nativ.api.JNativeAd;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdEventListener;
import cn.jpush.android.k.d;
import cn.jpush.android.x.b;
import java.util.List;

/* loaded from: classes.dex */
public class a implements JNativeAd {

    /* renamed from: a, reason: collision with root package name */
    public String f9116a;

    /* renamed from: b, reason: collision with root package name */
    public String f9117b;

    /* renamed from: c, reason: collision with root package name */
    public List<JUnionAdImage> f9118c;

    /* renamed from: d, reason: collision with root package name */
    public int f9119d;

    /* renamed from: e, reason: collision with root package name */
    public d f9120e;

    /* renamed from: f, reason: collision with root package name */
    public int f9121f;

    /* renamed from: g, reason: collision with root package name */
    public d f9122g;

    /* renamed from: h, reason: collision with root package name */
    public b f9123h;

    public int a() {
        return this.f9119d;
    }

    public void a(int i2) {
        this.f9119d = i2;
    }

    public void a(d dVar) {
        this.f9120e = dVar;
    }

    public void a(b bVar) {
        this.f9123h = bVar;
    }

    public void a(String str) {
        this.f9116a = str;
    }

    public void a(List<JUnionAdImage> list) {
        this.f9118c = list;
    }

    public d b() {
        return this.f9120e;
    }

    public void b(int i2) {
        this.f9121f = i2;
    }

    public void b(d dVar) {
        this.f9122g = dVar;
    }

    public void b(String str) {
        this.f9117b = str;
    }

    public int c() {
        return this.f9121f;
    }

    public d d() {
        return this.f9122g;
    }

    public b e() {
        return this.f9123h;
    }

    @Override // cn.jiguang.union.ads.nativ.api.JNativeAd
    public String getContent() {
        return this.f9117b;
    }

    @Override // cn.jiguang.union.ads.nativ.api.JNativeAd
    public List<JUnionAdImage> getImageList() {
        return this.f9118c;
    }

    @Override // cn.jiguang.union.ads.nativ.api.JNativeAd
    public String getTitle() {
        return this.f9116a;
    }

    @Override // cn.jiguang.union.ads.nativ.api.JNativeAd
    public void setOnNativeAdEventListener(View view, OnNativeAdEventListener onNativeAdEventListener) {
        cn.jpush.android.ag.a.a().a(this, view, (List<View>) null, onNativeAdEventListener);
    }

    @Override // cn.jiguang.union.ads.nativ.api.JNativeAd
    public void setOnNativeAdEventListener(View view, List<View> list, OnNativeAdEventListener onNativeAdEventListener) {
        cn.jpush.android.ag.a.a().a(this, view, list, onNativeAdEventListener);
    }
}
