package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);
        Intent intent = getIntent();
        String dep = intent.getStringExtra("Depart");
        String des = intent.getStringExtra("Destination");
        setTitle(dep+ ">>"+ des);


        ListView listTrip = findViewById(R.id.list_view);
        ArrayList<TripModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-kk:mm");

        try {
            results.add(new TripModel("Eric","Cartman",sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripModel("Clark","Kent", sdf.parse("21/02/2017-16:30"), 19));
            results.add(new TripModel("David","Douillet", sdf.parse("21/02/2017-18:30"), 19));


        }
        catch (ParseException e){
    }
        TripAdapter adapter = new TripAdapter(this, results);
        listTrip.setAdapter(adapter);





}}
