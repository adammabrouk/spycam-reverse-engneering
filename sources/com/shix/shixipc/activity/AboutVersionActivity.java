package com.shix.shixipc.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.utils.AppUtils;
import com.shix.shixipc.utils.MyLocationUtil;
import com.shix.shixipc.utils.SharedPreferencesUtils;

/* loaded from: classes.dex */
public class AboutVersionActivity extends BaseActivity {
    public Button back;
    public MyLocationUtil mMyLocationUtil;
    public TextView newVersion;
    public TextView oldVersion;
    public TextView updataTips1;
    public ImageView updataTips2;
    public LinearLayout updataVersion;
    public TextView verTv;
    public double versionNameOld = 0.0d;
    public double versionNameNew = 0.0d;
    public boolean isNeedUpdata = false;

    private String getVersionName() throws Exception {
        return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
    }

    private void initView() {
        this.verTv = (TextView) findViewById(R.id.ver_tv);
        this.back = (Button) findViewById(R.id.back);
        this.oldVersion = (TextView) findViewById(R.id.old_version);
        this.newVersion = (TextView) findViewById(R.id.new_version);
        this.updataVersion = (LinearLayout) findViewById(R.id.updata_version);
        this.updataTips1 = (TextView) findViewById(R.id.updata_tips1);
        this.updataTips2 = (ImageView) findViewById(R.id.updata_tips2);
        this.verTv.setText(getString(R.string.check_updata_5));
        try {
            this.versionNameOld = Double.parseDouble(getVersionName().replace(".", ""));
            this.versionNameNew = Double.parseDouble(SharedPreferencesUtils.getInstance().getString("NewVersion").replace(".", ""));
            this.newVersion.setText("V  " + SharedPreferencesUtils.getInstance().getString("NewVersion"));
            this.oldVersion.setText("V  " + getVersionName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.versionNameNew > this.versionNameOld) {
            this.isNeedUpdata = true;
            this.updataTips1.setVisibility(0);
            this.updataTips2.setVisibility(0);
        } else {
            this.isNeedUpdata = false;
            this.updataTips1.setVisibility(8);
            this.updataTips2.setVisibility(8);
        }
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.AboutVersionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AboutVersionActivity.this.finish();
                AboutVersionActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        this.updataVersion.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.AboutVersionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AboutVersionActivity.this.isNeedUpdata) {
                    AboutVersionActivity aboutVersionActivity = AboutVersionActivity.this;
                    aboutVersionActivity.launchAppDetail("com.shix.lookcam", AppUtils.getMarketPkgGoogle(aboutVersionActivity));
                }
            }
        });
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_about_version);
        initView();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
