package com.ui.mileszhou.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    public static RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        TextView textView =(TextView)findViewById(R.id.textView1);
         mQueue = Volley.newRequestQueue(this);
        textView.setOnClickListener(new View.OnClickListener() {


            public  void onClick(View arg0) {


//                StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://www.baidu.com",
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Log.d("TAG", response);
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
//                    }
//                });
//                mQueue.add(stringRequest);

//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                        "http://test.kuaidadi.com:8098/gateway?api=lj.c.d.getStatus&apiVersion=1.0.0", null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("TAG", response.toString());
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
//                    }
//                });
//
//                mQueue.add(jsonObjectRequest);

                Toast.makeText(getApplication(),"",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
         Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
//显示toast信息
        String time1 = DateUtils.formatElapsedTime(0);
        Log.d("zyzy","onResume at:"+time1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
//显示toast信息

        Log.d("zyzy", "onPause_MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast toast=Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT);
//显示toast信息
        toast.show();
        Log.d("zyzy", "onDestroy_MainActivity");
    }
}
