package com.ui.mileszhou.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

/**
 * Created by mileszhou on 16/3/15.
 */
public class MainActivity4 extends Activity {

      @Override

      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);
        GridView gridView = (GridView) findViewById(R.id.grid);

        MyAdapter_text myAdapter = new MyAdapter_text(this);
          myAdapter.addData("ddd");
          myAdapter.addData("EEE");


          gridView.setAdapter(myAdapter);



//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast toast = Toast.makeText(MainActivity4.this, "item clicked :" + position + " " + id, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
    }
}
