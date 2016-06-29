package com.example.timbiezeveld.amazighproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CatogoryQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogory);

    }

    public void startDieren1(View v){

        Intent intent1 = new Intent(CatogoryQuiz.this,QuizDieren1.class);
        startActivity(intent1);


    }
    public void startEten(View v){

       Intent intent2 = new Intent(CatogoryQuiz.this,QuizEten.class);
        startActivity(intent2);


    }
    public void oefenFruit(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizFruit.class);
        startActivity(intent3);


    }

        public void oefenWeer(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizWeer.class);
        startActivity(intent3);


    }

        public void oefenDieren1(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizDieren1.class);
        startActivity(intent3);


    }

        public void oefenDieren2(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizDieren2.class);
        startActivity(intent3);


    }

        public void oefenEten(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizEten.class);
        startActivity(intent3);


    }

        public void oefenGroente(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizGroente.class);
        startActivity(intent3);


    }

        public void oefenInsecten(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizInsecten.class);
        startActivity(intent3);


    }


        public void oefenKleding(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizKleding.class);
        startActivity(intent3);


    }

        public void oefenKleur(View v){

        Intent intent3 = new Intent(CatogoryQuiz.this,QuizKleur.class);
        startActivity(intent3);


    }

    
    
    
    
    
}
