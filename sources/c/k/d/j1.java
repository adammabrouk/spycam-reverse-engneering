package c.k.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import c.k.d.h1;

/* loaded from: classes.dex */
public class j1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7272a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h1.a f7273b;

    public j1(h1.a aVar, Context context) {
        this.f7273b = aVar;
        this.f7272a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f7273b.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f7273b.a(this.f7272a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        e = e2;
                        c.k.a.a.a.c.a(e);
                        this.f7273b.a(this.f7272a);
                    }
                }
                if (this.f7273b.f7198b != null) {
                    this.f7273b.f7198b.close();
                }
            } catch (Exception e3) {
                c.k.a.a.a.c.a(e3);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e4) {
                        e = e4;
                        c.k.a.a.a.c.a(e);
                        this.f7273b.a(this.f7272a);
                    }
                }
                if (this.f7273b.f7198b != null) {
                    this.f7273b.f7198b.close();
                }
            }
            this.f7273b.a(this.f7272a);
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e5) {
                    c.k.a.a.a.c.a(e5);
                    this.f7273b.a(this.f7272a);
                    throw th;
                }
            }
            if (this.f7273b.f7198b != null) {
                this.f7273b.f7198b.close();
            }
            this.f7273b.a(this.f7272a);
            throw th;
        }
    }
}
