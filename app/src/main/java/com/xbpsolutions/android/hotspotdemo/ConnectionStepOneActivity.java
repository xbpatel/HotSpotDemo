package com.xbpsolutions.android.hotspotdemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

public class ConnectionStepOneActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_step_one);

        processCheckSSID();
    }

    private void processCheckSSID() {


        WifiInfo connectionInfo = getCurrentSsid(this);
        if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID())) {
            Toast.makeText(this,connectionInfo.getSSID(), Toast.LENGTH_SHORT).show();
        }
    }

    public static WifiInfo getCurrentSsid(Context context) {

        WifiInfo connectionInfo = null;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo == null) {
            return null;
        }

        if (networkInfo.isConnected()) {

            final WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            connectionInfo = wifiManager.getConnectionInfo();


        }

        return connectionInfo;

    }
//    public static String getCurrentSsid(Context context) {
//
//        String ssid = null;
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
//
//        if (networkInfo == null) {
//            return null;
//        }
//
//        if (networkInfo.isConnected()) {
//
//            final WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//            final WifiInfo connectionInfo = wifiManager.getConnectionInfo();
//
//            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID())) {
//                ssid = connectionInfo.getSSID();
//            }
//        }
//
//        return ssid;
//    }

}
