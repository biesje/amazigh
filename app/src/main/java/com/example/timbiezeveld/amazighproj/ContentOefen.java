package com.example.timbiezeveld.amazighproj;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class ContentOefen extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_oefenen, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragThird);

        tv.setText(getArguments().getString("msg"));
        return v;
    }
    public static ContentOefen newInstance(String text) {

        ContentOefen f = new ContentOefen();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }




}