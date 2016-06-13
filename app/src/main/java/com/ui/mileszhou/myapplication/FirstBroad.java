package com.ui.mileszhou.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by mileszhou on 16/5/19.
 */
public class FirstBroad extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1;
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_POWER_CONNECTED)){
            intent1 =new Intent();
            intent1.setClass(context, MainActivity.class);
                context.startActivity(intent1);

        }
        else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)){
            intent1 =new Intent();
            intent1.setClass(context, MainActivity2.class);

                context.startActivity(intent1);


        }
    }
}
