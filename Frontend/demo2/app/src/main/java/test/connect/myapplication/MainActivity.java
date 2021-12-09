package test.connect.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import test.connect.myapplication.model.User;

/**
 * @author Lucas Ericson
 * MainActivity class creates navigation bar and stores saved instances.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * When MainActivity is initialized onCreate makes {@link BottomNavigationView}
     * bottomNav for storing different {@link Fragment} sub-class activities.
     * @param savedInstances is a {@link Bundle} that stores saved instances.
     */
    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navbar);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstances == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new activity_home()).commit();
        }
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                /**
                 * Method for changing currently selected {@link Fragment}
                 * when selected in the navbar
                 * @param item a {@link MenuItem} that stores a fragment id
                 * @return
                 */
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    //Get User from extras
                    User user;
                    Bundle extras = getIntent().getExtras();
                    if (extras == null) {
                        user = new User();
                    } else {
                        user = (User) extras.getParcelable("userInfo");
                        Log.d("USER", "MainActivity Received Account: " + user.getUsername() + user.printable());
                    }

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new activity_home();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new activity_search();
                            break;
                        case R.id.nav_sell:
                            selectedFragment = new activity_sell();
                            break;
                        case R.id.nav_orders:
                            selectedFragment = activity_orders.newInstance(user);
                            break;
                        case R.id.nav_account:
                            selectedFragment = activity_account.newInstance(user);
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}