package com.ui.mileszhou.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;


public class MainActivity2 extends AppCompatActivity    {
    private TextView text_view_zs = null;
    private TextView text_view_ab = null;
    private TextView text_view_ys = null;
    private TextView text_view_tvleft = null;
    private TextView text_view_tvright = null;
    private TextView text_view_zhuce = null;
    private TextView text_view_below = null;
    private TextView text_View_youxia = null;


    private static   Handler handler =new Handler();
    private Context context;
    private FirstCpu firstCpu;

    Runnable http_thread1 = new Runnable() {
        @Override
        public void run()
        {

            Toast.makeText(getApplicationContext(),""+firstCpu.getTotalCpuTime(),Toast.LENGTH_SHORT);
//            handler.postDelayed(http_thread1, 1000);
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        handler.post(http_thread1);


        EventBus.getDefault().register(this);
        text_view_zs =(TextView)findViewById(R.id.tvzs);
        text_view_ab =(TextView)findViewById(R.id.tvab);
        text_view_ys =(TextView)findViewById(R.id.tvys);
        text_view_tvleft =(TextView)findViewById(R.id.tvleft);
        text_view_tvright =(TextView)findViewById(R.id.tvright);
        text_view_zhuce =(TextView)findViewById(R.id.zhuce);
        text_view_below =(TextView)findViewById(R.id.textViewbelow);
        text_View_youxia =(TextView)findViewById(R.id.textViewyouxia);





        text_view_zs.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity3.class);
                startActivity(intent);

            }

        });
        text_view_ys.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }



        });

        text_view_tvleft.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }



        });
        text_view_tvright.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity7.class);
                startActivity(intent);
            }



        });


        text_view_zhuce.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity6.class);
                startActivityForResult(intent, 2);
            }
        });

        text_View_youxia.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity22.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"eeee", Toast.LENGTH_SHORT);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==2){
                text_view_below.setText(data.getStringExtra("context"));

            }
            else {
                Toast.makeText(getApplicationContext(), "aaaE", Toast.LENGTH_SHORT);
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "aaaE", Toast.LENGTH_SHORT);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("zyzy", "onDestroy_MainActivity2");
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        //EventBus.getDefault().unregister(this);

    }

    public void onEventMainThread(FirstEvent event) {

        String msg = "使用onEventMainThread收到了消息cs：" + event.getMsg();
        Log.d("harvic", msg);
        text_view_ab.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
