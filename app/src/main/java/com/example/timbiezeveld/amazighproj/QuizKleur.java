package com.example.timbiezeveld.amazighproj;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizKleur extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> mixlist = new ArrayList<Integer>();

    private String[] vertaling = {
            "azegg-aɣ", "awraɣ", "aḥmaymi",
            "abarcan","acemlal","ahemruni",
            "aziza", "aletcini", "akarkac",
            "azbaybi"
    };

    private int[] photos = {
            R.drawable.kleuren_rood, R.drawable.kleuren_geel,
            R.drawable.kleuren_blauw, R.drawable.kleuren_zwart,
            R.drawable.kleuren_wit, R.drawable.kleuren_bruin,
            R.drawable.kleuren_groen, R.drawable.kleuren_oranje,
            R.drawable.kleuren_bont, R.drawable.kleuren_paars
    };

    private int[] geluid = {
            R.raw.kleuren_rood, R.raw.kleuren_geel,
            R.raw.kleuren_blauw, R.raw.kleuren_zwart,
            R.raw.kleuren_wit, R.raw.kleuren_bruin,
            R.raw.kleuren_groen, R.raw.kleuren_oranje,
            R.raw.kleuren_bont, R.raw.kleuren_paars
    };


    int quiznum;
    int aantalfout;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addTarr();

        quiznum = 0;
        score = 0;


        antPosition();

        loadImg();
        TextView amw = (TextView) findViewById(R.id.amazighwoord); // amazich woor afgekoort met amw


        amw.setText(vertaling[quiznum]);


    }

    public void antPosition() {
        int[] layouts = new int[]{R.layout.activity_quiz, R.layout.activity_quiz1, R.layout.activity_quiz2, R.layout.activity_quiz3, R.layout.activity_quiz4, R.layout.activity_quiz5, R.layout.activity_quiz6,};

        setContentView(layouts[new Random().nextInt(layouts.length)]);
        setScore(0, true);
        final MediaPlayer mp = MediaPlayer.create(this, geluid[quiznum]);
        mp.start();

    }

    public void addTarr() {
        list.clear();
        list.add(R.drawable.kleuren_rood);
        list.add(R.drawable.kleuren_geel);//
        list.add(R.drawable.kleuren_blauw);
        list.add(R.drawable.kleuren_blauw);
        list.add(R.drawable.kleuren_zwart);
        list.add(R.drawable.kleuren_wit);
        list.add(R.drawable.kleuren_bruin);
        list.add(R.drawable.kleuren_groen);
        list.add(R.drawable.kleuren_oranje);
        list.add(R.drawable.kleuren_bont);
        list.add(R.drawable.kleuren_paars);

        list.remove(quiznum);

    }

    public void goedAntwoord() {
        setScore(2, false);
        if (quiznum < vertaling.length - 1) {
            aantalfout = 0;

            quiznum++;
            addTarr();

            antPosition();
            loadImg();

            TextView amw = (TextView) findViewById(R.id.amazighwoord); // amazich woor afgekoort met amw


            amw.setText(vertaling[quiznum]);


        } else {
            Intent intent = new Intent(QuizKleur.this, klaar.class);
            intent.putExtra("extra_text", String.valueOf(this.score));

            startActivity(intent);


        }

    }


    public void setFout(int i, String k) {
        switch (i) {
            case 1:
                Button btn1 = (Button) findViewById(R.id.photo1); // amazich woor afgekoort met amw
                btn1.setBackgroundColor(Color.parseColor(k));

                break;
            case 2:
                Button btn2 = (Button) findViewById(R.id.photo2); // amazich woor afgekoort met amw
                btn2.setBackgroundResource(R.drawable.kruis);

                break;
            case 3:
                Button btn3 = (Button) findViewById(R.id.photo3); // amazich woor afgekoort met amw

                btn3.setBackgroundResource(R.drawable.kruis);
                break;
            case 4:
                Button btn4 = (Button) findViewById(R.id.photo4); // amazich woor afgekoort met amw
                btn4.setBackgroundResource(R.drawable.kruis);
                break;
            case 5:
                Button btn5 = (Button) findViewById(R.id.photo5); // amazich woor afgekoort met amw
                btn5.setBackgroundResource(R.drawable.kruis);
                break;
            case 6:
                Button btn6 = (Button) findViewById(R.id.photo6); // amazich woor afgekoort met amw
                btn6.setBackgroundResource(R.drawable.kruis);


        }
    }

    public void foutAntwoord(int i) {
        setFout(i, "#FF0000");
        setScore(-1, false);
    }


    public void clickAntwoord(View v) {
        switch (v.getId()) {
            case R.id.photo1:

                goedAntwoord();
                //setKleur(1,"#FFA477");
                break;
            case R.id.photo2:
                foutAntwoord(2);
                break;
            case R.id.photo3:
                foutAntwoord(3);
                break;
            case R.id.photo4:
                foutAntwoord(4);
                break;
            case R.id.photo5:
                foutAntwoord(5);
                break;
            case R.id.photo6:
                foutAntwoord(6);
                break;
        }
        aantalfout++;


    }

    public void loadImg() {
        Random rand = new Random();

        int n2;
        int n3;
        int n4;

        int n5;
        int n6;


        n2 = 1;

        n3 = 2;
        n4 = 3;

        n5 = 4;

        n6 = 5;


        Button btn1 = (Button) findViewById(R.id.photo1); // amazich woor afgekoort met amw
        btn1.setBackgroundResource(photos[quiznum]);

        Button btn2 = (Button) findViewById(R.id.photo2); // amazich woor afgekoort met amw
        btn2.setBackgroundResource(list.get(1));
        Button btn3 = (Button) findViewById(R.id.photo3); // amazich woor afgekoort met amw
        btn3.setBackgroundResource(list.get(2));
        Button btn4 = (Button) findViewById(R.id.photo4); // amazich woor afgekoort met amw
        btn4.setBackgroundResource(list.get(3));
        Button btn5 = (Button) findViewById(R.id.photo5); // amazich woor afgekoort met amw
        btn5.setBackgroundResource(list.get(4));
        Button btn6 = (Button) findViewById(R.id.photo6); // amazich woor afgekoort met amw
        btn6.setBackgroundResource(list.get(5));
    }


    public void setScore(int score, boolean aanpas) {

        this.score = this.score + score;
        TextView txt = (TextView) findViewById(R.id.score); // score view
        if (aanpas) {

            txt.setText("Score: " + String.valueOf(this.score));
        }
    }


}





