package com.example.timbiezeveld.amazighproj;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenKleding extends Activity
{
    float x1,x2;
    float y1, y2;
    int arrayNum;
    int aantalWoorden;
    private String[] woorden = {
            "broek", "trui", "onderhemd",
            "jas","schoenen","laarzen",
            "muts", "jurk", "rok",
            "slippers", "handschoenen", "sokken",
            "overhemd", "sjaal", "riem
    };

    private String[] vertaling = {
            "ssarwal", "amaryul", "camisita",
            "aqabud","tisila","ihakusen",
            "tcaccict", "tablust", "farda",
            "tcinklat", "iwantisan", "tqacir",
            "taqmijjat", "ahewwak", "abyas"
    };

    private int[] photos = {
            R.drawable.kleding_broek, R.drawable.kleding_trui,
            R.drawable.kleding_onderhemd, R.drawable.kleding_jas,
            R.drawable.kleding_schoenen, R.drawable.kleding_laarzen,
            R.drawable.kleding_muts, R.drawable.kleding_jurk,
            R.drawable.kleding_rok, R.drawable.kleding_slippers,
            R.drawable.kleding_handschoenen, R.drawable.kleding_sokken,
            R.drawable.kleding_overhemd, R.drawable.kleding_sjaal,
            R.drawable.kleding_riem
    };

    private int[] geluid = {
            R.raw.kleding_broek, R.raw.kleding_trui,
            R.raw.kleding_onderhemd, R.raw.kleding_jas,
            R.raw.kleding_schoenen, R.raw.kleding_laarzen,
            R.raw.kleding_muts, R.raw.kleding_jurk,
            R.raw.kleding_rok, R.raw.kleding_slippers,
            R.raw.kleding_handschoenen, R.raw.kleding_sokken,
            R.raw.kleding_overhemd, R.raw.kleding_sjaal,
            R.raw.kleding_riem
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
