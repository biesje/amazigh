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

public class QuizDieren2 extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> mixlist = new ArrayList<Integer>();


    private int[] photos = {
            R.drawable.dieren02_duif, R.drawable.dieren02_gekko,
            R.drawable.dieren02_haas, R.drawable.dieren02_hyena,
            R.drawable.dieren02_kameleon, R.drawable.dieren02_patrijs,
            R.drawable.dieren02_schildpad, R.drawable.dieren02_schorpioen,
            R.drawable.dieren02_slang, R.drawable.dieren02_stekelvarken,
            R.drawable.dieren02_uil, R.drawable.dieren02_vos,
            R.drawable.dieren02_wildzwijn, R.drawable.dieren02_windhond,
            R.drawable.dieren02_zwaluw

    };


    private String[] vertaling = {
            "Adbir", "Aḥamchel ", "Ayaṛziz",
            "Ifis","Tata","Asekkur",
            "Icfar", "Tɣirdent", "Afiɣra",
            "Aruy", "Muka", "Icɛb",
            "Ilf", "Uccay", "Tiflillest"};


    private int[] geluid = {
            R.raw.dieren02_duif, R.raw.dieren02_gekko,
            R.raw.dieren02_haas, R.raw.dieren02_hyena,
            R.raw.dieren02_kameleon, R.raw.dieren02_patrijs,
            R.raw.dieren02_schildpad, R.raw.dieren02_schorpioen,
            R.raw.dieren02_slang, R.raw.dieren02_stekelvarken,
            R.raw.dieren02_uil, R.raw.dieren02_vos,
            R.raw.dieren02_wildzwijn, R.raw.dieren02_windhond,
            R.raw.dieren02_zwaluw
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
        list.add(R.drawable.dieren02_duif);
        list.add(R.drawable.dieren02_gekko);//
        list.add(R.drawable.dieren02_haas);
        list.add(R.drawable.dieren02_hyena);
        list.add(R.drawable.dieren02_kameleon);
        list.add(R.drawable.dieren02_patrijs);
        list.add(R.drawable.dieren02_schildpad);
        list.add(R.drawable.dieren02_schorpioen);
        list.add(R.drawable.dieren02_slang);
        list.add(R.drawable.dieren02_stekelvarken);
        list.add(R.drawable.dieren02_uil);
        list.add(R.drawable.dieren02_vos);
        list.add(R.drawable.dieren02_wildzwijn);
        list.add(R.drawable.dieren02_windhond);
        list.add(R.drawable.dieren02_zwaluw);
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
            Intent intent = new Intent(QuizDieren2.this, klaar.class);
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
        btn3.setBackgroundResource(list.get(4));
        Button btn4 = (Button) findViewById(R.id.photo4); // amazich woor afgekoort met amw
        btn4.setBackgroundResource(list.get(7));
        Button btn5 = (Button) findViewById(R.id.photo5); // amazich woor afgekoort met amw
        btn5.setBackgroundResource(list.get(5));
        Button btn6 = (Button) findViewById(R.id.photo6); // amazich woor afgekoort met amw
        btn6.setBackgroundResource(list.get(9));
    }


    public void setScore(int score, boolean aanpas) {

        this.score = this.score + score;
        TextView txt = (TextView) findViewById(R.id.score); // score view
        if (aanpas) {

            txt.setText("Score: " + String.valueOf(this.score));
        }
    }


}





