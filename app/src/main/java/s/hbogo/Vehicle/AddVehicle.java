package s.hbogo.Vehicle;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import s.hbogo.R;
import s.hbogo.RegisterActivity;
import s.hbogo.maintabs.Profile;
import s.hbogo.userinformation.UserInformation;

public class AddVehicle extends AppCompatActivity {

    /*
    This tab adds a car to the user's profile, currently users may only have 1 car in the profile but
    we could fix this (if needed) with an ArrayList later probably
     */
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    private Vehicle vehicle;

    private Button btnAddVehicle;
    private EditText etCarMake;
    private EditText etCarModel;
    private EditText etCarYear;
    private EditText etCarColor;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        btnAddVehicle = (Button) findViewById(R.id.btnAddVehicle);

        etCarMake = (EditText) findViewById(R.id.etCarMake);
        etCarModel = (EditText) findViewById(R.id.etCarModel);
        etCarYear = (EditText) findViewById(R.id.etCarYear);
        etCarColor = (EditText) findViewById(R.id.etCarColor);

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(this);

        btnAddVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addVehicle();
            }
        });
    }


    private void addVehicle() {

        FirebaseUser user = firebaseAuth.getCurrentUser();


        String stCarMake  = etCarMake.getText().toString().trim();
        String stCarModel  = etCarModel.getText().toString().trim();
        String stCarYear  = etCarYear.getText().toString().trim();
        String stCarColor  = etCarColor.getText().toString().trim();


        if (!stCarMake.isEmpty() && !stCarModel.isEmpty() && !stCarYear.isEmpty() && !stCarColor.isEmpty()){
            vehicle = new Vehicle(stCarMake, stCarYear, stCarModel, stCarColor);
            Toast.makeText(this, "Vehicle added", Toast.LENGTH_SHORT).show();
            databaseReference.child(user.getUid()).child("vehicle").setValue(vehicle);
            startActivity(new Intent(this, Profile.class));
        }

        else {
            Toast.makeText(this, "Please fill all areas", Toast.LENGTH_SHORT).show();
        }
    }
}
