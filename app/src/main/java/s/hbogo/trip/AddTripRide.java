package s.hbogo.trip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import s.hbogo.R;

public class AddTripRide extends AppCompatActivity {

    private Short RIDERIDETYPE;

    //These need a map fragment probably that pops up and lets them choose a location
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip_ride);

    }
}
