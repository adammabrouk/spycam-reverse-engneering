package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import c.c.a.b.f.d.a;
import c.c.a.b.f.d.f;
import c.c.a.b.j.c;
import c.c.a.b.j.h;
import c.c.a.b.j.i;
import c.c.a.b.j.k;
import c.c.b.l.g0;
import c.c.b.l.h0;
import c.c.b.l.i0;
import c.c.b.p.l;
import com.google.firebase.messaging.zzf;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes.dex */
public abstract class zzf extends Service {
    public Binder zzb;
    public int zzd;
    public final ExecutorService zza = a.a().a(new c.c.a.b.c.s.s.a("Firebase-Messaging-Intent-Handle"), f.f4052a);
    public final Object zzc = new Object();
    public int zze = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final h<Void> zzd(final Intent intent) {
        if (zzb(intent)) {
            return k.a((Object) null);
        }
        final i iVar = new i();
        this.zza.execute(new Runnable(this, intent, iVar) { // from class: c.c.b.p.m

            /* renamed from: a, reason: collision with root package name */
            public final zzf f6155a;

            /* renamed from: b, reason: collision with root package name */
            public final Intent f6156b;

            /* renamed from: c, reason: collision with root package name */
            public final c.c.a.b.j.i f6157c;

            {
                this.f6155a = this;
                this.f6156b = intent;
                this.f6157c = iVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzf zzfVar = this.f6155a;
                Intent intent2 = this.f6156b;
                c.c.a.b.j.i iVar2 = this.f6157c;
                try {
                    zzfVar.zzc(intent2);
                } finally {
                    iVar2.a((c.c.a.b.j.i) null);
                }
            }
        });
        return iVar.a();
    }

    private final void zzf(Intent intent) {
        if (intent != null) {
            h0.a(intent);
        }
        synchronized (this.zzc) {
            int i2 = this.zze - 1;
            this.zze = i2;
            if (i2 == 0) {
                stopSelfResult(this.zzd);
            }
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.zzb == null) {
            this.zzb = new g0(new i0(this) { // from class: c.c.b.p.k

                /* renamed from: a, reason: collision with root package name */
                public final zzf f6153a;

                {
                    this.f6153a = this;
                }

                @Override // c.c.b.l.i0
                public final c.c.a.b.j.h a(Intent intent2) {
                    return this.f6153a.zzd(intent2);
                }
            });
        }
        return this.zzb;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.zza.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i2, int i3) {
        synchronized (this.zzc) {
            this.zzd = i3;
            this.zze++;
        }
        Intent zza = zza(intent);
        if (zza == null) {
            zzf(intent);
            return 2;
        }
        h<Void> zzd = zzd(zza);
        if (zzd.d()) {
            zzf(intent);
            return 2;
        }
        zzd.a(l.f6154a, new c(this, intent) { // from class: c.c.b.p.o

            /* renamed from: a, reason: collision with root package name */
            public final zzf f6158a;

            /* renamed from: b, reason: collision with root package name */
            public final Intent f6159b;

            {
                this.f6158a = this;
                this.f6159b = intent;
            }

            @Override // c.c.a.b.j.c
            public final void onComplete(c.c.a.b.j.h hVar) {
                this.f6158a.zza(this.f6159b, hVar);
            }
        });
        return 3;
    }

    public Intent zza(Intent intent) {
        return intent;
    }

    public final /* synthetic */ void zza(Intent intent, h hVar) {
        zzf(intent);
    }

    public boolean zzb(Intent intent) {
        return false;
    }

    public abstract void zzc(Intent intent);
}
