package com.ui.mileszhou.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by mileszhou on 16/3/15.
 */
public class MainActivity5 extends Activity {

    private Gallery gallery;
    private ImageView imgview;
    private int[] imgs = {R.drawable.u1, R.drawable.u2, R.drawable.u3};

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout5);
        imgview = (ImageView) findViewById(R.id.imageView1);
        gallery = (Gallery) findViewById(R.id.gallery1);
        MyAdapter_imgs adapter = new MyAdapter_imgs(this);
        gallery.setAdapter(adapter);

        imgview.setImageResource(imgs[0]);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imgview.setImageResource(imgs[position]);
            }
        });

    }


}
