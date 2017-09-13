package s.hbogo.maintabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import s.hbogo.R;
import s.hbogo.Vehicle.AddVehicle;

import static android.R.attr.data;
import static android.R.id.content;

public class Profile extends AppCompatActivity {
/*
This is where the profile will go
 */

    private TextView tvPhotoEdit;
    private TextView tvInfoEdit;
    private TextView tvAddVehicle;
    private ImageView ivProfPic;

    private BottomNavigationView bottomNavigationView;

    private StorageReference storageReference;

    private static final int GALLERY_INTENT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBottomBar);

        tvPhotoEdit = (TextView) findViewById(R.id.tvPhotoEdit);
        tvInfoEdit = (TextView) findViewById(R.id.tvInfoEdit);
        tvAddVehicle = (TextView) findViewById(R.id.tvAddVehicle);
        ivProfPic = (ImageView) findViewById(R.id.ivProfPic);

        storageReference = FirebaseStorage.getInstance().getReference();

        tvPhotoEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, GALLERY_INTENT);
            }
        });

        tvAddVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddVehicle.class));
            }
        });

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tabMyRides:
                        Intent intent1 = new Intent(Profile.this, MyRides.class);
                        startActivity(intent1);
                        break;

                    case R.id.tabMessage:
                        Intent intent2 = new Intent(Profile.this, Messages.class);
                        startActivity(intent2);

                        break;
                    case R.id.tabSearch:
                        Intent intent3 = new Intent(Profile.this, Search.class);
                        startActivity(intent3);
                        break;

                    case R.id.tabProfile:
                        break;
                }
                return false;
            }

        });

    }



    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent intent){
        //This doesn't work as it uploads to the database and not to a user profile

        super.onActivityResult(requestCode, resultCode, intent);

        if( requestCode == GALLERY_INTENT && resultCode == RESULT_OK){

            Uri uri = intent.getData();

            StorageReference filePath = storageReference.child("Photos").child(uri.getLastPathSegment());

            filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(Profile.this, "Photo Uploaded", Toast.LENGTH_LONG).show();

                }
            });


        }
    }

}
