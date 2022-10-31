package com.hs1121.deligetsexample.breadcastReciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.TextView

class WifiReceiver(val tv: TextView,val context: Context):BroadcastReceiver() {
    override fun onReceive(p0: Context?, intent: Intent?) {
        val wifi=intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,0)?:0

        tv.text=when(wifi){
            WifiManager.WIFI_STATE_ENABLED->"Enabled"
            WifiManager.WIFI_STATE_DISABLED->"Disabled"
            WifiManager.WIFI_STATE_ENABLING->"Enabling"
            WifiManager.WIFI_STATE_DISABLING->"Disabling"
            else->"Unknown"
        }
    }
}