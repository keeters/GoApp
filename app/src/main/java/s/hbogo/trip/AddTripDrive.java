package s.hbogo.trip;

import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import s.hbogo.R;
import s.hbogo.maintabs.MyRides;
import s.hbogo.maintabs.Profile;
import s.hbogo.vehicle.Vehicle;

public class AddTripDrive extends AppCompatActivity {


    //These need a map fragment probably that pops up and lets them choose a location


    private Button btnAddStart;
    private Button btnAddDestination;
    private DatePicker dpRideDate;
    private CheckBox cbAccountVehicle;
    private Button btnChangeVehicle;
    private NumberPicker npSeats;
    private Button btnAddDrive;
    private Button btnCancel;
    private EditText etTripDescription;

    ProgressDialog progressDialog;

    private Trip trip;
    private Location start;
    private Location destination;
    private Vehicle vehicle;

    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private String userId;

    private String[] MAXPASSENGERS = setMAXPASSENGERS();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip_drive);
        trip = new Trip();
        setVariables();
        setOnClicks();

    }

    private String[] setMAXPASSENGERS(){
        String[] maxPassengers = new String[15];
        for(Integer i = 0; i<15; i++){
            maxPassengers[i] = i.toString();
        }

        return maxPassengers;
    }

    private void setVariables() {
        btnAddStart = (Button) findViewById(R.id.btnAddStart);
        btnAddDestination = (Button) findViewById(R.id.btnAddDestination);
        btnChangeVehicle = (Button) findViewById(R.id.btnChangeVehicle);
        btnAddDrive = (Button) findViewById(R.id.btnAddDrive);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        etTripDescription = (EditText) findViewById(R.id.etTripDescription);

        dpRideDate = (DatePicker) findViewById(R.id.dpRideDate);

        cbAccountVehicle = (CheckBox) findViewById(R.id.cbAccountVehicle);

        npSeats = (NumberPicker) findViewById(R.id.npSeats);
        npSeats.setDisplayedValues(MAXPASSENGERS);

        progressDialog = new ProgressDialog(this);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Trips");
        firebaseAuth = FirebaseAuth.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();
    }


    private void setOnClicks() {
        btnAddStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start = ....
                //Map fragment and maybe use an Event Bus to get it back into this
            }
        });

        btnAddDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //destinantion = ...
                //Map fragment and maybe use an Event Bus to get it back into this
            }
        });

        btnChangeVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vehicle = ...
                //Make a vehicle thingy that goes here
            }
        });

        btnAddDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTrip();
                addTripDatabase();
            }


        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MyRides.class));
            }
        });

    }

    private void addTripDatabase() {
        progressDialog.setMessage("Adding Ride");
        progressDialog.show();
        DatabaseReference nDatabase = mDatabase.push();
        nDatabase.setValue(trip);
        progressDialog.hide();
        startActivity(new Intent(getApplicationContext(), MyRides.class));


    }

    private void makeTrip() {
        //trip.setStart();
        //trip.setDestination();
        trip.setDay(dpRideDate.getDayOfMonth());
        trip.setMonth(dpRideDate.getMonth());
        trip.setYear(dpRideDate.getYear());
        trip.setRideTypeDrive();
        trip.setDescription(etTripDescription.getText().toString().trim());
        vehicleSelect();
        trip.setSeats(npSeats.getValue());
        trip.setPoster(userId);
        trip.setVehicle(vehicle);

    }

    private void vehicleSelect() {
        if (cbAccountVehicle.isChecked()) {
            //vehicle = account vehicle
        } else {
            //vehicle is = event bus vehicle
        }

    }
}