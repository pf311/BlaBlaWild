package fr.wcs.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView firstName = (TextView) convertView.findViewById(R.id.fName);
        TextView lastName = (TextView) convertView.findViewById(R.id.lName);
        TextView tDate = (TextView) convertView.findViewById(R.id.date);
        TextView tPrice = (TextView) convertView.findViewById(R.id.price);
        firstName.setText(trip.getFirstName());
        lastName.setText(trip.getLastName());
        tPrice.setText(String.valueOf(trip.getPrice()));
        tDate.setText(dateFormat.format(trip.getDate()));

        // Return the completed view to render on screen
        return convertView;
    }
}

