package com.example.timbiezeveld.amazighproj;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Catogory extends ListActivity {

    String[] itemname ={
            "Dieren 1",
            "Fruit",
            "Insecten",
            "Groente",
            "Dieren 2",
            "Eten",
            "Kleding",
            "Weer",
            "Kleuren"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogory);

        this.setListAdapter(new ArrayAdapter<String>(
                this, R.layout.mylist,
                R.id.Itemname,itemname));
    }



}

