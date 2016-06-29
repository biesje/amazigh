package com.example.timbiezeveld.amazighproj;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenWeer extends Activity
{
    float x1,x2;
    float y1, y2;
    int arrayNum;
    int aantalWoorden;
    private String[] woorden = {
            "lente", "zomer", "herfst",
            "winter","regen","sneeuw",
            "wind", "regenboog", "maan",
            "zon", "halvemaan", "donder",
            "ster", "mist", "wolken"

    };

    private String[] vertaling = {
            "tafsut", "anebdu", "leiglief",
            "tajarst","anẓar","adfel",
            "asemmiḍ taslit n", "unzar", "yur",
            "tfuct", "taziri", "ajjaj",
            "itri", "tayyut", "asinu"
    };

    private int[] photos = {
            R.drawable.weer_lente, R.drawable.weer_zomer,
            R.drawable.weer_herfst, R.drawable.weer_winter,
            R.drawable.weer_regen, R.drawable.weer_sneeuw,
            R.drawable.weer_wind, R.drawable.weer_regenboog,
            R.drawable.weer_maan, R.drawable.weer_zon,
            R.drawable.weer_halvemaan, R.drawable.weer_donder,
            R.drawable.weer_ster, R.drawable.weer_mist,
            R.drawable.weer_wolken
    };

    private int[] geluid = {
            R.raw.weer_lente, R.raw.weer_zomer,
            R.raw.weer_herfst, R.raw.weer_winter,
            R.raw.weer_regen, R.raw.weer_sneeuw,
            R.raw.weer_wind, R.raw.weer_regenboog,
            R.raw.weer_maan, R.raw.weer_zon,
            R.raw.weer_halvemaan, R.raw.weer_donder,
            R.raw.weer_ster, R.raw.weer_mist,
            R.raw.weer_wolken
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
