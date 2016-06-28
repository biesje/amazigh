package com.example.timbiezeveld.amazighproj;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timbiezeveld.amazighproj.R;

public class OefenDieren1 extends Activity
{
    float x1,x2;
    float y1, y2;
    int arrayNum;
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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oefen_dieren1);
        arrayNum = 0;
    }

    // onTouchEvent () method gets called when User performs any touch event on screen
    // Method to handle touch event like left to right swap and right to left swap
    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction())
        {
            // when user first touches the screen we get x and y coordinate
            case MotionEvent.ACTION_DOWN:
            {
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                x2 = touchevent.getX();
                y2 = touchevent.getY();

                //if left to right sweep event on screen
                if (x1 < x2)
                {
                    arrayNum--;
                }

                // if right to left sweep event on screen
                if (x1 > x2)
                {
                    arrayNum++;
                }
                //Set layout
                 TextView nlw = (TextView) findViewById(R.id.nederlands); //nederlands woord afgekort met nlw
                TextView amw = (TextView) findViewById(R.id.vertaling); // amazich woor afgekoort met amw

                nlw.setText(woorden[arrayNum] );
                amw.setText(vertaling[arrayNum] );



                break;
            }
        }
        return false;
    }


}
