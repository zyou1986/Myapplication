package com.ui.mileszhou.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class MainActivity3 extends Activity {
    int i=0;
    long sum =0;
    private TextView text_view = null;
    private TextView text_view2 = null;
    private Button starthah = null;
    private Button end = null;
    private Button ps_event = null;
    
    Handler handler =new Handler();

    Runnable http_thread1 = new Runnable() {
        @Override
        public void run()
        {
            text_view2.setText(String.valueOf(System.currentTimeMillis() / 1000));
            handler.postDelayed(http_thread1, 1000);
        }

    };


    Runnable http_thread2 = new Runnable() {
        @Override
        public void run()
        {
            Log.i("http_thread", "哈哈哈哈");
           final  String s="这这这是response";

//            Runnable reflash=new Runnable() {
//                @Override
//                public void run() {
                    text_view.setText(s+": "+i);
                    i++;

                    for(long j=0;j<9000000;j++){
                        sum =sum+j;
//                    }
//
//                }
            };
//        handler.post(reflash);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);

        text_view = (TextView)findViewById(R.id.text_view);
        text_view2 = (TextView)findViewById(R.id.text_view2);
        handler.post(http_thread1);


        starthah = (Button)findViewById(R.id.starthah);
        starthah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                handler.post(http_thread2);
//                http_thread2.run();//  直接run是在子线程。
            }

        });

        end = (Button)findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {
            public  void onClick(View arg0) {
                handler.removeCallbacks(http_thread1);
            }
        });

        ps_event = (Button)findViewById(R.id.ps_event);
        ps_event.setOnClickListener(new View.OnClickListener() {
            public  void onClick(View arg0) {

                EventBus.getDefault().post(new FirstEvent("Event post，回到前个页面看一看吧"));
                // TODO: 16/3/14  
            }
        });



    }





}
