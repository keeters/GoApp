package s.hbogo.userinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import s.hbogo.R;
import s.hbogo.maintabs.Profile;

public class EditBio extends AppCompatActivity {

    EditText etBio;
    Button btnBioSave;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bio);

        etBio = (EditText) findViewById(R.id.etBio);
        btnBioSave = (Button) findViewById(R.id.btnBioSave);

        testtest

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        final FirebaseUser user = firebaseAuth.getCurrentUser();


        btnBioSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String stBio = etBio.getText().toString().trim();
                databaseReference.child(user.getUid()).child("bio").setValue(stBio);
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
        });
    }
}