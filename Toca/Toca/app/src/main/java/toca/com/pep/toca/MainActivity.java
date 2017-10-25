package toca.com.pep.toca;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean clickTransaction = false;

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
                                if(!clickTransaction) {
                                    selectedFragment = LocalMusic.newInstance();
                                }
                                break;
                            case R.id.navigation_st:
                                selectedFragment = Store.newInstance();
                                break;
                        }

                        if(!clickTransaction) {
                            Log.i("MainActivity:", "fragment transaction onCreate");
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.content, selectedFragment);
                            transaction.commit();
                        }
                        clickTransaction = false;
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, Home.newInstance());
        transaction.commit();

    }

    public void songClick(View v) {
        switch (v.getId()) {
            case R.id.lm_1:
                lmTransaction(v);
                break;
            case R.id.lm_2:
                lmTransaction(v);
                break;
            case R.id.lm_3:
                lmTransaction(v);
                break;
            case R.id.st_1:
                stTransaction(v);
                break;
            case R.id.st_2:
                stTransaction(v);
                break;
            case R.id.st_3:
                stTransaction(v);
                break;
        }
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

    public void lmTransaction(View v) {
        // TODO: try to not create a new instance for each fragment call
        // TODO: pass resource ID
        clickTransaction = true;

        LocalMusic f = new LocalMusic();
        Bundle b = new Bundle();

        if (v != null) {
            b.putString("resource", v.getResources().getResourceName(v.getId()));
            f.setArguments(b);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, f);
        transaction.commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_lm);
    }

    public void stTransaction(View v) {
        // TODO: try to not create a new instance for each fragment call
        clickTransaction = true;

        Store f = new Store();
        Bundle b = new Bundle();

        if (v != null) {
            b.putString("resource", v.getResources().getResourceName(v.getId()));
            f.setArguments(b);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, f);
        transaction.commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_st);
    }
}
