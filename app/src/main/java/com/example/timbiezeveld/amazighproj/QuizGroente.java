package com.example.timbiezeveld.amazighproj;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizGroente extends AppCompatActivity {

    private static int[] photomix;
    private String[] vertaling = {
        "rḥimez", "leɛdes", "llubeyyet",
            "ttumatic","zzitun","baṭaṭa",
            "rebser", "ticcart", "dra",
            "rferfer", "taxsact", "xizzu",
"tinifin", "ibawen", "ṭebi"
    };

    private int[] photos = {
 R.drawable.groente_kikkererwten, R.drawable.groente_linzen,
            R.drawable.groente_bonen, R.drawable.groente_tomaat,
            R.drawable.groente_olijven, R.drawable.groente_aardappel,
            R.drawable.groente_ui, R.drawable.groente_knoflook,
            R.drawable.groente_mais, R.drawable.groente_paprika,
            R.drawable.groente_pompoen, R.drawable.groente_wortel,
            R.drawable.groente_doperwten, R.drawable.groente_tuinbonen,
R.drawable.groente_spinazie    };

    private int[] geluid = {
 R.raw.groente_kikkererwten, R.raw.groente_linzen,
            R.raw.groente_bonen, R.raw.groente_tomaat,
            R.raw.groente_olijven, R.raw.groente_aardappel,
            R.raw.groente_ui, R.raw.groente_knoflook,
            R.raw.groente_mais, R.raw.groente_paprika,
            R.raw.groente_pompoen, R.raw.groente_wortel,
            R.raw.groente_doperwten, R.raw.groente_tuinbonen,
R.raw.groente_spinazie    };

    int quiznum;
    int aantalfout;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        antPosition();

        quiznum = 0;
        score = 0;
        TextView amw = (TextView) findViewById(R.id.amazighwoord); // amazich woor afgekoort met amw


        amw.setText(vertaling[quiznum]);
        loadImg();

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 4) {

            int random = randomGenerator .nextInt(4);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }








    }
    public void antPosition(){
        int[] layouts = new int[] {R.layout.activity_quiz, R.layout.activity_quiz1,R.layout.activity_quiz2,R.layout.activity_quiz3,R.layout.activity_quiz4,R.layout.activity_quiz5,R.layout.activity_quiz6,};

        setContentView(layouts[new Random().nextInt(layouts.length)]);

    }


    public void goedAntwoord(){
        setScore(1);
        if(quiznum<vertaling.length-1) {
            aantalfout = 0;
            antPosition();

            quiznum++;

            TextView amw = (TextView) findViewById(R.id.amazighwoord); // amazich woor afgekoort met amw


            amw.setText(vertaling[quiznum]);


            loadImg();
        }
        else{
            Intent intent = new Intent(QuizGroente.this,klaar.class);
            intent.putExtra("extra_text", String.valueOf(this.score));

            startActivity(intent);


        }

    }


    public void setFout(int i, String k){
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
                shuffle();
                btn6.setBackgroundResource(R.drawable.kruis);




        }}

    public void foutAntwoord(int i){
        setFout(i,"#FF0000" );
        setScore(-1);
    }


                public void clickAntwoord(View v){
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
        public void loadImg(){
            Random rand = new Random();

            int n2;
            int n3;
            int n4;

            int n5;
            int n6;



                 n2 = 1;

                 n3 =  2;
                 n4 = 3;

                 n5 = 4;

                 n6 = 5;


RandomizeArray(photos);
            Button btn1 = (Button) findViewById(R.id.photo1); // amazich woor afgekoort met amw
            btn1.setBackgroundResource(photos[quiznum]);

            Button btn2 = (Button) findViewById(R.id.photo2); // amazich woor afgekoort met amw
            btn2.setBackgroundResource(photomix[2]);
            Button btn3 = (Button) findViewById(R.id.photo3); // amazich woor afgekoort met amw
            btn3.setBackgroundResource(photomix[3]);
            Button btn4 = (Button) findViewById(R.id.photo4); // amazich woor afgekoort met amw
            btn4.setBackgroundResource(photomix[5]);
            Button btn5 = (Button) findViewById(R.id.photo5); // amazich woor afgekoort met amw
            btn5.setBackgroundResource(photomix[6]);
            Button btn6 = (Button) findViewById(R.id.photo6); // amazich woor afgekoort met amw
            btn6.setBackgroundResource(photos[7]);
        }





    public static void RandomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

            if(array[1]==1){

            }

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];

            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        photomix= array;
    }
    public void setScore(int score){

        this.score=this.score+score;
        TextView txt = (TextView) findViewById(R.id.score); // score view

        txt.setText("Score: "+String.valueOf(this.score));
    }

    public void shuffle(){
        List<Integer> objects = new ArrayList<Integer>();
        objects.add(0);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);

        // Shuffle the collection
        Collections.shuffle(objects);

        List<Button> buttons = new ArrayList<Button>();
        buttons.add((Button)findViewById(R.id.photo1));
        buttons.add((Button)findViewById(R.id.photo2));
        buttons.add((Button)findViewById(R.id.photo4));
        buttons.add((Button)findViewById(R.id.photo5));
        buttons.add((Button)findViewById(R.id.photo6));

        for (int i = 0; i < objects.size(); i++) {
            buttons.get(i).setText(objects.get(i).toString());
        }



    }



}





