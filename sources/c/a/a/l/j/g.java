package c.a.a.l.j;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: ImageVideoWrapper.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f3197a;

    /* renamed from: b, reason: collision with root package name */
    public final ParcelFileDescriptor f3198b;

    public g(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.f3197a = inputStream;
        this.f3198b = parcelFileDescriptor;
    }

    public ParcelFileDescriptor a() {
        return this.f3198b;
    }

    public InputStream b() {
        return this.f3197a;
    }
}
