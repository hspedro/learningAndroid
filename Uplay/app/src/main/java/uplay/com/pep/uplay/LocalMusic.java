package uplay.com.pep.uplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LocalMusic extends MainActivity {
    LinearLayout dynamicContent, bottomNavBar;

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
        setContentView(R.layout.activity_local_music);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.VIEW_LM);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.message_lm);
        textView.setText(message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
