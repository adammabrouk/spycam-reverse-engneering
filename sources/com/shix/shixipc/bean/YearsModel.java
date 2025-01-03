package com.shix.shixipc.bean;

import com.google.gson.internal.bind.TypeAdapters;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class YearsModel {
    public int cmd;
    public ArrayList<String> days = new ArrayList<>();
    public int result;

    public static YearsModel jsonToModel(String str) throws JSONException {
        int i2;
        int i3;
        int i4;
        YearsModel yearsModel = new YearsModel();
        JSONObject jSONObject = new JSONObject(str);
        yearsModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        yearsModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        int jasonPaseInt = CommonUtil.jasonPaseInt(jSONObject, TypeAdapters.AnonymousClass27.YEAR, ContentCommon.SHIXFINAL_ERRORINT);
        if (jasonPaseInt != 1970 && (jasonPaseInt < 2018 || jasonPaseInt > 2035)) {
            jasonPaseInt = 2022;
        }
        int jasonPaseInt2 = CommonUtil.jasonPaseInt(jSONObject, "month[0]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt3 = CommonUtil.jasonPaseInt(jSONObject, "month[1]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt4 = CommonUtil.jasonPaseInt(jSONObject, "month[2]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt5 = CommonUtil.jasonPaseInt(jSONObject, "month[3]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt6 = CommonUtil.jasonPaseInt(jSONObject, "month[4]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt7 = CommonUtil.jasonPaseInt(jSONObject, "month[5]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt8 = CommonUtil.jasonPaseInt(jSONObject, "month[6]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt9 = CommonUtil.jasonPaseInt(jSONObject, "month[7]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt10 = CommonUtil.jasonPaseInt(jSONObject, "month[8]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt11 = CommonUtil.jasonPaseInt(jSONObject, "month[9]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt12 = CommonUtil.jasonPaseInt(jSONObject, "month[10]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt13 = CommonUtil.jasonPaseInt(jSONObject, "month[11]", ContentCommon.SHIXFINAL_ERRORINT);
        CommonUtil.Log(1, "YearsModel jsonToModel month0:" + jasonPaseInt2 + "  month1:" + jasonPaseInt3 + "  month2:" + jasonPaseInt4 + " month3:" + jasonPaseInt5 + " month4:" + jasonPaseInt6 + " month5:" + jasonPaseInt7 + " month6:" + jasonPaseInt8 + " month7:" + jasonPaseInt9 + " month8:" + jasonPaseInt10 + " month9:" + jasonPaseInt11 + " month10:" + jasonPaseInt12 + "  month11:" + jasonPaseInt13);
        ArrayList<String> arrayList = new ArrayList<>();
        int i5 = jasonPaseInt13;
        int i6 = jasonPaseInt12;
        if (jasonPaseInt2 > 0) {
            i4 = jasonPaseInt11;
            int i7 = 0;
            for (int i8 = 31; i7 < i8; i8 = 31) {
                boolean z = CommonUtil.get(jasonPaseInt2, i7);
                int i9 = jasonPaseInt10;
                StringBuilder sb = new StringBuilder();
                int i10 = jasonPaseInt9;
                sb.append(" month0:");
                sb.append(jasonPaseInt2);
                sb.append("  isHave:");
                sb.append(z);
                sb.append("   i:");
                sb.append(i7);
                CommonUtil.Log(1, sb.toString());
                if (z) {
                    arrayList.add(jasonPaseInt + "_01_" + (i7 + 1));
                }
                i7++;
                jasonPaseInt10 = i9;
                jasonPaseInt9 = i10;
            }
            i2 = jasonPaseInt9;
            i3 = jasonPaseInt10;
        } else {
            i2 = jasonPaseInt9;
            i3 = jasonPaseInt10;
            i4 = jasonPaseInt11;
        }
        if (jasonPaseInt3 > 0) {
            for (int i11 = 0; i11 < 31; i11++) {
                boolean z2 = CommonUtil.get(jasonPaseInt3, i11);
                CommonUtil.Log(1, " month9:" + jasonPaseInt3 + "  isHave:" + z2 + "   i:" + i11);
                if (z2) {
                    arrayList.add(jasonPaseInt + "_02_" + (i11 + 1));
                }
            }
        }
        if (jasonPaseInt4 > 0) {
            for (int i12 = 0; i12 < 31; i12++) {
                boolean z3 = CommonUtil.get(jasonPaseInt4, i12);
                CommonUtil.Log(1, " month9:" + jasonPaseInt4 + "  isHave:" + z3 + "   i:" + i12);
                if (z3) {
                    arrayList.add(jasonPaseInt + "_03_" + (i12 + 1));
                }
            }
        }
        if (jasonPaseInt5 > 0) {
            for (int i13 = 0; i13 < 31; i13++) {
                boolean z4 = CommonUtil.get(jasonPaseInt5, i13);
                CommonUtil.Log(1, " month9:" + jasonPaseInt5 + "  isHave:" + z4 + "   i:" + i13);
                if (z4) {
                    arrayList.add(jasonPaseInt + "_04_" + (i13 + 1));
                }
            }
        }
        if (jasonPaseInt6 > 0) {
            for (int i14 = 0; i14 < 31; i14++) {
                boolean z5 = CommonUtil.get(jasonPaseInt6, i14);
                CommonUtil.Log(1, " month9:" + jasonPaseInt6 + "  isHave:" + z5 + "   i:" + i14);
                if (z5) {
                    arrayList.add(jasonPaseInt + "_05_" + (i14 + 1));
                }
            }
        }
        if (jasonPaseInt7 > 0) {
            for (int i15 = 0; i15 < 31; i15++) {
                boolean z6 = CommonUtil.get(jasonPaseInt7, i15);
                CommonUtil.Log(1, " month9:" + jasonPaseInt7 + "  isHave:" + z6 + "   i:" + i15);
                if (z6) {
                    arrayList.add(jasonPaseInt + "_06_" + (i15 + 1));
                }
            }
        }
        if (jasonPaseInt8 > 0) {
            for (int i16 = 0; i16 < 31; i16++) {
                boolean z7 = CommonUtil.get(jasonPaseInt8, i16);
                CommonUtil.Log(1, " month9:" + jasonPaseInt8 + "  isHave:" + z7 + "   i:" + i16);
                if (z7) {
                    arrayList.add(jasonPaseInt + "_07_" + (i16 + 1));
                }
            }
        }
        if (i2 > 0) {
            int i17 = 0;
            while (i17 < 31) {
                int i18 = i2;
                boolean z8 = CommonUtil.get(i18, i17);
                CommonUtil.Log(1, " month9:" + i18 + "  isHave:" + z8 + "   i:" + i17);
                if (z8) {
                    arrayList.add(jasonPaseInt + "_08_" + (i17 + 1));
                }
                i17++;
                i2 = i18;
            }
        }
        if (i3 > 0) {
            int i19 = 0;
            while (i19 < 31) {
                int i20 = i3;
                boolean z9 = CommonUtil.get(i20, i19);
                CommonUtil.Log(1, " month9:" + i20 + "  isHave:" + z9 + "   i:" + i19);
                if (z9) {
                    arrayList.add(jasonPaseInt + "_09_" + (i19 + 1));
                }
                i19++;
                i3 = i20;
            }
        }
        if (i4 > 0) {
            int i21 = 0;
            while (i21 < 31) {
                int i22 = i4;
                boolean z10 = CommonUtil.get(i22, i21);
                CommonUtil.Log(1, " month9:" + i22 + "  isHave:" + z10 + "   i:" + i21);
                if (z10) {
                    arrayList.add(jasonPaseInt + "_10_" + (i21 + 1));
                }
                i21++;
                i4 = i22;
            }
        }
        if (i6 > 0) {
            int i23 = 0;
            while (i23 < 31) {
                int i24 = i6;
                boolean z11 = CommonUtil.get(i24, i23);
                CommonUtil.Log(1, " month9:" + i24 + "  isHave:" + z11 + "   i:" + i23);
                if (z11) {
                    arrayList.add(jasonPaseInt + "_11_" + (i23 + 1));
                }
                i23++;
                i6 = i24;
            }
        }
        if (i5 > 0) {
            int i25 = 0;
            while (i25 < 31) {
                int i26 = i5;
                boolean z12 = CommonUtil.get(i26, i25);
                CommonUtil.Log(1, " month9:" + i26 + "  isHave:" + z12 + "   i:" + i25);
                if (z12) {
                    arrayList.add(jasonPaseInt + "_12_" + (i25 + 1));
                }
                i25++;
                i5 = i26;
            }
        }
        yearsModel.setDays(arrayList);
        return yearsModel;
    }

    public int getCmd() {
        return this.cmd;
    }

    public ArrayList<String> getDays() {
        return this.days;
    }

    public int getResult() {
        return this.result;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setDays(ArrayList<String> arrayList) {
        this.days = arrayList;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public String toString() {
        return "YearsModel{cmd=" + this.cmd + ", result=" + this.result + ", days=" + this.days + '}';
    }
}
