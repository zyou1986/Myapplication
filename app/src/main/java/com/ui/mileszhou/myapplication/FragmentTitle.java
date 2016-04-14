package com.ui.mileszhou.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class FragmentTitle extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view =inflater.inflate(R.layout.fragmenttitle, container, false);
        ImageView imageView=(ImageView)view.findViewById(R.id.id_title_left_btn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"wo hahahah",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
