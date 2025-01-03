package c.a.a.l.h;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileDescriptorLocalUriFetcher.java */
/* loaded from: classes.dex */
public class e extends g<ParcelFileDescriptor> {
    public e(Context context, Uri uri) {
        super(context, uri);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.a.l.h.g
    public ParcelFileDescriptor a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }

    @Override // c.a.a.l.h.g
    public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
}
