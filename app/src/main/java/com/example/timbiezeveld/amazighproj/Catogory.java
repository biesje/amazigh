package com.example.timbiezeveld.amazighproj;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Catogory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogory);

    }

    public void startDieren1(View v){

        Intent intent1 = new Intent(Catogory.this,OefenDieren1.class);
        startActivity(intent1);


    }
    public void startEten(View v){

       Intent intent2 = new Intent(Catogory.this,OefenEten.class);
        startActivity(intent2);


    }
    public void oefenFruit(View v){

        Intent intent3 = new Intent(Catogory.this,OefenFruit.class);
        startActivity(intent3);


    }

}
