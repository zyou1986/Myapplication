package com.ui.mileszhou.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by mileszhou on 16/5/16.
 */
public class FirstService extends Service {
    public static final String TAG = "MyService";
    private Handler mMessengerHandler;
    private Messenger mMessenger;
//    public Mybinder mybinder;

    @Override
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread =new HandlerThread("MessengerService");
        handlerThread.start();

//        mMessengerHandler = new Handler(handlerThread.getLooper(),new );
        mMessenger =new Messenger(mMessengerHandler);

        Log.d(TAG, "onCreate() executed");
        Log.d("zyzyz",""+Thread.currentThread().getId());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed");
        int key =super.onStartCommand(intent, flags, startId);
        Log.d(TAG,String.valueOf(key));
        return key;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    class Mybinder extends Binder{
        public void startdowning(){
           Log.d(TAG,"startdowning......");
        }
    }

    private void notifyremoyeServiceDeath(IBinder iBinder){

        try {

            iBinder.linkToDeath(new MylinkToDeathCallback(), 0);
        }
        catch (RemoteException e){
            Log.e("","");
        }
    }
     class MylinkToDeathCallback implements IBinder.DeathRecipient{
         @Override

         public void binderDied() {

             // // TODO: 16/5/19
         }
     }
}
