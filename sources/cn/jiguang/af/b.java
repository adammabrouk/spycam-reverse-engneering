package cn.jiguang.af;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f8138a;

    /* renamed from: b, reason: collision with root package name */
    public final TelephonyManager f8139b;

    /* renamed from: c, reason: collision with root package name */
    public cn.jiguang.ag.a f8140c;

    public class a extends PhoneStateListener {
        public a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            cn.jiguang.ag.a aVar;
            int networkId;
            try {
                super.onSignalStrengthsChanged(signalStrength);
                b.this.f8140c.f8160f = signalStrength.getGsmSignalStrength();
                CellLocation cellLocation = b.this.f8139b.getCellLocation();
                if (cellLocation == null) {
                    return;
                }
                if (!(cellLocation instanceof GsmCellLocation)) {
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        b.this.f8140c.f8159e = cdmaCellLocation.getBaseStationId();
                        aVar = b.this.f8140c;
                        networkId = cdmaCellLocation.getNetworkId();
                    }
                    b.this.f8139b.listen(this, 0);
                }
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                b.this.f8140c.f8159e = gsmCellLocation.getCid();
                aVar = b.this.f8140c;
                networkId = gsmCellLocation.getLac();
                aVar.f8158d = networkId;
                b.this.f8139b.listen(this, 0);
            } catch (Throwable unused) {
            }
        }
    }

    public b(Context context) {
        this.f8138a = context;
        this.f8139b = (TelephonyManager) context.getSystemService("phone");
    }

    public cn.jiguang.ag.a a() {
        return this.f8140c;
    }

    public void b() {
        if (this.f8139b == null) {
            cn.jiguang.ai.a.d("JLocationCell", "get telephonyManager failed");
            return;
        }
        cn.jiguang.ag.a aVar = new cn.jiguang.ag.a();
        this.f8140c = aVar;
        aVar.f8155a = cn.jiguang.l.d.i(this.f8138a);
        String networkOperator = this.f8139b.getNetworkOperator();
        if (networkOperator.length() > 3) {
            this.f8140c.f8156b = Integer.parseInt(networkOperator.substring(0, 3));
            this.f8140c.f8157c = Integer.parseInt(networkOperator.substring(3));
        }
        this.f8140c.f8163i = this.f8139b.getNetworkOperatorName();
        this.f8140c.f8161g = cn.jiguang.l.d.a(this.f8139b.getNetworkType());
        this.f8140c.f8162h = cn.jiguang.l.d.a(this.f8138a, this.f8139b.getNetworkType());
        if (Build.VERSION.SDK_INT <= 17) {
            this.f8139b.listen(new a(), RecyclerView.c0.FLAG_TMP_DETACHED);
            return;
        }
        List<CellInfo> allCellInfo = this.f8139b.getAllCellInfo();
        if (allCellInfo == null || allCellInfo.size() <= 0) {
            return;
        }
        for (CellInfo cellInfo : allCellInfo) {
            if (cellInfo != null) {
                if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                    CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                    this.f8140c.f8160f = cellSignalStrength.getDbm();
                    this.f8140c.f8159e = cellIdentity.getCi();
                    this.f8140c.f8158d = cellIdentity.getTac();
                    if (this.f8140c.f8159e < 268435455) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellSignalStrengthGsm cellSignalStrength2 = cellInfoGsm.getCellSignalStrength();
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    this.f8140c.f8160f = cellSignalStrength2.getDbm();
                    this.f8140c.f8159e = cellIdentity2.getCid();
                    this.f8140c.f8158d = cellIdentity2.getLac();
                    if (this.f8140c.f8159e < 65535) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellSignalStrengthCdma cellSignalStrength3 = cellInfoCdma.getCellSignalStrength();
                    CellIdentityCdma cellIdentity3 = cellInfoCdma.getCellIdentity();
                    this.f8140c.f8160f = cellSignalStrength3.getDbm();
                    this.f8140c.f8159e = cellIdentity3.getBasestationId();
                    this.f8140c.f8158d = cellIdentity3.getNetworkId();
                    if (this.f8140c.f8159e < 65535) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellSignalStrengthWcdma cellSignalStrength4 = cellInfoWcdma.getCellSignalStrength();
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    this.f8140c.f8160f = cellSignalStrength4.getDbm();
                    this.f8140c.f8159e = cellIdentity4.getCid();
                    this.f8140c.f8158d = cellIdentity4.getLac();
                    if (this.f8140c.f8159e < 268435455) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
