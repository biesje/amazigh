package com.example.timbiezeveld.amazighproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class test extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        list.add(  R.drawable.dieren01_egel);
        list.add(  R.drawable.dieren01_ezel);
        list.add(  R.drawable.dieren01_geit);
        list.add(  R.drawable.dieren01_hond);
        list.add(  R.drawable.dieren01_jakhals);
        list.add(  R.drawable.dieren01_kat);
        list.add(  R.drawable.dieren01_kikker);
        list.add(  R.drawable.dieren01_kip);
        list.add(  R.drawable.dieren01_koe);
        list.add(  R.drawable.dieren01_konijn);
        list.add(  R.drawable.dieren01_muis);
        list.add(  R.drawable.dieren01_paard);
        list.add(  R.drawable.dieren01_schaap);
        list.add(  R.drawable.dieren01_vis);
        list.add(  R.drawable.dieren01_vogel);

    }


    public void clickEffect(View v){

        RelativeLayout btn5 = (RelativeLayout) findViewById(R.id.lay);
        btn5.setBackgroundResource(list.get(2));

    }

}
