package s.hbogo.maintabs;

import android.content.Intent;
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


import s.hbogo.R;

public class Search extends AppCompatActivity {

/*
This is where the search function will go
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBottomBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tabMyRides:
                        Intent intent1 = new Intent(Search.this, MyRides.class);
                        startActivity(intent1);
                        break;

                    case R.id.tabMessage:
                        Intent intent2 = new Intent(Search.this, Messages.class);
                        startActivity(intent2);

                        break;
                    case R.id.tabSearch:
                        break;

                    case R.id.tabProfile:
                        Intent intent4 = new Intent(Search.this, Profile.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }

        });

    }

}
