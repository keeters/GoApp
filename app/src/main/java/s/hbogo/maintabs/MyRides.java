package s.hbogo.maintabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import s.hbogo.R;

public class MyRides extends AppCompatActivity {
    /*
    This is where Rides will go (also hopefully the startscreen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rides);
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBottomBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tabMyRides:
                        break;

                    case R.id.tabMessage:
                        Intent intent2 = new Intent(MyRides.this, Messages.class);
                        startActivity(intent2);

                        break;
                    case R.id.tabSearch:
                        Intent intent3 = new Intent(MyRides.this, Search.class);
                        startActivity(intent3);
                        break;

                    case R.id.tabProfile:
                        Intent intent4 = new Intent(MyRides.this, Profile.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }

        });
        
    }

}

