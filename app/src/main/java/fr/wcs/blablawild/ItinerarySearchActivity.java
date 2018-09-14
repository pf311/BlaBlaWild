package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        Button buttonSearch = findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textD = findViewById(R.id.dep);
                EditText textDe =findViewById(R.id.des);
                EditText textDa= findViewById(R.id.date);
                String departureV = textD.getText().toString();
                String destinationV = textDe.getText().toString();
                String dateV = textDa.getText().toString();

                if(departureV.isEmpty() || destinationV.isEmpty()){
                    Toast.makeText(ItinerarySearchActivity.this, R.string.toasttext, Toast.LENGTH_LONG).show();

                }else{
                    Intent itinirary = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    itinirary.putExtra("Depart",textD.getText().toString());
                    itinirary.putExtra("Destination",textDe.getText().toString());
                    startActivity(itinirary);
                }


            }
        });
    }
}
