package com.google.zxing.client.j2se;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class CommandLineRunner {
    public static List<URI> expand(List<URI> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (URI uri : list) {
            if (isFileOrDir(uri)) {
                Path path = Paths.get(uri);
                if (Files.isDirectory(path, new LinkOption[0])) {
                    Throwable th = null;
                    try {
                        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path);
                        try {
                            Iterator<Path> it = newDirectoryStream.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().toUri());
                            }
                            if (newDirectoryStream != null) {
                                newDirectoryStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (newDirectoryStream == null) {
                                throw th;
                            }
                            newDirectoryStream.close();
                            throw th;
                        }
                    } finally {
                    }
                } else {
                    arrayList.add(uri);
                }
            } else {
                arrayList.add(uri);
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            URI uri2 = (URI) arrayList.get(i2);
            if (uri2.getScheme() == null) {
                arrayList.set(i2, Paths.get(uri2.getRawPath(), new String[0]).toUri());
            }
        }
        return arrayList;
    }

    public static boolean isExpandable(List<URI> list) {
        for (URI uri : list) {
            if (isFileOrDir(uri) && Files.isDirectory(Paths.get(uri), new LinkOption[0])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFileOrDir(URI uri) {
        return "file".equals(uri.getScheme());
    }

    public static void main(String[] strArr) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tJCommander cannot be resolved to a type\n\tJCommander cannot be resolved to a type\n");
    }

    public static List<URI> retainValid(List<URI> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (URI uri : list) {
            boolean z2 = true;
            if (isFileOrDir(uri)) {
                Path path = Paths.get(uri);
                if (path.getFileName().toString().startsWith(".") || (!z && Files.isDirectory(path, new LinkOption[0]))) {
                    z2 = false;
                }
            }
            if (z2) {
                arrayList.add(uri);
            }
        }
        return arrayList;
    }
}
