package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

public class ItinerarySearchActivity extends AppCompatActivity {
    private static final String TAG = "ItinerarySearchActivity";
    private TextView mDate;
    private DatePickerDialog.OnDateSetListener mDateSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        mDate = (TextView)findViewById(R.id.date);
        mDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ItinerarySearchActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSet,
                        year,month,day);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new
                        ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });
        mDateSet = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet : mm/dd/yyy :" + month +"/" + day + "/" + year
                + "/");
                String date = month + "/" + day + "/"+ year+"/";
                mDate.setText(date);

            }
        };








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




