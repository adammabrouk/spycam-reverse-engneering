package com.shix.shixipc.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import c.e.b.a;
import c.e.b.e.c;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.impl.ConfirmPopupView;
import com.lxj.xpopup.impl.LoadingPopupView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.SearchListAdapter;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SearchActivity extends BaseActivity implements NUIMainActivity.AddCameraInterface1, NetworkUtils.OnNetworkStatusChangedListener {
    public static final String Tag = "LocalNetFragmentActivity";
    public SwipeRefreshLayout localnetSwipe;
    public BasePopupView popupView;
    public TextView tvshow;
    public SearchListAdapter listAdapter = null;
    public ListView cameraListView = null;
    public boolean isStart = false;
    public List<Map<String, Object>> listItems11 = new ArrayList();
    public int sType = 0;
    public Handler mHandler = new Handler(new Handler.Callback() { // from class: com.shix.shixipc.activity.SearchActivity.8
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                if (SearchActivity.this.listItems11.size() == 0) {
                    SearchActivity.this.tvshow.setVisibility(0);
                    SearchActivity.this.tvshow.setText(R.string.sertch_show3);
                } else {
                    SearchActivity.this.tvshow.setVisibility(8);
                }
                SearchActivity.this.isStart = false;
                if (SearchActivity.this.localnetSwipe.d()) {
                    SearchActivity.this.localnetSwipe.setRefreshing(false);
                }
            } else if (i2 == 2) {
                if (SearchActivity.this.localnetSwipe.d()) {
                    SearchActivity.this.localnetSwipe.setRefreshing(false);
                }
                Map<String, Object> map = (Map) message.obj;
                if (map != null) {
                    SearchActivity.this.listAdapter.addItem(map);
                }
            } else if (i2 == 3 && SearchActivity.this.localnetSwipe.d()) {
                SearchActivity.this.localnetSwipe.setRefreshing(false);
            }
            return false;
        }
    });

    public class SearchThread implements Runnable {
        public SearchThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyLogUtils.d("tag", "startSearch");
            String localIpAddress = CommonUtil.getLocalIpAddress(SearchActivity.this);
            MyLogUtils.d("tag", "startSearch : " + localIpAddress);
            NativeCallerTools.SDKAPIStartSearchLanDev(localIpAddress);
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            NativeCallerTools.SDKAPIStopSearchLanDev();
        }
    }

    private void AddCamera(String str, String str2, String str3) {
        if (checkHasCameraID(str2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ContentCommon.STR_CAMERA_MAC, str);
        hashMap.put(ContentCommon.STR_CAMERA_ID, str2);
        hashMap.put(ContentCommon.STR_CAMERA_IP, str3);
        Message message = new Message();
        message.obj = hashMap;
        message.what = 2;
        this.mHandler.sendMessage(message);
    }

    private boolean CheckCameraInfo(String str) {
        int size = this.listItems11.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals((String) this.listItems11.get(i2).get(ContentCommon.STR_CAMERA_ID))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkHasCameraID(String str) {
        int size = this.listItems11.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equalsIgnoreCase((String) this.listItems11.get(i2).get(ContentCommon.STR_CAMERA_ID))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSearch() {
        this.isStart = true;
        new Thread(new SearchThread()).start();
        if (this.localnetSwipe.d()) {
            this.localnetSwipe.setRefreshing(false);
        }
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.AddCameraInterface1
    public void callBackSearchResultData(int i2, String str, String str2, String str3, String str4, int i3) {
        LogUtils.e(1, "strName:" + str2 + "  strDeviceID:" + str3 + "  strIpAddr:" + str4 + "  port:" + i3 + "  cameraType:" + i2 + "  strMac:" + str);
        if (str3 == null || str3.length() <= 3) {
            return;
        }
        AddCamera(str, str3.trim().replace("-", "").toUpperCase(), str4);
    }

    @Override // com.shix.shixipc.utilcode.NetworkUtils.OnNetworkStatusChangedListener
    public void onConnected(NetworkUtils.NetworkType networkType) {
        BasePopupView basePopupView = this.popupView;
        if (basePopupView != null) {
            basePopupView.h();
        }
        String localIpAddress = CommonUtil.getLocalIpAddress(this);
        MyLogUtils.d("tag", "startSearch : " + localIpAddress);
        a.C0120a c0120a = new a.C0120a(this);
        c0120a.a((Boolean) false);
        LoadingPopupView a2 = c0120a.a("");
        a2.w();
        final LoadingPopupView loadingPopupView = a2;
        NativeCallerTools.SDKAPIStartSearchLanDev(localIpAddress);
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.shix.shixipc.activity.SearchActivity.7
            @Override // java.lang.Runnable
            public void run() {
                NativeCallerTools.SDKAPIStopSearchLanDev();
                loadingPopupView.h();
            }
        }, 4000L);
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sss);
        BarUtils.setStatusBarColor(this, 0).setBackgroundResource(R.color.color_white);
        BarUtils.setStatusBarLightMode((Activity) this, false);
        this.sType = getIntent().getIntExtra("sType", 0);
        this.cameraListView = (ListView) findViewById(R.id.listviewCamera);
        NUIMainActivity.setAddCameraInterface1(this);
        SearchListAdapter searchListAdapter = new SearchListAdapter(this);
        this.listAdapter = searchListAdapter;
        this.cameraListView.setAdapter((ListAdapter) searchListAdapter);
        TextView textView = (TextView) findViewById(R.id.tvshow);
        this.tvshow = textView;
        textView.setVisibility(8);
        this.isStart = false;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.localnet_swipe);
        this.localnetSwipe = swipeRefreshLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.color_main);
        this.localnetSwipe.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.shix.shixipc.activity.SearchActivity.1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public void onRefresh() {
                SearchActivity.this.startSearch();
            }
        });
        ((ImageView) findViewById(R.id.fra_local_add)).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SearchActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchActivity.this.startActivity(new Intent(SearchActivity.this, (Class<?>) AddCameraActivity.class));
            }
        });
        ((Button) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.SearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SearchActivity.this, 10L);
                }
                SearchActivity.this.finish();
            }
        });
        this.cameraListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.shix.shixipc.activity.SearchActivity.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SearchActivity.this, 10L);
                }
                Map<String, Object> itemContent = SearchActivity.this.listAdapter.getItemContent(i2);
                if (itemContent == null) {
                    return;
                }
                String str = (String) itemContent.get(ContentCommon.STR_CAMERA_ID);
                if (SearchActivity.this.listAdapter.checkDID(str)) {
                    SearchActivity.this.showToast(R.string.sertch_show2);
                    return;
                }
                if (SearchActivity.this.sType != 110) {
                    Intent intent = new Intent();
                    intent.putExtra("mUID", str);
                    SearchActivity.this.setResult(-1, intent);
                    SearchActivity.this.finish();
                    return;
                }
                Intent intent2 = new Intent(SearchActivity.this, (Class<?>) AddCameraActivity.class);
                intent2.putExtra(ContentCommon.CAMERA_OPTION, 1);
                intent2.putExtra(ContentCommon.STR_CAMERA_NAME, "Camera");
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, str);
                intent2.putExtra(ContentCommon.STR_CAMERA_USER, ContentCommon.DEFAULT_USER_NAME);
                intent2.putExtra(ContentCommon.STR_CAMERA_PWD, "6666");
                intent2.putExtra("pushTypeInt", 110);
                SearchActivity.this.startActivity(intent2);
                SearchActivity.this.finish();
            }
        });
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            MyLogUtils.d(Tag, "wifi == null");
            return;
        }
        if (wifiManager.getWifiState() != 3) {
            NetworkUtils.registerNetworkStatusChangedListener(this);
            MyLogUtils.d(Tag, "wifi 开启状态 = " + wifiManager.isWifiEnabled());
            a.C0120a c0120a = new a.C0120a(this);
            c0120a.a((Boolean) true);
            c0120a.b(false);
            c0120a.a(true);
            ConfirmPopupView a2 = c0120a.a(getResources().getString(R.string.delete_device_notice), getResources().getString(R.string.search_ip_tip), getResources().getString(R.string.my_setup_cancel), getResources().getString(R.string.my_setup_sure), new c() { // from class: com.shix.shixipc.activity.SearchActivity.6
                @Override // c.e.b.e.c
                public void onConfirm() {
                    NetworkUtils.openWirelessSettings();
                }
            }, null, false);
            this.popupView = a2;
            a2.w();
            return;
        }
        MyLogUtils.d(Tag, "wifi 开启状态 = " + wifiManager.isWifiEnabled());
        String localIpAddress = CommonUtil.getLocalIpAddress(this);
        MyLogUtils.d("tag", "startSearch : " + localIpAddress);
        a.C0120a c0120a2 = new a.C0120a(this);
        c0120a2.a((Boolean) false);
        LoadingPopupView a3 = c0120a2.a("");
        a3.w();
        final LoadingPopupView loadingPopupView = a3;
        NativeCallerTools.SDKAPIStartSearchLanDev(localIpAddress);
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.shix.shixipc.activity.SearchActivity.5
            @Override // java.lang.Runnable
            public void run() {
                NativeCallerTools.SDKAPIStopSearchLanDev();
                loadingPopupView.h();
            }
        }, 4000L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NUIMainActivity.setAddCameraInterface1(null);
        NetworkUtils.unregisterNetworkStatusChangedListener(this);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.shix.shixipc.utilcode.NetworkUtils.OnNetworkStatusChangedListener
    public void onDisconnected() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
