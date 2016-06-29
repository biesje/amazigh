package com.example.timbiezeveld.amazighproj;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timbiezeveld.amazighproj.R;

public class OefenInsecten extends Activity
{
    float x1,x2;
    float y1, y2;
    int arrayNum;
    int aantalWoorden;
    private String[] woorden = {
            "slak", "regenworm", "larve",
            "vlieg","bij","mug",
            "mier", "vlinder", "spin",
            "sprinkhaan", "rups", "wesp",
            "naaktslak", "bloedzuiger", "bidsprinkhaan"
    };

    private String[] vertaling = {
            "aɣlal", "adan n tmurt", "takecca",
            "iẓi","zizwit","nnamus",
            "tikedfet", "aferṭṭu", "qundɣa ",
            "burxes", "bugḍif", "yaẓẓa",
            "buccel ", "tiḍḍa", "tamraebt"

    };

    private int[] photos = {
            R.drawable.insecten_slak, R.drawable.insecten_regenworm,
            R.drawable.insecten_larve, R.drawable.insecten_vlieg,
            R.drawable.insecten_bij, R.drawable.insecten_mug,
            R.drawable.insecten_mier, R.drawable.insecten_vlinder,
            R.drawable.insecten_spin, R.drawable.insecten_sprinkhaan,
            R.drawable.insecten_rups, R.drawable.insecten_wesp,
            R.drawable.insecten_naaktslak, R.drawable.insecten_bloedzuiger,
            R.drawable.insecten_bidsprinkhaan
    };

    private int[] geluid = {
            R.raw.insecten_slak, R.raw.insecten_regenworm,
            R.raw.insecten_larve, R.raw.insecten_vlieg,
            R.raw.insecten_bij, R.raw.insecten_mug,
            R.raw.insecten_mier, R.raw.insecten_vlinder,
            R.raw.insecten_spin, R.raw.insecten_sprinkhaan,
            R.raw.insecten_rups, R.raw.insecten_wesp,
            R.raw.insecten_naaktslak, R.raw.insecten_bloedzuiger,
            R.raw.insecten_bidsprinkhaan
    };

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
