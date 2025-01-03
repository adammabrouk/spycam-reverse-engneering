package c.k.d;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class a9 extends d9 {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f6975a = null;

    /* renamed from: b, reason: collision with root package name */
    public OutputStream f6976b;

    public a9(OutputStream outputStream) {
        this.f6976b = null;
        this.f6976b = outputStream;
    }

    @Override // c.k.d.d9
    public int a(byte[] bArr, int i2, int i3) {
        InputStream inputStream = this.f6975a;
        if (inputStream == null) {
            throw new e9(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i2, i3);
            if (read >= 0) {
                return read;
            }
            throw new e9(4);
        } catch (IOException e2) {
            throw new e9(0, e2);
        }
    }

    @Override // c.k.d.d9
    /* renamed from: a, reason: collision with other method in class */
    public void mo76a(byte[] bArr, int i2, int i3) {
        OutputStream outputStream = this.f6976b;
        if (outputStream == null) {
            throw new e9(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i2, i3);
        } catch (IOException e2) {
            throw new e9(0, e2);
        }
    }
}
