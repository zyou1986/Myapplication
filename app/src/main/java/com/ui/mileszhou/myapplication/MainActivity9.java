package com.ui.mileszhou.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by mileszhou on 16/5/17.
 */
public class MainActivity9 extends Activity implements OnClickListener{
        private Button startservice;
        private Button stopservice;
        private Button bindservice;
        private Button unbindservice;
        private Button listener;
        private FirstService.Mybinder mybinder;
        private boolean isBind = false ;
        private boolean isService = false ;
        private FirstBroad firstBroad;

        BroadcastReceiver broadcastReceiver;


    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mybinder = (FirstService.Mybinder) service;
            mybinder.startdowning();
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout9);
        startservice = (Button) findViewById(R.id.bt_9_1);
        stopservice = (Button) findViewById(R.id.bt_9_2);
        bindservice = (Button) findViewById(R.id.bt_9_3);
        unbindservice = (Button) findViewById(R.id.bt_9_4);
        listener = (Button) findViewById(R.id.bt_9_5);

        startservice.setOnClickListener(this);
        stopservice.setOnClickListener(this);
        bindservice.setOnClickListener(this);
        unbindservice.setOnClickListener(this);
        Log.d("zyzyz",""+Thread.currentThread().getId());

    }

    @Override
    protected void onResume() {

        super.onResume();
        listener.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                IntentFilter intentFilter = new IntentFilter();
                if (firstBroad == null) {
                    intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
                    intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
                    firstBroad = new FirstBroad();
                    registerReceiver(firstBroad, intentFilter);
                }
            }
        });

    }

    private void read(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        int backgroundcolor =preferences.getInt(Constants.UI_BACKGROUND_COLOR,def);


    }


    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(firstBroad);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_9_1:
                Intent startIntent = new Intent(this, FirstService.class);
                startService(startIntent);
                break;
            case R.id.bt_9_2:
                Intent stopIntent = new Intent(this, FirstService.class);
                if(isService!=stopService(stopIntent)){
                stopService(stopIntent);}
                isService=false;
                break;
            case R.id.bt_9_3:
                Intent bindIntent = new Intent(this, FirstService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.bt_9_4:
                Intent unbindIntent = new Intent(this, FirstService.class);
                if(isBind!=bindService(unbindIntent, connection, BIND_AUTO_CREATE)){
                    unbindService(connection);
                }
                isBind=false;
                break;
            default:
                break;
        }
    }
}
