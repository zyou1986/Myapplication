package com.ui.mileszhou.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by mileszhou on 16/5/10.
 */

public class MainActivity8 extends Activity {
    private Button button;
    private ProgressBar progressBar;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout8);

        button = (Button)findViewById(R.id.button03);
        progressBar = (ProgressBar)findViewById(R.id.progressBar02);
        textView = (TextView)findViewById(R.id.textView01);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ProgressBarAsyncTask asyncTask = new ProgressBarAsyncTask(textView, progressBar);
                asyncTask.execute(0);


            }
        });

    }
}