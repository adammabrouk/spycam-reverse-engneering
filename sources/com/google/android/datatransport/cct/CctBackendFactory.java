package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import c.c.a.a.i.e;
import c.c.a.a.j.t.d;
import c.c.a.a.j.t.h;
import c.c.a.a.j.t.m;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
@Keep
/* loaded from: classes.dex */
public class CctBackendFactory implements d {
    @Override // c.c.a.a.j.t.d
    public m create(h hVar) {
        return new e(hVar.a(), hVar.d(), hVar.c());
    }
}
