package com.example.timbiezeveld.amazighproj;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenEten extends Activity
{
    float x1,x2;
    float y1, y2;
    int arrayNum;
    int aantalWoorden;
    private String[] woorden = {
                  "Eieren", "olie", "koekjes",
            "thee","koffie","melk",
            "yoghurt", "water", "brood",
            "honing", "suiker", "zout",
            "vlees", "vissen", "boter"

    };

    private String[] vertaling = {
                      "timejjalin", "zzict", "ɣayiṭa",
            "atay","rqehwa","aɣi",
            "accil", "aman", "aɣrum",
            "tamment", "sseqqur", "tamellaḥt",
            "aysum", "iselman", "ddhen"

    };

    private int[] photos = {
 R.drawableable.eten_eieren, R.drawableable.eten_olie,
            R.drawableable.eten_koekjes, R.drawableable.eten_thee,
            R.drawableable.eten_koffie, R.drawableable.eten_melk,
            R.drawableable.eten_yoghurt, R.drawableable.eten_water,
            R.drawableable.eten_brood, R.drawableable.eten_honing,
            R.drawableable.eten_suiker, R.drawableable.eten_zout,
            R.drawableable.eten_vlees, R.drawableable.eten_vissen,
            R.drawableable.eten_boter    };

    private int[] geluid = {
 R.raw.eten_eieren, R.raw.eten_olie,
            R.raw.eten_koekjes, R.raw.eten_thee,
            R.raw.eten_koffie, R.raw.eten_melk,
            R.raw.eten_yoghurt, R.raw.eten_water,
            R.raw.eten_brood, R.raw.eten_honing,
            R.raw.eten_suiker, R.raw.eten_zout,
            R.raw.eten_vlees, R.raw.eten_vissen,
            R.raw.eten_boter    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oefen);
        arrayNum = 0;
        setItems();

        aantalWoorden = woorden.length-1;

    }

    // onTouchEvent () method gets called when User performs any touch event on screen
    // Method to handle touch event like left to right swap and right to left swap
    public boolean onTouchEvent(MotionEvent touchevent) {
            switch (touchevent.getAction()) {
                // when user first touches the screen we get x and y coordinate
                case MotionEvent.ACTION_DOWN: {
                    x1 = touchevent.getX();
                    y1 = touchevent.getY();
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    x2 = touchevent.getX();
                    y2 = touchevent.getY();

                    //if left to right sweep event on screen
                    if (x1 < x2) {
                        arrayNum--;
                    }

                    // if right to left sweep event on screen
                         if (arrayNum < aantalWoorden) {

                             if (x1 > x2) {
                                 arrayNum++;
                             }
                             //Set layout
                         }
                    setItems();


                    break;

            }
        }
            return false;

    }

    public  void setItems(){

        TextView nlw = (TextView) findViewById(R.id.nederlands); //nederlands woord afgekort met nlw
        TextView amw = (TextView) findViewById(R.id.vertaling); // amazich woor afgekoort met amw
        ImageView img = (ImageView) findViewById(R.id.imageView);
        final MediaPlayer mp = MediaPlayer.create(this, geluid[arrayNum]);

        nlw.setText(woorden[arrayNum] );
        amw.setText(vertaling[arrayNum] );

        img.setImageResource(photos[arrayNum]);
        mp.start();


    }


}
