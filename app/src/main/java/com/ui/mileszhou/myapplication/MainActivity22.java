package com.ui.mileszhou.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


public class MainActivity22 extends AppCompatActivity    {
    private TextView text_view_zs = null;
    private TextView text_view_ab = null;
    private TextView text_view_ys = null;
    private TextView text_view_tvleft = null;
    private TextView text_view_tvright = null;
    private TextView text_view_zhuce = null;
    private TextView text_view_below = null;
    private TextView text_View_youxia = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        text_view_zs =(TextView)findViewById(R.id.tvzs);
        text_view_zs.setText("1");
        text_view_ab =(TextView)findViewById(R.id.tvab);
        text_view_ab.setText("2");
        text_view_ys =(TextView)findViewById(R.id.tvys);
        text_view_ys.setText("3");
        text_view_tvleft =(TextView)findViewById(R.id.tvleft);
        text_view_tvleft.setText("4");
        text_view_tvright =(TextView)findViewById(R.id.tvright);
        text_view_tvright.setText("5");
        text_view_zhuce =(TextView)findViewById(R.id.zhuce);
        text_view_zhuce.setText("6");
        text_view_below =(TextView)findViewById(R.id.textViewbelow);
        text_view_below.setText("7");
        text_View_youxia =(TextView)findViewById(R.id.textViewyouxia);
        text_View_youxia.setText("9");



        text_view_zs.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainActivity22.this, MainActivity9.class);
                startActivity(intent);
            }
        });



    }





}
