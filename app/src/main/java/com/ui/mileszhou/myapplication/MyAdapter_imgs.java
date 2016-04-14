package com.ui.mileszhou.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by mileszhou on 16/3/17.
 */
public class MyAdapter_imgs extends BaseAdapter {

    private static final String TAG = "MyAdapter_imgs";
    private  int[] Images={R.drawable.u1, R.drawable.u2, R.drawable.u3};
    public  Context context;
    public MyAdapter_imgs(Context context){
        this.context=context;
    }

    @Override
    public int getCount(){
        return Images.length;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView view;

        if(convertView==null){
            ImageView imageView = new ImageView(context);
            view =imageView;
        }
        else {
            view= (ImageView)convertView;
        }

        view.setImageResource(Images[position]);
        return  view;
    }

}
