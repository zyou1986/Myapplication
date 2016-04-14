package com.ui.mileszhou.myapplication;

/**
 * Created by mileszhou on 16/3/15.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Jin Liang
 * @since 16/3/14
 */
public class MyAdapter_text extends BaseAdapter {
    private static final String TAG = "MyAdapter_text";
    private ArrayList<String> data = new ArrayList<String>();
    private String[] chars= new String[]{"a","b","c","d","e"};

    Context context;
    LayoutInflater inflater;
    public MyAdapter_text(Context context){
        this.context =context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 2;
//        return data.size();

    }
    @Override
    public Object getItem(int position) {

        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addData(String data) {
        this.data.add(data);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        if (convertView == null) {
            Log.d(TAG, "new view");
            view = inflater.inflate(R.layout.listview_item, null);

        } else {
            Log.d(TAG, "old view");
            view = convertView;
        }
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText(data.get(position));
        return view;
    }
}
