package com.ui.mileszhou.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.PersistableBundle;

/**
 * Created by mileszhou on 16/5/13.
 */
public class smpleActivity extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.layout8);
        HandlerThread handlerThread =new HandlerThread("backgroup");


    }

    @Override
    protected void onResume() {
        super.onResume();

    }



}
