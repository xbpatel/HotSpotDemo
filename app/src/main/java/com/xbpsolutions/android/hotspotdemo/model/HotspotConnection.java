package com.xbpsolutions.android.hotspotdemo.model;

/**
 * Created by excellent-3 on 21/06/17.
 */

public class HotspotConnection {

    private String ssid;
    private int ip;
    private String mac;

    public HotspotConnection() {
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
