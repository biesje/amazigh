package com.example.timbiezeveld.amazighproj;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openCatogory(View v){

        Intent intent = new Intent(MainActivity.this,oefenen.class);
        intent.putExtra("manier", "oefen" );
        startActivity(intent);

    }
    public void startOefen(View v){

        Intent intent = new Intent(MainActivity.this,Catogory.class);

        startActivity(intent);

    }
    public void startQuiz(View v){

        Intent intent = new Intent(MainActivity.this,QuizDieren1.class);

        startActivity(intent);

    }

}
