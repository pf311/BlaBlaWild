package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchAnItinirery = findViewById(R.id.searchI);
        searchAnItinirery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchItinery = new Intent(MainActivity.this, ItinerarySearchActivity.class);
                startActivity(searchItinery);
            }
        });
    }

}
