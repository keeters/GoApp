package s.hbogo.maintabs;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import s.hbogo.R;
import s.hbogo.maintabs.myridesfragments.DriverFragment;
import s.hbogo.maintabs.myridesfragments.RiderFragment;

public class MyRides extends AppCompatActivity {
    /*
    This is where Rides will go.  Probably be best to use 2 view fragments, one for riders and one for drivers
    Fragments need to be changed so we cna have a recycler view in the fragments
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rides);

        showFragment(RiderFragment.TAG);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {

                 FragmentManager fm;
                 Log.v("Tag", "Showedd frag1");

                 switch (tab.getPosition()) {
                     case 0:
                         Log.v("Tag", "Showedd frag2");
                         showFragment(RiderFragment.TAG);
                         break;

                     case 1:
                         showFragment(DriverFragment.TAG);
                         break;

                 }
             }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//Think we can leave these blank
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//Think we can leave these blank
            }
        });

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

    public void showFragment(String TAG) {
        Log.v("Tag", "Showedd frag");
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG);
        if (fragment == null) {
            if (TAG.equals(RiderFragment.TAG)) {
                Log.v("Tag", "Showed Rider");
                fragment = new RiderFragment();
            } else if (TAG.equals(DriverFragment.TAG)) {
                Log.v("Tag", "Showed Driver");

                fragment = new DriverFragment();
            }
        }
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.flRideView,fragment,TAG);
        ft.commit();
    }

}

