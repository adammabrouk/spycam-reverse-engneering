package c.k.d;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes.dex */
public final class w9 implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
