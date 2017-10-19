package toca.com.pep.toca;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                selectedFragment = Home.newInstance();
                                break;
                            case R.id.navigation_np:
                                selectedFragment = NowPlaying.newInstance();
                                break;
                            case R.id.navigation_lm:
                                selectedFragment = LocalMusic.newInstance();
                                break;
                            case R.id.navigation_st:
                                selectedFragment = Store.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, Home.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }

    public void songClick(View v) {
        switch (v.getId()) {
            case R.id.lm_1:
                Log.i("MainActivity:", "lm_1 clicked");
                lmTransaction(v);
                break;
            case R.id.lm_2:
                Log.i("MainActivity:", "lm_2 clicked");
                lmTransaction(v);
                break;
            case R.id.lm_3:
                Log.i("MainActivity:", "lm_3 clicked");
                lmTransaction(v);
                break;
            case R.id.st_1:
                Log.i("MainActivity:", "st_1 clicked");
                stTransaction(v);
                break;
            case R.id.st_2:
                Log.i("MainActivity:", "st_2 clicked");
                stTransaction(v);
                break;
            case R.id.st_3:
                Log.i("MainActivity:", "st_3 clicked");
                stTransaction(v);
                break;
        }
    }


    public void lmTransaction(View v) {
        // TODO: try to not create a new instance for each fragment call
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, LocalMusic.newInstance());
        transaction.commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_lm);
    }

    public void stTransaction(View v) {
        // TODO: try to not create a new instance for each fragment call
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, Store.newInstance());
        transaction.commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_st);
    }

    public void npTransaction(View v) {
        // TODO: try to not create a new instance for each fragment call
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, NowPlaying.newInstance());
        transaction.commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_np);
    }
}
