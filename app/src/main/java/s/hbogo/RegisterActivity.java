package s.hbogo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import s.hbogo.userinformation.UserInformation;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    Needs: get Toasts for making it block people who don't input all the information
    Assurances that stop if email already exists

     */

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;

    private Button btnRegister;

    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordConf;

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        progressDialog = new ProgressDialog(this);


        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConf = (EditText) findViewById(R.id.etPasswordConf);

        btnRegister = (Button) findViewById(R.id.btnRegister);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etPhone = (EditText) findViewById(R.id.etPhone);

        btnRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == btnRegister) {
            registerUser();

        }
    }


    private void addUserInformation() {
        //Note, may cause error if user suceeds in registering email and password but fails to register other data

        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String phoneNumber = etPhone.getText().toString().trim();

        UserInformation userInformation = new UserInformation(firstName, lastName, phoneNumber);
        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInformation);
    }


    private void registerUser() {
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();

        progressDialog.setMessage("Registering user....");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(RegisterActivity.this, "Registration sucessful",
                                    Toast.LENGTH_SHORT).show();
                            progressDialog.hide();

                            loginUser(email, password);
                            addUserInformation();

                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                        } else {
                            Toast.makeText(RegisterActivity.this, "Registration failed",
                                    Toast.LENGTH_SHORT).show();
                            progressDialog.hide();

                            return;
                        }
                    }
                });
    }

    public void loginUser(String email, String password) {
        progressDialog.setMessage("Adding user information");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Information failed to add",
                                    Toast.LENGTH_SHORT);
                        }
                    }
                });
    }

}