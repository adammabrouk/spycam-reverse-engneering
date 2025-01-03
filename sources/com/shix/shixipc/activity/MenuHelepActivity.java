package com.shix.shixipc.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.he.NetWorkUtil;
import com.shix.shixipc.view.MyTextView;
import com.shix.shixipc.view.MyWebView;

/* loaded from: classes.dex */
public class MenuHelepActivity extends BaseActivity {
    public Button back;
    public MyWebView webView1;

    public class WebViewClientDemo extends WebViewClient {
        public WebViewClientDemo() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    private void initComponent1() {
        this.webView1.removeJavascriptInterface("searchBoxJavaBredge_");
        this.webView1.setScrollBarStyle(33554432);
        WebSettings settings = this.webView1.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        if (NetWorkUtil.isNetworkAvailable(this)) {
            settings.setCacheMode(2);
        } else {
            settings.setCacheMode(1);
        }
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        MyTextView myTextView = (MyTextView) findViewById(R.id.tvTitle);
        if (getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI")) {
            String stringExtra = getIntent().getStringExtra("WEB_URL");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (stringExtra.equals("1")) {
                    myTextView.setText("用户协议");
                    this.webView1.loadUrl("https://version.xyx.wiki/privacys_terms.html");
                } else {
                    myTextView.setText("隐私政策");
                    this.webView1.loadUrl("https://version.xyx.wiki/privacys_policy.html");
                }
            }
        } else {
            this.webView1.loadUrl("https://xuanyuanxing.s3.us-west-1.amazonaws.com/privacy/privacys.html");
        }
        this.webView1.setWebViewClient(new WebViewClient() { // from class: com.shix.shixipc.activity.MenuHelepActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.menuhelpp);
        this.back = (Button) findViewById(R.id.back);
        this.webView1 = (MyWebView) findViewById(R.id.webView1);
        initComponent1();
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.MenuHelepActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuHelepActivity.this.finish();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        finish();
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        return true;
    }
}
