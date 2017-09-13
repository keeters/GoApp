package s.hbogo.Trip;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import s.hbogo.R;

public class AddTrip extends AppCompatActivity {

    final public short RIDE = 0;
    final public short DRIVE = 1; //So with these, as soon as a user selects the rides fragment
    // or the drive fragement, we should change Trip.rideType to the apropriate short

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
    }
}