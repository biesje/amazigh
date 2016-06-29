package com.example.timbiezeveld.amazighproj;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenKleur extends Activity
{
    float x1,x2;
    float y1, y2;
    int arrayNum;
    int aantalWoorden;
    private String[] woorden = {
            "rood", "geel", "blauw",
            "zwart","wit","bruin",
            "groen", "oranje", "bont",
            "paars"
    };

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
