package com.ui.mileszhou.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity6 extends Activity {
        private EditText editText;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout6);
        editText =(EditText)findViewById(R.id.zhuceet);

    }

    public void re(View view){
        Bundle bundle = new  Bundle();
        Intent intent = new Intent();
        bundle.putString("context", editText.getText().toString());
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();

    }







}
