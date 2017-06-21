package com.xbpsolutions.android.hotspotdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutResults;
    WifiManager mWifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutResults = (LinearLayout) findViewById(R.id.layoutResults);
        mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        registerReceiver(mWifiScanReceiver,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

    }

    public void doScanWifi(View view) {
        mWifiManager.startScan();
    }

    private final BroadcastReceiver mWifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {

            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                List<ScanResult> mScanResults = mWifiManager.getScanResults();
                // add your logic here
                processDisplayWifies(mScanResults);
            }
        }
    };

    private void processDisplayWifies(List<ScanResult> mScanResults) {

        layoutResults.removeAllViews();


        for (ScanResult mScanResult : mScanResults) {
            Log.e("WIFi : ", mScanResult.SSID + " " + mScanResult.capabilities);

            TextView textView = new TextView(this);
            textView.setPadding(16, 16, 16, 16);
            textView.setText(mScanResult.SSID);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,22);
            layoutResults.addView(textView);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mWifiScanReceiver);
    }
}
