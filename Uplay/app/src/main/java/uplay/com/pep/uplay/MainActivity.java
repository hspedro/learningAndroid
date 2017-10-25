package uplay.com.pep.uplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String VIEW_NP = "uplay.com.pep.uplay.VIEW_NP";
    public static final String VIEW_LM = "uplay.com.pep.uplay.VIEW_LM";
    public static final String VIEW_ST = "uplay.com.pep.uplay.VIEW_ST";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // TODO: intent to home activity
                    return true;
                case R.id.navigation_np:
                    // TODO: intent to now playing activity
                    return true;
                case R.id.navigation_lm:
                    // TODO: intent to local music activity
                    return true;
                case R.id.navigation_st:
                    // TODO: intent to store activity
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

    public void npTransaction(View v) {
        // TODO: intent to now playing activity
        Intent intent = new Intent(this, LocalMusic.class);
        String message = v.getResources().getResourceName(v.getId());
        intent.putExtra(VIEW_NP, message);
        startActivity(intent);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_np);
    }

    public void lmTransaction(View v) {
        // TODO: intent to local music activity
        Intent intent = new Intent(this, LocalMusic.class);
        String message = v.getResources().getResourceName(v.getId());
        intent.putExtra(VIEW_LM, message);
        startActivity(intent);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_lm);
    }

    public void stTransaction(View v) {
        // TODO: intent to store activity
        Intent intent = new Intent(this, LocalMusic.class);
        String message = v.getResources().getResourceName(v.getId());
        intent.putExtra(VIEW_ST, message);
        startActivity(intent);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_st);
    }
}
