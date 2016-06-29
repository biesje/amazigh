package com.example.timbiezeveld.amazighproj;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenGroente extends Activity
{
    float x1,x2;
    float y1, y2;
    int arrayNum;
    int aantalWoorden;
    private String[] woorden = {
            "kikkererwten", "linzen", "bonen",
            "tomaat","olijven","aardappel",
            "ui", "knoflook", "maïs",
            "paprika", "pompoen", "wortel",
"erwten", "tuinbonen", "spinazie"
    };

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
