package c.a.a.l.h;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class i extends g<InputStream> {
    public i(Context context, Uri uri) {
        super(context, uri);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.a.l.h.g
    public InputStream a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openInputStream(uri);
    }

    @Override // c.a.a.l.h.g
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
