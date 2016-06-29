package com.example.timbiezeveld.amazighproj;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizDieren1 extends AppCompatActivity {

    private String[] vertaling = {
            "Insi", "Aɣyul", "Tɣaṭṭ",
            "Ayḍi","Uccen","Mucc",
            "Aqaqriw", "Tyaziḍt", "Tafunast",
            "Aqninni", "Aɣerda", "Ayis",
            "Icerri", "Aslem", "Agḍiḍ"
    };

    int quiznum;
    int aantalfout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quiznum = 1;
        TextView amw = (TextView) findViewById(R.id.amazighwoord); // amazich woor afgekoort met amw


        amw.setText(vertaling[quiznum]);









    }


    public void goedAntwoord(){
        aantalfout=0;

        quiznum++;
        TextView amw = (TextView) findViewById(R.id.amazighwoord); // amazich woor afgekoort met amw


        amw.setText(vertaling[quiznum]);
        setKleur(1,"#ffffff" );
        setKleur(2,"#ffffff" );
        setKleur(3,"#ffffff" );
        setKleur(4,"#ffffff" );
        setKleur(5,"#ffffff" );
        setKleur(6,"#ffffff" );


    }
    public void setKleur(int i, String k){
        switch (i) {
            case 1:
                Button btn1 = (Button) findViewById(R.id.photo1); // amazich woor afgekoort met amw
                btn1.setBackgroundColor(Color.parseColor(k));

                break;
            case 2:
                Button btn2 = (Button) findViewById(R.id.photo2); // amazich woor afgekoort met amw
                btn2.setBackgroundColor(Color.parseColor(k));

                break;
            case 3:
                Button btn3 = (Button) findViewById(R.id.photo3); // amazich woor afgekoort met amw

                btn3.setBackgroundColor(Color.parseColor(k));
                break;
            case 4:
                Button btn4 = (Button) findViewById(R.id.photo4); // amazich woor afgekoort met amw
                btn4.setBackgroundColor(Color.parseColor(k));
                break;
            case 5:
                Button btn5 = (Button) findViewById(R.id.photo5); // amazich woor afgekoort met amw
                btn5.setBackgroundColor(Color.parseColor(k));
                break;
            case 6:
                Button btn6 = (Button) findViewById(R.id.photo6); // amazich woor afgekoort met amw
                btn6.setBackgroundColor(Color.parseColor(k));




        }}

    public void foutAntwoord(int i){
        setKleur(i,"#FF0000" );
    }


                public void clickAntwoord(View v){
                        switch (v.getId()) {
                            case R.id.photo1:
                               // goedAntwoord();
                                setKleur(1,"#FFA477");
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

}
