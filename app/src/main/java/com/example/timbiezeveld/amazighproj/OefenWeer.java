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
            "Egel", "Ezel", "Geit",
            "Hond","Jakhals","Kat",
            "Kikker", "Kip", "Koe",
            "Konijn", "Muis", "Paard",
            "Schaap", "Vis", "Vogel"
    };

    private String[] vertaling = {
            "Insi", "Aɣyul", "Tɣaṭṭ",
            "Ayḍi","Uccen","Mucc",
            "Aqaqriw", "Tyaziḍt", "Tafunast",
            "Aqninni", "Aɣerda", "Ayis",
            "Icerri", "Aslem", "Agḍiḍ"
    };

    private int[] photos = {
          R.drawable.dieren01_egel,R.drawable.dieren01_ezel, R.drawable.dieren01_geit,R.drawable.dieren01_hond, R.drawable.dieren01_jakhals, R.drawable.dieren01_kat,
            R.drawable.dieren01_kikker, R.drawable.dieren01_kip, R.drawable.dieren01_koe, R.drawable.dieren01_konijn, R.drawable.dieren01_muis, R.drawable.dieren01_paard, R.drawable.dieren01_schaap, R.drawable.dieren01_vis, R.drawable.dieren01_vogel
    };

    private int[] geluid = {
            R.raw.dieren01_egel,R.raw.dieren01_ezel, R.raw.dieren01_geit,R.raw.dieren01_hond, R.raw.dieren01_jakhals, R.raw.dieren01_kat,
            R.raw.dieren01_kikker, R.raw.dieren01_kip, R.raw.dieren01_koe, R.raw.dieren01_konijn, R.raw.dieren01_muis, R.raw.dieren01_paard, R.raw.dieren01_schaap, R.raw.dieren01_vis, R.raw.dieren01_vogel
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
