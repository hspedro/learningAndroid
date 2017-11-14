package com.pep.uplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LocalMusic extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.pep.android.PLAY_SONG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_music);

        // Adjust as the music selected from Home

        Log.i("LocalMusic:", "onCreateView() called");

        try {
            // Set image
            Intent intent = getIntent();
            String res = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
                    .replace("id", "drawable");

            String text = res.replace("drawable", "string");
            String idRes = res.split("/")[1];
            String resDrawable;
            switch(idRes) {
                case "lm_1":
                    resDrawable = res.replace("lm_1","metallica");
                    text = text.replace("lm_1", "text_metallica");
                    break;
                case "lm_2":
                    resDrawable = res.replace("lm_2","paramore");
                    text = text.replace("lm_2", "text_paramore");
                    break;
                case "lm_3":
                    resDrawable = res.replace("lm_3","jcole");
                    text = text.replace("lm_3", "text_jcole");
                    break;
                default:
                    resDrawable = res;
                    break;
            }

            // Set image resource
            ImageView iView = findViewById(R.id.lm_star);
            Log.i("LocalMusic:", "resDrawable = " + resDrawable);
            int id = getResources().getIdentifier(resDrawable, null, null);
            iView.setImageResource(id);

            // Set text resource
            TextView tView = findViewById(R.id.text_lm);
            Log.i("LocalMusic:", "text = " + text);
            id = getResources().getIdentifier(text, null, null);
            tView.setText(id);
        } catch (Exception e) {
            if (getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE) == null) {
                Log.i("LocalMusic:", "bundle is null again...");
            } else {
                Log.i("LocalMusic:", "we better run bro");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_np) {
            Intent intent = new Intent(this, NowPlaying.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_st) {
            Intent intent = new Intent(this, Store.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void nowPlayingSong(View v) {
        Intent intent = new Intent(this, NowPlaying.class);
        String vname = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        intent.putExtra(EXTRA_MESSAGE, vname);
        startActivity(intent);
    }
}
