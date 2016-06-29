package com.example.timbiezeveld.amazighproj;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenDieren2 extends Activity
{
    float x1,x2;
    float y1, y2;
    int arrayNum;
    int aantalWoorden;
    private String[] woorden = {
            "Duif", "Gekko", "Haas",
            "Hyena","Kameleon","Patrijs",
            "Schildpad", "Schorpioen", "Slang",
            "Stekelvarken", "Uil", "Vos",
            "Wilfzwijn", "Windhond", "Zwaluw"

    };

    private String[] vertaling = {
            "Adbir", "Aḥamchel ", "Ayaṛziz",
            "Ifis","Tata","Asekkur",
            "Icfar", "Tɣirdent", "Afiɣra",
            "Aruy", "Muka", "Icɛb",
            "Ilf", "Uccay", "Tiflillest"

    };

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
